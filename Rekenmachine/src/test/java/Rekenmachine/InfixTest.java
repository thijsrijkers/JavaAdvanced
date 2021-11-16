package Rekenmachine;

import Rekenmachine.Beans.Infix;
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
        this.infix = new Infix();
    }

    @Test
    @DisplayName("Error testing of the calculate method in the Infix class")
    void testingInfixError() {
        assertThrows(NumberFormatException.class, () -> {
            infix.calculate("+++1+++");
        });
    }

    @Test
    @DisplayName("Giving Infix correct add calculation to return a double")
    void testingInfixAddResponse() {
        assertEquals(2.0, infix.calculate("1 + 1"));
    }

    @Test
    @DisplayName("Giving Infix correct multiple calculation to return a double")
    void testingInfixMultipleResponse() {
        assertEquals(1.0, infix.calculate("1 * 1"));
    }

    @Test
    @DisplayName("Giving Infix correct minus calculation to return a double")
    void testingInfixMinusResponse() {
        assertEquals(1.0, infix.calculate("2 - 1"));
    }

    @Test
    @DisplayName("Giving Infix correct divide calculation to return a double")
    void testingInfixDivideResponse() {
        assertEquals(2.0, infix.calculate("4 / 2"));
    }

}
