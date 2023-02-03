package sortingAlgo;

import app.*;
import arraySorting.*;
import test.*;

public class bubbleSort implements sortInterface {
    public long Delay;

    @Override
    public void runSort(sortVisualizer visualizer) throws InterruptedException {
        visualizer.jLabel1.setText("Bubble Sort");
        visualizer.jLabel2.setText("Time Complexity | Best: O(n) Average: O(n^2) Worst: O(n^2)");
        sortArray sortA = new sortArray(visualizer);
        for (int i = 0; i < visualizer.SIZE - 1; i++) {
            for (int j = 0; j < visualizer.SIZE - i - 1; j++) {
                if (visualizer.bar_height[j] > visualizer.bar_height[j + 1]) {
                    sortA.swap(j, j + 1);
                    visualizer.swapCount++;
                    visualizer.jLabel3.setText("Swaps: " + visualizer.swapCount);
                }
                visualizer.traversing_index = j + 1;
                visualizer.current_index = j;
                sortA.setDelay();
                visualizer.repaint();
            }
        }
        visualizer.current_index = 0;
        visualizer.traversing_index = 0;
        new test(visualizer);
    }

    @Override
    public String getName() {
        return "Bubble Sort";
    };
}