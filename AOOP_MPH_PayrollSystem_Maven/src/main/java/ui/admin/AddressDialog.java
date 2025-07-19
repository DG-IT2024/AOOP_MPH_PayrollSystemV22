package ui.admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import util.InputValidator;

public class AddressDialog extends JDialog {

    private JTextField streetField, barangayField, cityField, provinceField, zipField;
    private boolean confirmed = false;

    public AddressDialog(JFrame parent, String address) {
        super(parent, "Enter Address", true);

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // top, left, bottom, right

        streetField = new JTextField(20);
        barangayField = new JTextField(20);
        cityField = new JTextField(20);
        provinceField = new JTextField(20);
        zipField = new JTextField(8);

        zipField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String text = zipField.getText();
                        
                if (!InputValidator.isOnlyDigitWithMaxLength(c, text, 4)) {
                    e.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });

        String[] parts = address != null ? address.split(";", -1) : new String[0];
        if (parts.length > 0) {
            streetField.setText(parts[0].trim());
        }
        if (parts.length > 1) {
            barangayField.setText(parts[1].trim());
        }
        if (parts.length > 2) {
            cityField.setText(parts[2].trim());
        }
        if (parts.length > 3) {
            provinceField.setText(parts[3].trim());
        }
        if (parts.length > 4) {
            zipField.setText(parts[4].trim());
        }

        formPanel.add(new JLabel("Street:"));
        formPanel.add(streetField);
        formPanel.add(new JLabel("Barangay:"));
        formPanel.add(barangayField);
        formPanel.add(new JLabel("City:"));
        formPanel.add(cityField);
        formPanel.add(new JLabel("Province:"));
        formPanel.add(provinceField);
        formPanel.add(new JLabel("Zip:"));
        formPanel.add(zipField);

        JButton confirmButton = new JButton("Confirm");
        JButton cancelButton = new JButton("Cancel");

        formPanel.add(confirmButton);
        formPanel.add(cancelButton);

        confirmButton.addActionListener(e -> {
            confirmed = true;
            setVisible(false);
        });
        cancelButton.addActionListener(e -> {
            confirmed = false;
            setVisible(false);
        });

        setContentPane(formPanel);

        pack();
        setLocationRelativeTo(parent);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public String getAddress() {
        return String.format("%s; %s; %s; %s; %s",
                streetField.getText().trim(),
                barangayField.getText().trim(),
                cityField.getText().trim(),
                provinceField.getText().trim(),
                zipField.getText().trim());
    }
}
