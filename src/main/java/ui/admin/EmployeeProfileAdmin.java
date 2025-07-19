package ui.admin;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import service.EmployeeService;
import controller.*;
import service.*;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import ui.employeeuser.EmployeeProfileUser;

import util.*;
import static util.DateUtil.convertToDate;
import static util.DateUtil.formatDate;

public class EmployeeProfileAdmin extends javax.swing.JFrame {

    private EmployeeController controller;
    private static int empId;
    private LeaveApplicationAdmin leaveEmployeeWindow = null;
    private PayrollProcessing payrollWindow = null;
    private PayrollSummaryView payrollSummaryWindow = null;
    private AttendanceAdmin attendanceWindow = null;

    public EmployeeProfileAdmin(int empId) throws Exception {
        EmployeeProfileAdmin.empId = empId=10001;
        initComponents();

        loadEmployeeDetails();
        showLeaveCounter();
        populateCombobox();

    }

    private void loadEmployeeDetails() throws Exception {

        EmployeeService service = new EmployeeService();
        controller = new EmployeeController(service);
        controller.loadEmployeesToTable(jTableEmployeeList); // Load data at startup
    }

    private void clearTextField() {
        jComboBoxStatus.setSelectedIndex(0); // or .setSelectedItem("") if you want to be explicit
        jTextFieldEmployeeNum.setText("");
        jTextFieldLastName.setText("");
        jTextFieldFirstName.setText("");
        jDateChooserBirthday.setDate(null);
        jTextFieldPhoneNum.setText("");
        jTextAreaAddress.setText("");

        jComboBoxPosition.setSelectedIndex(0);
        jComboBoxImmediateSupervisor.setSelectedIndex(0);

        jTextFieldSSSnum.setText("");
        jTextFieldPhilhealthNum.setText("");
        jTextFieldPagibigNum.setText("");
        jTextFieldTINnum.setText("");

        jTextFieldBasicSalary.setText("");
        jTextFieldRiceSubsidy.setText("");
        jTextFieldPhoneAllow.setText("");
        jTextFieldClothAllow.setText("");
    }

    private void populateCombobox() throws Exception {
        EmployeeService service = new EmployeeService();
        List<Employee> emp = service.listAllEmployees();

        Set<String> uniquePositions = new HashSet<>();
        for (Employee e : emp) {
            if (e.getPosition() != null && !e.getPosition().trim().isEmpty()) {
                uniquePositions.add(e.getPosition().trim());
            }
        }

        jComboBoxPosition.removeAllItems();
        jComboBoxPosition.addItem("");
        for (String pos : uniquePositions) {
            jComboBoxPosition.addItem(pos);
        }

        Set<String> uniqueStatus = new HashSet<>();
        for (Employee e : emp) {
            if (e.getStatus() != null && !e.getStatus().trim().isEmpty()) {
                uniqueStatus.add(e.getStatus().trim());
            }
        }
        jComboBoxStatus.removeAllItems();
        jComboBoxStatus.addItem("");
        for (String status : uniqueStatus) {
            jComboBoxStatus.addItem(status);
        }

        jComboBoxImmediateSupervisor.removeAllItems();
        jComboBoxImmediateSupervisor.addItem("");
        for (Employee e : emp) {
            String fullName = e.getFirstName() + " " + e.getLastName();
            jComboBoxImmediateSupervisor.addItem(fullName);
        }
    }

    private boolean isEmpty(String text) {
        return text.trim().isEmpty();
    }

    // Collect data from GUI (UI Layer)
    private Employee getEmployeeFromForm() {
        Employee emp = new Employee();
        emp.setEmployeeId(Integer.parseInt(jTextFieldEmployeeNum.getText().trim()));
        emp.setLastName(jTextFieldLastName.getText().trim());
        emp.setFirstName(jTextFieldFirstName.getText().trim());
        emp.setBirthdate(jDateChooserBirthday.getDate());

        String[] addressParts = jTextAreaAddress.getText().split(";", -1);
        emp.setStreet(addressParts.length > 0 ? addressParts[0].trim() : "");
        emp.setBarangay(addressParts.length > 1 ? addressParts[1].trim() : "");
        emp.setCity(addressParts.length > 2 ? addressParts[2].trim() : "");
        emp.setProvince(addressParts.length > 3 ? addressParts[3].trim() : "");
        emp.setZip(addressParts.length > 4 ? addressParts[4].trim() : "");

        emp.setPhoneNumber(jTextFieldPhoneNum.getText().trim());
        emp.setSssNumber(jTextFieldSSSnum.getText().trim());
        emp.setPhilhealthNumber(jTextFieldPhilhealthNum.getText().trim());
        emp.setTinNumber(jTextFieldTINnum.getText().trim());
        emp.setPagibigNumber(jTextFieldPagibigNum.getText().trim());

        // Correct way to get selected item from JComboBox
        emp.setStatus(jComboBoxStatus.getSelectedItem() != null ? jComboBoxStatus.getSelectedItem().toString().trim() : "");
        emp.setPosition(jComboBoxPosition.getSelectedItem() != null ? jComboBoxPosition.getSelectedItem().toString().trim() : "");
        emp.setImmediateSupervisor(jComboBoxImmediateSupervisor.getSelectedItem() != null ? jComboBoxImmediateSupervisor.getSelectedItem().toString().trim() : "");

        emp.setBasicSalary(Double.parseDouble(jTextFieldBasicSalary.getText().trim()));
        emp.setRiceSubsidy(Double.parseDouble(jTextFieldRiceSubsidy.getText().trim()));
        emp.setPhoneAllowance(Double.parseDouble(jTextFieldPhoneAllow.getText().trim()));
        emp.setClothingAllowance(Double.parseDouble(jTextFieldClothAllow.getText().trim()));
        return emp;
    }

    private boolean checkEntries() {
        if (isEmpty(jTextAreaAddress.getText())
                || isEmpty(jTextFieldBasicSalary.getText())
                || isEmpty(formatDate(jDateChooserBirthday.getDate()))
                || isEmpty(jTextFieldClothAllow.getText())
                || isEmpty(jTextFieldEmployeeNum.getText())
                || isEmpty(jTextFieldFirstName.getText())
                || isEmpty(jTextFieldLastName.getText())
                || isEmpty(jTextFieldPagibigNum.getText())
                || isEmpty(jTextFieldPhilhealthNum.getText())
                || isEmpty(jTextFieldPhoneAllow.getText())
                || isEmpty(jTextFieldPhoneNum.getText())
                || isEmpty(jComboBoxPosition.getSelectedItem() == null ? "" : jComboBoxPosition.getSelectedItem().toString())
                || isEmpty(jTextFieldRiceSubsidy.getText())
                || isEmpty(jTextFieldSSSnum.getText())
                || isEmpty(jComboBoxStatus.getSelectedItem() == null ? "" : jComboBoxStatus.getSelectedItem().toString())
                || isEmpty(jComboBoxImmediateSupervisor.getSelectedItem() == null ? "" : jComboBoxImmediateSupervisor.getSelectedItem().toString())
                || isEmpty(jTextFieldTINnum.getText())) {

            JOptionPane.showMessageDialog(null, "All fields must be filled in", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public List<String> createTableIdList() {
        DefaultTableModel model = (DefaultTableModel) jTableEmployeeList.getModel();
        List<String> tableIdList = new ArrayList<>();

        for (int i = 0; i < model.getRowCount(); i++) {
            String id = model.getValueAt(i, 0).toString();
            tableIdList.add(id);
        }
        return tableIdList;
    }

    public boolean isUniqueEmployeeId(List<String> tableIdList) {
        String newEmployeeId = jTextFieldEmployeeNum.getText().trim();

        for (int i = 0; i < tableIdList.size(); i++) {
            if (tableIdList.get(i).equals(newEmployeeId)) {
                JOptionPane.showMessageDialog(this, "ID number already exist");
                return false;
            }
        }

        return true;
    }

    public int determineLastEmployeeId() {

        ArrayList<Integer> list = new ArrayList<>();
        int rowCount = jTableEmployeeList.getRowCount();
        int lastNumber = 0;

        for (int i = 0; i < rowCount; i++) {
            list.add(Integer.valueOf(jTableEmployeeList.getValueAt(i, 0).toString()));
        }

        // Sorting the ArrayList in descending order
        Collections.sort(list, Collections.reverseOrder());

        lastNumber = list.get(0);

        return lastNumber;
    }

    public int generateUniqueId() {
        int lastEmployeeID = determineLastEmployeeId();
        int newEmployeeId = lastEmployeeID + 1;

        return newEmployeeId;
    }

    //Method to check uniqueness before saving/updating employee info
    private boolean checkFieldsUnique() throws Exception {
        String sssNum = jTextFieldSSSnum.getText().trim();
        String philhealthNum = jTextFieldPhilhealthNum.getText().trim();
        String pagibigNum = jTextFieldPagibigNum.getText().trim();
        String tinNum = jTextFieldTINnum.getText().trim();

        EmployeeService service = new EmployeeService();
        controller = new EmployeeController(service);
        List<Employee> employeeList = controller.getAllEmployees();

        boolean isUnique = service.isEmployeeFieldsUnique(employeeList, sssNum, philhealthNum, pagibigNum, tinNum);

        if (!isUnique) {
            JOptionPane.showMessageDialog(this, "One or more fields (SSS, PhilHealth, Pagibig, TIN) are already used by another employee!", "Duplicate Entry", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }

    private int selectedRowEmpId() throws Exception {

        DefaultTableModel model = (DefaultTableModel) jTableEmployeeList.getModel();
        int selectedRowIndex = jTableEmployeeList.getSelectedRow();

        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select an employee from the list.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return -1; // Or handle it gracefully depending on your method's return expectations
        }

        Object empIdObj = model.getValueAt(selectedRowIndex, 0);
        return Integer.parseInt(empIdObj.toString());

    }

    public void showLeaveCounter() throws Exception {
        LeaveRequestService leaveRequestService = new LeaveRequestService();
        jTextFieldPendingLeaveCounter.setText(Integer.toString(leaveRequestService.getPendingLeaveRequestCount()));
    }

    private boolean isEmployeeRowSelected() {
        int selectedRow = jTableEmployeeList.getSelectedRow();
        if (selectedRow == -1) {
            // Show a message dialog or status notification
            JOptionPane.showMessageDialog(
                    this,
                    "Please select an employee from the list first.",
                    "No Employee Selected",
                    JOptionPane.WARNING_MESSAGE
            );
            return false;
        }
        return true;
    }

    private void handleWindowClose() throws IOException {
        Object[] options = {"Return to Login", "Exit Program", "Cancel"};
        int choice = JOptionPane.showOptionDialog(
                this,
                "Do you want to return to the login page or exit the program?",
                "Confirm Exit",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        if (choice == JOptionPane.YES_OPTION) {
            // Return to Login (replace this with your login form code)
            this.dispose(); // or setVisible(false);
            new LoginView().setVisible(true); // assuming LoginForm is your login window
        } else if (choice == JOptionPane.NO_OPTION) {
            System.exit(0);
        }
        // If Cancel, do nothing
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldEmployeeNum = new javax.swing.JTextField();
        jTextFieldLastName = new javax.swing.JTextField();
        jTextFieldSSSnum = new javax.swing.JTextField();
        jTextFieldPagibigNum = new javax.swing.JTextField();
        jTextFieldTINnum = new javax.swing.JTextField();
        jTextFieldPhoneNum = new javax.swing.JTextField();
        jTextFieldPhilhealthNum = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldRiceSubsidy = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldPhoneAllow = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldClothAllow = new javax.swing.JTextField();
        jTextFieldBasicSalary = new javax.swing.JTextField();
        jLabelBasicSalary = new javax.swing.JLabel();
        jTextFieldFirstName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAddress = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jDateChooserBirthday = new com.toedter.calendar.JDateChooser();
        jComboBoxPosition = new javax.swing.JComboBox<>();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jComboBoxImmediateSupervisor = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jButtonExit = new javax.swing.JButton();
        jButtonPayrollSummary = new javax.swing.JButton();
        jButtonLeaveApplication = new javax.swing.JButton();
        jButtonAttendance = new javax.swing.JButton();
        jButtonViewEmployee1 = new javax.swing.JButton();
        jTextFieldPendingLeaveCounter = new javax.swing.JTextField();
        jButtonExit1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEmployeeList = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jButtonClear = new javax.swing.JButton();
        jButtonProfileUpdate = new javax.swing.JButton();
        jButtonProfileAdd = new javax.swing.JButton();
        jButtonProfileDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("AOOP |  A2101");
        setAutoRequestFocus(false);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255, 0));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1037, 364));
        jPanel1.setPreferredSize(new java.awt.Dimension(1037, 364));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Status");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 13, -1, 22));

        jLabel3.setText("Employee No.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 43, -1, -1));

        jLabel4.setText("Last Name");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 13, -1, -1));

        jLabel6.setText("Birthday");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 103, -1, -1));

        jLabel7.setText("SSS No.");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 43, -1, -1));

        jLabel8.setText("Phone Number");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 73, -1, -1));

        jLabel9.setText("PhilHealth No.");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 73, -1, -1));

        jLabel10.setText("TIN");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 13, -1, -1));

        jLabel11.setText("Pagibig No.");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 103, -1, -1));

        jTextFieldEmployeeNum.setEditable(false);
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
        jPanel1.add(jTextFieldEmployeeNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 190, 22));

        jTextFieldLastName.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldLastName.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLastNameActionPerformed(evt);
            }
        });
        jTextFieldLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldLastNameKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 190, 22));

        jTextFieldSSSnum.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldSSSnum.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldSSSnum.setName(""); // NOI18N
        jTextFieldSSSnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSSSnumActionPerformed(evt);
            }
        });
        jTextFieldSSSnum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldSSSnumKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldSSSnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 190, 22));

        jTextFieldPagibigNum.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldPagibigNum.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldPagibigNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPagibigNumKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldPagibigNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 190, 22));

        jTextFieldTINnum.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldTINnum.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldTINnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTINnumActionPerformed(evt);
            }
        });
        jTextFieldTINnum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTINnumKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldTINnum, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 190, 22));

        jTextFieldPhoneNum.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldPhoneNum.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldPhoneNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPhoneNumActionPerformed(evt);
            }
        });
        jTextFieldPhoneNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPhoneNumKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldPhoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 190, 22));

        jTextFieldPhilhealthNum.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldPhilhealthNum.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldPhilhealthNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPhilhealthNumActionPerformed(evt);
            }
        });
        jTextFieldPhilhealthNum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPhilhealthNumKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldPhilhealthNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 190, 22));

        jLabel14.setText("Immediate Supervisor");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, -1));

        jLabel15.setText("Rice Subsidy");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 253, -1, -1));

        jTextFieldRiceSubsidy.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldRiceSubsidy.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldRiceSubsidy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldRiceSubsidyKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldRiceSubsidy, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 190, 22));
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(311, 372, -1, -1));

        jLabel17.setText("Phone Allowance");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 253, -1, -1));

        jTextFieldPhoneAllow.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldPhoneAllow.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldPhoneAllow.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldPhoneAllowKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldPhoneAllow, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 250, 190, 22));

        jLabel19.setText("Clothing  Allowance");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 253, -1, -1));

        jTextFieldClothAllow.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldClothAllow.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldClothAllow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldClothAllowActionPerformed(evt);
            }
        });
        jTextFieldClothAllow.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldClothAllowKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldClothAllow, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 250, 190, 22));

        jTextFieldBasicSalary.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldBasicSalary.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldBasicSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBasicSalaryActionPerformed(evt);
            }
        });
        jTextFieldBasicSalary.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBasicSalaryKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldBasicSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 190, 22));

        jLabelBasicSalary.setText("Basic Salary");
        jPanel1.add(jLabelBasicSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 223, -1, -1));

        jTextFieldFirstName.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextFieldFirstName.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextFieldFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFirstNameActionPerformed(evt);
            }
        });
        jTextFieldFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldFirstNameKeyTyped(evt);
            }
        });
        jPanel1.add(jTextFieldFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 190, 22));

        jLabel5.setText("First Name");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 43, -1, -1));

        jLabel20.setText("Address");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 158, -1, -1));

        jTextAreaAddress.setColumns(20);
        jTextAreaAddress.setLineWrap(true);
        jTextAreaAddress.setRows(5);
        jTextAreaAddress.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jTextAreaAddress.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextAreaAddress.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextAreaAddressMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTextAreaAddress);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 280, 56));

        jLabel18.setText("Positon");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 73, -1, -1));

        jDateChooserBirthday.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooserBirthday.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray));
        jDateChooserBirthday.setToolTipText("");
        jDateChooserBirthday.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jDateChooserBirthdayKeyTyped(evt);
            }
        });
        jPanel1.add(jDateChooserBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 190, 30));

        jComboBoxPosition.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jComboBoxPosition.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        jPanel1.add(jComboBoxPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 190, 30));

        jComboBoxStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jComboBoxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxStatusActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 190, 30));

        jComboBoxImmediateSupervisor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jComboBoxImmediateSupervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 190, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 980, 280));

        jPanel2.setBackground(new java.awt.Color(222, 194, 110));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonExit.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButtonExit.setText("EXIT");
        jButtonExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonExit.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 150, 20));

        jButtonPayrollSummary.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButtonPayrollSummary.setText("PAYROLL SUMMARY");
        jButtonPayrollSummary.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonPayrollSummary.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonPayrollSummary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPayrollSummaryActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonPayrollSummary, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, 20));

        jButtonLeaveApplication.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButtonLeaveApplication.setText("LEAVE APPLICATION");
        jButtonLeaveApplication.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonLeaveApplication.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonLeaveApplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLeaveApplicationActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonLeaveApplication, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 150, 20));

        jButtonAttendance.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButtonAttendance.setText("ATTENDANCE");
        jButtonAttendance.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAttendance.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAttendanceActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonAttendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 20));

        jButtonViewEmployee1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButtonViewEmployee1.setText("PAYROLL");
        jButtonViewEmployee1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonViewEmployee1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonViewEmployee1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewEmployee1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonViewEmployee1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 150, 20));

        jTextFieldPendingLeaveCounter.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jTextFieldPendingLeaveCounter.setForeground(new java.awt.Color(255, 0, 51));
        jTextFieldPendingLeaveCounter.setText("- -");
        jTextFieldPendingLeaveCounter.setDisabledTextColor(new java.awt.Color(255, 0, 51));
        jTextFieldPendingLeaveCounter.setEnabled(false);
        jTextFieldPendingLeaveCounter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldPendingLeaveCounterMouseClicked(evt);
            }
        });
        jTextFieldPendingLeaveCounter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPendingLeaveCounterActionPerformed(evt);
            }
        });
        jTextFieldPendingLeaveCounter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldPendingLeaveCounterKeyPressed(evt);
            }
        });
        jPanel2.add(jTextFieldPendingLeaveCounter, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 30, -1));

        jButtonExit1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButtonExit1.setText("SWITCH ACCOUNT");
        jButtonExit1.setToolTipText("");
        jButtonExit1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonExit1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonExit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExit1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonExit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 150, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 180, 283));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255, 0));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        jTableEmployeeList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee", "Last Name", "First Name", "Birthday", "Street", "Barangay", "CIty", "Province", "Zip", "Phone Number", "SSS #", "Philhealth #", "TIN ", "Pag-ibig #", "Status", "Position", "Immediate Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEmployeeList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jTableEmployeeList.setAutoscrolls(false);
        jTableEmployeeList.getTableHeader().setReorderingAllowed(false);
        jTableEmployeeList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmployeeListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableEmployeeList);
        if (jTableEmployeeList.getColumnModel().getColumnCount() > 0) {
            jTableEmployeeList.getColumnModel().getColumn(0).setMinWidth(50);
            jTableEmployeeList.getColumnModel().getColumn(0).setPreferredWidth(3);
            jTableEmployeeList.getColumnModel().getColumn(1).setMinWidth(150);
            jTableEmployeeList.getColumnModel().getColumn(1).setPreferredWidth(150);
            jTableEmployeeList.getColumnModel().getColumn(2).setMinWidth(150);
            jTableEmployeeList.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTableEmployeeList.getColumnModel().getColumn(3).setMinWidth(100);
            jTableEmployeeList.getColumnModel().getColumn(3).setPreferredWidth(100);
            jTableEmployeeList.getColumnModel().getColumn(4).setMinWidth(200);
            jTableEmployeeList.getColumnModel().getColumn(4).setPreferredWidth(200);
            jTableEmployeeList.getColumnModel().getColumn(9).setMinWidth(100);
            jTableEmployeeList.getColumnModel().getColumn(10).setMinWidth(100);
            jTableEmployeeList.getColumnModel().getColumn(11).setMinWidth(100);
            jTableEmployeeList.getColumnModel().getColumn(12).setMinWidth(100);
            jTableEmployeeList.getColumnModel().getColumn(13).setMinWidth(100);
            jTableEmployeeList.getColumnModel().getColumn(14).setMinWidth(100);
            jTableEmployeeList.getColumnModel().getColumn(15).setMinWidth(100);
            jTableEmployeeList.getColumnModel().getColumn(16).setMinWidth(100);
            jTableEmployeeList.getColumnModel().getColumn(17).setMinWidth(100);
            jTableEmployeeList.getColumnModel().getColumn(18).setMinWidth(100);
            jTableEmployeeList.getColumnModel().getColumn(19).setMinWidth(100);
            jTableEmployeeList.getColumnModel().getColumn(20).setMinWidth(100);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 370, 980, 180));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 51));
        jLabel12.setText("* All fields are required.");
        jLabel12.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jLabel12InputMethodTextChanged(evt);
            }
        });
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        jButtonClear.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButtonClear.setText("CLEAR");
        jButtonClear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonClear.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 150, 20));

        jButtonProfileUpdate.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButtonProfileUpdate.setText("UPDATE");
        jButtonProfileUpdate.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonProfileUpdate.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonProfileUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProfileUpdateActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonProfileUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 560, 150, -1));

        jButtonProfileAdd.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButtonProfileAdd.setText("ADD");
        jButtonProfileAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonProfileAdd.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonProfileAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProfileAddActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonProfileAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 560, 150, 20));

        jButtonProfileDelete.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButtonProfileDelete.setText("DELETE");
        jButtonProfileDelete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonProfileDelete.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jButtonProfileDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProfileDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonProfileDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 560, 150, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/EE Information Admin.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1220, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearActionPerformed
        clearTextField();
    }//GEN-LAST:event_jButtonClearActionPerformed

    private void jButtonProfileDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProfileDeleteActionPerformed

        int response = JOptionPane.showConfirmDialog(null, "Do you want to proceed with deleting the employee?",
                "Delete Entry Confirmation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            int employeeId = Integer.parseInt(jTextFieldEmployeeNum.getText());
            try {
                EmployeeService employeeService = new EmployeeService();
                employeeService.removeEmployee(employeeId);
                JOptionPane.showMessageDialog(this, "Employee deleted successfully.");
                loadEmployeeDetails();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

//        textFieldEditSetting(false);

    }//GEN-LAST:event_jButtonProfileDeleteActionPerformed

    private void jButtonAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAttendanceActionPerformed
        // TODO add your handling code here:
        if (!isEmployeeRowSelected()) {
            return; // Stop further processing if none is selected
        }
        try {
            if (attendanceWindow == null || !attendanceWindow.isDisplayable()) {
                attendanceWindow = new AttendanceAdmin(selectedRowEmpId(), empId);
                attendanceWindow.setVisible(true);
                attendanceWindow.pack();
                attendanceWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                attendanceWindow.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        attendanceWindow = null;
                    }
                });
            } else {
                attendanceWindow.toFront();
                attendanceWindow.requestFocus();
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeProfileAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonAttendanceActionPerformed


    private void jButtonProfileUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProfileUpdateActionPerformed

        try {
            Employee emp = getEmployeeFromForm();
            if (emp == null) {
                JOptionPane.showMessageDialog(this, "Employee details are invalid.");
                return;
            }

            // Update employee
            EmployeeService employeeService = new EmployeeService();
            try {
                employeeService.updateEmployee(emp);  // <-- this line!
            } catch (Exception updateEx) {
                JOptionPane.showMessageDialog(this, "Failed to update employee: " + updateEx.getMessage());
                return;
            }

            // Success
            JOptionPane.showMessageDialog(this, "Employee updated successfully.");
            loadEmployeeDetails();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "System Error: " + e.getMessage());
            return;
        }

    }//GEN-LAST:event_jButtonProfileUpdateActionPerformed

    private void jTableEmployeeListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmployeeListMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTableEmployeeList.getModel();
        int selectedRowIndex = jTableEmployeeList.getSelectedRow();

        // Date handling
        Object birthday = model.getValueAt(selectedRowIndex, 3);
        Date birthday_ = null;
        if (birthday != null) {
            try {
                birthday_ = convertToDate(birthday);
            } catch (ParseException ex) {
                Logger.getLogger(EmployeeProfileAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        jDateChooserBirthday.setDate(birthday_);

        // All others safely get value
        jTextFieldEmployeeNum.setText(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 0));
        jTextFieldLastName.setText(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 1));
        jTextFieldFirstName.setText(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 2));
        jTextAreaAddress.setText(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 4));
        jTextFieldPhoneNum.setText(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 5));
        jTextFieldSSSnum.setText(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 6));
        jTextFieldPhilhealthNum.setText(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 7));
        jTextFieldTINnum.setText(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 8));
        jTextFieldPagibigNum.setText(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 9));

// If these are JComboBox
        jComboBoxStatus.setSelectedItem(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 10));
        jComboBoxPosition.setSelectedItem(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 11));
        jComboBoxImmediateSupervisor.setSelectedItem(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 12));

// Continue with text fields
        jTextFieldBasicSalary.setText(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 13));
        jTextFieldRiceSubsidy.setText(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 14));
        jTextFieldPhoneAllow.setText(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 15));
        jTextFieldClothAllow.setText(EmployeeTableUtil.safeGetValue(model, selectedRowIndex, 16));

    }//GEN-LAST:event_jTableEmployeeListMouseClicked


    private void jButtonProfileAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProfileAddActionPerformed

        try {
            // 1. Uniqueness check
            if (!checkFieldsUnique()) {
                // Error already shown by checkFieldsUnique, but make sure to return to STOP process
                return;
            }

            // 2. Generate new Employee ID
            String newEmployeeId = Integer.toString(generateUniqueId());
            jTextFieldEmployeeNum.setText(newEmployeeId);

            // 3. Get employee details from form
            Employee emp = getEmployeeFromForm();
            if (emp == null) {
                JOptionPane.showMessageDialog(this, "Employee details are invalid.");
                return;
            }

            // 4. Add employee
            EmployeeService employeeService = new EmployeeService();
            try {
                employeeService.addEmployee(emp);
            } catch (SQLException addEx) {
                JOptionPane.showMessageDialog(this, "Failed to add employee: " + addEx.getMessage());
                return;
            }

            // 5. Success
            JOptionPane.showMessageDialog(this, "Employee added successfully.");
            loadEmployeeDetails();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "System Error: " + e.getMessage());
            // Optionally, System.exit(1); if you want to terminate the whole application (usually not recommended in desktop apps)
            // System.exit(1);
        }

    }//GEN-LAST:event_jButtonProfileAddActionPerformed


    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void jButtonLeaveApplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLeaveApplicationActionPerformed
        if (leaveEmployeeWindow == null || !leaveEmployeeWindow.isVisible()) {
            try {
                leaveEmployeeWindow = new LeaveApplicationAdmin(empId);
                leaveEmployeeWindow.setDefaultCloseOperation(PayrollProcessing.DISPOSE_ON_CLOSE);
                leaveEmployeeWindow.pack();
                leaveEmployeeWindow.setVisible(true);
                leaveEmployeeWindow.setAlwaysOnTop(true);

                leaveEmployeeWindow.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        leaveEmployeeWindow = null;
                    }
                });

            } catch (Exception ex) {
                Logger.getLogger(EmployeeProfileAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonLeaveApplicationActionPerformed

    private void jTextFieldFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFirstNameActionPerformed

    private void jTextFieldBasicSalaryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBasicSalaryKeyTyped
        // TODO add your handling code here:
        InputValidator.allowOnlyDigits(evt);
    }//GEN-LAST:event_jTextFieldBasicSalaryKeyTyped

    private void jTextFieldBasicSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBasicSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBasicSalaryActionPerformed

    private void jTextFieldClothAllowKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldClothAllowKeyTyped
        // TODO add your handling code here:
        InputValidator.allowOnlyDigits(evt);
    }//GEN-LAST:event_jTextFieldClothAllowKeyTyped

    private void jTextFieldClothAllowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldClothAllowActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldClothAllowActionPerformed

    private void jTextFieldPhoneAllowKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPhoneAllowKeyTyped
        // TODO add your handling code here:
        InputValidator.allowOnlyDigits(evt);
    }//GEN-LAST:event_jTextFieldPhoneAllowKeyTyped

    private void jTextFieldRiceSubsidyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldRiceSubsidyKeyTyped
        // TODO add your handling code here:

        InputValidator.allowOnlyDigits(evt);
    }//GEN-LAST:event_jTextFieldRiceSubsidyKeyTyped

    private void jTextFieldPhilhealthNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPhilhealthNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPhilhealthNumActionPerformed

    private void jTextFieldPhoneNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPhoneNumActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldPhoneNumActionPerformed

    private void jTextFieldTINnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTINnumActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldTINnumActionPerformed

    private void jTextFieldSSSnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSSSnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSSSnumActionPerformed

    private void jTextFieldEmployeeNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldEmployeeNumKeyTyped
        // TODO add your handling code here:
//        InputValidator.allowOnlyDigits(evt);
    }//GEN-LAST:event_jTextFieldEmployeeNumKeyTyped

    private void jTextFieldEmployeeNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEmployeeNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEmployeeNumActionPerformed

    private void jDateChooserBirthdayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooserBirthdayKeyTyped
        // TODO add your handling code here:
        jDateChooserBirthday.getDateEditor().getUiComponent().setEnabled(false);

    }//GEN-LAST:event_jDateChooserBirthdayKeyTyped

    private void jTextFieldTINnumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTINnumKeyTyped
        // TODO add your handling code here:
        InputValidator.allowOnlyDigitsSpecial(evt, jTextFieldTINnum.getText().trim(), 20);
    }//GEN-LAST:event_jTextFieldTINnumKeyTyped

    private void jTextFieldSSSnumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSSSnumKeyTyped
        // TODO add your handling code here:
        InputValidator.allowOnlyDigitsSpecial(evt, jTextFieldSSSnum.getText().trim(), 20);
    }//GEN-LAST:event_jTextFieldSSSnumKeyTyped

    private void jTextFieldPhilhealthNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPhilhealthNumKeyTyped
        // TODO add your handling code here:

        InputValidator.allowOnlyDigitsSpecial(evt, jTextFieldPhilhealthNum.getText().trim(), 20);
    }//GEN-LAST:event_jTextFieldPhilhealthNumKeyTyped

    private void jTextFieldPagibigNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPagibigNumKeyTyped
        // TODO add your handling code here:

        InputValidator.allowOnlyDigitsSpecial(evt, jTextFieldPagibigNum.getText().trim(), 20);
    }//GEN-LAST:event_jTextFieldPagibigNumKeyTyped

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Confirm Exit",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            // Dispose all open frames
            for (java.awt.Window window : java.awt.Window.getWindows()) {
                if (window.isVisible()) {
                    window.dispose();
                    try {
                        new LoginView().setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(EmployeeProfileAdmin.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        }
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jTextFieldPhoneNumKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPhoneNumKeyTyped
        // TODO add your handling code here:
        InputValidator.allowOnlyDigitsSpecial(evt, jTextFieldPhoneNum.getText(), 10);

    }//GEN-LAST:event_jTextFieldPhoneNumKeyTyped

    private void jButtonPayrollSummaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPayrollSummaryActionPerformed
        try {
            if (payrollSummaryWindow == null || !payrollSummaryWindow.isDisplayable()) {
                payrollSummaryWindow = new PayrollSummaryView();
                payrollSummaryWindow.setVisible(true);
                payrollSummaryWindow.pack();
                payrollSummaryWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                payrollSummaryWindow.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        payrollSummaryWindow = null;
                    }
                });
            } else {
                payrollSummaryWindow.toFront();
                payrollSummaryWindow.requestFocus();
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeProfileAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonPayrollSummaryActionPerformed

    private void jTextFieldLastNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldLastNameKeyTyped
        // TODO add your handling code here:
//        InputValidator.allowValidNameCharacters(evt);
    }//GEN-LAST:event_jTextFieldLastNameKeyTyped

    private void jTextFieldFirstNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldFirstNameKeyTyped
        // TODO add your handling code here:
//        InputValidator.allowValidNameCharacters(evt);
    }//GEN-LAST:event_jTextFieldFirstNameKeyTyped

    private void jTextFieldLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLastNameActionPerformed

    private void jButtonViewEmployee1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewEmployee1ActionPerformed
        if (!isEmployeeRowSelected()) {
            return; // Stop further processing if none is selected
        }
        try {
            // Check if the payroll window is already open
            if (payrollWindow == null || !payrollWindow.isDisplayable()) {
                payrollWindow = new PayrollProcessing(selectedRowEmpId());
                payrollWindow.setVisible(true);
                payrollWindow.pack();
                payrollWindow.setDefaultCloseOperation(PayrollProcessing.DISPOSE_ON_CLOSE);

                payrollWindow.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                        payrollWindow = null;
                    }
                });
            } else {
                payrollWindow.toFront();
                payrollWindow.requestFocus();
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeProfileAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonViewEmployee1ActionPerformed

    private void jTextAreaAddressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaAddressMouseClicked
        // TODO add your handling code here:

        AddressDialog dialog = new AddressDialog((JFrame) SwingUtilities.getWindowAncestor(jTextAreaAddress), jTextAreaAddress.getText());
        dialog.setVisible(true);
        if (dialog.isConfirmed()) {
            jTextAreaAddress.setText(dialog.getAddress());
        }

    }//GEN-LAST:event_jTextAreaAddressMouseClicked

    private void jLabel12InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jLabel12InputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12InputMethodTextChanged

    private void jTextFieldPendingLeaveCounterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPendingLeaveCounterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPendingLeaveCounterActionPerformed

    private void jTextFieldPendingLeaveCounterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPendingLeaveCounterKeyPressed

    }//GEN-LAST:event_jTextFieldPendingLeaveCounterKeyPressed

    private void jTextFieldPendingLeaveCounterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldPendingLeaveCounterMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            showLeaveCounter();
        } catch (Exception ex) {
            Logger.getLogger(EmployeeProfileAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextFieldPendingLeaveCounterMouseClicked

    private void jButtonExit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExit1ActionPerformed
        try {
            // TODO add your handling code here:
            this.dispose();
            EmployeeProfileUser userFrame = new EmployeeProfileUser(empId);
            userFrame.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeProfileAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonExit1ActionPerformed

    private void jComboBoxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxStatusActionPerformed

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
        }        // TODO add your handling code here:
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
                    new EmployeeProfileAdmin(empId).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(EmployeeProfileAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAttendance;
    private javax.swing.JButton jButtonClear;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonExit1;
    private javax.swing.JButton jButtonLeaveApplication;
    private javax.swing.JButton jButtonPayrollSummary;
    private javax.swing.JButton jButtonProfileAdd;
    private javax.swing.JButton jButtonProfileDelete;
    private javax.swing.JButton jButtonProfileUpdate;
    private javax.swing.JButton jButtonViewEmployee1;
    private javax.swing.JComboBox<String> jComboBoxImmediateSupervisor;
    private javax.swing.JComboBox<String> jComboBoxPosition;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private com.toedter.calendar.JDateChooser jDateChooserBirthday;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBasicSalary;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEmployeeList;
    private javax.swing.JTextArea jTextAreaAddress;
    private javax.swing.JTextField jTextFieldBasicSalary;
    private javax.swing.JTextField jTextFieldClothAllow;
    private javax.swing.JTextField jTextFieldEmployeeNum;
    private javax.swing.JTextField jTextFieldFirstName;
    private javax.swing.JTextField jTextFieldLastName;
    private javax.swing.JTextField jTextFieldPagibigNum;
    private javax.swing.JTextField jTextFieldPendingLeaveCounter;
    private javax.swing.JTextField jTextFieldPhilhealthNum;
    private javax.swing.JTextField jTextFieldPhoneAllow;
    private javax.swing.JTextField jTextFieldPhoneNum;
    private javax.swing.JTextField jTextFieldRiceSubsidy;
    private javax.swing.JTextField jTextFieldSSSnum;
    private javax.swing.JTextField jTextFieldTINnum;
    // End of variables declaration//GEN-END:variables

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.jpg")));
    }

}
