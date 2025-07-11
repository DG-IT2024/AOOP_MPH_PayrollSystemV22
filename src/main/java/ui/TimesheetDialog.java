package ui;

import service.AttendanceService;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TimesheetDialog extends JDialog {

    private int attendanceId;
    private int approverId;

    private JTextField txtTimeIn;
    private JTextField txtTimeOut;
    private JTextField txtOvertimeRate;
    private JTextField txtOvertimeApproverId;

    private boolean submitted = false;

    public TimesheetDialog(Frame parent, int attendanceId, int approverId) {
        super(parent, "Edit Overtime Details", true);
        this.attendanceId = attendanceId;
        this.approverId = approverId;
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        int row = 0;

        // Attendance ID (display only)
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Attendance ID:"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel(String.valueOf(attendanceId)), gbc);
        row++;

        // Time In
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Time In:( HH:mm:ss) "), gbc);
        gbc.gridx = 1;
        txtTimeIn = new JTextField(10);
        txtTimeIn.setToolTipText("Format: HH:mm:ss (optional)");
        panel.add(txtTimeIn, gbc);
        row++;

        // Time Out
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Time Out:( HH:mm:ss)"), gbc);
        gbc.gridx = 1;
        txtTimeOut = new JTextField(10);
        txtTimeOut.setToolTipText("Format: HH:mm:ss (optional)");
        panel.add(txtTimeOut, gbc);
        row++;

        // Overtime Rate
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Overtime Rate:"), gbc);
        gbc.gridx = 1;
        txtOvertimeRate = new JTextField(10);
        txtOvertimeRate.setToolTipText("e.g. 1.25");
        panel.add(txtOvertimeRate, gbc);
        row++;

        // Overtime Approver ID
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Overtime Approver ID:"), gbc);
        gbc.gridx = 1;
        txtOvertimeApproverId = new JTextField(String.valueOf(approverId), 10);
        txtOvertimeApproverId.setToolTipText("Numeric ID");
        panel.add(txtOvertimeApproverId, gbc);
        row++;

        // Buttons
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        JButton btnOk = new JButton("Save");
        JButton btnCancel = new JButton("Cancel");
        buttonsPanel.add(btnOk);
        buttonsPanel.add(btnCancel);

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(buttonsPanel, gbc);

        // Action Listeners
        btnOk.addActionListener(e -> {
            if (!checkFieldsWithProceedOption()) {
                return; // Stops if user picks No
            }
            if (!checkInputsValid()) {
                return; // (optional) Do format validation as usual
            }
            submitted = true;
            try {
                updateAttendance();
                JOptionPane.showMessageDialog(this, "Attendance updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(TimesheetDialog.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                submitted = false;
                return;
            }
            setVisible(false);
        });

        btnCancel.addActionListener(e -> {
            submitted = false;
            setVisible(false);
        });

        getContentPane().add(panel);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    // Validation for inputs (returns true if valid)
    public boolean checkInputsValid() {

        // Time In
        String timeInStr = txtTimeIn.getText().trim();
        if (!timeInStr.isEmpty()) {
            try {
                Time.valueOf(timeInStr);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, "Invalid Time In format! Please use HH:mm:ss", "Input Error", JOptionPane.ERROR_MESSAGE);
                txtTimeIn.requestFocus();
                return false;
            }
        }

        // Time Out
        String timeOutStr = txtTimeOut.getText().trim();
        if (!timeOutStr.isEmpty()) {
            try {
                Time.valueOf(timeOutStr);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, "Invalid Time Out format! Please use HH:mm:ss", "Input Error", JOptionPane.ERROR_MESSAGE);
                txtTimeOut.requestFocus();
                return false;
            }
        }

        // Overtime Rate
        String otRateStr = txtOvertimeRate.getText().trim();
        if (!otRateStr.isEmpty()) {
            try {
                Double.parseDouble(otRateStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Overtime Rate must be a number!", "Input Error", JOptionPane.ERROR_MESSAGE);
                txtOvertimeRate.requestFocus();
                return false;
            }
        }

        // Approver ID
        String approverIdStr = txtOvertimeApproverId.getText().trim();
        if (!approverIdStr.isEmpty()) {
            try {
                Integer.parseInt(approverIdStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Approver ID must be a number!", "Input Error", JOptionPane.ERROR_MESSAGE);
                txtOvertimeApproverId.requestFocus();
                return false;
            }
        }
        return true;
    }

    // --- Clean getters: return null or 0 if field is empty ---
    public Time getSqlTimeIn() {
        String time = txtTimeIn.getText().trim();
        return (time.isEmpty()) ? null : Time.valueOf(time);
    }

    public Time getSqlTimeOut() {
        String time = txtTimeOut.getText().trim();
        return (time.isEmpty()) ? null : Time.valueOf(time);
    }

    public double getOvertimeRate() {
        String txt = txtOvertimeRate.getText().trim();
        return txt.isEmpty() ? 0.0 : Double.parseDouble(txt);
    }

    public java.sql.Date getCurrentSqlDate() {
        return new java.sql.Date(System.currentTimeMillis());
    }

    public int getOvertimeApproverId() {
        String txt = txtOvertimeApproverId.getText().trim();
        return txt.isEmpty() ? 0 : Integer.parseInt(txt);
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public boolean checkFieldsWithProceedOption() {
        String[] fieldNames = {
            "Time In",
            "Time Out",
            "Overtime Rate",
            "Overtime Approver ID"
        };
        JTextField[] fields = {
            txtTimeIn,
            txtTimeOut,
            txtOvertimeRate,
            txtOvertimeApproverId
        };

        StringBuilder missing = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getText().trim().isEmpty()) {
                if (missing.length() > 0) {
                    missing.append(", ");
                }
                missing.append(fieldNames[i]);
            }
        }

        if (missing.length() > 0) {
            int result = JOptionPane.showConfirmDialog(
                    this,
                    "The following fields are empty: " + missing
                    + ".\nDo you want to proceed anyway?",
                    "Incomplete Fields",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE
            );
            return result == JOptionPane.YES_OPTION;
        }
        return true; // All fields are filled
    }

    // This is where you call your AttendanceService
    public void updateAttendance() throws SQLException {
//        // Print all input values for debugging/confirmation
//        System.out.println("Updating attendance:");
//        System.out.println("Attendance ID: " + attendanceId);
//        System.out.println("Time In: " + getSqlTimeIn());
//        System.out.println("Time Out: " + getSqlTimeOut());
//        System.out.println("Overtime Rate: " + getOvertimeRate());
//
//        System.out.println("Overtime Updated Date: " + getOvertimeUpdatedDate());
//        System.out.println("Overtime Approver ID: " + getOvertimeApproverId());

        AttendanceService attendanceService = new AttendanceService();
        attendanceService.updateAttendanceOvertimeFields(
                attendanceId,
                getSqlTimeIn(),
                getSqlTimeOut(),
                getOvertimeRate(),
                getCurrentSqlDate(),
                getOvertimeApproverId()
        );
    }

    // Example usage
    public void main(String[] args) {
        TimesheetDialog dialog = new TimesheetDialog(null, attendanceId, approverId);
        dialog.setVisible(true);
        if (dialog.isSubmitted()) {
        } else {
        }
    }
}
