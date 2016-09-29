package net.sectorbob.football.client;

import net.sectorbob.football.config.properties.ProxyProperties;
import net.sectorbob.football.model.RotoGrindersVegasOddsRecord;
import net.sectorbob.football.model.Team;
import net.sectorbob.football.support.Row;
import net.sectorbob.football.support.Table;
import net.sectorbob.football.support.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kyle Heide
 */
@Component
public class RotoGrindersClient {

    private static String baseUrl = "http://rotogrinders.com/schedules/nfl";

    private DesiredCapabilities caps;

    public RotoGrindersClient(ProxyProperties proxyProperties) {

        ArrayList<String> phantomArgs = new ArrayList<>();
        phantomArgs.add("--webdriver-loglevel=NONE");

        caps = new DesiredCapabilities();
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                "/usr/local/Cellar/phantomjs/2.0.0/bin/phantomjs");

        // If the proxy is configured then set this up
        //if(proxyProperties.isEnabled()) {
        //    phantomArgs.add("--proxy="+proxyProperties.getHost()+":"+proxyProperties.getPort());
        //    phantomArgs.add("--proxy-type=" + proxyProperties.getScheme());
        //}

        caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);



    }

    public List<RotoGrindersVegasOddsRecord> getVegasLines() {
        String tableSelector = "#tschedules";
        String cellSelector = "#tschedules > tbody > tr:nth-child(3) > td.time > span";

        WebDriver driver = new PhantomJSDriver(caps);

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.get(baseUrl);

        driver.findElement(By.cssSelector(cellSelector));

        Table table = Util.webTableToListMapWithJsoup(driver.getPageSource(), tableSelector, 0, null);
        driver.quit();

        List<RotoGrindersVegasOddsRecord> vegasLines = new ArrayList<>();
        for(Row row : table) {
            RotoGrindersVegasOddsRecord rec =  new RotoGrindersVegasOddsRecord();

            rec.setTime(row.get("Time").getData());
            rec.setTeam(Team.fromString(row.get("Team").getData()));
            rec.setOpponent(Team.fromString(row.get("Opponent").getData().replace("@ ","").replace("vs. ","")));
            rec.setLine(tryParseDouble(row.get("Line").getData()));
            rec.setMoneyline(tryParseDouble(row.get("Moneyline").getData()));
            rec.setOverUnder(tryParseDouble(row.get("Over/Under").getData()));
            rec.setProjectedPoints(tryParseDouble(row.get("Projected Points").getData()));

            String tmp = row.get("Projected Points Change").getData().replace(" (show details)", "");
            if(tmp.contains("+")) {
                tmp.replace("+", "");
            }

            rec.setProjectedPointsChange(tryParseDouble(tmp));

            vegasLines.add(rec);
        }
        return vegasLines;
    }


    protected static Double tryParseDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
