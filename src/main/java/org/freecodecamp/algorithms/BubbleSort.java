package org.freecodecamp.algorithms;

public class BubbleSort {
    public int[] bubbleSort(int[] array) {
        // Only change code below this line
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1, array);
                }
            }
        }
        return array;
        // Only change code above this line
    }

    private void swap(int index1, int index2, int arr[]) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
