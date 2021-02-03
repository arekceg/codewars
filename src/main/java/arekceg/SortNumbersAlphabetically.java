package arekceg;

import java.util.Arrays;
import java.util.Comparator;

//https://www.codewars.com/kata/56f4ff45af5b1f8cd100067d/train/java
public class SortNumbersAlphabetically {

    private static String[] UNITS = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private static String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    public static int[] sort(final int array[]) {
        return
                Arrays.stream(array)
                        .boxed()
                        .sorted(Comparator.comparing(SortNumbersAlphabetically::toName))
                        .map(String::valueOf)
                        .mapToInt(Integer::valueOf)
                        .toArray();
    }

    private static String toName(int i) {
        if (i == 0) return "zero";
        return toWords(i / 100, " hundred") + ((i / 100) % 10 != 0 ? " " : "") + toWords(i % 100);
    }

    private static String toWords(int i, String toAppend) {
        return toWords(i) + (i > 0 ? toAppend : "");
    }

    private static String toWords(int i) {
        if (i > 19) {
            return TENS[i / 10] + " " + UNITS[i % 10];
        }
        return UNITS[i];
    }
}

