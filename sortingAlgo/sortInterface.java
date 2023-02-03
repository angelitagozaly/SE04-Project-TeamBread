package sortingAlgo;

import app.sortVisualizer;

public interface sortInterface {
    public String getName();

    public void runSort(sortVisualizer visualizer) throws InterruptedException;
}