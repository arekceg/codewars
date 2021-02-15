package arekceg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.codewars.com/kata/k-primes/train/java
public class KPrimes {
    public static long[] countKprimes(int k, long start, long end) {
        // use sieve of eratosthenes
        long[] primeFactorCountArray = new long[(int) (end + 1)];
        Arrays.fill(primeFactorCountArray, 0);
        for (int i = 2; i <= end; i++) {
            if (primeFactorCountArray[i] == 0) {
                for (int j = i; j <= end; j += i) {
                    int temp = j;
                    while (temp % i == 0) {
                        primeFactorCountArray[j]++;
                        temp /= i;
                    }
                }
            }
        }

        List<Long> resultList = new ArrayList<>();
        for (int i = (int) start; i <= end; i++) {
            if (primeFactorCountArray[i] == k) resultList.add((long) i);
        }
        return resultList.stream().mapToLong(l -> l).toArray();
    }

    public static int puzzle(int s) {
        int counter = 0;
        long[] onePrimes = countKprimes(1, 2, s);
        long[] threePrimes = countKprimes(3, 2, s);
        long[] sevenPrimes = countKprimes(7, 2, s);

        for (long onePrime : onePrimes) {
            for (long threePrime : threePrimes) {
                for (long sevenPrime: sevenPrimes) {
                    if (onePrime + threePrime+ sevenPrime == s) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}
