import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import model.Employee;
import util.EmployeeTableUtil;
import javax.swing.table.DefaultTableModel;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EmployeeTableUtilTest {

    private List<Employee> employees;

    @BeforeEach
    public void setUp() {
        employees = new ArrayList<>();

        Employee emp1 = new Employee();
        emp1.setEmployeeId(1);
        emp1.setLastName("Garcia");
        emp1.setFirstName("Manuel");
        emp1.setBirthdate(java.sql.Date.valueOf("1990-02-01"));
        emp1.setStreet("123 Main St");
        emp1.setBarangay("B1");
        emp1.setCity("Quezon City");
        emp1.setProvince("Metro Manila");
        emp1.setZip("1100");
        emp1.setPhoneNumber("9000-211414");
        emp1.setSssNumber("44-4506057-3");
        emp1.setTinNumber("691295330870");
        emp1.setPhilhealthNumber("820126853951");
        emp1.setPagibigNumber("442-605-657-000");
        emp1.setStatus("Regular");
        emp1.setPosition("Chief Executive Officer");
        emp1.setImmediateSupervisor("N/A");
        emp1.setBasicSalary(90000);
        emp1.setRiceSubsidy(1500);
        emp1.setPhoneAllowance(2000);
        emp1.setClothingAllowance(1000);

        Employee emp2 = new Employee();
        emp2.setEmployeeId(2);
        emp2.setLastName("Dela Cruz");
        emp2.setFirstName("Juan");
        emp2.setBirthdate(java.sql.Date.valueOf("1992-03-05"));
        emp2.setStreet("456 Test Ave");
        emp2.setBarangay("B2");
        emp2.setCity("Manila");
        emp2.setProvince("Metro Manila");
        emp2.setZip("1200");
        emp2.setPhoneNumber("812-9999");
        emp2.setSssNumber("22-2222222-2");
        emp2.setTinNumber("123456789012");
        emp2.setPhilhealthNumber("111122223333");
        emp2.setPagibigNumber("123-123-123-123");
        emp2.setStatus("Probationary");
        emp2.setPosition("Accountant");
        emp2.setImmediateSupervisor("Garcia, Manuel");
        emp2.setBasicSalary(50000);
        emp2.setRiceSubsidy(1200);
        emp2.setPhoneAllowance(1200);
        emp2.setClothingAllowance(900);

        employees.add(emp1);
        employees.add(emp2);
    }

    @Test
    public void test1_toTableModel_conversion() {
        System.out.println("Test 1: toTableModel - Convert employees to table model");
        DefaultTableModel model = EmployeeTableUtil.toTableModel(employees);
        assertEquals(2, model.getRowCount());
        assertEquals(17, model.getColumnCount());
        assertEquals("Garcia", model.getValueAt(0, 1));
        assertEquals("Accountant", model.getValueAt(1, 11));
        System.out.println("Table rows: " + model.getRowCount() + ", columns: " + model.getColumnCount());
    }

    @Test
    public void test2_safeGetValue() {
        System.out.println("Test 2: safeGetValue - Safely get cell value");
        DefaultTableModel model = EmployeeTableUtil.toTableModel(employees);
        String val1 = EmployeeTableUtil.safeGetValue(model, 0, 1);
        String val2 = EmployeeTableUtil.safeGetValue(model, 1, 2);
        String valInvalid = EmployeeTableUtil.safeGetValue(model, 0, 99); // invalid col
        assertEquals("Garcia", val1);
        assertEquals("Juan", val2);
        assertEquals("", valInvalid);
        System.out.println("Safe value get: " + val1 + ", " + val2 + ", (invalid) -> '" + valInvalid + "'");
    }

    @Test
    public void test3_safeGetValue_null() {
        System.out.println("Test 3: safeGetValue - Null cell returns empty string");
        Employee emp3 = new Employee();
        emp3.setEmployeeId(3);
        emp3.setLastName(null);
        employees.add(emp3);
        DefaultTableModel model = EmployeeTableUtil.toTableModel(employees);
        String val = EmployeeTableUtil.safeGetValue(model, 2, 1);
        assertEquals("", val);
        System.out.println("Null cell: '" + val + "'");
    }

    
    @Test
    public void test4_toTableModel_nullsInEmployee() {
        System.out.println("Test 6: toTableModel - Employee with all null fields");
        Employee emp = new Employee();
        employees.clear();
        employees.add(emp);
        DefaultTableModel model = EmployeeTableUtil.toTableModel(employees);
        for (int c = 0; c < model.getColumnCount(); c++) {
            assertNotNull(EmployeeTableUtil.safeGetValue(model, 0, c));
        }
        System.out.println("Null fields handled as empty strings.");
    }
}
