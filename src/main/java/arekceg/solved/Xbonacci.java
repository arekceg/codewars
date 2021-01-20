package arekceg.solved;

//https://www.codewars.com/kata/556deca17c58da83c00002db/train/java
import java.util.ArrayList;
import java.util.List;

public class Xbonacci {
    List<Double> sequence = new ArrayList<>();

    public double[] tribonacci(double[] ds, int i) {
        sequence = new ArrayList<>();
        if (i == 0)
            return new double[0];
        for (int j = 1; j <= i; j++) {
            sequence.add(getTribonacciNumberAtPosition(ds, j));
        }
        return sequence.stream().mapToDouble(d -> d).toArray();
    }

    private Double getTribonacciNumberAtPosition(double[] ds, int position) {
        if (position <= ds.length) {
            return ds[position - 1];
        }
        if (position < sequence.size())
            return sequence.get(position - 1);
        return getTribonacciNumberAtPosition(ds, position - 1)
                + getTribonacciNumberAtPosition(ds, position - 2)
                + getTribonacciNumberAtPosition(ds, position - 3);
    }
}
