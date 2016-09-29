package net.sectorbob.football.rest;

import net.sectorbob.football.client.RotoGrindersClient;
import net.sectorbob.football.model.RotoGrindersVegasOddsRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Kyle Heide
 */
@RestController
@RequestMapping(value = "/vegas")
public class VegasLinesController {

    @Autowired
    RotoGrindersClient rotoGrindersClient;

    @RequestMapping
    public List<RotoGrindersVegasOddsRecord> getVegasLines() {
        return rotoGrindersClient.getVegasLines();
    }
}
