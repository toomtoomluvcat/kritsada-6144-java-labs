package beapthong.kritsada.lab11;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

/**
 * MobileDeviceCompleteV4 - An enhanced GUI application with text color customization
 *
 * This class extends MobileDeviceCompleteV2 and adds functionality for users to
 * customize the text color of all input fields using JColorChooser. The user can
 * select a custom color from a color selection dialog accessed through the menu.
 *
 * Key Features:
 * - All features from MobileDeviceCompleteV2
 * - Configuration menu with color customization options
 * - JColorChooser integration for color selection
 * - Consistent color application across all text fields
 *
 * Usage:
 * MobileDeviceCompleteV4.createAndShowGUI();
 *
 * Author: Kritsada Beapthong
 * Student ID: 6730406144
 * Section: 2
 */
public class MobileDeviceCompleteV4 extends MobileDeviceCompleteV2 implements ActionListener {

    // Menu components for color customization
    protected JMenu configMenu, colorMenu;
    protected JMenuItem customItem;

    /**
     * Handles action events from menu items, particularly the color customization option
     * 
     * @param e The action event generated when a menu item is selected
     */
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == customItem) {
            // Show color chooser dialog with white as the initial color
            Color selectedColor = JColorChooser.showDialog(colorMenu, "Choose Text Color", Color.white);
            
            // Apply the selected color to all text fields if a color was chosen
            if (selectedColor != null) {
                deviceNameField.setForeground(selectedColor);
                brandField.setForeground(selectedColor);
                priceField.setForeground(selectedColor);
            }
            // If selectedColor is null (user canceled), the color remains unchanged
        }
    }

    /**
     * Constructor that initializes the window with the specified title
     * 
     * @param title The title for the window frame
     */
    public MobileDeviceCompleteV4(String title) {
        super(title);
    }
    
    /**
     * Adds action listeners to the menu items and other components
     * Extends the parent's implementation by adding listeners for color customization
     */
    @Override
    public void addListeners() {
        super.addListeners(); // Set up existing listeners from parent class
        customItem.addActionListener(this); // Add listener for the custom color option
    }

    /**
     * Creates and configures the menu structure, extending the parent implementation
     * to include color configuration options
     */
    @Override
    protected void addMenus() {
        super.addMenus(); // Set up the basic menu structure from parent class

        // Create new menu components for color customization
        configMenu = new JMenu("Config");
        colorMenu = new JMenu("Color");
        customItem = new JMenuItem("Custom");

        // Assemble the menu hierarchy
        colorMenu.add(customItem);
        configMenu.add(colorMenu);

        // Add the config menu to the menu bar
        menuBar.add(configMenu);

        // Set the completed menu bar for the frame
        setJMenuBar(menuBar);
    }

    /**
     * Creates and configures the application window with all necessary
     * components, menus, listeners, and display properties
     */
    public static void createAndShowGUI() {
        MobileDeviceCompleteV4 window = new MobileDeviceCompleteV4("Mobile Device Complete V4");
        window.addComponents(); // Add UI components to the frame
        window.addMenus(); // Set up menu structure including color options
        window.addListeners(); // Configure event listeners
        window.setFrameFeatures(); // Set frame properties and make it visible
    }

    /**
     * Main entry point for the application
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Launch the application on the Event Dispatch Thread for thread safety
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}