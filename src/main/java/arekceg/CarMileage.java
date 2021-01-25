package arekceg;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CarMileage {
    public static boolean isReallyInteresting(int number, final int[] awesomePhrases) {
        return Stream.<Predicate<String>>of(
                s -> s.matches("\\d0+"),
                s -> new StringBuilder(s).reverse().toString().equals(s),
                s -> "1234567890".contains(s),
                s -> "9876543210".contains(s),
                s -> Arrays.stream(awesomePhrases)
                    .anyMatch(n -> Integer.parseInt(s) == n))
                    .anyMatch(p -> number > 99 && p.test(Integer.toString(number)));
    }

    public static int isInteresting(int number, int[] awesomePhrases) {
        return isReallyInteresting(number, awesomePhrases) ? 2
                : isReallyInteresting(number + 1, awesomePhrases) ? 1
                        : isReallyInteresting(number + 2, awesomePhrases) ? 1 : 0;
    }

}