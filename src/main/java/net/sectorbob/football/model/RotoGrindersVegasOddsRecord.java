package net.sectorbob.football.model;

/**
 * Created by ltm688 on 9/18/16.
 */
public class RotoGrindersVegasOddsRecord {

    private String time;
    private Team team;
    private Team opponent;
    private Double line;
    private Double moneyline;
    private Double overUnder;
    private Double projectedPoints;
    private Double projectedPointsChange;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getOpponent() {
        return opponent;
    }

    public void setOpponent(Team opponent) {
        this.opponent = opponent;
    }

    public Double getLine() {
        return line;
    }

    public void setLine(Double line) {
        this.line = line;
    }

    public Double getMoneyline() {
        return moneyline;
    }

    public void setMoneyline(Double moneyline) {
        this.moneyline = moneyline;
    }

    public Double getOverUnder() {
        return overUnder;
    }

    public void setOverUnder(Double overUnder) {
        this.overUnder = overUnder;
    }

    public Double getProjectedPoints() {
        return projectedPoints;
    }

    public void setProjectedPoints(Double projectedPoints) {
        this.projectedPoints = projectedPoints;
    }

    public Double getProjectedPointsChange() {
        return projectedPointsChange;
    }

    public void setProjectedPointsChange(Double projectedPointsChange) {
        this.projectedPointsChange = projectedPointsChange;
    }
}
