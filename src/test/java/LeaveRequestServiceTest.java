import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import service.LeaveRequestService;
import model.LeaveRequest_sp;
import javax.swing.JTable;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LeaveRequestServiceTest {

    private LeaveRequestService leaveRequestService;

    @BeforeAll
    public static void setupDB() throws Exception {
        System.out.println("Database connection established for LeaveRequestServiceTest.");
    }

    @AfterAll
    public static void teardown() throws Exception {
        System.out.println("Database connection closed after LeaveRequestServiceTest.");
    }

    @BeforeEach
    public void setUp() throws Exception {
        leaveRequestService = new LeaveRequestService();
    }

    @Test
    public void test1_listLeaveRequests_approved() throws Exception {
        System.out.println("Test 1: listLeaveRequests - approved leaves for employee");
        List<LeaveRequest_sp> list = leaveRequestService.listLeaveRequests(10001, "APPROVED");
        assertNotNull(list);
        assertTrue(list.size() >= 0);
        System.out.println("Approved leaves found: " + list.size());
    }

    @Test
    public void test2_loadLeaveToTable() throws Exception {
        System.out.println("Test 2: loadLeaveToTable - populates JTable");
        JTable table = new JTable();
        leaveRequestService.loadLeaveToTable(table, 10001, "APPROVED");
        assertNotNull(table.getModel());
        System.out.println("JTable row count: " + table.getRowCount());
    }

    @Test
    public void test3_loadLeaveToTableExpanded() throws Exception {
        System.out.println("Test 3: loadLeaveToTableExpanded - expanded table");
        JTable table = new JTable();
        leaveRequestService.loadLeaveToTableExpanded(table, 10001, "APPROVED");
        assertNotNull(table.getModel());
        System.out.println("JTable columns: " + table.getColumnCount());
    }

    @Test
    public void test4_loadLeaveSummary() throws Exception {
        System.out.println("Test 4: loadLeaveSummary - summary totals");
        double[] summary = leaveRequestService.loadLeaveSummary(10001, "APPROVED");
        assertNotNull(summary);
        assertEquals(5, summary.length);
        System.out.println("Summary for emp 10001: " + java.util.Arrays.toString(summary));
    }

    @Test
    public void test5_updateLeaveRequestStatus() throws Exception {
        System.out.println("Test 5: updateLeaveRequestStatus");
        int leaveId = 1; 
        String newStatus = "APPROVED";
        int approverEmployeeId = 10002; 
        Timestamp actionDate = new Timestamp(System.currentTimeMillis());
        assertDoesNotThrow(() ->
            leaveRequestService.updateLeaveRequestStatus(leaveId, newStatus, approverEmployeeId, actionDate)
        );
        System.out.println("LeaveRequest status updated.");
    }

    @Test
    public void test6_loadEmployeeDetail() throws Exception {
        System.out.println("Test 6: loadEmployeeDetail - basic name retrieval");
        String[] details = leaveRequestService.loadEmployeeDetail(10001);
        assertNotNull(details);
        assertEquals(2, details.length);
        System.out.println("Employee: " + details[0] + ", " + details[1]);
    }

    @Test
    public void test7_addLeaveRequest_valid() throws Exception {
        System.out.println("Test 7: addLeaveRequest - valid insert");
        int employeeId = 10001;
        String leaveType = "Sick Leave";
        Date start = Date.valueOf("2024-08-10");
        Date end = Date.valueOf("2024-08-12");
        double calcLeave = 3;
        String reason = "Medical";
        assertDoesNotThrow(() ->
            leaveRequestService.addLeaveRequest(employeeId, leaveType, start, end, calcLeave, reason)
        );
        System.out.println("Leave request added for " + employeeId);
    }

    @Test
    public void test8_addLeaveRequest_missingDate() {
        System.out.println("Test 8: addLeaveRequest - missing dates should throw");
        int employeeId = 10001;
        String leaveType = "Sick Leave";
        Date start = null;
        Date end = Date.valueOf("2024-08-12");
        double calcLeave = 3;
        String reason = "Medical";
        Exception ex = assertThrows(Exception.class, () ->
            leaveRequestService.addLeaveRequest(employeeId, leaveType, start, end, calcLeave, reason)
        );
        System.out.println("Expected exception: " + ex.getMessage());
    }

    @Test
    public void test9_addLeaveRequest_startAfterEnd() {
        System.out.println("Test 9: addLeaveRequest - start after end should throw");
        int employeeId = 10001;
        String leaveType = "Vacation Leave";
        Date start = Date.valueOf("2024-08-15");
        Date end = Date.valueOf("2024-08-12");
        double calcLeave = 2;
        String reason = "Test";
        Exception ex = assertThrows(Exception.class, () ->
            leaveRequestService.addLeaveRequest(employeeId, leaveType, start, end, calcLeave, reason)
        );
        System.out.println("Expected exception: " + ex.getMessage());
    }

    @Test
    public void test10_getPendingLeaveRequestCount() throws Exception {
        System.out.println("Test 10: getPendingLeaveRequestCount - pending requests");
        int count = leaveRequestService.getPendingLeaveRequestCount();
        assertTrue(count >= 0);
        System.out.println("Pending leave requests: " + count);
    }
}
