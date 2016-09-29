package net.sectorbob.football.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ltm688 on 9/29/16.
 */
public class FantasyProsRankings {

    private String week;
    private List<FantasyProRankingEntry> rankings = new ArrayList<>();

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public List<FantasyProRankingEntry> getRankings() {
        return rankings;
    }

    public void setRankings(List<FantasyProRankingEntry> rankings) {
        this.rankings = rankings;
    }

    public static class FantasyProRankingEntry {
        private Integer rank;
        private String playerName;
        private Position position;
        private Team team;
        private String matchup;
        private Integer bestRank;
        private Integer worstRank;
        private Double averageRank;
        private Double standardDeviation;

        public Integer getRank() {
            return rank;
        }

        public void setRank(Integer rank) {
            this.rank = rank;
        }

        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }

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

        public String getMatchup() {
            return matchup;
        }

        public void setMatchup(String matchup) {
            this.matchup = matchup;
        }

        public Integer getBestRank() {
            return bestRank;
        }

        public void setBestRank(Integer bestRank) {
            this.bestRank = bestRank;
        }

        public Integer getWorstRank() {
            return worstRank;
        }

        public void setWorstRank(Integer worstRank) {
            this.worstRank = worstRank;
        }

        public Double getAverageRank() {
            return averageRank;
        }

        public void setAverageRank(Double averageRank) {
            this.averageRank = averageRank;
        }

        public Double getStandardDeviation() {
            return standardDeviation;
        }

        public void setStandardDeviation(Double standardDeviation) {
            this.standardDeviation = standardDeviation;
        }
    }
}
