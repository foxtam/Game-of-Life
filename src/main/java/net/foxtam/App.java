package net.foxtam;

import net.foxtam.universe.Universe;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mapSize = scanner.nextInt();

        new App().run(mapSize);
    }

    private void run(int mapSize) {
        Universe universe = new Universe(mapSize);

        for (int i = 0; universe.countAlive() > 0; i++) {
            clearScreen();
            System.out.println("Generation #" + i);
            System.out.println("Alive: " + universe.countAlive());
            System.out.println(universe);
            sleep();
            universe.nextGeneration();
        }
    }

    private void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
