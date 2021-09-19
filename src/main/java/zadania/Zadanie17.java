package zadania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zadanie17 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Podaj tekst");
        String text = reader.readLine();

        // System.out.println("Litery: " + count("Ala ma kota, kot ma Ale.", "[a-zA-ZąĄęĘćĆłŁóÓżŻźŹ]"));

        int litery = 0;
        int cyfry = 0;
        int spacje = 0;
        int inne = 0;

        String alphabetic = "abcdefghijklmnop";

        for (char c : text.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                litery++;
            } else if (Character.isSpaceChar(c)) {
                spacje++;
            } else if (Character.isDigit(c)) {
                cyfry++;
            } else {
                inne++;
            }
        }

        System.out.printf("litery: %d\ncyfry: %d\nspacje: %d\ninne: %d", litery, cyfry, spacje, inne);
    }
    private static int count(String text, String regex) {

        Matcher matcher = Pattern.compile(regex).matcher(text);
        int res = 0;

        while (matcher.find()) {
            res++;
        }

        return res;
    }
}
