
import org.junit.jupiter.api.*;


import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.Employee;
import service.EmployeeService;
import util.DBConnect;
import util.DateUtil;

public class EmployeeServiceTest1 {

    private static Connection conn;
    private EmployeeService service;

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for EmployeeServiceTest.");
    }

    @BeforeEach
    public void setUp() throws Exception {
        service = new EmployeeService();
    }

    //Add Employee With Duplicate Government IDs
      @Test
    public void testCase06_AddEmployeeWithDuplicateGovernmentIds() throws Exception {
        System.out.println("== CASE 6: Add Employee With Duplicate Government IDs ==");

        // First employee
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
        emp.setPhilhealthNumber("61234567");
        emp.setPagibigNumber("1234567");
        emp.setTinNumber("1234567");
        emp.setStatus("Regular");
        emp.setPosition("Account Rank and File");
        emp.setImmediateSupervisor("Garcia Manuel III");
        emp.setBasicSalary(30000);
        emp.setRiceSubsidy(2000);
        emp.setPhoneAllowance(1000);
        emp.setClothingAllowance(500);

        service.addEmployee(emp);

        // Second employee with same government IDs (should fail)
        Employee emp1 = new Employee();
        emp1.setLastName("Doe");
        emp1.setFirstName("Jane");
        emp1.setBirthdate(DateUtil.convertToDate("1990-01-01"));
        emp1.setStreet("123 Main St");
        emp1.setBarangay("Barangay Uno");
        emp1.setCity("Makati");
        emp1.setProvince("Metro Manila");
        emp1.setZip("1200");
        emp1.setPhoneNumber("09171234");
        emp1.setSssNumber("612345676");
        emp1.setPhilhealthNumber("61234567");
        emp1.setPagibigNumber("1234567");
        emp1.setTinNumber("1234567");
        emp1.setStatus("Regular");
        emp1.setPosition("Account Rank and File");
        emp1.setImmediateSupervisor("Garcia Manuel III");
        emp1.setBasicSalary(30000);
        emp1.setRiceSubsidy(2000);
        emp1.setPhoneAllowance(1000);
        emp1.setClothingAllowance(500);

        // Use assertThrows to verify the exception
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.addEmployee(emp1),
                "Should throw exception for duplicate government IDs"
        );

        // Optionally check the exception message
        assertTrue(
                exception.getMessage().toLowerCase().contains("duplicate"),
                "Exception message should mention duplicate"
        );
        System.out.println("Expected exception caught: " + exception.getMessage());
    }
//     7. Null and Edge Cases
//    @Test
//    public void testCase07_NullAndEdgeCases() throws Exception {
//        System.out.println("== CASE 7: Null and Edge Cases ==");
//        Employee emp = new Employee();
//        emp.setLastName("Nulls");
//        emp.setFirstName(null);
//        emp.setBirthdate(null);
//        emp.setStatus("Active");
//        emp.setSssNumber("NULLCASE1");
//        emp.setPhilhealthNumber("NULLCASE1");
//        emp.setPagibigNumber("NULLCASE1");
//        emp.setTinNumber("NULLCASE1");
//        emp.setBasicSalary(-9999999);
//        emp.setRiceSubsidy(0);
//        emp.setPhoneAllowance(0);
//        emp.setClothingAllowance(0);
//
//        try {
//            service.addEmployee(emp);
//            System.out.println("Added employee with null/negative values (check if allowed by business rules).");
//            Employee added = service.listAllEmployees().get(service.listAllEmployees().size() - 1);
//            assertEquals("Nulls", added.getLastName());
//            assertTrue(added.getBasicSalary() <= 0);
//        } catch (Exception e) {
//            System.out.println("Exception as expected: " + e.getMessage());
//            assertTrue(true);
//        }
//    }
//     16. Unique Constraint Enforcement
//    @Test
//    public void testCase16_UniqueConstraintEnforcement() throws Exception {
//        System.out.println("== CASE 16: Unique Constraint Enforcement ==");
//        Employee emp1 = new Employee();
//        emp1.setLastName("UniqA");
//        emp1.setFirstName("UniqA");
//        emp1.setStatus("Active");
//        emp1.setSssNumber("UNIQ1");
//        emp1.setPhilhealthNumber("UNIQ1");
//        emp1.setPagibigNumber("UNIQ1");
//        emp1.setTinNumber("UNIQ1");
//        emp1.setBasicSalary(9000);
//        emp1.setRiceSubsidy(0);
//        emp1.setPhoneAllowance(0);
//        emp1.setClothingAllowance(0);
//        service.addEmployee(emp1);
//
//        Employee emp2 = new Employee();
//        emp2.setLastName("UniqB");
//        emp2.setFirstName("UniqB");
//        emp2.setStatus("Active");
//        emp2.setSssNumber("UNIQ1");
//        emp2.setPhilhealthNumber("UNIQ1");
//        emp2.setPagibigNumber("UNIQ1");
//        emp2.setTinNumber("UNIQ1");
//        emp2.setBasicSalary(9500);
//        emp2.setRiceSubsidy(0);
//        emp2.setPhoneAllowance(0);
//        emp2.setClothingAllowance(0);
//
//        try {
//            service.addEmployee(emp2);
//            Assert.fail("Should have failed due to unique constraint.");
//        } catch (Exception e) {
//            System.out.println("Expected unique constraint violation: " + e.getMessage());
//            assertTrue(e.getMessage().toLowerCase().contains("duplicate"));
//        }
//    }
//    // 17. SQL Injection Attempt
//    @Test
//    public void testCase17_SQLInjectionAttempt() throws Exception {
//        System.out.println("== CASE 17: SQL Injection Attempt ==");
//        Employee emp = new Employee();
//        emp.setLastName("Doe'; DROP TABLE employee; --");
//        emp.setFirstName("Injection");
//        emp.setStatus("Active");
//        emp.setSssNumber("SQLINJ1");
//        emp.setPhilhealthNumber("SQLINJ1");
//        emp.setPagibigNumber("SQLINJ1");
//        emp.setTinNumber("SQLINJ1");
//        emp.setBasicSalary(7000);
//        emp.setRiceSubsidy(0);
//        emp.setPhoneAllowance(0);
//        emp.setClothingAllowance(0);
//
//        service.addEmployee(emp);
//        Employee added = service.listAllEmployees().get(service.listAllEmployees().size() - 1);
//        assertTrue(added.getLastName().contains("DROP TABLE") || added.getLastName().contains("Doe"));
//    }
//     23. Mass Insert and Query
}
