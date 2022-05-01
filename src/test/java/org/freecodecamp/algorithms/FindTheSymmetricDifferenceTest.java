package org.freecodecamp.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FindTheSymmetricDifferenceTest {
    int[][][] args = new int[][][]{
            {{1, 2, 3}, {5, 2, 1, 4},}
            , {{1, 2, 3, 3}, {5, 2, 1, 4}}
            , {{1, 2, 3}, {5, 2, 1, 4, 5}}
            , {{1, 2, 5}, {2, 3, 5}, {3, 4, 5}}
            , {{1, 1, 2, 5}, {2, 2, 3, 5}, {3, 4, 5, 5}}
            , {{3, 3, 3, 2, 5}, {2, 1, 5, 7}, {3, 4, 6, 6}, {1, 2, 3}}
            , {{3, 3, 3, 2, 5}, {2, 1, 5, 7}, {3, 4, 6, 6}, {1, 2, 3}, {5, 3, 9, 8}, {1}}
    };
    int[][] result = new int[][]{
            {3, 4, 5}
            , {3, 4, 5}
            , {3, 4, 5}
            , {1, 4, 5}
            , {1, 4, 5}
            , {2, 3, 4, 6, 7}
            , {1, 2, 4, 5, 6, 7, 8, 9}
    };
    FindTheSymmetricDifference a = new FindTheSymmetricDifference();

    @Test
    void sym1() {
        for (int i = 0; i < args.length; i++) {
            int[] r = a.sym1(args[i]);
            assertArrayEquals(r, result[i]);
            assertEquals(r.length, result[i].length);
        }

    }

    @Test
    void sym2() {
        for (int i = 0; i < args.length; i++) {
            int[] r = a.sym2(args[i]);
            assertArrayEquals(r, result[i]);
            assertEquals(r.length, result[i].length);
        }
    }

    @Test
    void sym3() {
        for (int i = 0; i < args.length; i++) {
            int[] r = a.sym3(args[i]);
            assertArrayEquals(r, result[i]);
            assertEquals(r.length, result[i].length);
        }
    }

}