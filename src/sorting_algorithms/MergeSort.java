package sorting_algorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{23, 12, 1, -4, 400, 55, -22, 168};
        System.out.println("Unsorted array is: " + Arrays.toString(arr));

        MergeSort obj = new MergeSort();
        obj.mergeSort(arr, 0, arr.length-1);
        System.out.println("Array after merge sort is: " + Arrays.toString(arr));

    }

    void mergeSort(int[] arr, int a, int z) {
        if (a < z) {
            int m = (a + z) / 2;
            mergeSort(arr, a, m);
            mergeSort(arr, m + 1, z);
            merge(arr, a, m, z);
        }
    }

    void merge(int[] arr, int a, int m, int z) {
        int arrSize1 = m - a + 1;
        int arrSize2 = z - m;

        int[] arr1 = new int[arrSize1];
        int[] arr2 = new int[arrSize2];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[a+i];
        }

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = arr[m+1+i];
        }

        int i = 0, j = 0;
        int k = a;

        while ((i < arrSize1) && (j < arrSize2)) {
            if(arr1[i] <= arr2[j])
            {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < arrSize1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < arrSize2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }
}