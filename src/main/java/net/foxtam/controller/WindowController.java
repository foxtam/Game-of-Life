package net.foxtam.controller;

import net.foxtam.model.universe.Universe;
import net.foxtam.model.universe.generationmap.GenerationMap;
import net.foxtam.view.window.GameOfLifeFrame;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class WindowController implements Controller {
    @Override
    public void run(Universe universe) {
        GameOfLifeFrame frame = new GameOfLifeFrame(universe.getSideSize());

        for (int i = 0; universe.countAlive() > 0; i++) {
            frame.setGenerationNumber(i);
            frame.setAliveNumber(universe.countAlive());
            List<Boolean> aliveCellsStatus = getAliveCellStatus(universe);
            frame.updateCellsMap(aliveCellsStatus);
            sleep();
            universe.nextGeneration();
        }
    }

    private List<Boolean> getAliveCellStatus(Universe universe) {
        return StreamSupport.stream(universe.getGenerationMap().spliterator(), false)
                .map(GenerationMap.Cell::isAlive)
                .collect(Collectors.toList());
    }

    private void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
