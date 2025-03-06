package beapthong.kritsada.lab12;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class MobileDeviceV14 extends MobileDeviceV13 {

    private JFileChooser fileChooser;
    private File selectedFile;
    private boolean isFileSaving = false;

    public MobileDeviceV14(String title) {
        super(title);
        // Create JFileChooser
        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Text Files", "txt")); // Filter to show only .txt files
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e); // ต้องเรียกก่อนตามที่กำหนด
    
        if (isFileSaving) return; // ถ้ากำลังเซฟไฟล์อยู่ ให้ return ออกไปก่อน
    
        Object src = e.getSource();
        if (src == saveItem) {
            isFileSaving = true; 
            
            int returnValue = fileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileChooser.getSelectedFile();
                if (!selectedFile.getName().endsWith(".txt")) {
                    selectedFile = new File(selectedFile.getAbsolutePath() + ".txt");
                }
    
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
                    String contentToSave = messageInfo(); 
                    writer.write(contentToSave);
                    JOptionPane.showMessageDialog(this, "File saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            isFileSaving = false; // รีเซ็ตให้สามารถเซฟใหม่ได้อีกครั้ง
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