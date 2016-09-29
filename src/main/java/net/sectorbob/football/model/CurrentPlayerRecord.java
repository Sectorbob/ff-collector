package net.sectorbob.football.model;

/**
 * Created by ltm688 on 9/17/16.
 */
public class CurrentPlayerRecord {

    private Position position;
    private Team team;

    private PFRRushingAndReceivingRecord rushingAndReceiving;
    private PFRPassingRecord passingRecord;
    private PFRTeamDefenseRecord defenseRecord;
    private YahooDailyPlayersFeedNFL.Player yahooDaily;

    private RotoGrindersVegasOddsRecord vegasOddsRecord;

    private FantasyProsRankings.FantasyProRankingEntry qbRankingEntry;
    private FantasyProsRankings.FantasyProRankingEntry rbRankingEntry;
    private FantasyProsRankings.FantasyProRankingEntry wrRankingEntry;
    private FantasyProsRankings.FantasyProRankingEntry teRankingEntry;
    private FantasyProsRankings.FantasyProRankingEntry flexRankingEntry;
    private FantasyProsRankings.FantasyProRankingEntry defRankingEntry;


    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public PFRRushingAndReceivingRecord getRushingAndReceiving() {
        return rushingAndReceiving;
    }

    public void setRushingAndReceiving(PFRRushingAndReceivingRecord rushingAndReceiving) {
        this.rushingAndReceiving = rushingAndReceiving;
    }

    public PFRPassingRecord getPassingRecord() {
        return passingRecord;
    }

    public void setPassingRecord(PFRPassingRecord passingRecord) {
        this.passingRecord = passingRecord;
    }

    public PFRTeamDefenseRecord getDefenseRecord() {
        return defenseRecord;
    }

    public void setDefenseRecord(PFRTeamDefenseRecord defenseRecord) {
        this.defenseRecord = defenseRecord;
    }

    public YahooDailyPlayersFeedNFL.Player getYahooDaily() {
        return yahooDaily;
    }

    public void setYahooDaily(YahooDailyPlayersFeedNFL.Player yahooDaily) {
        this.yahooDaily = yahooDaily;
    }

    public RotoGrindersVegasOddsRecord getVegasOddsRecord() {
        return vegasOddsRecord;
    }

    public void setVegasOddsRecord(RotoGrindersVegasOddsRecord vegasOddsRecord) {
        this.vegasOddsRecord = vegasOddsRecord;
    }

    public FantasyProsRankings.FantasyProRankingEntry getQbRankingEntry() {
        return qbRankingEntry;
    }

    public void setQbRankingEntry(FantasyProsRankings.FantasyProRankingEntry qbRankingEntry) {
        this.qbRankingEntry = qbRankingEntry;
    }

    public FantasyProsRankings.FantasyProRankingEntry getRbRankingEntry() {
        return rbRankingEntry;
    }

    public void setRbRankingEntry(FantasyProsRankings.FantasyProRankingEntry rbRankingEntry) {
        this.rbRankingEntry = rbRankingEntry;
    }

    public FantasyProsRankings.FantasyProRankingEntry getWrRankingEntry() {
        return wrRankingEntry;
    }

    public void setWrRankingEntry(FantasyProsRankings.FantasyProRankingEntry wrRankingEntry) {
        this.wrRankingEntry = wrRankingEntry;
    }

    public FantasyProsRankings.FantasyProRankingEntry getTeRankingEntry() {
        return teRankingEntry;
    }

    public void setTeRankingEntry(FantasyProsRankings.FantasyProRankingEntry teRankingEntry) {
        this.teRankingEntry = teRankingEntry;
    }

    public FantasyProsRankings.FantasyProRankingEntry getFlexRankingEntry() {
        return flexRankingEntry;
    }

    public void setFlexRankingEntry(FantasyProsRankings.FantasyProRankingEntry flexRankingEntry) {
        this.flexRankingEntry = flexRankingEntry;
    }

    public FantasyProsRankings.FantasyProRankingEntry getDefRankingEntry() {
        return defRankingEntry;
    }

    public void setDefRankingEntry(FantasyProsRankings.FantasyProRankingEntry defRankingEntry) {
        this.defRankingEntry = defRankingEntry;
    }
}
