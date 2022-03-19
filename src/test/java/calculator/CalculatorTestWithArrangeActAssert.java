package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTestWithArrangeActAssert {

    @Test
    public void calculatorAddTest() {

        // Arrange
        Calculator calculator = new Calculator(2, 3);

        // Act
        int result = calculator.add();

        // Assert
        Assertions.assertEquals(5, result);
    }

    @Test
    public void when_adding_two_ints_then_correct_result() {

    }
}
