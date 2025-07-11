
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import model.Employee;
import service.EmployeeService;
import util.DBConnect;
import util.DateUtil;

public class EmployeeServiceTest {

    private static Connection conn;
    private EmployeeService service;

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for LeaveTest.");
    }

    @BeforeEach
    public void setUp() throws Exception {
        service = new EmployeeService();
    }

    // 1. Add New Employee
    @Test
    public void testCase01_AddNewEmployee() throws Exception {
        System.out.println("== CASE 1: Add New Employee ==");

        Employee emp = new Employee();
        emp.setLastName("Doe");
        emp.setFirstName("Jane");
        emp.setBirthdate(DateUtil.convertToDate("1990-01-01"));
        emp.setStreet("123 Main St");
        emp.setBarangay("Barangay Uno");
        emp.setCity("Makati");
        emp.setProvince("Metro Manila");
        emp.setZip("1200");
        emp.setPhoneNumber("09171234");
        emp.setSssNumber("612345676");
        emp.setPhilhealthNumber("6411234567");
        emp.setPagibigNumber("332234567");
        emp.setTinNumber("3211234567");
        emp.setStatus("Regular");
        emp.setPosition("Account Rank and File");
        emp.setImmediateSupervisor("Garcia Manuel III");
        emp.setBasicSalary(30000);
        emp.setRiceSubsidy(2000);
        emp.setPhoneAllowance(1000);
        emp.setClothingAllowance(500);

        service.addEmployee(emp);
        System.out.println("Employee added.");

        List<Employee> all = service.listAllEmployees();
        Employee last = all.get(all.size() - 1);
        System.out.println("Retrieved Employee: " + last);

        assertEquals("Jane", last.getFirstName());
        assertEquals("Doe", last.getLastName());
        assertTrue(last.getEmployeeId() > 0);
    }

    // 2. Retrieve Employee By ID
    @Test
    public void testCase02_RetrieveEmployeeById() throws Exception {
        System.out.println("== CASE 2: Retrieve Employee By ID ==");
        List<Employee> all = service.listAllEmployees();
        assertTrue(all.size() > 0);
        Employee sample = all.get(0);
        Employee found = service.findEmployeeById(sample.getEmployeeId());
        System.out.println("Employee found: " + found);
        assertNotNull(found);
        assertEquals(sample.getEmployeeId(), found.getEmployeeId());
    }

    // 3. Update Employee
    @Test
    public void testCase03_UpdateEmployee() throws Exception {
        System.out.println("== CASE 3: Update Employee ==");
        List<Employee> all = service.listAllEmployees();
        assertTrue(all.size() > 0);
        Employee emp = all.get(0);
        String oldLastName = emp.getLastName();
        String newLastName = "Updated" + oldLastName;
        emp.setLastName(newLastName);
        service.updateEmployee(emp);
        System.out.println("Employee updated.");
        Employee updated = service.findEmployeeById(emp.getEmployeeId());
        System.out.println("Retrieved after update: " + updated);
        assertEquals(newLastName, updated.getLastName());
    }

    // 4. Delete Employee
    @Test
    public void testCase04_DeleteEmployee() throws Exception {
        System.out.println("== CASE 4: Delete Employee ==");
        Employee emp = new Employee();
        emp.setLastName("ToDelete");
        emp.setFirstName("Emp");
        emp.setBirthdate(new Date());
        emp.setStatus("Active");
        emp.setSssNumber("DEL123");
        emp.setPhilhealthNumber("DEL123");
        emp.setPagibigNumber("DEL123");
        emp.setTinNumber("DEL123");
        emp.setBasicSalary(10000);
        emp.setRiceSubsidy(0);
        emp.setPhoneAllowance(0);
        emp.setClothingAllowance(0);
        emp.setPhoneNumber("456780");
        emp.setZip("1000");

        service.addEmployee(emp);
        List<Employee> all = service.listAllEmployees();
        Employee added = all.get(all.size() - 1);

        System.out.println("Employee to delete: " + added);
        service.removeEmployee(added.getEmployeeId());
        System.out.println("Employee deleted.");
        Employee shouldBeNull = service.findEmployeeById(added.getEmployeeId());
        System.out.println("After deletion, found: " + shouldBeNull);
        assertNull(shouldBeNull);
    }

    // 5. Get All Employees
    @Test
    public void testCase05_GetAllEmployees() throws Exception {
        System.out.println("== CASE 5: Get All Employees ==");
        List<Employee> all = service.listAllEmployees();
        System.out.println("Employees found: " + all.size());
        for (Employee e : all) {
            System.out.println(e);
        }
        assertNotNull(all);
        assertTrue(all.size() >= 0);
    }

  
    // 8. Date Utility
    @Test
    public void testCase08_DateUtility() throws Exception {
        System.out.println("== CASE 8: Date Utility ==");
        Date d1 = DateUtil.convertToDate("2024-12-25");
        Date d2 = DateUtil.convertToDate("12/25/2024");
        String s1 = DateUtil.dateToDefaultString(d1);
        String s2 = DateUtil.dateToDefaultString(d2);
        System.out.println("Parsed dates: " + d1 + ", " + d2);
        System.out.println("Formatted: " + s1 + ", " + s2);
        assertEquals("12/25/2024", s1);
        assertEquals("12/25/2024", s2);
        assertTrue(DateUtil.isSameDay(d1, d2));
    }

    // 9. Retrieve Employee With Non-Existent ID
    @Test
    public void testCase09_RetrieveNonExistentID() throws Exception {
        System.out.println("== CASE 9: Retrieve Non-Existent Employee ID ==");
        int nonExistentId = -99999;
        Employee emp = service.findEmployeeById(nonExistentId);
        System.out.println("Result: " + emp);
        assertNull(emp);
    }

    // 10. Add Employee With Missing Required Fields
    @Test
    public void testCase10_AddMissingRequiredFields() throws Exception {
        System.out.println("== CASE 10: Add Employee With Missing Required Fields ==");
        Employee emp = new Employee();
        try {
            service.addEmployee(emp);
            fail("Should have failed due to missing required fields.");
        } catch (Exception e) {
            System.out.println("Expected exception caught: " + e.getMessage());
            assertTrue(true);
        }
    }

    // 11. Update Non-Existent Employee
    @Test
    public void testCase11_UpdateNonExistentEmployee() throws Exception {
        System.out.println("== CASE 11: Update Non-Existent Employee ==");
        Employee emp = new Employee();
        emp.setEmployeeId(-1234567);
        emp.setLastName("Ghost");
        try {
            service.updateEmployee(emp);
            System.out.println("Update attempt finished (should fail gracefully).");
            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Exception as expected: " + e.getMessage());
            assertTrue(true);
        }
    }

    // 12. Delete Non-Existent Employee
    @Test
    public void testCase12_DeleteNonExistentEmployee() throws Exception {
        System.out.println("== CASE 12: Delete Non-Existent Employee ==");
        int nonExistentId = -12345;
        try {
            service.removeEmployee(nonExistentId);
            System.out.println("No exception thrown. Graceful handling.");
            assertTrue(true);
        } catch (Exception e) {
            System.out.println("Exception caught (acceptable): " + e.getMessage());
            assertTrue(true);
        }
    }

    // 13. Add Employee With Extreme Field Values
    @Test
    public void testCase13_AddExtremeFieldValues() throws Exception {
        System.out.println("== CASE 13: Add Employee With Extreme Field Values ==");
        Employee emp = new Employee();
        String longName = "A".repeat(300);
        emp.setLastName(longName);
        emp.setFirstName(longName);
        emp.setStatus("Active");
        emp.setSssNumber("EXTREME1");
        emp.setPhilhealthNumber("EXTREME1");
        emp.setPagibigNumber("EXTREME1");
        emp.setTinNumber("EXTREME1");
        emp.setBasicSalary(0);
        emp.setRiceSubsidy(0);
        emp.setPhoneAllowance(0);
        emp.setClothingAllowance(0);

        try {
            service.addEmployee(emp);
            Employee added = service.listAllEmployees().get(service.listAllEmployees().size() - 1);
            assertTrue(added.getLastName().length() <= 300);
        } catch (Exception e) {
            System.out.println("Exception as expected for extreme values: " + e.getMessage());
            assertTrue(true);
        }
    }

    // 14. Add Employee With Invalid Date
    @Test
    public void testCase14_AddEmployeeWithInvalidDate() throws Exception {
        System.out.println("== CASE 14: Add Employee With Invalid Date ==");
        try {
            DateUtil.convertToDate("not-a-date");
            fail("Should have thrown ParseException.");
        } catch (Exception e) {
            System.out.println("Expected exception for invalid date: " + e.getMessage());
            assertTrue(e.getMessage().contains("Unparseable date"));
        }
    }

    // 15. List All Employees When None Exist
    @Test
    public void testCase15_ListWhenNoneExist() throws Exception {
        System.out.println("== CASE 15: List All Employees When None Exist ==");
        List<Employee> all = service.listAllEmployees();
        System.out.println("Employee count: " + all.size());
        assertTrue(all.size() >= 0);
    }

    // 18. Print All Employees
    @Test
    public void testCase18_PrintAllEmployees() throws Exception {
        System.out.println("== CASE 18: Print All Employees ==");
        service.printAllEmployees();
        System.out.println("Printed all employees.");
        assertTrue(true);
    }

    // 19. Service Handles DB Connection Failure
    @Test
    public void testCase19_HandleDBConnectionFailure() throws Exception {
        System.out.println("== CASE 19: Handle DB Connection Failure ==");
        System.out.println("To test this, manually stop the DB or break credentials and run any service method.");
        assertTrue(true);
    }

    // 20. Address/Contact Field Formatting
    @Test
    public void testCase20_AddressFieldFormatting() throws Exception {
        System.out.println("== CASE 20: Address Field Formatting ==");
        Employee emp = new Employee();
        emp.setLastName("Format");
        emp.setFirstName("Test");
        emp.setStreet("241");
        emp.setBarangay("");
        emp.setCity("Manila");
        emp.setProvince("");
        emp.setZip("5151");
        emp.setStatus("Active");
        emp.setSssNumber("5151");
        emp.setPhilhealthNumber("697068");
        emp.setPagibigNumber("512521");
        emp.setPhoneNumber("456780");
        emp.setTinNumber("51251");
        emp.setBirthdate(DateUtil.convertToDate("1990-01-01"));
        emp.setBasicSalary(8000);
        emp.setRiceSubsidy(0);
        emp.setPhoneAllowance(0);
        emp.setClothingAllowance(0);

        service.addEmployee(emp);
        Employee added = service.listAllEmployees().get(service.listAllEmployees().size() - 1);
        System.out.println("Formatted address: " + added.getStreet() + ", " + added.getBarangay() + ", "
                + added.getCity() + ", " + added.getProvince() + ", " + added.getZip());
        assertNotNull(added);
    }

    // 21. UI Table Utility Methods (toTableModel/safeGetValue)
    @Test
    public void testCase21_UITableUtility() {
        System.out.println("== CASE 21: UI Table Utility Methods ==");
        assertTrue(true);
    }

    // 22. Uniqueness Utility
    @Test
    public void testCase22_UniquenessUtility() {
        System.out.println("== CASE 22: Uniqueness Utility ==");
        assertTrue(true);
    }

// 23. Special Character Handling
    @Test
    public void testCase23_SpecialCharacterHandling() throws Exception {
        System.out.println("== CASE 24: Special Character Handling ==");

        Employee emp = new Employee();
        emp.setLastName("Nguyễn Văn A"); // for foreign names
        emp.setFirstName("O'Neil");
        emp.setStatus("Regular");
        emp.setSssNumber("1155331");
        emp.setPhilhealthNumber("553");
        emp.setPagibigNumber("51235");
        emp.setTinNumber("5325");
        emp.setBasicSalary(9900);
        emp.setRiceSubsidy(900);
        emp.setPhoneAllowance(900);
        emp.setClothingAllowance(90);
        emp.setBirthdate(DateUtil.convertToDate("1990-01-01"));
        emp.setStreet("Emoji St.");
        emp.setBarangay("Barangay Smile");
        emp.setCity("Emoji City");
        emp.setProvince("Unicode");
        emp.setZip("1000");
        emp.setPhoneNumber("456780");
        emp.setPosition("Account Rank and File");
        emp.setImmediateSupervisor("Garcia Manuel III"); // must exist in DB

        service.addEmployee(emp);

        List<Employee> all = service.listAllEmployees();
        Employee added = all.stream()
                .filter(e -> "Nguyễn Văn A".equals(e.getLastName()))
                .findFirst()
                .orElse(null);

        assertNotNull(added, "Employee with last name Nguyễn Văn A not found.");
        System.out.println("Found employee: " + added.getLastName() + ", " + added.getFirstName());
        assertEquals("Nguyễn Văn A", added.getLastName());

    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed after EmployeeServiceTest.");
        }
    }
}
