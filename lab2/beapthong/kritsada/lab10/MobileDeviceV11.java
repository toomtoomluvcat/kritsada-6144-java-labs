package beapthong.kritsada.lab10;

import java.awt.event.*;
import javax.swing.*;

/**
 * MobileDeviceV11 - Extends MobileDeviceV10 to add radio button selection messages and mnemonics/accelerators
 * to the menu items (New, Open, Save, Exit).
 *
 * This class enhances MobileDeviceV10 by implementing:
 *   - Display of message dialogs upon radio button selection (Tablet or SmartPhone).
 *   - Mnemonic keys (e.g., Alt+N for New) for menu items.
 *   - Accelerator keys (e.g., Ctrl+N for New) for menu items.
 *
 * Key Features:
 *   - Shows "Tablet is selected" or "SmartPhone is selected" when the respective radio button is chosen.
 *   - Provides keyboard shortcuts for New, Open, Save, and Exit menu actions.
 *
 * Author: Kritsada Beapthong
 * Student ID: 6730406144
 * Section: 2
 */
public class MobileDeviceV11 extends MobileDeviceV10 {

    /**
     * Constructor for the MobileDeviceV11 class.
     *
     * @param title The title of the application window.
     */
    public MobileDeviceV11(String title) {
        super(title); // Calls the constructor of the superclass (MobileDeviceV10).
    }

    /**
     * Adds mnemonic keys (Alt+key) and accelerator keys (Ctrl+key or Cmd+key) to the menu items.
     */
    public void addShortKey() {
        // Mnemonic keys (Alt + Key)
        newItem.setMnemonic(KeyEvent.VK_N); // Sets mnemonic key 'N' for New menu item.
        openItem.setMnemonic(KeyEvent.VK_O);  // Sets mnemonic key 'O' for Open menu item.
        saveItem.setMnemonic(KeyEvent.VK_S);  // Sets mnemonic key 'S' for Save menu item.
        exitItem.setMnemonic(KeyEvent.VK_X);  // Sets mnemonic key 'X' for Exit menu item.

        // Accelerator keys (Ctrl/Cmd + Key)
        newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK)); // Sets accelerator key Ctrl+N for New menu item.
        openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK)); // Sets accelerator key Ctrl+O for Open menu item.
        saveItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK)); // Sets accelerator key Ctrl+S for Save menu item.
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK)); // Sets accelerator key Ctrl+Q for Exit menu item.  Note: 'Q' used instead of 'X' as per the prompt requirement.

    }

    /**
     * Handles the item state change event for the radio buttons (Tablet and SmartPhone).
     * Displays a message dialog indicating which radio button was selected.
     *
     * @param e The ItemEvent object.
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        Object src = e.getSource(); // Gets the source of the event.
        if (e.getStateChange() == ItemEvent.SELECTED) { // Checks if the item's selection state has changed to SELECTED.
            if (src == tabletRadio) { // Checks if the event originated from the tablet radio button.
                JOptionPane.showMessageDialog(null, "Tablet is selected"); // Displays a message dialog.
            } else if (src == smartphoneRadio) { // Checks if the event originated from the smartphone radio button.
                JOptionPane.showMessageDialog(null, "SmartPhone is selected"); // Displays a message dialog.
            }
        }
    }

    /**
     * Adds ItemListeners to the radio buttons (Tablet and SmartPhone).
     * Overrides the superclass's `addListeners` method.
     */
    @Override
    public void addListeners() {
        super.addListeners(); // Calls the superclass's `addListeners()` method to ensure its listeners are also added.
        tabletRadio.addItemListener(this);   // Adds the current instance as an ItemListener to the tablet radio button.
        smartphoneRadio.addItemListener(this); // Adds the current instance as an ItemListener to the smartphone radio button.
    }

    /**
     * Method to create and display the GUI.
     */
    public static void createAndShowGUI() {
        MobileDeviceV11 mdv11 = new MobileDeviceV11("Mobile Device V11"); // Creates a new instance of the MobileDeviceV11 class.
        mdv11.addComponents(); // Calls the `addComponents()` method to add GUI components.
        mdv11.addListeners(); // Calls the `addListeners()` method to add action listeners.
        mdv11.addChangeListener(); // Calls the `addChangeListener()` method from the superclass (MobileDeviceV10).
        mdv11.addListSelectionListener(); // Calls the `addListSelectionListener()` method from the superclass (MobileDeviceV10).
        mdv11.addShortKey(); // Calls the `addShortKey()` method to add mnemonic and accelerator keys.
        mdv11.setFrameFeatures(); // Calls the `setFrameFeatures()` method to set window properties.

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