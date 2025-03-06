package beapthong.kritsada.lab12;

import beapthong.kritsada.lab10.*;
import java.awt.event.*;
import javax.swing.*;

;

public class MobileDeviceV12 extends MobileDeviceV11 {

    protected double price;

    public MobileDeviceV12(String title) {
        super(title);
    }

    protected void handleNormalTextField(JTextField tf, JComponent nexComponent) {
        if (tf.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter some data in " + tf.getName());
            if (nexComponent != null && !tf.getName().equals("Price")) {
                nexComponent.setEnabled(false);
            }
            tf.requestFocusInWindow();
           
        } else {
            if (tf.getName().equals("Price")) {
                try {
                   price = Double.parseDouble(tf.getText().replace(",",""));
                    if (price < 0) {
                        JOptionPane.showMessageDialog(null, "Price must be a positive number", "error", JOptionPane.ERROR_MESSAGE);
                    } else if(price>=0){
                        
                        JOptionPane.showMessageDialog(null, String.format("%s is change to %.2f",tf.getName(),price));
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number in Price");

                }
                nexComponent.requestFocusInWindow();
            } else {
                JOptionPane.showMessageDialog(null, tf.getName() + "is change to " + tf.getText());
                nexComponent.requestFocusInWindow();
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        if (src == deviceNameTextField) {
            handleNormalTextField(deviceNameTextField, brandTextField);
        } else if (src == brandTextField) {
            handleNormalTextField(brandTextField, priceTextField);
        } else if (src == priceTextField) {
            handleNormalTextField(priceTextField, priceTextField);
        }

    }

    @Override
    public void addComponents() {
        super.addComponents();
        deviceNameTextField.setName("Device Name");
        brandTextField.setName("Brand");
        priceTextField.setName("Price");

    }

    @Override
    public void addListeners() {
        super.addListeners();
        deviceNameTextField.addActionListener(this);
        brandTextField.addActionListener(this);
        priceTextField.addActionListener(this);

    }

    public static void createAndShowGUI() {
        MobileDeviceV12 window = new MobileDeviceV12("Mobile device V12");
        window.addComponents();
        window.addListeners();
        window.addChangeListener();
        window.addListSelectionListener();
        window.addShortKey();
        window.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

}
