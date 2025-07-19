package ui.employeeuser;

import ui.employeeuser.PayrollUser;
import ui.employeeuser.LeaveApplicationUser;
import ui.employeeuser.EmployeeProfileUser;
import ui.admin.EmployeeProfileAdmin;
import controller.AttendanceController;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Attendance_sp;

import service.AttendanceService;
import ui.admin.LoginView;

import util.InputValidator;

public class AttendanceUser extends javax.swing.JFrame {

    private AttendanceController controller;
    private static int empId;

    public AttendanceUser(int empId) throws Exception {
        this.empId = empId;
        initComponents();

        displayEmployeeDetail();

    }

    private void displayEmployeeDetail() throws Exception {
        jTextFieldEmployeeNum.setText(String.valueOf(empId));

        AttendanceService service = new AttendanceService();
        controller = new AttendanceController(service);
        Attendance_sp attendance = controller.getAttendance(empId, null, null);

        String employeeName = attendance.getLastName() + " , " + attendance.getFirstName();
        jTextFieldName.setText(employeeName);

    }

    private void loadFilteredAttendanceDetails() throws Exception {
        AttendanceService service = new AttendanceService();
        controller = new AttendanceController(service);

        int employeeId = Integer.parseInt(jTextFieldEmployeeNum.getText().trim());
        java.util.Date startDate = jDateChooserStartDate.getDate();
        java.util.Date endDate = jDateChooserEndDate.getDate();

        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

        controller.loadBasicAttendanceToFilteredTable(jTableTimeSheet, employeeId, sqlStartDate, sqlEndDate); // Load data at startup
    }

    private double displayTotalWorkedHours() throws Exception {
        AttendanceService service = new AttendanceService();

        int employeeId = Integer.parseInt(jTextFieldEmployeeNum.getText().trim());
        java.util.Date startDate = jDateChooserStartDate.getDate();
        java.util.Date endDate = jDateChooserEndDate.getDate();

        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

        double TotalWorkedHours = service.getRegularHours(employeeId, sqlStartDate, sqlEndDate);
        return TotalWorkedHours;
    }

    private double displayTotalOvertime() throws Exception {
        AttendanceService service = new AttendanceService();

        int employeeId = Integer.parseInt(jTextFieldEmployeeNum.getText().trim());
        java.util.Date startDate = jDateChooserStartDate.getDate();
        java.util.Date endDate = jDateChooserEndDate.getDate();

        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

        double TotalOvertime = service.getOvertimeHours(employeeId, sqlStartDate, sqlEndDate);
        return TotalOvertime;
    }

    private void loadAllFilteredAttendanceDetails() throws Exception {
        AttendanceService service = new AttendanceService();
        controller = new AttendanceController(service);

        int employeeId = Integer.parseInt(jTextFieldEmployeeNum.getText().trim());
        java.util.Date startDate = jDateChooserStartDate.getDate();
        java.util.Date endDate = jDateChooserEndDate.getDate();

        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

        controller.loadAttendanceToFilteredTable(jTableTimeSheet, employeeId, sqlStartDate, sqlEndDate); // Load data at startup
    }

    private boolean checkAttendanceInputFields() {
        // Check Employee Number field
        String empNum = jTextFieldEmployeeNum.getText().trim();
        if (empNum.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Employee Number is required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Check Start Date
        if (jDateChooserStartDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Start Date is required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Check End Date
        if (jDateChooserEndDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "End Date is required.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true; // All fields have values
    }

    public void handleWindowClosing() {
        int option = JOptionPane.showConfirmDialog(
                this,
                "Do you want to save before closing?",
                "Save",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.YES_OPTION) {

            setVisible(false); // Close the application after saving
        } else if (option == JOptionPane.NO_OPTION) {
            setVisible(false); // Close the application without saving
        }
    }

    private Date convertToDate(Object dateObj) throws ParseException {
        if (dateObj instanceof Date) {
            return (Date) dateObj;
        } else if (dateObj instanceof String) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse((String) dateObj);
        } else {
            throw new ParseException("Unparseable date: " + dateObj, 0);
        }
    }

//
//    private List<String> createTableIdList() {
//        DefaultTableModel model = (DefaultTableModel) jTableTimeSheet.getModel();
//        List<String> tableIdList = new ArrayList<>();
//
//        for (int i = 0; i < model.getRowCount(); i++) {
//            String id = model.getValueAt(i, 0).toString();
//            tableIdList.add(id);
//        }
//        return tableIdList;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButtonProfile = new javax.swing.JButton();
        jButtonLeaveApp = new javax.swing.JButton();
        jButtonPayroll = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jButtonPayroll1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldEmployeeNum = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldRegularHours = new javax.swing.JTextField();
        jTextFieldOvertimeHours = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTimeSheet = new javax.swing.JTable();
        jDateChooserEndDate = new com.toedter.calendar.JDateChooser();
        jDateChooserStartDate = new com.toedter.calendar.JDateChooser();
        jButtonView = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("AOOP |  A2101");
        setAutoRequestFocus(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 51));
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        jPanel2.setBackground(new java.awt.Color(222, 194, 110));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(222, 194, 110));

        jButtonProfile.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButtonProfile.setText("PROFILE");
        jButtonProfile.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProfileActionPerformed(evt);
            }
        });

        jButtonLeaveApp.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButtonLeaveApp.setText("LEAVE ");
        jButtonLeaveApp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonLeaveApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLeaveAppActionPerformed(evt);
            }
        });

        jButtonPayroll.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButtonPayroll.setText("ATTENDANCE");
        jButtonPayroll.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonPayroll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPayrolljButtonAttendanceActionPerformed(evt);
            }
        });

        jButtonExit.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButtonExit.setText("LOG OUT");
        jButtonExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jButtonPayroll1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButtonPayroll1.setText("PAYROLL");
        jButtonPayroll1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonPayroll1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPayroll1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonPayroll, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jButtonProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonLeaveApp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonPayroll1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButtonProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonPayroll, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButtonPayroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonLeaveApp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 150, 220));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 207, 180, 283));

        jLabel4.setText("Name");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, -1, -1));

        jTextFieldName.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldName.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldName.setEnabled(false);
        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });
        jTextFieldName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNameKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 170, 22));

        jLabel3.setText("Employee No.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        jTextFieldEmployeeNum.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldEmployeeNum.setCaretColor(new java.awt.Color(51, 51, 51));
        jTextFieldEmployeeNum.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldEmployeeNum.setEnabled(false);
        jTextFieldEmployeeNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEmployeeNumActionPerformed(evt);
            }
        });
        jTextFieldEmployeeNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldEmployeeNumKeyTyped(evt);
            }
        });
        getContentPane().add(jTextFieldEmployeeNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 170, 22));

        jLabel6.setText("Period Start Date");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, -1));

        jLabel5.setText("Period End Date");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("SUMMARY");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 220, -1, -1));

        jLabel7.setText("Overtime Hours");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, -1, -1));

        jLabel9.setText("Regular Hours");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 250, -1, -1));

        jTextFieldRegularHours.setEditable(false);
        jTextFieldRegularHours.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRegularHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRegularHoursActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldRegularHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 250, 50, -1));

        jTextFieldOvertimeHours.setEditable(false);
        jTextFieldOvertimeHours.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(jTextFieldOvertimeHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 290, 50, -1));

        jTableTimeSheet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableTimeSheet.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTimeSheet.getTableHeader().setReorderingAllowed(false);
        jTableTimeSheet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTimeSheetMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableTimeSheet);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 400, 390));

        jDateChooserEndDate.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserEndDate.setToolTipText("");
        jDateChooserEndDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooserEndDateKeyTyped(evt);
            }
        });
        getContentPane().add(jDateChooserEndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 110, 160, 30));

        jDateChooserStartDate.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserStartDate.setToolTipText("");
        jDateChooserStartDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooserStartDateKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooserStartDateKeyTyped(evt);
            }
        });
        getContentPane().add(jDateChooserStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 160, 30));

        jButtonView.setText("VIEW");
        jButtonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonView, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 70, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Attendance.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameActionPerformed

    private void jTextFieldNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNameKeyTyped
        // TODO add your handling code here:
        InputValidator.allowValidNameCharacters(evt);
    }//GEN-LAST:event_jTextFieldNameKeyTyped

    private void jTextFieldEmployeeNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmployeeNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmployeeNumActionPerformed

    private void jTextFieldEmployeeNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmployeeNumKeyTyped
        // TODO add your handling code here:
        InputValidator.allowOnlyDigits(evt);
    }//GEN-LAST:event_jTextFieldEmployeeNumKeyTyped

    private void jTextFieldRegularHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRegularHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRegularHoursActionPerformed

    private void jButtonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewActionPerformed

        if (!checkAttendanceInputFields()) {
            // One or more fields are empty, so stop further processing
            return;
        }

        try {

            loadFilteredAttendanceDetails();
            displayTotalWorkedHours();

            jTextFieldOvertimeHours.setText(String.valueOf(displayTotalOvertime()));
            jTextFieldRegularHours.setText(String.valueOf(displayTotalWorkedHours()));

        } catch (Exception ex) {
            Logger.getLogger(AttendanceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonViewActionPerformed

    private void jTableTimeSheetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTimeSheetMouseClicked

    }//GEN-LAST:event_jTableTimeSheetMouseClicked

    private void jDateChooserEndDateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserEndDateKeyTyped
        // TODO add your handling code here:
        jDateChooserEndDate.getDateEditor().getUiComponent().setEnabled(false);


    }//GEN-LAST:event_jDateChooserEndDateKeyTyped

    private void jDateChooserStartDateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserStartDateKeyTyped
        // TODO add your handling code here:
        Date startDate = jDateChooserStartDate.getDate();
        System.out.println(startDate);


    }//GEN-LAST:event_jDateChooserStartDateKeyTyped

    private void jDateChooserStartDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserStartDateKeyPressed
        // TODO add your handling code here:
        Date startDate = jDateChooserStartDate.getDate();
        System.out.println(startDate);


    }//GEN-LAST:event_jDateChooserStartDateKeyPressed

    private void jButtonProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProfileActionPerformed
        try {

            this.setVisible(false);
            new EmployeeProfileUser(empId).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeProfileUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonProfileActionPerformed

    private void jButtonLeaveAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeaveAppActionPerformed
        try {
            // TODO add your handling code here:
            this.setVisible(false);
            LeaveApplicationUser leaveEmployee = new LeaveApplicationUser(empId);

            leaveEmployee.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(LeaveApplicationUser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonLeaveAppActionPerformed

    private void jButtonPayrolljButtonAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPayrolljButtonAttendanceActionPerformed

    }//GEN-LAST:event_jButtonPayrolljButtonAttendanceActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:

        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirm Logout",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        // Check the user's response
        if (response == JOptionPane.YES_OPTION) {
            try {
                // Hide the current window
                setVisible(false);

                // Show the login manager window
                new LoginView().setVisible(true);
            } catch (IOException ex) {

            }
        }

    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonPayroll1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPayroll1ActionPerformed
        try {
            // TODO add your handling code here:
            this.setVisible(false);
            PayrollUser payrollUser = new PayrollUser(empId);
            payrollUser.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(PayrollUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPayroll1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int response = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit?",
                "Confirm Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeProfileAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeProfileAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeProfileAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeProfileAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    new AttendanceUser(empId).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(EmployeeProfileAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonLeaveApp;
    private javax.swing.JButton jButtonPayroll;
    private javax.swing.JButton jButtonPayroll1;
    private javax.swing.JButton jButtonProfile;
    private javax.swing.JButton jButtonView;
    private com.toedter.calendar.JDateChooser jDateChooserEndDate;
    private com.toedter.calendar.JDateChooser jDateChooserStartDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTimeSheet;
    public javax.swing.JTextField jTextFieldEmployeeNum;
    public javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldOvertimeHours;
    private javax.swing.JTextField jTextFieldRegularHours;
    // End of variables declaration//GEN-END:variables

//    private void setIconImage() {
//        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
//    }
}
