package org.freecodecamp.algorithms;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example {
    public static void main(String[] args) {
        final String regex = "(.)\\1+";
        final String string = "Abc#+123\n"
                + "123Abc#+\n"
                + "Abbc#+123\n"
                + "Abc##+123\n"
                + "Abc#+1223\n"
                + "aaab\n"
                + "baa\n";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);

        if (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));

            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}
