package net.sectorbob.football.client;

import net.sectorbob.football.model.YahooDailyPlayersFeedNFL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Kyle Heide
 */
@Component
public class YahooDailyFantasyFootballClient {

    private String playersUrl = "https://dfyql-ro.sports.yahoo.com/v2/external/playersFeed/nfl";


    @Autowired
    private RestTemplate yahooDailyFantasyRestTemplate;


    public YahooDailyPlayersFeedNFL getLatestYahooDailyNFLPlayers() {
        ResponseEntity<YahooDailyPlayersFeedNFL> response =
                yahooDailyFantasyRestTemplate.getForEntity(playersUrl, YahooDailyPlayersFeedNFL.class);

        return response.getBody();
    }
}
