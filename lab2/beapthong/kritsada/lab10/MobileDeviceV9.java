package beapthong.kritsada.lab10;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MobileDeviceV9 extends MobileDeviceV8 {

    /**
     * MobileDeviceV9 - Extends MobileDeviceV8 to add file handling capabilities
     * and direct font manipulations.
     *
     * This class extends MobileDeviceV8 and implements ActionListener to handle
     * user interactions. It builds upon the functionality of V8 by adding
     * features for: - Opening, saving, and creating new files. - Directly
     * manipulating the font of the text fields and text area through menu
     * actions.
     *
     * Key enhancements: - File menu with "Open", "Save", "New", and "Exit"
     * options. - Direct font size adjustment through menu items (Small, Medium,
     * Large, Extra Large). - Direct font color adjustment through menu items
     * (Black, Red, Green, Blue). - Direct font style adjustment through menu
     * items (Serif, SansSerif, Monospaced).
     *
     * Usage example: MobileDeviceV9.createAndShowGUI(); // Call this static
     * method to launch the application.
     *
     * Author: Kritsada Beapthong Student ID: 6730406144 Section: 2
     */
    protected JFileChooser fileChooser;

    public MobileDeviceV9(String title) {
        super(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e); // Calls the actionPerformed method of the superclass (if any).  This is good practice as the superclass might have important logic to execute.
        Object src = e.getSource(); // Gets the source of the action event. This is the component that triggered the event (e.g., a button click, menu item selection).

        // **File Menu Actions**
        if (src == openItem) { // Checks if the action came from the "Open" menu item.
            JFileChooser fileChooser = new JFileChooser(); // Creates a new file chooser dialog.
            int value = fileChooser.showOpenDialog(null); // Displays the "Open" dialog.  The `null` argument means the dialog is centered on the screen. `showOpenDialog` returns an integer representing the user's choice.
            if (value == JFileChooser.APPROVE_OPTION) { // Checks if the user clicked "Open" or "OK" in the dialog.
                File selectedFile = fileChooser.getSelectedFile(); // Gets the selected file object.
                JOptionPane.showMessageDialog(null, "Opening: " + selectedFile.getName(), "Message", JOptionPane.INFORMATION_MESSAGE); // Displays a message dialog informing the user which file is being opened.
            }
        } else if (src == saveItem) { // Checks if the action came from the "Save" menu item.
            JFileChooser fileChooser = new JFileChooser(); // Creates a new file chooser dialog.
            fileChooser.setDialogTitle("Save File"); // Sets the title of the "Save" dialog.
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt"); // Creates a filter to only show files with the ".txt" extension.
            fileChooser.setFileFilter(filter); // Applies the filter to the file chooser.
            int value = fileChooser.showSaveDialog(null); // Displays the "Save" dialog.
            if (value == JFileChooser.APPROVE_OPTION) { // Checks if the user clicked "Save" or "OK" in the dialog.
                System.out.println(fileChooser.getSelectedFile().getName()); // Prints the name of the selected file to the console (useful for debugging).
                JOptionPane.showMessageDialog(null, "Data is saved to " + fileChooser.getSelectedFile().getName() + ".txt successfully!", "Save", JOptionPane.INFORMATION_MESSAGE); // Displays a success message to the user. Note the forced ".txt" extension.  This could be problematic if the user intends to save the file with a different extension or no extension.
            }
        } else if (src == newItem) { // Checks if the action came from the "New" menu item.
            clearData(); // Calls the `clearData()` method (presumably defined elsewhere in the class) to clear the contents of the text fields and text area.
        } else if (src == exitItem) { // Checks if the action came from the "Exit" menu item.
            System.exit(0); // Exits the application.  `0` indicates a normal exit.

            // **Font Size Menu Actions**
        } else if (src == smallItem) { // Checks if the action came from the "Small" font size menu item.
            deviceNameTextField.setFont(new Font("Arial", Font.PLAIN, 10)); // Sets the font of the `deviceNameTextField` to Arial, plain style, size 10.
            brandTextField.setFont(new Font("Arial", Font.PLAIN, 10)); // Sets the font of the `brandTextField` to Arial, plain style, size 10.
            priceTextField.setFont(new Font("Arial", Font.PLAIN, 10)); // Sets the font of the `priceTextField` to Arial, plain style, size 10.
            featuresTextArea.setFont(new Font("Arial", Font.PLAIN, 10)); // Sets the font of the `featuresTextArea` to Arial, plain style, size 10.
        } else if (src == mediumItem) { // Checks if the action came from the "Medium" font size menu item.
            deviceNameTextField.setFont(new Font("Arial", Font.PLAIN, 14)); // Sets the font to Arial, plain style, size 14.
            brandTextField.setFont(new Font("Arial", Font.PLAIN, 14));
            priceTextField.setFont(new Font("Arial", Font.PLAIN, 14));
            featuresTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        } else if (src == largeItem) { // Checks if the action came from the "Large" font size menu item.
            deviceNameTextField.setFont(new Font("Arial", Font.PLAIN, 18)); // Sets the font to Arial, plain style, size 18.
            brandTextField.setFont(new Font("Arial", Font.PLAIN, 18));
            priceTextField.setFont(new Font("Arial", Font.PLAIN, 18));
            featuresTextArea.setFont(new Font("Arial", Font.PLAIN, 18));
        } else if (src == extraLargeItem) { // Checks if the action came from the "Extra Large" font size menu item.
            deviceNameTextField.setFont(new Font("Arial", Font.PLAIN, 22)); // Sets the font to Arial, plain style, size 22.
            brandTextField.setFont(new Font("Arial", Font.PLAIN, 22));
            priceTextField.setFont(new Font("Arial", Font.PLAIN, 22));
            featuresTextArea.setFont(new Font("Arial", Font.PLAIN, 22));

            // **Font Color Menu Actions**
        } else if (src == blackItem) { // Checks if the action came from the "Black" font color menu item.
            deviceNameTextField.setForeground(Color.BLACK); // Sets the text color to black.
            brandTextField.setForeground(Color.BLACK);
            priceTextField.setForeground(Color.BLACK);
            featuresTextArea.setForeground(Color.BLACK);
        } else if (src == redItem) { // Checks if the action came from the "Red" font color menu item.
            deviceNameTextField.setForeground(Color.RED); // Sets the text color to red.
            brandTextField.setForeground(Color.RED);
            priceTextField.setForeground(Color.RED);
            featuresTextArea.setForeground(Color.RED);
        } else if (src == greenItem) { // Checks if the action came from the "Green" font color menu item.
            deviceNameTextField.setForeground(Color.GREEN); // Sets the text color to green.
            brandTextField.setForeground(Color.GREEN);
            priceTextField.setForeground(Color.GREEN);
            featuresTextArea.setForeground(Color.GREEN);
        } else if (src == blueItem) { // Checks if the action came from the "Blue" font color menu item.
            deviceNameTextField.setForeground(Color.BLUE); // Sets the text color to blue.
            brandTextField.setForeground(Color.BLUE);
            priceTextField.setForeground(Color.BLUE);
            featuresTextArea.setForeground(Color.BLUE);

            // **Font Style Menu Actions**
        } else if (src == font1Item) { // Checks if the action came from the first font style menu item.
            deviceNameTextField.setFont(new Font("Serif", Font.PLAIN, deviceNameTextField.getFont().getSize())); // Sets the font to Serif, plain style, and retains the current font size.
            brandTextField.setFont(new Font("Serif", Font.PLAIN, deviceNameTextField.getFont().getSize()));
            priceTextField.setFont(new Font("Serif", Font.PLAIN, deviceNameTextField.getFont().getSize()));
            featuresTextArea.setFont(new Font("Serif", Font.PLAIN, deviceNameTextField.getFont().getSize()));
        } else if (src == font2Item) { // Checks if the action came from the second font style menu item.
            deviceNameTextField.setFont(new Font("SansSerif", Font.PLAIN, deviceNameTextField.getFont().getSize())); // Sets the font to SansSerif, plain style, and retains the current font size.
            brandTextField.setFont(new Font("SansSerif", Font.PLAIN, deviceNameTextField.getFont().getSize()));
            priceTextField.setFont(new Font("SansSerif", Font.PLAIN, deviceNameTextField.getFont().getSize()));
            featuresTextArea.setFont(new Font("SansSerif", Font.PLAIN, deviceNameTextField.getFont().getSize()));
        } else if (src == font3Item) { // Checks if the action came from the third font style menu item.
            deviceNameTextField.setFont(new Font("Monospaced", Font.PLAIN, deviceNameTextField.getFont().getSize())); // Sets the font to Monospaced, plain style, and retains the current font size.
            brandTextField.setFont(new Font("Monospaced", Font.PLAIN, deviceNameTextField.getFont().getSize()));
            priceTextField.setFont(new Font("Monospaced", Font.PLAIN, deviceNameTextField.getFont().getSize()));
            featuresTextArea.setFont(new Font("Monospaced", Font.PLAIN, deviceNameTextField.getFont().getSize()));
        }
    }

    //add action listeners to component and item-
    @Override
    public void addListeners() {
        super.addListeners();
        //file Item
        newItem.addActionListener(this);
        saveItem.addActionListener(this);
        openItem.addActionListener(this);
        exitItem.addActionListener(this);

        //font size
        smallItem.addActionListener(this);
        mediumItem.addActionListener(this);
        largeItem.addActionListener(this);
        extraLargeItem.addActionListener(this);

        //font color
        blackItem.addActionListener(this);
        redItem.addActionListener(this);
        greenItem.addActionListener(this);
        blueItem.addActionListener(this);

        //font family
        font1Item.addActionListener(this);
        font2Item.addActionListener(this);
        font3Item.addActionListener(this);
    }

    // Method to create and display the GUI
    public static void createAndShowGUI() {
        MobileDeviceV9 mdv9 = new MobileDeviceV9("Mobile device V9");
        mdv9.addComponents();
        mdv9.addListeners();
        mdv9.setFrameFeatures();
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
