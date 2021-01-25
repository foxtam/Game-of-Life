package net.foxtam.controller;

import net.foxtam.controller.window.GameOfLife;
import net.foxtam.model.universe.Universe;

public class WindowController implements Controller {
    @Override
    public void run(Universe universe) {
        GameOfLife game = new GameOfLife(universe.getSideSize());

    }
}
