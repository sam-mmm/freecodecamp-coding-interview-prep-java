package org.freecodecamp.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PairwiseTest {

    @Test
    void pairwise() {
        Pairwise pairwise = new Pairwise();
//        pairwise([1, 4, 2, 3, 0, 5], 7) should return 11.
        assertEquals(11, pairwise.pairwise(new int[]{1, 4, 2, 3, 0, 5}, 7));
//        pairwise([1, 3, 2, 4], 4) should return 1.
        assertEquals(1, pairwise.pairwise(new int[]{1, 3, 2, 4}, 4));
//        pairwise([1, 1, 1], 2) should return 1.
        assertEquals(1, pairwise.pairwise(new int[]{1, 3, 2, 4}, 4));
//        pairwise([0, 0, 0, 0, 1, 1], 1) should return 10.
        assertEquals(10, pairwise.pairwise(new int[]{0, 0, 0, 0, 1, 1}, 1));
//        pairwise([], 100) should return 0.
        assertEquals(0, pairwise.pairwise(new int[]{}, 100));

    }
}