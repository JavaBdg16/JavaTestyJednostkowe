package zadania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zadanie1 {



    /**
     * Metoda zamienia liczbę w postaci dzisiętnej do postaci binarnej
     * @param number liczba dziesiętna
     * @return liczba binarna
     */
    private static int convertDecimalToBinary(int number) {

        // dziesiatka = 1
        // binary = 0
        // [_, _, _, ..., _]
        // 12
        // 12 mod 2 = 6 r 0
        // [_, _, _, ..., 0] binary = binary + r * dziesiatka = 0
        // 12 -> 6
        // dziesiatka = dziesiatka * 10

        // 6 mod 2 = 3 r 0
        // [_, _, _, ..., 0, 0] binary = binary + r * dziesiatka = 00 = 0
        // 6 -> 3
        // dziesiatka = dziesiatka * 10

        // 3 mod 2 = 1 r 1
        // [_, _, _, ..., 1, 0, 0] binary = binary + r * dziesiatka = 100
        // 3 -> 1
        // dziesiatka = dziesiatka * 10

        // 1 mod 2 = 0 r 1
        // [_, _, _, ..., 1, 1, 0, 0] binary = binary + r * dziesiatka = 1100
        // 1 -> 0

        int binary = 0;
        int byteNumber = 0;

        while (number != 0) {
            int r = number % 2;
            number /= 2;

            binary += Math.pow(10, byteNumber) * r;
            byteNumber++;
        }

        return binary;
    }

    private static String convertDecimalToBinaryUsingString(int number) {

        String binary = "";

        while (number != 0) {
            int r = number % 2;
            number /= 2;

            binary = r + binary;
        }

        return binary;
    }

    private static String convertDecimalToBinaryUsingBaseTab(int number) {

        String binary = "";
        String[] base = { "0", "1" };

        // 29

        // hexa = ""

        // 29 mod 2 = 14 r 1
        // hexa = r + hexa = ([1] = 1) + "" = "1"
        // 29 -> 14

        // 14 mod 2 = 7 r 0
        // hexa = r + hexa = ([0] = 0) + "1" = "01"
        // 14 -> 7

        // 7 mod 2 = 3 r 1
        // hexa = r + hexa = ([1] = 1) + "01" = "101"
        // 7 -> 3

        // 3 mod 2 = 1 r 1
        // hexa = r + hexa = ([1] = 1) + "101" = "1101"
        // 3 -> 1

        // 1 mod 2 = 0 r 1
        // hexa = r + hexa = ([1] = 1) + "1101" = "11101"
        // 1 -> 0

        while (number != 0) {
            int r = number % base.length;
            binary = base[r] + binary;
            number /= base.length;
        }

        return binary;
    }
}
