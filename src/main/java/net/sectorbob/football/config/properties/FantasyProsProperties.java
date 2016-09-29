package net.sectorbob.football.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by ltm688 on 9/29/16.
 */
@Component
@ConfigurationProperties(prefix="net.sectorbob.fantasy.football.fantasypros")
public class FantasyProsProperties {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
