
import org.junit.jupiter.api.*;
import service.DeductionRateService;
import service.DeductionRateServiceImpl;
import util.DBConnect;

import java.sql.Connection;

public class DeductionRateServiceTest {

    private static Connection conn;
    private DeductionRateService service;

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for DeductionRateServiceTest.");
    }

    @BeforeEach
    public void initService() throws Exception {
        service = new DeductionRateServiceImpl();
    }

    @Test
    public void testCase1_ComputeSSS() throws Exception {
        double result = service.computeSss(18000.0);
        System.out.println("Test Case 1 - computeSss(18000): " + result);
        Assertions.assertTrue(result >= 0);
    }

    @Test
    public void testCase2_ComputePhilHealth_WithFixedAmountOrRate() throws Exception {
        double result = service.computePhilHealth(25000.0);
        System.out.println("Test Case 2 - computePhilHealth(25000): " + result);
        Assertions.assertTrue(result >= 0);
    }

    @Test
    public void testCase3_ComputePagIbig_WithCap() throws Exception {
        double result = service.computePagIbig(50000.0);
        System.out.println("Test Case 3 - computePagIbig(50000): " + result);
        Assertions.assertTrue(result <= 100.0);
    }

    @Test
    public void testCase4_ComputeTaxableIncome() throws Exception {
        double result = service.taxableIncome(30000.0);
        System.out.println("Test Case 4 - taxableIncome(30000): " + result);
        Assertions.assertTrue(result >= 0);
    }

    @Test
    public void testCase5_ComputeWithholdingTax() throws Exception {
        double result = service.computeWithholdingTax(35000.0);
        System.out.println("Test Case 5 - computeWithholdingTax(35000): " + result);
        Assertions.assertTrue(result >= 0);
    }

    @Test
    public void testCase6_TotalDeduction() throws Exception {
        double result = service.totalDeduction(32000.0);
        System.out.println("Test Case 6 - totalDeduction(32000): " + result);
        Assertions.assertTrue(result >= 0);
    }

    @Test
    public void testCase7_GetDeductionRateForIncome() throws Exception {
        var rate = service.getDeductionRateForIncome("SSS", 18000.0);
        System.out.println("Test Case 7 - getDeductionRateForIncome(\"SSS\", 18000): " + (rate != null));
        Assertions.assertNotNull(rate);
    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed for DeductionRateServiceTest.");
        }
    }

    @Test
    public void testCase8_ComputeSss_Within3250Bracket() throws Exception {
        double result = service.computeSss(3000.0);  // Below ₱3,250
        System.out.println("Test Case 8 - computeSss(3000): " + result);
        Assertions.assertEquals(135.0, result);
    }

    @Test
    public void testCase9_ComputePhilHealth_PercentBased() throws Exception {
        double salary = 60000.0;
        double result = service.computePhilHealth(salary);

        double raw = Math.round(salary * 0.015 * 100.0) / 100.0;
        double expected = Math.max(150.0, Math.min(900.0, raw));

        System.out.println("Test Case 9 - computePhilHealth(60000): " + result);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testCase10_ComputePagIbig_Capped() throws Exception {
        double salary = 70000.0;
        double result = service.computePagIbig(salary);
        System.out.println("Test Case 10 - computePagIbig(70000): " + result);
        Assertions.assertEquals(100.0, result);  // Should cap at 100
    }

    @Test
    public void testCase11_TaxableIncome_CheckIfAccurate() throws Exception {
        double salary = 30000.0;

        double sss = service.computeSss(salary);
        double philhealth = service.computePhilHealth(salary);
        double pagibig = service.computePagIbig(salary);

        double expectedTaxable = salary - sss - philhealth - pagibig;
        double result = service.taxableIncome(salary);

        System.out.println("Test Case 11 - taxableIncome(30000): " + result);
        Assertions.assertEquals(Math.round(expectedTaxable * 100.0) / 100.0, result);
    }

    @Test
    public void testCase12_ComputeWithholdingTax_BelowThreshold() throws Exception {
        double result = service.computeWithholdingTax(20000.0);  // Below ₱20,832
        System.out.println("Test Case 12 - computeWithholdingTax(20000): " + result);
        Assertions.assertEquals(0.0, result);
    }

    @Test
    public void testCase13_ComputeWithholdingTax_AboveThreshold() throws Exception {
        double salary = 50000.0;
        double result = service.computeWithholdingTax(salary);
        System.out.println("Test Case 13 - computeWithholdingTax(50000): " + result);
        Assertions.assertTrue(result > 0);
    }

    @Test
    public void testCase14_TotalDeduction_ConsistencyCheck() throws Exception {
        double salary = 45000.0;
        double sss = service.computeSss(salary);
        double phil = service.computePhilHealth(salary);
        double pagibig = service.computePagIbig(salary);
        double tax = service.computeWithholdingTax(salary);
        double expectedTotal = sss + phil + pagibig + tax;
        double result = service.totalDeduction(salary);
        System.out.println("Test Case 14 - totalDeduction(45000): " + result);
        Assertions.assertEquals(Math.round(expectedTotal * 100.0) / 100.0, result);
    }

}
