package beapthong.kritsada.lab8;

import java.awt.BorderLayout;
import javax.swing.*;

public class MySimpleWindow extends JFrame {

    /**
     * A basic window implementation that extends JFrame and shows Cancel/Ok
     * buttons. Creates a simple GUI window with buttons arranged at the bottom
     * using BorderLayout. Protected variables allow subclasses to access and
     * modify the button and panel components.
     *
     * Author: Kritsada Beapthong ID: 673040614-4 Section: 2
     */
    // Protected variables for buttons and panel
    protected JButton resetButton, submitButton;
    protected JPanel mainPanel, buttonPanel;

    // Constructor sets window title and default close behavior 
    public MySimpleWindow(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    // Creates and arranges the Cancel/Ok buttons in a panel
    protected void addButtonUnderComponents() {
        //create each button 
        resetButton = new JButton("Cancel");
        submitButton = new JButton("Ok");

        buttonPanel = new JPanel();
        mainPanel = new JPanel();

        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel,BorderLayout.SOUTH);

    }

    // Adds all components to the frame
    protected void addComponents() {
        addButtonUnderComponents();
        //finally add every component to frame 
        

    }

    // Configure final window settings
    protected void setFrameFeatures() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Main entry point using SwingUtilities to ensure thread safety
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    // Creates and displays the window
    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
