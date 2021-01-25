package net.foxtam.controller;

import net.foxtam.model.universe.Universe;

import java.io.IOException;

public class ConsoleController implements Controller {
    @Override
    public void run(Universe universe) {
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
