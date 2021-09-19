package zadania;

import java.util.Arrays;

public class Zadanie25 {

    public static void main(String[] args) {
        int[] tab = { 54, 26, 93, 17, 77, 31, 44, 55, 20 };
        System.out.println(Arrays.toString(sort(tab)));

        int[] tab2 = { 93, 77, 55, 54, 44, 31, 26, 20, 17 };
        System.out.println(Arrays.toString(sort(tab2)));
    }

    static int[] sort(int[] tab) {

        int count = 0;
        for (int i = 1; i < tab.length; i++) {

            System.out.println(Arrays.toString((tab)));

            int j = i;
            int value = tab[j];

            while (j > 0 && tab[j - 1] > value) {
                swap(tab, j, j - 1);
                j--;
                count++;
            }


        }

        System.out.println(count);
        return tab;
    }

    static void swap(int[] tab, int i, int j) {
        int buff = tab[j];
        tab[j] = tab[i];
        tab[i] = buff;
    }
}
