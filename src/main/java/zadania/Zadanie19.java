package zadania;

import java.util.Arrays;

public class Zadanie19 {

    public static void main(String[] args)
    {
        uniqueArray(new int[] {0, 3, -2, 4, 3, 2});
        uniqueArray(new int[] {10, 22, 10, 20, 11, 22});
    }

    private static void uniqueArray(int[] myArray)
    {
        System.out.println("Original Array : " + Arrays.toString(myArray));

        // Zakładamy, że wszystkie elementy tablicy są unikalne
        int noUniqueElements = myArray.length;

        // Porównuję wszystkie elementy tablicy
        for (int i = 0; i < noUniqueElements; i++) {
            for (int j = i+1; j < noUniqueElements; j++) {

                // jeśli znalazłem dwa takie same elementy tablicy
                if(myArray[i] == myArray[j]) {

                    // zastępuję duplikat z ostatnim znanym unikalnym elementem tablicy
                    myArray[j] = myArray[noUniqueElements-1];
                    noUniqueElements--;
                    j--;
                }
            }
        }

        // Kopiuję unikalne elementy tablicy do nowej tablicy
        int[] array1 = Arrays.copyOf(myArray, noUniqueElements);

        //Printing arrayWithoutDuplicates
        System.out.println("Array with unique values : " + Arrays.toString(array1));
        System.out.println();
    }
}

