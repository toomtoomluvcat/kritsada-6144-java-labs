package beapthong.kritsada.lab9;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MobileDeviceV7 extends MobileDeviceV6 {

    protected JPanel imagePanel, containnerSouthPanel;
    protected BufferedImage samsungImage;

    public class ReadImage extends JPanel {

        @Override
        protected void paintComponent(Graphics img) {
            super.paintComponent(img);
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            Image scaledImage = samsungImage.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);
            img.drawImage(scaledImage, 0, 0, this);
        }

        public ReadImage() {
            try {
                samsungImage = ImageIO.read(getClass().getResource("/images/S25-ultra.jpg"));
            } catch (IOException error) {
                System.out.println("Hello");

                System.out.println("error: " + error);

            }
        }
    }

    @Override
    public void addComponents() {
        super.addComponents();
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

        imagePanel = new ReadImage();
        imagePanel.setPreferredSize(new Dimension(400, 300));

        containnerSouthPanel = new JPanel(new BorderLayout());
        containnerSouthPanel.add(containnerExtraPanel,BorderLayout.NORTH);
        containnerSouthPanel.add(imagePanel, BorderLayout.CENTER);
        containnerSouthPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(containnerSouthPanel, BorderLayout.SOUTH);

    }

    public MobileDeviceV7(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        MobileDeviceV7 mdv7 = new MobileDeviceV7("Mobile device V7");
        mdv7.addComponents();
        mdv7.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
