package net.sectorbob.football.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ltm688 on 9/28/16.
 */
public enum Position {

    QB,
    WR,
    RB,
    TE,
    K,
    DEF, // team defense
    P, // punter
    N_A;

    private static Logger LOG = LoggerFactory.getLogger(Position.class);

    public static Position fromString(String s) {
        switch (s.toUpperCase()) {
            case "QB":
            case "QB/WR":
                return QB;
            case "WR": return WR;
            case "RB":
            case "HB":
            case "FB":
            case "FB/RB":
            case "RB/WR":
            case "FB/WR":
            case "FB/TE":
                return RB;
            case "TE": return TE;
            case "K": return K;
            case "DEF":
            case "DST":
                return DEF;
            case "P":
                return P;
            case "":
            default:
                LOG.warn("Unknown Position: \"" + s + "\"");
                return N_A;
        }
    }

}
