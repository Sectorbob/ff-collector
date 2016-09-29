package net.sectorbob.football.client;

import javafx.geometry.Pos;
import net.sectorbob.football.exception.ResourceNotFoundException;
import net.sectorbob.football.model.*;
import net.sectorbob.football.support.Row;
import net.sectorbob.football.support.Table;
import net.sectorbob.football.support.Util;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ltm688 on 9/17/16.
 */
@Component
public class ProFootballReferenceClient {

    private static String baseUrl = "http://www.pro-football-reference.com/years/";

    @Autowired
    private RestTemplate proFootballReferenceRestTemplate;


    public static String[] passingCols = {"Rk", "", "Tm", "Age", "Pos", "G", "GS", "QBrec", "Cmp", "Att", "Cmp%",
            "Yds", "TD", "TD%", "Int", "Int%", "Lng", "Y/A", "AY/A", "Y/C", "Y/G",
            "Rate", "QBR", "Sk", "Yds", "NY/A", "ANY/A", "Sk%", "4QC", "GWD"};

    public static String[] receivingCols = {"Rk", "", "Tm", "Age", "Pos", "G", "GS", "Tgt", "Rec",
            "Ctch%", "Yds", "Y/R", "TD", "Lng", "R/G", "Y/G", "Fmb"};

    public static String[] rushingCols = {"Rk", "", "Tm", "Age", "Pos", "G", "GS", "Att", "Yds", "TD", "Lng", "Y/A",
            "Y/G", "A/G","Tgt", "Rec", "Yds2", "Y/R", "TD2", "Lng2", "R/G", "Y/G2", "Ctch%",
            "YScm", "RRTD", "Fmb"};

    public static String[] defenseCols = {"Rk", "", "Tm", "Age", "Pos", "G", "GS", "Int", "Yds", "TD", "Lng", "PD",
            "FF", "Fmb", "FR", "Yds2", "TD2", "Sk", "Tkl", "Ast", "Sfty"};

    public static String[] teamDefenseCols = {"Rk", "Tm", "G", "PF", "Yds", "Ply", "Y/P", "TO", "FL", "1stD", "Cmp",
            "Att", "Yds", "TD", "Int", "NY/A", "1stD", "Att", "Yds", "TD", "Y/A", "1stD", "Pen", "Yds", "1stPy", "Sc%", "TO%", "EXP"};




    public List<PFRPassingRecord> getPassingData(int year) {
        Table data = getData(year, "passing");

        List<PFRPassingRecord> passingRecords = new ArrayList<>();

        for(Row row : data) {
            PFRPassingRecord passingRecord = new PFRPassingRecord();
            passingRecord.setRank(tryParseInt(row.get("Rk").getData()));
            passingRecord.setPlayer(row.get("").getData().replace("*", "").replace("+", "").trim());
            passingRecord.setTeam(Team.fromString(row.get("Tm").getData()));
            passingRecord.setAge(tryParseInt(row.get("Age").getData()));
            passingRecord.setPosition(Position.fromString(row.get("Pos").getData()));
            passingRecord.setGames(tryParseInt(row.get("G").getData()));
            passingRecord.setGamesStarted(tryParseInt(row.get("GS").getData()));
            passingRecord.setQbRecord(row.get("QBrec").getData());
            passingRecord.setCompletions(tryParseInt(row.get("Cmp").getData()));
            passingRecord.setAttempts(tryParseInt(row.get("Att").getData()));
            passingRecord.setCompletionPercentage(tryParseDouble(row.get("Cmp%").getData()));
            passingRecord.setYards(tryParseInt(row.get("Yds").getData()));
            passingRecord.setTouchdowns(tryParseInt(row.get("TD").getData()));
            passingRecord.setTouchdownPercentage(tryParseDouble(row.get("TD%").getData()));
            passingRecord.setInterceptions(tryParseInt(row.get("Int").getData()));
            passingRecord.setInterceptionPercentage(tryParseDouble(row.get("Int%").getData()));
            passingRecord.setLongestPass(tryParseInt(row.get("Lng").getData()));
            passingRecord.setYardsPerAttempt(tryParseDouble(row.get("Y/A").getData()));
            passingRecord.setAdjustedYardsPerAttempt(tryParseDouble(row.get("AY/A").getData()));
            passingRecord.setYardsPerCompletion(tryParseDouble(row.get("Y/C").getData()));
            passingRecord.setYardsPerGame(tryParseDouble(row.get("Y/G").getData()));
            passingRecord.setNflQuarterbackRating(tryParseDouble(row.get("Rate").getData()));
            passingRecord.setEspnQuarterbackRating(tryParseDouble(row.get("QBR").getData()));
            passingRecord.setTimesSacked(tryParseInt(row.get("Sk").getData()));
            passingRecord.setYardsLossFromSacks(tryParseInt(row.get("Yds2").getData()));
            passingRecord.setNetYardsGainedPerPassAttempt(tryParseDouble(row.get("NY/A").getData()));
            passingRecord.setAdjustedNetYardsGainedPerPassAttempt(tryParseDouble(row.get("ANY/A").getData()));
            passingRecord.setSackedDuringPassAttemptPercentage(tryParseDouble(row.get("Sk%").getData()));
            passingRecord.setFourthQuarterComebacks(tryParseInt(row.get("4QC").getData()));
            passingRecord.setGameWinningDrives(tryParseInt(row.get("GWD").getData()));
            passingRecords.add(passingRecord);
        }
        return passingRecords;
    }

    public List<PFRReceivingRecord> getReceivingData(int year) {
        Table data = getData(year, "receiving");

        List<PFRReceivingRecord> receivingRecords = new ArrayList<>();
        for(Row row : data) {
            PFRReceivingRecord receivingRecord = new PFRReceivingRecord();

            receivingRecord.setRank(tryParseInt(row.get("Rk").getData()));
            receivingRecord.setPlayer(row.get("").getData().replace("*", "").replace("+", "").trim());
            receivingRecord.setTeam(Team.fromString(row.get("Tm").getData()));
            receivingRecord.setAge(tryParseInt(row.get("Age").getData()));
            receivingRecord.setPosition(Position.fromString(row.get("Pos").getData()));
            receivingRecord.setGames(tryParseInt(row.get("G").getData()));
            receivingRecord.setGamesStarted(tryParseInt(row.get("GS").getData()));
            receivingRecord.setTargets(tryParseInt(row.get("Tgt").getData()));
            receivingRecord.setReceptions(tryParseInt(row.get("Rec").getData()));
            String tmp = row.get("Ctch%").getData().replace("%", "");
            receivingRecord.setCatchPercentage(tryParseDouble(tmp));
            receivingRecord.setYards(tryParseInt(row.get("Yds").getData()));
            receivingRecord.setYardsPerReception(tryParseDouble(row.get("Y/R").getData()));
            receivingRecord.setTouchdowns(tryParseInt(row.get("TD").getData()));
            receivingRecord.setLongestReception(tryParseInt(row.get("Lng").getData()));
            receivingRecord.setReceptionsPerGame(tryParseDouble(row.get("R/G").getData()));
            receivingRecord.setYardsPerGame(tryParseDouble(row.get("Y/G").getData()));
            receivingRecord.setTotalFumbles(tryParseInt(row.get("Fmb").getData()));

            //        "Ctch%", "Yds", "Y/R", "TD", "Lng", "R/G", "Y/G", "Fmb"


            receivingRecords.add(receivingRecord);
        }

        return receivingRecords;
    }

    public List<PFRRushingAndReceivingRecord> getRushingAndReceivingData(int year) {
        Table data = getData(year, "rushing");

        List<PFRRushingAndReceivingRecord> rushingAndReceivingRecords = new ArrayList<>();

        for(Row row : data) {
            PFRRushingAndReceivingRecord rrr = new PFRRushingAndReceivingRecord();

            rrr.setRank(tryParseInt(row.get("Rk").getData()));
            rrr.setPlayer(row.get("").getData().replace("*", "").replace("+", "").trim());
            rrr.setTeam(Team.fromString(row.get("Tm").getData()));
            rrr.setAge(tryParseInt(row.get("Age").getData()));
            rrr.setPosition(Position.fromString(row.get("Pos").getData()));
            rrr.setGames(tryParseInt(row.get("G").getData()));
            rrr.setGamesStarted(tryParseInt(row.get("GS").getData()));

            // Rushing Data
            rrr.setRushingAttempts(tryParseInt(row.get("Att").getData()));
            rrr.setRushingYards(tryParseInt(row.get("Yds").getData()));
            rrr.setRushingTouchdowns(tryParseInt(row.get("TD").getData()));
            rrr.setLongestRush(tryParseInt(row.get("Lng").getData()));
            rrr.setYardsPerRushingAttempt(tryParseDouble(row.get("Y/A").getData()));
            rrr.setRushingYardsPerGame(tryParseDouble(row.get("Y/G").getData()));
            rrr.setRushingAttemptsPerGame(tryParseDouble(row.get("A/G").getData()));

            // Receiving Data
            rrr.setTargets(tryParseInt(row.get("Tgt").getData()));
            rrr.setReceptions(tryParseInt(row.get("Rec").getData()));
            rrr.setReceivingYards(tryParseInt(row.get("Yds2").getData()));
            rrr.setYardsPerReception(tryParseDouble(row.get("Y/R").getData()));
            rrr.setReceivingTouchdowns(tryParseInt(row.get("TD2").getData()));
            rrr.setLongestReception(tryParseInt(row.get("Lng2").getData()));
            rrr.setReceptionsPerGame(tryParseDouble(row.get("R/G").getData()));
            rrr.setReceivingYardsPerGame(tryParseDouble(row.get("Y/G2").getData()));
            String tmp = row.get("Ctch%").getData().replace("%", "");
            rrr.setCatchPercentage(tryParseDouble(tmp));

            // Overall
            rrr.setYardsFromScrimmage(tryParseInt(row.get("YScm").getData()));
            rrr.setReceivingAndRushingTouchdowns(tryParseInt(row.get("RRTD").getData()));
            rrr.setTotalFumbles(tryParseInt(row.get("Fmb").getData()));

            rushingAndReceivingRecords.add(rrr);
        }

        return rushingAndReceivingRecords;
    }

    public List<PFRTeamDefenseRecord> getTeamDefenseData(int year) {
        Table data = getData(year, "opp");

        List<PFRTeamDefenseRecord> teamDefenseRecords = new ArrayList<>();

        for(Row row : data) {
            PFRTeamDefenseRecord tdr = new PFRTeamDefenseRecord();

            tdr.setRank(tryParseInt(row.get("Rk").getData()));
            tdr.setTeam(Team.fromString(row.get("Tm").getData()));
            tdr.setPosition(Position.DEF);
            tdr.setGames(tryParseInt(row.get("G").getData()));
            tdr.setPointsFor(tryParseInt(row.get("PF").getData()));
            tdr.setYards(tryParseInt(row.get("Yds").getData()));
            tdr.setOffensivePlays(tryParseInt(row.get("Ply").getData()));
            tdr.setYardsPerOffensivePlay(tryParseDouble(row.get("Y/P").getData()));
            tdr.setTakeAways(tryParseInt(row.get("TO").getData()));
            tdr.setFumblesLostByTeam(tryParseInt(row.get("FL").getData()));
            tdr.setFirstDowns(tryParseInt(row.get("1stD").getData()));
            tdr.setPassingCompletions(tryParseInt(row.get("Cmp").getData()));
            tdr.setPassingAttempts(tryParseInt(row.get("Att").getData()));
            tdr.setPassingYards(tryParseInt(row.get("Yds2").getData()));
            tdr.setPassingTouchdowns(tryParseInt(row.get("TD").getData()));
            tdr.setInterceptions(tryParseInt(row.get("Int").getData()));
            tdr.setNetYardsPerPassingAttempt(tryParseDouble(row.get("NY/A").getData()));
            tdr.setFirstDownsByPassing(tryParseInt(row.get("1stD2").getData()));
            tdr.setRushingAttempts(tryParseInt(row.get("Att2").getData()));
            tdr.setRushingYards(tryParseInt(row.get("Yds3").getData()));
            tdr.setRushingTouchdowns(tryParseInt(row.get("TD2").getData()));
            tdr.setRushingYardsPerAttempt(tryParseDouble(row.get("Y/A").getData()));
            tdr.setFirstDownsByRushing(tryParseInt(row.get("1stD3").getData()));
            tdr.setPenalties(tryParseInt(row.get("Pen").getData()));
            tdr.setPenaltyYards(tryParseInt(row.get("Yds4").getData()));
            tdr.setFirstDownsByPenalty(tryParseInt(row.get("1stPy").getData()));
            tdr.setScoringDrivePercentage(tryParseDouble(row.get("Sc%").getData()));
            tdr.setTurnoverDrivePercentage(tryParseDouble(row.get("TO%").getData()));
            tdr.setExpectedPointsContributedByDefense(tryParseDouble(row.get("EXP").getData()));

            teamDefenseRecords.add(tdr);
        }
        return teamDefenseRecords;
    }
    // Utilities
    protected Table getData(int year, String position) {
        String url = baseUrl + year + "/" + position + ".htm";

        ResponseEntity<String> response;

        try {
            response = proFootballReferenceRestTemplate.getForEntity(url, String.class);
        } catch(RestClientException e) {
            e.printStackTrace();
            return null;
        }

        System.out.println("Status Code: " + response.getStatusCodeValue() + "  Content-Type: " + response.getHeaders().get("Content-Type"));

        String html = response.getBody();
        validateFor404NotFoundPage(html);

        int headerRowsToSkip = 0;
        if(position.equals("rushing")) {
            headerRowsToSkip = 1;
            position = "rushing_and_receiving";
        } else if(position.equals("defense")) {
            headerRowsToSkip = 1;
        } else if(position.equals("opp")) {
            headerRowsToSkip = 1;
            position = "team_stats";
        }

        Table table = Util.webTableToListMapWithJsoup(html, "#" + position, headerRowsToSkip, "data-row");
        List<Row> rowsToDelete = new ArrayList<>();

        for(Row row : table) {
            String data = row.get("Rk").getData();
            try {
                Integer.parseInt(data);
            } catch (NumberFormatException e) {
                rowsToDelete.add(row);
            }
        }

        for(Row rowToDelete : rowsToDelete) {
            table.remove(rowToDelete);
        }
        return table;
    }

    private void validateFor404NotFoundPage(String html) {
        String selector = "#content > h1";
        String expected404Text = "Page Not Found (404 error)";
        Document doc = Jsoup.parse(html);

        Element h1 = doc.select(selector).first();

        if(h1 != null) {
            throw new ResourceNotFoundException();
        }


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
