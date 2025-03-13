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

    protected void handleNormalTextField(JTextField tf, JComponent nextComponent) {
        // Set action commands for radio buttons (this should be outside this method)
        smartphoneRadio.setActionCommand("SmartPhone");
        tabletRadio.setActionCommand("Tablet");
        
        if (tf.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter some data in " + tf.getName());
            
            if (nextComponent != null && !tf.getName().equals("Price")) {
                nextComponent.setEnabled(false);
            } else {
                if (groupPhone.getSelection() != null && 
                    groupPhone.getSelection().getActionCommand().equals("SmartPhone")) {
                    tabletRadio.setEnabled(false);
                } else {
                    smartphoneRadio.setEnabled(false);
                }
            }
            
            tf.requestFocusInWindow();
        } else {
            if (tf.getName().equals("Price")) {
                try {
                    price = Double.parseDouble(tf.getText().replace(",", ""));
                    
                    if (price < 0) {
                        JOptionPane.showMessageDialog(null, "Price must be a positive number", 
                                                     "Error", JOptionPane.ERROR_MESSAGE);
                        // Disable radio buttons for invalid price
                        smartphoneRadio.setEnabled(false);
                        tabletRadio.setEnabled(false);
                    } else {
                        JOptionPane.showMessageDialog(null, 
                            String.format("%s is changed to %.1f", tf.getName(), price));
                        // Enable radio buttons when price is valid
                        smartphoneRadio.setEnabled(true);
                        tabletRadio.setEnabled(true);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number in Price");
                    // Disable radio buttons for invalid price format
                    smartphoneRadio.setEnabled(false);
                    tabletRadio.setEnabled(false);
                    tf.requestFocusInWindow();
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(null, 
                    tf.getName() + " is changed to " + tf.getText());
            }
            
            if (nextComponent != null) {
                nextComponent.requestFocusInWindow();
                nextComponent.setEnabled(true);
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
            handleNormalTextField(priceTextField, operatingComboBox);
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
