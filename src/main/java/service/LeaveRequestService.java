package service;

import dao.LeaveRequestDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.LeaveRequest_sp;
import util.DBConnect;
import util.LeaveRequestUtil;
import java.sql.Timestamp;
import java.sql.Date;

public class LeaveRequestService {

    private LeaveRequestDAO leaveRequestDAO;

    public LeaveRequestService() throws SQLException {
        Connection conn = DBConnect.getConnection();
        this.leaveRequestDAO = new LeaveRequestDAO(conn);
    }

    public List<LeaveRequest_sp> listLeaveRequests(Integer employeeId, String status) throws SQLException {
        return leaveRequestDAO.getLeaveRequests(employeeId, status);
    }

    public void loadLeaveToTable(JTable table, Integer employeeId, String status) throws SQLException {
        List<LeaveRequest_sp> leaveRequest = listLeaveRequests(employeeId, status);
        DefaultTableModel model = LeaveRequestUtil.loadToJTable(leaveRequest);
        table.setModel(model);
    }

    public void loadLeaveToTableExpanded(JTable table, Integer employeeId, String status) throws SQLException {
        List<LeaveRequest_sp> leaveRequest = listLeaveRequests(employeeId, status);
        DefaultTableModel model = LeaveRequestUtil.loadToJTableExpanded(leaveRequest);
        table.setModel(model);
    }

    public double[] loadLeaveSummary(int employeeId, String status) throws SQLException {
        List<LeaveRequest_sp> leaveRequest = listLeaveRequests(employeeId, status);
        double[] leaveSummary = LeaveRequestUtil.computeLeaveTotals(employeeId, leaveRequest);

        return leaveSummary;
    }

    public void updateLeaveRequestStatus(int leaveId, String status, int approverEmployeeId, Timestamp actionDate) throws SQLException {
        leaveRequestDAO.updateLeaveRequest(leaveId, status, approverEmployeeId, actionDate);
    }

    public String[] loadEmployeeDetail(int employeeId) throws SQLException {
        List<LeaveRequest_sp> leaveRequests = listLeaveRequests(employeeId, null);

        for (LeaveRequest_sp request : leaveRequests) {
            if (request.getEmployeeId() == employeeId) {
                String lastName = request.getLastName();
                String firstName = request.getFirstName();
                return new String[]{lastName, firstName};
            }
        }
        // If no record is found, return empty or default values
        return new String[]{"", ""};
    }

    public void addLeaveRequest(int employeeId, String leaveType, Date startDate, Date endDate, double calcLeave, String reason) throws Exception {

        // Defensive: Check if dates are selected
        if (startDate == null || endDate == null) {
            throw new Exception("Please select both start and end dates.");
        }

        // Defensive: Ensure start date is not after end date
        if (startDate.after(endDate)) {
            throw new Exception("Start date should not be after end date.");
        }

        leaveRequestDAO.addLeaveRequest(employeeId, leaveType, startDate, endDate, calcLeave, reason);
    }

    
     public int getPendingLeaveRequestCount() throws SQLException {
        List<LeaveRequest_sp> pendingRequests = leaveRequestDAO.getLeaveRequests(null, "PENDING");
        return pendingRequests.size();
    }

  
}
