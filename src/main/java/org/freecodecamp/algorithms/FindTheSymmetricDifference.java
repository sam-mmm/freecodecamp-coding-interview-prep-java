package org.freecodecamp.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindTheSymmetricDifference {
    public int[] sym1(int[]... args) {
        int[] results = Arrays.<int[]>stream(args).reduce((ints1, ints2) -> {
            int[] result = null;
            try {

                List<Integer> a = Arrays.stream(ints1).boxed().toList();
                List<Integer> b = Arrays.stream(ints2).boxed().toList();

                ArrayList<Integer> _result = new ArrayList<>();
                a.forEach(value -> {
                    if (b.indexOf(value) < 0 && _result.indexOf(value) < 0) {
                        _result.add(value);
                    }
                });

                b.forEach(value -> {
                    if (a.indexOf(value) < 0 && _result.indexOf(value) < 0) {
                        _result.add((Integer) value);
                    }
                });
                result = getArrayFormList(_result);
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            return result;
        }).get();
        Arrays.sort(results);
        return results;
    }

    public int[] sym2(int[]... args) {
        int[] results = null;
        results = Arrays.stream(args).reduce((ints, ints2) -> {
            List<Integer> a = Arrays.stream(ints).boxed().toList();
            List<Integer> b = Arrays.stream(ints2).boxed().toList();

            List<Integer> c = a.stream().filter(integer -> {
                return b.indexOf(integer) < 0;
            }).collect(Collectors.toList());
            List<Integer> d = b.stream().filter(integer -> {
                return a.indexOf(integer) < 0;
            }).toList();
            c.addAll(d);
            List<Integer> r = c.stream().distinct().collect(Collectors.toList());
            int[] result = getArrayFormList(r);
            return result;
        }).get();
        Arrays.sort(results);
        return results;
    }

    public int[] sym3(int[]... args) {
        int[] results = Arrays.stream(args).reduce((ints, ints2) -> {
            List<Integer> r = new ArrayList<>();
            final List<Integer> a = Arrays.stream(ints).boxed().toList();
            final List<Integer> b = Arrays.stream(ints2).boxed().toList();
            r.addAll(a.stream().filter(integer -> !b.contains(integer)).toList());
            r.addAll(b.stream().filter(integer -> !a.contains(integer)).toList());
            return getArrayFormList(r.stream().distinct().collect(Collectors.toList()));
        }).get();

        Arrays.sort(results);
        return results;
    }


    private int[] getArrayFormList(List<Integer> r) {
        int[] result = new int[r.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = r.get(i);
        }
        return result;
    }
}
