package org.freecodecamp.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BinarySearchTest {

    @Test
    void binarySearch() {
        int[] testArray = new int[]{
                0, 1, 2, 3, 4, 5, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,
                23, 49, 70};
        BinarySearch binarySearch = new BinarySearch();
        assertArrayEquals(new int[]{13, 5, 2, 0}, binarySearch.binarySearch(testArray, 0));
        assertArrayEquals(new int[]{13, 5, 2, 0, 1}, binarySearch.binarySearch(testArray, 1));
        assertArrayEquals(new int[]{13, 5, 2}, binarySearch.binarySearch(testArray, 2));
        assertArrayEquals(new int[]{13, 5, 2, 0, 1}, binarySearch.binarySearch(testArray, 1));
        assertArrayEquals(new int[]{13, 5, 10, 11}, binarySearch.binarySearch(testArray, 11));
        assertArrayEquals(new int[]{13}, binarySearch.binarySearch(testArray, 13));
        assertArrayEquals(new int[]{13, 19, 22, 49, 70}, binarySearch.binarySearch(testArray, 70));
    }
}