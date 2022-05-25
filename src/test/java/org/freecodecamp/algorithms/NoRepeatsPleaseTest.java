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
        assertEquals(2, a.permAlone("aab"));
//        permAlone("aaa") should return 0.
        a = new NoRepeatsPlease();
        assertEquals(0, a.permAlone("aaa"));
//        permAlone("aabb") should return 8.
        a = new NoRepeatsPlease();
        assertEquals(8, a.permAlone("aabb"));
//        permAlone("abcdefa") should return 3600.
        a = new NoRepeatsPlease();
        assertEquals(3600, a.permAlone("abcdefa"));
//        permAlone("abfdefa") should return 2640.
        a = new NoRepeatsPlease();
        assertEquals(2640, a.permAlone("abfdefa"));
//        permAlone("zzzzzzzz") should return 0.
        a = new NoRepeatsPlease();
        assertEquals(0, a.permAlone("zzzzzzzz"));
//        permAlone("a") should return 1.
        a = new NoRepeatsPlease();
        assertEquals(1, a.permAlone("a"));
//        permAlone("aaab") should return 0.
        a = new NoRepeatsPlease();
        assertEquals(0, a.permAlone("aaab"));
//        permAlone("aaabb") should return 12.
        a = new NoRepeatsPlease();
        assertEquals(12, a.permAlone("aaabb"));
    }
}