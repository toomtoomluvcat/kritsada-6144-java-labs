package beapthong.kritsada.lab9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class MobileDeviceV5 extends MobileDeviceV4 {

    /**
     * MobileDeviceV5 extends MobileDeviceV4 by adding new interactive
     * components to enhance user experience. This version introduces a JList
     * for selecting vendors where the device is available and a JSlider for
     * rating the device.
     *
     * Key Enhancements: - Adds a JList with multiple selection mode to choose
     * vendors (AIS, True, DTAC, Shopee). - Wraps the JList in a JScrollPane to
     * accommodate multiple items efficiently. - Implements a JSlider (0-10) for
     * users to rate the device. - Organizes the new components using JPanel
     * with GridLayout for a structured layout. - Places the new panel at the
     * SOUTH region of the main panel.
     *
     * Author: Kritsada Beapthong Student ID: 6730406144 Section: 2
     */
    protected JSlider rateSlide;
    protected JPanel containnerExtraPanel, vendorsPanel, ratePanel;
    protected JLabel vendorsLabel, rateLabel;
    protected String[] vendorsName = {"AIS", "True", "DTAC", "Shopee"};
    protected JList<String> vendorsList;
    protected JScrollPane vendorsPane;

    @Override
    public void addComponents() {

        super.addComponents();

        // Create a panel to hold the additional components
        containnerExtraPanel = new JPanel();

        // Initialize the JList with available vendor names
        vendorsList = new JList<>(vendorsName);

        // Allow multiple selections in the list
        vendorsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        vendorsList.setSelectedValue("AIS", true);
        // Wrap the list in a JScrollPane for better usability
        vendorsPane = new JScrollPane(vendorsList);
        vendorsPane.setPreferredSize(new Dimension(150, 70));

        // Create a label for the vendors section
        vendorsLabel = new JLabel("The device is available at:");

        // Create a panel with GridLayout to organize vendors section
        vendorsPanel = createPanelWithGridLayout(1, 2);

        // Add label and list (inside scroll pane) to the panel
        vendorsPanel.add(vendorsLabel);
        vendorsPanel.add(vendorsPane);

        // Create a label for the rating section
        rateLabel = new JLabel("Rate the device (0-10)");

        // Create a panel with GridLayout for rating section
        ratePanel = createPanelWithGridLayout(2, 1);

        // Initialize the JSlider with a range from 0 to 10, default set to 5
        rateSlide = new JSlider(0, 10, 5);

        // Configure the slider to display tick marks and labels
        rateSlide.setMajorTickSpacing(1);
        rateSlide.setPaintLabels(true);
        rateSlide.setPaintTicks(true);

        // Add the rating label and slider to the panel
        ratePanel.add(rateLabel);
        ratePanel.add(rateSlide);

        // Create a main container panel to hold both sections
        containnerExtraPanel = createPanelWithGridLayout(2, 1);

        // Add the vendors panel and rating panel to the container panel
        containnerExtraPanel.add(vendorsPanel);
        containnerExtraPanel.add(ratePanel);
        
        // Add the container panel to the main panel at the SOUTH position
        mainPanel.add(containnerExtraPanel,BorderLayout.SOUTH);
    }

    public MobileDeviceV5(String title) {
        super(title);
    }

    // Method to create and display the GUI
    public static void createAndShowGUI() {
        MobileDeviceV5 mdv5 = new MobileDeviceV5("Mobile Device V5");
        mdv5.addComponents();
        mdv5.setFrameFeatures();
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
