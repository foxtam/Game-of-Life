package net.foxtam;

import net.foxtam.controller.ConsoleController;
import net.foxtam.controller.Controller;
import net.foxtam.controller.WindowController;
import net.foxtam.model.universe.BaseUniverse;
import net.foxtam.model.universe.Universe;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mapSize = scanner.nextInt();

        Controller controller = new WindowController();
        Universe universe = new BaseUniverse(mapSize);
        controller.run(universe);
    }
}
