package beapthong.kritsada.lab12;

import beapthong.kritsada.lab7.MobileDevice;
import java.io.*;
import javax.swing.*;

public class MobileDeviceV15 extends MobileDeviceV14 {

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
                    System.out.println("Adjusted filename to: " + selectedFile.getAbsolutePath());
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
        deviceList.clear();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj;
            while (true) {
                try {
                    obj = ois.readObject();
                    if (obj instanceof SmartPhone) {
                        SmartPhone device = (SmartPhone) obj;
                        System.out.println("Read SmartPhone with price: " + device.getPrice());
                        deviceList.add(device);
                    } else if (obj instanceof Tablet) {
                        Tablet device = (Tablet) obj;
                        System.out.println("Read Tablet with price: " + device.getPrice());
                        deviceList.add(device);
                    } else {
                        System.out.println("Unknown device type: " + obj.getClass().getName());
                    }
                } catch (EOFException e) {
                    break; // End of file reached
                } catch (ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Class not found when reading binary file: " + e.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Read devices from the binary file " + file.getAbsolutePath()
                + " are as follows:\n" + messageInfo());
    }

    private void openTextFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            deviceList.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] part = line.split(":");
                String type = part[0].substring(part[0].length() - 1);
                String[] partSmartPhone = part[1].split("\\(");
                String name = partSmartPhone[0].substring(1);
                String[] brandPart = partSmartPhone[1].split("\\) ");
                String brand = brandPart[0];
                String[] pricePart = brandPart[1].split(" ");
                double price = Double.parseDouble(pricePart[0].trim());
                deviceList.add(new SmartPhone(name, brand, price, type));
                System.out.println(price);
            }
            JOptionPane.showMessageDialog(null, "Read devices from the text file " + file.getAbsolutePath() + " are as follows:\n" + messageInfo());
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
