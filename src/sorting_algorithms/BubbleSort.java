package sorting_algorithms;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{23, 12, 1, -4, 400, 55, -22, 168};
        System.out.println("Unsorted array is :" + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Array after bubble sort is :" + Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = (arr.length-1); j >= i; j--) {
                if (arr[j - 1] > arr[j]) {
                    int t = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = t;
                }
            }
        }
    }
}