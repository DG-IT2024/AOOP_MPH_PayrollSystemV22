
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.mockito.*;
import java.sql.*;
import java.util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dao.AttendanceDAO;
import model.Attendance;
import model.Attendance_sp;
import service.AttendanceService;
import controller.AttendanceController;
import util.AttendanceUtil;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danilo
 */
public class AttendanceTest {

    @Mock
    Connection mockConn;
    @Mock
    AttendanceDAO mockDao;
    @Mock
    JTable mockTable;
    @Mock
    DefaultTableModel mockModel;
    AttendanceService service;
    AttendanceController controller;

    @BeforeEach
    public void setup() throws Exception {
        MockitoAnnotations.openMocks(this);
        mockDao = Mockito.mock(AttendanceDAO.class);
        service = Mockito.spy(new AttendanceService());
        // Overwrite service's DAO with mock
        java.lang.reflect.Field daoField = service.getClass().getDeclaredField("attendanceDAO");
        daoField.setAccessible(true);
        daoField.set(service, mockDao);
        controller = new AttendanceController(service);
    }

    // ================= DAO TEST CASES =================
    @Test
    public void testCase01_getAttendanceByEmployeeAndDateRange_valid() throws SQLException {
        System.out.println("[testCase01] getAttendanceByEmployeeAndDateRange with valid params.");
        List<Attendance_sp> dummy = List.of(new Attendance_sp());
        Mockito.when(mockDao.getAttendanceByEmployeeAndDateRange(10001, null, null)).thenReturn(dummy);
        List<Attendance_sp> result = mockDao.getAttendanceByEmployeeAndDateRange(10001, null, null);
        assertNotNull(result);
        assertEquals(1, result.size());
        System.out.println("  PASS: List returned size: " + result.size());
    }

    @Test
    public void testCase02_getAttendanceByEmployeeAndDateRange_invalid() throws SQLException {
        System.out.println("[testCase02] getAttendanceByEmployeeAndDateRange with invalid params.");
        Mockito.when(mockDao.getAttendanceByEmployeeAndDateRange(99999, null, null)).thenReturn(Collections.emptyList());
        List<Attendance_sp> result = mockDao.getAttendanceByEmployeeAndDateRange(99999, null, null);
        assertTrue(result.isEmpty());
        System.out.println("  PASS: Empty list returned");
    }

    @Test
    public void testCase03_addAttendance_valid() throws SQLException {
        System.out.println("[testCase03] addAttendance with valid Attendance.");
        Attendance att = new Attendance();
        Mockito.doNothing().when(mockDao).addAttendance(att);
        mockDao.addAttendance(att);
        Mockito.verify(mockDao).addAttendance(att);
        System.out.println("  PASS: addAttendance called and verified");
    }

    @Test
    public void testCase04_getAttendance_valid() throws SQLException {
        System.out.println("[testCase04] getAttendance with valid attendanceId.");
        Attendance att = new Attendance();
        Mockito.when(mockDao.getAttendance(1)).thenReturn(att);
        Attendance result = mockDao.getAttendance(1);
        assertNotNull(result);
        System.out.println("  PASS: Attendance found");
    }

//    @Test
//    public void testCase05_updateAttendance_valid() throws SQLException {
//        System.out.println("[testCase05] updateAttendance with valid Attendance.");
//        Attendance att = new Attendance();
//        Mockito.doNothing().when(mockDao).updateAttendance(att);
//        mockDao.updateAttendance(att);
//        Mockito.verify(mockDao).updateAttendance(att);
//        System.out.println("  PASS: updateAttendance called and verified");
//    }

    @Test
    public void testCase06_getAllAttendanceRecords_valid() throws SQLException {
        System.out.println("[testCase06] getAllAttendanceRecords returns list.");
        List<Attendance> dummy = List.of(new Attendance());
        Mockito.when(mockDao.getAllAttendanceRecords()).thenReturn(dummy);
        List<Attendance> result = mockDao.getAllAttendanceRecords();
        assertEquals(1, result.size());
        System.out.println("  PASS: All attendance records found");
    }

    @Test
    public void testCase07_getAttendanceRecordById_valid() throws SQLException {
        System.out.println("[testCase07] getAttendanceRecordById with valid id.");
        Attendance att = new Attendance();
        Mockito.when(mockDao.getAttendanceRecordById(1)).thenReturn(att);
        Attendance result = mockDao.getAttendanceRecordById(1);
        assertNotNull(result);
        System.out.println("  PASS: Attendance record by id found");
    }

    @Test
    public void testCase08_updateAttendanceOvertimeFields_valid() throws SQLException {
        System.out.println("[testCase08] updateAttendanceOvertimeFields with valid args.");
        Mockito.doNothing().when(mockDao).updateAttendanceOvertimeFields(Mockito.eq(1), Mockito.any(), Mockito.any(), Mockito.eq(1.5), Mockito.any(), Mockito.any());
        mockDao.updateAttendanceOvertimeFields(1, null, null, 1.5, null, null);
        Mockito.verify(mockDao).updateAttendanceOvertimeFields(Mockito.eq(1), Mockito.any(), Mockito.any(), Mockito.eq(1.5), Mockito.any(), Mockito.any());
        System.out.println("  PASS: updateAttendanceOvertimeFields called");
    }

    // ================= SERVICE TEST CASES =================
    @Test
    public void testCase09_readAttendance_valid() throws SQLException {
        System.out.println("[testCase09] readAttendance returns Attendance_sp.");
        Attendance_sp attsp = new Attendance_sp();
        Mockito.when(mockDao.getAllAttendance(10001, null, null)).thenReturn(attsp);
        Attendance_sp result = service.readAttendance(10001, null, null);
        assertNotNull(result);
        System.out.println("  PASS: readAttendance returns Attendance_sp");
    }

    @Test
    public void testCase10_listAttendanceByEmployeeAndDateRange_valid() throws SQLException {
        System.out.println("[testCase10] listAttendanceByEmployeeAndDateRange returns list.");
        List<Attendance_sp> dummy = List.of(new Attendance_sp());
        Mockito.when(mockDao.getAttendanceByEmployeeAndDateRange(10001, null, null)).thenReturn(dummy);
        List<Attendance_sp> result = service.listAttendanceByEmployeeAndDateRange(10001, null, null);
        assertEquals(1, result.size());
        System.out.println("  PASS: listAttendanceByEmployeeAndDateRange correct size");
    }

//    @Test
//    public void testCase11_calculateWorkedHours_basic() {
//        System.out.println("[testCase11] calculateWorkedHours for 08:00 to 17:00.");
//        int hours = AttendanceService.calculateWorkedHours("08:00", "17:00");
//        assertEquals(8, hours);
//        System.out.println("  PASS: 8 regular hours computed");
//    }
//
//    @Test
//    public void testCase12_getRegularHours_basic() {
//        System.out.println("[testCase12] getRegularHours for 08:00-17:00.");
//        double regular = service.getRegularHours("08:00", "17:00");
//        assertEquals(8, regular);
//        System.out.println("  PASS: Regular hours 8");
//    }
//
//    @Test
//    public void testCase13_getOvertimeHours_basic() {
//        System.out.println("[testCase13] getOvertimeHours for 08:00-19:00.");
//        double overtime = service.getOvertimeHours("08:00", "19:00");
//        assertEquals(3, overtime);
//        System.out.println("  PASS: Overtime hours 3");
//    }

    @Test
    public void testCase14_getRegularHours_range() throws SQLException {
        System.out.println("[testCase14] getRegularHours range aggregates.");
        Attendance_sp att = new Attendance_sp();
        att.setRegularHoursCalc(8.0);
        List<Attendance_sp> dummy = List.of(att);
        Mockito.when(mockDao.getAttendanceByEmployeeAndDateRange(10001, null, null)).thenReturn(dummy);
        double total = service.getRegularHours(10001, null, null);
        assertEquals(8.0, total);
        System.out.println("  PASS: Range regular hours 8.0");
    }

    @Test
    public void testCase15_getOvertimeHours_range() throws SQLException {
        System.out.println("[testCase15] getOvertimeHours range aggregates.");
        Attendance_sp att = new Attendance_sp();
        att.setOvertimeHoursCalc(2.0);
        List<Attendance_sp> dummy = List.of(att);
        Mockito.when(mockDao.getAttendanceByEmployeeAndDateRange(10001, null, null)).thenReturn(dummy);
        double total = service.getOvertimeHours(10001, null, null);
        assertEquals(2.0, total);
        System.out.println("  PASS: Range overtime hours 2.0");
    }

//    @Test
//    public void testCase16_updateAttendance_valid() throws SQLException {
//        System.out.println("[testCase16] updateAttendance delegates to DAO.");
//        Attendance att = new Attendance();
//        Mockito.doNothing().when(mockDao).updateAttendance(att);
//        service.updateAttendance(att);
//        Mockito.verify(mockDao).updateAttendance(att);
//        System.out.println("  PASS: updateAttendance called");
//    }

    @Test
    public void testCase17_listAllAttendance_valid() throws SQLException {
        System.out.println("[testCase17] listAllAttendance returns list.");
        List<Attendance> dummy = List.of(new Attendance());
        Mockito.when(mockDao.getAllAttendanceRecords()).thenReturn(dummy);
        List<Attendance> result = service.listAllAttendance();
        assertEquals(1, result.size());
        System.out.println("  PASS: listAllAttendance returns 1 item");
    }

//    @Test
//    public void testCase18_updateAttendanceOvertimeFields_valid() throws SQLException {
//        System.out.println("[testCase18] updateAttendanceOvertimeFields calls DAO.");
//        Mockito.doNothing().when(mockDao).updateAttendanceOvertimeFields(Mockito.eq(1), Mockito.any(), Mockito.any(), Mockito.eq(1.25), Mockito.any(), Mockito.any());
//        service.updateAttendanceOvertimeFields(1, null, null, 1.25, null, null);
//        Mockito.verify(mockDao).updateAttendanceOvertimeFields(Mockito.eq(1), Mockito.any(), Mockito.any(), Mockito.eq(1.25), Mockito.any(), Mockito.any());
//        System.out.println("  PASS: updateAttendanceOvertimeFields called");
//    }

    // ================= CONTROLLER TEST CASES =================
    @Test
    public void testCase19_loadAttendanceToTable_valid() throws SQLException {
        System.out.println("[testCase19] loadAttendanceToTable with dummy.");
        List<Attendance> dummy = List.of(new Attendance());
        Mockito.when(mockDao.getAllAttendanceRecords()).thenReturn(dummy);
        controller.loadAttendanceToTable(new JTable());
        System.out.println("  PASS: No exception, loaded table");
    }

    @Test
    public void testCase20_loadAttendanceToFilteredTable_valid() throws SQLException {
        System.out.println("[testCase20] loadAttendanceToFilteredTable");
        List<Attendance_sp> dummy = List.of(new Attendance_sp());
        Mockito.when(mockDao.getAttendanceByEmployeeAndDateRange(10001, null, null)).thenReturn(dummy);
        controller.loadAttendanceToFilteredTable(new JTable(), 10001, null, null);
        System.out.println("  PASS: Filtered attendance table loaded");
    }

    @Test
    public void testCase21_loadBasicAttendanceToFilteredTable_valid() throws SQLException {
        System.out.println("[testCase21] loadBasicAttendanceToFilteredTable");
        List<Attendance_sp> dummy = List.of(new Attendance_sp());
        Mockito.when(mockDao.getAttendanceByEmployeeAndDateRange(10001, null, null)).thenReturn(dummy);
        controller.loadBasicAttendanceToFilteredTable(new JTable(), 10001, null, null);
        System.out.println("  PASS: Basic attendance table loaded");
    }

//    @Test
//    public void testCase22_getAttendance_valid() {
//        System.out.println("[testCase22] getAttendance valid path");
//        Attendance_sp attsp = new Attendance_sp();
//        Mockito.doReturn(attsp).when(service).readAttendance(10001, null, null);
//        Attendance_sp result = controller.getAttendance(10001, null, null);
//        assertNotNull(result);
//        System.out.println("  PASS: Controller getAttendance found");
//    }

//    @Test
//    public void testCase23_modifyAttendance_valid() {
//        System.out.println("[testCase23] modifyAttendance delegates");
//        Attendance att = new Attendance();
//        Mockito.doNothing().when(service).updateAttendance(att);
//        controller.modifyAttendance(att);
//        Mockito.verify(service).updateAttendance(att);
//        System.out.println("  PASS: Controller modifyAttendance");
//    }

    @Test
    public void testCase24_getAttendanceIds_valid() {
        System.out.println("[testCase24] getAttendanceIds from mock JTable");
        JTable table = new JTable(new Object[][]{{1}, {2}}, new String[]{"attendance_id"});
        ArrayList<Integer> ids = controller.getAttendanceIds(table);
        assertEquals(2, ids.size());
        System.out.println("  PASS: Got attendance IDs");
    }

    // ================= UTIL/BEAN/MODEL TEST CASES =================
//    @Test
//    public void testCase25_Attendance_sp_gettersSetters() {
//        System.out.println("[testCase25] Attendance_sp getters/setters");
//        Attendance_sp req = new Attendance_sp();
//        req.setAttendanceId(1);
//        req.setEmployeeId(100);
//        req.setDate(new Date(System.currentTimeMillis()));
//        req.setTimeIn(Time.valueOf("08:00:00"));
//        req.setTimeOut(Time.valueOf("17:00:00"));
//        req.setRegularHoursCalc(8.0);
//        req.setOvertimeRate(1.25);
//        req.setOvertimeHoursCalc(2.0);
//        req.setOvertimeUpdatedDate(new Date(System.currentTimeMillis()));
//        req.setLastName("Dela Cruz");
//        req.setFirstName("Maria");
//        req.setOvertimeApproverId(10);
//        req.setOvertimeApproverLastName("Santos");
//        req.setOvertimeApproverFirstName("Jose");
//        assertEquals(1, req.getAttendanceId());
//        assertEquals(100, req.getEmployeeId());
//        assertEquals("08:00:00", req.getTimeIn().toString());
//        assertEquals(8.0, req.getRegularHoursCalc(), 0.01);
//        assertEquals(1.25, req.getOvertimeRate(), 0.01);
//        assertEquals(2.0, req.getOvertimeHoursCalc(), 0.01);
//        assertEquals("Dela Cruz", req.getLastName());
//        assertEquals("Maria", req.getFirstName());
//        assertEquals(10, req.getOvertimeApproverId());
//        assertEquals("Santos", req.getOvertimeApproverLastName());
//        assertEquals("Jose", req.getOvertimeApproverFirstName());
//        System.out.println("  PASS: All Attendance_sp getters/setters ok");
//    }

    @Test
    public void testCase26_AttendanceUtil_toTableModelTruncated() {
        System.out.println("[testCase26] AttendanceUtil.toTableModelTruncated");
        List<Attendance> dummy = List.of(new Attendance());
        DefaultTableModel model = AttendanceUtil.toTableModelTruncated(dummy);
        assertNotNull(model);
        System.out.println("  PASS: Model created");
    }

    @Test
    public void testCase27_AttendanceUtil_toTableModel_sp() {
        System.out.println("[testCase27] AttendanceUtil.toTableModel_sp");
        List<Attendance_sp> dummy = List.of(new Attendance_sp());
        DefaultTableModel model = AttendanceUtil.toTableModel_sp(dummy);
        assertNotNull(model);
        System.out.println("  PASS: Model created");
    }

    @Test
    public void testCase28_AttendanceUtil_attendanceListToTableModel() {
        System.out.println("[testCase28] AttendanceUtil.attendanceListToTableModel");
        List<Attendance_sp> dummy = List.of(new Attendance_sp());
        DefaultTableModel model = AttendanceUtil.attendanceListToTableModel(dummy);
        assertNotNull(model);
        System.out.println("  PASS: attendanceListToTableModel created");
    }

    @Test
    public void testCase29_AttendanceUtil_toTableModel() {
        System.out.println("[testCase29] AttendanceUtil.toTableModel");
        List<Attendance> dummy = List.of(new Attendance());
        DefaultTableModel model = AttendanceUtil.toTableModel(dummy);
        assertNotNull(model);
        System.out.println("  PASS: Model created");
    }

    @Test
    public void testCase30_AttendanceUtil_getTotalRegularHours() {
        System.out.println("[testCase30] AttendanceUtil.getTotalRegularHours");
        AttendanceUtil util = new AttendanceUtil();
        Attendance_sp att = new Attendance_sp();
        att.setRegularHoursCalc(8.0);
        double total = util.getTotalRegularHours(List.of(att));
        assertEquals(8.0, total);

    }
}
