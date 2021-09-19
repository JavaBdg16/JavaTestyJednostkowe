package zadania;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberFormatParserTests {

    @Test
    public void shouldTakeDecimalNumber() {

        NumberFormatParser numberFormatParser = new NumberFormatParser();

        assertThrows(NumberFormatException.class,
                () -> numberFormatParser.convertDecimalToBinary("ABC"));
    }

    @Test
    public void shouldReturnBinaryNumber() {
        NumberFormatParser numberFormatParser = new NumberFormatParser();
        String result = numberFormatParser.convertDecimalToBinary("3");

        assertFalse(result.contains("2"));
        assertFalse(result.contains("3"));
        assertFalse(result.contains("4"));
        assertFalse(result.contains("5"));
        assertFalse(result.contains("6"));
        assertFalse(result.contains("7"));
        assertFalse(result.contains("8"));
        assertFalse(result.contains("9"));
    }

    @Test
    public void shouldReturnCorrectValue() {
        NumberFormatParser numberFormatParser = new NumberFormatParser();
        String result = numberFormatParser.convertDecimalToBinary("3");

        assertEquals("11", result);
    }
}
