package org.freecodecamp.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NoRepeatsPleaseTest {

    @Test
    void permAlone() {
        NoRepeatsPlease a = new NoRepeatsPlease();
//        permAlone("aab") should return a number.
//        assertEquals(a.permAlone("aab"));
//                permAlone("aab") should return 2.
        assertEquals(a.permAlone("aab"), 2);
//        permAlone("aaa") should return 0.
        assertEquals(a.permAlone("aaa"), 0);
//        permAlone("aabb") should return 8.
        assertEquals(a.permAlone("aabb"), 8);
//        permAlone("abcdefa") should return 3600.
        assertEquals(a.permAlone("abcdefa"), 3600);
//        permAlone("abfdefa") should return 2640.
        assertEquals(a.permAlone("abfdefa"), 2640);
//        permAlone("zzzzzzzz") should return 0.
        assertEquals(a.permAlone("zzzzzzzz"), 0);
//        permAlone("a") should return 1.
        assertEquals(a.permAlone("a"), 1);
//        permAlone("aaab") should return 0.
        assertEquals(a.permAlone("aaab"), 0);
//        permAlone("aaabb") should return 12.
        assertEquals(a.permAlone("aaabb"), 12);
    }
}