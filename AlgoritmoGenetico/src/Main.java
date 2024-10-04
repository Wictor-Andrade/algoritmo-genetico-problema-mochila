import utils.Agent;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.println("Iteración: " + i);
            Agent ag = new Agent(14, 100, 1000, 50);
            ag.run();
        }
    }
}