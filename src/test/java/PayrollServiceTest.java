import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Date;
import java.util.List;
import model.Payroll;
import service.PayrollService;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PayrollServiceTest {

    private PayrollService payrollService;

    @BeforeAll
    public static void setupDB() throws Exception {
        System.out.println("Database connection established for PayrollServiceTest.");
    }

    @AfterAll
    public static void teardown() throws Exception {
        System.out.println("Database connection closed after PayrollServiceTest.");
    }

    @BeforeEach
    public void setUp() throws Exception {
        payrollService = new PayrollService();
    }

    @Test
    public void test1_getPayroll_specificPeriod() throws Exception {
        System.out.println("Test 1: getPayroll(employeeId, periodStart, periodEnd) - Payslip for period");
        int employeeId = 10001;
        Date start = Date.valueOf("2024-06-01");
        Date end = Date.valueOf("2024-06-30");
        Payroll payroll = payrollService.getPayroll(employeeId, start, end);
        assertNotNull(payroll, "Payroll should not be null for valid employee and period");
        System.out.println("Payroll for: " + payroll.getEmployeeFullName() + " period: " + payroll.getPayPeriodStart() + " - " + payroll.getPayPeriodEnd());
    }

    @Test
    public void test2_getPayroll_latest() throws Exception {
        System.out.println("Test 2: getPayroll(employeeId) - Latest payroll for employee");
        int employeeId = 10001;
        Payroll payroll = payrollService.getPayroll(employeeId);
        assertNotNull(payroll, "Payroll should not be null for valid employee");
        System.out.println("Latest Payroll for: " + payroll.getEmployeeFullName());
    }

    @Test
    public void test3_getAllPayroll() throws Exception {
        System.out.println("Test 3: getAllPayroll - All payrolls for period");
        int employeeId = 10001;
        Date start = Date.valueOf("2024-06-01");
        Date end = Date.valueOf("2024-06-30");
        List<Payroll> payrolls = payrollService.getAllPayroll(employeeId, start, end);
        assertNotNull(payrolls, "Payroll list should not be null");
        assertTrue(payrolls.size() > 0, "Payroll list should have at least one entry");
        System.out.println("Payroll entries found: " + payrolls.size());
    }

    @Test
    public void test4_computePayroll_logic() throws Exception {
        System.out.println("Test 4: computePayroll - Compute payroll using service logic");
        int employeeId = 10001;
        Date start = Date.valueOf("2024-06-01");
        Date end = Date.valueOf("2024-06-30");
        Payroll payroll = payrollService.computePayroll(employeeId, start, end);
        assertNotNull(payroll, "Computed payroll should not be null");
        assertTrue(payroll.getGrossSalaryCalc() > 0, "Gross salary should be positive");
        System.out.println("Computed Payroll: Gross = " + payroll.getGrossSalaryCalc() + ", Takehome = " + payroll.getTakehomePay());
    }

    @Test
    public void test5_getPayDetails() throws Exception {
        System.out.println("Test 5: getPayDetails - Pay details breakdown");
        int employeeId = 10001;
        Date start = Date.valueOf("2024-06-01");
        Date end = Date.valueOf("2024-06-30");
        List<Double> payDetails = payrollService.getPayDetails(employeeId, start, end);
        assertNotNull(payDetails, "Pay details should not be null");
        assertEquals(5, payDetails.size(), "Should return five pay detail values");
        System.out.println("Pay details: Regular=" + payDetails.get(0) + ", OT=" + payDetails.get(1)
                + ", Basic=" + payDetails.get(2) + ", Hourly=" + payDetails.get(3) + ", Gross=" + payDetails.get(4));
    }

    @Test
    public void test6_getTotalBenefit() throws Exception {
        System.out.println("Test 6: getTotalBenefit - Compute total benefit for employee");
        int employeeId = 10001;
        double totalBenefit = payrollService.getTotalBenefit(employeeId);
        assertTrue(totalBenefit >= 0);
        System.out.println("Total benefit: " + totalBenefit);
    }

    @Test
    public void test7_getTakehomePay() throws Exception {
        System.out.println("Test 7: getTakehomePay - Compute take-home pay");
        int employeeId = 10001;
        Date start = Date.valueOf("2024-06-01");
        Date end = Date.valueOf("2024-06-30");
        double takehome = payrollService.getTakehomePay(employeeId, start, end);
        assertTrue(takehome > 0, "Takehome pay should be positive");
        System.out.println("Takehome pay: " + takehome);
    }
}
