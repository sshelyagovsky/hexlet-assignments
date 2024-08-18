package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;
import java.time.LocalDateTime;


// BEGIN
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Scope("prototype")
    @Bean
    public Daytime daytime() {
        var currentTimeHour = LocalDateTime.now().getHour();
        if (currentTimeHour >= 6 && currentTimeHour <= 22) {
            return new Day();
        }

        return new Night();
    }
    // END
}
