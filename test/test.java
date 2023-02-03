package test;

import app.sortVisualizer;

public class test {
    private boolean arrayCheck = true;

    public test(sortVisualizer visualizer) {
        for (int i = 0; i < visualizer.SIZE; i++) {
            if (visualizer.bar_height[i] < visualizer.bar_height[i + 1]) {
                arrayCheck = false;
            }
        }
        assert arrayCheck == true : "Array is not sorted";
    }
}