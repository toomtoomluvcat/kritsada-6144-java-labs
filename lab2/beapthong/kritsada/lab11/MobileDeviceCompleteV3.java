package beapthong.kritsada.lab11;

import java.awt.*;
import java.awt.event.*;
import  javax.swing.*;

public class MobileDeviceCompleteV3 extends MobileDeviceCompleteV2 implements ComponentListener {

    private Timer resizeTimer;
    private Timer moverTimer;

    @Override
    public void addListener() {
        super.addListener();
        this.addComponentListener(this);
    }

    @Override
    public void componentResized(ComponentEvent e) {
            resizeTimer.restart();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
            moverTimer.restart();
    }

    @Override
    public void componentShown(ComponentEvent e) {
        JOptionPane.showMessageDialog(null, "Window is now visible");

    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

    public MobileDeviceCompleteV3(String title) {
        super(title);
        resizeTimer = new Timer(300, e -> {
            Dimension size = mainPanel.getSize();
           JOptionPane.showMessageDialog(null, "Window resize to:  "+size.width +" x "+size.height);

            resizeTimer.stop();
        });
        resizeTimer.setRepeats(false);

        moverTimer = new Timer(300, e -> {
            Point screenPosition = mainPanel.getLocationOnScreen(); 
           JOptionPane.showMessageDialog(null, "Window moved to: X= "+screenPosition.x+" Y= "+screenPosition.y);
            moverTimer.stop();
        });
        moverTimer.setRepeats(false);

    }

    public static void createAndShowGUI() {
        MobileDeviceCompleteV3 window = new MobileDeviceCompleteV3("Mobile Device Complete V3");
        window.addComponents();
        window.addListener();
        window.addMenus();
        window.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
