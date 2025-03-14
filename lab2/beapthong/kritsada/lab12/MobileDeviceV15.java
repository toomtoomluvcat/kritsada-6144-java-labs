package beapthong.kritsada.lab12;

import beapthong.kritsada.lab7.MobileDevice;
import java.io.*;
import javax.swing.*;

public class MobileDeviceV15 extends MobileDeviceV14 {
    /**
 * MobileDeviceV12 - Extends MobileDeviceV11 to enhance form validation and event handling.
 *
 * This class extends `MobileDeviceV11` by improving user interaction through:
 * - Validating text fields for device name, brand, and price.
 * - Enabling/disabling components dynamically based on user input.
 * - Handling price input validation to ensure only positive numeric values are allowed.
 * - Implementing additional UI behaviors such as radio button control based on price validity.
 *
 * Key Features:
 * - Disables form components when invalid input is detected.
 * - Enables the correct input sequence, guiding users through proper data entry.
 * - Provides informative error messages when incorrect values are entered.
 *
 * Author: Kritsada Beapthong  
 * Student ID: 6730406144  
 * Section: 2  
 */

    JMenu formatMenu;
    JCheckBoxMenuItem textCheckBoxMenuItem, binaryBoxMenuItem;
    ButtonGroup saveTypeGroup;

    public MobileDeviceV15(String title) {
        super(title);
    }

    @Override
    public void addComponents() {
        super.addComponents();

        formatMenu = new JMenu("Format");
        saveTypeGroup = new ButtonGroup();

        textCheckBoxMenuItem = new JCheckBoxMenuItem("Text");
        binaryBoxMenuItem = new JCheckBoxMenuItem("Binary");

        saveTypeGroup.add(textCheckBoxMenuItem);
        saveTypeGroup.add(binaryBoxMenuItem);

        formatMenu.add(textCheckBoxMenuItem);
        formatMenu.add(binaryBoxMenuItem);

        configMenu.add(formatMenu);
        deviceMenuBar.add(configMenu);
        setJMenuBar(deviceMenuBar);
        textCheckBoxMenuItem.setSelected(true);
    }

    @Override
    public void handleMenuSave() {
        if (binaryBoxMenuItem.isSelected()) {
            int returnValue = fileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();

                // Ensure the file has a ".bin" extension
                if (!selectedFile.getName().endsWith(".bin")) {
                    selectedFile = new File(selectedFile.getAbsolutePath() + ".bin");
                }

                // Save to binary file
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(selectedFile))) {
                    for (MobileDevice device : deviceList) {
                        oos.writeObject(device);
                    }
                    JOptionPane.showMessageDialog(this, "Data is saved to " + selectedFile.getAbsolutePath() + " successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            // Call super method to handle text file saving
            super.handleMenuSave();
        }
    }

    @Override
    protected void handleMenuOpen() {
        int value = fileChooser.showOpenDialog(null);
        if (value == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Opening: " + selectedFile.getAbsolutePath());

            try {
                if (isBinaryFile(selectedFile)) {
                    openBinaryFile(selectedFile);
                } else {
                    openTextFile(selectedFile);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error reading file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean isBinaryFile(File file) throws IOException {
        String filename = file.getName();
        String fileExtension = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();

        if (fileExtension.equals("bin")) {
            return true;
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead = fis.read(buffer);
            for (int i = 0; i < bytesRead; i++) {
                if (buffer[i] < 0x09) {
                    return true; // Possibly binary file due to control characters
                }
            }
        }
        return false; // Assume it's a text file if not binary
    }

    private void openBinaryFile(File file) throws IOException {
        deviceList.clear();  // Clear the existing device list before loading new data
    
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj;
            while (true) {
                try {
                    obj = ois.readObject();  // Read an object from the binary stream
                    if (obj instanceof SmartPhone) {
                        SmartPhone device = (SmartPhone) obj;  // Cast to SmartPhone
                        deviceList.add(device);  // Add the SmartPhone to the list
                    } else if (obj instanceof Tablet) {
                        Tablet device = (Tablet) obj;  // Cast to Tablet
                        deviceList.add(device);  // Add the Tablet to the list
                    }
                } catch (EOFException e) {
                    break;  // End of file reached, exit loop
                } catch (ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Class not found when reading binary file: " + e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);  // Handle deserialization errors
                    break;
                }
            }
        }
    
        JOptionPane.showMessageDialog(null, "Read devices from the binary file " + file.getAbsolutePath()
                + " are as follows:\n" + messageInfo());  // Show a dialog with the list of devices
    }

//     * @param file The file to be opened and read.
//  * @throws IOException if an error occurs during file reading.
//  */
    private void openTextFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            deviceList.clear();  // Clear the existing device list before loading new data
            String line;
            while ((line = reader.readLine()) != null) {
                String[] part = line.split(":");  // Split the line by ':' to separate type from device details
                String type = part[0].substring(part[0].length() - 1);  // Extract the device type (SmartPhone or Tablet)
                String[] partSmartPhone = part[1].split("\\(");  // Split name and brand
                String name = partSmartPhone[0].substring(1);  // Extract device name, removing leading space
                String[] brandPart = partSmartPhone[1].split("\\) ");  // Split brand and price
                String brand = brandPart[0];  // Extract the brand name
                String[] pricePart = brandPart[1].split(" ");  // Split the price portion
                double price = Double.parseDouble(pricePart[0].trim());  // Parse the price and trim extra spaces
                deviceList.add(new SmartPhone(name, brand, price, type));  // Add the parsed device to the list
            }
            JOptionPane.showMessageDialog(null, "Read devices from the text file " + file.getAbsolutePath() + " are as follows:\n" + messageInfo());  // Show a dialog with the list of devices
        }
    }

    public static void createAndShowGUI() {
        MobileDeviceV15 window = new MobileDeviceV15("Mobile Device V15");
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
