package net.sectorbob.football.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by ltm688 on 9/29/16.
 */
@Component
@ConfigurationProperties(prefix="net.sectorbob.fantasy.phantomjs")
public class PhantomJsProperties {

    private String driverPath;

    public String getDriverPath() {
        return driverPath;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }
}
