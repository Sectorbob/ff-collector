package net.sectorbob.football.rest;

import net.sectorbob.football.client.YahooDailyFantasyFootballClient;
import net.sectorbob.football.model.YahooDailyPlayersFeedNFL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by ltm688 on 9/17/16.
 */
@RestController
@RequestMapping(value = "/daily")
public class DailyController {

    @Autowired
    YahooDailyFantasyFootballClient yahooDailyFantasyFootballClient;

    @RequestMapping(value = "/yahoo", method = GET)
    public YahooDailyPlayersFeedNFL getYahooDailyPlayers() {
        return yahooDailyFantasyFootballClient.getLatestYahooDailyNFLPlayers();
    }
}
