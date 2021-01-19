package net.foxtam.universe.generationmap;

import java.util.Iterator;
import java.util.Random;

public class GenerationMap implements Iterable<GenerationMap.Cell> {

    private final boolean[][] map;

    private GenerationMap(int size, long seed) {
        this(size);
        randomFillMap(seed);
    }

    private GenerationMap(int size) {
        this.map = new boolean[size][size];
    }

    private void randomFillMap(long seed) {
        Random random = new Random(seed);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = random.nextBoolean();
            }
        }
    }

    public static GenerationMap newRandom(int mapSize, long seed) {
        return new GenerationMap(mapSize, seed);
    }

    public static GenerationMap newEmpty(int size) {
        return new GenerationMap(size);
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

    @Override
    public Iterator<Cell> iterator() {
        return new Iterator<>() {

            private int i = 0, j = 0;

            @Override
            public boolean hasNext() {
                return i < size() && j < size();
            }

            @Override
            public Cell next() {
                Cell cell = new Cell(i, j);
                j++;
                if (j == size()) {
                    j = 0;
                    i++;
                }
                return cell;
            }
        };
    }

    public int size() {
        return map.length;
    }

    public Cell getCell(Position position) {
        return new Cell(position.getRow(), position.getColumn());
    }

    public class Cell {

        private final int homeRow;
        private final int homeColumn;

        public Cell(int homeRow, int homeColumn) {
            this.homeRow = homeRow;
            this.homeColumn = homeColumn;
        }

        public boolean isAlive() {
            return map[homeRow][homeColumn];
        }

        public void die() {
            map[homeRow][homeColumn] = false;
        }

        public void live() {
            map[homeRow][homeColumn] = true;
        }

        public int countNeighbors() {
            int count = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    if (map[Math.floorMod(homeRow + i, size())][Math.floorMod(homeColumn + j, size())]) {
                        count++;
                    }
                }
            }
            return count;
        }

        public Position getPosition() {
            return new Position(homeRow, homeColumn);
        }
    }
}
