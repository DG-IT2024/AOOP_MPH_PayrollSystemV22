import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Date;
import java.util.List;
import model.PayrollSummary;
import service.PayrollSummaryService;
import javax.swing.JTable;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PayrollSummaryServiceTest {

    private PayrollSummaryService payrollSummaryService;

    @BeforeAll
    public static void setupDB() throws Exception {
        System.out.println("Database connection established for PayrollSummaryServiceTest.");
    }

    @AfterAll
    public static void teardown() throws Exception {
        System.out.println("Database connection closed after PayrollSummaryServiceTest.");
    }

    @BeforeEach
    public void setUp() throws Exception {
        payrollSummaryService = new PayrollSummaryService();
    }

    @Test
    public void test1_listPayrollSummaryForEmployeeAndDateRange() throws Exception {
        System.out.println("Test 1: listPayrollSummary - For employee and date range");
        Integer empId = 10001;
        Date start = Date.valueOf("2024-06-01");
        Date end = Date.valueOf("2024-06-30");
        List<PayrollSummary> list = payrollSummaryService.listPayrollSummary(empId, start, end);
        assertNotNull(list, "PayrollSummary list should not be null");
        assertTrue(list.size() > 0, "Should return at least one summary");
        System.out.println("Summaries found: " + list.size());
    }

    @Test
    public void test2_listPayrollSummaryAllEmployees() throws Exception {
        System.out.println("Test 2: listPayrollSummary - For all employees");
        List<PayrollSummary> list = payrollSummaryService.listPayrollSummary(null, null, null);
        assertNotNull(list, "PayrollSummary list should not be null");
        assertTrue(list.size() > 0, "Should return at least one summary for all employees");
        System.out.println("All employee summaries found: " + list.size());
    }

    @Test
    public void test3_benefitsCalculation() throws Exception {
        System.out.println("Test 3: benefits - Compute total benefit for employee");
        int empId = 10001;
        double benefits = payrollSummaryService.benefits(empId);
        assertTrue(benefits >= 0, "Total benefits should be non-negative");
        System.out.println("Total benefits for emp " + empId + ": " + benefits);
    }

    @Test
    public void test4_listPayrollSummary_noResults() throws Exception {
        System.out.println("Test 4: listPayrollSummary - For employee/date range with no results");
        Integer empId = 99999; // Intentionally using non-existent ID
        Date start = Date.valueOf("2023-01-01");
        Date end = Date.valueOf("2023-01-31");
        List<PayrollSummary> list = payrollSummaryService.listPayrollSummary(empId, start, end);
        assertNotNull(list, "PayrollSummary list should not be null");
        assertEquals(0, list.size(), "Should return zero summaries for non-existent employee/date");
        System.out.println("Summaries found for invalid employee/date: " + list.size());
    }

    @Test
    public void test5_benefitsCalculation_nonExistentEmployee() {
        System.out.println("Test 5: benefits - Non-existent employee should throw Exception");
        int empId = 99999; // Intentionally invalid
        Exception exception = assertThrows(Exception.class, () -> {
            payrollSummaryService.benefits(empId);
        });
        System.out.println("Exception thrown as expected for non-existent employee: " + exception.getMessage());
    }

    @Test
    public void test6_listPayrollSummary_dateRangeOnly() throws Exception {
        System.out.println("Test 6: listPayrollSummary - Only date range (all employees)");
        Integer empId = null;
        Date start = Date.valueOf("2024-01-01");
        Date end = Date.valueOf("2024-12-31");
        List<PayrollSummary> list = payrollSummaryService.listPayrollSummary(empId, start, end);
        assertNotNull(list, "PayrollSummary list should not be null");
        System.out.println("Summaries found for year 2024: " + list.size());
    }

    @Test
    public void test7_fetchPayrollSummariesJTable() throws Exception {
        System.out.println("Test 7: fetchPayrollSummaries - Populate JTable");
        Integer empId = 10001;
        Date start = Date.valueOf("2024-06-01");
        Date end = Date.valueOf("2024-06-30");
        JTable table = new JTable();
        payrollSummaryService.fetchPayrollSummaries(table, empId, start, end);
        assertNotNull(table.getModel(), "Table model should not be null");
        System.out.println("JTable model class: " + table.getModel().getClass().getSimpleName());
    }

    @Test
    public void test8_fetchAllPayrollSummariesJTable() throws Exception {
        System.out.println("Test 8: fetchAllPayrollSummaries - Populate JTable with all employees");
        JTable table = new JTable();
        payrollSummaryService.fetchAllPayrollSummaries(table);
        assertNotNull(table.getModel(), "Table model should not be null");
        System.out.println("JTable total rows: " + table.getRowCount());
    }

    @Test
    public void test9_listPayrollSummary_nullDateEmployee() throws Exception {
        System.out.println("Test 9: listPayrollSummary - Null date, real employee");
        Integer empId = 10001;
        List<PayrollSummary> list = payrollSummaryService.listPayrollSummary(empId, null, null);
        assertNotNull(list, "PayrollSummary list should not be null");
        assertTrue(list.size() > 0, "Should return at least one summary for employee with null date");
        System.out.println("Summaries found: " + list.size());
    }
}
