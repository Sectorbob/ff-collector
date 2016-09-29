package net.sectorbob.football.logic;

import java.text.ParseException;

/**
 * Created by ltm688 on 9/29/16.
 */

public class WeekTimingTest {

    public static void main(String... args) throws ParseException {

        System.out.println("Current Week:" + WeekTiming.getCurrentWeek());
        System.out.println(WeekTiming.weekOfYahooDate("Mon, 26 Sep 2016 17:30:00 -0700"));
        System.out.println(WeekTiming.weekOfYahooDate("Sun, 2 Oct 2016 10:00:00 -0700"));
    }

}
