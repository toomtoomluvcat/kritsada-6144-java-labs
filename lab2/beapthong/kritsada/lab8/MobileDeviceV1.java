package beapthong.kritsada.lab8;

import java.awt.*;
import javax.swing.*;

public class MobileDeviceV1 extends MySimpleWindow {

    protected JLabel deviceNameLabel, brandLabel, priceLabel, typeLabel;
    protected JTextField deviceNameTextField, brandTextField, priceTextField, typeTextField;
    protected JPanel typePanel, formPanel;
    protected JRadioButton smartphoneRadio, tabletRadio;

    public MobileDeviceV1(String title) {
        super(title);
    }

    protected JLabel createLabel(String title) {
        return new JLabel(title);
    }

    protected JTextField createTextField(int cols) {
        return new JTextField(cols);
    }

    protected JPanel createPanelWithGridLayout(int rows, int cols) {
        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(rows, cols));
        return Panel;
    }

    protected JRadioButton createRadioButton(String title) {
        return new JRadioButton(title);
    }

    protected void addInformationInput() {

        deviceNameLabel = createLabel("DeviceName:");
        brandLabel = createLabel("Brand:");
        priceLabel = createLabel("Price:");
        typeLabel = createLabel("Type:");

        deviceNameTextField = createTextField(15);
        brandTextField = createTextField(15);
        priceTextField = createTextField(15);
        typeTextField = createTextField(15);

        typePanel = createPanelWithGridLayout(1, 2);
        formPanel = createPanelWithGridLayout(4, 2);

        smartphoneRadio = createRadioButton("SmartPhone");
        tabletRadio = createRadioButton("Tablet");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(smartphoneRadio);
        radioGroup.add(tabletRadio);
        smartphoneRadio.setSelected(true);

        formPanel.add(deviceNameLabel);
        formPanel.add(deviceNameTextField);

        formPanel.add(brandLabel);
        formPanel.add(brandTextField);

        formPanel.add(priceLabel);
        formPanel.add(priceTextField);

        typePanel.add(smartphoneRadio);
        typePanel.add(tabletRadio);
        typePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        formPanel.add(typeLabel);
        formPanel.add(typePanel);
    }

    @Override
    public void addComponents() {

        addInformationInput();
        addButtonUnderComponents();

        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

    }

    public static void createAndShowGUI() {
        MobileDeviceV1 mdv1 = new MobileDeviceV1("Mobile Device V1");
        mdv1.addComponents();
        mdv1.setFrameFeatures();

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
