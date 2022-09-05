package task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arraySort = new int[]{5, 6, 3, 2, 5, 1, 4, 9};
        int temp;
        System.out.println("\nНеотсортированный массив: " + Arrays.toString(arraySort));

        for (int i = 0; i < arraySort.length; i++) {
            for (int j = 0; j < arraySort.length; j++) {
                temp = arraySort[j];
                if (arraySort[j] > arraySort[i]) {
                    arraySort[j] = arraySort[i];
                    arraySort[i] = temp;
                }
            }
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(arraySort));
    }
}

