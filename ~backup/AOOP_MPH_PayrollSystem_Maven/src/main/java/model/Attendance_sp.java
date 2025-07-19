package model;

import java.sql.Date;
import java.sql.Time;

public class Attendance_sp {

    private int attendanceId;
    private int employeeId;
    private Date Date;
    private Time timeIn;
    private Time timeOut;
    private Double regularHoursCalc;
    private Integer overtimeRate; 
    private Double overtimeHoursCalc;
    private Date overtimeUpdatedDate;
    private String lastName;
    private String firstName;
    private Integer overtimeApproverId;
    private String overtimeApproverLastName;
    private String overtimeApproverFirstName;

    public Attendance_sp(){}
    
    // Full Constructor
    public Attendance_sp(
            int attendanceId,
            int employeeId,
            Date Date,
            Time timeIn,
            Time timeOut,
            Double regularHoursCalc,
            Integer overtimeRate,
            Double overtimeHoursCalc,
            Date overtimeUpdatedDate,
            String lastName,
            String firstName,
            Integer overtimeApproverId,
            String overtimeApproverLastName,
            String overtimeApproverFirstName
    ) {
        this.attendanceId = attendanceId;
        this.employeeId = employeeId;
        this.Date = Date;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.regularHoursCalc = regularHoursCalc;
        this.overtimeRate = overtimeRate;
        this.overtimeHoursCalc = overtimeHoursCalc;
        this.overtimeUpdatedDate = overtimeUpdatedDate;
        this.lastName = lastName;
        this.firstName = firstName;
        this.overtimeApproverId = overtimeApproverId;
        this.overtimeApproverLastName = overtimeApproverLastName;
        this.overtimeApproverFirstName = overtimeApproverFirstName;
    }

    // Getters and Setters
    public int getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(int attendanceId) {
        this.attendanceId = attendanceId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public Time getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Time timeIn) {
        this.timeIn = timeIn;
    }

    public Time getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Time timeOut) {
        this.timeOut = timeOut;
    }

    public Double getRegularHoursCalc() {
        return regularHoursCalc;
    }

    public void setRegularHoursCalc(Double regularHoursCalc) {
        this.regularHoursCalc = regularHoursCalc;
    }

    public Integer getOvertimeRate() {
        return overtimeRate;
    }

    public void setOvertimeRate(Integer overtimeRate) {
        this.overtimeRate = overtimeRate;
    }

    public Double getOvertimeHoursCalc() {
        return overtimeHoursCalc;
    }

    public void setOvertimeHoursCalc(Double overtimeHoursCalc) {
        this.overtimeHoursCalc = overtimeHoursCalc;
    }

    public Date getOvertimeUpdatedDate() {
        return overtimeUpdatedDate;
    }

    public void setOvertimeUpdatedDate(Date overtimeUpdatedDate) {
        this.overtimeUpdatedDate = overtimeUpdatedDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getOvertimeApproverId() {
        return overtimeApproverId;
    }

    public void setOvertimeApproverId(Integer overtimeApproverId) {
        this.overtimeApproverId = overtimeApproverId;
    }

    public String getOvertimeApproverLastName() {
        return overtimeApproverLastName;
    }

    public void setOvertimeApproverLastName(String overtimeApproverLastName) {
        this.overtimeApproverLastName = overtimeApproverLastName;
    }

    public String getOvertimeApproverFirstName() {
        return overtimeApproverFirstName;
    }

    public void setOvertimeApproverFirstName(String overtimeApproverFirstName) {
        this.overtimeApproverFirstName = overtimeApproverFirstName;
    }
}
