package org.freecodecamp.algorithms;

public class MergeSort {
    public int[] mergeSort(int[] array) {
        // Only change code below this line
        sort(array, 0, array.length - 1);
        return array;
        // Only change code above this line
    }


    private void merge(int[] arr, int beg, int mid, int end) {
        int l = mid - beg + 1;
        int r = end - mid;
        int[] leftArray = new int[l];
        int[] rightArray = new int[r];
        System.arraycopy(arr, beg, leftArray, 0, l);
        System.arraycopy(arr, mid + 1, rightArray, 0, r);
        int i = 0, j = 0;
        int k = beg;
        while (i < l && j < r) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < l) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < r) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private void sort(int[] arr, int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            sort(arr, beg, mid);
            sort(arr, mid + 1, end);
            merge(arr, beg, mid, end);
        }
    }

}
