package app;

import sortingAlgo.*;
import javax.swing.SwingWorker;
import java.util.Random;

public class sortArray {
    public sortVisualizer visualizer;

    public sortArray(sortVisualizer visualizer) {
        this.visualizer = visualizer;
    }

    public void callAlgo() {
        if (visualizer.algo == "Bubble") {
            bubbleSort sort = new bubbleSort();
            try {
                sort.runSort(visualizer);
            } catch (InterruptedException e) {
            }
        } else if (visualizer.algo == "Insertion") {
            insertionSort sort = new insertionSort();
            try {
                sort.runSort(visualizer);
            } catch (InterruptedException e) {
            }
        } else if (visualizer.algo == "Selection") {
            selectionSort sort = new selectionSort();
            try {
                sort.runSort(visualizer);
            } catch (InterruptedException e) {
            }
        }
    }

    public void initShuffler() {
        visualizer.shuffler = new SwingWorker<>() {
            @Override
            public Void doInBackground() throws InterruptedException {
                int middle = visualizer.SIZE / 2;
                for (int i = 0, j = middle; i < middle; i++, j++) {
                    int random_index = new Random().nextInt(visualizer.SIZE);
                    swap(i, random_index);

                    random_index = new Random().nextInt(visualizer.SIZE);
                    swap(j, random_index);

                    Thread.sleep(1);
                    visualizer.repaint();
                }

                return null;
            }

            @Override
            public void done() {
                super.done();
                visualizer.sorter.execute();
            }
        };
        visualizer.shuffler.execute();
    }

    public void initBarHeight() {
        float interval = (float) visualizer.HEIGHT / visualizer.SIZE;
        for (int i = 0; i < visualizer.SIZE; i++)
            visualizer.bar_height[i] = i * interval;
    }

    public void swap(int indexA, int indexB) {
        float temp = visualizer.bar_height[indexA];
        visualizer.bar_height[indexA] = visualizer.bar_height[indexB];
        visualizer.bar_height[indexB] = temp;

    }

    public void setDelay() throws InterruptedException {
        if (1 < visualizer.SIZE && visualizer.SIZE <= 10) {
            Thread.sleep(100);
        } else if (10 < visualizer.SIZE && visualizer.SIZE <= 30) {
            Thread.sleep(50);
        } else if (30 < visualizer.SIZE && visualizer.SIZE <= 50) {
            Thread.sleep(20);
        } else if (50 < visualizer.SIZE && visualizer.SIZE <= 100) {
            Thread.sleep(10);
        } else if (100 < visualizer.SIZE && visualizer.SIZE <= 300) {
            Thread.sleep(5);
        } else if (300 < visualizer.SIZE && visualizer.SIZE <= 500) {
            Thread.sleep(3);
        } else if (500 < visualizer.SIZE && visualizer.SIZE <= 700) {
            Thread.sleep(2);
        } else if (700 < visualizer.SIZE && visualizer.SIZE <= 999) {
            Thread.sleep(1);
        }
    }
}
