package zadania;

import java.util.Arrays;

public class Zadanie26 {

    public static void main(String[] args) {
        int[] tab = { 54, 26, 93, 17, 77, 31, 44, 55, 20 };
        // System.out.println(Arrays.toString(sort(tab)));

        int[] tab2 = { 93, 77, 55, 54, 44, 31, 26, 20, 17 };
        System.out.println(Arrays.toString(sort(tab2)));
    }

    private static int[] sort(int[] tab) {

        for (int i = 0; i < tab.length - 1; i++) {

            System.out.println(Arrays.toString(tab));

            for (int j = 0; j < tab.length - i - 1; j++) {
                if (tab[j] > tab[j + 1]) {
                    swap(tab, j, j + 1);
                }
            }
        }

        return tab;
    }

    static void swap(int[] tab, int i, int j) {
        int buff = tab[j];
        tab[j] = tab[i];
        tab[i] = buff;
    }
}
