package beapthong.kritsada.lab12;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MobileDeviceV14 extends MobileDeviceV13 {
    /**
 * MobileDeviceV14 - Extends MobileDeviceV13 to handle file operations (open and save).
 *
 * This class extends `MobileDeviceV13` to provide functionality for opening and saving device data to/from text files.
 * It allows users to choose a file using a file chooser and processes device details from text files. It also supports saving the device list to a file.
 * 
 * Key Features:
 * - Allows the user to select a file to open (.txt files only).
 * - Reads and parses device data from the selected file and displays the list of devices.
 * - Allows the user to save the device data into a text file, ensuring the file has a `.txt` extension.
 * - Provides feedback through message dialogs to inform users about the success or failure of file operations.
 * 
 * Methods:
 * - `handleMenuOpen`: Opens a file dialog to select a file, reads its contents, and adds devices to the device list.
 * - `handleMenuSave`: Opens a file dialog to select a location for saving, writes the device list to a text file.
 * 
 * Author: Kritsada Beapthong  
 * Student ID: 6730406144  
 * Section: 2  
 */

    protected File selectedFile;

    public MobileDeviceV14(String title) {
        super(title);

        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text Files", "txt")); // Filter to show only .txt files
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource(); // Get the source of the event

        if (src == openItem) {
            handleMenuOpen(); // Open file handling
        } else if (src == saveItem) {
            handleMenuSave(); // Save file handling
        } else {
            super.actionPerformed(e); // Delegate to superclass for other actions
        }
    }

    protected void handleMenuOpen() {
        // Show the file chooser dialog and get the user's selection
        int value = fileChooser.showOpenDialog(null);

        // If the user selects a file and clicks "Open"
        if (value == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Opening: " + selectedFile.getAbsolutePath());

            // Try to read the selected file
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;

                // Read each line and extract device details
                while ((line = reader.readLine()) != null) {
                    String[] part = line.split(":");
                    String type = part[0].substring(part[0].length() - 1); // Extract device type

                    String[] partSmartPhone = part[1].split("\\(");
                    String name = partSmartPhone[0].substring(1); // Extract name

                    String[] brandpart = partSmartPhone[1].split("\\) ");
                    String brand = brandpart[0]; // Extract brand

                    String[] pricePart = brandpart[1].split(" ");
                    double price = Double.parseDouble(pricePart[0].trim()); // Extract price

                    // Create a new SmartPhone object and add it to the list
                    deviceList.add(new SmartPhone(name, brand, price, type));
                }

                // Display a message showing the loaded devices
                JOptionPane.showMessageDialog(null,
                        "Read device from the file " + selectedFile.getAbsolutePath()
                        + " are as follows:\n" + messageInfo());

            } catch (IOException ex) {
                System.out.println("Error reading file: " + ex);
            }
        }
    }

    protected void handleMenuSave() {
        // Show the file chooser dialog and get the user's selection
        int returnValue = fileChooser.showSaveDialog(this);

        // If the user selects a file and clicks "Save"
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();

            // Ensure the file has a .txt extension
            if (!selectedFile.getName().endsWith(".txt")) {
                selectedFile = new File(selectedFile.getAbsolutePath() + ".txt");
            }

            // Try to write the device list data to the selected file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
                String contentToSave = messageInfo();
                writer.write(contentToSave);

                // Display success message
                JOptionPane.showMessageDialog(this,
                        "Data is saved to " + selectedFile.getAbsolutePath() + " successfully!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
                // Display error message if saving fails
                JOptionPane.showMessageDialog(this,
                        "Error saving file: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void createAndShowGUI() {
        MobileDeviceV14 window = new MobileDeviceV14("Mobile Device V14");
        window.addComponents();
        window.addListeners();
        window.addChangeListener();
        window.addListSelectionListener();
        window.addShortKey();
        window.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
