import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import dao.LeaveRequestDAO;
import model.LeaveRequest_sp;
import util.DBConnect;

import java.sql.*;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LeaveRequestDAOTest {

    private static Connection conn;
    private LeaveRequestDAO leaveRequestDAO;

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for LeaveRequestDAOTest.");
    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed after LeaveRequestDAOTest.");
        }
    }

    @BeforeEach
    public void setUp() {
        leaveRequestDAO = new LeaveRequestDAO(conn);
    }

    @Test
    public void test1_getLeaveRequests_byEmployeeAndStatus() throws Exception {
        System.out.println("Test 1: getLeaveRequests - By employee and status");
        Integer employeeId = 10001; // Replace with real test data
        String status = "APPROVED";
        List<LeaveRequest_sp> list = leaveRequestDAO.getLeaveRequests(employeeId, status);
        assertNotNull(list, "List should not be null");
        System.out.println("Leave requests found: " + list.size());
    }

    @Test
    public void test2_getLeaveRequests_allStatuses() throws Exception {
        System.out.println("Test 2: getLeaveRequests - All statuses for employee");
        Integer employeeId = 10001;
        List<LeaveRequest_sp> list = leaveRequestDAO.getLeaveRequests(employeeId, null);
        assertNotNull(list);
        System.out.println("Total requests for emp: " + list.size());
    }

    @Test
    public void test3_getLeaveRequests_allEmployees() throws Exception {
        System.out.println("Test 3: getLeaveRequests - All employees, all statuses");
        List<LeaveRequest_sp> list = leaveRequestDAO.getLeaveRequests(null, null);
        assertNotNull(list);
        System.out.println("Total leave requests in DB: " + list.size());
    }

    @Test
    public void test4_addLeaveRequest() throws Exception {
        System.out.println("Test 4: addLeaveRequest - Insert new leave request");
        int employeeId = 10001;
        String leaveType = "Vacation Leave";
        Date start = Date.valueOf("2024-08-20");
        Date end = Date.valueOf("2024-08-22");
        double calcLeave = 3;
        String reason = "JUnit test leave";
        assertDoesNotThrow(() ->
            leaveRequestDAO.addLeaveRequest(employeeId, leaveType, start, end, calcLeave, reason)
        );
        System.out.println("Leave request added for employee: " + employeeId);
    }

    @Test
    public void test5_updateLeaveRequest() throws Exception {
        System.out.println("Test 5: updateLeaveRequest - Update leave status");
        // Use an actual leave_id and approverEmployeeId for your DB!
        int leaveId = 1; // Change as needed
        String status = "APPROVED";
        int approverId = 10002;
        Timestamp approvedDate = new Timestamp(System.currentTimeMillis());
        assertDoesNotThrow(() ->
            leaveRequestDAO.updateLeaveRequest(leaveId, status, approverId, approvedDate)
        );
        System.out.println("Leave request updated for leaveId: " + leaveId);
    }

    @Test
    public void test6_getLeaveRequests_noneFound() throws Exception {
        System.out.println("Test 6: getLeaveRequests - No requests found edge case");
        Integer employeeId = 99999; // Use non-existent
        String status = "APPROVED";
        List<LeaveRequest_sp> list = leaveRequestDAO.getLeaveRequests(employeeId, status);
        assertNotNull(list);
        assertEquals(0, list.size(), "Should return empty list if no records found");
        System.out.println("No leave requests found for invalid employee/status.");
    }

    @Test
    public void test7_addLeaveRequest_invalidData() {
        System.out.println("Test 7: addLeaveRequest - Invalid data should throw SQLException");
        int employeeId = 99999; // Non-existent employee
        String leaveType = "Invalid Leave";
        Date start = Date.valueOf("2024-08-20");
        Date end = Date.valueOf("2024-08-19"); // start > end
        double calcLeave = -1;
        String reason = null;
        assertThrows(SQLException.class, () ->
            leaveRequestDAO.addLeaveRequest(employeeId, leaveType, start, end, calcLeave, reason)
        );
        System.out.println("Exception thrown for invalid insert as expected.");
    }
}
