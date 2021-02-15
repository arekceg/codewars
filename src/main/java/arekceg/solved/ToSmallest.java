package arekceg.solved;

import java.util.stream.Stream;

public class ToSmallest {
    //https://www.codewars.com/kata/573992c724fc289553000e95/train/java
    public static long[] smallest(long n) {
        long[] result = new long[3];
        int[] digitArray = convertLongToDigitArray(n);
        long min = n;
        int sourceIndex = 0;
        int destinationIndex = 0;
        for (int i = 0; i < digitArray.length; i++) {
            for (int j = 0; j < digitArray.length; j++) {
                long currentIteration = calculateIterationByMovingDigitFromIndexToIndex(i, j, n);
                if (currentIteration < min) {
                    min = currentIteration;
                    sourceIndex = i;
                    destinationIndex = j;
                }
            }
        }
        result[0] = min;
        result[1] = sourceIndex;
        result[2] = destinationIndex;

        return result;
    }

    private static long calculateIterationByMovingDigitFromIndexToIndex(int sourceIndex, int destIndex, long n){
        final StringBuilder sb = new StringBuilder(String.valueOf(n));
        char digtitToMove = sb.charAt(sourceIndex);
        sb.deleteCharAt(sourceIndex).insert(destIndex, digtitToMove);
        return Long.parseLong(sb.toString());
    }

    private static int[] convertLongToDigitArray(long n) {
        // Java 9
        // return String.valueOf(n).chars().toArray();
        return Stream.of(String.valueOf(n).split(""))
            .mapToInt(Integer::parseInt)
            .toArray();
    }
}
