
import org.junit.jupiter.api.*;
import service.PayrollService;
import util.PayrollUtil;

import java.sql.*;


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

    
    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed after LeaveTest.");
        }
    }
}
