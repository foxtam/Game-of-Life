package net.foxtam.model.universe;

import net.foxtam.model.universe.generationmap.GenerationMap;

public interface Universe {
    void nextGeneration();
    int countAlive();
    int getSideSize();
    GenerationMap getGenerationMap();
}
