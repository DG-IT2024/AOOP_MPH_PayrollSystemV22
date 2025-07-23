
import java.sql.Connection;
import org.junit.jupiter.api.*;
import util.AttendanceUtil;
import model.Attendance;
import model.Attendance_sp;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import util.DBConnect;

public class AttendanceUtilTest {

    private static Connection conn;
 
    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for AttendanceUtilTest.");
    }

   
    @Test
    public void testCase1_toTableModelTruncated_validList() {
        List<Attendance> list = new ArrayList<>();
        Attendance att = new Attendance();
        att.setDate(Date.valueOf("2024-07-20"));
        att.setTimeIn(java.sql.Time.valueOf("08:00:00"));
        att.setTimeOut(java.sql.Time.valueOf("17:00:00"));
        att.setRegularHoursCalc(8.0);
        list.add(att);
        DefaultTableModel model = AttendanceUtil.toTableModelTruncated(list);
        System.out.println("Test Case 1 - toTableModelTruncated: Row count = " + model.getRowCount());
        assertEquals(1, model.getRowCount());
    }

    @Test
    public void testCase2_toTableModel_sp_validList() {
        List<Attendance_sp> list = new ArrayList<>();
        Attendance_sp att = new Attendance_sp();
        att.setDate(Date.valueOf("2024-07-20"));
        att.setTimeIn(java.sql.Time.valueOf("08:00:00"));
        att.setTimeOut(java.sql.Time.valueOf("17:00:00"));
        att.setRegularHoursCalc(8.0);
        att.setOvertimeHoursCalc(2.0);
        list.add(att);
        DefaultTableModel model = AttendanceUtil.toTableModel_sp(list);
        System.out.println("Test Case 2 - toTableModel_sp: Row count = " + model.getRowCount());
        assertEquals(1, model.getRowCount());
    }

    @Test
    public void testCase3_attendanceListToTableModel_validList() {
        List<Attendance_sp> list = new ArrayList<>();
        Attendance_sp att = new Attendance_sp();
        att.setAttendanceId(1);
        att.setEmployeeId(1);
        att.setDate(Date.valueOf("2024-07-20"));
        att.setTimeIn(java.sql.Time.valueOf("08:00:00"));
        att.setTimeOut(java.sql.Time.valueOf("17:00:00"));
        att.setRegularHoursCalc(8.0);
        att.setOvertimeRate(1.25);
        att.setOvertimeHoursCalc(2.0);
        att.setLastName("Smith");
        att.setFirstName("John");
        att.setOvertimeApproverId(10);
        att.setOvertimeApproverLastName("Doe");
        att.setOvertimeApproverFirstName("Jane");
        list.add(att);
        DefaultTableModel model = AttendanceUtil.attendanceListToTableModel(list);
        System.out.println("Test Case 3 - attendanceListToTableModel: Row count = " + model.getRowCount());
        assertEquals(1, model.getRowCount());
    }

    @Test
    public void testCase4_toTableModel_validList() {
        List<Attendance> list = new ArrayList<>();
        Attendance att = new Attendance();
        att.setDate(Date.valueOf("2024-07-20"));
        att.setTimeIn(java.sql.Time.valueOf("08:00:00"));
        att.setTimeOut(java.sql.Time.valueOf("17:00:00"));
        att.setRegularHoursCalc(8.0);
        list.add(att);
        DefaultTableModel model = AttendanceUtil.toTableModel(list);
        System.out.println("Test Case 4 - toTableModel: Row count = " + model.getRowCount());
        assertEquals(1, model.getRowCount());
    }

    @Test
    public void testCase5_getTotalRegularHours_validList() {
        List<Attendance_sp> list = new ArrayList<>();
        Attendance_sp att1 = new Attendance_sp();
        att1.setRegularHoursCalc(8.0);
        Attendance_sp att2 = new Attendance_sp();
        att2.setRegularHoursCalc(7.5);
        list.add(att1);
        list.add(att2);
        double total = new AttendanceUtil().getTotalRegularHours(list);
        System.out.println("Test Case 5 - getTotalRegularHours: Total = " + total);
        assertEquals(15.5, total, 0.001);
    }

    @Test
    public void testCase6_calculateWorkedHours_regularCase() {
        int result = AttendanceUtil.calculateWorkedHours("08:00", "17:00");
        System.out.println("Test Case 6 - calculateWorkedHours: 08:00-17:00 = " + result);
        assertEquals(8, result);
    }

    @Test
    public void testCase7_regularWorkedHours_sum() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(9);
        int result = AttendanceUtil.regularWorkedHours(list);
        System.out.println("Test Case 7 - regularWorkedHours: Sum = " + result);
        assertEquals(16, result);
    }

    @Test
    public void testCase8_overtimeHours_sum() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        int result = AttendanceUtil.overtimeHours(list);
        System.out.println("Test Case 8 - overtimeHours: Sum = " + result);
        assertEquals(5, result);
    }

    @Test
    public void testCase9_weightedOvertimeHour_typical() {
        ArrayList<Integer> hours = new ArrayList<>();
        ArrayList<Double> rates = new ArrayList<>();
        hours.add(2);
        rates.add(1.25);
        hours.add(1);
        rates.add(1.5);
        double result = AttendanceUtil.weightedOvertimeHour(hours, rates);
        System.out.println("Test Case 9 - weightedOvertimeHour: (2*1.25 + 1*1.5) = " + result);
        assertEquals(4.0, result, 0.01);
    }

    @Test
    public void testCase10_getAttendanceIdsFromTable_mockTable() {
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{
                    {101, "2024-07-20", "08:00:00", "17:00:00", 8.0, 2.0},
                    {102, "2024-07-21", "08:00:00", "17:00:00", 8.0, 1.5}
                },
                new String[]{"attendance_id", "Date", "Time In", "Time Out", "Regular Hours", "Overtime Hours"}
        );
        JTable table = new JTable(model);
        ArrayList<Integer> ids = AttendanceUtil.getAttendanceIdsFromTable(table);
        System.out.println("Test Case 10 - getAttendanceIdsFromTable: IDs = " + ids);
        assertEquals(2, ids.size());
        assertTrue(ids.contains(101));
        assertTrue(ids.contains(102));
    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed after LeaveTest.");
        }
    }
}
