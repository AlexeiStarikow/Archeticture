package test.java.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator Tests")
public class CalculatorTestThree {
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("Тест на сложение")
    public void testAddition() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    @DisplayName("Subtraction test")
    public void testSubtraction() {
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    @DisplayName("Multiplication test")
    public void testMultiplication() {
        assertEquals(15, calculator.multiply(5, 3));
    }

    @Test
    @DisplayName("Division test")
    public void testDivision() {
        assertEquals(2, calculator.divide(6, 3));
    }

    @Test
    @DisplayName("Division by zero test")
    public void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(6, 0));
    }
}
