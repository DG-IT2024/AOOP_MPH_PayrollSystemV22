package util;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Attendance;
import model.Attendance_sp;

public class AttendanceUtil {

    public interface TableModelBuilder<T> {
        DefaultTableModel toTableModel(List<T> list);
    }

    public static class AttendanceTableModelBuilder implements TableModelBuilder<Attendance> {
        @Override
        public DefaultTableModel toTableModel(List<Attendance> attendanceList) {
            String[] columnNames = {
                "Date", "Time In", "Time Out", "Regular Hours", "Overtime Hours"
            };
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            for (Attendance att : attendanceList) {
                String[] row = new String[]{
                    att.getDate() != null ? att.getDate().toString() : "",
                    att.getTimeIn() != null ? att.getTimeIn().toString() : "",
                    att.getTimeOut() != null ? att.getTimeOut().toString() : "",
                    String.valueOf(att.getRegularHoursCalc())
                };
                model.addRow(row);
            }
            return model;
        }
    }

    public static class AttendanceSPTableModelBuilder implements TableModelBuilder<Attendance_sp> {
        @Override
        public DefaultTableModel toTableModel(List<Attendance_sp> attendanceList) {
            String[] columnNames = {
                "Date", "Time In", "Time Out", "Regular Hours", "Overtime Hours"
            };
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            for (Attendance_sp att : attendanceList) {
                String[] row = new String[]{
                    att.getDate() != null ? att.getDate().toString() : "",
                    att.getTimeIn() != null ? att.getTimeIn().toString() : "",
                    att.getTimeOut() != null ? att.getTimeOut().toString() : "",
                    att.getRegularHoursCalc() != null ? att.getRegularHoursCalc().toString() : "",
                    att.getOvertimeHoursCalc() != null ? att.getOvertimeHoursCalc().toString() : ""
                };
                model.addRow(row);
            }
            return model;
        }
    }

    public static class AttendanceSPFullTableModelBuilder implements TableModelBuilder<Attendance_sp> {
        @Override
        public DefaultTableModel toTableModel(List<Attendance_sp> attendanceList) {
            String[] columnNames = {
                "Attendance ID", "Employee ID", "Date", "Time In", "Time Out",
                "Regular Hours", "Overtime Rate", "Overtime Hours",
                "Overtime Updated",
//                "Last Name", "First Name",
                "Overtime Approver ID", "OT Approver Last Name", "OT Approver First Name"
            };
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            for (Attendance_sp att : attendanceList) {
                Object[] row = {
                    att.getAttendanceId(),
                    att.getEmployeeId(),
                    att.getDate(),
                    att.getTimeIn(),
                    att.getTimeOut(),
                    att.getRegularHoursCalc(),
                    att.getOvertimeRate(),
                    att.getOvertimeHoursCalc(),
                    att.getOvertimeUpdatedDate(),
//                    att.getLastName(),
//                    att.getFirstName(),
                    att.getOvertimeApproverId(),
                    att.getOvertimeApproverLastName(),
                    att.getOvertimeApproverFirstName()
                };
                model.addRow(row);
            }
            return model;
        }
    }

    public static DefaultTableModel toTableModelTruncated(List<Attendance> attendanceList) {
        return new AttendanceTableModelBuilder().toTableModel(attendanceList);
    }

    public static DefaultTableModel toTableModel_sp(List<Attendance_sp> attendanceList) {
        return new AttendanceSPTableModelBuilder().toTableModel(attendanceList);
    }

    public static DefaultTableModel attendanceListToTableModel(List<Attendance_sp> attendanceList) {
        return new AttendanceSPFullTableModelBuilder().toTableModel(attendanceList);
    }

    public static DefaultTableModel toTableModel(List<Attendance> attendanceList) {
        return new AttendanceTableModelBuilder().toTableModel(attendanceList);
    }

    public double getTotalRegularHours(List<Attendance_sp> attendanceList) {
        double total = 0.0;
        for (Attendance_sp att : attendanceList) {
            if (att.getRegularHoursCalc() != null) {
                total += att.getRegularHoursCalc();
            }
        }
        return total;
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

        int totalMinutesIn = parsedTimeIn.getHour() * 60 + parsedTimeIn.getMinute();
        int totalMinutesOut = parsedTimeOut.getHour() * 60 + parsedTimeOut.getMinute();
        int workedMinutes = totalMinutesOut - totalMinutesIn;
        int workedHour = workedMinutes / 60;

        int breakTime = 0;
        if (parsedTimeIn.isBefore(breakStart) && parsedTimeOut.isAfter(LocalTime.of(12, 59))) {
            breakTime = 1;
        }
        if (parsedTimeIn.equals(breakStart) && parsedTimeOut.equals(breakEnd)) {
            breakTime = 1;
        }

        return workedHour - breakTime;
    }

    public static Integer regularWorkedHours(ArrayList<Integer> regularHoursList) {
        int totalRegularHour = 0;
        for (Integer hour : regularHoursList) {
            totalRegularHour += hour;
        }
        return totalRegularHour;
    }

    public static Integer overtimeHours(ArrayList<Integer> overtimeHoursList) {
        int totalOvertimeHour = 0;
        for (Integer hour : overtimeHoursList) {
            totalOvertimeHour += hour;
        }
        return totalOvertimeHour;
    }

    public static void regularOvertimeView(int workedregularHours, int workedOvertimeHours) {
        System.out.println("-".repeat(55));
        System.out.println("Regular Hours : " + workedregularHours);
        System.out.println("Overtime Hours : " + workedOvertimeHours);
        System.out.println("-".repeat(55));
    }

    public static double overtimeRateInput() {
        Scanner overtimeRateEntry = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("\nEnter Overtime Pay rate: (Example 1.25)");
                System.out.println("(Set rate to 0 if you don't want to credit overtime hours)");
                double overtimeRate = Double.parseDouble(overtimeRateEntry.nextLine());

                if (overtimeRate < 0) {
                    System.out.println("--- Error: Invalid Input. Overtime rate must be non-negative. ---");
                    continue;
                }
                if (overtimeRate > 0 && overtimeRate < 1) {
                    System.out.println("--- Error: Invalid Input. Overtime rate must be greater than 1. ---");
                    continue;
                }
                return overtimeRate;
            } catch (NumberFormatException e) {
                System.out.println("--- Error: Invalid Input. Please enter a valid number. ---");
            }
        }
    }

    public static double weightedOvertimeHour(ArrayList<Integer> overtimeHoursList, ArrayList<Double> overtimeRateList) {
        double overtimeHourPay = 0;
        for (int i = 0; i < overtimeHoursList.size(); i++) {
            overtimeHourPay += overtimeHoursList.get(i) * overtimeRateList.get(i);
        }
        return overtimeHourPay;
    }

    public static boolean isValidTimeFormat(String time) {
        return time.matches("\\d{2}:\\d{2}") || time.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
    }

    public static ArrayList<Integer> getAttendanceIdsFromTable(JTable table) {
        ArrayList<Integer> attendanceIds = new ArrayList<>();
        int rowCount = table.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            Object value = table.getValueAt(i, 0); 
            if (value != null) {
                try {
                    attendanceIds.add(Integer.valueOf(value.toString()));
                } catch (NumberFormatException ex) {
                    // Skip invalid values
                }
            }
        }
        return attendanceIds;
    }
}
