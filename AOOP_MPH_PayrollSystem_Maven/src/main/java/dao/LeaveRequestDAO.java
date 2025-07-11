package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.LeaveRequest_sp;

public class LeaveRequestDAO {

    private Connection conn;

    public LeaveRequestDAO(Connection conn) {
        this.conn = conn;
    }

    public List<LeaveRequest_sp> getLeaveRequests(Integer employeeId, String status) throws SQLException {
        List<LeaveRequest_sp> leaveRequests = new ArrayList<>();
        String sql = "{CALL sp_leave_request(?, ?)}";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            // Set employeeId parameter
            if (employeeId == null) {
                cs.setNull(1, java.sql.Types.INTEGER);
            } else {
                cs.setInt(1, employeeId);
            }
            // Set status parameter
            if (status == null) {
                cs.setNull(2, java.sql.Types.VARCHAR);
            } else {
                cs.setString(2, status);
            }
            try (ResultSet rs = cs.executeQuery()) {
                while (rs.next()) {
                    LeaveRequest_sp leave = new LeaveRequest_sp(
                            rs.getInt("entry_id"),
                            rs.getInt("employee_id"),
                            rs.getString("last_name"),
                            rs.getString("first_name"),
                            rs.getString("leave_status"),
                            rs.getTimestamp("request_date"),
                            rs.getString("leave_type"),
                            rs.getString("reason"),
                            rs.getDate("start_date"),
                            rs.getDate("end_date"),
                            rs.getDouble("calc_leave"),
                            rs.getString("approver"),
                            rs.getTimestamp("approved_date")
                    );
                    leaveRequests.add(leave);
                }
            }
        }
        return leaveRequests;
    }

    public void updateLeaveRequest(int leaveId, String status, int appproverEmployeeId, Timestamp approvedDate) throws SQLException {
        String sql = "{CALL sp_leave_update(?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, leaveId);
            stmt.setString(2, status);
            stmt.setInt(3, appproverEmployeeId);
            if (approvedDate != null) {
                stmt.setTimestamp(4, approvedDate);
            } else {
                stmt.setNull(4, java.sql.Types.TIMESTAMP);
            }
            stmt.execute();
        }
    }

    public void addLeaveRequest(
            int employeeId,
            String leaveType,
            Date startDate,
            Date endDate,
            double calcLeave,
            String reason
    ) throws SQLException {
        String sql = "{CALL sp_leave_add(?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, employeeId);
            stmt.setString(2, leaveType);
            stmt.setDate(3, startDate);
            stmt.setDate(4, endDate);
            stmt.setDouble(5, calcLeave);
            stmt.setString(6, reason);
            stmt.execute();
        }
    }

   
}
