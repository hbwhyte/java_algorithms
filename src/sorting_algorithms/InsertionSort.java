package sorting_algorithms;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{23, 12, 1, -4, 400, 55, -22, 168};
        System.out.println("Unsorted array is: " + Arrays.toString(arr));
        long nanoTime = insertionSort(arr);
        System.out.println("The search took " + nanoTime + " nanoseconds.");
        System.out.println("Array after insertion sort is: " + Arrays.toString(arr));
    }
    static long insertionSort(int[] arr) {
        long start = System.nanoTime();

        for (int i = 1; i < arr.length; i++) {
            int t = arr[i];
            int j = i-1;
            while ((j >= 0) && (arr[j] > t)) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = t;
        }

        long finish = System.nanoTime();
        long nanoTime = finish-start;
        return nanoTime;
    }
}
