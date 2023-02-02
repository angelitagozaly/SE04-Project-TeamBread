public class bubbleSort implements sortInterface {
    protected long Delay;

    @Override
    public void runSort(sortVisualizer visualizer) throws InterruptedException {
        visualizer.jLabel1.setText("Bubble Sort");
        visualizer.jLabel2.setText("Time Complexity | Best: O(n) Average: O(n^2) Worst: O(n^2)");
        for (int i = 0; i < visualizer.arraySize() - 1; i++) {
            for (int j = 0; j < visualizer.arraySize() - i - 1; j++) {

                if (visualizer.getValue(j) > visualizer.getValue(j + 1)) {
                    visualizer.swap(j, j + 1);
                    visualizer.swapCount++;
                    visualizer.jLabel3.setText("Swaps: " + visualizer.swapCount);
                }
                visualizer.traversing_index = j + 1;
                visualizer.current_index = j;
                Thread.sleep(5);
                visualizer.repaint();
            }
        }
    }

    @Override
    public String getName() {
        return "Bubble Sort";
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
