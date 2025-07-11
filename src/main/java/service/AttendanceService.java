package service;

import dao.AttendanceDAO;
import model.Attendance;
import java.sql.*;
import java.util.List;
import util.DBConnect;
import java.sql.SQLException;
import java.time.LocalTime;

import model.Attendance_sp;

public class AttendanceService {

    private AttendanceDAO attendanceDAO;

    public AttendanceService() throws SQLException {
        Connection conn = DBConnect.getConnection();
        this.attendanceDAO = new AttendanceDAO(conn);
    }

    public Attendance_sp readAttendance(int id, Date startDate, Date endDate) throws SQLException {
        return attendanceDAO.getAllAttendance(id, startDate, endDate);
    }

    public List<Attendance_sp> listAttendanceByEmployeeAndDateRange(int employeeId, Date startDate, Date endDate) throws SQLException {
        return attendanceDAO.getAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
    }

    public static int calculateWorkedHours(String timeIn, String timeOut) {
        LocalTime parsedTimeIn = LocalTime.parse(timeIn);
        LocalTime parsedTimeOut = LocalTime.parse(timeOut);

        int gracePeriod = 10;
        LocalTime officeStart = LocalTime.of(8, 0);
        LocalTime targetTime = LocalTime.of(8, gracePeriod + 1);

        if (parsedTimeIn.isBefore(targetTime) && parsedTimeIn.getHour() == officeStart.getHour()) {
            parsedTimeIn = officeStart;
        }

        LocalTime breakStart = LocalTime.of(12, 0);
        LocalTime breakEnd = LocalTime.of(13, 0);

        if (parsedTimeIn.isBefore(breakStart) && parsedTimeOut.isBefore(LocalTime.of(12, 59))) {
            parsedTimeOut = breakStart;
        }
        if (parsedTimeIn.isAfter(LocalTime.of(11, 59)) && parsedTimeOut.isAfter(breakEnd)) {
            parsedTimeIn = breakEnd;
        }

        int workedMinutes = (parsedTimeOut.getHour() * 60 + parsedTimeOut.getMinute())
                - (parsedTimeIn.getHour() * 60 + parsedTimeIn.getMinute());

        int workedHour = workedMinutes / 60;

        int breakTime = 0;
        if (parsedTimeIn.isBefore(breakStart) && parsedTimeOut.isAfter(LocalTime.of(12, 59))
                || (parsedTimeIn.equals(breakStart) && parsedTimeOut.equals(breakEnd))) {
            breakTime = 1;
        }

        return workedHour - breakTime;
    }

    public double getRegularHours(String timeIn, String timeOut) {
        int workedHours = calculateWorkedHours(timeIn, timeOut);
        int regularHours = Math.min(workedHours, 8);
        return regularHours;
    }

    public double getOvertimeHours(String timeIn, String timeOut) {
        int workedHours = calculateWorkedHours(timeIn, timeOut);
        int overtimeHours = Math.max(workedHours - 8, 0);
        return overtimeHours;
    }

    public double getRegularHours(int employeeId, Date startDate, Date endDate) throws SQLException {
        double regularTotal = 0.0;
        List<Attendance_sp> attendanceList = listAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
        for (Attendance_sp att : attendanceList) {
            if (att.getRegularHoursCalc() != null) {
                regularTotal += att.getRegularHoursCalc();
            }
        }
        return regularTotal;
    }

    public double getOvertimeHours(int employeeId, Date startDate, Date endDate) throws SQLException {
        double overtimeTotal = 0.0;
        List<Attendance_sp> attendanceList = listAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
        for (Attendance_sp att : attendanceList) {
            if (att.getOvertimeHoursCalc() != null) {
                overtimeTotal += att.getOvertimeHoursCalc();
            }
        }
        return overtimeTotal;
    }

    public void updateAttendance(Attendance att) throws SQLException {
        attendanceDAO.updateAttendance(att);
    }

    public List<Attendance> listAllAttendance() throws SQLException {
        return attendanceDAO.getAllAttendanceRecords();
    }

    public void updateAttendanceOvertimeFields(
            int attendanceId,
            Time timeIn,
            Time timeOut,
            Double otRate,
            Date overtimeUpdatedDate,
            Integer overtimeApproverId
    ) throws SQLException {
        attendanceDAO.updateAttendanceOvertimeFields(
                attendanceId, timeIn, timeOut, otRate, overtimeUpdatedDate, overtimeApproverId
        );
    }

//   
}
