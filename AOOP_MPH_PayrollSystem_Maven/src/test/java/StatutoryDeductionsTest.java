import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import util.DBConnect;
import util.StatutoryDeductions;

public class StatutoryDeductionsTest {

    private static Connection conn;

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for StatutoryDeductionsTest.");
    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed after StatutoryDeductionsTest.");
        }
    }

    @Test
    public void test1_calculatePagIbig_minimumContribution() {
        System.out.println("Running test1_calculatePagIbig_minimumContribution...");
        double basis = 1000.0;
        double expected = 1000.0 * 0.01; // Usually minimum is 1%
        double actual = StatutoryDeductions.calculatePagIbig(basis);
        System.out.println("Input: " + basis + ", Expected: " + expected + ", Actual: " + actual);
        assertEquals(expected, actual, 0.01, "Pag-IBIG calculation for minimum should be correct");
    }

    @Test
    public void test2_calculatePagIbig_standardContribution() {
        System.out.println("Running test2_calculatePagIbig_standardContribution...");
        double basis = 5000.0;
        double expected = 5000.0 * 0.02; // Typical max is 2%
        double actual = StatutoryDeductions.calculatePagIbig(basis);
        System.out.println("Input: " + basis + ", Expected: " + expected + ", Actual: " + actual);
        assertEquals(expected, actual, 0.01, "Pag-IBIG calculation for regular basis should be correct");
    }

    @Test
    public void test3_calculatePhilHealth_lowBracket() {
        System.out.println("Running test3_calculatePhilHealth_lowBracket...");
        double basis = 10000.0;
        // The formula may vary by year; adjust expected as needed!
        double expected = basis * 0.03 / 2; // Assume 3% divided by 2 (employee share)
        double actual = StatutoryDeductions.calculatePhilHealth(basis);
        System.out.println("Input: " + basis + ", Expected: " + expected + ", Actual: " + actual);
        assertEquals(expected, actual, 0.01, "PhilHealth calculation for low bracket should be correct");
    }

    @Test
    public void test4_calculatePhilHealth_highBracket() {
        System.out.println("Running test4_calculatePhilHealth_highBracket...");
        double basis = 90000.0;
        double expected = basis * 0.05 / 2; // Assume 5% divided by 2 (employee share)
        double actual = StatutoryDeductions.calculatePhilHealth(basis);
        System.out.println("Input: " + basis + ", Expected: " + expected + ", Actual: " + actual);
        assertEquals(expected, actual, 0.01, "PhilHealth calculation for high bracket should be correct");
    }

    @Test
    public void test5_calculateSSS_bracketBelowMinimum() {
        System.out.println("Running test5_calculateSSS_bracketBelowMinimum...");
        double basis = 2000.0; // SSS min is usually around 3000, so this should check minimum logic
        double expected = 80.0; // Example: expected minimum SSS (check formula in StatutoryDeductions.java)
        double actual = StatutoryDeductions.calculateSSS(basis);
        System.out.println("Input: " + basis + ", Expected: " + expected + ", Actual: " + actual);
        assertEquals(expected, actual, 0.01, "SSS calculation for below minimum should return minimum value");
    }

    @Test
    public void test6_calculateSSS_standardBracket() {
        System.out.println("Running test6_calculateSSS_standardBracket...");
        double basis = 12000.0;
        double expected = 540.0; // Example: expected SSS for this salary (adjust as per your formula)
        double actual = StatutoryDeductions.calculateSSS(basis);
        System.out.println("Input: " + basis + ", Expected: " + expected + ", Actual: " + actual);
        assertEquals(expected, actual, 0.01, "SSS calculation for standard basis should be correct");
    }

    @Test
    public void test7_calculateSSS_maxBracket() {
        System.out.println("Running test7_calculateSSS_maxBracket...");
        double basis = 30000.0;
        double expected = 800.0; // Example: expected maximum SSS value (adjust as per your formula)
        double actual = StatutoryDeductions.calculateSSS(basis);
        System.out.println("Input: " + basis + ", Expected: " + expected + ", Actual: " + actual);
        assertEquals(expected, actual, 0.01, "SSS calculation for above maximum should return max value");
    }
}
