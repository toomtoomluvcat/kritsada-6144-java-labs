package beapthong.kritsada.lab9;

import beapthong.kritsada.lab8.*;
import java.awt.*;
import javax.swing.*;

public class MobileDeviceV4 extends MobileDeviceV3 {

    protected ImageIcon fileIcon, openIcon, saveIcon, exitIcon;

    public MobileDeviceV4(String title) {
        super(title);
    }

    @Override
    public void addMenus() {
        super.addMenus();

        newItem.setIcon(new ImageIcon("lab2/images/new_icon.png"));
        openItem.setIcon(new ImageIcon("lab2/images/open_icon.png"));
        saveItem.setIcon(new ImageIcon("lab2/images/save_icon.png"));
        exitItem.setIcon(new ImageIcon("lab2/images/exit_icon.png"));

        smallItem.setFont(new Font("Arial", Font.PLAIN, 10));
        mediumItem.setFont(new Font("Arial", Font.PLAIN, 14));
        largeItem.setFont(new Font("Arial", Font.PLAIN, 18));
        extraLargeItem.setFont(new Font("Arial", Font.PLAIN, 20));

        redItem.setForeground(Color.red);
        greenItem.setForeground(Color.green);
        blueItem.setForeground(Color.blue);

        font1Item.setFont(new Font("Serif", Font.PLAIN, 14));
        font2Item.setFont(new Font("SansSerif", Font.PLAIN, 14));
        font3Item.setFont(new Font("Monospaced", Font.PLAIN, 14));

    }
    
    // Method to create and display the GUI
    public static void createAndShowGUI() {
        MobileDeviceV4 mdv4 = new MobileDeviceV4("Mobile Device V4");
        mdv4.addComponents();
        mdv4.setFrameFeatures();
    }
    
    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
