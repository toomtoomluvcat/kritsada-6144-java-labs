package beapthong.kritsada.lab11;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class MobileDeviceCompleteV4 extends MobileDeviceCompleteV2 implements ActionListener {

    protected JMenu configMenu, colorMenu;
    protected JMenuItem customItem;

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == customItem) {
           Color selectedColor= JColorChooser.showDialog(colorMenu, "Choose Text Color", Color.white);
           deviceNameField.setForeground(selectedColor);
           brandField.setForeground(selectedColor);
           priceField.setForeground(selectedColor);

        }
    }

    public MobileDeviceCompleteV4(String title) {
        super(title);
    }

    public void addListener() {
        super.addListener();
        customItem.addActionListener(this);
    }

    @Override
    protected void addMenus() {
        super.addMenus();

        configMenu = new JMenu("Config");
        colorMenu = new JMenu("Color");
        customItem = new JMenuItem("Custom");

        colorMenu.add(customItem);
        configMenu.add(colorMenu);

        menuBar.add(configMenu);

        setJMenuBar(menuBar);

    }

    public static void createAndShowGUI() {
        MobileDeviceCompleteV4 window = new MobileDeviceCompleteV4("Mobile Device Complete V4");
        window.addComponents();
        window.addMenus();
        window.addListener();
        window.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

}
