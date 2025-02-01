package beapthong.kritsada.lab8;

import java.awt.*;
import javax.swing.*;

public class MobileDeviceV2 extends MobileDeviceV1 {

    protected  JScrollPane featuresScrollPane;
    protected JLabel operatingLabel, FeaturesLabel;
    protected JPanel extraPanel;
    protected JComboBox operatingComboBox;
    protected JTextArea featuresTextArea;

    public MobileDeviceV2(String title) {
        super(title);
    }

    public static void createAndShowGUI() {
        MobileDeviceV2 mdv2 = new MobileDeviceV2("Mobile Device V2");
        mdv2.addComponents();
        mdv2.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    @Override
    public void addComponents() {

        addInformationInput();
        addMoreInformation();
        addButtonUnderComponents();

        add(formPanel, BorderLayout.NORTH);
        add(extraPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

    }

    protected void addMoreInformation() {

        operatingLabel = createLabel("Operating System:");
        String[] options = {"Android", "iOS", "windows", "and Others"};
        operatingComboBox = new JComboBox<>(options);

        FeaturesLabel = createLabel("Features:");
        featuresTextArea = new JTextArea(3, 25);
        featuresTextArea.setLineWrap(true);
        featuresTextArea.setWrapStyleWord(true);
        featuresScrollPane = new JScrollPane(featuresTextArea);
        featuresScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        featuresScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        extraPanel = createPanelWithGridLayout(2, 2);

        extraPanel.add(operatingLabel);
        extraPanel.add(operatingComboBox);
        extraPanel.add(FeaturesLabel);
        extraPanel.add(featuresScrollPane);

    }

}
