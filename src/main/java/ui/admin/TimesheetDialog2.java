package ui.admin;

import service.AttendanceService;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendance;

public class TimesheetDialog2 extends JDialog {

    private JTextField txtDate;
    private JTextField txtTimeIn;
    private JTextField txtTimeOut;
    private int empId;

    private boolean submitted = false;

    public TimesheetDialog2(int empId) {

        this.empId = empId;
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
        panel.add(new JLabel("Employee ID:"), gbc);
        gbc.gridx = 1;
        panel.add(new JLabel(String.valueOf(empId)), gbc);
        row++;

        // Date
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel("Date (YYYY-MM-DD):"), gbc);
        gbc.gridx = 1;
        txtDate = new JTextField(10);
        txtDate.setToolTipText("e.g. 1.25");
        panel.add(txtDate, gbc);
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
                addAttendance();
                JOptionPane.showMessageDialog(this, "Attendance added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                Logger.getLogger(TimesheetDialog2.class.getName()).log(Level.SEVERE, null, ex);
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

    public static boolean isValidTime(String timeStr) {
        // Accepts "HH:mm:ss" (or "H:mm:ss") format
        if (timeStr == null) {
            return false;
        }
        String[] parts = timeStr.split(":");
        if (parts.length != 3) {
            return false;
        }
        try {
            int hour = Integer.parseInt(parts[0]);
            int min = Integer.parseInt(parts[1]);
            int sec = Integer.parseInt(parts[2]);
            // Hour must be 0-23, minute 0-59, second 0-59
            return (hour >= 0 && hour <= 23)
                    && (min >= 0 && min <= 59)
                    && (sec >= 0 && sec <= 59);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkInputsValid() {

        String dateStr = txtDate.getText().trim();
        if (!isValidDateFormat(dateStr)) {
            JOptionPane.showMessageDialog(this, "Invalid date format! Please use YYYY-MM-DD.", "Input Error", JOptionPane.ERROR_MESSAGE);
            txtDate.requestFocus();
            return false;
        }

        // Time In
        String timeInStr = txtTimeIn.getText().trim();
        if (!timeInStr.isEmpty()) {
            try {
                Time.valueOf(timeInStr);
                if (!isValidTime(timeInStr)) {
                    JOptionPane.showMessageDialog(this, "Time In must not exceed 23:59:59.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    txtTimeIn.requestFocus();
                    return false;
                }
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
                if (!isValidTime(timeOutStr)) {
                    JOptionPane.showMessageDialog(this, "Time Out must not exceed 23:59:59.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    txtTimeOut.requestFocus();
                    return false;
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, "Invalid Time Out format! Please use HH:mm:ss", "Input Error", JOptionPane.ERROR_MESSAGE);
                txtTimeOut.requestFocus();
                return false;
            }
        }

        return true;
    }

    // --- Clean getters: return null or 0 if field is empty ---
    public Date getsqlDate() {
        String date = txtDate.getText().trim();
        return (date.isEmpty()) ? null : Date.valueOf(date);
    }

    public Time getSqlTimeIn() {
        String time = txtTimeIn.getText().trim();
        return (time.isEmpty()) ? null : Time.valueOf(time);
    }

    public Time getSqlTimeOut() {
        String time = txtTimeOut.getText().trim();
        return (time.isEmpty()) ? null : Time.valueOf(time);
    }

    private boolean isValidDateFormat(String dateStr) {
        // Checks if the string matches YYYY-MM-DD (with zero-padded month and day)
        return dateStr.matches("^\\d{4}-\\d{2}-\\d{2}$");
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public boolean checkFieldsWithProceedOption() {
        String[] fieldNames = {
            "Date",
            "Time In",
            "Time Out",};
        JTextField[] fields = {
            txtDate,
            txtTimeIn,
            txtTimeOut,};

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
            JOptionPane.showMessageDialog(
                    this,
                    "The following fields are empty: " + missing
                    + ".\nPlease fill out all fields before proceeding.",
                    "Incomplete Fields",
                    JOptionPane.WARNING_MESSAGE
            );
            return false;
        }
        return true;
    }

    // This is where you call your AttendanceService
    public void addAttendance() throws SQLException {
        Attendance att = new Attendance();
        AttendanceService attendanceService = new AttendanceService();

//         // Print all input values for debugging/confirmation
        System.out.println("Adding attendance:");
        System.out.println("Empd ID: " + empId);
        System.out.println("Date : " + getsqlDate());
        System.out.println("Time In: " + getSqlTimeIn());
        System.out.println("Time Out: " + getSqlTimeOut());
        System.out.println("RegularHoursCalc: " + attendanceService.getRegularHours(getSqlTimeIn(), getSqlTimeOut()));
//        System.out.println("Overtime Rate: " + getOvertimeRate());
//
//        System.out.println("Overtime Updated Date: " + getCurrentSqlDate());
//        System.out.println("Overtime Approver ID: " + getOvertimeApproverId());

        att.setEmployeeId(empId);
        att.setDate(getsqlDate());
        att.setTimeIn(getSqlTimeIn());
        att.setTimeOut(getSqlTimeOut());
        att.setRegularHoursCalc(attendanceService.getRegularHours(getSqlTimeIn(), getSqlTimeOut()));

        System.out.println(att);
        attendanceService.addAttendance(att);
    }

}
