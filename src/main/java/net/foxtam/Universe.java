package net.foxtam;

import java.util.Iterator;

public class Universe {

    private GenerationMap currentGen;

    public Universe(int mapSize, long seed) {
        this.currentGen = GenerationMap.newRandom(mapSize, seed);
    }

    @Override
    public String toString() {
        return currentGen.toString();
    }

    public void nextGeneration() {
        GenerationMap nextGen = GenerationMap.newEmpty(currentGen.size());
        Iterator<GenerationMap.Cell> currentGenIterator = currentGen.iterator();
        Iterator<GenerationMap.Cell> nextGenIterator = nextGen.iterator();

        while (currentGenIterator.hasNext()) {
            GenerationMap.Cell currentGenCell = currentGenIterator.next();
            GenerationMap.Cell nextGenCell = nextGenIterator.next();

            int neighborNumber = currentGenCell.countNeighbors();
            if (currentGenCell.isAlive()) {
                if (neighborNumber == 2 || neighborNumber == 3) {
                    nextGenCell.live();
                }
            } else if (neighborNumber == 3) {
                nextGenCell.live();
            }
        }
        currentGen = nextGen;
    }
}
