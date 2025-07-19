package controller;

import service.AttendanceService;
import model.Attendance;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Attendance_sp;
import util.AttendanceUtil;

public class AttendanceController {

    private AttendanceService service;

    public AttendanceController(AttendanceService service) {
        this.service = service;
    }

    public void loadAttendanceToTable(JTable table) {
        try {
            List<Attendance> attendance = service.listAllAttendance();
            DefaultTableModel model = AttendanceUtil.toTableModel(attendance);
            table.setModel(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadAttendanceToFilteredTable(JTable table, int employeeId, Date startDate, Date endDate) throws SQLException {
        List<Attendance_sp> attendance = service.listAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
        DefaultTableModel model = AttendanceUtil.attendanceListToTableModel(attendance);
        table.setModel(model);
    }

    public void loadBasicAttendanceToFilteredTable(JTable table, int employeeId, Date startDate, Date endDate) throws SQLException {
        List<Attendance_sp> attendance = service.listAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
        DefaultTableModel model = AttendanceUtil.toTableModel_sp(attendance);
        table.setModel(model);
    }

    public Attendance_sp getAttendance(int id, Date startDate, Date endDate) {
        try {
            return service.readAttendance(id, startDate, endDate);
        } catch (SQLException e) {
            return null;
        }
    }

//    public void modifyAttendance(Attendance att) {
//        try {
//            service.updateAttendance(att);
//        } catch (SQLException e) {
//        }
//    }

    public ArrayList<Integer> getAttendanceIds(JTable table) {

        ArrayList<Integer> ids = AttendanceUtil.getAttendanceIdsFromTable(table);
        for (Integer id : ids) {
        }
        return ids;
    }

  
}
