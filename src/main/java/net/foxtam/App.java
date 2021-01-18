package net.foxtam;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mapSize = scanner.nextInt();
        int seed = scanner.nextInt();

        new App().run(mapSize, seed);
    }

    private void run(int mapSize, long seed) {
        UniverseMap universeMap = new UniverseMap(mapSize, seed);
        System.out.println(universeMap);
    }
}
