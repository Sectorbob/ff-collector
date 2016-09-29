package net.sectorbob.football.client;

import net.sectorbob.football.config.properties.FantasyProsProperties;
import net.sectorbob.football.model.FantasyProsRankings;
import net.sectorbob.football.model.Position;
import net.sectorbob.football.model.Team;
import net.sectorbob.football.rest.template.StatefulRestTemplate;
import org.apache.http.cookie.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * Created by ltm688 on 9/29/16.
 */
@Component
public class FantasyProsClient {

    private static Logger LOG = LoggerFactory.getLogger(FantasyProsClient.class);

    public static final String QB = "qb";
    public static final String RB = "rb";
    public static final String WR = "wr";
    public static final String TE = "te";
    public static final String FLEX = "flex";
    public static final String DST = "dst";

    private static final String baseUrl = "https://www.fantasypros.com";
    private static final String loginBaseUrl = "https://secure.fantasypros.com";

    private boolean authenticated = false;

    @Autowired
    private StatefulRestTemplate statefulRestTemplate;

    @Autowired
    private FantasyProsProperties fantasyProsProperties;

    protected void authenticate(String username, String password) {

        String csrfToken = getCsrfToken();
        String body = "csrfmiddlewaretoken=" + csrfToken +"&username=" + username + "&password=" + password + "&import_id=";
        String uri = loginBaseUrl + "/accounts/login/?next=http://www.fantasypros.com/nfl/rankings/dst.php?loggedin&loggedout";


        HttpHeaders headers = getHeaders("http://www.fantasypros.com/nfl/rankings/dst.php?loggedin&loggedout");
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> res = statefulRestTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

        authenticated = true;

        LOG.info("Return Code: " + res.getStatusCodeValue());
    }

    public FantasyProsRankings getRankings(String position) {
        if(!authenticated) {
            authenticate(fantasyProsProperties.getUsername(), fantasyProsProperties.getPassword());
        }

        String uri =  baseUrl + "/nfl/rankings/" + position + ".php";
        String refererUri = uri + "?loggedin";
        String excelDownloadUri = uri + "?export=xls";

        HttpEntity<String> httpEntity = new HttpEntity<>(null, getHeaders(refererUri));


        ResponseEntity<String> res = statefulRestTemplate.exchange(excelDownloadUri, HttpMethod.GET, httpEntity, String.class);

        String body = res.getBody();

        return parse(body);
    }

    private static HttpHeaders getHeaders(String refererUri) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:48.0) Gecko/20100101 Firefox/48.0");
        headers.add("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        headers.add("Accept-Language", "en-US,en;q=0.5");
        headers.add("Accept-Encoding", "gzip, deflate, br");
        headers.add("Referer", refererUri);
        headers.add("Connection", "keep-alive");
        headers.add("Upgrade-Insecure-Requests", "1");
        return headers;
    }

    private String getCsrfToken() {
        HttpEntity<String> entity = new HttpEntity<>(null, getHeaders("https://secure.fantasypros.com/accounts/login/?next=http://www.fantasypros.com/nfl/rankings/dst.php?loggedin&loggedout"));

        statefulRestTemplate.exchange(loginBaseUrl + "/accounts/login/", HttpMethod.GET, entity, String.class);

        return extractCsrfCookieValue();
    }

    private FantasyProsRankings parse(String excel) {
        FantasyProsRankings rankings = new FantasyProsRankings();

        String position = "";

        int rowNumber = 0;
        for(String row : excel.split("\n")) {
            row = row.trim();
            rowNumber++;

            if(rowNumber == 2) {
                String[] parts = row.split(" - ");
                rankings.setWeek(parts[0]);
                parts = parts[1].split(" ");
                position = parts[0];
            } else if(rowNumber > 5) {
                int numberOfColumns = row.split("\t").length;



                FantasyProsRankings.FantasyProRankingEntry entry = new FantasyProsRankings.FantasyProRankingEntry();
                if(numberOfColumns != 9) {
                    entry.setPosition(Position.fromString(position));
                }
                int cellNumber = 0;
                for (String cell : row.split("\t")) {
                    cell = cell.trim();
                    cellNumber++;
                    switch(cellNumber) {
                        case 1:
                            entry.setRank(tryParseInt(cell));
                            break;
                        case 2:
                            entry.setPlayerName(cell);
                            break;
                        case 3:
                            if(numberOfColumns == 9) {
                                String pos = cell.replaceAll("\\d","");
                                entry.setPosition(Position.fromString(pos));
                            } else {
                                entry.setTeam(Team.fromString(cell));
                            }

                            break;
                        case 4:
                            if(numberOfColumns == 9) {
                                entry.setTeam(Team.fromString(cell));
                            } else {
                                entry.setMatchup(cell);
                            }
                            break;
                        case 5:
                            if(numberOfColumns == 9) {
                                entry.setMatchup(cell);
                            } else {
                                entry.setBestRank(tryParseInt(cell));
                            }
                            break;
                        case 6:
                            if(numberOfColumns == 9) {
                                entry.setBestRank(tryParseInt(cell));
                            } else {
                                entry.setWorstRank(tryParseInt(cell));
                            }
                            break;
                        case 7:
                            if(numberOfColumns == 9) {
                                entry.setWorstRank(tryParseInt(cell));
                            } else {
                                entry.setAverageRank(tryParseDouble(cell));
                            }
                            break;
                        case 8:
                            if(numberOfColumns == 9) {
                                entry.setAverageRank(tryParseDouble(cell));
                            } else {
                                entry.setStandardDeviation(tryParseDouble(cell));
                            }
                            break;
                        case 9:
                            entry.setStandardDeviation(tryParseDouble(cell));
                            break;
                        default:
                            break;
                    }


                }
                rankings.getRankings().add(entry);
            }
        }
        return rankings;
    }

    private String extractCsrfCookieValue() {
        for(Cookie cookie :statefulRestTemplate.getCookieStore().getCookies()) {
            if(cookie.getName().equals("csrftoken")) {
                return cookie.getValue();
            }
        }
        return null;
    }

    protected static Double tryParseDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    protected static Integer tryParseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
