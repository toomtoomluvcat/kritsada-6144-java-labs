package beapthong.kritsada.lab11;

import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MobileDeviceCompleteV2 extends MobileDeviceComplete implements ActionListener {
    /**
 * MobileDeviceCompleteV2 - A GUI application for managing mobile device information
 *
 * This class extends MobileDeviceComplete and implements ActionListener to handle
 * user interactions. It provides functionality to:
 * - Capture user input for device details
 * - Display input values in a dialog box when the Enter key is pressed
 *
 * Key Features:
 * - Text fields for device name, brand, and price
 * - ActionListener to detect Enter key presses
 * - JOptionPane to display entered data
 *
 * Usage:
 * MobileDeviceCompleteV2.createAndShowGUI();
 *
 * Author: Kritsada Beapthong
 * Student ID: 6730406144
 * Section: 2
 */
   

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();// Get the source of the action event
         // Check if the event came from the Device Name field
        if (src ==  deviceNameField) {
            JOptionPane.showMessageDialog(null, "You pressed Enter in Device Name field: "+deviceNameField.getText());
        }
         // Check if the event came from the Brand field
        if (src ==  brandField) {
            JOptionPane.showMessageDialog(null, "Brand field says: "+brandField.getText());
        }
           // Check if the event came from the Price field
        if (src ==  priceField) {
            JOptionPane.showMessageDialog(null, "Price entered: "+priceField.getText());
        }
    }
    /**
     * Adds ActionListeners to the text fields for Device Name, Brand, and Price.
     * This allows the application to detect Enter key presses in these fields.
     */
    public void addListeners(){
        deviceNameField.addActionListener(this); // Add listener to Device Name field
        brandField.addActionListener(this);      // Add listener to Brand field
        priceField.addActionListener(this);      // Add listener to Price field
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public MobileDeviceCompleteV2(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        MobileDeviceCompleteV2 window = new MobileDeviceCompleteV2("Mobile Device Complete V2");
        window.addComponents();  // Add GUI components
        window.addListeners();   // Attach listeners to text fields
        window.addMenus();       // Add menu options
        window.setFrameFeatures(); // Configure window properties
    }
}
