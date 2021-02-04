package arekceg;

public class StringPermutation {

    public static void printPermutaitons(String s){
        printPermutationsRec("", s);
    }

    private static void printPermutationsRec(String permutation, String s) {
        if("".equalsIgnoreCase(s)){
            System.out.println(permutation);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String next = permutation + s.charAt(i);
            String reminder = s.substring(0, i) + s.substring(i+1);
            printPermutationsRec(next, reminder);
        }
    }
}
