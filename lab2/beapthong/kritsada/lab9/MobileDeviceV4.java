package beapthong.kritsada.lab9;

import beapthong.kritsada.lab8.*;
import java.awt.*;
import javax.swing.*;

public class MobileDeviceV4 extends MobileDeviceV3 {

    /**
     * MobileDeviceV4 extends MobileDeviceV3 by enhancing the menu system with
     * icons and improved text styling. It introduces: - Image icons for menu
     * items (New, Open, Save, Exit). - Custom font sizes and styles for better
     * readability. - Color changes for text to improve UI visibility.
     *
     * This version builds on the previous functionality while improving the
     * graphical user experience.
     *
     * Author: Kritsada Beapthong Student ID: 6730406144 Section: 2
     */
    // decalre image icon for menu
    protected ImageIcon fileIcon, openIcon, saveIcon, exitIcon;

    public MobileDeviceV4(String title) {
        super(title);
    }

    @Override
    public void addMenus() {
        super.addMenus();

        //add image icon
        newItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/new_icon.png")));
        openItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/open_icon.png")));
        saveItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/save_icon.png")));
        exitItem.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/exit_icon.png")));

        //change text-size
        blackItem.setForeground(Color.black);
        smallItem.setFont(new Font("Arial", Font.PLAIN, 10));
        mediumItem.setFont(new Font("Arial", Font.PLAIN, 14));
        largeItem.setFont(new Font("Arial", Font.PLAIN, 18));
        extraLargeItem.setFont(new Font("Arial", Font.PLAIN, 22));

        //change text-color
        redItem.setForeground(Color.red);
        greenItem.setForeground(Color.green);
        blueItem.setForeground(Color.blue);

        // change font familiy
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
