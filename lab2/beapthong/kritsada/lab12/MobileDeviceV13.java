package beapthong.kritsada.lab12;

import beapthong.kritsada.lab7.MobileDevice;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.*;

public class MobileDeviceV13 extends MobileDeviceV12 {

    protected List<MobileDevice> deviceList = new ArrayList<>();
    protected JButton addButton, displayButton;
    StringBuilder messageSmartPhone = new StringBuilder();

    public MobileDeviceV13(String title) {
        super(title);
    }

    public void createObjSmartPhone() {
        price = Double.parseDouble(priceTextField.getText().trim().replace(",", ""));
        if (smartphoneRadio.isSelected()) {
            deviceList.add(new SmartPhone(deviceNameTextField.getText(), brandTextField.getText(), price, groupPhone.getSelection().getActionCommand()));
        }else if (tabletRadio.isSelected()){
            deviceList.add(new Tablet(deviceNameTextField.getText(), brandTextField.getText(), price, groupPhone.getSelection().getActionCommand()));
        }
        JOptionPane.showMessageDialog(null, deviceNameTextField.getText()+"is added");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        Object src = e.getSource();
        if (src == addButton) {
            createObjSmartPhone();
        } else if (src == displayButton) {
            JOptionPane.showMessageDialog(null, messageInfo());

        }
    }

    protected String messageInfo() {
        messageSmartPhone.setLength(0);
        for (MobileDevice device : deviceList) {
            messageSmartPhone.append(device.toString() + "\n");
        }
        return messageSmartPhone.toString();

    }

    @Override
    public void addListeners() {
        super.addListeners();
        addButton.addActionListener(this);
        displayButton.addActionListener(this);
    }

    @Override
    public void addComponents() {
        super.addComponents();
        containnerSouthPanel = new JPanel();

        addButton = new JButton("Add");
        displayButton = new JButton("Display");
        buttonPanel.add(addButton);
        buttonPanel.add(displayButton);

        containnerSouthPanel = new JPanel(new BorderLayout());
        containnerSouthPanel.add(imagePanel, BorderLayout.CENTER);
        containnerSouthPanel.add(containnerExtraPanel, BorderLayout.NORTH);
        containnerSouthPanel.add(buttonPanel, BorderLayout.SOUTH);
        mainPanel.add(containnerSouthPanel, BorderLayout.SOUTH);

    }

    public static void createAndShowGUI() {
        MobileDeviceV13 window = new MobileDeviceV13("Mobile Device V13");
        window.addComponents();
        window.addListeners();
        window.addChangeListener();
        window.addListSelectionListener();
        window.addShortKey();
        window.setFrameFeatures();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

}
