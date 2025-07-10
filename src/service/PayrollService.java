package service;

import dao.PayrollDAO;
import model.Payroll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import util.DBConnect;

public class PayrollService {

    private PayrollDAO payrollDAO;

    public PayrollService() throws SQLException {
        Connection conn = DBConnect.getConnection();
        this.payrollDAO = new PayrollDAO(conn);
    }

    public Payroll getPayroll(int employeeId, Date periodStart, Date periodEnd) throws SQLException {
        return payrollDAO.getPayrollDetails(employeeId, periodStart, periodEnd);
    }

    public Payroll getPayroll(int employeeId) throws SQLException {
        return payrollDAO.getPayrollDetails(employeeId, null, null);
    }

    public List<Payroll> getAllPayroll() throws SQLException {
        return payrollDAO.getAllPayroll();
    }

    // 3. Insert new payroll record
    public boolean addPayroll(Payroll payroll) throws SQLException {
        return payrollDAO.insertPayroll(payroll);
    }
//
//    // 4. Update payroll record
//    public boolean updatePayroll(Payroll payroll) throws SQLException {
//        // You'd need to implement updatePayroll in PayrollDAO
//        return payrollDAO.updatePayroll(payroll);
//    }
//
//    // 5. Delete payroll record
//    public boolean deletePayroll(int employeeId, Date periodStart, Date periodEnd) throws SQLException {
//        // You'd need to implement deletePayroll in PayrollDAO
//        return payrollDAO.deletePayroll(employeeId, periodStart, periodEnd);
//    }
}
