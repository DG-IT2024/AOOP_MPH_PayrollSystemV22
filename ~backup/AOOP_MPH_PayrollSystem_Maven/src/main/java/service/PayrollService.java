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

    public boolean addPayroll(Payroll payroll) throws SQLException {
        return payrollDAO.insertPayroll(payroll);

    }


}
