package Rekenmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

public class InfixTest {
    Infix infix;

    @BeforeEach
    void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        this.infix = context.getBean(Infix.class);
    }

    @Test
    @DisplayName("Error testing of the calculate method in the Infix class")
    void testingInfixError() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            infix.calculate("+++1+++");
        });

        String expectedMessage = "For input string";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Giving Infix correct calculation to return a double")
    void testingInfixResponse() {
        assertEquals(2.0, infix.calculate("1+1"));
    }

}
