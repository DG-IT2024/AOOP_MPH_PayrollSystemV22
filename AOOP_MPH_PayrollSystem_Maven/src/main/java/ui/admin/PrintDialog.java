/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.admin;

/**
 *
 * @author danilo
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrintDialog extends JDialog {
    private JComboBox<String> comboPeriods;
    private JButton btnPrint, btnCancel;

    public PrintDialog(Frame parent, String[] periods) {
        super(parent, "Print Covered Period", true);

        comboPeriods = new JComboBox<>(periods);
        btnPrint = new JButton("Print");
        btnCancel = new JButton("Cancel");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        panel.add(new JLabel("Covered Period:"), gbc);
        gbc.gridx = 1; gbc.anchor = GridBagConstraints.WEST;
        panel.add(comboPeriods, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnPrint);
        buttonPanel.add(btnCancel);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setSize(350, 150);
        setLocationRelativeTo(parent);

        // Button actions
        btnPrint.addActionListener(e -> {
            String selectedPeriod = (String) comboPeriods.getSelectedItem();
            // Add your print logic here, for example:
            System.out.println("Printing for period: " + selectedPeriod);
            dispose();
        });

        btnCancel.addActionListener(e -> dispose());
    }

    // Demo/testing main
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String[] coveredPeriods = {
                "2024-01-01 to 2024-01-15",
                "2024-01-16 to 2024-01-31",
                "2024-02-01 to 2024-02-15"
            };
            PrintDialog dialog = new PrintDialog(null, coveredPeriods);
            dialog.setVisible(true);
        });
    }
}
