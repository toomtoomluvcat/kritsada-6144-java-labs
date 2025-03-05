package beapthong.kritsada.lab11;

import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MobileDeviceCompleteV2 extends MobileDeviceComplete implements ActionListener {
   

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src ==  deviceNameField) {
            JOptionPane.showMessageDialog(null, "You pressed Enter in Device Name field: "+deviceNameField.getText());
        }
        if (src ==  brandField) {
            JOptionPane.showMessageDialog(null, "Brand field says: "+brandField.getText());
        }
        if (src ==  priceField) {
            JOptionPane.showMessageDialog(null, "Price entered: "+priceField.getText());
        }
    }
    public void addListener(){
        priceField.addActionListener(this);
        brandField.addActionListener(this);
        deviceNameField.addActionListener(this);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public MobileDeviceCompleteV2(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        MobileDeviceCompleteV2 window = new MobileDeviceCompleteV2("Mobile Device Complete V2");
        window.addComponents();
        window.addListener();
        window.addMenus();
        window.setFrameFeatures();
    }
}
