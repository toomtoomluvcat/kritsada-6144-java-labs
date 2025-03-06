package beapthong.kritsada.lab11;

import java.awt.*;
import java.awt.event.*;
import  javax.swing.*;

public class MobileDeviceCompleteV3 extends MobileDeviceCompleteV2 implements ComponentListener {
    /**
 * MobileDeviceCompleteV3 - An enhanced GUI application for mobile device information
 *
 * This class extends MobileDeviceCompleteV2 and implements ComponentListener to track
 * and display window events. It provides visual feedback about the window state
 * including resizing, movement, and visibility changes.
 *
 * Key Features:
 * - All features from MobileDeviceCompleteV2
 * - Window resize event notifications
 * - Window movement tracking
 * - Window visibility state updates
 * - Debounced event handling using Timers
 *
 * Usage:
 * MobileDeviceCompleteV3.createAndShowGUI();
 *
 * Author: Kritsada Beapthong
 * Student ID: 6730406144
 * Section: 2
 */


   // Timers to prevent excessive notifications during resize and move operations
    private Timer resizeTimer;
    private Timer moverTimer;
 /**
     * Overrides the parent method to add this class as a ComponentListener
     * for tracking window events
     */
    @Override
    public void addListeners() {
        super.addListeners(); // Call parent method to set up existing listeners
        this.addComponentListener(this); // Register this class to listen for component events
    }

    @Override
    public void componentResized(ComponentEvent e) {
            resizeTimer.restart(); // Restart timer to debounce resize events
    }

    @Override
    public void componentMoved(ComponentEvent e) {
            moverTimer.restart(); // Restart timer to debounce movement events
    }

     /**
     * Constructor that initializes the window with a title and sets up timers
     * for handling resize and movement events
     */
    @Override
    public void componentShown(ComponentEvent e) {
        JOptionPane.showMessageDialog(null, "Window is now visible");

    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

   

    public MobileDeviceCompleteV3(String title) {
        super(title); // Call parent constructor with the title
        
        // Initialize resize timer with delayed notification
        resizeTimer = new Timer(300, e -> {
            Dimension size = getSize(); // Get the current frame size
            JOptionPane.showMessageDialog(null, "Window resized to: " + size.width + " x " + size.height);
            resizeTimer.stop();
        });
        resizeTimer.setRepeats(false); // Ensure timer only fires once per restart
        
        // Initialize movement timer with delayed notification
        moverTimer = new Timer(300, e -> {
            Point location = getLocation(); // Get the current frame position
            JOptionPane.showMessageDialog(null, "Window moved to: X=" + location.x + " Y=" + location.y);
            moverTimer.stop();
        });
        moverTimer.setRepeats(false); // Ensure timer only fires once per restart
    }
     /**
     * Creates and configures the application window with all necessary
     * components, listeners, menus, and display properties
     */

    public static void createAndShowGUI() {
        MobileDeviceCompleteV3 window = new MobileDeviceCompleteV3("Mobile Device Complete V3");
        window.addComponents(); // Add UI components to the frame
        window.addListeners(); // Set up event listeners
        window.addMenus(); // Add menus to the frame
        window.setFrameFeatures(); // Configure frame properties
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI()); // Create GUI on the Event Dispatch Thread
    }
}
