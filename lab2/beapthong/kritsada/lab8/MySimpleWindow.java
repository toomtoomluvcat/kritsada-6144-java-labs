package beapthong.kritsada.lab8;

import javax.swing.*;

public class MySimpleWindow extends JFrame {

    protected JButton resetButton, submitButton;
    protected JPanel mainPanel, buttonPanel;

    public MySimpleWindow(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    protected void addButtonUnderComponents() {
        //create each button 
        resetButton = new JButton("Cancel");
        submitButton = new JButton("Ok");

        buttonPanel = new JPanel();
        mainPanel = new JPanel();

        buttonPanel.add(resetButton);
        buttonPanel.add(submitButton);

        mainPanel.add(buttonPanel);       
    }

    protected void addComponents() {
        addButtonUnderComponents();
         //finally add every component to frame 
         add(mainPanel);
       
    }

    protected void setFrameFeatures() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndshowGUI();
            }
        });
    }

    public static void createAndshowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.addComponents();
        msw.setFrameFeatures();
    }
}
