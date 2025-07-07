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

     public static List<MonthDay> getPhilippineHolidays(int year) {
        List<MonthDay> holidays = new ArrayList<>();

        // Regular holidays
        holidays.add(MonthDay.of(1, 1));   // New Year's Day
        holidays.add(MonthDay.of(4, 9));   // Araw ng Kagitingan
        holidays.add(MonthDay.of(5, 1));   // Labor Day
        holidays.add(MonthDay.of(6, 12));  // Independence Day
        holidays.add(MonthDay.of(11, 30)); // Bonifacio Day
        holidays.add(MonthDay.of(12, 25)); // Christmas Day
        holidays.add(MonthDay.of(12, 30)); // Rizal Day

        // Special holidays
        holidays.add(MonthDay.of(2, 25));  // EDSA People Power Revolution Anniversary
        holidays.add(MonthDay.of(8, 21));  // Ninoy Aquino Day
        holidays.add(MonthDay.of(11, 1));  // All Saints' Day
        holidays.add(MonthDay.of(11, 2));  // All Souls' Day
        holidays.add(MonthDay.of(12, 8));  // Feast of the Immaculate Conception
        holidays.add(MonthDay.of(12, 24)); // Christmas Eve
        holidays.add(MonthDay.of(12, 31)); // New Year's Eve

        // Moveable holidays (examples for given years, adjust manually)
        if (year == 2020) {
            holidays.add(MonthDay.of(4, 9));  // Maundy Thursday 2020
            holidays.add(MonthDay.of(4, 10)); // Good Friday 2020
            holidays.add(MonthDay.of(4, 11)); // Black Saturday 2020
            holidays.add(MonthDay.of(1, 25)); // Chinese New Year 2020
            holidays.add(MonthDay.of(5, 24)); // Eid'l Fitr 2020 (adjust manually)
            holidays.add(MonthDay.of(7, 31)); // Eid'l Adha 2020 (adjust manually)
        } else if (year == 2021) {
            holidays.add(MonthDay.of(4, 1));  // Maundy Thursday 2021
            holidays.add(MonthDay.of(4, 2));  // Good Friday 2021
            holidays.add(MonthDay.of(4, 3));  // Black Saturday 2021
            holidays.add(MonthDay.of(2, 12)); // Chinese New Year 2021
            holidays.add(MonthDay.of(5, 13)); // Eid'l Fitr 2021 (adjust manually)
            holidays.add(MonthDay.of(7, 20)); // Eid'l Adha 2021 (adjust manually)
        } else if (year == 2022) {
            holidays.add(MonthDay.of(4, 14)); // Maundy Thursday 2022
            holidays.add(MonthDay.of(4, 15)); // Good Friday 2022
            holidays.add(MonthDay.of(4, 16)); // Black Saturday 2022
            holidays.add(MonthDay.of(2, 1));  // Chinese New Year 2022
            holidays.add(MonthDay.of(5, 3));  // Eid'l Fitr 2022 (adjust manually)
            holidays.add(MonthDay.of(7, 10)); // Eid'l Adha 2022 (adjust manually)
        } else if (year == 2023) {
            holidays.add(MonthDay.of(4, 6));  // Maundy Thursday 2023
            holidays.add(MonthDay.of(4, 7));  // Good Friday 2023
            holidays.add(MonthDay.of(4, 8));  // Black Saturday 2023
            holidays.add(MonthDay.of(1, 22)); // Chinese New Year 2023
            holidays.add(MonthDay.of(4, 21)); // Eid'l Fitr 2023 (adjust manually)
            holidays.add(MonthDay.of(6, 28)); // Eid'l Adha 2023 (adjust manually)
        } else if (year == 2024) {
            holidays.add(MonthDay.of(3, 28)); // Maundy Thursday 2024
            holidays.add(MonthDay.of(3, 29)); // Good Friday 2024
            holidays.add(MonthDay.of(3, 30)); // Black Saturday 2024
            holidays.add(MonthDay.of(2, 10)); // Chinese New Year 2024
            holidays.add(MonthDay.of(4, 10)); // Eid'l Fitr 2024 (adjust manually)
            holidays.add(MonthDay.of(6, 17)); // Eid'l Adha 2024 (adjust manually)
        }

        return holidays;
    }

    
}
