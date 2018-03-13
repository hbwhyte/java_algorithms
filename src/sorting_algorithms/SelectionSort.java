package sorting_algorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{23, 12, 1, -4, 400, 55, -22, 168};
        System.out.println("Unsorted array is: " + Arrays.toString(arr));
        selectionSort(arr);
        System.out.println("Array after selection sort is: " + Arrays.toString(arr));
    }

    static void selectionSort(int[] arr){

        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int minVal = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = minVal;
        }
    }
}
