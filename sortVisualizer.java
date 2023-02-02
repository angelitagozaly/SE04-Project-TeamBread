import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;
import javax.swing.SwingWorker;

public class sortVisualizer extends Screen {
    private static final long serialVersionUID = 1L;
    protected final int WIDTH = 960, HEIGHT = 496; // WIDTH * 9 / 16;
    protected int SIZE;
    protected float BAR_WIDTH;
    public float[] bar_height;
    private SwingWorker<Void, Void> shuffler, sorter;
    public int current_index, traversing_index;
    private String algo;
    public int swapCount = 0;

    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jButton1;

    public sortVisualizer(mainApp app, String algo, int arrSize) {
        super(app);
        this.algo = algo;
        this.SIZE = arrSize;
        this.BAR_WIDTH = (float) WIDTH / SIZE;
        bar_height = new float[SIZE];
        setBackground(new java.awt.Color(255, 244, 227));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initComponents();
        initBarHeight();
        onOpen();
        initShuffler();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(66, 35, 8));
        jLabel1.setText("InsertionSort");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(66, 35, 8));
        jLabel2.setText("Time Complexity | Best: O(n) Average: O(n^2) Worst: O(n^2)\"");

        jButton1.setBackground(new java.awt.Color(238, 192, 123));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(66, 35, 8));
        jButton1.setText("go back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(66, 35, 8));
        jLabel3.setText("Swaps: " + swapCount);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addGap(65, 65, 65)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80,
                                        Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jButton1)
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jButton1)
                                        .addComponent(jLabel3))
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 273, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));
    }

    public void done() {
        app.popScreen();
        new mainApp();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        done();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new java.awt.Color(238, 192, 123));
        Rectangle2D.Float bar;
        for (int i = 0; i < SIZE; i++) {
            bar = new Rectangle2D.Float(i * BAR_WIDTH, HEIGHT - bar_height[i], BAR_WIDTH, bar_height[i]);
            g2d.fill(bar);
        }

        g2d.setColor(Color.RED);
        bar = new Rectangle2D.Float(current_index * BAR_WIDTH,
                HEIGHT - bar_height[current_index],
                BAR_WIDTH,
                bar_height[current_index]);
        g2d.fill(bar);

        g2d.setColor(Color.GREEN);
        bar = new Rectangle2D.Float(traversing_index * BAR_WIDTH,
                HEIGHT - bar_height[traversing_index],
                BAR_WIDTH,
                bar_height[traversing_index]);
        g2d.fill(bar);

    }

    public int arraySize() {
        return SIZE;
    }

    public int getCurrentIndex() {
        return current_index;
    }

    public void setCurrentIndex(int index) {
        current_index = index;
    }

    public int getTraversingIndex() {
        return traversing_index;
    }

    public void setTraversingIndex(int index) {
        traversing_index = index;
    }

    public float getValue(int index) {
        return bar_height[index];
    }

    public void callAlgo() {
        if (algo == "Bubble") {
            bubbleSort sort = new bubbleSort();
            try {
                sort.runSort(this);
            } catch (InterruptedException e) {
            }
        } else if (algo == "Insertion") {
            insertionSort sort = new insertionSort();
            try {
                sort.runSort(this);
            } catch (InterruptedException e) {
            }
        } else if (algo == "Selection") {
            selectionSort sort = new selectionSort();
            try {
                sort.runSort(this);
            } catch (InterruptedException e) {
            }
        }
        current_index = 0;
        traversing_index = 0;
    }

    public void onOpen() {
        sorter = new SwingWorker<>() {
            @Override
            public Void doInBackground() throws InterruptedException {
                callAlgo();
                return null;
            }
        };
        new test(this);
    }

    protected void initShuffler() {
        shuffler = new SwingWorker<>() {
            @Override
            public Void doInBackground() throws InterruptedException {
                int middle = SIZE / 2;
                for (int i = 0, j = middle; i < middle; i++, j++) {
                    int random_index = new Random().nextInt(SIZE);
                    swap(i, random_index);

                    random_index = new Random().nextInt(SIZE);
                    swap(j, random_index);

                    Thread.sleep(1);
                    repaint();
                }

                return null;
            }

            @Override
            public void done() {
                super.done();
                sorter.execute();
            }
        };
        shuffler.execute();
    }

    protected void initBarHeight() {
        float interval = (float) HEIGHT / SIZE;
        for (int i = 0; i < SIZE; i++)
            bar_height[i] = i * interval;
    }

    protected void swap(int indexA, int indexB) {
        float temp = bar_height[indexA];
        bar_height[indexA] = bar_height[indexB];
        bar_height[indexB] = temp;

    }

    protected void setDelay() throws InterruptedException {
        if (1 < SIZE && SIZE <= 10) {
            Thread.sleep(100);
        } else if (10 < SIZE && SIZE <= 30) {
            Thread.sleep(50);
        } else if (30 < SIZE && SIZE <= 50) {
            Thread.sleep(20);
        } else if (50 < SIZE && SIZE <= 100) {
            Thread.sleep(10);
        } else if (100 < SIZE && SIZE <= 300) {
            Thread.sleep(5);
        } else if (300 < SIZE && SIZE <= 500) {
            Thread.sleep(3);
        } else if (500 < SIZE && SIZE <= 700) {
            Thread.sleep(2);
        } else if (700 < SIZE && SIZE <= 999) {
            Thread.sleep(1);
        }
    }
}