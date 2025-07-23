
import dao.AttendanceDAO;
import model.Attendance;
import model.Attendance_sp;
import org.junit.jupiter.api.*;
import util.DBConnect;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
    }

    @Test
    public void testCase1_getAttendanceById_validId() throws Exception {
        List<Attendance> records = attendanceDAO.getAllAttendanceRecords();
        boolean result = false;

        if (!records.isEmpty()) {
            int id = records.get(0).getAttendanceId();
            Attendance att = attendanceDAO.getAttendance(id);
            result = att != null && att.getAttendanceId() == id;
        }

        assertTrue(result, "Failed to get attendance by ID.");
        System.out.println("Test Case 1 - Get Attendance by ID: " + result);
    }

    @Test
    public void testCase2_getAttendanceByEmployeeAndDateRange_validInput() throws Exception {
        int employeeId = 10001;
        Date start = Date.valueOf("2025-08-09");
        Date end = Date.valueOf("2025-08-10");

        List<Attendance_sp> list = attendanceDAO.getAttendanceByEmployeeAndDateRange(employeeId, start, end);
        boolean result = list != null;

        assertTrue(result, "Attendance list is null.");
        System.out.println("Test Case 2 - Get Attendance by Employee and Date Range: " + result);
    }

    @Test
    public void testCase3_updateAttendanceOvertimeFields_validUpdate() throws Exception {
        List<Attendance> records = attendanceDAO.getAllAttendanceRecords();
        boolean result = false;

        if (!records.isEmpty()) {
            Attendance att = records.get(0);
            int id = att.getAttendanceId();

            Time newTimeIn = Time.valueOf("08:30:00");
            Time newTimeOut = Time.valueOf("17:30:00");
            Double newOtRate = 1.5;
            Date overtimeUpdatedDate = new Date(System.currentTimeMillis());
            Integer overtimeApproverId = 2;

            attendanceDAO.updateAttendanceOvertimeFields(id, newTimeIn, newTimeOut, newOtRate, overtimeUpdatedDate, overtimeApproverId);

            Attendance updated = attendanceDAO.getAttendance(id);
            result = updated != null;
        }

        assertTrue(result, "Failed to update overtime fields.");
        System.out.println("Test Case 3 - Update Attendance Overtime Fields: " + result);
    }

    @Test
    public void testCase4_updateAttendance_validUpdate() throws Exception {
        List<Attendance> records = attendanceDAO.getAllAttendanceRecords();
        boolean result = false;

        if (!records.isEmpty()) {
            Attendance att = records.get(0);
            int id = att.getAttendanceId();

            Double newRegularHours = 7.5;
            Double newOtRate = 1.25;
            Double newOvertimeHours = 2.0;

            attendanceDAO.updateAttendance(id, newRegularHours, newOtRate, newOvertimeHours);
            Attendance updated = attendanceDAO.getAttendance(id);
            result = updated != null;
        }

        assertTrue(result, "Failed to update attendance.");
        System.out.println("Test Case 4 - Update Attendance (Regular and Overtime): " + result);
    }

    @Test
    public void testCase5_getAttendanceRecordById_validId() throws Exception {
        List<Attendance> records = attendanceDAO.getAllAttendanceRecords();
        boolean result = false;

        if (!records.isEmpty()) {
            int id = records.get(0).getAttendanceId();
            Attendance att = attendanceDAO.getAttendanceRecordById(id);
            result = att != null && att.getAttendanceId() == id;
        }

        assertTrue(result, "Failed to get attendance record by ID.");
        System.out.println("Test Case 5 - Get Attendance Record by ID: " + result);
    }
}
