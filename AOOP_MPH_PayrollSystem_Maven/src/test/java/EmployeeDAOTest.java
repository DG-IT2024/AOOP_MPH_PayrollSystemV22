import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;
import java.util.*;
import dao.EmployeeDAO;
import model.Employee;
import util.DBConnect;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EmployeeDAOTest {

    private static Connection conn;
    private EmployeeDAO employeeDAO;

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for EmployeeDAOTest.");
    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed after EmployeeDAOTest.");
        }
    }

    @BeforeEach
    public void setUp() {
        employeeDAO = new EmployeeDAO(conn);
    }

    @Test
    public void test1_getAllEmployees() throws Exception {
        System.out.println("Test 1: getAllEmployees - Retrieve all employees");
        List<Employee> employees = employeeDAO.getAllEmployees();
        assertNotNull(employees, "Employees list should not be null");
        assertTrue(employees.size() > 0, "There should be at least one employee in the database");
        System.out.println("Total employees found: " + employees.size());
    }

    @Test
    public void test2_getEmployeeDetailsById() throws Exception {
        System.out.println("Test 2: getEmployeeDetailsById - Retrieve employee by ID");
        int employeeId = 10001; // Change as needed based on your DB contents
        Employee emp = employeeDAO.getEmployeeDetailsById(employeeId);
        assertNotNull(emp, "Employee should exist for the given ID");
        assertEquals(employeeId, emp.getEmployeeId());
        System.out.println("Employee found: " + emp.getFirstName() + " " + emp.getLastName());
    }

    @Test
    public void test3_createEmployee() throws Exception {
        System.out.println("Test 3: createEmployee - Insert a new employee");
        Employee emp = new Employee();
        emp.setLastName("TestLastName");
        emp.setFirstName("TestFirstName");
       
        emp.setStreet("123 Test St");
        emp.setBarangay("TestBarangay");
        emp.setCity("TestCity");
        emp.setProvince("TestProvince");
        emp.setZip("9999");
        emp.setPhoneNumber("2-9999999"); // area code-local format
        emp.setSssNumber("99-9999999-9");
        emp.setPhilhealthNumber("999999999999");
        emp.setPagibigNumber("999-999-999-999");
        emp.setTinNumber("999999999999");
        emp.setStatus("Regular");
        emp.setPosition("Chief Executive Officer");
        emp.setImmediateSupervisor(""); // Or provide valid supervisor
        emp.setBasicSalary(12345.67);
        emp.setRiceSubsidy(123.0);
        emp.setPhoneAllowance(456.0);
        emp.setClothingAllowance(789.0);

        employeeDAO.createEmployee(emp);

        // Optionally, check for duplicate after insert (search by SSS)
        boolean isDuplicate = employeeDAO.isGovtIdDuplicate("99-9999999-9", "999999999999", "999999999999", "999-999-999-999");
        assertTrue(isDuplicate, "Inserted employee should now be a duplicate by government IDs");
        System.out.println("Employee creation successful and duplicate detected as expected.");
    }

    @Test
    public void test4_updateEmployee() throws Exception {
        System.out.println("Test 4: updateEmployee - Update employee data");
        // Retrieve last inserted test employee by unique SSS number (or select known ID)
        List<Employee> employees = employeeDAO.getAllEmployees();
        Employee toUpdate = null;
        for (Employee emp : employees) {
            if ("99-9999999-9".equals(emp.getSssNumber())) {
                toUpdate = emp;
                break;
            }
        }
        assertNotNull(toUpdate, "Test employee to update should exist");
        toUpdate.setLastName("UpdatedLastName");
        toUpdate.setFirstName("UpdatedFirstName");
        toUpdate.setCity("UpdatedCity");

        employeeDAO.updateEmployee(toUpdate);

        Employee updated = employeeDAO.getEmployeeDetailsById(toUpdate.getEmployeeId());
        assertEquals("UpdatedLastName", updated.getLastName());
        assertEquals("UpdatedFirstName", updated.getFirstName());
        assertEquals("UpdatedCity", updated.getCity());
        System.out.println("Employee update successful for ID: " + updated.getEmployeeId());
    }

    @Test
    public void test5_deleteEmployee() throws Exception {
        System.out.println("Test 5: deleteEmployee - Soft delete (archive) employee");
        // Retrieve test employee as above
        List<Employee> employees = employeeDAO.getAllEmployees();
        Employee toDelete = null;
        for (Employee emp : employees) {
            if ("99-9999999-9".equals(emp.getSssNumber())) {
                toDelete = emp;
                break;
            }
        }
        assertNotNull(toDelete, "Test employee to delete should exist");
        int idToDelete = toDelete.getEmployeeId();

        employeeDAO.deleteEmployee(idToDelete);

        Employee deletedEmp = employeeDAO.getEmployeeDetailsById(idToDelete);
        // Employee is not physically deleted; status should be "Inactive" (status_id = 11)
        assertNotNull(deletedEmp, "Employee record should still exist (soft delete)");
        assertEquals("Inactive", deletedEmp.getStatus(), "Employee status should be set to 'Inactive' after delete");
        System.out.println("Employee with ID " + idToDelete + " marked as Inactive.");
    }

    @Test
    public void test6_isGovtIdDuplicate() {
        System.out.println("Test 6: isGovtIdDuplicate - Check duplicate government IDs");
        // Use SSS/TIN/Philhealth/Pagibig values that exist in DB
        boolean duplicate = employeeDAO.isGovtIdDuplicate("44-4506057-3", "691295330870", "820126853951", "442-605-657-000");
        assertTrue(duplicate, "Should return true for existing government IDs");
        System.out.println("Duplicate check returned: " + duplicate);
    }
}
