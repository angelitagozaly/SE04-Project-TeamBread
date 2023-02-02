public class insertionSort implements sortInterface {
    protected long Delay;

    @Override
    public void runSort(sortVisualizer visualizer) throws InterruptedException {
        visualizer.jLabel1.setText("Insertion Sort");
        visualizer.jLabel2.setText("Time Complexity | Best: O(n) Average: O(n^2) Worst: O(n^2)");
        for (visualizer.current_index = 1; visualizer.current_index < visualizer.SIZE; visualizer.current_index++) {
            visualizer.traversing_index = visualizer.current_index;
            while (visualizer.traversing_index > 0 &&
                    visualizer.bar_height[visualizer.traversing_index] < visualizer.bar_height[visualizer.traversing_index
                            - 1]) {
                visualizer.swap(visualizer.traversing_index, visualizer.traversing_index - 1);
                visualizer.swapCount++;
                visualizer.jLabel3.setText("Swaps: " + visualizer.swapCount);
                visualizer.traversing_index--;
                visualizer.setDelay();
                visualizer.repaint();
            }
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    };
}