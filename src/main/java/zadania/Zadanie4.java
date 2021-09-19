package zadania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadanie4 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Podaj liczbę w postaci binarnej");
        String number = reader.readLine();

        System.out.println("Postać binarna liczby " + number + " to " + convertBinaryToDecimal(Integer.parseInt(number)));
        System.out.println("Postać binarna liczby " + number + " to " + convertBinaryToDecimal(number));
    }

    private static int convertBinaryToDecimal(int number) {

        // liczba = 0
        // potega = 0
        // 1010

        // 1010 mod 10 = 101 r 0
        // liczba = liczba + r * 2^potega = 0
        // potega = potega + 1 = 1
        // 1010 -> 101

        // 101 mod 10 = 10 r 1
        // liczba = liczba + r * 2^potega = 0 + 1 * 2^1 = 2
        // potega = potega + 1 = 2
        // 101 -> 10

        // 10 mod 10 = 1 r 0
        // liczba = liczba + r * 2^potega = 2 + 0 * 2^2 = 2
        // potega = potega + 1 = 3
        // 10 -> 1

        // 1 mod 10 = 0 r 1
        // liczba = liczba + r * 2^potega = 2 + 1 * 2^3 = 10
        // potega = potega + 1 = 4
        // 1 -> 0

        int liczba = 0;
        int potega = 0;

        while (number != 0) {
            int r = number % 10;
            liczba = liczba + r * (int)Math.pow(2, potega++);
            number /= 10;
        }

        return liczba;
    }

    private static int convertBinaryToDecimal(String number) {

        // 1010
        int potega = 0;
        int liczba = 0;

        for (int i = number.length() - 1; i >= 0; i--) {
            int value = Character.getNumericValue(number.charAt(i));
            liczba += value * (int)Math.pow(2, potega++);
        }

        return liczba;
    }
}
