package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
        att.setOvertimeRate(rs.getObject("overtime_rate") != null ? rs.getInt("overtime_rate") : null);
        att.setOvertimeHoursCalc(rs.getObject("overtime_hours_calc") != null ? rs.getDouble("overtime_hours_calc") : null);
        att.setOvertimeUpdatedDate(rs.getDate("overtime_updated_date")); // <-- FIXED
        att.setLastName(rs.getString("last_name"));
        att.setFirstName(rs.getString("first_name"));
        att.setOvertimeApproverId(rs.getObject("overtime_approver_id") != null ? rs.getInt("overtime_approver_id") : null); // <-- FIXED
        att.setOvertimeApproverLastName(rs.getString("overtime_approver_last_name")); // <-- FIXED
        att.setOvertimeApproverFirstName(rs.getString("overtime_approver_first_name")); // <-- FIXED
        return att;
    }

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
    

//    // Get attendance by employee and date range using stored procedure sp_attendance
//    public List<Attendance> getAttendanceByEmployeeAndDateRange(int employeeId, Date startDate, Date endDate) throws SQLException {
//        List<Attendance> attendances = new ArrayList<>();
//        String sql = "{CALL sp_attendance(?, ?, ?)}";
//        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setInt(1, employeeId);
//            stmt.setDate(2, startDate);
//            stmt.setDate(3, endDate);
//            try (ResultSet rs = stmt.executeQuery()) {
//                while (rs.next()) {
//                    attendances.add(mapAttendance(rs)); // Make sure mapAttendance maps all fields returned by the procedure
//                }
//            }
//        }
//        return attendances;
//    }
    // Get attendance with overtime and approver details for employee and date range
//    public List<Attendance> getAttendanceWithOvertimeAndApprover(int employeeId, Date startDate, Date endDate) throws SQLException {
//        List<Attendance> attendances = new ArrayList<>();
//        String sql
//                = "SELECT a.attendance_id, a.employee_id, a.date, a.time_in, a.time_out, a.regular_hours_calc, "
//                + "o.otrate_id, o.overtime_hours_calc, o.updated_date, "
//                + "e.last_name, e.first_name, o.approver_id, eo.last_name AS approver_last_name, eo.first_name AS approver_first_name "
//                + "FROM attendance a "
//                + "LEFT JOIN overtime o ON a.attendance_id = o.attendance_id "
//                + "JOIN employee e ON a.employee_id = e.employee_id "
//                + "LEFT JOIN employee eo ON o.approver_id = eo.employee_id "
//                + "WHERE a.employee_id = ? AND a.date BETWEEN ? AND ?";
//        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setInt(1, employeeId);
//            stmt.setDate(2, startDate);
//            stmt.setDate(3, endDate);
//            try (ResultSet rs = stmt.executeQuery()) {
//                while (rs.next()) {
//                    attendances.add(mapAttendance(rs));
//                }
//            }
//        }
//        return attendances;
//    }
//}
//    public void addAttendance(Attendance att) throws SQLException {
//        String sql = "INSERT INTO attendance (employee_id, date, time_in, time_out, regular_hours_calc) VALUES (?, ?, ?, ?, ?)";
//        PreparedStatement stmt = conn.prepareStatement(sql);
//        stmt.setInt(1, att.getEmployeeId());
//        stmt.setDate(2, att.getDate());
//        stmt.setTime(3, att.getTimeIn());
//        stmt.setTime(4, att.getTimeOut());
//        stmt.setInt(5, att.getRegularHoursCalc());
//        stmt.executeUpdate();
//    }
}
