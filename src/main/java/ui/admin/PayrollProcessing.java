package ui.admin;

import controller.AttendanceController;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Toolkit;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.Attendance_sp;
import service.AttendanceService;
import service.DeductionRateService;
import service.DeductionRateServiceImpl;
import service.PayrollService;


import util.ReportUtil;

/**
 *
 * @author danilo
 */
public class PayrollProcessing extends javax.swing.JFrame {

    private AttendanceController controller;

    private static int empId;

    /**
     * Creates new form PayrollProcessing
     *
     * @param empId
     * @throws java.io.FileNotFoundException
     */
    public PayrollProcessing(int empId) throws Exception {
        this.empId = empId;
        initComponents();
        displayEmployeeDetail();

    }

    private void displayEmployeeDetail() throws Exception {
        jTextFieldEmployeeNum.setText(String.valueOf(empId));

        AttendanceService service = new AttendanceService();
        controller = new AttendanceController(service);
        Attendance_sp attendance = controller.getAttendance(empId, null, null);
        jTextFieldLastName.setText(attendance.getLastName());
        jTextFieldFirstName.setText(attendance.getFirstName());

    }

    private void clearFields() {
        jTextFieldBasicSalary.setText("");
        jTextFieldGrossIncome.setText("");
        jTextFieldGrossIncome_S.setText("");
        jTextFieldHourlyRate.setText("");
        jTextFieldPagibigDeduction.setText("");
        jTextFieldPhilHealthDeduction.setText("");
        jTextFieldTakeHomePay.setText("");
        jTextFieldTotalDeductions.setText("");
        jTextFieldWHT.setText("");
        jTextFieldRegularHours.setText("");
        jTextSssDeduction.setText("");
        jTextFieldRegularHours.setText("");
        jTextFieldOvertimeHours.setText("");
        jTextFieldBenefits.setText("");
        jDateChooserStartDate.setDate(null);
        jDateChooserEndDate.setDate(null);

    }

    private void displayPayDetails() {
        try {
            PayrollService payrollService = new PayrollService();

            java.util.Date startDate = jDateChooserStartDate.getDate();
            java.util.Date endDate = jDateChooserEndDate.getDate();

            if (startDate == null || endDate == null) {
                JOptionPane.showMessageDialog(null, "Please select both start and end dates.");
                return;
            }

            java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

            List<Double> payDetails = payrollService.getPayDetails(empId, sqlStartDate, sqlEndDate);

            if (payDetails == null || payDetails.size() < 5) {
                clearFields();
                JOptionPane.showMessageDialog(null, "Invalid date range.");
                return;
            }

            double regularHours = payDetails.get(0);

            // 0.0 or null checker for regular hours
            if (regularHours == 0.0) {
                clearFields();
                JOptionPane.showMessageDialog(null, "Invalid date range.");
                return;
            }

            // Proceed if valid
            jTextFieldRegularHours.setText(String.format("%.2f", regularHours));
            jTextFieldOvertimeHours.setText(String.format("%.2f", payDetails.get(1)));
            jTextFieldBasicSalary.setText(String.format("%.2f", payDetails.get(2)));
            jTextFieldHourlyRate.setText(String.format("%.2f", payDetails.get(3)));
            double grossIncome = payDetails.get(4);
            jTextFieldGrossIncome.setText(String.format("%.2f", grossIncome));
            jTextFieldGrossIncome_S.setText(String.format("%.2f", grossIncome));
            // Deductions
            DeductionRateService service = new DeductionRateServiceImpl();

            jTextSssDeduction.setText(String.format("%.2f", service.computeSss(grossIncome)));
            jTextFieldPhilHealthDeduction.setText(String.format("%.2f", service.computePhilHealth(grossIncome)));
            jTextFieldPagibigDeduction.setText(String.format("%.2f", service.computePagIbig(grossIncome)));

            double taxableIncome = service.taxableIncome(grossIncome);
            jTextFieldWHT.setText(String.format("%.2f", taxableIncome));

            double deductionsTotal = service.totalDeduction(grossIncome);
            jTextFieldTotalDeductions.setText(String.format("%.2f", deductionsTotal));

            // Benefits and Takehome
            jTextFieldBenefits.setText(String.format("%.2f", payrollService.getTotalBenefit(empId)));
            jTextFieldTakeHomePay.setText(String.format("%.2f", payrollService.getTakehomePay(empId, sqlStartDate, sqlEndDate)));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error displaying pay details: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

       /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldEmployeeNum = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldLastName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldFirstName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldRegularHours = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldGrossIncome = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextSssDeduction = new javax.swing.JTextField();
        jTextFieldPhilHealthDeduction = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldPagibigDeduction = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jDateChooserEndDate = new com.toedter.calendar.JDateChooser();
        jTextFieldWHT = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldGrossIncome_S = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldBenefits = new javax.swing.JTextField();
        jTextFieldTotalDeductions = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldTakeHomePay = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldHourlyRate = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldBasicSalary = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextFieldOvertimeHours = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jDateChooserStartDate = new com.toedter.calendar.JDateChooser();
        jButtonClear = new javax.swing.JButton();
        jButtonCompute1 = new javax.swing.JButton();
        jButtonClose = new javax.swing.JButton();
        jButtonPrintPayslip = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel21.setText("Month");

        jLabel22.setText("Month");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AOOP | A2101");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Employee No.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, -1, -1));

        jTextFieldEmployeeNum.setEditable(false);
        jTextFieldEmployeeNum.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
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
        jPanel1.add(jTextFieldEmployeeNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 170, 22));

        jLabel4.setText("Last Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 43, -1, -1));

        jTextFieldLastName.setEditable(false);
        jTextFieldLastName.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldLastName.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldLastName.setEnabled(false);
        jTextFieldLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLastNameActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 170, 22));

        jLabel5.setText("First Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        jTextFieldFirstName.setEditable(false);
        jTextFieldFirstName.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldFirstName.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldFirstName.setEnabled(false);
        jTextFieldFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFirstNameActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 170, 22));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 13, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel6.setText("Covered Period");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 13, -1, -1));

        jLabel7.setText("Worked Hours");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 103, -1, -1));

        jTextFieldRegularHours.setEditable(false);
        jTextFieldRegularHours.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldRegularHours.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldRegularHours.setEnabled(false);
        jTextFieldRegularHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRegularHoursActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldRegularHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 70, 22));

        jLabel8.setText("Gross Income");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        jTextFieldGrossIncome.setEditable(false);
        jTextFieldGrossIncome.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldGrossIncome.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldGrossIncome.setEnabled(false);
        jTextFieldGrossIncome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGrossIncomeActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldGrossIncome, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 170, 22));

        jLabel9.setText("SSS Deduction ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jTextSssDeduction.setEditable(false);
        jTextSssDeduction.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextSssDeduction.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextSssDeduction.setEnabled(false);
        jTextSssDeduction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSssDeductionActionPerformed(evt);
            }
        });
        jPanel1.add(jTextSssDeduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 170, 22));

        jTextFieldPhilHealthDeduction.setEditable(false);
        jTextFieldPhilHealthDeduction.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldPhilHealthDeduction.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldPhilHealthDeduction.setEnabled(false);
        jTextFieldPhilHealthDeduction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPhilHealthDeductionActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldPhilHealthDeduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 170, 22));

        jLabel10.setText("PhilHealth Deduction ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        jLabel11.setText("Pagibig Deduction ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jTextFieldPagibigDeduction.setEditable(false);
        jTextFieldPagibigDeduction.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldPagibigDeduction.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldPagibigDeduction.setEnabled(false);
        jTextFieldPagibigDeduction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPagibigDeductionActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldPagibigDeduction, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 170, 22));

        jLabel12.setText("Withholding Tax");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        jDateChooserEndDate.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserEndDate.setToolTipText("");
        jDateChooserEndDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jDateChooserEndDateKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooserEndDateKeyTyped(evt);
            }
        });
        jPanel1.add(jDateChooserEndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 160, 30));

        jTextFieldWHT.setEditable(false);
        jTextFieldWHT.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldWHT.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldWHT.setEnabled(false);
        jTextFieldWHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldWHTActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldWHT, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 170, 22));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Summary");
        jLabel13.setToolTipText("");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 220, -1));

        jLabel14.setText("End Date");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        jTextFieldGrossIncome_S.setEditable(false);
        jTextFieldGrossIncome_S.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldGrossIncome_S.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldGrossIncome_S.setEnabled(false);
        jTextFieldGrossIncome_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGrossIncome_SActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldGrossIncome_S, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 112, 22));

        jLabel15.setText("Benefits");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, -1, -1));

        jTextFieldBenefits.setEditable(false);
        jTextFieldBenefits.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldBenefits.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldBenefits.setEnabled(false);
        jTextFieldBenefits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBenefitsActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldBenefits, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 112, 22));

        jTextFieldTotalDeductions.setEditable(false);
        jTextFieldTotalDeductions.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldTotalDeductions.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldTotalDeductions.setEnabled(false);
        jTextFieldTotalDeductions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalDeductionsActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldTotalDeductions, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 112, 22));

        jLabel16.setText("Total Deductions");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        jTextFieldTakeHomePay.setEditable(false);
        jTextFieldTakeHomePay.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldTakeHomePay.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldTakeHomePay.setEnabled(false);
        jTextFieldTakeHomePay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTakeHomePayActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldTakeHomePay, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 112, 22));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("TAKE-HOME PAY");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, -1));

        jTextFieldHourlyRate.setEditable(false);
        jTextFieldHourlyRate.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldHourlyRate.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldHourlyRate.setEnabled(false);
        jTextFieldHourlyRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHourlyRateActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldHourlyRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 170, 22));

        jLabel18.setText("Basic Salary");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jLabel19.setText("Hourly Rate");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jTextFieldBasicSalary.setEditable(false);
        jTextFieldBasicSalary.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldBasicSalary.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldBasicSalary.setEnabled(false);
        jTextFieldBasicSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBasicSalaryActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldBasicSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 170, 22));

        jLabel25.setText("Overtime");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, -1));

        jTextFieldOvertimeHours.setEditable(false);
        jTextFieldOvertimeHours.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldOvertimeHours.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldOvertimeHours.setEnabled(false);
        jTextFieldOvertimeHours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOvertimeHoursActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldOvertimeHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 70, 22));

        jLabel26.setText("Regular");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));

        jLabel20.setText("Gross Income");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, -1, -1));

        jLabel23.setText("Start Date");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

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
        jPanel1.add(jDateChooserStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 160, 30));

        jButtonClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonClear.setText("CLEAR");
        jButtonClear.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 110, 30));

        jButtonCompute1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonCompute1.setText("COMPUTE");
        jButtonCompute1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        jButtonCompute1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompute1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCompute1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 620, 360));

        jButtonClose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonClose.setText("CLOSE");
        jButtonClose.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 140, 23));

        jButtonPrintPayslip.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonPrintPayslip.setText("PRINT PAYSLIP");
        jButtonPrintPayslip.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        jButtonPrintPayslip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrintPayslipActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPrintPayslip, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 140, 23));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PayrollD.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldEmployeeNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmployeeNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmployeeNumActionPerformed

    private void jTextFieldEmployeeNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmployeeNumKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldEmployeeNumKeyTyped

    private void jTextFieldLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLastNameActionPerformed

    private void jTextFieldFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFirstNameActionPerformed

    private void jTextFieldRegularHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRegularHoursActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jTextFieldRegularHoursActionPerformed

    private void jTextFieldGrossIncomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGrossIncomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGrossIncomeActionPerformed

    private void jTextSssDeductionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSssDeductionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSssDeductionActionPerformed

    private void jTextFieldPhilHealthDeductionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPhilHealthDeductionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPhilHealthDeductionActionPerformed

    private void jTextFieldPagibigDeductionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPagibigDeductionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPagibigDeductionActionPerformed

    private void jTextFieldWHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldWHTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldWHTActionPerformed

    private void jTextFieldGrossIncome_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGrossIncome_SActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGrossIncome_SActionPerformed

    private void jTextFieldBenefitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBenefitsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBenefitsActionPerformed

    private void jTextFieldTotalDeductionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalDeductionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalDeductionsActionPerformed

    private void jTextFieldTakeHomePayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTakeHomePayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTakeHomePayActionPerformed

    private void jTextFieldHourlyRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHourlyRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHourlyRateActionPerformed

    private void jTextFieldBasicSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBasicSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBasicSalaryActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCloseActionPerformed
        this.dispose();

        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonCloseActionPerformed

    private void jButtonPrintPayslipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrintPayslipActionPerformed

        java.util.Date startDate = jDateChooserStartDate.getDate();
        java.util.Date endDate = jDateChooserEndDate.getDate();
        java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
        int employeeId = Integer.parseInt(jTextFieldEmployeeNum.getText());
        // Show confirmation dialog
        int response = JOptionPane.showConfirmDialog(
                this,
                "Do you also want to save the payslip as PDF?",
                "Save as PDF",
                JOptionPane.YES_NO_OPTION
        );
        if (response == JOptionPane.YES_OPTION) {
            ReportUtil.generatePayslip(employeeId, jTextFieldLastName.getText(), sqlStartDate, sqlEndDate);

        }
        ReportUtil.viewPayslip(employeeId, sqlStartDate, sqlEndDate);

    }//GEN-LAST:event_jButtonPrintPayslipActionPerformed

    private void jButtonCompute1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompute1ActionPerformed
        try {
            // TODO add your handling code here:
            displayPayDetails();
        } catch (Exception ex) {
            Logger.getLogger(PayrollProcessing.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonCompute1ActionPerformed

    private void jTextFieldOvertimeHoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOvertimeHoursActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOvertimeHoursActionPerformed

    private void jDateChooserEndDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserEndDateKeyPressed
        // TODO add your handling code here:
        Date startDate = jDateChooserEndDate.getDate();
        System.out.println(startDate);

    }//GEN-LAST:event_jDateChooserEndDateKeyPressed

    private void jDateChooserEndDateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserEndDateKeyTyped
        // TODO add your handling code here:
        Date startDate = jDateChooserEndDate.getDate();
        System.out.println(startDate);

    }//GEN-LAST:event_jDateChooserEndDateKeyTyped

    private void jDateChooserStartDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserStartDateKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserStartDateKeyPressed

    private void jDateChooserStartDateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserStartDateKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateChooserStartDateKeyTyped

    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_jButtonClearActionPerformed

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
            java.util.logging.Logger.getLogger(PayrollProcessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PayrollProcessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PayrollProcessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PayrollProcessing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new PayrollProcessing(empId).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(PayrollProcessing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonCompute1;
    private javax.swing.JButton jButtonPrintPayslip;
    private com.toedter.calendar.JDateChooser jDateChooserEndDate;
    private com.toedter.calendar.JDateChooser jDateChooserStartDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextFieldBasicSalary;
    public javax.swing.JTextField jTextFieldBenefits;
    public javax.swing.JTextField jTextFieldEmployeeNum;
    public javax.swing.JTextField jTextFieldFirstName;
    public javax.swing.JTextField jTextFieldGrossIncome;
    public javax.swing.JTextField jTextFieldGrossIncome_S;
    public javax.swing.JTextField jTextFieldHourlyRate;
    public javax.swing.JTextField jTextFieldLastName;
    public javax.swing.JTextField jTextFieldOvertimeHours;
    public javax.swing.JTextField jTextFieldPagibigDeduction;
    public javax.swing.JTextField jTextFieldPhilHealthDeduction;
    public javax.swing.JTextField jTextFieldRegularHours;
    public javax.swing.JTextField jTextFieldTakeHomePay;
    public javax.swing.JTextField jTextFieldTotalDeductions;
    public javax.swing.JTextField jTextFieldWHT;
    public javax.swing.JTextField jTextSssDeduction;
    // End of variables declaration//GEN-END:variables

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
    }
}
