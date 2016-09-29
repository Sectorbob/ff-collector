package net.sectorbob.football.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ltm688 on 9/29/16.
 */
public class WeekTiming {

    private static Logger LOG = LoggerFactory.getLogger(WeekTiming.class);
    static long weekDuration = 1000*60*60*24*7;
    //long week1Start = 1473350400000L; //thu at noon
    static long week1Start = 1473177600000L; //tue at noo

    public static int getCurrentWeek() {
        return getWeekForDate(new Date());
    }

    public static int getWeekForDate(Date date) {
        long dateInMillis = date.getTime();

        long weekStart = week1Start;
        long weekEnd = weekStart + weekDuration;
        for(int i = 1; i <= 17; i++) {
            if(dateInMillis >= weekStart && dateInMillis < weekEnd) {
                return i;
            } else {
                weekStart = weekEnd;
                weekEnd = weekStart + weekDuration;
            }
        }
        return 0;

    }

    public static int weekOfYahooDate(String dateString) throws ParseException {
        Date yahooDate = yahooDate(dateString);
        return getWeekForDate(yahooDate);
    }

    public static Date yahooDate(String dateString) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
        return df.parse(dateString);
    }

}
