package beapthong.kritsada.lab12;

import beapthong.kritsada.lab10.*;
import java.awt.event.*;
import javax.swing.*;

;

public class MobileDeviceV12 extends MobileDeviceV11 {

    /**
 * MobileDeviceV12 - Extends MobileDeviceV11 to enhance form validation and event handling.
 *
 * This class extends `MobileDeviceV11` by improving user interaction through:
 * - Validating text fields for device name, brand, and price.
 * - Enabling/disabling components dynamically based on user input.
 * - Handling price input validation to ensure only positive numeric values are allowed.
 * - Implementing additional UI behaviors such as radio button control based on price validity.
 *
 * Key Features:
 * - Disables form components when invalid input is detected.
 * - Enables the correct input sequence, guiding users through proper data entry.
 * - Provides informative error messages when incorrect values are entered.
 *
 * Author: Kritsada Beapthong  
 * Student ID: 6730406144  
 * Section: 2  
 */

    protected double price;

    //Constructs a `MobileDeviceV12` object with the specified window title.

    public MobileDeviceV12(String title) {
        super(title);
    }

    protected void handleNormalTextField(JTextField tf, JComponent nextComponent) {

        //// Assign action commands to radio buttons
        // Set action commands for radio buttons (this should be outside this method)
        smartphoneRadio.setActionCommand("SmartPhone");
        tabletRadio.setActionCommand("Tablet");
        

        //check is empty
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

            //is price text field
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


    //recive action when user click on the button
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

    //addname for know what this is button

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
