package net.foxtam;

import net.foxtam.controller.WindowController;
import net.foxtam.model.universe.BaseUniverse;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mapSize = scanner.nextInt();

        new WindowController().run(
                new BaseUniverse(mapSize));
    }
}
