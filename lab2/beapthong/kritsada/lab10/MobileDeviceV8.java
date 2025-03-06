package beapthong.kritsada.lab10;

import beapthong.kritsada.lab9.*;
import java.awt.event.*;
import javax.swing.*;

public class MobileDeviceV8 extends MobileDeviceV7 implements ActionListener {

    /**
     * MobileDeviceV8 - A GUI application for mobile device information
     * management
     *
     * This class extends MobileDeviceV7 and implements ActionListener to handle
     * user interactions. It provides functionality to: - Input and display
     * mobile device details - Handle button events for submission and reset -
     * Display device information in a dialog box - Clear and reset all input
     * fields
     *
     * Key features: - Input fields for device name, brand, price - Radio
     * buttons for device type selection - Combo box for operating system
     * selection - Text area for device features - List for vendor selection -
     * Slider for rating - OK button to submit and display information - Cancel
     * button to reset all fields
     *
     * Usage example: MobileDeviceV8.createAndShowGUI();
     *
     * Author: Kritsada Beapthong Student ID: 6730406144 Section: 2
     */
    protected int osIndex ;
    protected String osSelected;

    public void clearData() {
        //clear all in formation in panel
        deviceNameTextField.setText("");
        brandTextField.setText("");
        priceTextField.setText("");
        smartphoneRadio.setSelected(true); //set to default radio
        operatingComboBox.setSelectedIndex(0);
        featuresTextArea.setText("");
        vendorsList.clearSelection();
        rateSlide.setValue(5); //set to default rate
    }

    public void addListeners() {
        //add listeners to button component
        resetButton.addActionListener(this);
        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        smartphoneRadio.setActionCommand("SmartPhone");
        tabletRadio.setActionCommand("Tablet");
        osIndex = operatingComboBox.getSelectedIndex();
        switch (osIndex) {
            case 0:
                osSelected = "Android";
                break;
            case 1:
                osSelected = "iOS";
                break;
            case 2:
                osSelected = "windows";
                break;
            case 3:
                osSelected = "Others";
                break;

        }
        //if user click resset button clear all data information
        if (src == resetButton) {
            clearData();
        } else if (src == submitButton) { //if user click "ok" show all in formation they input to form
            String info = "Device Name:" + deviceNameTextField.getText() + "\n"
                    + "Brand:" + brandTextField.getText() + "\n"
                    + "Price: " + priceTextField.getText() + "\n"
                    + "Type: " + groupPhone.getSelection().getActionCommand() + "\n"
                    + "Operating System:" +  osSelected + "\n"
                    + "Features" + featuresTextArea.getText() + "\n"
                    + "Availble at: " + String.join(",", vendorsList.getSelectedValuesList()) + "\n" // get list and make it to string
                    + "Rating: " + rateSlide.getValue();

            //show Pane messenger
            JOptionPane.showMessageDialog(null, info, "Device Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public MobileDeviceV8(String title) {
        super(title);
    }

    // Method to create and display the GUI
    public static void createAndShowGUI() {
        MobileDeviceV8 mdv8 = new MobileDeviceV8("Mobile device V8");
        mdv8.addComponents();
        mdv8.addListeners();
        mdv8.setFrameFeatures();
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
