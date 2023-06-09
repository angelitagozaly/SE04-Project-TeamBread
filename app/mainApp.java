package app;

import java.util.ArrayList;

import javax.swing.JFrame;

public class mainApp {
        public final JFrame window;

        public static final int WIN_WIDTH = 960;
        public static final int WIN_HEIGHT = 540;
        public int arrSize = 0;

        private final ArrayList<Screen> screens;

        public mainApp() {
                screens = new ArrayList<>();
                window = new JFrame("Sort visualiser");
                initComponents();
                window.setVisible(true);

        }

        public Screen getCurrentScreen() {
                return screens.get(screens.size() - 1);
        }

        public void pushScreen(Screen screen, JFrame window) {
                if (!screens.isEmpty()) {
                        window.remove(getCurrentScreen());
                }
                screens.add(screen);
                window.setContentPane(screen);
                window.validate();
                screen.onOpen();
        }

        public void popScreen() {
                if (!screens.isEmpty()) {
                        Screen prev = getCurrentScreen();
                        screens.remove(prev);
                        window.remove(prev);
                        if (!screens.isEmpty()) {
                                Screen current = getCurrentScreen();
                                window.setContentPane(current);
                                window.validate();
                                current.onOpen();
                        } else {
                                window.dispose();
                        }
                }
        }

        public int getArrSize(int arrSize) {
                return arrSize;
        }

        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JPanel jPanel3;
        private javax.swing.JTextField jTextField1;

        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jPanel2 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jTextField1 = new javax.swing.JTextField();
                jPanel3 = new javax.swing.JPanel();
                jButton1 = new javax.swing.JButton();
                jButton2 = new javax.swing.JButton();
                jButton3 = new javax.swing.JButton();
                jLabel2 = new javax.swing.JLabel();

                window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                window.setMinimumSize(new java.awt.Dimension(975, 578));
                window.setPreferredSize(new java.awt.Dimension(975, 578));
                window.setResizable(false);

                jPanel1.setBackground(new java.awt.Color(255, 244, 227));
                jPanel1.setMinimumSize(new java.awt.Dimension(960, 540));

                jPanel2.setBackground(new java.awt.Color(238, 192, 123));

                jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(66, 35, 8));
                jLabel1.setText("Elements");

                jTextField1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
                jTextField1.setForeground(new java.awt.Color(66, 35, 8));
                jTextField1.setText("999");
                jTextField1.setEditable(true);

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jTextField1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                162, Short.MAX_VALUE)
                                                                .addContainerGap()));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel2Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jTextField1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                49,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jLabel1))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                jPanel3.setBackground(new java.awt.Color(255, 255, 255));

                jButton1.setBackground(new java.awt.Color(238, 192, 123));
                jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
                jButton1.setForeground(new java.awt.Color(66, 35, 8));
                jButton1.setText("Bubble Sort");
                jButton1.setMinimumSize(new java.awt.Dimension(256, 48));
                jButton1.setPreferredSize(new java.awt.Dimension(256, 48));
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jButton2.setBackground(new java.awt.Color(238, 192, 123));
                jButton2.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
                jButton2.setForeground(new java.awt.Color(66, 35, 8));
                jButton2.setText("Insertion Sort");
                jButton2.setMinimumSize(new java.awt.Dimension(256, 48));
                jButton2.setPreferredSize(new java.awt.Dimension(256, 48));
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                jButton3.setBackground(new java.awt.Color(238, 192, 123));
                jButton3.setFont(new java.awt.Font("Comic Sans MS", 0, 20)); // NOI18N
                jButton3.setForeground(new java.awt.Color(66, 35, 8));
                jButton3.setText("Selection Sort");
                jButton3.setMinimumSize(new java.awt.Dimension(256, 48));
                jButton3.setPreferredSize(new java.awt.Dimension(256, 48));
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton3ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel3Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(jButton1,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jButton2,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jButton3,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jButton1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButton2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButton3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("Img/Bread Logo.png"))); // NOI18N

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                528,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                42,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(jPanel3,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jPanel2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(116, 116, 116)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(115, 115, 115)
                                                                                                .addComponent(jPanel2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jPanel3,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(jLabel2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                467,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(67, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(window.getContentPane());
                window.getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                window.pack();
        }

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
                arrSize = Integer.parseInt(jTextField1.getText());

                pushScreen(new sortVisualizer(this, "Bubble", arrSize), window);
        }// GEN-LAST:event_jButton1ActionPerformed

        private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {
                arrSize = Integer.parseInt(jTextField1.getText());
        }

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
                arrSize = Integer.parseInt(jTextField1.getText());
                pushScreen(new sortVisualizer(this, "Insertion", arrSize), window);
        }// GEN-LAST:event_jButton2ActionPerformed

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
                arrSize = Integer.parseInt(jTextField1.getText());

                pushScreen(new sortVisualizer(this, "Selection", arrSize), window);
        }

        public static void main(String args[]) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new mainApp();
                        }
                });
        }

}
