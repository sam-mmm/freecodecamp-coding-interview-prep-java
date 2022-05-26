package org.freecodecamp.algorithms;

import java.util.ArrayList;

public class Pairwise {
    public int pairwise(int[] arr, int a) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == a && !list.contains(i) && !list.contains(j)) {
                    list.add(i);
                    list.add(j);
                    break;
                }
            }
        }
        return list.stream().reduce((integer, integer2) -> {
            return integer + integer2;
        }).orElseGet(() -> {
            return 0;
        });
    }
}
