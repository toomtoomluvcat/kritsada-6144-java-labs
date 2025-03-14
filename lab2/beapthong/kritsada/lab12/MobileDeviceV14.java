package beapthong.kritsada.lab12;

import beapthong.kritsada.lab7.MobileDevice;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class MobileDeviceV14 extends MobileDeviceV13 {
    
    protected File selectedFile;
    protected ArrayList<MobileDevice> deviceList = new ArrayList<>();

    public MobileDeviceV14(String title) {
        super(title);
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text Files", "txt"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == openItem) {
            handleMenuOpen();
        } else if (src == saveItem) {
            handleMenuSave();
        } else {
            super.actionPerformed(e);
        }
    }

    protected void handleMenuOpen() {
        int value = fileChooser.showOpenDialog(null);

        if (value == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Opening: " + selectedFile.getAbsolutePath());

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                deviceList.clear(); // Clear existing list before loading new data
                String line;

                while ((line = reader.readLine()) != null) {
                    // Assume file format "SmartPhone:name(brand) price"
                    String[] part = line.split(":");
                    String type = part[0].substring(part[0].length() - 1);

                    String[] partSmartPhone = part[1].split("\\(");
                    String name = partSmartPhone[0].substring(1).trim();

                    String[] brandPart = partSmartPhone[1].split("\\) ");
                    String brand = brandPart[0].trim();

                    String[] pricePart = brandPart[1].split(" ");
                    double price = Double.parseDouble(pricePart[0].trim());

                    deviceList.add(new SmartPhone(name, brand, price, type));
                }

                JOptionPane.showMessageDialog(null,
                        "Read device from the file " + selectedFile.getAbsolutePath()
                        + " are as follows:\n" + messageInfo());

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error reading file: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    protected void handleMenuSave() {
        int returnValue = fileChooser.showSaveDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();

            if (!selectedFile.getName().endsWith(".txt")) {
                selectedFile = new File(selectedFile.getAbsolutePath() + ".txt");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
                writer.write(messageInfo());

                JOptionPane.showMessageDialog(this,
                        "Data is saved to " + selectedFile.getAbsolutePath() + " successfully!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException ex) {
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