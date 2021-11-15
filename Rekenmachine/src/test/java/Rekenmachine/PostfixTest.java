package Rekenmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class PostfixTest {
    Postfix postfix;

    @BeforeEach
    void setUp() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        this.postfix = context.getBean(Postfix.class);
    }

    @Test
    @DisplayName("Error testing of the calculate method in the Postfix class")
    void testingPostfixError() throws EmptyStackException {
        assertThrows(EmptyStackException.class, () -> {
            postfix.calculate("0+---1");
        });
    }

    @Test
    @DisplayName("Giving Postfix correct calculation to return a int")
    void testingPostfixResponse() {
        assertEquals(1, postfix.calculate("823*+7/1-"));
    }


    @Test
    @DisplayName("Giving Postfix correct add calculation to return a int")
    void testingPostfixAddResponse() {
        assertEquals(2, postfix.calculate("11+"));
    }

    @Test
    @DisplayName("Giving Postfix correct multiple calculation to return a int")
    void testingPostfixMultipleResponse() {
        assertEquals(1, postfix.calculate("11*"));
    }

    @Test
    @DisplayName("Giving Postfix correct minus calculation to return a int")
    void testingPostfixMinusResponse() {
        assertEquals(1, postfix.calculate("21-"));
    }

    @Test
    @DisplayName("Giving Postfix correct divide calculation to return a int")
    void testingPostfixDivideResponse() {
        assertEquals(2, postfix.calculate("42/"));
    }

}
