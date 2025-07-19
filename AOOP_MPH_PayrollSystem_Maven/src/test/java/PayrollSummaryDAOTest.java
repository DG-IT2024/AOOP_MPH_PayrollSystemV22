import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;
import java.util.List;
import dao.PayrollSummaryDAO;
import model.PayrollSummary;
import util.DBConnect;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PayrollSummaryDAOTest {

    private static Connection conn;
    private PayrollSummaryDAO payrollSummaryDAO;

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for PayrollSummaryDAOTest.");
    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed after PayrollSummaryDAOTest.");
        }
    }

    @BeforeEach
    public void setUp() {
        payrollSummaryDAO = new PayrollSummaryDAO(conn);
    }

    @Test
    public void test1_getPayrollSummariesForEmployeeAndDateRange() throws Exception {
        System.out.println("Test 1: getPayrollSummaries - For one employee, with date range");
        Integer employeeId = 10001; // Use an existing employee
        Date start = Date.valueOf("2024-06-01");
        Date end = Date.valueOf("2024-06-30");
        List<PayrollSummary> summaries = payrollSummaryDAO.getPayrollSummaries(employeeId, start, end);
        assertNotNull(summaries, "Payroll summaries should not be null");
        assertTrue(summaries.size() > 0, "At least one payroll summary should exist for given employee and period");
        for (PayrollSummary ps : summaries) {
            System.out.println("PayrollSummary for " + ps.getEmployeeFullName() +
                ", Period: " + ps.getPayPeriodStart() + " to " + ps.getPayPeriodEnd() +
                ", Net Pay: " + ps.getNetPay());
        }
    }

    @Test
    public void test2_getPayrollSummariesForAllEmployeesAndPeriod() throws Exception {
        System.out.println("Test 2: getPayrollSummaries - For all employees, with date range");
        Integer employeeId = null; // null for all employees
        Date start = Date.valueOf("2024-06-01");
        Date end = Date.valueOf("2024-06-30");
        List<PayrollSummary> summaries = payrollSummaryDAO.getPayrollSummaries(employeeId, start, end);
        assertNotNull(summaries, "Payroll summaries should not be null");
        assertTrue(summaries.size() > 0, "At least one payroll summary should exist for given period");
        System.out.println("Found " + summaries.size() + " payroll summary entries for all employees.");
    }

    @Test
    public void test3_getPayrollSummariesForEmployeeNoDate() throws Exception {
        System.out.println("Test 3: getPayrollSummaries - For one employee, all periods");
        Integer employeeId = 10001; // Use an existing employee
        Date start = null;
        Date end = null;
        List<PayrollSummary> summaries = payrollSummaryDAO.getPayrollSummaries(employeeId, start, end);
        assertNotNull(summaries, "Payroll summaries should not be null");
        assertTrue(summaries.size() > 0, "At least one payroll summary should exist for the employee");
        System.out.println("Total payroll periods for employee: " + summaries.size());
    }

    @Test
    public void test4_getPayrollSummariesAllNull() throws Exception {
        System.out.println("Test 4: getPayrollSummaries - All employees, all periods");
        List<PayrollSummary> summaries = payrollSummaryDAO.getPayrollSummaries(null, null, null);
        assertNotNull(summaries, "Payroll summaries should not be null");
        assertTrue(summaries.size() > 0, "Should return payroll summaries for all employees and periods");
        System.out.println("Total payroll summary entries found: " + summaries.size());
    }
}
