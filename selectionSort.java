public class selectionSort implements sortInterface {
    protected long Delay;

    @Override
    public void runSort(sortVisualizer visualizer) throws InterruptedException {
        visualizer.jLabel1.setText("Selection Sort");
        visualizer.jLabel2.setText("Time Complexity | Best: O(n^2) Average: O(n^2) Worst: O(n^2)");
        visualizer.current_index = 0;
        for (int i = 0; i < visualizer.arraySize() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < visualizer.arraySize(); j++) {
                visualizer.current_index = j;
                if (visualizer.getValue(j) < visualizer.getValue(index)) {
                    index = j;
                }
                Thread.sleep(1);
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

    @Override
    public long getDelay() {
        return Delay;
    };

    @Override
    public void setDelay(long delay) {
        this.Delay = delay;
    };
}
