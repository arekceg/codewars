package arekceg.solved;

import java.util.Map;
import java.util.TreeMap;

public class PrimeDecomp {
    private static Map<Integer, Integer> factorToPowerMap;

    public static String factors(int n) {
        factorToPowerMap = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        calculateFactorToPowerMap(n);
        factorToPowerMap.forEach((k, v) -> {
            sb.append("(").append(k);
            if (v > 1) sb.append("**").append(v);
            sb.append(")");
        });
        return sb.toString();
    }

    public static void calculateFactorToPowerMap(int n) {
        if (n == 1) return;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) { // ALE SUPER
                factorToPowerMap.put(i, factorToPowerMap.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
    }

//    public static boolean isPrime(int n) {
//        if (n < 2) return false;
//        if (n == 2 || n == 3) return true;
//        for (int j = 2; j <= Math.sqrt(n); j++) {
//            if (n % j == 0) return false;
//        }
//        return true;
//    }
//        public static boolean isPrime(int n) {
//        if (n < 2) return false;
//        if (n == 2 || n == 3) return true;
//        if (n % 2 == 0 || n % 3 == 0) return false;
//        long sqrtN = (long) Math.sqrt(n) + 1;
//        for (long i = 6L; i <= sqrtN; i += 6) {
//            if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
//        }
//        return true;
}

