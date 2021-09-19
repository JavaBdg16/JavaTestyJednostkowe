package zadania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadanie3 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Podaj liczbę w postaci dziesiętnej");
        int number = Integer.parseInt(reader.readLine());

        System.out.println("Postać szesnastkowa liczby " + number + " to " + convertDecimalToHexadecimal(number));
    }

    private static String convertDecimalToHexadecimal(int number) {

        String[] base = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

        // 29

        // hexa = ""

        // 29 mod 16 = 1 r 13
        // hexa = r + hexa = ([13] = D) + "" = "D"
        // 29 -> 1

        // 1 mod 16 = 0 r 1
        // hexa = r + hexa = ([1] = 1) + "D" = "1D"
        // 1 -> 0

        String hexa = "";
        while (number != 0) {
            int r = number % base.length;
            hexa = base[r] + hexa;
            number /= base.length;
        }

        return hexa;
    }
}
