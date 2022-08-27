package task1;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[][] ints = IntStream.range(0, 5).mapToObj(i -> new Random().ints(2, 0, 100).toArray()).toArray(int[][]::new);
        findMaxMinAverage(ints);

        int[][] test1 = new int[][]{{3, 3, 3}, {3, 3, 3}};
        System.out.println("\nТест 1 - 3, 3, 3.0");
        findMaxMinAverage(test1);


        int[][] test2 = new int[1][1];
        System.out.println("\nТест 2 - 0, 0, 0.0");
        findMaxMinAverage(test2);


        int[][] test3 = new int[][]{{1, 2}, {3, 4}};
        System.out.println("\nТест 3 - 4, 1, 2.5");
        findMaxMinAverage(test3);


    }

    static void findMaxMinAverage(int[][] ints) {
        int min = ints[0][0];
        int max = ints[0][0];
        int sum = 0;
        System.out.println("Исходный массив: " + Arrays.deepToString(ints));

        for (int[] i : ints) {
            for (int j : i) {
                sum += j;
                if (min > j)
                    min = j;
                if (max < j)
                    max = j;
            }
        }

        System.out.println("Максимальное значение = " + max);
        System.out.println("Минимальное значение = " + min);
        System.out.println("Среднее значение = " + (double) sum / (ints[0].length * ints.length));
    }
}

