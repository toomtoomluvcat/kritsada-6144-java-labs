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

    public MobileDeviceV1(String title) {
        super(title);
    }

    // Method to create a JLabel with given title
    protected JLabel createLabel(String title) {
        return new JLabel(title);
    }

    // Method to create a JTextField with specified column width
    protected JTextField createTextField(int cols) {
        return new JTextField(cols);
    }

    // Method to create a JPanel with a GridLayout of specified rows and columns
    protected JPanel createPanelWithGridLayout(int rows, int cols) {
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(rows, cols));
        return Panel;
    }

    // Method to create a JRadioButton with given title
    protected JRadioButton createRadioButton(String title) {
        return new JRadioButton(title);
    }

    // Method to add input fields and radio buttons to the form
    protected void addInformationInput() {
        // Creating labels
        deviceNameLabel = createLabel("DeviceName:");
        brandLabel = createLabel("Brand:");
        priceLabel = createLabel("Price:");
        typeLabel = createLabel("Type:");

        // Creating text fields
        deviceNameTextField = createTextField(15);
        brandTextField = createTextField(15);
        priceTextField = createTextField(15);
        typeTextField = createTextField(15);

        // Creating panels
        typePanel = createPanelWithGridLayout(1, 2);
        formPanel = createPanelWithGridLayout(4, 2);

        // Creating radio buttons and grouping them
        smartphoneRadio = createRadioButton("SmartPhone");
        tabletRadio = createRadioButton("Tablet");
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

        // Adding radio buttons to type panel
        typePanel.add(smartphoneRadio);
        typePanel.add(tabletRadio);
        typePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        formPanel.add(typeLabel);
        formPanel.add(typePanel);

        // Setting up the main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(formPanel, BorderLayout.NORTH);
        add(mainPanel,BorderLayout.NORTH);

        // Adding panels to the frame
        

    }

    @Override
    public void addComponents() {
        addButtonUnderComponents(); // Adding buttons (assumed to be in superclass)
        addInformationInput(); // Adding form inputs

       
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
