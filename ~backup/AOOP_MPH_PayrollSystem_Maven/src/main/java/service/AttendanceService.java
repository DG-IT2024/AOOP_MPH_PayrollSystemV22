package service;

import dao.AttendanceDAO;
import model.Attendance;
import java.sql.*;
import java.util.List;
import util.DBConnect;
import java.sql.SQLException;
import model.Attendance_sp;

public class AttendanceService {

    private AttendanceDAO attendanceDAO;

    public AttendanceService() throws SQLException {
        Connection conn = DBConnect.getConnection();
        this.attendanceDAO = new AttendanceDAO(conn);
    }

    public Attendance readAttendance(int id) throws SQLException {
        return attendanceDAO.getAttendance(id);
    }

    public void updateAttendance(Attendance att) throws SQLException {
        attendanceDAO.updateAttendance(att);
    }

    public List<Attendance> listAllAttendance() throws SQLException {
        return attendanceDAO.getAllAttendanceRecords();
    }

    public List<Attendance_sp> listAttendanceByEmployeeAndDateRange(int employeeId, Date startDate, Date endDate) throws SQLException {
        return attendanceDAO.getAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
    }

    public List<Attendance_sp> listAllAttendanceByDateRange(int employeeId, Date startDate, Date endDate) throws SQLException {
        return attendanceDAO.getAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
    }

    public double getTotalRegularHours(int employeeId, Date startDate, Date endDate) throws SQLException {
        double regularTotal = 0.0;
        List<Attendance_sp> attendanceList = listAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
        for (Attendance_sp att : attendanceList) {
            if (att.getRegularHoursCalc() != null) {
                regularTotal += att.getRegularHoursCalc();
            }
        }
        return regularTotal;
    }

    public double getOvertimeRegularHours(int employeeId, Date startDate, Date endDate) throws SQLException {
        double overtimeTotal = 0.0;
        List<Attendance_sp> attendanceList = listAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
        for (Attendance_sp att : attendanceList) {
            if (att.getOvertimeHoursCalc() != null) {
                overtimeTotal += att.getOvertimeHoursCalc();
            }
        }
        return overtimeTotal;
    }

}
