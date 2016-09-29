package net.sectorbob.football.rest;

import net.sectorbob.football.client.FantasyProsClient;
import net.sectorbob.football.model.FantasyProsRankings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ltm688 on 9/29/16.
 */
@RestController
@RequestMapping("/rankings")
public class RankingsController {

    @Autowired
    FantasyProsClient fantasyProsClient;

    @RequestMapping("/qb")
    public FantasyProsRankings getQuarterbackRankings() {
        return fantasyProsClient.getRankings(FantasyProsClient.QB);
    }

    @RequestMapping("/rb")
    public FantasyProsRankings getRunningBackRankings() {
        return fantasyProsClient.getRankings(FantasyProsClient.RB);
    }

    @RequestMapping("/wr")
    public FantasyProsRankings getWideReceiverRankings() {
        return fantasyProsClient.getRankings(FantasyProsClient.WR);
    }

    @RequestMapping("/te")
    public FantasyProsRankings getTightEndRankings() {
        return fantasyProsClient.getRankings(FantasyProsClient.TE);
    }

    @RequestMapping("/flex")
    public FantasyProsRankings getFlexRankings() {
        return fantasyProsClient.getRankings(FantasyProsClient.FLEX);
    }

    @RequestMapping("/def")
    public FantasyProsRankings getDefenseRankings() {
        return fantasyProsClient.getRankings(FantasyProsClient.DST);
    }

}
