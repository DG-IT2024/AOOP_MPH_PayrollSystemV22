
import org.junit.jupiter.api.*;
import service.PayrollService;
import model.Payroll;
import util.PayrollUtil;

import java.sql.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import util.DBConnect;

public class PayrollTest {

    private PayrollService service;

    private static Connection conn;

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for LeaveTest.");
    }

    @BeforeEach
    public void setup() throws Exception {
        service = new PayrollService();
    }

    @Test
    public void testCase01_CalculateNetPay() {
        double gross = 15000.0;
        double deductions = 3200.0;
        double expected = 11800.0;
        double actual = PayrollUtil.calculateNetPay(gross, deductions);
        assertEquals(expected, actual, 0.001);
    }

    @Test
    public void testCase02_ComputeSSSDeduction() {
        double salary = 20000.0;
        double expected = 800.0; // Example expected
        double actual = PayrollUtil.calculateSSSContribution(salary);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCase03_ComputePhilHealthDeduction() {
        double salary = 20000.0;
        double expected = 600.0; // Example expected
        double actual = PayrollUtil.calculatePhilHealthContribution(salary);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCase04_ComputePagIbigDeduction() {
        double salary = 20000.0;
        double expected = 100.0;
        double actual = PayrollUtil.calculatePagIbigContribution(salary);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCase05_CalculateGrossPay() {
        double hourlyRate = 100.0;
        int totalHours = 160;
        double expectedGross = 16000.0;
        double actualGross = PayrollUtil.calculateGrossPay(hourlyRate, totalHours);
        assertEquals(expectedGross, actualGross, 0.001);
    }

    @Test
    public void testCase06_FormatCurrency() {
        double value = 12345.678;
        String expected = "Php 12,345.68"; // assuming PHP locale
        String actual = PayrollUtil.formatCurrency(value);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase07_CalculateTotalDeductions() {
        double sss = 800.0;
        double philHealth = 600.0;
        double pagIbig = 100.0;
        double expected = 1500.0;
        double actual = PayrollUtil.calculateTotalDeductions(sss, philHealth, pagIbig);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase08_CalculateHourlyRate() {
        double monthlySalary = 20000.0;
        int workingDays = 22;
        int hoursPerDay = 8;
        double expected = 113.64; // 20000 / (22 * 8)
        double actual = PayrollUtil.calculateHourlyRate(monthlySalary, workingDays, hoursPerDay);
        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testCase9_CalculateOvertimePay() {
        double hourlyRate = 100.0;
        double overtimeHours = 10;
        double overtimeMultiplier = 1.5;
        double expected = 1500.0;
        double actual = PayrollUtil.calculateOvertimePay(hourlyRate, overtimeHours, overtimeMultiplier);
        assertEquals(expected, actual);
    }

    // The following tests require actual database setup. You can uncomment them if the environment supports it.
    @Test
    public void testCase10_GetAllPayrollRecords() throws SQLException {
        List<Payroll> result = service.listAllPayroll();
        assertNotNull(result);
        assertTrue(result.size() >= 0);
    }

    @Test
    public void testCase11_GetPayrollByEmployeeId() throws SQLException {
        Payroll result = service.getPayrollByEmployeeId(1); // use valid ID
        assertNotNull(result);
    }

    @Test
    public void testCase12_UpdatePayrollRecord() throws SQLException {
        Payroll payroll = new Payroll();
        payroll.setPayrollId(1); // set valid ID and update fields
        payroll.setBasicSalary(20000);
        service.updatePayroll(payroll);
    }

    @Test
    public void testCase13_InsertPayrollRecord() throws SQLException {
        Payroll payroll = new Payroll();
        payroll.setEmployeeId(2); // use valid employee ID
        payroll.setBasicSalary(22000);
        service.insertPayroll(payroll);
    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed after LeaveTest.");
        }
    }
}
