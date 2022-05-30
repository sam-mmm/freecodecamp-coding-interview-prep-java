package org.freecodecamp.algorithms;

public class QuickSort {
    public int[] quickSort(int[] array, int left, int right) {
        // Only change code below this line
        if (left < right) {
            int pivotIndex = pivot(array, left, right);

            //Recusrively calling the function to the left of the pivot and to the right of the pivot
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
        return array;
        // Only change code above this line
    }

    private int pivot(int[] arr, int left, int right) {
        int shift = left;
        for (int i = left + 1; i <= right; i++) {
            //Move all the small elements on the left side
            if (arr[i] < arr[left]) swap(i, ++shift, arr);
        }

        //Finally swapping the last element with the left
        swap(left, shift, arr);
        return shift;
    }

    private void swap(int index1, int index2, int[] arr) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
