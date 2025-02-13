package beapthong.kritsada.lab9;

import java.awt.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MobileDeviceV6 extends MobileDeviceV5 {

    /**
     * MobileDeviceV6 extends MobileDeviceV5 by enhancing the graphical user
     * interface (GUI) with improved styling and a more visually appealing
     * design. This version utilizes UIManager to apply consistent colors,
     * fonts, and styles to various components.
     *
     * Key Enhancements: - Applies a dark blue color (#000080) and bold Arial
     * font to all labels. - Sets light gray backgrounds and dark gray italic
     * fonts for text fields. - Customizes text areas with a soft yellow
     * background (RGB 255, 255, 204) for readability. - Modifies the vendors
     * list to use a green font, light gray background, and yellow selection
     * color. - Adjusts the appearance of reset and submit buttons, setting
     * foreground and background colors. - Ensures UI consistency by defining
     * styles globally through UIManager before initializing components.
     *
     * Author: Kritsada Beapthong Student ID: 6730406144 Section: 2
     */

    @Override
    public void addComponents() {
        // Set label text color and font style
        UIManager.put("Label.foreground", Color.decode("#000080"));
        UIManager.put("Label.font", new Font("Arial", Font.BOLD, 14));

        // Set text field background color, text color, and font style
        UIManager.put("TextField.background", Color.LIGHT_GRAY);
        UIManager.put("TextField.foreground", Color.DARK_GRAY);
        UIManager.put("TextField.font", new Font("Arial", Font.ITALIC, 14));

        // Set text area background color, text color, and font style
        UIManager.put("TextArea.background", new Color(255, 255, 204));
        UIManager.put("TextArea.foreground", Color.DARK_GRAY);
        UIManager.put("TextArea.font", new Font("Arial", Font.ITALIC, 14));

        // Call the parent method to add other components
        super.addComponents();

        // Customize vendors list appearance
        vendorsList.setBackground(Color.LIGHT_GRAY);
        vendorsList.setForeground(Color.decode("#006400"));
        vendorsList.setFont(new Font("Arial", Font.BOLD, 14));
        vendorsList.setSelectionBackground(Color.yellow);
        vendorsList.setSelectionForeground(Color.black);

        // Set reset button color scheme
        resetButton.setForeground(Color.red);
        resetButton.setBackground(Color.white);

        // Set submit button color scheme
        submitButton.setForeground(Color.green);
        submitButton.setBackground(Color.white);

      
    }

    public MobileDeviceV6(String title) {
        super(title);
    }
 // Method to create and display the GUI
    public static void createAndShowGUI() {
        MobileDeviceV6 mdv6 = new MobileDeviceV6("Mobile device V6");
        mdv6.addComponents();
        mdv6.setFrameFeatures();
    }
    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

}
