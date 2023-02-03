package sortingAlgo;

import app.*;
import test.test;

public class insertionSort implements sortInterface {
    public long Delay;

    @Override
    public void runSort(sortVisualizer visualizer) throws InterruptedException {
        visualizer.jLabel1.setText("Insertion Sort");
        visualizer.jLabel2.setText("Time Complexity | Best: O(n) Average: O(n^2) Worst: O(n^2)");
        sortArray sortA = new sortArray(visualizer);
        for (visualizer.current_index = 1; visualizer.current_index < visualizer.SIZE; visualizer.current_index++) {
            visualizer.traversing_index = visualizer.current_index;
            while (visualizer.traversing_index > 0 &&
                    visualizer.bar_height[visualizer.traversing_index] < visualizer.bar_height[visualizer.traversing_index
                            - 1]) {
                sortA.swap(visualizer.traversing_index, visualizer.traversing_index - 1);
                visualizer.swapCount++;
                visualizer.jLabel3.setText("Swaps: " + visualizer.swapCount);
                visualizer.traversing_index--;
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
        return "Insertion Sort";
    };
}