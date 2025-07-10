package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import model.Attendance;
import model.Attendance_sp;

public class AttendanceDAO {

    private Connection conn;

    public AttendanceDAO(Connection conn) {
        this.conn = conn;
    }

    private Attendance_sp mapAttendance(ResultSet rs) throws SQLException {
        Attendance_sp att = new Attendance_sp();
        att.setAttendanceId(rs.getInt("attendance_id"));
        att.setEmployeeId(rs.getInt("employee_id"));
        att.setDate(rs.getDate("date"));
        att.setTimeIn(rs.getTime("time_in"));
        att.setTimeOut(rs.getTime("time_out"));
        att.setRegularHoursCalc(rs.getDouble("regular_hours_calc"));
        att.setOvertimeRate(rs.getObject("overtime_rate") != null ? rs.getDouble("overtime_rate") : null);
        att.setOvertimeHoursCalc(rs.getObject("overtime_hours_calc") != null ? rs.getDouble("overtime_hours_calc") : null);
        att.setOvertimeUpdatedDate(rs.getDate("overtime_updated_date")); // <-- FIXED
        att.setLastName(rs.getString("last_name"));
        att.setFirstName(rs.getString("first_name"));
        att.setOvertimeApproverId(rs.getObject("overtime_approver_id") != null ? rs.getInt("overtime_approver_id") : null); // <-- FIXED
        att.setOvertimeApproverLastName(rs.getString("overtime_approver_last_name")); // <-- FIXED
        att.setOvertimeApproverFirstName(rs.getString("overtime_approver_first_name")); // <-- FIXED
        return att;
    }

    public List<Attendance_sp> getAttendanceByEmployeeAndDateRange(int employeeId, Date startDate, Date endDate) throws SQLException {
        String sql = "{CALL sp_attendance(?,?,?)}";
        List<Attendance_sp> attendanceList = new ArrayList<>();
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, employeeId);
            stmt.setDate(2, startDate);
            stmt.setDate(3, endDate);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Attendance_sp attendance = mapAttendance(rs);
                    attendanceList.add(attendance);
                }
            }
        }
        return attendanceList;
    }

    public List<Attendance_sp> getAllAttendanceByDateRange(int employeeId, Date startDate, Date endDate) throws SQLException {
        String sql = "{CALL sp_attendance(null,?,?)}";
        List<Attendance_sp> attendanceList = new ArrayList<>();
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, employeeId);
            stmt.setDate(2, startDate);
            stmt.setDate(3, endDate);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Attendance_sp attendance = mapAttendance(rs);
                    attendanceList.add(attendance);
                }
            }
        }
        return attendanceList;
    }

    public Attendance_sp getAllAttendance(int employeeId, Date startDate, Date endDate) throws SQLException {
        String sql = "{CALL sp_attendance(?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, employeeId);

            if (startDate != null) {
                stmt.setDate(2, startDate);
            } else {
                stmt.setNull(2, java.sql.Types.DATE);
            }

            if (endDate != null) {
                stmt.setDate(3, endDate);
            } else {
                stmt.setNull(3, java.sql.Types.DATE);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Attendance_sp attendance = mapAttendance(rs);
                    return attendance;
                }
            }
        }
        return null;
    }

    // using Attendance Table
    // Basic attendance mapping (no overtime info)
    private Attendance mapBasicAttendance(ResultSet rs) throws SQLException {
        Attendance att = new Attendance();
        att.setAttendanceId(rs.getInt("attendance_id"));
        att.setEmployeeId(rs.getInt("employee_id"));
        att.setDate(rs.getDate("date"));
        att.setTimeIn(rs.getTime("time_in"));
        att.setTimeOut(rs.getTime("time_out"));
        att.setRegularHoursCalc(rs.getDouble("regular_hours_calc"));
        return att;
    }

    public void addAttendance(Attendance att) throws SQLException {
        String sql = "INSERT INTO attendance (employee_id, date, time_in, time_out, regular_hours_calc) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, att.getEmployeeId());
        stmt.setDate(2, att.getDate());
        stmt.setTime(3, att.getTimeIn());
        stmt.setTime(4, att.getTimeOut());
        stmt.setDouble(5, att.getRegularHoursCalc());
        stmt.executeUpdate();
    }

    public Attendance getAttendance(int attendanceId) throws SQLException {
        String sql = "SELECT * FROM attendance WHERE attendance_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, attendanceId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return mapBasicAttendance(rs);
        }
        return null;
    }

    public void updateAttendance(Attendance att) throws SQLException {
        String sql = "UPDATE attendance SET employee_id=?, date=?, time_in=?, time_out=?, regular_hours_calc=? WHERE attendance_id=?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, att.getEmployeeId());
        stmt.setDate(2, att.getDate());
        stmt.setTime(3, att.getTimeIn());
        stmt.setTime(4, att.getTimeOut());
        stmt.setDouble(5, att.getRegularHoursCalc());
        stmt.setInt(6, att.getAttendanceId());
        stmt.executeUpdate();
    }

    public List<Attendance> getAllAttendanceRecords() throws SQLException {
        List<Attendance> attendanceList = new ArrayList<>();
        String sql = "SELECT * FROM attendance";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                attendanceList.add(mapBasicAttendance(rs));
            }
        }
        return attendanceList;
    }

    public Attendance getAttendanceRecordById(int attendanceId) throws SQLException {
        String sql = "SELECT * FROM attendance WHERE attendance_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, attendanceId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapBasicAttendance(rs);
                }
            }
        }
        return null;
    }

    public void updateAttendanceOvertimeFields(
            int attendanceId,
            Time timeIn,
            Time timeOut,
            Double otRate,
            Date overtimeUpdatedDate,
            Integer overtimeApproverId
    ) throws SQLException {
        String sql = "{CALL sp_update_attendance(?, ?, ?, null, ?, null, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, attendanceId);

            if (timeIn != null) {
                stmt.setTime(2, timeIn);
            } else {
                stmt.setNull(2, java.sql.Types.TIME);
            }

            if (timeOut != null) {
                stmt.setTime(3, timeOut);
            } else {
                stmt.setNull(3, java.sql.Types.TIME);
            }
            if (otRate != null) {
                stmt.setDouble(4, otRate);
            } else {
                stmt.setNull(4, java.sql.Types.DOUBLE);
            }

            if (overtimeUpdatedDate != null) {
                stmt.setDate(5, overtimeUpdatedDate);
            } else {
                stmt.setNull(5, java.sql.Types.DATE);
            }

            if (overtimeApproverId != null) {
                stmt.setInt(6, overtimeApproverId);
            } else {
                stmt.setNull(6, java.sql.Types.INTEGER);
            }

            stmt.executeUpdate();
        }
    }

}
