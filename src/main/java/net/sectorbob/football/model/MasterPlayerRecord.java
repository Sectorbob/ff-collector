package net.sectorbob.football.model;

/**
 * Created by ltm688 on 9/29/16.
 */
public class MasterPlayerRecord {

    private String playerName;
    private Integer age;
    private Position position;
    private Team team;
    private Team opponent;
    private String matchup;
    private String time;
    private String injuryStatus;
    private Integer fantasyProsQbRank;
    private Integer fantasyProsWrRank;
    private Integer fantasyProsRbRank;
    private Integer fantasyProsTeRank;
    private Integer fantasyProsDefRank;
    private Integer fantasyProsFlexRank;
    private Integer rank;
    private Integer inOutOverride;
    private Integer inOut;
    private String fullTeamName;
    private String fullOpponentTeamName;
    private Double line;
    private Double overUnder;
    private Double projected;

    private Integer yahooDfsPrice;

    private YearStats ytd;
    private YearStats lastYear;


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

    public Team getOpponent() {
        return opponent;
    }

    public void setOpponent(Team opponent) {
        this.opponent = opponent;
    }

    public String getMatchup() {
        return matchup;
    }

    public void setMatchup(String matchup) {
        this.matchup = matchup;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInjuryStatus() {
        return injuryStatus;
    }

    public void setInjuryStatus(String injuryStatus) {
        this.injuryStatus = injuryStatus;
    }

    public Integer getFantasyProsQbRank() {
        return fantasyProsQbRank;
    }

    public void setFantasyProsQbRank(Integer fantasyProsQbRank) {
        this.fantasyProsQbRank = fantasyProsQbRank;
    }

    public Integer getFantasyProsWrRank() {
        return fantasyProsWrRank;
    }

    public void setFantasyProsWrRank(Integer fantasyProsWrRank) {
        this.fantasyProsWrRank = fantasyProsWrRank;
    }

    public Integer getFantasyProsRbRank() {
        return fantasyProsRbRank;
    }

    public void setFantasyProsRbRank(Integer fantasyProsRbRank) {
        this.fantasyProsRbRank = fantasyProsRbRank;
    }

    public Integer getFantasyProsTeRank() {
        return fantasyProsTeRank;
    }

    public void setFantasyProsTeRank(Integer fantasyProsTeRank) {
        this.fantasyProsTeRank = fantasyProsTeRank;
    }

    public Integer getFantasyProsDefRank() {
        return fantasyProsDefRank;
    }

    public void setFantasyProsDefRank(Integer fantasyProsDefRank) {
        this.fantasyProsDefRank = fantasyProsDefRank;
    }

    public Integer getFantasyProsFlexRank() {
        return fantasyProsFlexRank;
    }

    public void setFantasyProsFlexRank(Integer fantasyProsFlexRank) {
        this.fantasyProsFlexRank = fantasyProsFlexRank;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getInOutOverride() {
        return inOutOverride;
    }

    public void setInOutOverride(Integer inOutOverride) {
        this.inOutOverride = inOutOverride;
    }

    public Integer getInOut() {
        return inOut;
    }

    public void setInOut(Integer inOut) {
        this.inOut = inOut;
    }

    public String getFullTeamName() {
        return fullTeamName;
    }

    public void setFullTeamName(String fullTeamName) {
        this.fullTeamName = fullTeamName;
    }

    public String getFullOpponentTeamName() {
        return fullOpponentTeamName;
    }

    public void setFullOpponentTeamName(String fullOpponentTeamName) {
        this.fullOpponentTeamName = fullOpponentTeamName;
    }

    public Double getLine() {
        return line;
    }

    public void setLine(Double line) {
        this.line = line;
    }

    public Double getOverUnder() {
        return overUnder;
    }

    public void setOverUnder(Double overUnder) {
        this.overUnder = overUnder;
    }

    public Double getProjected() {
        return projected;
    }

    public void setProjected(Double projected) {
        this.projected = projected;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public YearStats getYtd() {
        return ytd;
    }

    public Integer getYahooDfsPrice() {
        return yahooDfsPrice;
    }

    public void setYahooDfsPrice(Integer yahooDfsPrice) {
        this.yahooDfsPrice = yahooDfsPrice;
    }

    public void setYtd(YearStats ytd) {
        this.ytd = ytd;
    }

    public YearStats getLastYear() {
        return lastYear;
    }

    public void setLastYear(YearStats lastYear) {
        this.lastYear = lastYear;
    }

    public static MasterPlayerRecord fromCurrentPlayerRecord(CurrentPlayerRecord cpr) {
        MasterPlayerRecord mpr = new MasterPlayerRecord();

        mpr.setPlayerName(cpr.getYahooDaily().getName());
        mpr.setPosition(Position.fromString(cpr.getYahooDaily().getPosition()));
        mpr.setTeam(Team.fromString(cpr.getYahooDaily().getTeam()));
        mpr.setOpponent(cpr.getVegasOddsRecord().getOpponent());
        mpr.setMatchup(Team.fromString(cpr.getYahooDaily().getAwayTeam()) + "@" + Team.fromString(cpr.getYahooDaily().getHomeTeam()));
        mpr.setTime(cpr.getVegasOddsRecord().getTime());
        mpr.setInjuryStatus(null);
        if(cpr.getQbRankingEntry() != null)
            mpr.setFantasyProsQbRank(cpr.getQbRankingEntry().getRank());
        if(cpr.getRbRankingEntry() != null)
            mpr.setFantasyProsRbRank(cpr.getRbRankingEntry().getRank());
        if(cpr.getWrRankingEntry() != null)
            mpr.setFantasyProsWrRank(cpr.getWrRankingEntry().getRank());
        if(cpr.getTeRankingEntry() != null)
            mpr.setFantasyProsTeRank(cpr.getTeRankingEntry().getRank());
        if(cpr.getFlexRankingEntry() != null)
            mpr.setFantasyProsFlexRank(cpr.getFlexRankingEntry().getRank());
        if(cpr.getDefRankingEntry() != null)
            mpr.setFantasyProsDefRank(cpr.getDefRankingEntry().getRank());
        mpr.setRank(null);
        mpr.setInOutOverride(null);
        mpr.setInOut(null);
        mpr.setFullTeamName(mpr.getTeam().toFullName());
        mpr.setFullOpponentTeamName(mpr.getOpponent().toFullName());
        mpr.setLine(cpr.getVegasOddsRecord().getLine());
        mpr.setOverUnder(cpr.getVegasOddsRecord().getOverUnder());
        mpr.setProjected(cpr.getVegasOddsRecord().getProjectedPoints());
        mpr.setYahooDfsPrice(cpr.getYahooDaily().getSalary());
        YearStats ytd = new YearStats();
        mpr.setYtd(ytd);
        if(cpr.getRushingAndReceiving() != null) {
            PFRRushingAndReceivingRecord rrr = cpr.getRushingAndReceiving();
            mpr.setAge(rrr.getAge());
            ytd.setGames(rrr.getGames());
            ytd.setGamesStarted(rrr.getGamesStarted());

            ytd.setRushingAttempts(rrr.getRushingAttempts());
            ytd.setRushingYards(rrr.getRushingYards());
            ytd.setRushingTouchdowns(rrr.getRushingTouchdowns());
            ytd.setLongestRush(rrr.getLongestRush());

            ytd.setTargets(rrr.getTargets());
            ytd.setReceptions(rrr.getReceptions());
            ytd.setReceivingYards(rrr.getReceivingYards());
            ytd.setReceivingTouchdowns(rrr.getReceivingTouchdowns());
            ytd.setLongestReception(rrr.getLongestReception());
            ytd.setTotalFumbles(rrr.getTotalFumbles());
        }

        if(cpr.getPassingRecord() != null) {
            PFRPassingRecord pr = cpr.getPassingRecord();
            mpr.setAge(pr.getAge());
            ytd.setGames(pr.getGames());
            ytd.setGamesStarted(pr.getGamesStarted());
            ytd.setCompletions(pr.getCompletions());
            ytd.setPassingAttempts(pr.getAttempts());
            ytd.setPassingYards(pr.getYards());
            ytd.setPassingTouchdowns(pr.getTouchdowns());
            ytd.setInterceptions(pr.getInterceptions());
            ytd.setLongestPass(pr.getLongestPass());
            ytd.setAdjustedYardsPerPassAttempt(pr.getAdjustedYardsPerAttempt());
            ytd.setNflQuarterbackRating(pr.getNflQuarterbackRating());
            ytd.setEspnQuarterbackRating(pr.getEspnQuarterbackRating());
            ytd.setAdjustedNetYardsGainedPerPassAttempt(pr.getNetYardsGainedPerPassAttempt());
        }

        if(cpr.getDefenseRecord() != null) {
            PFRTeamDefenseRecord tdr = cpr.getDefenseRecord();
            ytd.setGames(tdr.getGames());
            ytd.setGamesStarted(tdr.getGames());
            ytd.setPointsAllowed(tdr.getPointsFor());
            ytd.setYardsAllowed(tdr.getYards());
            ytd.setOffensivePlaysAllowed(tdr.getOffensivePlays());
            ytd.setTakeAways(tdr.getTakeAways());
            ytd.setFumblesTakenAway(tdr.getFumblesLostByTeam());
            ytd.setFirstDownsAllowed(tdr.getFirstDowns());
            ytd.setPassingCompletionsAllowed(tdr.getPassingCompletions());
            ytd.setPassingAttemptsAllowed(tdr.getPassingAttempts());
            ytd.setPassingYardsAllowed(tdr.getPassingYards());
            ytd.setPassingTouchdownsAllowed(tdr.getPassingTouchdowns());
            ytd.setInterceptionsForced(tdr.getInterceptions());
            ytd.setFirstDownsByPassingAllowed(tdr.getFirstDownsByPassing());
            ytd.setRushingAttemptsAllowed(tdr.getRushingAttempts());
            ytd.setRushingYardsAllowed(tdr.getRushingYards());
            ytd.setRushingTouchdownsAllowed(tdr.getRushingTouchdowns());
            ytd.setFirstDownsByRushingAllowed(tdr.getFirstDownsByRushing());
            ytd.setPenalties(tdr.getPenalties());
            ytd.setPenaltyYards(tdr.getPenaltyYards());
            ytd.setFirstDownsByPenalty(tdr.getFirstDownsByPenalty());
            ytd.setScoringDrivePercentage(tdr.getScoringDrivePercentage());
            ytd.setTurnoverDrivePercentage(tdr.getTurnoverDrivePercentage());
            ytd.setExpectedPointsContributedByDefense(tdr.getExpectedPointsContributedByDefense());
        }

        return mpr;
    }

    public static class YearStats {
        // Stats

        private Integer games;
        private Integer gamesStarted;

        // Passing
        private Integer completions;
        private Integer passingAttempts;
        private Integer passingYards;
        private Integer passingTouchdowns;
        private Integer interceptions;
        private Integer longestPass;
        private Double adjustedYardsPerPassAttempt;
        private Double nflQuarterbackRating;
        private Double espnQuarterbackRating;
        private Double adjustedNetYardsGainedPerPassAttempt;

        // Rushing
        private Integer rushingAttempts;
        private Integer rushingYards;
        private Integer rushingTouchdowns;
        private Integer longestRush;

        // Receiving
        private Integer targets;
        private Integer receptions;
        private Integer receivingYards;
        private Integer receivingTouchdowns;
        private Integer longestReception;
        private Integer totalFumbles;

        // Defense
        private Integer pointsAllowed;
        private Integer yardsAllowed;
        private Integer offensivePlaysAllowed;
        private Integer takeAways;
        private Integer fumblesTakenAway;
        private Integer firstDownsAllowed;
        private Integer passingCompletionsAllowed;
        private Integer passingAttemptsAllowed;
        private Integer passingYardsAllowed;
        private Integer passingTouchdownsAllowed;
        private Integer interceptionsForced;
        private Integer firstDownsByPassingAllowed;
        private Integer rushingAttemptsAllowed;
        private Integer rushingYardsAllowed;
        private Integer rushingTouchdownsAllowed;
        private Integer firstDownsByRushingAllowed;
        private Integer penalties;
        private Integer penaltyYards;
        private Integer firstDownsByPenalty;
        private Double scoringDrivePercentage;
        private Double turnoverDrivePercentage;
        private Double expectedPointsContributedByDefense;


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

        public Integer getCompletions() {
            return completions;
        }

        public void setCompletions(Integer completions) {
            this.completions = completions;
        }

        public Integer getPassingAttempts() {
            return passingAttempts;
        }

        public void setPassingAttempts(Integer passingAattempts) {
            this.passingAttempts = passingAattempts;
        }

        public Integer getPassingYards() {
            return passingYards;
        }

        public void setPassingYards(Integer passingYards) {
            this.passingYards = passingYards;
        }

        public Integer getPassingTouchdowns() {
            return passingTouchdowns;
        }

        public void setPassingTouchdowns(Integer passingTouchdowns) {
            this.passingTouchdowns = passingTouchdowns;
        }

        public Integer getInterceptions() {
            return interceptions;
        }

        public void setInterceptions(Integer interceptions) {
            this.interceptions = interceptions;
        }

        public Integer getLongestPass() {
            return longestPass;
        }

        public void setLongestPass(Integer longestPass) {
            this.longestPass = longestPass;
        }

        public Double getAdjustedYardsPerPassAttempt() {
            return adjustedYardsPerPassAttempt;
        }

        public void setAdjustedYardsPerPassAttempt(Double adjustedYardsPerPassAttempt) {
            this.adjustedYardsPerPassAttempt = adjustedYardsPerPassAttempt;
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

        public Double getAdjustedNetYardsGainedPerPassAttempt() {
            return adjustedNetYardsGainedPerPassAttempt;
        }

        public void setAdjustedNetYardsGainedPerPassAttempt(Double adjustedNetYardsGainedPerPassAttempt) {
            this.adjustedNetYardsGainedPerPassAttempt = adjustedNetYardsGainedPerPassAttempt;
        }

        public Integer getRushingAttempts() {
            return rushingAttempts;
        }

        public void setRushingAttempts(Integer rushingAttempts) {
            this.rushingAttempts = rushingAttempts;
        }

        public Integer getRushingYards() {
            return rushingYards;
        }

        public void setRushingYards(Integer rushingYards) {
            this.rushingYards = rushingYards;
        }

        public Integer getRushingTouchdowns() {
            return rushingTouchdowns;
        }

        public void setRushingTouchdowns(Integer rushingTouchdowns) {
            this.rushingTouchdowns = rushingTouchdowns;
        }

        public Integer getLongestRush() {
            return longestRush;
        }

        public void setLongestRush(Integer longestRush) {
            this.longestRush = longestRush;
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

        public Integer getReceivingYards() {
            return receivingYards;
        }

        public void setReceivingYards(Integer receivingYards) {
            this.receivingYards = receivingYards;
        }

        public Integer getReceivingTouchdowns() {
            return receivingTouchdowns;
        }

        public void setReceivingTouchdowns(Integer receivingTouchdowns) {
            this.receivingTouchdowns = receivingTouchdowns;
        }

        public Integer getLongestReception() {
            return longestReception;
        }

        public void setLongestReception(Integer longestReception) {
            this.longestReception = longestReception;
        }

        public Integer getTotalFumbles() {
            return totalFumbles;
        }

        public void setTotalFumbles(Integer totalFumbles) {
            this.totalFumbles = totalFumbles;
        }

        public Integer getPointsAllowed() {
            return pointsAllowed;
        }

        public void setPointsAllowed(Integer pointsAllowed) {
            this.pointsAllowed = pointsAllowed;
        }

        public Integer getYardsAllowed() {
            return yardsAllowed;
        }

        public void setYardsAllowed(Integer yardsAllowed) {
            this.yardsAllowed = yardsAllowed;
        }

        public Integer getOffensivePlaysAllowed() {
            return offensivePlaysAllowed;
        }

        public void setOffensivePlaysAllowed(Integer offensivePlaysAllowed) {
            this.offensivePlaysAllowed = offensivePlaysAllowed;
        }

        public Integer getTakeAways() {
            return takeAways;
        }

        public void setTakeAways(Integer takeAways) {
            this.takeAways = takeAways;
        }

        public Integer getFumblesTakenAway() {
            return fumblesTakenAway;
        }

        public void setFumblesTakenAway(Integer fumblesTakenAway) {
            this.fumblesTakenAway = fumblesTakenAway;
        }

        public Integer getFirstDownsAllowed() {
            return firstDownsAllowed;
        }

        public void setFirstDownsAllowed(Integer firstDownsAllowed) {
            this.firstDownsAllowed = firstDownsAllowed;
        }

        public Integer getPassingCompletionsAllowed() {
            return passingCompletionsAllowed;
        }

        public void setPassingCompletionsAllowed(Integer passingCompletionsAllowed) {
            this.passingCompletionsAllowed = passingCompletionsAllowed;
        }

        public Integer getPassingAttemptsAllowed() {
            return passingAttemptsAllowed;
        }

        public void setPassingAttemptsAllowed(Integer passingAttemptsAllowed) {
            this.passingAttemptsAllowed = passingAttemptsAllowed;
        }

        public Integer getPassingYardsAllowed() {
            return passingYardsAllowed;
        }

        public void setPassingYardsAllowed(Integer passingYardsAllowed) {
            this.passingYardsAllowed = passingYardsAllowed;
        }

        public Integer getPassingTouchdownsAllowed() {
            return passingTouchdownsAllowed;
        }

        public void setPassingTouchdownsAllowed(Integer passingTouchdownsAllowed) {
            this.passingTouchdownsAllowed = passingTouchdownsAllowed;
        }

        public Integer getInterceptionsForced() {
            return interceptionsForced;
        }

        public void setInterceptionsForced(Integer interceptionsForced) {
            this.interceptionsForced = interceptionsForced;
        }

        public Integer getFirstDownsByPassingAllowed() {
            return firstDownsByPassingAllowed;
        }

        public void setFirstDownsByPassingAllowed(Integer firstDownsByPassingAllowed) {
            this.firstDownsByPassingAllowed = firstDownsByPassingAllowed;
        }

        public Integer getRushingAttemptsAllowed() {
            return rushingAttemptsAllowed;
        }

        public void setRushingAttemptsAllowed(Integer rushingAttemptsAllowed) {
            this.rushingAttemptsAllowed = rushingAttemptsAllowed;
        }

        public Integer getRushingYardsAllowed() {
            return rushingYardsAllowed;
        }

        public void setRushingYardsAllowed(Integer rushingYardsAllowed) {
            this.rushingYardsAllowed = rushingYardsAllowed;
        }

        public Integer getRushingTouchdownsAllowed() {
            return rushingTouchdownsAllowed;
        }

        public void setRushingTouchdownsAllowed(Integer rushingTouchdownsAllowed) {
            this.rushingTouchdownsAllowed = rushingTouchdownsAllowed;
        }

        public Integer getFirstDownsByRushingAllowed() {
            return firstDownsByRushingAllowed;
        }

        public void setFirstDownsByRushingAllowed(Integer firstDownsByRushingAllowed) {
            this.firstDownsByRushingAllowed = firstDownsByRushingAllowed;
        }

        public Integer getPenalties() {
            return penalties;
        }

        public void setPenalties(Integer penalties) {
            this.penalties = penalties;
        }

        public Integer getPenaltyYards() {
            return penaltyYards;
        }

        public void setPenaltyYards(Integer penaltyYards) {
            this.penaltyYards = penaltyYards;
        }

        public Integer getFirstDownsByPenalty() {
            return firstDownsByPenalty;
        }

        public void setFirstDownsByPenalty(Integer firstDownsByPenalty) {
            this.firstDownsByPenalty = firstDownsByPenalty;
        }

        public Double getScoringDrivePercentage() {
            return scoringDrivePercentage;
        }

        public void setScoringDrivePercentage(Double scoringDrivePercentage) {
            this.scoringDrivePercentage = scoringDrivePercentage;
        }

        public Double getTurnoverDrivePercentage() {
            return turnoverDrivePercentage;
        }

        public void setTurnoverDrivePercentage(Double turnoverDrivePercentage) {
            this.turnoverDrivePercentage = turnoverDrivePercentage;
        }

        public Double getExpectedPointsContributedByDefense() {
            return expectedPointsContributedByDefense;
        }

        public void setExpectedPointsContributedByDefense(Double expectedPointsContributedByDefense) {
            this.expectedPointsContributedByDefense = expectedPointsContributedByDefense;
        }
    }
}
