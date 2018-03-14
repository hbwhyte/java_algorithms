package sorting_algorithms;

import java.util.Arrays;

public class ExchangeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{23, 12, 1, -4, 400, 55, -22, 168};
        System.out.println("Unsorted array is: " + Arrays.toString(arr));
        exchangeSort(arr);
        System.out.println("Array after exchange sort is: " + Arrays.toString(arr));
    }

    static void exchangeSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
    }

}


