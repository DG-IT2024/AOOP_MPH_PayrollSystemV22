
import dao.AttendanceDAO;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.*;
import java.util.List;

import model.Attendance;
import model.Attendance_sp;
import util.DBConnect;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AttendanceDAOTest {

    private static Connection conn;
    private AttendanceDAO attendanceDAO;

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for AttendanceDAOTest.");
    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed after AttendanceDAOTest.");
        }
    }

    @BeforeEach
    public void setup() {
        attendanceDAO = new AttendanceDAO(conn);
        System.out.println("AttendanceDAO instance created.");
    }

    @Test
    public void test1_AddAndGetAttendance() throws Exception {
        System.out.println("Running test1_AddAndGetAttendance...");
        Attendance att = new Attendance();
        att.setEmployeeId(1); // Make sure employee with ID 1 exists in your test DB
        att.setDate(new java.sql.Date(System.currentTimeMillis()));
        att.setTimeIn(Time.valueOf("08:00:00"));
        att.setTimeOut(Time.valueOf("17:00:00"));
        att.setRegularHoursCalc(8.0);

        attendanceDAO.addAttendance(att);
        System.out.println("Attendance record inserted.");

        List<Attendance> records = attendanceDAO.getAllAttendanceRecords();
        assertFalse(records.isEmpty(), "Attendance records should not be empty.");

        Attendance last = records.get(records.size() - 1);
        assertEquals(att.getEmployeeId(), last.getEmployeeId());
        System.out.println("test1_AddAndGetAttendance PASSED.");
    }

    @Test
    public void test2_GetAttendanceById() throws Exception {
        System.out.println("Running test2_GetAttendanceById...");
        List<Attendance> records = attendanceDAO.getAllAttendanceRecords();
        assertFalse(records.isEmpty(), "No attendance records found.");

        int id = records.get(0).getAttendanceId();
        Attendance att = attendanceDAO.getAttendance(id);

        assertNotNull(att, "Attendance should not be null.");
        assertEquals(id, att.getAttendanceId());
        System.out.println("test2_GetAttendanceById PASSED.");
    }

    @Test
    public void test3_GetAttendanceByEmployeeAndDateRange() throws Exception {
        System.out.println("Running test3_GetAttendanceByEmployeeAndDateRange...");
        int employeeId = 10001;
        java.sql.Date start = java.sql.Date.valueOf("2025-08-09");
        java.sql.Date end = java.sql.Date.valueOf("2025-08-10");
        List<Attendance_sp> list = attendanceDAO.getAttendanceByEmployeeAndDateRange(employeeId, start, end);

        System.out.println("Found " + list.size() + " Attendance_sp records for employeeId=" + employeeId);
        assertNotNull(list, "Attendance list should not be null.");
        System.out.println("test3_GetAttendanceByEmployeeAndDateRange PASSED.");
    }

    @Test
    public void test4_GetAllAttendanceByDateRange() throws Exception {
        System.out.println("Running test4_GetAllAttendanceByDateRange...");
        int employeeId = 10001;
        java.sql.Date start = new java.sql.Date(System.currentTimeMillis() - 14 * 24 * 60 * 60 * 1000L);
        java.sql.Date end = new java.sql.Date(System.currentTimeMillis());
        List<Attendance_sp> list = attendanceDAO.getAllAttendanceByDateRange(employeeId, start, end);

        System.out.println("Found " + list.size() + " Attendance_sp records (all) for employeeId=" + employeeId);
        assertNotNull(list, "Attendance_sp list should not be null.");
        System.out.println("test4_GetAllAttendanceByDateRange PASSED.");
    }

    @Test
    public void test5_UpdateAttendanceOvertimeFields() throws Exception {
        System.out.println("Running test5_UpdateAttendanceOvertimeFields...");
        List<Attendance> records = attendanceDAO.getAllAttendanceRecords();
        assertFalse(records.isEmpty(), "No attendance records found.");

        Attendance att = records.get(0);
        int id = att.getAttendanceId();
        Time newTimeIn = Time.valueOf("08:30:00");
        Time newTimeOut = Time.valueOf("17:30:00");
        Double newOtRate = 1.5;
        Date overtimeUpdatedDate = new Date(System.currentTimeMillis());
        Integer overtimeApproverId = 2; // Make sure this approver exists!

        attendanceDAO.updateAttendanceOvertimeFields(id, newTimeIn, newTimeOut, newOtRate, overtimeUpdatedDate, overtimeApproverId);
        System.out.println("Attendance record updated for overtime fields.");

        Attendance updated = attendanceDAO.getAttendance(id);
        assertNotNull(updated, "Updated attendance should not be null.");
        System.out.println("test5_UpdateAttendanceOvertimeFields PASSED.");
    }

    @Test
    public void test6_UpdateAttendance() throws Exception {
        System.out.println("Running test6_UpdateAttendance...");
        List<Attendance> records = attendanceDAO.getAllAttendanceRecords();
        assertFalse(records.isEmpty(), "No attendance records found.");

        Attendance att = records.get(0);
        int id = att.getAttendanceId();

        Double newRegularHours = 7.5;
        Double newOtRate = 1.25;
        Double newOvertimeHours = 2.0;

        attendanceDAO.updateAttendance(id, newRegularHours, newOtRate, newOvertimeHours);
        System.out.println("Attendance record updated (regular/overtime).");

        Attendance updated = attendanceDAO.getAttendance(id);
        assertNotNull(updated, "Updated attendance should not be null.");
        System.out.println("test6_UpdateAttendance PASSED.");
    }

    @Test
    public void test7_GetAttendanceRecordById() throws Exception {
        System.out.println("Running test7_GetAttendanceRecordById...");
        List<Attendance> records = attendanceDAO.getAllAttendanceRecords();
        assertFalse(records.isEmpty(), "No attendance records found.");

        int id = records.get(0).getAttendanceId();
        Attendance att = attendanceDAO.getAttendanceRecordById(id);

        assertNotNull(att, "Attendance should not be null.");
        assertEquals(id, att.getAttendanceId());
        System.out.println("test7_GetAttendanceRecordById PASSED.");
    }

}
