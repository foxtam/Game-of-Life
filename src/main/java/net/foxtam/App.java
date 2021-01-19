package net.foxtam;

import net.foxtam.universe.Universe;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mapSize = scanner.nextInt();
        long seed = scanner.nextLong();
        int generationNumber = scanner.nextInt();

        new App().run(mapSize, seed, generationNumber);
    }

    private void run(int mapSize, long seed, int generationNumber) {
        Universe universe = new Universe(mapSize, seed);

        for (int i = 0; i < generationNumber; i++) {
            universe.nextGeneration();
        }
        System.out.println(universe);
    }
}
