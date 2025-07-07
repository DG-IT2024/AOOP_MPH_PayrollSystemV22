package controller;

import service.AttendanceService;
import model.Attendance;
import java.sql.*;
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
        DefaultTableModel model = AttendanceUtil.toTableModel_sp(attendance);
        table.setModel(model);
    }

    public void loadAllAttendanceToFilteredTable(JTable table, int employeeId, Date startDate, Date endDate) throws SQLException {
        List<Attendance_sp> attendance = service.listAttendanceByEmployeeAndDateRange(employeeId, startDate, endDate);
        DefaultTableModel model = AttendanceUtil.toTableModel_sp(attendance);
        table.setModel(model);
    }

    public Attendance getAttendance(int id) {
        try {
            return service.readAttendance(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void modifyAttendance(Attendance att) {
        try {
            service.updateAttendance(att);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
