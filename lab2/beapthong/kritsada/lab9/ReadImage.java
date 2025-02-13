package beapthong.kritsada.lab9;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class ReadImage extends JPanel {

    /**
     * ReadImage class is a custom JPanel for loading and displaying images. It
     * loads images from resources folder and scales them to fit the panel using
     * bilinear interpolation for smooth rendering.
     *
     * Features: - Loads images from classpath resources - Smooth image scaling
     * - Auto-adjusts to panel size - Default size 600x300 pixels
     *
     * Author: Kritsada Beapthong Student ID: 6730406144 Section: 2
     */
    private BufferedImage img;

    // Constructor: Takes image filename and loads it from resources/images directory
    public ReadImage(String fileName) {
        // Handles file not found with IOException
        try {
            // Revalidates and repaints component after loading
            InputStream imageStream = getClass().getClassLoader().getResourceAsStream("images/" + fileName);
            if (imageStream == null) {
                throw new IOException("Image file not found: images/" + fileName);
            }
            img = ImageIO.read(imageStream);
            revalidate();
            repaint();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
// paintComponent: Custom painting method that:

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            // - Uses Graphics2D for better rendering quality
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            // - Enables bilinear interpolation for smooth scaling
            // - Draws image scaled to fit panel dimensions
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            g2d.drawImage(img, 0, 0, panelWidth, panelHeight, this);
        }
    }
// getPreferredSize: Sets default panel size to 600x300 pixels

    @Override
    public Dimension getPreferredSize() {
        return (img != null) ? new Dimension(600, 300) : new Dimension(600, 300);
    }
}
