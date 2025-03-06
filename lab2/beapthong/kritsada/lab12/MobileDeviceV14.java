package beapthong.kritsada.lab12;

import beapthong.kritsada.lab7.SmartPhone;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MobileDeviceV14 extends MobileDeviceV13 {

    protected  File selectedFile;

    public MobileDeviceV14(String title) {
        super(title);

        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text Files", "txt")); // Filter to show only .txt files
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src ==  openItem) {
            handleMenuOpen();
        } else if (src ==saveItem) {
            handleMenuSave();
        } else {
            super.actionPerformed(e);
        }
    }

    protected void handleMenuOpen() {
        int value = fileChooser.showOpenDialog(null); // Displays the "Open" dialog.  The `null` argument means the dialog is centered on the screen. `showOpenDialog` returns an integer representing the user's choice.
        if (value == JFileChooser.APPROVE_OPTION) { // Checks if the user clicked "Open" or "OK" in the dialog.
            selectedFile = fileChooser.getSelectedFile();
            JOptionPane.showMessageDialog(null, "Opening: " + selectedFile.getAbsolutePath()); // Displays a message dialog informing the user which file is being opened.
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] part = line.split(":");
                    String type = part[0].substring(part[0].length() - 1);
                    String[] partSmartPhone = part[1].split("\\(");
                    String name = partSmartPhone[0].substring(1);
                    String[] brandpart = partSmartPhone[1].split("\\) ");
                    String brand = brandpart[0];
                    String[] pricePart = brandpart[1].split(" ");
                    double price = Double.parseDouble(pricePart[0].trim());
                    smartPhoneList.add(new SmartPhone(name, brand, price, type));
                }
                JOptionPane.showMessageDialog(null, "Read device form the file " + selectedFile.getAbsolutePath() + " are as follows:\n" + messageInfo());
            } catch (IOException ex) {
                System.out.println("err" + ex);
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
                String contentToSave = messageInfo();
                writer.write(contentToSave);
                JOptionPane.showMessageDialog(this, "Data is saved to " + selectedFile.getAbsolutePath() + " successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
