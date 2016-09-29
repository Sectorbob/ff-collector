package net.sectorbob.football.model;

import javafx.geometry.Pos;

/**
 * Created by Kyle Heide
 */
public class PFRPassingRecord {
    /*
    "Rk", "", "Tm", "Age", "Pos", "G", "GS", "QBrec", "Cmp", "Att", "Cmp%",
            "Yds", "TD", "TD%", "Int", "Int%", "Lng", "Y/A", "AY/A", "Y/C", "Y/G",
            "Rate", "QBR", "Sk", "Yds", "NY/A", "ANY/A", "Sk%", "4QC", "GWD"
    */

    private Integer rank;
    private String player;
    private Team team;
    private Integer age;
    private Position position;
    private Integer games;
    private Integer gamesStarted;
    private String qbRecord;
    private Integer completions;
    private Integer attempts;
    private Double completionPercentage;
    private Integer yards;
    private Integer touchdowns;
    private Double touchdownPercentage;
    private Integer interceptions;
    private Double interceptionPercentage;
    private Integer longestPass;
    private Double yardsPerAttempt;
    private Double adjustedYardsPerAttempt;
    private Double yardsPerCompletion;
    private Double yardsPerGame;
    private Double nflQuarterbackRating;
    private Double espnQuarterbackRating;
    private Integer timesSacked;
    private Integer yardsLossFromSacks;
    private Double netYardsGainedPerPassAttempt;
    private Double adjustedNetYardsGainedPerPassAttempt;
    private Double sackedDuringPassAttemptPercentage;
    private Integer fourthQuarterComebacks;
    private Integer gameWinningDrives;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getGamesStarted() {
        return gamesStarted;
    }

    public void setGamesStarted(Integer gamesStarted) {
        this.gamesStarted = gamesStarted;
    }

    public String getQbRecord() {
        return qbRecord;
    }

    public void setQbRecord(String qbRecord) {
        this.qbRecord = qbRecord;
    }

    public Integer getCompletions() {
        return completions;
    }

    public void setCompletions(Integer completions) {
        this.completions = completions;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public Double getCompletionPercentage() {
        return completionPercentage;
    }

    public void setCompletionPercentage(Double completionPercentage) {
        this.completionPercentage = completionPercentage;
    }

    public Integer getYards() {
        return yards;
    }

    public void setYards(Integer yards) {
        this.yards = yards;
    }

    public Integer getTouchdowns() {
        return touchdowns;
    }

    public void setTouchdowns(Integer touchdowns) {
        this.touchdowns = touchdowns;
    }

    public Double getTouchdownPercentage() {
        return touchdownPercentage;
    }

    public void setTouchdownPercentage(Double touchdownPercentage) {
        this.touchdownPercentage = touchdownPercentage;
    }

    public Integer getInterceptions() {
        return interceptions;
    }

    public void setInterceptions(Integer interceptions) {
        this.interceptions = interceptions;
    }

    public Double getInterceptionPercentage() {
        return interceptionPercentage;
    }

    public void setInterceptionPercentage(Double interceptionPercentage) {
        this.interceptionPercentage = interceptionPercentage;
    }

    public Integer getLongestPass() {
        return longestPass;
    }

    public void setLongestPass(Integer longestPass) {
        this.longestPass = longestPass;
    }

    public Double getYardsPerAttempt() {
        return yardsPerAttempt;
    }

    public void setYardsPerAttempt(Double yardsPerAttempt) {
        this.yardsPerAttempt = yardsPerAttempt;
    }

    public Double getAdjustedYardsPerAttempt() {
        return adjustedYardsPerAttempt;
    }

    public void setAdjustedYardsPerAttempt(Double adjustedYardsPerAttempt) {
        this.adjustedYardsPerAttempt = adjustedYardsPerAttempt;
    }

    public Double getYardsPerCompletion() {
        return yardsPerCompletion;
    }

    public void setYardsPerCompletion(Double yardsPerCompletion) {
        this.yardsPerCompletion = yardsPerCompletion;
    }

    public Double getYardsPerGame() {
        return yardsPerGame;
    }

    public void setYardsPerGame(Double yardsPerGame) {
        this.yardsPerGame = yardsPerGame;
    }

    public Double getNflQuarterbackRating() {
        return nflQuarterbackRating;
    }

    public void setNflQuarterbackRating(Double nflQuarterbackRating) {
        this.nflQuarterbackRating = nflQuarterbackRating;
    }

    public Double getEspnQuarterbackRating() {
        return espnQuarterbackRating;
    }

    public void setEspnQuarterbackRating(Double espnQuarterbackRating) {
        this.espnQuarterbackRating = espnQuarterbackRating;
    }

    public Integer getTimesSacked() {
        return timesSacked;
    }

    public void setTimesSacked(Integer timesSacked) {
        this.timesSacked = timesSacked;
    }

    public Integer getYardsLossFromSacks() {
        return yardsLossFromSacks;
    }

    public void setYardsLossFromSacks(Integer yardsLossFromSacks) {
        this.yardsLossFromSacks = yardsLossFromSacks;
    }

    public Double getNetYardsGainedPerPassAttempt() {
        return netYardsGainedPerPassAttempt;
    }

    public void setNetYardsGainedPerPassAttempt(Double netYardsGainedPerPassAttempt) {
        this.netYardsGainedPerPassAttempt = netYardsGainedPerPassAttempt;
    }

    public Double getAdjustedNetYardsGainedPerPassAttempt() {
        return adjustedNetYardsGainedPerPassAttempt;
    }

    public void setAdjustedNetYardsGainedPerPassAttempt(Double adjustedNetYardsGainedPerPassAttempt) {
        this.adjustedNetYardsGainedPerPassAttempt = adjustedNetYardsGainedPerPassAttempt;
    }

    public Double getSackedDuringPassAttemptPercentage() {
        return sackedDuringPassAttemptPercentage;
    }

    public void setSackedDuringPassAttemptPercentage(Double sackedDuringPassAttemptPercentage) {
        this.sackedDuringPassAttemptPercentage = sackedDuringPassAttemptPercentage;
    }

    public Integer getFourthQuarterComebacks() {
        return fourthQuarterComebacks;
    }

    public void setFourthQuarterComebacks(Integer fourthQuarterComebacks) {
        this.fourthQuarterComebacks = fourthQuarterComebacks;
    }

    public Integer getGameWinningDrives() {
        return gameWinningDrives;
    }

    public void setGameWinningDrives(Integer gameWinningDrives) {
        this.gameWinningDrives = gameWinningDrives;
    }
}
