
import dao.DeductionRateDao;
import dao.DeductionRateDaoImpl;
import model.DeductionRate;
import org.junit.jupiter.api.*;
import util.DBConnect;

import java.sql.Connection;
import java.util.List;

public class DeductionRateDaoTest {

    private static Connection conn;
    private DeductionRateDao dao;

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for DeductionRateDaoTest.");
    }

    @BeforeEach
    public void initDao() {
        dao = new DeductionRateDaoImpl(conn);
    }

    @Test
    public void testCase1_getById_Valid() throws Exception {
        DeductionRate rate = dao.getById(7);
        System.out.println("Test Case 1 - getById(1): " + (rate != null ? rate.getAmount() : "null"));
        Assertions.assertNotNull(rate);
        Assertions.assertEquals(150, rate.getAmount());
    }

    @Test
    public void testCase2_getAll_NotEmpty() throws Exception {
        List<DeductionRate> rates = dao.getAll();
        System.out.println("Test Case 2 - getAll(): total rates = " + rates.size());
        Assertions.assertTrue(rates.size() >= 25); // adjust if more exist
    }

    @Test
    public void testCase3_getByType_PhilHealth() throws Exception {
        List<DeductionRate> list = dao.getByType("PhilHealth");
        System.out.println("Test Case 3 - getByType('PhilHealth'): " + list.size());
        Assertions.assertEquals(3, list.size());
    }

    @Test
    public void testCase4_findMatchingRate_PhilHealth_5000() throws Exception {
        DeductionRate rate = dao.findMatchingRate("PhilHealth", 5000);
        System.out.println("Test Case 4 - PhilHealth @ 5000: " + (rate != null ? rate.getAmount() : "null"));
        Assertions.assertNotNull(rate);
        Assertions.assertEquals(150.00, rate.getAmount());
    }

    @Test
    public void testCase5_findMatchingRate_PhilHealth_30000() throws Exception {
        DeductionRate rate = dao.findMatchingRate("PhilHealth", 30000);
        double expected = Math.round(30000 * 0.015 * 100.0) / 100.0;
        System.out.println("Test Case 5 - PhilHealth @ 30000: " + rate.getDeductionRate());
        Assertions.assertNotNull(rate);
        Assertions.assertEquals(1.50, rate.getDeductionRate());
    }

    @Test
    public void testCase6_findMatchingRate_PhilHealth_60000() throws Exception {
        DeductionRate rate = dao.findMatchingRate("PhilHealth", 60000);
        System.out.println("Test Case 6 - PhilHealth @ 60000: " + rate.getAmount());
        Assertions.assertNotNull(rate);
        Assertions.assertEquals(900.00, rate.getAmount()); // capped
    }

    @Test
    public void testCase7_findMatchingRate_SSS_5000() throws Exception {
        DeductionRate rate = dao.findMatchingRate("SSS", 5000);
        System.out.println("Test Case 7 - SSS @ 5000: " + rate.getAmount());
        Assertions.assertNotNull(rate);
        Assertions.assertEquals(225.00, rate.getAmount());
    }

    @Test
    public void testCase8_findMatchingRate_PagIbig_1400() throws Exception {
        DeductionRate rate = dao.findMatchingRate("Pag-IBIG", 1400);
        System.out.println("Test Case 8 - Pag-IBIG @ 1400: " + rate.getDeductionRate());
        Assertions.assertNotNull(rate);
        Assertions.assertEquals(1.00, rate.getDeductionRate());
    }

    @Test
    public void testCase9_findMatchingRate_PagIbig_1600() throws Exception {
        DeductionRate rate = dao.findMatchingRate("Pag-IBIG", 1600);
        System.out.println("Test Case 9 - Pag-IBIG @ 1600: " + rate.getDeductionRate());
        Assertions.assertNotNull(rate);
        Assertions.assertEquals(2.00, rate.getDeductionRate());
    }

    @Test
    public void testCase10_findMatchingRate_WithholdingTax_20000() throws Exception {
        DeductionRate rate = dao.findMatchingRate("Withholding Tax", 20000);
        System.out.println("Test Case 10 - WHT @ 20000: " + rate.getDeductionRate());
        Assertions.assertNotNull(rate);
        Assertions.assertEquals(0.00, rate.getDeductionRate());
        Assertions.assertEquals(0.00, rate.getAmount());
    }

    @Test
    public void testCase11_findMatchingRate_WithholdingTax_30000() throws Exception {
        DeductionRate rate = dao.findMatchingRate("Withholding Tax", 30000);
        System.out.println("Test Case 11 - WHT @ 30000: " + rate.getDeductionRate());
        Assertions.assertNotNull(rate);
        Assertions.assertEquals(20.00, rate.getDeductionRate());
    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed for DeductionRateDaoTest.");
        }
    }
}
