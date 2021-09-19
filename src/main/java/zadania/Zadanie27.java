package zadania;

public class Zadanie27 {

    static boolean palindrom(String word) {

        // przypadek elementarny: słowo jest długości 1 lub 0
        // ścieżka pozytywna
        if (word.length() <= 1) return true;

        // ścieżka negatywna
        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }

        // przypadek złożony
        return palindrom(word.substring(1, word.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(palindrom("rower"));
    }
}
