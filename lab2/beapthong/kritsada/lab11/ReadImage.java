package beapthong.kritsada.lab11;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;


public class ReadImage extends JPanel {
    BufferedImage img;
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }

    public ReadImage() {
        try {
            img = ImageIO.read(getClass().getResource("./images/exit_icon.jpg"));
        } catch (IOException e) {
           e.printStackTrace(System.err);
        }
    }

    public ReadImage(String fileName) {
        String name = "./images/" + fileName;
        try {
            img = ImageIO.read(getClass().getResource(name));
        } catch (IOException e) {
           e.printStackTrace(System.err);
        }
    }
}