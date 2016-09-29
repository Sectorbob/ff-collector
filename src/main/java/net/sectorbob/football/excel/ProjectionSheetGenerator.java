package net.sectorbob.football.excel;

import net.sectorbob.football.model.MasterPlayerRecord;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ltm688 on 9/28/16.
 */
@Component
public class ProjectionSheetGenerator {


    public Workbook generate(List<MasterPlayerRecord> players) {
        Workbook wb = new HSSFWorkbook();

        Sheet sh = wb.createSheet("projections");
        generateHeaderRow(sh);

        int rowNo = 0;
        for(MasterPlayerRecord player : players) {
            Row row = sh.createRow(++rowNo);
            for(int i = 0; i < 22; i++) {
                Cell cell = row.createCell(i);
                switch (i) {
                    case 0:
                        writeCell(cell, player.getRank());
                        break;
                    case 1:
                        writeCell(cell, player.getPlayerName());
                        break;
                    case 2:
                        writeCell(cell, player.getPosition().toString());
                        break;
                    case 3:
                        writeCell(cell, player.getTeam().toString());
                        break;
                    case 4:
                        writeCell(cell, player.getOpponent().toString());
                        break;
                    case 5:
                        writeCell(cell, player.getMatchup());
                        break;
                    case 6:
                        writeCell(cell, player.getTime());
                        break;
                    case 7:
                        writeCell(cell, "n/a"); // TODO
                        break;
                    case 8:
                        writeCell(cell, player.getFantasyProsQbRank());
                        break;
                    case 9:
                        writeCell(cell, player.getFantasyProsRbRank());
                        break;
                    case 10:
                        writeCell(cell, player.getFantasyProsWrRank());
                        break;
                    case 11:
                        writeCell(cell, player.getFantasyProsTeRank());
                        break;
                    case 12:
                        writeCell(cell, player.getFantasyProsFlexRank());
                        break;
                    case 13:
                        writeCell(cell, player.getFantasyProsDefRank());
                        break;
                    case 14:
                        writeCell(cell, "n/a"); // TODO
                        break;
                    case 15:
                        writeCell(cell, "n/a"); // TODO
                        break;
                    case 16:
                        writeCell(cell, player.getTeam().toFullName());
                        break;
                    case 17:
                        writeCell(cell, player.getOpponent().toFullName());
                        break;
                    case 18:
                        writeCell(cell, player.getLine());
                        break;
                    case 19:
                        writeCell(cell, player.getOverUnder());
                        break;
                    case 20:
                        writeCell(cell, player.getProjected());
                        break;
                    case 21:
                        writeCell(cell, player.getYahooDfsPrice());
                        break;
                    default:
                        break;
                }
            }
        }

        return wb;
    }

    private static void generateHeaderRow(Sheet sh) {
        Font font = sh.getWorkbook().createFont();
        font.setBold(true);

        CellStyle style = sh.getWorkbook().createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setFont(font);

        Row row = sh.createRow(0);

        for(int i = 0; i < 23; i++) {
            Cell cell =  row.createCell(i);
            cell.setCellStyle(style);

            switch (i) {
                case 0:
                    cell.setCellValue("Rank");
                    break;
                case 1:
                    cell.setCellValue("Name");
                    break;
                case 2:
                    cell.setCellValue("Position");
                    break;
                case 3:
                    cell.setCellValue("Team");
                    break;
                case 4:
                    cell.setCellValue("Opponent");
                    break;
                case 5:
                    cell.setCellValue("Game");
                    break;
                case 6:
                    cell.setCellValue("Time");
                    break;
                case 7:
                    cell.setCellValue("Injury Status");
                    break;
                case 8:
                    cell.setCellValue("FP QB Rank");
                    break;
                case 9:
                    cell.setCellValue("FP RB Rank");
                    break;
                case 10:
                    cell.setCellValue("FP WR Rank");
                    break;
                case 11:
                    cell.setCellValue("FP TE Rank");
                    break;
                case 12:
                    cell.setCellValue("FP Flex Rank");
                    break;
                case 13:
                    cell.setCellValue("FP Def Rank");
                    break;
                case 14:
                    cell.setCellValue("In/Out Override");
                    break;
                case 15:
                    cell.setCellValue("In/Out");
                    break;
                case 16:
                    cell.setCellValue("Team Name");
                    break;
                case 17:
                    cell.setCellValue("Opponent Team Name");
                    break;
                case 18:
                    cell.setCellValue("Line");
                    break;
                case 19:
                    cell.setCellValue("Over/Under");
                    break;
                case 20:
                    cell.setCellValue("Projected");
                    break;
                case 21:
                    cell.setCellValue("Yahoo DFS Price");
                    break;
                default:
                    break;
            }
        }

    }


    private static void writeCell(Cell cell, Object data) {
        if(data == null) {
            return;
        }

        if(data.getClass().isAssignableFrom(Integer.class)) {
            cell.setCellValue((Integer)data);
        } else if(data.getClass().isAssignableFrom(Double.class)) {
            cell.setCellValue((Double)data);
        } else if(data.getClass().isAssignableFrom(Boolean.class)) {
            cell.setCellValue((Boolean)data);
        } else {
            cell.setCellValue(data.toString());
        }
    }


}
