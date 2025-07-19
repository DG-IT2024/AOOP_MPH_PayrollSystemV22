package model;

import java.sql.Date;
import java.sql.Timestamp;

public class LeaveRequest_sp {

    private int leaveId;
    private int employeeId;
    private String lastName;
    private String firstName;
    private String leaveStatus;
    private Timestamp requestDate;
    private String leaveType;
    private String reason;
    private Date startDate;
    private Date endDate;
    private double calcLeave;
    private String approver;
    private Timestamp approvedDate;

    // No-args constructor
    public LeaveRequest_sp() {
    }

    // All-args constructor
    public LeaveRequest_sp(int leaveId, int employeeId, String lastName, String firstName, String leaveStatus,
            Timestamp requestDate, String leaveType, String reason, Date startDate, Date endDate,
            double calcLeave, String approver, Timestamp approvedDate) {
        this.leaveId = leaveId;
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.leaveStatus = leaveStatus;
        this.requestDate = requestDate;
        this.leaveType = leaveType;
        this.reason = reason;
        this.startDate = startDate;
        this.endDate = endDate;
        this.calcLeave = calcLeave;
        this.approver = approver;
        this.approvedDate = approvedDate;
    }

    public int getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(int leaveId) {
        this.leaveId = leaveId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public String getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getCalcLeave() {
        return calcLeave;
    }

    public void setCalcLeave(double calcLeave) {
        this.calcLeave = calcLeave;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Timestamp getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Timestamp approvedDate) {
        this.approvedDate = approvedDate;
    }
}
