package org.freecodecamp.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NoRepeatsPlease {
    ArrayList<String> permutations = new ArrayList<>();
    String tmp;

    public int permAlone(String s) {
        String regex = "(.)\\1+";
        String arr[] = s.split("");
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        if (pattern.matcher(s).find() && pattern.matcher(s).results().anyMatch(matchResult -> matchResult.toString().equalsIgnoreCase(s)))
            return 0;
        generate(arr.length, arr);
        List filtered = permutations.stream().filter(s1 -> {
            return !pattern.matcher(s1).find();
        }).collect(Collectors.toList());
        return filtered.size();
    }

    private void swap(int index1, int index2, String arr[]) {
        tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    private void generate(int j, String arr[]) {
        if (j == 1) {
//            // Make sure to join the characters as we create  the permutation arrays
            permutations.add(Arrays.stream(arr).collect(Collectors.joining("")));
        } else {
            for (int i = 0; i != j; ++i) {
                generate(j - 1, arr);
                swap(j % 2 == 0 ? 0 : i, j - 1, arr);
            }
        }
    }
}
