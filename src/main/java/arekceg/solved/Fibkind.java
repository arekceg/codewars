package arekceg.solved;

import java.util.ArrayList;
import java.util.List;

//https://www.codewars.com/kata/5772382d509c65de7e000982/train/java
class Fibkind {

    private static final List<Long> CACHE = new ArrayList<>();

    public static long lengthSupUK(int n, int k) {
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            if (element(i) >= k) counter++;
        }
        return counter;
    }

    public static long comp(int n) {
        int counter = 0;
        for (int i = 1; i < n; i++) {
            if (element(i + 1) < element(i)) counter++;
        }
        return counter;
    }

    private static long element(int n) {
        return createCacheOfSize(n).get(n - 1);
    }

    private static List<Long> createCacheOfSize(int size) {
        if (CACHE.size() >= size) return CACHE;
        int start = CACHE.size();
        for (int i = start; i < size; i++) {
            CACHE.add(calculateElement(i));
        }
        return CACHE;
    }

    private static long calculateElement(int n) {
        if (n < 2) return 1;
        if (CACHE.get(n - 1) != 0 && CACHE.get(n - 2) != 0) {
            return CACHE.get((int) (n - CACHE.get(n - 1))) + CACHE.get((int) (n - CACHE.get(n - 2)));
        }
        return 1;
    }
}
