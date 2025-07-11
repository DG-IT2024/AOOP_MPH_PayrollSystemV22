
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import model.LeaveRequest_sp;
import service.LeaveRequestService;
import util.DBConnect;
import util.DateUtil;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LeaveTest {

    private static Connection conn;
    private LeaveRequestService leaveRequestService;

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for LeaveTest.");
    }

    @BeforeEach
    public void setUp() throws Exception {
        leaveRequestService = new LeaveRequestService();
    }

    // EMPLOYEE TESTS
    @Test
    public void testCase1_SubmitValidLeaveRequest() throws Exception {
        int employeeId = 10005;
        String leaveType = "Sick Leave";
        Date startDate = Date.valueOf("2025-07-10");
        Date endDate = Date.valueOf("2025-07-12");
        double calcLeave = 3;
        String reason = "Fever and flu";

        leaveRequestService.addLeaveRequest(employeeId, leaveType, startDate, endDate, calcLeave, reason);

        List<LeaveRequest_sp> requests = leaveRequestService.listLeaveRequests(employeeId, "PENDING");
        boolean found = requests.stream().anyMatch(lr
                -> lr.getLeaveType().equals(leaveType)
                && lr.getReason().equals(reason)
                && lr.getLeaveStatus().equals("PENDING")
        );
        System.out.println("Test Case 1 - Submit valid leave request: " + found);
        assertTrue(found);
    }

    @Test
    public void testCase2_SubmitLeaveWithStartAfterEndDate() {
        int employeeId = 10005;
        String leaveType = "Vacation Leave";
        Date startDate = Date.valueOf("2025-07-15");
        Date endDate = Date.valueOf("2025-07-10");
        double calcLeave = 1;
        String reason = "Error date";

        Exception exception = assertThrows(Exception.class, () -> {
            leaveRequestService.addLeaveRequest(employeeId, leaveType, startDate, endDate, calcLeave, reason);
        });
        System.out.println("Test Case 2 - Submit leave with start date after end date: Exception Message = " + exception.getMessage());
        assertTrue(exception.getMessage().contains("Start date should not be after end date"));
    }

    // ADMIN TESTS
    @Test
    public void testCase3_ApprovePendingLeaveRequest() throws Exception {
        int employeeId = 10005;
        String leaveType = "Vacation Leave";
        Date startDate = Date.valueOf("2025-07-20");
        Date endDate = Date.valueOf("2025-07-21");
        double calcLeave = 2;
        String reason = "Family trip";

        leaveRequestService.addLeaveRequest(employeeId, leaveType, startDate, endDate, calcLeave, reason);

        List<LeaveRequest_sp> requests = leaveRequestService.listLeaveRequests(employeeId, "PENDING");
        LeaveRequest_sp request = requests.get(requests.size() - 1); // Last request

        int leaveId = request.getLeaveId();
        int approverId = 10001;
        Timestamp now = new Timestamp(System.currentTimeMillis());

        leaveRequestService.updateLeaveRequestStatus(leaveId, "APPROVED", approverId, now);

        List<LeaveRequest_sp> approved = leaveRequestService.listLeaveRequests(employeeId, "APPROVED");
        boolean found = approved.stream().anyMatch(lr -> lr.getLeaveId() == leaveId);
        System.out.println("Test Case 3 - Approve pending leave request: " + found);
        assertTrue(found);
    }

    @Test
    public void testCase4_DenyPendingLeaveRequest() throws Exception {
        int employeeId = 10005;
        String leaveType = "Others";
        Date startDate = Date.valueOf("2025-07-25");
        Date endDate = Date.valueOf("2025-07-25");
        double calcLeave = 1;
        String reason = "Personal errand";

        leaveRequestService.addLeaveRequest(employeeId, leaveType, startDate, endDate, calcLeave, reason);

        List<LeaveRequest_sp> requests = leaveRequestService.listLeaveRequests(employeeId, "PENDING");
        LeaveRequest_sp request = requests.get(requests.size() - 1);

        int leaveId = request.getLeaveId();
        int approverId = 10001;
        Timestamp now = new Timestamp(System.currentTimeMillis());

        leaveRequestService.updateLeaveRequestStatus(leaveId, "DENIED", approverId, now);

        List<LeaveRequest_sp> denied = leaveRequestService.listLeaveRequests(employeeId, "DENIED");
        boolean found = denied.stream().anyMatch(lr -> lr.getLeaveId() == leaveId);
        System.out.println("Test Case 4 - Deny pending leave request: " + found);
        assertTrue(found);
    }

    // VIEWING
    @Test
    public void testCase5_EmployeeCanViewOwnLeaveHistory() throws Exception {
        int employeeId = 10005;
        List<LeaveRequest_sp> requests = leaveRequestService.listLeaveRequests(employeeId, null);
        System.out.println("Test Case 5 - Employee can view own leave history, found requests: " + requests.size());
        assertNotNull(requests);
    }

    @Test
    public void testCase6_AdminCanViewAllLeaveRequests() throws Exception {
        List<LeaveRequest_sp> allRequests = leaveRequestService.listLeaveRequests(null, null);
        System.out.println("Test Case 6 - Admin can view all leave requests, found requests: " + allRequests.size());
        assertNotNull(allRequests);
        assertTrue(allRequests.size() > 0);
    }

    // LEAVE CALCULATION7
    @Test
    public void testCase7_CalculateLeaveDaysExcludingSundays() throws Exception {
        java.sql.Date sqlStartDate = java.sql.Date.valueOf("2025-07-07"); // Monday
        java.sql.Date sqlEndDate = java.sql.Date.valueOf("2025-07-13");   // Sunday
        java.util.Date utilStartDate = new java.util.Date(sqlStartDate.getTime());
        java.util.Date utilEndDate = new java.util.Date(sqlEndDate.getTime());

        int leaveDays = DateUtil.getLeaveDaysExcludingSundays(utilStartDate, utilEndDate);

        System.out.println("Test Case 7 - Calculate leave days excluding Sundays (2025-07-07 to 2025-07-13): " + leaveDays);
        assertEquals(6, leaveDays);
    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed after LeaveTest.");
        }
    }
}
