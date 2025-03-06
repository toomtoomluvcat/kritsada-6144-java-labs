package beapthong.kritsada.lab12;

import beapthong.kritsada.lab7.SmartPhone;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

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
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());

                if (!selectedFile.getName().endsWith(".bin")) {
                    selectedFile = new File(selectedFile.getAbsolutePath() + ".bin");
                    System.out.println("Adjusted filename to: " + selectedFile.getAbsolutePath());
                }

                try {
                    if (!selectedFile.exists()) {
                        boolean created = selectedFile.createNewFile();
                        System.out.println("File created: " + created);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error creating file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                    return;
                }

                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(selectedFile))) {
                    for (SmartPhone device : smartPhoneList) {
                        oos.writeObject(device);
                        System.out.println("Wrote device: " + device);
                    }
                    JOptionPane.showMessageDialog(this, "Data is saved to " + selectedFile.getAbsolutePath() + " successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
            }
        } else {
            super.handleMenuSave();
        }
    }

    @Override
    protected void handleMenuOpen() {
        int value = fileChooser.showOpenDialog(null); // Display the "Open" dialog
        if (value == JFileChooser.APPROVE_OPTION) { // Check if the user clicked "Open"
            selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Opening: " + selectedFile.getAbsolutePath());

            // Try to determine if the file is binary or text based on the extension or content
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
        // A simple way to check for binary files is by reading the first few characters
        // You can also check the file extension if you have a known convention
        String filename = file.getName();
        String fileExtension = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();

        // Assuming ".bin" or similar for binary files as a simple check
        if (fileExtension.equals("bin")) {
            return true;
        }

        // If extensions aren't sufficient, you can try reading the file header or analyze content
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead = fis.read(buffer);
            for (int i = 0; i < bytesRead; i++) {
                if (buffer[i] < 0x09) {
                    return true;
                }
            }
        }
        return false;
    }

    private void openBinaryFile(File file) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj;
            while (true) { // Continue until EOFException is thrown
                obj = ois.readObject();
                if (obj instanceof SmartPhone) {
                    smartPhoneList.add((SmartPhone) obj);
                }
            }
        } catch (EOFException e) {
            // This exception indicates the end of the binary file
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Class not found when reading binary file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        JOptionPane.showMessageDialog(null, "Read devices from the binary file " + file.getAbsolutePath() + " are as follows:\n" + messageInfo());
    }

    private void openTextFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
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
                smartPhoneList.add(new SmartPhone(name, brand, price, type));
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
