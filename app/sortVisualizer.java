package app;

import arraySorting.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import javax.swing.SwingWorker;

public class sortVisualizer extends Screen {
    private static final long serialVersionUID = 1L;
    public final int WIDTH = 960, HEIGHT = 496;
    public int SIZE;
    public float BAR_WIDTH;
    public float[] bar_height;
    public SwingWorker<Void, Void> shuffler, sorter;
    public int current_index, traversing_index;
    public String algo;
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
        sortA.initBarHeight();
        onOpen();
        sortA.initShuffler();
    }

    sortArray sortA = new sortArray(this);

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
    public void paintComponent(Graphics g) {
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

    public void onOpen() {
        sorter = new SwingWorker<>() {
            @Override
            public Void doInBackground() throws InterruptedException {
                sortA.callAlgo();
                return null;
            }
        };
    }
}