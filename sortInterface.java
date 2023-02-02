public interface sortInterface {
    public String getName();

    public long getDelay();

    public void setDelay(long delay);

    public void runSort(sortVisualizer visualizer) throws InterruptedException;
}