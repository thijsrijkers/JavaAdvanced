package Rekenmachine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class AppConfig {

        @Bean
        public InputReader inputReader() {
                return new InputReader();
        }

        @Bean
        @Profile("postfix")
        public Postfix postfix() {
                return new Postfix();
        }

        @Bean
        @Profile("infix")
        public Infix infix() {
                return new Infix();
        }
}
