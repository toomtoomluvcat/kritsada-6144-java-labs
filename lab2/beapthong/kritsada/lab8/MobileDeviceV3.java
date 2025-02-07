package beapthong.kritsada.lab8;

import javax.swing.*;

public class MobileDeviceV3 extends MobileDeviceV2 {

    /**
     * MobileDeviceV3 extends MobileDeviceV2 by adding a comprehensive menu bar
     * system. The menu structure includes: - File menu (New, Open, Save, Exit)
     * - Config menu with submenus for: - Size (Small to Extra Large) - Color
     * (Black, Red, Green, Blue) - Font (Font 1-3)
     *
     * Author: Kritsada Beapthong 
     * ID: 673040614-4 
     * Section: 2
     */

    // Declare components for the menu bar and menu items
    protected JMenuBar deviceMenuBar;
    protected JMenu fileMenu, configmMenu, sizemMenu, colorMenu, fontMenu;
    protected JMenuItem newItem, openItem, saveItem, exitItem, smallItem, mediumItem,
            largeItem, extraLargeItem, blackItem, redItem, greenItem, blueItem, font1Item, font2Item, font3Item;
    
    // Method to create and add the menu bar to the window
    protected void addMenus() {
        // Create a new JMenuBar
        deviceMenuBar = new JMenuBar();

        // Create menu items for the File menu
        newItem = new JMenu("New");
        openItem = new JMenu("Open");
        saveItem = new JMenu("Save");
        exitItem = new JMenu("Exit");

        // Create the File menu and add items to it
        fileMenu = new JMenu("File");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(exitItem);

        // Create the Config menu and its submenus (Size, Color, Font)
        configmMenu = new JMenu("Config");
        sizemMenu = new JMenu("Size");
        colorMenu = new JMenu("Color");
        fontMenu = new JMenu("Font");

        // Add submenus to the Config menu
        configmMenu.add(sizemMenu);
        configmMenu.add(colorMenu);
        configmMenu.add(fontMenu);

        // Create menu items for the Size submenu
        smallItem = new JMenu("Small");
        mediumItem = new JMenu("Medium");
        largeItem = new JMenu("Large");
        extraLargeItem = new JMenu("Extra Large");

        // Add items to the Size submenu
        sizemMenu.add(smallItem);
        sizemMenu.add(mediumItem);
        sizemMenu.add(largeItem);
        sizemMenu.add(extraLargeItem);

        // Create menu items for the Color submenu
        blackItem = new JMenu("Black");
        redItem = new JMenu("Red");
        greenItem = new JMenu("Green");
        blueItem = new JMenu("Blue");

        // Add items to the Color submenu
        colorMenu.add(blackItem);
        colorMenu.add(redItem);
        colorMenu.add(greenItem);
        colorMenu.add(blueItem);

        // Create menu items for the Font submenu
        font1Item = new JMenu("Font 1");
        font2Item = new JMenu("Font 2");
        font3Item = new JMenu("Font 3");

        // Add items to the Font submenu
        fontMenu.add(font1Item);
        fontMenu.add(font2Item);
        fontMenu.add(font3Item);

        // Add the File and Config menus to the menu bar
        deviceMenuBar.add(fileMenu);
        deviceMenuBar.add(configmMenu);

        // Set the menu bar to the window
        setJMenuBar(deviceMenuBar);
    }

    @Override
    public void addComponents() {
        super.addComponents();
        addMenus();
    }

    // Constructor to set the title of the window
    protected MobileDeviceV3(String title) {
        super(title);
    }

    // Method to create and display the GUI
    public static void createAndShowGUI() {
        MobileDeviceV3 mdv3 = new MobileDeviceV3("Mobile Device V3");
        mdv3.addComponents();
        mdv3.setFrameFeatures();
    }
    
    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
