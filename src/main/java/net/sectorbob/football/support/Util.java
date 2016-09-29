package net.sectorbob.football.support;

import org.apache.http.HttpEntity;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Kyle Heide
 *
 */
public class Util {

    private static Logger LOG = LogManager.getLogger(Util.class);

    public static void printTableFromObjects(Logger logger, Priority level, List<? extends Object> objects, String... columns) {
        Table table = new Table();

        objects.forEach((obj) -> {
            Row row = new Row();
            for (Field field : obj.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true); // You might want to set modifier to public first.
                    Object value = field.get(obj);
                    if (value != null) {
                        row.put(field.getName(),new TableCellData(value.toString()));
                    }
                } catch (IllegalAccessException e) {
                    logger.error("Reflection error", e);
                }
            }
            table.add(row);
        });

        printTable(logger, level, table, columns);
    }


    public static void printTable(Logger logger, Priority level, Table data, String... columns) {
        String columnDelimiter = " | ";


        List<Integer> columnWidths = new ArrayList<>();
        for(String column : columns) {
            int maxValueLength = column.length();
            for(Row row : data) {
                TableCellData temp = row.get(column);
                if(cellHasData(temp))
                    maxValueLength = (maxValueLength < row.get(column).getData().length())
                            ? row.get(column).getData().length() : maxValueLength;
            }
            columnWidths.add(maxValueLength);
        }
        StringBuilder headerRow = new StringBuilder();
        headerRow.append(columnDelimiter);
        for(int i = 0; i < columns.length; i++) {
            String columnName = columns[i];
            int columnWidth = columnWidths.get(i);
            headerRow.append(String.format("%-" + columnWidth + "s" + columnDelimiter, columnName));
        }
        StringBuilder topBorder = new StringBuilder();
        topBorder.append(" +");
        for(int i = 0; i < headerRow.length()-4; i++) topBorder.append('-');
        topBorder.append("+ ");

        logger.log(level, topBorder.toString());
        logger.log(level, headerRow.toString());
        logger.log(level, topBorder.toString());
        for(Row row : data) {
            StringBuilder s = new StringBuilder();

            s.append(columnDelimiter);
            for (int i = 0; i < columns.length; i++) {
                String columnName = columns[i];
                int columnWidth = columnWidths.get(i);
                String temp = ( !cellHasData(row.get(columnName))) ? "" : row.get(columnName).getData();
                s.append(String.format("%-" + columnWidth + "s" + columnDelimiter, temp));
            }
            logger.log(level, s.toString());
        }

        logger.log(level, topBorder.toString());
    }

    private static boolean cellHasData(TableCellData data) {
        return (data != null && data.getData() != null && data.getData().length() != 0);
    }

    public static Table webTableToListMapWithJsoup(String html, String selector, int ignoreFirstXRows, String dataRowAttribute) {
        LOG.debug("Retrieving and parsing data from html");
        Document doc = Jsoup.parse(html);

        Element table = doc.select(selector).first();

        //LOG.info(table.html());

        if(table == null) {
            LOG.error("Unable to find table at " + selector + " | Source: " + html);
        }

        Table userTable = webTableElementToDataTable(table, ignoreFirstXRows, dataRowAttribute);

        LOG.debug("Retrieved and parsed data from html successfully");
        return userTable;
    }

    public static Table webTableElementToDataTable(Element tableElement, int ignoreFirstXRows, String dataRowAttribute) {
        // create empty table object and iterate through all rows of the found table element
        Table userTable = new Table();
        List<Element> rowElements = tableElement.select("tr");

        // get column names of table from table headers
        List<String> columnNames = new ArrayList<>();
        List<Element> headerElements = rowElements.get(ignoreFirstXRows).select("th");
        for (Element headerElement: headerElements) {
            columnNames.add(headerElement.text());
        }

        LOG.info(columnNames);

        List<Element> dataRows = new ArrayList<>();
        for(Element rowElement : rowElements) {

            if(rowElement.parent().tagName().equals("tbody") && !rowElement.hasClass("thead")) {
                dataRows.add(rowElement);
            }
        }

        LOG.debug("Data Row Count: " + dataRows.size());
        LOG.debug("Column Names: " + columnNames);

        // iterate through all rows and add their content to table array
        for (Element rowElement: dataRows) {
            Row row = new Row();

            // add table cells to current row
            int columnIndex = 0;
            List<Element> cellElements = rowElement.select("th,td");
            List<String> dataArray = new ArrayList<>();
            for (Element cellElement: cellElements) {
                dataArray.add(cellElement.text());
                TableCellData data = extractFromElement(cellElement);

                int d = 1;
                boolean added = false;
                while(!added) {
                    String columnName = (d == 1) ? columnNames.get(columnIndex) : columnNames.get(columnIndex) + d;

                    if(row.containsKey(columnName)) {
                        d++;
                        continue;
                    } else {
                        row.put(columnName, data);
                        added = true;
                    }
                }
                columnIndex++;
            }
            LOG.debug(dataArray);

            boolean addRow = false;
            for(Map.Entry<String, TableCellData> entry : row.entrySet()) {
                if(entry.getValue() != null && !entry.getValue().getData().trim().isEmpty()) {
                    addRow = true;
                }
            }

            if(addRow) userTable.add(row);
        }
        return userTable;
    }

    public static TableCellData extractFromElement(Element element) {
        Element a = element.select("a").first();

        if(a == null) {
            return new TableCellData(element.text());
        } else {
            return new LinkTableCellData(element.text(), a.attr("href"));
        }
    }

    public static String getStringFromEntity(HttpEntity entity) {
        InputStream is;
        try {
            is = entity.getContent();
        } catch (IOException e) {
            System.err.println("Error" + e.getMessage());
            return null;
        }
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        StringBuilder s = new StringBuilder();
        String line;
        try {
            while((line = br.readLine()) != null) {
                s.append(line);
            }
        } catch (IOException e) {
            System.err.println("Error" + e.getMessage());
            return s.toString();
        }
        return s.toString();
    }

}
