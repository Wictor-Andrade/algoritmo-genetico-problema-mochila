package genetics;

import java.util.Arrays;
import java.util.Comparator;

public class Population {
    private Individual population[];

    public Population(int populationSize, int genotypeSize) {
        this.population = this.initializePopulation(populationSize, genotypeSize);
    }

    private Individual[] initializePopulation(int populationSize, int genotypeSize) {
        Individual[] result = new Individual[populationSize];

        for (int i = 0; i < populationSize; i++) {
            result[i] = new Individual(genotypeSize);
        }
        return result;
    }

    public void printPopulation() {
        for (int i = 0; i < this.population.length; i++) {
            System.out.print("Individual number " + i + " ");
            this.population[i].printIndividual();
        }
    }

    public void sortByFitness() {
        Arrays.sort(this.population, Comparator.comparingDouble(Individual::getFitness));
    }

    public Individual[] getPopulation() {
        return population;
    }

    public void insertIndividual(int index, Individual individual) {
        this.population[index] = individual;
    }
}