package beapthong.kritsada.lab8;

import java.awt.*;
import  javax.swing.*;

public class MobileDeviceV3 extends MobileDeviceV2 {

    protected  JMenu deviceMenu;
    protected JMenuBar fileMenuBar, configmMenuBar, sizemJMenuBar, colorMenuBar, colormMenuBar, fontmMenuBar;
    protected JMenuItem newItem, MenuItem, saveItem, exitItem, smallItem, mediumItem,
    largeItem, extraLargeItem,blackItem,redItem,greenItem,blueItem,font1Item,font2Item,font3Item;

    protected  JMenuBar createMenubar(String title){
        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu(title);
        return menubar;
    }
    

    protected void addMenuBar(){
        fileMenuBar = createMenubar("File");
        configmMenuBar = createMenubar("config");
        add(fileMenuBar);
        add(configmMenuBar);
        
    }

    @Override
    public  void addComponents(){
        addInformationInput();
        addMoreInformation();
        addMenuBar();
        addButtonUnderComponents();

        add(formPanel, BorderLayout.NORTH);
        add(extraPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    protected  MobileDeviceV3(String title) {
        super(title);
    }

    
    public static  void createAndShowGUI(){
        MobileDeviceV3 mdv3 = new MobileDeviceV3("Mobile Device V3");
        mdv3.addComponents();;
        mdv3.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }


}
