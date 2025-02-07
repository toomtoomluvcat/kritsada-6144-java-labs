package beapthong.kritsada.lab8;

import java.awt.BorderLayout;
import javax.swing.*;

public class MobileDeviceV2 extends MobileDeviceV1 {

    /**
     * MobileDeviceV2 extends MobileDeviceV1 to add functionality for selecting
     * the operating system and entering device features. It enhances the user
     * interface by incorporating a JComboBox for OS selection and a JTextArea
     * with JScrollPane for inputting features. This version uses GridLayout for
     * a more organized layout.
     *
     * The class builds on the previous version, improving usability with
     * scrollable text areas and non-editable combo boxes, while retaining core
     * functionality from MobileDeviceV1.
     *
     * Author: Kritsada Beapthong Student ID: 6730406144 Section: 2
     */
    
    protected JScrollPane featuresScrollPane;
    protected JLabel operatingLabel, featuresLabel;
    protected JPanel extraPanel;
    protected JComboBox<String> operatingComboBox;
    protected JTextArea featuresTextArea;

    // Constructor to set the window title
    public MobileDeviceV2(String title) {
        super(title);
    }
// Method to create and display the GUI

    public static void createAndShowGUI() {
        MobileDeviceV2 mdv2 = new MobileDeviceV2("Mobile Device V2");
        mdv2.addComponents();
        mdv2.setFrameFeatures();
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    // Override the method to add components to the UI
    @Override
    public void addComponents() {
        super.addComponents();
        operatingLabel = new JLabel("Operating System:");
        String[] options = {"Android", "iOS", "Windows", "Others"};
        operatingComboBox = new JComboBox<>(options);
        operatingComboBox.setSelectedIndex(0);
        operatingComboBox.setEditable(false);

        // Create a label and a text area with scroll support for features
        featuresLabel = new JLabel("Features:");
        featuresTextArea = new JTextArea(3, 25);
        featuresTextArea.setLineWrap(true);
        featuresTextArea.setWrapStyleWord(true);
        featuresScrollPane = new JScrollPane(featuresTextArea);
        featuresScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        featuresScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Create a panel with GridLayout to organize components
        extraPanel = createPanelWithGridLayout(2, 2);

        // Add components to the extra panel
        extraPanel.add(operatingLabel);
        extraPanel.add(operatingComboBox);
        extraPanel.add(featuresLabel);
        extraPanel.add(featuresScrollPane);

        mainPanel.add(extraPanel,BorderLayout.CENTER);

        // Add the main panel to the frame
        add(mainPanel);
        
    }

}
