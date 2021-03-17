package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/testDataAdd.csv")
    void addTest(int expected, String str) {
        Calculator calculator = new Calculator();

        var actual = calculator.add(str);

        assertEquals(expected, actual);

    }

    @Test
    void addExeptionTest() {
        Calculator calculator = new Calculator();
        Throwable exeption = Assertions.assertThrows(NegativesNotAllowedRuntimeExeption.class, () -> calculator.add("-1"));
        assertTrue(exeption.getMessage().equals("[-1]"));
    }

    @Test
    void addExeptionTestTwoNegativeNumbers() {
        Calculator calculator = new Calculator();
        Throwable exeption = Assertions.assertThrows(NegativesNotAllowedRuntimeExeption.class, () -> calculator.add("-1,3,-4"));
        assertTrue(exeption.getMessage().equals("[-1, -4]"));
    }
}