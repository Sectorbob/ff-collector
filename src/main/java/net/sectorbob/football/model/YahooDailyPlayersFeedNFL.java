package net.sectorbob.football.model;

import java.util.List;

/**
 * Created by ltm688 on 9/17/16.
 */
public class YahooDailyPlayersFeedNFL {

    private Long currentTime;

    private Players players;

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }

    public Players getPlayers() {
        return players;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }

    public static class Players {
        private List<Player> result;
        private String error;

        public List<Player> getResult() {
            return result;
        }

        public void setResult(List<Player> result) {
            this.result = result;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    public static class Player {
        private String sport;
        private String playerCode;
        private String gameCode;
        private String position;
        private String team;
        private Integer salary;
        private Double fppg;
        private String name;
        private String homeTeam;
        private String awayTeam;
        private String gameStartTime;

        public String getSport() {
            return sport;
        }

        public void setSport(String sport) {
            this.sport = sport;
        }

        public String getPlayerCode() {
            return playerCode;
        }

        public void setPlayerCode(String playerCode) {
            this.playerCode = playerCode;
        }

        public String getGameCode() {
            return gameCode;
        }

        public void setGameCode(String gameCode) {
            this.gameCode = gameCode;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getTeam() {
            return team;
        }

        public void setTeam(String team) {
            this.team = team;
        }

        public Integer getSalary() {
            return salary;
        }

        public void setSalary(Integer salary) {
            this.salary = salary;
        }

        public Double getFppg() {
            return fppg;
        }

        public void setFppg(Double fppg) {
            this.fppg = fppg;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHomeTeam() {
            return homeTeam;
        }

        public void setHomeTeam(String homeTeam) {
            this.homeTeam = homeTeam;
        }

        public String getAwayTeam() {
            return awayTeam;
        }

        public void setAwayTeam(String awayTeam) {
            this.awayTeam = awayTeam;
        }

        public String getGameStartTime() {
            return gameStartTime;
        }

        public void setGameStartTime(String gameStartTime) {
            this.gameStartTime = gameStartTime;
        }

        public boolean equals(Object o) {
            Player other = (Player)o;
            return other.getGameCode().equals(this.getGameCode()) &&
                    other.getPlayerCode().equals(this.getPlayerCode());

        }

        public int hashCode() {
            return this.getPlayerCode().hashCode() +
                    this.getGameCode().hashCode() +
                    this.getName().hashCode() +
                    this.getSalary();
        }
    }
}
