package net.sectorbob.football.model;

import javafx.geometry.Pos;

/**
 * Created by ltm688 on 9/17/16.
 */
public class PFRReceivingRecord {

    private Integer rank;
    private String player;
    private Team team;
    private Integer age;
    private Position position;
    private Integer games;
    private Integer gamesStarted;
    private Integer targets;
    private Integer receptions;
    private Double catchPercentage;
    private Integer yards;
    private Double yardsPerReception;
    private Integer touchdowns;
    private Integer longestReception;
    private Double receptionsPerGame;
    private Double yardsPerGame;
    private Integer totalFumbles;

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

    public Integer getTargets() {
        return targets;
    }

    public void setTargets(Integer targets) {
        this.targets = targets;
    }

    public Integer getReceptions() {
        return receptions;
    }

    public void setReceptions(Integer receptions) {
        this.receptions = receptions;
    }

    public Double getCatchPercentage() {
        return catchPercentage;
    }

    public void setCatchPercentage(Double catchPercentage) {
        this.catchPercentage = catchPercentage;
    }

    public Integer getYards() {
        return yards;
    }

    public void setYards(Integer yards) {
        this.yards = yards;
    }

    public Double getYardsPerReception() {
        return yardsPerReception;
    }

    public void setYardsPerReception(Double yardsPerReception) {
        this.yardsPerReception = yardsPerReception;
    }

    public Integer getTouchdowns() {
        return touchdowns;
    }

    public void setTouchdowns(Integer touchdowns) {
        this.touchdowns = touchdowns;
    }

    public Integer getLongestReception() {
        return longestReception;
    }

    public void setLongestReception(Integer longestReception) {
        this.longestReception = longestReception;
    }

    public Double getReceptionsPerGame() {
        return receptionsPerGame;
    }

    public void setReceptionsPerGame(Double receptionsPerGame) {
        this.receptionsPerGame = receptionsPerGame;
    }

    public Double getYardsPerGame() {
        return yardsPerGame;
    }

    public void setYardsPerGame(Double yardsPerGame) {
        this.yardsPerGame = yardsPerGame;
    }

    public Integer getTotalFumbles() {
        return totalFumbles;
    }

    public void setTotalFumbles(Integer totalFumbles) {
        this.totalFumbles = totalFumbles;
    }
}
