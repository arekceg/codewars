package arekceg.solved;

//https://www.codewars.com/kata/556deca17c58da83c00002db/train/java
import java.util.Arrays;

public class Xibonacci2 {
    public double[] tribonacci(double[] s, int n) {

        double[] tritab = Arrays.copyOf(s, n);
        for (int i = 3; i < n; i++) {
            tritab[i] = tritab[i - 1] + tritab[i - 2] + tritab[i - 3];
        }
        return tritab;

    }
}
