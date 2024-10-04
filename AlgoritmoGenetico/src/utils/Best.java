package utils;
import genetics.Individual;

public class Best {
    private Individual individual;
    private int generation;

    public Best(Individual individual, int generation) {
        this.individual = individual;
        this.generation = generation;
    }

    public Individual getIndividual() {
        return individual;
    }

    public void setIndividual(Individual individual) {
        this.individual = individual;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }
}