package arekceg.solved;

public class PerfectPower {
    //https://www.codewars.com/kata/54d4c8b08776e4ad92000835/train/java
    public static int[] isPerfectPower(int n) {
        int[] solution = new int[2];
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = 2; ; j++) {
                int currentIteration = (int) Math.pow(i, j);
                if(currentIteration == n){
                    solution[0] = i;
                    solution[1] = j;
                    return solution;
                } else if (currentIteration > n){
                    break;
                }
            }
        }
        return null;
    }
}
