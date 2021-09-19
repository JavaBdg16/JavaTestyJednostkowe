package calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static company.JunitCustomAssertions.assertSomething;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("After All");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before each");
        calculator = new Calculator(2, 2);
    }

    @AfterEach
    public void afterEach() {
        System.out.println("After each");
    }

    @Test
    @DisplayName("test dodawania")
    public void addTest() {
        int result = calculator.add();
        assertEquals(4, result);

        calculator.setB(3);
        result = calculator.add();
        assertNotEquals(4, result);
    }

    @Test
    public void minusTest() {
        int result = calculator.minus();

        assertEquals(0, result);
    }

    @Nested
    public class NestedCalculatorTest {

        @Test
        public void testSomething() {
            assertSomething(false);
        }
    }
}
