package arekceg.unsolved;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class PrimeNumberDecomposer {
    /**
     * Return value: List of all prime factors of a given number n
     */
    public static Long[] getAllPrimeFactors(long n) {
        final List<Long> factorList = new ArrayList<>();
        int increment = n % 2 == 0 ? 1 : 2;
        for (long i = 1L; i < Math.sqrt(n); i = i + increment) {
            if (n % i == 0 && isPrime(i)){
                factorList.add(i);
                if (n / i != i && isPrime(n / i)){
                    factorList.add(n / i);
                }
            }
        }
        factorList.sort(Comparator.naturalOrder());
        return factorList.toArray(new Long[0]);
    }

    /**
     * Return value: List containing two lists, first containg all prime factors without duplicates,
     * second containing the count, how often each prime factor occured.
     * Return code always contains two lists.
     * <p>
     * e.g.: getUniquePrimeFactorsWithCount(100) = {{2,5},{2,2}) // prime 2 occurs 2 times, prime 2 occurs 5 times,
     */
    public static Long[][] getUniquePrimeFactorsWithCount(long n) {
        return new Long[][]{{}, {}};
    }

    /**
     * Return value: List containing product of same prime factors,
     * e.g.: 45 = 3*3*5 ==>  {3^2,5^1} == {9,5}
     * e.g.: getUniquePrimeFactorsWithCount(100) = {{2,5},{2,2}) // prime 2 occurs 2 times, prime 2 occurs 5 times,
     */
    public static Long[] getPrimeFactorPotencies(long n) {
        return new Long[]{};
    }

    private static boolean isPrime(long n) {
        if (n == 0 || n == 1) return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

