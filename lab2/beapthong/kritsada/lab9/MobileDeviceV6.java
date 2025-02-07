package beapthong.kritsada.lab9;

import java.awt.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MobileDeviceV6 extends MobileDeviceV5 {
    @Override
    public void addComponents(){
        UIManager.put("Label.foreground",Color.decode("#000080"));
        UIManager.put("Label.font",new Font("Arial",Font.BOLD,14));
        
        UIManager.put("TextField.background",Color.LIGHT_GRAY);
        UIManager.put("TextField.foreground",Color.DARK_GRAY);
        UIManager.put("TextField.font",new Font("Arial",Font.ITALIC,14));
        
        UIManager.put("TextArea.background",new Color(255, 255, 204));
        UIManager.put("TextArea.foreground",Color.DARK_GRAY);
        UIManager.put("TextArea.font",new Font("Arial",Font.ITALIC,14));

        super.addComponents();

        vendorsList.setBackground(Color.LIGHT_GRAY);
        vendorsList.setForeground(Color.decode("#006400"));
        vendorsList.setFont(new Font("Arial",Font.BOLD,14));
        vendorsList.setSelectionBackground(Color.yellow);
        vendorsList.setSelectionForeground(Color.black);

        resetButton.setForeground(Color.red);
        resetButton.setBackground(Color.white);

        submitButton.setForeground(Color.green);
        submitButton.setBackground(Color.white);

    }
    
    public MobileDeviceV6(String title){
        super(title);
    }
    public static void createAndShowGUI(){
        MobileDeviceV6 mdv6 = new MobileDeviceV6("Mobile device V6");
        mdv6.addComponents();
        mdv6.setFrameFeatures();
    } 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

  
    
}
