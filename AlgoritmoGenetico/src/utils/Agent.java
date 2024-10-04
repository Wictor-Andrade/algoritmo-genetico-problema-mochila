package utils;

import genetics.Individual;
import genetics.Population;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Agent {
    private Best best;
    private int genotypeSize;
    private int populationSize;
    private int numberOfGenerations;
    private int mutationRate;
    private static final double MAX_VOLUME = 3.0;
    private static Product[] products = {
            new Product("Geladeira Dako", 0.751, 999.90),
            new Product("Iphone 6", 0.0000899, 2911.12),
            new Product("TV 55", 0.400, 4346.99),
            new Product("TV 50", 0.290, 3999.90),
            new Product("TV 42", 0.200, 2999.00),
            new Product("Notebook Dell", 0.00350, 2499.90),
            new Product("Ventilador Panasonic", 0.496, 199.90),
            new Product("Microondas Eletrolux", 0.0424, 308.66),
            new Product("Microondas LG", 0.0544, 429.90),
            new Product("Microondas Panasonic", 0.0319, 299.29),
            new Product("Geladeira Brastemp", 0.0635, 849.00),
            new Product("Geladeira Consul", 0.870, 1199.90),
            new Product("Notebook Lenovo", 0.498, 1999.90),
            new Product("Notebook Asus", 0.0527, 3999.00)
    };

    public Agent(int genotypeSize, int populationSize, int numberOfGenerations, int mutationRate) {
        this.genotypeSize = genotypeSize;
        this.populationSize = populationSize;
        this.numberOfGenerations = numberOfGenerations;
        this.mutationRate = mutationRate;
    }

    public Individual run() {
        Population population = new Population(populationSize, genotypeSize);
        int generation = 0;
        Random random = new Random();

        this.best = new Best(population.getPopulation()[populationSize - 1], 0);

        while (generation < numberOfGenerations) {
            calculateFitness(population.getPopulation());
            population.sortByFitness();
            ArrayList<Individual> newPopulation = new ArrayList<>();

            for (int i = 0; i < populationSize / 2; i++) {
                Individual parent1 = selectIndividual(population.getPopulation());
                Individual parent2 = selectIndividual(population.getPopulation());
                Individual[] offspring = Individual.crossover(parent1, parent2, mutationRate);
                newPopulation.add(offspring[0]);
                newPopulation.add(offspring[1]);
            }

            if (population.getPopulation()[populationSize - 1].getFitness() > this.best.getIndividual().getFitness()
                    && population.getPopulation()[populationSize - 1].getFitness() > 0) {
                this.best.setIndividual(population.getPopulation()[populationSize - 1]);
                this.best.setGeneration(generation);
            }

            for (int i = 0; i < populationSize; i++) {
                population.insertIndividual(i, newPopulation.get(i));
            }
            generation++;
        }

        System.out.println("The fitness of our best solution: " + this.best.getIndividual().getFitness()
                + " Its generation was " + this.best.getGeneration());
        return this.best.getIndividual();
    }

    private void calculateFitness(Individual[] population) {
        for (Individual ind : population) {
            double totalVolume = 0;
            double totalValue = 0;
            for (int i = 0; i < ind.getChromosome().length; i++) {
                if (ind.getChromosome()[i]) {
                    totalVolume += products[i].volume;
                    totalValue += products[i].price;
                }
            }
            ind.setFitness((totalVolume <= MAX_VOLUME) ? totalValue : 0);
        }
    }

    private Individual selectIndividual(Individual[] population) {
        double totalFitness = Arrays.stream(population).mapToDouble(Individual::getFitness).sum();
        double rouletteValue = new Random().nextDouble() * totalFitness;

        double accumulated = 0;
        for (Individual ind : population) {
            accumulated += ind.getFitness();
            if (accumulated >= rouletteValue) {
                return ind;
            }
        }
        return population[0];
    }
}