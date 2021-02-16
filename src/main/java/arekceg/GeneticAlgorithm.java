package arekceg;

//https://www.codewars.com/kata/526f35b9c103314662000007/train/java

import java.util.*;
import java.util.function.ToDoubleFunction;

public class GeneticAlgorithm {
    private final int populationSize = 150;
    private ToDoubleFunction<String> fitness;
    private double p_c;
    private double p_m;

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m) {
        return run(fitness, length, p_c, p_m, 100);
    }

    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m, int iterations) {
        this.fitness = fitness;
        this.p_c = p_c;
        this.p_m = p_m;
        Map<String, Double> chromosomesAndFitnessMap = new HashMap<>();
        for (int i = 0; i < populationSize; i++) {
            final String chromosome = generateChromosome(length);
            chromosomesAndFitnessMap.put(chromosome, fitness.applyAsDouble(chromosome));
        }

        for (int i = 0; i < iterations; i++) {
            chromosomesAndFitnessMap = generateNewChromosomesAndFitnessMap(chromosomesAndFitnessMap);
        }

        final Optional<Map.Entry<String, Double>> bestChromosome = chromosomesAndFitnessMap.entrySet().stream()
                .max(Map.Entry.comparingByValue());

        return bestChromosome.get().getKey();
    }

    private String generateChromosome(int length) {
        if (length == 0) return "";
        final StringBuilder sb = new StringBuilder();
        final Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextBoolean() ? 1 : 0);
        }
        return sb.toString();
    }

    private String select(Map<String, Double> chromosomeToFitnessMap) {
        // TODO: POPRAWIĆ! selectionProbability ma sie zwiększać przy każdym kroku o fintess/fitnessSum
        final Random random = new Random();
        final Double fitnessesSum = chromosomeToFitnessMap.values().stream().reduce(Double::sum).get();
        int selectionProbability;
        String selectedChromosome = "";
        while (selectedChromosome.equals("")) {
            selectedChromosome = chromosomeToFitnessMap.keySet().stream()
                    .filter(chromosome -> {
                        final double selectionProbability = chromosomeToFitnessMap.get(chromosome) / fitnessesSum;
                        return random.nextInt(101) < selectionProbability * 100;
                    }).findFirst().orElse("");
        }
        return selectedChromosome;
    }

    private String mutate(String chromosome, double p) {
        final StringBuilder sb = new StringBuilder();
        final Random random = new Random();
        chromosome.chars()
                .map(bit -> {
                    final int bitInt = Character.getNumericValue(bit);
                    if (random.nextInt(101) < p * 100) {
                        return switchBit(bitInt);
                    }
                    return bitInt;
                }).forEach(sb::append);
        return sb.toString();
    }

    private int switchBit(int bit) {
        return bit == 0 ? 1 : 0;
    }

    private String[] crossover(String chromosome1, String chromosome2) {
        int crossOverBitIndex = chromosome1.length();
        final String[] crossedChromosomes = new String[2];
        final Random random = new Random();
        for (int i = 0; i < chromosome1.length(); i++) {
            if (random.nextBoolean()) {
                crossOverBitIndex = i;
                break;
            }
        }
        if (crossOverBitIndex == chromosome1.length()) return new String[]{chromosome1, chromosome2};
        crossedChromosomes[0] = chromosome1.substring(0, crossOverBitIndex) + chromosome2.substring(crossOverBitIndex);
        crossedChromosomes[1] = chromosome2.substring(0, crossOverBitIndex) + chromosome1.substring(crossOverBitIndex);
        return crossedChromosomes;
    }

    private Map<String, Double> generateNewChromosomesAndFitnessMap(Map<String, Double> chromosomesAndFitnessMap) {
        final Map<String, Double> newMap = new HashMap<>();
        final Random random = new Random();
        String[] selectedChromosomes = new String[]{"", ""};
        for (int i = 0; i < populationSize / 2; i++) {
            while (selectedChromosomes[0].equals(selectedChromosomes[1])) {
                selectedChromosomes[0] = select(chromosomesAndFitnessMap);
                selectedChromosomes[1] = select(chromosomesAndFitnessMap);
            }
            if (random.nextInt(101) < p_c * 100) {
                selectedChromosomes = crossover(selectedChromosomes[0], selectedChromosomes[1]);
            }
            for (String chromosome : selectedChromosomes) {
                final String mutatedChromosome = mutate(chromosome, p_m);
                newMap.put(mutatedChromosome, fitness.applyAsDouble(mutatedChromosome));
            }
        }
        return newMap;
    }
}
