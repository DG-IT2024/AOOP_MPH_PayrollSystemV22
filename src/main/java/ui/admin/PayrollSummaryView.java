package ui.admin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import controller.EmployeeController;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import model.PayrollSummary;
import service.EmployeeService;
import service.PayrollSummaryService;

/**
 *
 * @author danilo
 */
public class PayrollSummaryView extends javax.swing.JFrame {

    private EmployeeController controller;

    public PayrollSummaryView() throws Exception {
        initComponents();
        loadPayrollSummary();
        populateEmployeeDetails();
        populateCoveredPeriods();
    }

    private void loadPayrollSummary() throws Exception {
        PayrollSummaryService summaries = new PayrollSummaryService();
        summaries.fetchAllPayrollSummaries(jTablePayrollSummary);
    }

    private void populateEmployeeDetails() throws Exception {

        EmployeeService service = new EmployeeService();
        controller = new EmployeeController(service);
        List<Employee> employees = controller.getAllEmployees();

        List<String> employeeList = new ArrayList<>();

        for (Employee e : employees) {
            String id = String.valueOf((e.getEmployeeId()));
            String firstName = e.getFirstName();
            String lastName = e.getLastName();
            String employeeInfo = id + " - " + lastName + ", " + firstName;
            employeeList.add(employeeInfo);
        }

        Collections.sort(employeeList);

        jComboBoxEmployeeNumber.addItem("");
        for (String employeeInfo : employeeList) {
            jComboBoxEmployeeNumber.addItem(employeeInfo);
        }
    }

    private void populateCoveredPeriods() throws Exception {
        PayrollSummaryService service = new PayrollSummaryService();
        List<PayrollSummary> payrolls = service.listPayrollSummary(null, null, null);

        Set<String> coveredPeriods = new HashSet<>();

        for (PayrollSummary p : payrolls) {
            String period = p.getPayPeriodStart() + " to " + p.getPayPeriodEnd();
            coveredPeriods.add(period);
        }

        List<String> sortedPeriods = new ArrayList<>(coveredPeriods);
        Collections.sort(sortedPeriods, (p1, p2) -> {
            LocalDate d1 = LocalDate.parse(p1.split(" to ")[0]);
            LocalDate d2 = LocalDate.parse(p2.split(" to ")[0]);
            return d2.compareTo(d1); // Sort from latest to oldest
        });

        jComboBoxCoveredPeriod.addItem("");
        for (String period : sortedPeriods) {
            jComboBoxCoveredPeriod.addItem(period);
        }

    }

    public void filterByCategory() throws SQLException {

        String selectedPeriod = jComboBoxCoveredPeriod.getSelectedItem() != null
                ? jComboBoxCoveredPeriod.getSelectedItem().toString()
                : "";

        Date startDate = null;
        Date endDate = null;
        Integer empId = null;

        String empItem = jComboBoxEmployeeNumber.getSelectedItem() != null
                ? jComboBoxEmployeeNumber.getSelectedItem().toString()
                : "";

        if (!empItem.isEmpty()) {
            try {
                // Assuming the format is "10001 - Name"
                String[] parts = empItem.split(" - ");
                empId = Integer.parseInt(parts[0].trim());
            } catch (Exception e) {
                empId = null;
            }
        }

        if (!selectedPeriod.isEmpty() && selectedPeriod.contains(" to ")) {
            String[] dates = selectedPeriod.split(" to ");
            if (dates.length == 2) {
                try {
                    startDate = Date.valueOf(dates[0].trim());
                    endDate = Date.valueOf(dates[1].trim());
                } catch (IllegalArgumentException ex) {
                    startDate = null;
                    endDate = null;
                }
            }
        }

        PayrollSummaryService service = new PayrollSummaryService();
        service.fetchPayrollSummaries(jTablePayrollSummary, empId, startDate, endDate);

    }

    /**
     * Searches for a given text in all columns of the JTable. If found, selects
     * the row.
     *
     * @param table the JTable to search
     * @param searchText the text to search for
     * @return the first matching row index, or -1 if not found
     */
    public int searchTable(JTable table, String searchText) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        searchText = searchText.trim().toLowerCase();

        for (int row = 0; row < model.getRowCount(); row++) {
            for (int col = 0; col < model.getColumnCount(); col++) {
                Object value = model.getValueAt(row, col);
                if (value != null && value.toString().toLowerCase().contains(searchText)) {
                    // Select and scroll to the found row
                    table.setRowSelectionInterval(row, row);
                    table.scrollRectToVisible(table.getCellRect(row, 0, true));
                    return row;
                }
            }
        }
        // Not found
        return -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePayrollSummary = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxCoveredPeriod = new javax.swing.JComboBox<>();
        jComboBoxEmployeeNumber = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonClose = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AOOP | A2101");
        setAlwaysOnTop(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255, 0));

        jTablePayrollSummary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee No", "Last Name", "First Name", "Regular Hours", "Overtime Hours", "Basic Salary", "Hourly Rate", "Gross Income", "SSS Deduction", "Philthealth Deduction", "Pagibig Deduction", "Withholding Tax", "Start Date", "End Date", "Benefits", "Total Deductions", "TakeHome-Pay"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePayrollSummary.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTablePayrollSummary.setEnabled(false);
        jTablePayrollSummary.setRowSelectionAllowed(false);
        jScrollPane2.setViewportView(jTablePayrollSummary);
        if (jTablePayrollSummary.getColumnModel().getColumnCount() > 0) {
            jTablePayrollSummary.getColumnModel().getColumn(0).setResizable(false);
            jTablePayrollSummary.getColumnModel().getColumn(0).setPreferredWidth(70);
            jTablePayrollSummary.getColumnModel().getColumn(3).setResizable(false);
            jTablePayrollSummary.getColumnModel().getColumn(4).setResizable(false);
            jTablePayrollSummary.getColumnModel().getColumn(5).setResizable(false);
            jTablePayrollSummary.getColumnModel().getColumn(6).setResizable(false);
            jTablePayrollSummary.getColumnModel().getColumn(7).setResizable(false);
            jTablePayrollSummary.getColumnModel().getColumn(8).setResizable(false);
            jTablePayrollSummary.getColumnModel().getColumn(9).setResizable(false);
            jTablePayrollSummary.getColumnModel().getColumn(10).setResizable(false);
            jTablePayrollSummary.getColumnModel().getColumn(11).setResizable(false);
            jTablePayrollSummary.getColumnModel().getColumn(12).setResizable(false);
            jTablePayrollSummary.getColumnModel().getColumn(12).setPreferredWidth(100);
            jTablePayrollSummary.getColumnModel().getColumn(13).setResizable(false);
            jTablePayrollSummary.getColumnModel().getColumn(13).setPreferredWidth(100);
            jTablePayrollSummary.getColumnModel().getColumn(14).setResizable(false);
            jTablePayrollSummary.getColumnModel().getColumn(15).setResizable(false);
            jTablePayrollSummary.getColumnModel().getColumn(16).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 600, 220));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxCoveredPeriod.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        jComboBoxCoveredPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCoveredPeriodActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxCoveredPeriod, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 200, -1));

        jComboBoxEmployeeNumber.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        jComboBoxEmployeeNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEmployeeNumberActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxEmployeeNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 200, -1));

        jLabel1.setText("Covered Period");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel3.setText("Employee");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 13, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel6.setText("Filter by :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 600, 110));

        jButtonClose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonClose.setText("CLOSE");
        jButtonClose.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 140, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Payroll Summary.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxCoveredPeriodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCoveredPeriodActionPerformed
        try {
            // TODO add your handling code here:
            filterByCategory();
        } catch (SQLException ex) {
            Logger.getLogger(PayrollSummaryView.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jComboBoxCoveredPeriodActionPerformed

    private void jComboBoxEmployeeNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEmployeeNumberActionPerformed
        try {
            // TODO add your handling code here:
            filterByCategory();
        } catch (SQLException ex) {
            Logger.getLogger(PayrollSummaryView.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jComboBoxEmployeeNumberActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonCloseActionPerformed

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
            java.util.logging.Logger.getLogger(PayrollSummaryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayrollSummaryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayrollSummaryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayrollSummaryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    new PayrollSummaryView().setVisible(true);
                } catch (Exception ex) {
                    java.util.logging.Logger.getLogger(PayrollSummaryView.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClose;
    private javax.swing.JComboBox<String> jComboBoxCoveredPeriod;
    private javax.swing.JComboBox<String> jComboBoxEmployeeNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePayrollSummary;
    // End of variables declaration//GEN-END:variables

}
