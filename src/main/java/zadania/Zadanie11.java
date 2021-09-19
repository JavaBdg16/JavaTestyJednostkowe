package zadania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadanie11 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Podaj liczbę w postaci szesnastkowej");
        String number = reader.readLine();

        System.out.println("Postać binarna liczby " + number + " to " + convertHexadecimalToBinary(number));
    }

    private static String convertHexadecimalToBinary(String number) {

        number = number.toUpperCase();
        String binary = "";

        // 2A5

        // 2 - A - 5
        // 2 - 10 - 5

        // krok 1 - 5 zamieniamy na binary (4 bity)
        // 5_(10) = 101_(2) -> 0101_(2)

        // krok 2 - 10 zamieniamy na binary (4 bity)
        // 10_(10) = 1010_(2)

        // krok 3 = 2 zamieniamy na binary (4 bity)
        // 2_(10) = 10_(2) -> 0010_(2)

        for (int i = number.length() - 1; i >= 0; i--) {
            int decimal = convertHexadecimalToDecimal(number.charAt(i));
            String partBinary = convertDecimalToBinaryUsingBaseTab(decimal);
            binary = partBinary + binary;
        }

        while (binary.charAt(0) == '0') {
            binary = binary.substring(1);
        }

        return binary;
    }

    private static int convertHexadecimalToDecimal(char number) {

        switch (number) {
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            case 'A': return 10;
            case 'B': return 11;
            case 'C': return 12;
            case 'D': return 13;
            case 'E': return 14;
            case 'F': return 15;
            default: return -1;
        }
    }

    private static String convertDecimalToBinaryUsingBaseTab(int number) {

        String binary = "";
        String[] base = { "0", "1" };

        while (number != 0) {
            int r = number % base.length;
            binary = base[r] + binary;
            number /= base.length;
        }

        while (binary.length() != 4) {
            binary = "0" + binary;
        }

        return binary;
    }
}
