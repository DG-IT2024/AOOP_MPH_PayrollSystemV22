package service;

//Even if user entered overtime hour rate it will not be accepted if there is no overtime hours. 
//by default overtime rate is 1.25
//user have the option to update the time-in, time out, overtime rate using the update button.
import dao.AttendanceDAO;
import model.Attendance;
import java.sql.*;
import java.util.List;
import util.DBConnect;
import java.sql.SQLException;
import java.sql.Time;
import java.time.DayOfWeek;
import java.time.LocalDate;
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

//    
    public static int calculateWorkedHours(Time timeIn, Time timeOut) {
        LocalTime parsedTimeIn = timeIn.toLocalTime();
        LocalTime parsedTimeOut = timeOut.toLocalTime();

        int gracePeriod = 10;
        LocalTime officeStart = LocalTime.of(8, 0);
        LocalTime graceLimit = officeStart.plusMinutes(gracePeriod);

        // Apply grace period: if employee times in at 8:00–8:10, count as 8:00
        if (!parsedTimeIn.isAfter(graceLimit) && parsedTimeIn.getHour() == officeStart.getHour()) {
            parsedTimeIn = officeStart;
        }

        LocalTime breakStart = LocalTime.of(12, 0);
        LocalTime breakEnd = LocalTime.of(13, 0);

        // Only snap parsedTimeOut to breakStart (12:00) if it falls WITHIN lunch break, not before 12:00
        if (parsedTimeIn.isBefore(breakStart)
                && (parsedTimeOut.equals(breakStart)
                || (parsedTimeOut.isAfter(breakStart) && parsedTimeOut.isBefore(breakEnd)))) {
            parsedTimeOut = breakStart;
        }

        // If work starts during break and ends after break, snap start to breakEnd
        if (parsedTimeIn.isAfter(breakStart.minusMinutes(1)) && parsedTimeIn.isBefore(breakEnd) && parsedTimeOut.isAfter(breakEnd.minusSeconds(1))) {
            parsedTimeIn = breakEnd;
        }

        int workedMinutes = (parsedTimeOut.getHour() * 60 + parsedTimeOut.getMinute())
                - (parsedTimeIn.getHour() * 60 + parsedTimeIn.getMinute());

        int workedHours = workedMinutes / 60;

        int breakTime = 0;
        // Deduct 1 hour if the worked period spans the lunch break (12:00–13:00)
        if (parsedTimeIn.isBefore(breakStart) && parsedTimeOut.isAfter(breakEnd.minusSeconds(1))) {
            breakTime = 1;
        }

        return workedHours - breakTime;
    }

    public double getRegularHours(Time timeIn, Time timeOut) {
        int workedHours = calculateWorkedHours(timeIn, timeOut);
        int regularHours = Math.min(workedHours, 8);
        return regularHours;
    }

    public double getOvertimeHours(Time timeIn, Time timeOut) {
        int workedHours = calculateWorkedHours(timeIn, timeOut);
        int overtimeHours = Math.max(workedHours - 8, 0);
        return overtimeHours;
    }

    public void calculateRegularOvertimeHours(int employeeId, Date startDate, Date endDate) throws SQLException {
        List<Attendance_sp> attendanceList = listAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
        for (Attendance_sp att : attendanceList) {
            if (att != null) {
                Time timeIn = att.getTimeIn();
                Time timeOut = att.getTimeOut();
//                Double regularHours = getRegularHours(timeIn, timeOut);
                Double regularHours = getRegularHours(timeIn, timeOut);
                regularHours = (regularHours < 0) ? 0.0 : regularHours;

                Double overtimeHours = getOvertimeHours(timeIn, timeOut);
                Double overtimeRateObj = att.getOvertimeRate();
                Double otRate = (overtimeRateObj != null) ? overtimeRateObj : 0.0;
//                if (overtimeHours != null && overtimeHours > 0) {
//                    if (att.getOvertimeRate() > 1.25) {
//                        otRate = att.getOvertimeRate(); // don't change it
//                    } else {
//                        otRate = 1.25;
//                    }
//                } else {
//                    otRate = 0.0;
//                }

                attendanceDAO.updateAttendance(att.getAttendanceId(), regularHours, otRate, overtimeHours);

//                System.out.println("Attendance ID: " + att.getAttendanceId()
//                        + " | otRat: " + otRate
//                        + " | overtimeHours: " + overtimeHours);
            }
        }
    }

    public Time[] getTimeInAndTimeOut(int attendanceId) throws SQLException {
        Attendance attendance = attendanceDAO.getAttendanceRecordById(attendanceId);
        if (attendance == null) {
            return null; // or throw an exception
        }
        Time[] result = new Time[2];
        result[0] = attendance.getTimeIn();
        result[1] = attendance.getTimeOut();
        return result;
    }

    public double updateRegularOvertimeHours(int employeeId, Date startDate, Date endDate) throws SQLException {
        double regularTotal = 0.0;
        List<Attendance_sp> attendanceList = listAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
        for (Attendance_sp att : attendanceList) {
            if (att.getRegularHoursCalc() != null) {
                regularTotal += att.getRegularHoursCalc();
            }
        }
        return regularTotal;
    }

    public double getRegularHours(int employeeId, Date startDate, Date endDate) throws SQLException {
        double regularTotal = 0.0;
        List<Attendance_sp> attendanceList = listAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
        for (Attendance_sp att : attendanceList) {
            if (att.getRegularHoursCalc() != null && att.getRegularHoursCalc() > 0) {
                regularTotal += att.getRegularHoursCalc();
            }
        }
        return regularTotal;
    }

    public double getOvertimeHours(int employeeId, Date startDate, Date endDate) throws SQLException {
        double overtimeTotal = 0.0;
        List<Attendance_sp> attendanceList = listAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
        for (Attendance_sp att : attendanceList) {
            if (att.getOvertimeHoursCalc() != null && att.getOvertimeRate() > 0) {
//            if (att.getOvertimeHoursCalc() != null ) {
                overtimeTotal += att.getOvertimeHoursCalc();
            }
        }
        return overtimeTotal;

    }

    //Product of overtime hours and overtime rate
    public double getWeightedOvertimes(int employeeId, Date startDate, Date endDate) throws SQLException {
        double weightedOvertimeTotal = 0.0;
        List<Attendance_sp> attendanceList = listAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
        for (Attendance_sp att : attendanceList) {
            if (att.getOvertimeHoursCalc() != null) {
                weightedOvertimeTotal += att.getOvertimeHoursCalc() * att.getOvertimeRate();
            }
        }
        return weightedOvertimeTotal;

    }

    public List<Attendance> listAllAttendance() throws SQLException {
        return attendanceDAO.getAllAttendanceRecords();
    }

    public void updateAttendanceOvertimeField(
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

    public int getWorkingDays(Date sqlStartDate) {
        int workingDays = 0;

        LocalDate localDate = sqlStartDate.toLocalDate();

        int year = localDate.getYear();
        int month = localDate.getMonthValue();

        LocalDate date = LocalDate.of(year, month, 1);
        int lengthOfMonth = date.lengthOfMonth();
        for (int day = 1; day <= lengthOfMonth; day++) {
            LocalDate current = LocalDate.of(year, month, day);
            if (current.getDayOfWeek() != DayOfWeek.SUNDAY) {
                workingDays++;
            }
        }
        return workingDays;
    }

    public void addAttendance(Attendance att) {
        try {
            attendanceDAO.addAttendance(att);
        } catch (SQLException e) {
            System.err.println("Error adding attendance: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
//   
}
