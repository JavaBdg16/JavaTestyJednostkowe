package zadania;

public class NumberFormatParser {

    public String convertDecimalToBinary(String str) {

        String binary = "";
        int number = Integer.parseInt(str);

        while (number != 0) {
            int r = number % 2;
            number /= 2;

            binary = r + binary;
        }

        return binary;
    }
}
