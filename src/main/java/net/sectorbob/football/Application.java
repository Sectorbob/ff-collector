package net.sectorbob.football;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by ltm688 on 9/17/16.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        System.setProperty("https.protocols", "TLSv1.2,TLSv1.1,TLSv1");

        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
