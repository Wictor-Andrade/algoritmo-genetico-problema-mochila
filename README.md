# Algoritmo Genético para o Problema da Mochila

Este projeto implementa um algoritmo genético para resolver o problema da mochila, onde o objetivo é maximizar o valor dos itens selecionados sem exceder a capacidade máxima da mochila.

## Estrutura do Projeto

- `Main.java`: Classe principal que inicializa e executa o algoritmo genético.
- `utils/Agent.java`: Implementa o agente que gerencia a execução do algoritmo genético.
- `genetics/Individual.java`: Representa um indivíduo na população, com um cromossomo e um valor de fitness.
- `genetics/Population.java`: Gerencia a população de indivíduos.
- `utils/Product.java`: Representa um produto com nome, volume e preço.

## Como Executar

1. Clone o repositório:
    ```sh
    git clone https://github.com/Wictor-Andrade/algoritmo-genetico-problema-mochila
    cd algoritmo-genetico-problema-mochila
    ```

2. Compile o projeto:
    ```sh
    javac -d out src/**/*.java
    ```

3. Execute o projeto:
    ```sh
    java -cp out Main
    ```

## Descrição do Algoritmo

1. **Inicialização**: Cria uma população inicial de indivíduos com cromossomos aleatórios.
2. **Cálculo do Fitness**: Calcula o valor de fitness de cada indivíduo com base no valor total dos produtos selecionados e no volume total.
3. **Seleção por Roleta Viciada**: Seleciona indivíduos para reprodução com base em seus valores de fitness.
4. **Crossover e Mutação**: Gera novos indivíduos a partir dos pais selecionados, aplicando crossover e mutação.
5. **Atualização da População**: Substitui a população antiga pela nova geração de indivíduos.
6. **Iteração**: Repete os passos de 2 a 5 por um número definido de gerações.

## Exemplo de Uso

No arquivo `Main.java`, o agente é configurado e executado da seguinte forma:
```java
import utils.Agent;

public class Main {
    public static void main(String[] args) {
        Agent ag = new Agent(14, 100, 1000, 50);
        ag.run();
    }
}
```

## Melhor Resultado Obtido Durante Os Testes

![Melhor Resultado](https://prnt.sc/4LyE5oVGcclC)

The fitness of our best solution: 25842.560000000005 Its generation was 13