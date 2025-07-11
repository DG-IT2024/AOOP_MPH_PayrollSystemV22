package util;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import model.LeaveRequest_sp;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.MonthDay;

public class LeaveRequestUtil {

    public static DefaultTableModel loadToJTable(List<LeaveRequest_sp> leaves) {
        String[] columnNames = {
            "Leave ID", "Status", "Request Date", "Type", "Reason", "Start Date", "End Date", "Leave Count"
        };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (LeaveRequest_sp leave : leaves) {
            Object[] row = new Object[]{
                leave.getLeaveId(),
                leave.getLeaveStatus(),
                leave.getRequestDate(),
                leave.getLeaveType(),
                leave.getReason(),
                leave.getStartDate(),
                leave.getEndDate(),
                leave.getCalcLeave()
            };
            model.addRow(row);
        }
        return model; // <-- ADD THIS LINE
    }

    public static DefaultTableModel loadToJTableExpanded(List<LeaveRequest_sp> leaves) {
        String[] columnNames = {
            "Leave ID", "Employee ID", "Last Name", "First Name", "Status", "Request Date",
            "Type", "Reason", "Start Date", "End Date", "Leave Count",
            "Approver", "Approved Date"
        };
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (LeaveRequest_sp leave : leaves) {
            Object[] row = new Object[]{
                leave.getLeaveId(),
                leave.getEmployeeId(),
                leave.getLastName(),
                leave.getFirstName(),
                leave.getLeaveStatus(),
                leave.getRequestDate(),
                leave.getLeaveType(),
                leave.getReason(),
                leave.getStartDate(),
                leave.getEndDate(),
                leave.getCalcLeave(),
                leave.getApprover(),
                leave.getApprovedDate()
            };
            model.addRow(row);
        }
        return model;
    }

    public static double[] computeLeaveTotals(int empID, List<LeaveRequest_sp> leaves) {

        int sickLeaveTotal = 0;
        int vacationLeaveTotal = 0;
        int paternityLeaveTotal = 0;
        int maternityLeaveTotal = 0;
        int otherLeaveTotal = 0;

        for (LeaveRequest_sp leave : leaves) {
            if ((leave.getEmployeeId() == empID) && leave.getLeaveStatus().equals("APPROVED")) {
                switch (leave.getLeaveType()) {
                    case "Sick Leave" ->
                        sickLeaveTotal += leave.getCalcLeave();
                    case "Vacation Leave" ->
                        vacationLeaveTotal += leave.getCalcLeave();
                    case "Paternity Leave" ->
                        paternityLeaveTotal += leave.getCalcLeave();
                    case "Maternity Leave" ->
                        maternityLeaveTotal += leave.getCalcLeave();
                    default ->
                        otherLeaveTotal += leave.getCalcLeave();
                }
            }
        }

        return new double[]{sickLeaveTotal, vacationLeaveTotal, paternityLeaveTotal, maternityLeaveTotal, otherLeaveTotal};
    }

    public static Timestamp getCurrentTimestamp() {
        // Truncate to seconds to match the format
        LocalDateTime now = LocalDateTime.now().withNano(0);
        return Timestamp.valueOf(now);
    }

    public static void pendingLeaveCounter()    {

    }

}
