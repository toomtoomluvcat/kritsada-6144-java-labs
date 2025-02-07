package beapthong.kritsada.lab9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;

public class MobileDeviceV5 extends MobileDeviceV4 {
    
    protected  JSlider rateSlide;
    protected JPanel containnerExtraPanel,vendorsPanel,ratePanel ;
    protected JLabel vendorsLabel,rateLabel;
    protected String[] vendorsName = {"AIS", "True", "DTAC", "Shopee"};
    protected JList<String> vendorsList;
    protected JScrollPane vendorsPane;

    @Override
    public void addComponents() {
        
        super.addComponents();
        containnerExtraPanel =new JPanel();
        vendorsList = new JList<>(vendorsName);
        vendorsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
        vendorsPane = new JScrollPane(vendorsList);

        vendorsPane.setPreferredSize(new Dimension(150,70));
        vendorsLabel = new JLabel("The device is avalable at:");
        vendorsPanel = createPanelWithGridLayout(1,2);
   
        vendorsPanel.add(vendorsLabel);
        vendorsPanel.add(vendorsPane);

        rateLabel = new JLabel("rate the device(0-10)");
        ratePanel = createPanelWithGridLayout(2, 1);
        rateSlide = new JSlider(0,10,5);
        rateSlide.setMajorTickSpacing(1);
        rateSlide.setPaintLabels(true);
        rateSlide.setPaintTicks(true);

        ratePanel.add(rateLabel);
        ratePanel.add(rateSlide);
        
        containnerExtraPanel =createPanelWithGridLayout(2,1);
        containnerExtraPanel.add(vendorsPanel);
        containnerExtraPanel.add(ratePanel);

        mainPanel.add(containnerExtraPanel,BorderLayout.SOUTH);
    }

    public MobileDeviceV5(String title) {
        super(title);
    }

    // Method to create and display the GUI
    public static void createAndShowGUI() {
        MobileDeviceV5 mdv5 = new MobileDeviceV5("Mobile Device V5");
        mdv5.addComponents();
        mdv5.setFrameFeatures();
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
