package zadania;

public class Zadanie18 {

    public static void main(String[] args) {
        int amount = 0;
        int count = 0;
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 4; j++) {
                if (i == j) {
                    count++;
                    continue;
                }
                for (int k = 1; k <= 4; k++) {
                    if (j == k || k == i) {
                        count++;
                        continue;
                    }
                    amount++;
                    System.out.printf("%d%d%d\n", i, j, k);
                    count++;
                }
            }
        }

        System.out.println("Ilość liczb: " + amount);
        System.out.println("Ilość kroków: " + count);
    }
}
