package org.freecodecamp.algorithms;

public class SelectionSort {
    public int[] selectionSort(int[] array) {
        // Only change code below this line
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) min = j;
            }
            swap(i, min, array);
        }
        return array;
        // Only change code above this line
    }

    private void swap(int index1, int index2, int[] arr) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
