package zadania;

import java.util.Arrays;

public class Zadanie21 {
    public static void main(String[] args) {

        int[] arrayNums = {0,0,1,0,3,0,5,0,6};

        zeraNaKoniec(new int[] {0,0,1,0,3,0,5,0,6});
        System.out.println();
        niezeroweNaPoczatek(new int[] {0,0,1,0,3,0,5,0,6});
    }

    static void niezeroweNaPoczatek(int[] arrayNums) {
        int i = 0;
        for(int j = 0, l = arrayNums.length; j < l;) {
            if (arrayNums[j] == 0) {
                j++;
            } else {
                int temp = arrayNums[i];
                arrayNums[i] = arrayNums[j];
                arrayNums[j] = temp;
                i++;
                j++;
            }
        }
        while (i < arrayNums.length) {
            arrayNums[i++] = 0;
        }

        System.out.print("After moving 0's to the end of the array: " + Arrays.toString(arrayNums));
    }

    static void zeraNaKoniec(int[] arrayNums) {
        int i = 0;
        int indexEnd = arrayNums.length - 1;

        System.out.println("Original Array : " + Arrays.toString(arrayNums));

        while (i <= indexEnd) {
            if (arrayNums[i] != 0) {
                i++;
            } else {
                int temp = arrayNums[i];
                arrayNums[i] = arrayNums[indexEnd];
                arrayNums[indexEnd] = temp;

                indexEnd--;
            }
        }

        System.out.print("After moving 0's to the end of the array: " + Arrays.toString(arrayNums));
    }
}

