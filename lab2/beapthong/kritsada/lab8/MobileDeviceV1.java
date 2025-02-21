package beapthong.kritsada.lab8;

import java.awt.*;
import javax.swing.*;

public class MobileDeviceV1 extends MySimpleWindow {

    /**
     * MobileDeviceV1 extends MySimpleWindow to create a form for mobile device
     * details. Implements a GUI with text fields for device name, brand, price
     * and radio buttons for device type selection (Smartphone/Tablet).
     *
     * Author: Kritsada Beapthong ID: 673040614-4 Section: 2
     */
    //declare variable for all component
    protected JLabel deviceNameLabel, brandLabel, priceLabel, typeLabel;
    protected JTextField deviceNameTextField, brandTextField, priceTextField, typeTextField;
    protected JPanel typePanel, formPanel;
    protected JRadioButton smartphoneRadio, tabletRadio;
    protected ButtonGroup groupPhone;

    public MobileDeviceV1(String title) {
        super(title);
    }

    // Method to create a JPanel with a GridLayout of specified rows and columns
    protected JPanel createPanelWithGridLayout(int rows, int cols) {
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(rows, cols));
        return Panel;
    }

    // Method to add input fields and radio buttons to the form
    @Override
    public void addComponents() {
        super.addComponents();

        // Creating labels
        deviceNameLabel = new JLabel("DeviceName:");
        brandLabel = new JLabel("Brand:");
        priceLabel = new JLabel("Price:");
        typeLabel = new JLabel("Type:");

        // Creating text fields
        deviceNameTextField = new JTextField(15);
        brandTextField = new JTextField(15);
        priceTextField = new JTextField(15);
        typeTextField = new JTextField(15);

        // Creating panels
        typePanel = createPanelWithGridLayout(1, 2);
        formPanel = createPanelWithGridLayout(4, 2);

        // Creating radio buttons and grouping them
        smartphoneRadio = new JRadioButton("SmartPhone");
        tabletRadio = new JRadioButton("Tablet");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(smartphoneRadio);
        radioGroup.add(tabletRadio);
        smartphoneRadio.setSelected(true); // Default selection

        // Adding components to form panel
        formPanel.add(deviceNameLabel);
        formPanel.add(deviceNameTextField);

        formPanel.add(brandLabel);
        formPanel.add(brandTextField);

        formPanel.add(priceLabel);
        formPanel.add(priceTextField);

        groupPhone  = new ButtonGroup();
        groupPhone.add(smartphoneRadio);
        groupPhone.add(tabletRadio);
        typePanel = new JPanel();
        // Adding radio buttons to type panel
        typePanel.add(smartphoneRadio);
        typePanel.add(tabletRadio);

        formPanel.add(typeLabel);
        formPanel.add(typePanel);

        // Setting up the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(formPanel, BorderLayout.NORTH);
        add(mainPanel);

        // Adding panels to the frame
    }

    // Method to create and display the GUI
    public static void createAndShowGUI() {
        MobileDeviceV1 mdv1 = new MobileDeviceV1("Mobile Device V1");
        mdv1.addComponents();
        mdv1.setFrameFeatures(); // Setting frame properties (assumed to be in superclass)
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
