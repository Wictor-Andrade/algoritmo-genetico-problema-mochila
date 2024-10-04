package genetics;

import java.util.Arrays;
import java.util.Random;

public class Individual {
    private boolean[] chromosome;
    private double fitness;

    public Individual(int chromosomeSize) {
        this.chromosome = new boolean[chromosomeSize];
        Random random = new Random();
        for (int i = 0; i < chromosomeSize; i++) {
            this.chromosome[i] = random.nextBoolean();
        }
        this.fitness = 0;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public boolean[] getChromosome() {
        return chromosome;
    }

    public void printIndividual() {
        System.out.println("Chromosome: " + Arrays.toString(chromosome) + " Fitness: " + fitness);
    }

    public static Individual[] crossover(Individual parent1, Individual parent2, int mutationRate) {
        Random random = new Random();
        int chromosomeSize = parent1.chromosome.length;
        Individual child1 = new Individual(chromosomeSize);
        Individual child2 = new Individual(chromosomeSize);

        for (int i = 0; i < chromosomeSize; i++) {
            if (random.nextBoolean()) {
                child1.chromosome[i] = parent1.chromosome[i];
                child2.chromosome[i] = parent2.chromosome[i];
            } else {
                child1.chromosome[i] = parent2.chromosome[i];
                child2.chromosome[i] = parent1.chromosome[i];
            }
        }

        for (int i = 0; i < chromosomeSize; i++) {
            if (random.nextInt(100) < mutationRate) {
                child1.chromosome[i] = !child1.chromosome[i];
            }
            if (random.nextInt(100) < mutationRate) {
                child2.chromosome[i] = !child2.chromosome[i];
            }
        }

        return new Individual[]{child1, child2};
    }
}