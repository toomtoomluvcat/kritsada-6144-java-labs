package beapthong.kritsada.lab9;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class MobileDeviceV7 extends MobileDeviceV6 {

    /**
     * ReadImage - A custom JPanel class for loading and displaying images
     *
     * The class provides functionality to: - Load images from resources folder
     * - Scale images smoothly using bilinear interpolation - Auto-resize image
     * to fit panel dimensions - Handle missing image files with error handling
     *
     * Key methods: - Constructor: Loads image file from resources -
     * paintComponent: Renders scaled image - getPreferredSize: Sets default
     * 600x300 panel size
     *
     * Example usage: ReadImage panel = new ReadImage("myimage.jpg");
     * frame.add(panel);
     *
     * Author: Kritsada Beapthong Student ID: 6730406144 Section: 2
     */
    protected JPanel imagePanel, containnerSouthPanel;
    protected BufferedImage samsungImage;

    //Overrides addComponents method to initialize and configure UI components.
    @Override
    public void addComponents() {
        super.addComponents();
        //Sets default values 
        deviceNameTextField.setText("Samsung Galaxy S25 Ultra");
        brandTextField.setText("Samsung");
        priceTextField.setText("46,900");
        smartphoneRadio.setSelected(true);
        operatingComboBox.setSelectedIndex(0);
        featuresTextArea.setText("-200MP Camera\r\n"
                + //
                "-1TB Storage\r\n"
                + //
                "-Snapdragon Gen 4 Processor\r\n"
                + //
                "-5000mAh Battery\r\n"
                + //
                "-6.8-inch AMOLED Display\r\n"
                + //
                "-120Hz Refresh Rate\r\n"
                + //
                "-Fast Charging");
        vendorsList.setSelectedIndex(0);
        rateSlide.setValue(9);

        //Also adds image panel showing S25-ultra.jpg and configures layout:
        imagePanel = new ReadImage("S25-ultra.jpg");
        imagePanel.setPreferredSize(new Dimension(400, 300)); // Image panel sized 400x300

        // Contained in south panel with extra panel above and button panel below
        containnerSouthPanel = new JPanel(new BorderLayout());
        containnerSouthPanel.add(containnerExtraPanel, BorderLayout.NORTH);
        containnerSouthPanel.add(imagePanel, BorderLayout.CENTER);
        containnerSouthPanel.add(buttonPanel, BorderLayout.SOUTH);
        //Main panel uses BorderLayout with this container in SOUTH position
        mainPanel.add(containnerSouthPanel, BorderLayout.SOUTH);

    }
    //super constructor
    public MobileDeviceV7(String title) {
        super(title);
    }
    // Method to create and display the GUI
    public static void createAndShowGUI() {
        MobileDeviceV7 mdv7 = new MobileDeviceV7("Mobile device V7");
        mdv7.addComponents();
        mdv7.setFrameFeatures();
    }
   // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
