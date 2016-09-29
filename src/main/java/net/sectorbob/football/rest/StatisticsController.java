package net.sectorbob.football.rest;

import net.sectorbob.football.client.ProFootballReferenceClient;
import net.sectorbob.football.model.PFRPassingRecord;
import net.sectorbob.football.model.PFRReceivingRecord;
import net.sectorbob.football.model.PFRRushingAndReceivingRecord;
import net.sectorbob.football.model.PFRTeamDefenseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Kyle Heide
 */
@RestController
@RequestMapping("/stats")
public class StatisticsController {

    @Autowired
    ProFootballReferenceClient proFootballReferenceClient;

    @RequestMapping(value = "/passing/{year}", method = GET)
    public List<PFRPassingRecord> getPassingStats(@PathVariable Integer year) {
        return proFootballReferenceClient.getPassingData(year);
    }

    @RequestMapping(value = "/receiving/{year}", method = GET)
    public List<PFRReceivingRecord> getReceivingStats(@PathVariable Integer year) {
        return proFootballReferenceClient.getReceivingData(year);
    }

    @RequestMapping(value = "/rushing_and_receiving/{year}", method = GET)
    public List<PFRRushingAndReceivingRecord> getRushingAndReceivingStats(@PathVariable Integer year) {
        return proFootballReferenceClient.getRushingAndReceivingData(year);
    }

    @RequestMapping(value = "/team_defense/{year}", method = GET)
    public List<PFRTeamDefenseRecord> getTeamDefenseStats(@PathVariable Integer year) {
        return proFootballReferenceClient.getTeamDefenseData(year);
    }
}
