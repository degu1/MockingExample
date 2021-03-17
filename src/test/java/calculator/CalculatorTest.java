package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/testDataAdd.csv")
   // @CsvSource({"1, 1", "2, 1,1"})
    void addTest(int expected, String str) {
        Calculator calculator = new Calculator();

        var actual = calculator.add(str);

        assertEquals(expected, actual);

    }
}