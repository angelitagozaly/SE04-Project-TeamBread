


import javax.swing.JPanel;


import java.awt.Dimension;

public abstract class Screen extends JPanel {
    protected mainApp app; 

    public Screen(mainApp app){
        this.app = app;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(960, 540);
    }
    
    public abstract void onOpen();
}
