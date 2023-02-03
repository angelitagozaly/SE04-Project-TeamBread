package sortingAlgo;

import app.*;
import test.test;

public class selectionSort implements sortInterface {
    public long Delay;

    @Override
    public void runSort(sortVisualizer visualizer) throws InterruptedException {
        visualizer.jLabel1.setText("Selection Sort");
        visualizer.jLabel2.setText("Time Complexity | Best: O(n^2) Average: O(n^2) Worst: O(n^2)");
        visualizer.current_index = 0;
        sortArray sortA = new sortArray(visualizer);
        for (int i = 0; i < visualizer.SIZE - 1; i++) {
            int index = i;
            for (int j = i + 1; j < visualizer.SIZE; j++) {
                visualizer.current_index = j;
                if (visualizer.bar_height[j] < visualizer.bar_height[index]) {
                    index = j;
                }
                sortA.setDelay();
                visualizer.repaint();
            }
            sortA.swap(i, index);
            visualizer.swapCount++;
            visualizer.jLabel3.setText("Swaps: " + visualizer.swapCount);
            visualizer.traversing_index++;
        }
        visualizer.current_index = 0;
        visualizer.traversing_index = 0;
        new test(visualizer);
    }

    @Override
    public String getName() {
        return "Selection Sort";
    };
}
