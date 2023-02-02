public class selectionSort implements sortInterface {
    protected long Delay;

    @Override
    public void runSort(sortVisualizer visualizer) throws InterruptedException {
        visualizer.jLabel1.setText("Selection Sort");
        visualizer.jLabel2.setText("Time Complexity | Best: O(n^2) Average: O(n^2) Worst: O(n^2)");
        visualizer.current_index = 0;
        for (int i = 0; i < visualizer.SIZE - 1; i++) {
            int index = i;
            // sortArray sortA = new sortArray(visualizer);
            for (int j = i + 1; j < visualizer.SIZE; j++) {
                visualizer.current_index = j;
                if (visualizer.bar_height[j] < visualizer.bar_height[index]) {
                    index = j;
                }
                visualizer.setDelay();
                visualizer.repaint();
            }
            visualizer.swap(i, index);
            visualizer.swapCount++;
            visualizer.jLabel3.setText("Swaps: " + visualizer.swapCount);
            visualizer.traversing_index++;
        }
    }

    @Override
    public String getName() {
        return "Selection Sort";
    };
}
