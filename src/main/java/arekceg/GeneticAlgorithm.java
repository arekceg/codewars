package arekceg;

//https://www.codewars.com/kata/526f35b9c103314662000007/train/java

import java.util.List;
import java.util.function.ToDoubleFunction;

public class GeneticAlgorithm {
    /***************************************************************
     * Feel free to change the private methods' signatures (I did) *
     * Only the "run" functions are tested                         *
     ***************************************************************/
    private String generate(int length) {
        // TODO: Implement the generate method
    }

    private String[] select(List<String> population, List<Double> fitnesses) {
        // TODO: Implement the select method
    }

    private String mutate(String chromosome, double p) {
        // TODO: Implement the mutate method
    }

    private String[] crossover(String chromosome1, String chromosome2) {
        // TODO: Implement the crossover method
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m) {
        // TODO: Implement the run method
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m, int iterations) {
        // TODO: Implement the run method
    }
}
