package net.foxtam.universe.generationmap;

import java.util.Iterator;
import java.util.Random;

public class GenerationMap implements Iterable<GenerationMap.Cell> {

    private final Cell[][] map;

    private GenerationMap(int size, long seed) {
        this(size);
        randomFillMap(seed);
    }

    private GenerationMap(int size) {
        this.map = new Cell[size][size];
        fillEmptyMap();
    }

    private void randomFillMap(long seed) {
        Random random = new Random(seed);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = new Cell(new Position(i, j), random.nextBoolean());
            }
        }
    }

    private void fillEmptyMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = new Cell(new Position(i, j), false);
            }
        }
    }

    public static GenerationMap newRandom(int mapSize) {
        return new GenerationMap(mapSize, 0);
    }

    public static GenerationMap newEmpty(int size) {
        return new GenerationMap(size);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Cell[] row : map) {
            for (Cell cell : row) {
                builder.append(cell.isAlive() ? 'O' : ' ');
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
                Cell cell = map[i][j];
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
        return map[position.getRow()][position.getColumn()];
    }

    public class Cell {

        private final Position position;
        private boolean alive;

        public Cell(Position position, boolean alive) {
            this.position = position;
            this.alive = alive;
        }

        public void die() {
            alive = false;
        }

        public void live() {
            alive = true;
        }

        public int countNeighbors() {
            int count = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) continue;
                    if (getCellRelative(i, j).isAlive()) {
                        count++;
                    }
                }
            }
            return count;
        }

        public boolean isAlive() {
            return alive;
        }

        private Cell getCellRelative(int i, int j) {
            return map[Math.floorMod(position.getRow() + i, size())]
                    [Math.floorMod(position.getColumn() + j, size())];
        }

        public Position getPosition() {
            return position;
        }
    }
}
