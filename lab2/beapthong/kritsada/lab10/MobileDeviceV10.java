package beapthong.kritsada.lab10;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * MobileDeviceV10 - Extends MobileDeviceV9 to add interactive components and
 * event handling for: - Operating System selection from a combo box. - Vendor
 * selection from a list. - Device rating using a slider.
 *
 * This class builds upon MobileDeviceV9 by incorporating user interaction
 * elements and their corresponding event listeners and handlers. It implements
 * `ItemListener`, `ListSelectionListener`, and `ChangeListener` to respond to
 * changes in the combo box, list, and slider, respectively.
 *
 * Key Features: - Displays a message dialog upon changing the selected
 * operating system in the `operatingComboBox`. - Displays a message dialog upon
 * changing the selected vendor(s) in the `vendorsList`. - Displays a message
 * dialog showing the new rating value when the `rateSlide` is adjusted.
 *
 * Author: Kritsada Beapthong Student ID: 6730406144 Section: 2
 */
public class MobileDeviceV10 extends MobileDeviceV9 implements ItemListener, ListSelectionListener, ChangeListener {

    /**
     * Constructor for the MobileDeviceV10 class.
     *
     * @param title The title of the application window.
     */
    public MobileDeviceV10(String title) {
        super(title); // Calls the constructor of the superclass (MobileDeviceV9).
    }

    /**
     * Adds a ChangeListener to the `rateSlide` slider.
     */
    public void addChangeListener() {
        rateSlide.addChangeListener(this); // Attaches the current instance as a ChangeListener to the slider.
    }

    /**
     * Handles the state change event triggered by the `rateSlide` slider.
     * Displays a message dialog with the new rating value.
     *
     * @param e The ChangeEvent object.
     */
    @Override
    public void stateChanged(ChangeEvent e) {

        if (!rateSlide.getValueIsAdjusting()) { // Checks if the slider is no longer being actively adjusted by the user.  This prevents rapid-fire message dialogs.
            JOptionPane.showMessageDialog(null, "new rating: " + rateSlide.getValue(), "Rating Adjusment", JOptionPane.INFORMATION_MESSAGE); // Displays a message dialog showing the new slider value.
        }
    }

    /**
     * Handles the item state change event triggered by the `operatingComboBox`
     * combo box. Displays a message dialog with the selected operating system.
     *
     * @param e The ItemEvent object.
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        Object src = e.getSource(); // Gets the source of the event.

        if (src == operatingComboBox) { // Checks if the event originated from the operating system combo box.
            if (e.getStateChange() == ItemEvent.SELECTED) { // Checks if the item's selection state has changed to SELECTED.
                JOptionPane.showMessageDialog(null, "You selected Operating System:" + e.getItem(), "OS Selection", JOptionPane.INFORMATION_MESSAGE); // Displays a message dialog showing the selected OS.
            }
        }
    }

    /**
     * Handles the value change event triggered by the `vendorsList` list.
     * Displays a message dialog with the selected vendor(s).
     *
     * @param e The ListSelectionEvent object.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        Object src = e.getSource(); // Gets the source of the event.
        if (src == vendorsList) { // Checks if the event originated from the vendors list.
            if (!e.getValueIsAdjusting()) { // Checks if the list selection is no longer being actively adjusted by the user.
                JOptionPane.showMessageDialog(null, "Device is available at: " + String.join(",", vendorsList.getSelectedValuesList())); // Displays a message dialog showing the selected vendor(s).  Uses String.join to concatenate multiple selections.
            }
        }

    }

    /**
     * Adds a ListSelectionListener to the `vendorsList` list.
     */
    public void addListSelectionListener() {
        vendorsList.addListSelectionListener(this); // Attaches the current instance as a ListSelectionListener to the list.
    }

    /**
     * Adds an ItemListener to the `operatingComboBox` combo box. Overrides the
     * superclass's `addListeners` method.
     */
    @Override
    public void addListeners() {
        super.addListeners(); // Calls the superclass's `addListeners()` method to ensure its listeners are also added.
        operatingComboBox.addItemListener(this); // Adds the current instance as an ItemListener to the operating system combo box.
    }

    /**
     * Method to create and display the GUI.
     */
    public static void createAndShowGUI() {
        MobileDeviceV10 mdv10 = new MobileDeviceV10("Mobile device V10"); // Creates a new instance of the MobileDeviceV10 class.
        mdv10.addComponents(); // Calls the `addComponents()` method to add GUI components.  This is assumed to be defined in MobileDeviceV9 or its parent.
        mdv10.addListeners(); // Calls the `addListeners()` method to add action listeners.
        mdv10.addChangeListener(); // Calls the `addChangeListener()` method to add the change listener to the slider.
        mdv10.addListSelectionListener(); // Calls the `addListSelectionListener()` method to add the list selection listener to the list.
        mdv10.setFrameFeatures(); // Calls the `setFrameFeatures()` method to set window properties. This is assumed to be defined in MobileDeviceV9 or its parent.
    }

    /**
     * Main method to run the application.
     *
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI()); // Uses SwingUtilities.invokeLater to create and show the GUI on the Event Dispatch Thread (EDT).
    }
}
