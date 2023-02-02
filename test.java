public class test {
    private boolean arrayCheck;

    public test(sortVisualizer visualizer) {
        for (int i = 0; i < visualizer.SIZE; i++) {
            if (visualizer.bar_height[i] != i) {
                arrayCheck = true;
            } else {
                arrayCheck = false;
            }
        }
        assert arrayCheck != false;
    }
}
