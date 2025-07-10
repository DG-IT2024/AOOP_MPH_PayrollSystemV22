
import java.sql.Connection;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import util.AttendanceUtil;
import model.Attendance;
import model.Attendance_sp;
import service.AttendanceService;
import service.EmployeeService;
import util.DBConnect;

public class AttendanceTest {

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

    @Test
    public void testCase01_ToTableModelTruncated() {
        Attendance att = new Attendance();
        att.setDate(java.sql.Date.valueOf("2025-07-04"));
        att.setTimeIn(java.sql.Time.valueOf("08:15:00"));
        att.setTimeOut(java.sql.Time.valueOf("12:00:00"));
        att.setRegularHoursCalc(3.0);
        List<Attendance> list = Arrays.asList(att);
        DefaultTableModel model = AttendanceUtil.toTableModelTruncated(list);
        assertEquals(4, model.getColumnCount()); // Date, Time In, Time Out, Regular Hours
        assertEquals("2025-07-04", model.getValueAt(0, 0));
        assertEquals("08:15:00", model.getValueAt(0, 1));
        assertEquals("12:00:00", model.getValueAt(0, 2));
        assertEquals("3.0", model.getValueAt(0, 3));
    }

    @Test
    public void testCase02_ToTableModel_sp() {
        Attendance_sp att = new Attendance_sp();
        att.setDate(java.sql.Date.valueOf("2025-07-05"));
        att.setTimeIn(java.sql.Time.valueOf("09:00:00"));
        att.setTimeOut(java.sql.Time.valueOf("13:00:00"));
        att.setRegularHoursCalc(3.0);
        att.setOvertimeHoursCalc(2.0);
        List<Attendance_sp> list = Arrays.asList(att);
        DefaultTableModel model = AttendanceUtil.toTableModel_sp(list);
        assertEquals(5, model.getColumnCount()); // Date, In, Out, Reg, OT
        assertEquals("2025-07-05", model.getValueAt(0, 0));
        assertEquals("09:00:00", model.getValueAt(0, 1));
        assertEquals("13:00:00", model.getValueAt(0, 2));
        assertEquals("3.0", model.getValueAt(0, 3));
        assertEquals("2.0", model.getValueAt(0, 4));
    }

    @Test
    public void testCase03_AttendanceListToTableModel() {
        Attendance_sp att = new Attendance_sp();
        att.setAttendanceId(5);
        att.setEmployeeId(55);
        att.setDate(java.sql.Date.valueOf("2025-07-06"));
        att.setTimeIn(java.sql.Time.valueOf("07:00:00"));
        att.setTimeOut(java.sql.Time.valueOf("15:00:00"));
        att.setRegularHoursCalc(8.0);
        att.setOvertimeRate(1.75);
        att.setOvertimeHoursCalc(0.0);
        att.setOvertimeUpdatedDate(java.sql.Date.valueOf("2025-07-06"));
        att.setLastName("Max");
        att.setFirstName("Payne");
        att.setOvertimeApproverId(99);
        att.setOvertimeApproverLastName("Lee");
        att.setOvertimeApproverFirstName("Stone");
        List<Attendance_sp> list = Arrays.asList(att);

        DefaultTableModel model = AttendanceUtil.attendanceListToTableModel(list);
        assertEquals(14, model.getColumnCount());
        assertEquals(5, model.getValueAt(0, 0));
        assertEquals(55, model.getValueAt(0, 1));
        assertEquals(java.sql.Date.valueOf("2025-07-06"), model.getValueAt(0, 2));
        assertEquals(8.0, model.getValueAt(0, 5));
        assertEquals(99, model.getValueAt(0, 11));
        assertEquals("Stone", model.getValueAt(0, 13));
    }

    @Test
    public void testCase04_ToTableModel() {
        Attendance att = new Attendance();
        att.setDate(java.sql.Date.valueOf("2025-07-07"));
        att.setTimeIn(java.sql.Time.valueOf("10:00:00"));
        att.setTimeOut(java.sql.Time.valueOf("12:00:00"));
        att.setRegularHoursCalc(2.0);
        List<Attendance> list = Arrays.asList(att);
        DefaultTableModel model = AttendanceUtil.toTableModel(list);
        assertEquals(4, model.getColumnCount()); // Date, In, Out, Reg
        assertEquals("2025-07-07", model.getValueAt(0, 0));
        assertEquals("10:00:00", model.getValueAt(0, 1));
        assertEquals("12:00:00", model.getValueAt(0, 2));
        assertEquals("2.0", model.getValueAt(0, 3));
    }

    @Test
    public void testCase05_IsValidTimeFormat() {
        assertTrue(AttendanceUtil.isValidTimeFormat("08:00"));
        assertTrue(AttendanceUtil.isValidTimeFormat("8:05"));
        assertTrue(AttendanceUtil.isValidTimeFormat("23:59"));
        assertFalse(AttendanceUtil.isValidTimeFormat("24:00"));
        assertFalse(AttendanceUtil.isValidTimeFormat("99:99"));
        assertFalse(AttendanceUtil.isValidTimeFormat("abc"));
    }

    @Test
    public void testCase06_CalculateWorkedHours_MatchesServiceLogic() {
        // Should match AttendanceService.calculateWorkedHours
        assertEquals(AttendanceService.calculateWorkedHours("08:00", "17:00"), AttendanceUtil.calculateWorkedHours("08:00", "17:00"));
        assertEquals(8, AttendanceUtil.calculateWorkedHours("08:00", "17:00"));
        assertEquals(4, AttendanceUtil.calculateWorkedHours("13:00", "17:00"));
    }

    @Test
    public void testCase07_RegularAndOvertimeHoursLists() {
        List<Integer> regs = Arrays.asList(3, 4, 1);
        List<Integer> ots = Arrays.asList(2, 0, 1);
        assertEquals(8, AttendanceUtil.regularWorkedHours(new ArrayList<>(regs)));
        assertEquals(3, AttendanceUtil.overtimeHours(new ArrayList<>(ots)));
    }

    @Test
    public void testCase08_GetTotalRegularHours_List() {
        Attendance_sp a = new Attendance_sp();
        a.setRegularHoursCalc(4.0);
        Attendance_sp b = new Attendance_sp();
        b.setRegularHoursCalc(2.5);
        Attendance_sp c = new Attendance_sp();
        c.setRegularHoursCalc(null);
        double total = new AttendanceUtil().getTotalRegularHours(Arrays.asList(a, b, c));
        assertEquals(6.5, total, 0.001);
    }

    @Test
    public void testCase09_GetAttendanceIdsFromTable() {
        // Create table with one column (attendance ID at column 0)
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID"}, 0);
        model.addRow(new Object[]{1});
        model.addRow(new Object[]{"2"});
        model.addRow(new Object[]{null});
        model.addRow(new Object[]{"x"});
        model.addRow(new Object[]{3});
        JTable table = new JTable(model);
        List<Integer> ids = AttendanceUtil.getAttendanceIdsFromTable(table);
        assertEquals(Arrays.asList(1, 2, 3), ids);
    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed after EmployeeServiceTest.");
        }
    }
}
