package org.freecodecamp.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortTest {

    @Test
    void bubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] a = bubbleSort.bubbleSort(new int[]{1, 4, 2, 8, 345, 123, 43, 32, 5643, 63, 123, 43, 2, 55, 1, 234, 92});
        assertArrayEquals(new int[]{1, 1, 2, 2, 4, 8, 32, 43, 43, 55, 63, 92, 123, 123, 234, 345, 5643}, a);
    }
}