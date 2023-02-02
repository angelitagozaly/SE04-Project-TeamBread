public class insertionSort implements sortInterface {
    protected long Delay;

    @Override
    public void runSort(sortVisualizer visualizer) throws InterruptedException {
        visualizer.jLabel1.setText("Insertion Sort");
        visualizer.jLabel2.setText("Time Complexity | Best: O(n) Average: O(n^2) Worst: O(n^2)");
        for (visualizer.current_index = 1; visualizer.current_index < visualizer
                .arraySize(); visualizer.current_index++) {
            visualizer.traversing_index = visualizer.current_index;
            while (visualizer.traversing_index > 0 &&
                    visualizer.getValue(visualizer.traversing_index) < visualizer
                            .getValue(visualizer.traversing_index - 1)) {

                visualizer.swap(visualizer.traversing_index, visualizer.traversing_index - 1);
                visualizer.swapCount++;
                visualizer.jLabel3.setText("Swaps: " + visualizer.swapCount);
                visualizer.traversing_index--;

                Thread.sleep(1);
                visualizer.repaint();
            }
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    };

    @Override
    public long getDelay() {
        return Delay;
    };

    @Override
    public void setDelay(long delay) {
        this.Delay = delay;
    };
}
