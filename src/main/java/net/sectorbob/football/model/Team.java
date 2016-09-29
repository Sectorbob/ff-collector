package net.sectorbob.football.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ltm688 on 9/28/16.
 */
public enum Team {

    ARI,
    ATL,
    BAL,
    BUF,
    CAR,
    CHI,
    CIN,
    CLE,
    DAL,
    DEN,
    DET,
    GBP,
    HOU,
    IND,
    JAX,
    KCC,
    LAR,
    MIA,
    NEP,
    NOS,
    NYG,
    NYJ,
    OAK,
    PHI,
    PIT,
    MIN,
    SDC,
    SEA,
    SFF,
    TBB,
    TEN,
    WAS,
    N_A;

    private static Logger LOG = LoggerFactory.getLogger(Team.class);

    public static Team fromString(String s) {
        switch(s.toUpperCase().trim()) {
            case "ARI":
            case "ARIZONA CARDINALS":
                return ARI;
            case "ATL":
            case "ATLANTA FALCONS":
                return ATL;
            case "BAL":
            case "BALTIMORE RAVENS":
                return BAL;
            case "BUF":
            case "BUFFALO BILLS":
                return BUF;
            case "CAR":
            case "CAROLINA PANTHERS":
                return CAR;
            case "CHI":
            case "CHICAGO BEARS":
                return CHI;
            case "CIN":
            case "CINCINNATI BENGALS":
                return CIN;
            case "CLE":
            case "CLEVELAND BROWNS":
                return CLE;
            case "DAL":
            case "DALLAS COWBOYS":
                return DAL;
            case "DEN":
            case "DENVER BRONCOS":
                return DEN;
            case "DET":
            case "DETROIT LIONS":
                return DET;
            case "GB":
            case "GNB":
            case "GBP":
            case "GREEN BAY PACKERS":
                return GBP;
            case "HOU":
            case "HOUSTON TEXANS":
                return HOU;
            case "IND":
            case "INDIANAPOLIS COLTS":
                return IND;
            case "JAX":
            case "JAC":
            case "JACKSONVILLE JAGUARS":
                return JAX;
            case "KC":
            case "KCC":
            case "KAN":
            case "KANSAS CITY CHIEFS":
                return KCC;
            case "LA":
            case "LAR":
            case "STL":
            case "LOS ANGELES RAMS":
                return LAR;
            case "MIA":
            case "MIAMI DOLPHINS":
                return MIA;
            case "NE":
            case "NEP":
            case "NWE":
            case "NEW ENGLAND PATRIOTS":
                return NEP;
            case "NO":
            case "NOR":
            case "NOS":
            case "NEW ORLEANS SAINTS":
                return NOS;
            case "NYG":
            case "NEW YORK GIANTS":
                return NYG;
            case "NYJ":
            case "NEW YORK JETS":
                return NYJ;
            case "OAK":
            case "OAKLAND RAIDERS":
                return OAK;
            case "PHI":
            case "PHILADELPHIA EAGLES":
                return PHI;
            case "PIT":
            case "PITTSBURGH STEELERS":
                return PIT;
            case "MIN":
            case "MINNESOTA VIKINGS":
                return MIN;
            case "SD":
            case "SDG":
            case "SDC":
            case "SAN DIEGO CHARGERS":
                return SDC;
            case "SEA":
            case "SEATTLE SEAHAWKS":
                return SEA;
            case "SF":
            case "SFO":
            case "SAN FRANCISCO 49ERS":
                return SFF;
            case "TB":
            case "TBB":
            case "TAM":
            case "TAMPA BAY BUCCANEERS":
                return TBB;
            case "TEN":
            case "TENNESSEE TITANS":
                return TEN;
            case "WAS":
            case "WASHINGTON REDSKINS":
                return WAS;
            case "2TM":
            case "3TM":
                return N_A;
            default:
                LOG.warn("Unknown team: \"" + s + "\"");
                return N_A;
        }
    }

    public String toFullName() {
        switch(this) {

            case ARI: return "Arizona Cardinals";
            case ATL: return "Atlanta Falcons";
            case BAL: return "Baltimore Ravens";
            case BUF: return "Buffalo Bills";
            case CAR: return "Carolina Panthers";
            case CHI: return "Chicago Bears";
            case CIN: return "Cincinnati Bengals";
            case CLE: return "Cleveland Browns";
            case DAL: return "Dallas Cowboys";
            case DEN: return "Denver Broncos";
            case DET: return "Detroit Lions";
            case GBP: return "Green Bay Packers";
            case HOU: return "Houston Texans";
            case IND: return "Indianapolis Colts";
            case JAX: return "Jacksonville Jaguars";
            case KCC: return "Kansas City Chiefs";
            case LAR: return "Los Angeles Rams";
            case MIA: return "Miami Dolphins";
            case NEP: return "New England Patriots";
            case NOS: return "New Orleans Saints";
            case NYG: return "New York Giants";
            case NYJ: return "New York Jets";
            case OAK: return "Oakland Raiders";
            case PHI: return "Philadelphia Eagles";
            case PIT: return "Pittsburgh Steelers";
            case MIN: return "Minnesota Vikings";
            case SDC: return "San Diego Chargers";
            case SEA: return "Seattle Seahawks";
            case SFF: return "San Francisco 49ers";
            case TBB: return "Tampa Bay Buccaneers";
            case TEN: return "Tennessee Titans";
            case WAS: return "Washington Redskins";
            case N_A:
            default:
                return "Not Available";
        }
    }

    public String getTextColor() {
        return null;
    }
}
