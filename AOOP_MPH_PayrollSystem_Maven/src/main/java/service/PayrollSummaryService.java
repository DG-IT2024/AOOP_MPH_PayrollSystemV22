/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author danilo
 */
import dao.PayrollSummaryDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.PayrollSummary;
import util.DBConnect;
import util.PayrollUtil;

public class PayrollSummaryService {

    private PayrollSummaryDAO payrollSummaryDAO;

    public PayrollSummaryService() throws SQLException {
        Connection conn = DBConnect.getConnection();
        this.payrollSummaryDAO = new PayrollSummaryDAO(conn);
    }

    public List<PayrollSummary> listPayrollSummary(Integer empID, Date startDate, Date endDate) throws SQLException {
        return payrollSummaryDAO.getPayrollSummaries(empID,startDate, endDate);
    }

    public void fetchPayrollSummaries(JTable table, Integer empID, Date startDate, Date endDate) throws SQLException {
        List<PayrollSummary> summaries = listPayrollSummary(empID, startDate, endDate);
        DefaultTableModel model = PayrollUtil.loadToJTable(summaries);
        table.setModel(model);

    }

    public void fetchAllPayrollSummaries(JTable table) throws SQLException {
        List<PayrollSummary> summaries = listPayrollSummary(null,null, null);
        DefaultTableModel model = PayrollUtil.loadToJTable(summaries);
        table.setModel(model);

    }
}
