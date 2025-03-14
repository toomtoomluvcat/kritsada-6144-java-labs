package beapthong.kritsada.lab12;

import beapthong.kritsada.lab10.*;
import java.awt.event.*;
import javax.swing.*;

public class MobileDeviceV12 extends MobileDeviceV11 {

    /**
     * MobileDeviceV12 - Extension of MobileDeviceV11 with improved form
     * validation and event handling.
     *
     * This class implements enhanced input validation for all form fields
     * including: - Text field validation for required fields - Numeric input
     * validation for price fields - Positive number validation - Proper error
     * messaging using JOptionPane dialog boxes - Focus management between form
     * components - Dynamic enabling/disabling of components based on validation
     * results
     *
     * The class demonstrates good practices in GUI form validation including: -
     * Clear user feedback on validation errors - Proper focus handling to guide
     * users through form completion - Appropriate error messages specific to
     * the validation issue - Preventing form submission with invalid data
     *
     * Author: Kritsada Beapthong Student ID: 6730406144 Section: 2 Date:
     * [Current Date] Version: 12.0
     */

    //decare price variable
    protected double price;

    public MobileDeviceV12(String title) {
        super(title);
    }

    protected void handleNormalTextField(JTextField tf, JComponent nextComponent) {
        // Check if empty
        if (tf.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter some data in " + tf.getName());
            tf.requestFocusInWindow();
            if (nextComponent != null) {
                nextComponent.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(null, tf.getName() + " is changed to " + tf.getText());
            if (nextComponent != null) {
                nextComponent.setEnabled(true);
                nextComponent.requestFocusInWindow();
            }
        }
    }

    protected void handlePosNumTextField(JTextField tf, JComponent nextComponent) {
        // Check if empty
        if (tf.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter some data in " + tf.getName());
            tf.requestFocusInWindow();
            if (nextComponent != null) {
                nextComponent.setEnabled(false);
            }
            return;
        }

        // Check if it's a valid number
        try {
            price = Double.parseDouble(tf.getText().replace(",", ""));

            // Check if number is positive
            if (price <= 0) {
                JOptionPane.showMessageDialog(null, tf.getName() + " must be a positive number");
                tf.requestFocusInWindow();
                if (nextComponent != null) {
                    nextComponent.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Price is changed to " + price);
                if (nextComponent != null) {
                    nextComponent.setEnabled(true);
                    nextComponent.requestFocusInWindow();
                }
            }
            //show message if is input not number 
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a valid number in " + tf.getName(), "Error", JOptionPane.ERROR_MESSAGE);
            tf.requestFocusInWindow();
            if (nextComponent != null) {
                nextComponent.setEnabled(false);
            }
        }
    }

    //add action in text name and brad fied
    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        if (src == deviceNameTextField) {
            handleNormalTextField(deviceNameTextField, brandTextField);
        } else if (src == brandTextField) {
            handleNormalTextField(brandTextField, priceTextField);
        } else if (src == priceTextField) {
            handlePosNumTextField(priceTextField, operatingComboBox);
        }
    }

    //add name for reice when is emty
    @Override
    public void addComponents() {
        super.addComponents();
        deviceNameTextField.setName("Device Name");
        brandTextField.setName("Brand");
        priceTextField.setName("Price");
    }

    //add listenner for each text fied
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
