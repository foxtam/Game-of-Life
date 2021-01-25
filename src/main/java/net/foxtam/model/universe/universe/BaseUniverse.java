package net.foxtam.model.universe.universe;

import net.foxtam.model.universe.generationmap.GenerationMap;

import java.util.stream.StreamSupport;

public class BaseUniverse implements Universe {

    private GenerationMap currentGen;

    public BaseUniverse(int mapSize) {
        this.currentGen = GenerationMap.newRandom(mapSize);
    }

    @Override
    public String toString() {
        return currentGen.toString();
    }

    @Override
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

    @Override
    public int countAlive() {
        return StreamSupport.stream(currentGen.spliterator(), false)
                .map(cell -> cell.isAlive() ? 1 : 0)
                .reduce(Integer::sum)
                .orElse(0);
    }
}
