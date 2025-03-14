package beapthong.kritsada.lab12;

import beapthong.kritsada.lab7.MobileDevice;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;

public class MobileDeviceV13 extends MobileDeviceV12 {
    /**
 * MobileDeviceV14 - Extends MobileDeviceV13 to handle file operations (open and save).
 *
 * This class extends `MobileDeviceV13` and provides the functionality for handling file operations, such as:
 * - Opening a file using a JFileChooser to read device data from a text file.
 * - Saving device data to a file, ensuring the file has a .txt extension.
 * 
 * Key Features:
 * - The class includes a JFileChooser for file selection, with filtering for `.txt` files.
 * - Handles the reading and parsing of device information from a text file, extracting details such as device type, name, brand, and price.
 * - Handles saving device data to a selected file, ensuring the correct format is used, and providing user feedback on success or failure.
 *
 * Functional Details:
 * - `handleMenuOpen`: Opens a file, reads the device data from the text file, and adds it to the device list.
 * - `handleMenuSave`: Saves the device data to a text file, ensuring the correct file extension is used.
 *
 * Author: Kritsada Beapthong  
 * Student ID: 6730406144  
 * Section: 2  
 */

    protected List<MobileDevice> deviceList = new ArrayList<>();
    protected JButton addButton, displayButton;
    StringBuilder messageSmartPhone = new StringBuilder();

    public MobileDeviceV13(String title) {
        super(title);
    }

    public void createObjSmartPhone() {
        // Parse price input, removing commas and converting to double
        price = Double.parseDouble(priceTextField.getText().trim().replace(",", ""));

        // Determine the selected device type and create the corresponding object
        if (smartphoneRadio.isSelected()) {
            deviceList.add(new SmartPhone(
                    deviceNameTextField.getText(),
                    brandTextField.getText(),
                    price,
                    groupPhone.getSelection().getActionCommand()
            ));
        } else if (tabletRadio.isSelected()) {
            deviceList.add(new Tablet(
                    deviceNameTextField.getText(),
                    brandTextField.getText(),
                    price,
                    groupPhone.getSelection().getActionCommand()
            ));
        }

        // Show confirmation message
        JOptionPane.showMessageDialog(null, deviceNameTextField.getText() + " is added");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Call the parent class's actionPerformed to handle any inherited functionality
        super.actionPerformed(e);

        // Identify the source of the action event
        Object src = e.getSource();

        // If the "Add" button is clicked, create a new device object
        if (src == addButton) {
            createObjSmartPhone();

            // If the "Display" button is clicked, show device information
        } else if (src == displayButton) {
            JOptionPane.showMessageDialog(null, messageInfo());
        }
    }

    //medthod replay information message
    protected String messageInfo() {
        messageSmartPhone.setLength(0);
        for (MobileDevice device : deviceList) {
            messageSmartPhone.append(device.toString() + "\n");
        }
        return messageSmartPhone.toString();

    }


    
    @Override
    public void addListeners() {
        super.addListeners();
        addButton.addActionListener(this);
        displayButton.addActionListener(this);
    }
    //method that add buttom and display buttom
    @Override
    public void addComponents() {
        super.addComponents();
        containnerSouthPanel = new JPanel();

        addButton = new JButton("Add");
        displayButton = new JButton("Display");
        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);

        //fix component position
        containnerSouthPanel = new JPanel(new BorderLayout());
        containnerSouthPanel.add(imagePanel, BorderLayout.CENTER);
        containnerSouthPanel.add(containnerExtraPanel, BorderLayout.NORTH);
        containnerSouthPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(containnerSouthPanel, BorderLayout.SOUTH);

    }

    public static void createAndShowGUI() {
        MobileDeviceV13 window = new MobileDeviceV13("Mobile Device V13");
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
