package net.foxtam.universe;

import net.foxtam.universe.generationmap.GenerationMap;

public class Universe {

    private GenerationMap currentGen;

    public Universe(int mapSize) {
        this.currentGen = GenerationMap.newRandom(mapSize);
    }

    @Override
    public String toString() {
        return currentGen.toString();
    }

    public void nextGeneration() {
        GenerationMap nextGen = GenerationMap.newEmpty(currentGen.size());
        for (GenerationMap.Cell currentGenCell : currentGen) {
            int neighborNumber = currentGenCell.countNeighbors();
            if (currentGenCell.isAlive()) {
                if (neighborNumber == 2 || neighborNumber == 3) {
                    nextGen.getCell(currentGenCell.getPosition()).live();
                }
            } else if (neighborNumber == 3) {
                nextGen.getCell(currentGenCell.getPosition()).live();
            }
        }
        currentGen = nextGen;
    }

    public int countAlive() {
        int count = 0;
        for (GenerationMap.Cell cell : currentGen) {
            if (cell.isAlive()) {
                count++;
            }
        }
        return count;
    }
}
