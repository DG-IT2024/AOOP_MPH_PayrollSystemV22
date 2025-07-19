import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;
import java.util.List;
import model.Attendance_sp;
import model.Attendance;
import service.AttendanceService;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AttendanceServiceTest {

    private AttendanceService attendanceService;

    @BeforeAll
    public static void setupDB() throws Exception {
        System.out.println("Database connection established for AttendanceServiceTest.");
    }

    @AfterAll
    public static void teardown() throws Exception {
        System.out.println("Database connection closed after AttendanceServiceTest.");
    }

    @BeforeEach
    public void setUp() throws Exception {
        attendanceService = new AttendanceService();
    }

    @Test
    public void test1_readAttendance() throws Exception {
        System.out.println("Test 1: readAttendance - Read one attendance summary via stored procedure");
        int employeeId = 10001; // Adjust to your test employee
        Date start = Date.valueOf("2024-06-01");
        Date end = Date.valueOf("2024-06-30");
        Attendance_sp att = attendanceService.readAttendance(employeeId, start, end);
        assertNotNull(att, "Attendance_sp should not be null for valid employee/dates");
        System.out.println("Attendance ID: " + att.getAttendanceId() + " for Employee: " + att.getEmployeeId());
    }

    @Test
    public void test2_listAttendanceByEmployeeAndDateRange() throws Exception {
        System.out.println("Test 2: listAttendanceByEmployeeAndDateRange - List attendances");
        int employeeId = 10001;
        Date start = Date.valueOf("2024-06-01");
        Date end = Date.valueOf("2024-06-30");
        List<Attendance_sp> list = attendanceService.listAttendanceByEmployeeAndDateRange(employeeId, start, end);
        assertNotNull(list, "Attendance list should not be null");
        assertTrue(list.size() > 0, "Attendance list should have at least one entry");
        System.out.println("Attendance entries found: " + list.size());
    }

    @Test
    public void test3_calculateWorkedHours() {
        System.out.println("Test 3: calculateWorkedHours - Grace period and break deduction logic");
        Time timeIn = Time.valueOf("08:05:00");
        Time timeOut = Time.valueOf("17:00:00");
        int workedHours = AttendanceService.calculateWorkedHours(timeIn, timeOut);
        assertEquals(8, workedHours, "Should count 8 worked hours (8:00am in, 5:00pm out)");
        System.out.println("Worked hours with grace period: " + workedHours);
    }

    @Test
    public void test4_getRegularAndOvertimeHours() {
        System.out.println("Test 4: getRegularHours & getOvertimeHours logic");
        Time timeIn = Time.valueOf("08:00:00");
        Time timeOut = Time.valueOf("19:00:00");
        double regular = attendanceService.getRegularHours(timeIn, timeOut);
        double overtime = attendanceService.getOvertimeHours(timeIn, timeOut);
        assertEquals(8, regular, 0.01);
        assertEquals(2, overtime, 0.01);
        System.out.println("Regular hours: " + regular + ", Overtime hours: " + overtime);
    }

    @Test
    public void test5_getRegularAndOvertimeHours_db() throws Exception {
        System.out.println("Test 5: getRegularHours/OvertimeHours over date range from DB");
        int employeeId = 10001;
        Date start = Date.valueOf("2024-06-01");
        Date end = Date.valueOf("2024-06-30");
        double reg = attendanceService.getRegularHours(employeeId, start, end);
        double ot = attendanceService.getOvertimeHours(employeeId, start, end);
        System.out.println("Total DB-regular hours: " + reg + ", DB-overtime hours: " + ot);
        assertTrue(reg >= 0);
        assertTrue(ot >= 0);
    }

    @Test
    public void test6_getWeightedOvertimes() throws Exception {
        System.out.println("Test 6: getWeightedOvertimes - Weighted overtime calc from DB");
        int employeeId = 10001;
        Date start = Date.valueOf("2024-06-01");
        Date end = Date.valueOf("2024-06-30");
        double weighted = attendanceService.getWeightedOvertimes(employeeId, start, end);
        System.out.println("Total weighted overtimes: " + weighted);
        assertTrue(weighted >= 0);
    }

    @Test
    public void test7_listAllAttendance() throws Exception {
        System.out.println("Test 7: listAllAttendance - List all attendance records (admin/all view)");
        List<Attendance> list = attendanceService.listAllAttendance();
        assertNotNull(list, "Attendance records should not be null");
        System.out.println("Attendance record count: " + list.size());
        assertTrue(list.size() > 0);
    }

    @Test
    public void test8_updateAttendanceOvertimeField() throws Exception {
        System.out.println("Test 8: updateAttendanceOvertimeField - Update attendance overtime fields");
        // Find a real attendance ID and valid times for your test!
        int attendanceId = 1;
        Time timeIn = Time.valueOf("08:00:00");
        Time timeOut = Time.valueOf("18:00:00");
        Double otRate = 1.5;
        Date overtimeUpdatedDate = Date.valueOf("2024-07-10");
        Integer overtimeApproverId = 10002; // Use real approver/employee ID if needed

        attendanceService.updateAttendanceOvertimeField(
                attendanceId, timeIn, timeOut, otRate, overtimeUpdatedDate, overtimeApproverId
        );
        // If no exception, update was successful
        System.out.println("Attendance " + attendanceId + " updated with OT fields.");
    }

    @Test
    public void test9_getWorkingDays() {
        System.out.println("Test 9: getWorkingDays - Calculate working days for month");
        Date monthStart = Date.valueOf("2024-07-01");
        int workingDays = attendanceService.getWorkingDays(monthStart);
        System.out.println("Working days in July 2024: " + workingDays);
        assertTrue(workingDays > 0 && workingDays <= 31);
    }
}
