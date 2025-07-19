
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTextField;
import java.awt.event.KeyEvent;
import model.Employee;
import util.DBConnect;
import util.InputValidator;

public class InputValidatorTest {

    private static Connection conn;

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for InputValidatorTest.");
    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed after InputValidatorTest.");
        }
    }

    @Test
    public void test1_isOnlyDigit_trueForDigit() {
        System.out.println("test1_isOnlyDigit_trueForDigit...");
        assertTrue(InputValidator.isOnlyDigit('5'));
    }

    @Test
    public void test2_isOnlyDigit_falseForNonDigit() {
        System.out.println("test2_isOnlyDigit_falseForNonDigit...");
        assertFalse(InputValidator.isOnlyDigit('A'));
    }

    @Test
    public void test3_isOnlyDigitWithMaxLength_true() {
        System.out.println("test3_isOnlyDigitWithMaxLength_true...");
        assertTrue(InputValidator.isOnlyDigitWithMaxLength('2', "123", 5));
        assertTrue(InputValidator.isOnlyDigitWithMaxLength('\b', "12345", 5));
    }

    @Test
    public void test4_isOnlyDigitWithMaxLength_false() {
        System.out.println("test4_isOnlyDigitWithMaxLength_false...");
        assertFalse(InputValidator.isOnlyDigitWithMaxLength('2', "12345", 5));
        assertFalse(InputValidator.isOnlyDigitWithMaxLength('A', "123", 5));
    }

    @Test
    public void test5_isValidDateChar() {
        System.out.println("test5_isValidDateChar...");
        assertTrue(InputValidator.isValidDateChar('2'));
        assertTrue(InputValidator.isValidDateChar('-'));
        assertFalse(InputValidator.isValidDateChar('A'));
    }

    @Test
    public void test6_isOnlyDigitOrDash() {
        System.out.println("test6_isOnlyDigitOrDash...");
        assertTrue(InputValidator.isOnlyDigitOrDash('5'));
        assertTrue(InputValidator.isOnlyDigitOrDash('-'));
        assertFalse(InputValidator.isOnlyDigitOrDash('A'));
    }

    @Test
    public void test7_isOnlyDigitOrDashWithMaxLength_true() {
        System.out.println("test7_isOnlyDigitOrDashWithMaxLength_true...");
        assertTrue(InputValidator.isOnlyDigitOrDashWithMaxLength('-', "123", 5));
        assertTrue(InputValidator.isOnlyDigitOrDashWithMaxLength('2', "123", 5));
    }

    @Test
    public void test8_isOnlyDigitOrDashWithMaxLength_false() {
        System.out.println("test8_isOnlyDigitOrDashWithMaxLength_false...");
        assertFalse(InputValidator.isOnlyDigitOrDashWithMaxLength('-', "12345", 5));
        assertFalse(InputValidator.isOnlyDigitOrDashWithMaxLength('A', "123", 5));
    }

    @Test
    public void test9_isOnlyAlphabet() {
        System.out.println("test9_isOnlyAlphabet...");
        assertTrue(InputValidator.isOnlyAlphabet('A'));
        assertFalse(InputValidator.isOnlyAlphabet('1'));
    }

    @Test
    public void test10_isOnlyAlphabetWithMaxLength() {
        System.out.println("test10_isOnlyAlphabetWithMaxLength...");
        assertTrue(InputValidator.isOnlyAlphabetWithMaxLength('B', "abc", 5));
        assertFalse(InputValidator.isOnlyAlphabetWithMaxLength('B', "abcde", 5));
        assertFalse(InputValidator.isOnlyAlphabetWithMaxLength('1', "abc", 5));
    }

    @Test
    public void test11_isWithinAllowedLength() {
        System.out.println("test11_isWithinAllowedLength...");
        assertTrue(InputValidator.isWithinAllowedLength('a', "ab", 3));
        assertFalse(InputValidator.isWithinAllowedLength('a', "abc", 3));
        assertTrue(InputValidator.isWithinAllowedLength('\b', "abc", 3));
    }

    @Test
    public void test12_isAlphanumeric() {
        System.out.println("test12_isAlphanumeric...");
        assertTrue(InputValidator.isAlphanumeric("abc123", 10));
        assertFalse(InputValidator.isAlphanumeric("abc-123", 10));
        assertFalse(InputValidator.isAlphanumeric("abc123456789", 10));
        assertFalse(InputValidator.isAlphanumeric(null, 10));
    }

    @Test
    public void test13_validateEmployee_valid() throws SQLException {
        System.out.println("test13_validateEmployee_valid...");
        Employee emp = new Employee();
        emp.setFirstName("Juan");
        emp.setLastName("Dela Cruz");
        emp.setStatus("Active");
        emp.setSssNumber("SSS123456");
        emp.setPhilhealthNumber("PH123456");
        emp.setPagibigNumber("PG123456");
        emp.setTinNumber("TIN123456");
        emp.setBasicSalary(15000);
        emp.setRiceSubsidy(1000);
        emp.setPhoneAllowance(500);
        emp.setClothingAllowance(800);
        emp.setPhoneNumber("0917-1234567");
        emp.setZip("1234");
        emp.setBirthdate(new java.util.Date());
        assertDoesNotThrow(() -> InputValidator.validateEmployee(emp));
    }

    @Test
    public void test14_validateEmployee_invalidFirstName() {
        System.out.println("test14_validateEmployee_invalidFirstName...");
        Employee emp = new Employee();
        emp.setFirstName("Juan123");
        emp.setLastName("Cruz");
        emp.setStatus("Active");
        emp.setSssNumber("SSS123456");
        emp.setPhilhealthNumber("PH123456");
        emp.setPagibigNumber("PG123456");
        emp.setTinNumber("TIN123456");
        emp.setBasicSalary(15000);
        emp.setRiceSubsidy(1000);
        emp.setPhoneAllowance(500);
        emp.setClothingAllowance(800);
        emp.setPhoneNumber("0917-1234567");
        emp.setZip("1234");
        emp.setBirthdate(new java.util.Date());
        Exception ex = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateEmployee(emp));
        System.out.println("Exception: " + ex.getMessage());
    }

    @Test
    public void test15_validateEmployee_invalidZip() {
        System.out.println("test15_validateEmployee_invalidZip...");
        Employee emp = new Employee();
        emp.setFirstName("Juan");
        emp.setLastName("Cruz");
        emp.setStatus("Active");
        emp.setSssNumber("SSS123456");
        emp.setPhilhealthNumber("PH123456");
        emp.setPagibigNumber("PG123456");
        emp.setTinNumber("TIN123456");
        emp.setBasicSalary(15000);
        emp.setRiceSubsidy(1000);
        emp.setPhoneAllowance(500);
        emp.setClothingAllowance(800);
        emp.setPhoneNumber("0917-1234567");
        emp.setZip("12");
        emp.setBirthdate(new java.util.Date());
        Exception ex = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateEmployee(emp));
        System.out.println("Exception: " + ex.getMessage());
    }

    @Test
    public void test16_validateEmployee_negativeSalary() {
        System.out.println("test16_validateEmployee_negativeSalary...");
        Employee emp = new Employee();
        emp.setFirstName("Juan");
        emp.setLastName("Cruz");
        emp.setStatus("Active");
        emp.setSssNumber("SSS123456");
        emp.setPhilhealthNumber("PH123456");
        emp.setPagibigNumber("PG123456");
        emp.setTinNumber("TIN123456");
        emp.setBasicSalary(-1);
        emp.setRiceSubsidy(1000);
        emp.setPhoneAllowance(500);
        emp.setClothingAllowance(800);
        emp.setPhoneNumber("0917-1234567");
        emp.setZip("1234");
        emp.setBirthdate(new java.util.Date());
        Exception ex = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateEmployee(emp));
        System.out.println("Exception: " + ex.getMessage());
    }
}
