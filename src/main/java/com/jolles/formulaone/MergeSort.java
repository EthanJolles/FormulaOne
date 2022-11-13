package com.jolles.formulaone;

// The memory/space complexity of Merge Sort is O(n) for meaning it is linear related to the size of the array
// The time complexity of Merge Sort is O(nlog(n))
public class MergeSort {

    private MergeSort() {

    }

    private static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int num1 = m - l + 1;
        int num2 = r - m;

        /* Create temp arrays */
        int left[] = new int[num1];
        int right[] = new int[num2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < num1; ++i)
            left[i] = arr[l + i];
        for (int j = 0; j < num2; ++j)
            right[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < num1 && j < num2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < num1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < num2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
