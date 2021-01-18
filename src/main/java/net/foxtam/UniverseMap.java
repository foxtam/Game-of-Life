package net.foxtam;

import java.util.Random;

public class UniverseMap {

    private final boolean[][] map;

    public UniverseMap(int mapSize, int seed) {
        this.map = new boolean[mapSize][mapSize];
        randomFillMap(seed);
    }

    private void randomFillMap(int seed) {
        Random random = new Random(seed);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = random.nextBoolean();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (boolean[] row : map) {
            for (boolean cell : row) {
                builder.append(cell ? 'O' : ' ');
            }
            builder.append('\n');
        }
        return builder.toString();
    }
}
