package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void addTestEmptyEntery(){
        Calculator calculator = new Calculator();
        String numbers = "";

        var actual = calculator.add(numbers);

        assertEquals(0,actual);
    }

    @Test
    void addTestOneEntery(){
        Calculator calculator = new Calculator();
        String numbers = "1";

        var actual = calculator.add(numbers);

        assertEquals(1,actual);
    }
    @Test
    void addTestTwoEntery(){
        Calculator calculator = new Calculator();
        String numbers = "1,2";

        var actual = calculator.add(numbers);

        assertEquals(3,actual);
    }
}