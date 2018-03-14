package sorting_algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{23, 12, 1, -4, 400, 55, -22, 168};
        System.out.println("Unsorted array is: " + Arrays.toString(arr));

        QuickSort obj = new QuickSort();
        obj.quickSort(arr, 0, arr.length - 1);
        System.out.println("Array after quick sort is: " + Arrays.toString(arr));
    }

    /**
     * {@code quicksort()} is a recursive method that keeps partitioning and sorting itself until all elements
     * are sorted.
     *
     * @param arr is the original array to be sorted.
     * @param a the starting index of the sort. Default for completely sorting a collection: a = 0
     * @param z the last index of the sort. Default for completely sorting a collection: z = arr.length -1
     */
    void quickSort(int[] arr, int a, int z) {
        // if a = z, recursion is complete and method exits
        if (a < z) {
            int pIndex = partition(arr, a, z);
            quickSort(arr, a, pIndex - 1);
            quickSort(arr, pIndex + 1, z);
        }
    }

    /**
     * {@code partition()} splits the array based on the pivot. If the element is lower, it gets sorted with
     * below the pivot, if it is high, it is sorted above the pivot. By the end of one loop, the pivot should
     * be in its true location.
     *
     * @param arr is the partitioned array, taken from quickSort()
     * @param a the starting index of the partitioned array, taken from quickSort()
     * @param z the last index of the partitioned array, taken from quickSort()
     * @returns returns a new partition index to iterate through the next split and sort
     */
    int partition(int[] arr, int a, int z) {
        int pivot = arr[z];
        int i = a - 1;
        for (int j = a; j < z; j++) {
            // if arr[j] is less than the pivot, swap arr[j] and arr[i]
            // the moves arr[j] to the lower half of the collection
            if (arr[j] <= pivot) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        // after one iteration swap the last value, arr[z], with the next iteration, arr[i + 1].
        int t = arr[z];
        arr[z] = arr[i + 1];
        arr[i + 1] = t;

        return i + 1;
    }

}
