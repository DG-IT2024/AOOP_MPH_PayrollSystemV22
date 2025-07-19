import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;
import java.util.List;
import dao.PayrollDAO;
import model.Payroll;
import util.DBConnect;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PayrollDAOTest {

    private static Connection conn;
    private PayrollDAO payrollDAO;

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for PayrollDAOTest.");
    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed after PayrollDAOTest.");
        }
    }

    @BeforeEach
    public void setUp() {
        payrollDAO = new PayrollDAO(conn);
    }

    @Test
    public void test1_getPayrollDetails() throws Exception {
        System.out.println("Test 1: getPayrollDetails - Retrieve payslip for specific employee and period");
        // Use actual employee_id and date range from your DB
        Integer employeeId = 10001;
        Date start = Date.valueOf("2024-06-03");
        Date end = Date.valueOf("2024-06-14");
        Payroll payroll = payrollDAO.getPayrollDetails(employeeId, start, end);
        assertNotNull(payroll, "Payroll should not be null for valid employee and period");
        System.out.println("Payroll for " + payroll.getEmployeeFullName() + ", period: " + payroll.getPayPeriodStart() + " - " + payroll.getPayPeriodEnd());
    }

    @Test
    public void test2_getPayrollByEmployee() throws Exception {
        System.out.println("Test 2: getPayroll(employeeId) - Retrieve all payrolls for employee");
        Integer employeeId = 10001;
        List<Payroll> payrolls = payrollDAO.getPayroll(employeeId);
        assertNotNull(payrolls, "Payroll list should not be null");
        assertTrue(payrolls.size() > 0, "Payroll list should have at least 1 entry");
        for (Payroll p : payrolls) {
            System.out.println("Payroll for " + p.getEmployeeFullName() + " on period: " + p.getPayPeriodStart() + " - " + p.getPayPeriodEnd());
        }
    }

    @Test
    public void test3_getPayrollByEmployeeAndPeriod() throws Exception {
        System.out.println("Test 3: getPayroll(employeeId, start, end) - Retrieve payrolls for employee and period");
        Integer employeeId = 10001;
        Date start = Date.valueOf("2024-06-03");
        Date end = Date.valueOf("2024-06-14");
        List<Payroll> payrolls = payrollDAO.getPayroll(employeeId, start, end);
        assertNotNull(payrolls, "Payroll list should not be null");
        assertTrue(payrolls.size() > 0, "Payroll list should have at least 1 entry");
        for (Payroll p : payrolls) {
            System.out.println("Payroll for " + p.getEmployeeFullName() + " period: " + p.getPayPeriodStart() + " - " + p.getPayPeriodEnd());
        }
    }

    @Test
    public void test4_insertPayroll() throws Exception {
        System.out.println("Test 4: insertPayroll - Insert payroll record");
        // Set up a dummy payroll. Fill in real fields as needed.
        Payroll payroll = new Payroll();
        payroll.setEmployeeId(10001);
        payroll.setEmployeeFullName("Garcia, Manuel III");
        payroll.setJobPosition("Chief Executive Officer");
        payroll.setDepartmentName("Executive");
        payroll.setPayPeriodStart(Date.valueOf("2024-07-01"));
        payroll.setPayPeriodEnd(Date.valueOf("2024-07-15"));
        payroll.setBasicSalary(90000);
        payroll.setDailyRate(4090.91);
        payroll.setTotalWorkedHours(80);
        payroll.setOvertimeHours(5);
        payroll.setDaysWorked(10);
        payroll.setGrossSalaryCalc(95000);
        payroll.setRiceSubsidy(1500);
        payroll.setPhoneAllowance(2000);
        payroll.setClothingAllowance(1000);
        payroll.setTotalBenefits(4500);
        payroll.setSssDeduction(500);
        payroll.setPhilhealth(400);
        payroll.setPagibig(300);
        payroll.setTaxableIncome(93800);
        payroll.setWithholdingTax(2000);
        payroll.setTotalDeductions(3200);
        payroll.setTakehomePay(96300);

        boolean inserted = payrollDAO.insertPayroll(payroll);
        assertTrue(inserted, "Payroll should be inserted successfully");
        System.out.println("Inserted payroll for " + payroll.getEmployeeFullName() + " period: " + payroll.getPayPeriodStart() + " - " + payroll.getPayPeriodEnd());
    }
}
