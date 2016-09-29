package net.sectorbob.football.rest;

import net.sectorbob.football.logic.WeekTiming;
import net.sectorbob.football.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.zip.DataFormatException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Kyle Heide
 */
@RestController
@RequestMapping(value = "/players")
public class CurrentPlayerJoinController {

    @Autowired
    DailyController dailyController;

    @Autowired
    StatisticsController statisticsController;

    @Autowired
    RankingsController rankingsController;

    @Autowired
    VegasLinesController vegasLinesController;

    @RequestMapping(value = "/current", method = GET)
    public List<CurrentPlayerRecord> getCurrentPlayers() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentWeek = WeekTiming.getCurrentWeek();


        List<PFRRushingAndReceivingRecord> rushingAndReceivingRecords = statisticsController.getRushingAndReceivingStats(currentYear);
        List<PFRPassingRecord> passingRecords = statisticsController.getPassingStats(currentYear);
        List<PFRTeamDefenseRecord> teamDefenseRecords = statisticsController.getTeamDefenseStats(currentYear);
        YahooDailyPlayersFeedNFL yahooPlayers = dailyController.getYahooDailyPlayers();

        // Vegas Odds
        List<RotoGrindersVegasOddsRecord> vegasOdds = vegasLinesController.getVegasLines();

        // Fantasy Pros stuff
        FantasyProsRankings qbRankings = rankingsController.getQuarterbackRankings();
        FantasyProsRankings rbRankings = rankingsController.getRunningBackRankings();
        FantasyProsRankings wrRankings = rankingsController.getWideReceiverRankings();
        FantasyProsRankings teRankings = rankingsController.getTightEndRankings();
        FantasyProsRankings flexRankings = rankingsController.getFlexRankings();
        FantasyProsRankings defRankings = rankingsController.getDefenseRankings();


        List<CurrentPlayerRecord> currentPlayerRecords = new ArrayList<>();

        for(YahooDailyPlayersFeedNFL.Player yahooPlayer : yahooPlayers.getPlayers().getResult()) {
            int week = 0;
            try{
                week = WeekTiming.weekOfYahooDate(yahooPlayer.getGameStartTime());
            } catch(ParseException e) {

            }

            // Ignore this player entry if it is not the correct week
            if(week == 0 || week != currentWeek) {
                continue;
            }

            CurrentPlayerRecord currentPlayerRecord = new CurrentPlayerRecord();
            currentPlayerRecord.setYahooDaily(yahooPlayer);
            currentPlayerRecord.setTeam(Team.fromString(yahooPlayer.getTeam()));
            currentPlayerRecord.setPosition(Position.fromString(currentPlayerRecord.getYahooDaily().getPosition()));

            for(PFRPassingRecord passingRecord : passingRecords) {
                if(passingRecord.getPlayer().equals(yahooPlayer.getName())) {
                    currentPlayerRecord.setPassingRecord(passingRecord);
                    break;
                }
            }
            for(PFRRushingAndReceivingRecord rushingAndReceivingRecord : rushingAndReceivingRecords) {
                if(rushingAndReceivingRecord.getPlayer().equals(yahooPlayer.getName())) {
                    currentPlayerRecord.setRushingAndReceiving(rushingAndReceivingRecord);
                    break;
                }
            }
            for(PFRTeamDefenseRecord teamDefenseRecord : teamDefenseRecords) {
                if(teamDefenseRecord.getTeam().equals(currentPlayerRecord.getTeam())) {
                    currentPlayerRecord.setDefenseRecord(teamDefenseRecord);
                    break;
                }
            }

            // Join Vegas Odds
            for(RotoGrindersVegasOddsRecord vegasOdd : vegasOdds) {
                if(currentPlayerRecord.getTeam().equals(vegasOdd.getTeam())) {
                    currentPlayerRecord.setVegasOddsRecord(vegasOdd);
                    break;
                }
            }


            // Fantasy Pros QB Ranking
            for(FantasyProsRankings.FantasyProRankingEntry entry : qbRankings.getRankings()) {
                if(entry.getPlayerName().equals(yahooPlayer.getName())) {
                    currentPlayerRecord.setQbRankingEntry(entry);
                    break;
                }
            }
            // Fantasy Pros RB Ranking
            for(FantasyProsRankings.FantasyProRankingEntry entry : rbRankings.getRankings()) {
                if(entry.getPlayerName().equals(yahooPlayer.getName())) {
                    currentPlayerRecord.setRbRankingEntry(entry);
                    break;
                }
            }
            // Fantasy Pros WR Ranking
            for(FantasyProsRankings.FantasyProRankingEntry entry : wrRankings.getRankings()) {
                if(entry.getPlayerName().equals(yahooPlayer.getName())) {
                    currentPlayerRecord.setWrRankingEntry(entry);
                    break;
                }
            }
            // Fantasy Pros TE Ranking
            for(FantasyProsRankings.FantasyProRankingEntry entry : teRankings.getRankings()) {
                if(entry.getPlayerName().equals(yahooPlayer.getName())) {
                    currentPlayerRecord.setTeRankingEntry(entry);
                    break;
                }
            }
            // Fantasy Pros FLEX Ranking
            for(FantasyProsRankings.FantasyProRankingEntry entry : flexRankings.getRankings()) {
                if(entry.getPlayerName().equals(yahooPlayer.getName())) {
                    currentPlayerRecord.setFlexRankingEntry(entry);
                    break;
                }
            }
            // Fantasy Pros DEF Ranking
            for(FantasyProsRankings.FantasyProRankingEntry entry : defRankings.getRankings()) {
                if(entry.getPlayerName().equals(yahooPlayer.getName())) {
                    currentPlayerRecord.setDefRankingEntry(entry);
                    break;
                }
            }

            currentPlayerRecords.add(currentPlayerRecord);
        }

        return currentPlayerRecords;
    }

    @RequestMapping("/master")
    public List<MasterPlayerRecord> getMasterPlayers() {
        List<MasterPlayerRecord> mprs = new ArrayList<>();
        for(CurrentPlayerRecord cpr : getCurrentPlayers()) {
            mprs.add(MasterPlayerRecord.fromCurrentPlayerRecord(cpr));
        }
        return mprs;
    }
}
