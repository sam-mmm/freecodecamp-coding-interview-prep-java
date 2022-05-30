package org.freecodecamp.algorithms;

public class InsertionSort {
    public int[] insertionSort(int[] array) {
        // Only change code below this line
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];
            int j = i - 1;
            while (j >= 0 && curr <= array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = curr;
        }
        return array;
        // Only change code above this line
    }
}
