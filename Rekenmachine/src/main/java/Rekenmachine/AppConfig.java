package Rekenmachine;
import Rekenmachine.Beans.Infix;
import Rekenmachine.Beans.Postfix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

        @Bean
        public InputReader inputReader() {
                return new InputReader();
        }

        @Bean
        public Postfix postfix() {
                return new Postfix();
        }

        @Bean
        public Infix infix() {
                return new Infix();
        }

        @Bean
        public ProfileHandler profileHandler() {
                return new ProfileHandler();
        }
}
