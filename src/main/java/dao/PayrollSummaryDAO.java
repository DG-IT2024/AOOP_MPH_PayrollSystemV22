/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author danilo
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.PayrollSummary;

public class PayrollSummaryDAO {

    private Connection conn;

    public PayrollSummaryDAO(Connection conn) {
        this.conn = conn;
    }

    public List<PayrollSummary> getPayrollSummaries(Integer empId, Date startDate, Date endDate) throws SQLException {
        List<PayrollSummary> summaries = new ArrayList<>();
        String sql = "{CALL payroll_summary(?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {

            if (startDate != null) {
                stmt.setDate(1, startDate);
            } else {
                stmt.setNull(1, java.sql.Types.DATE);
            }

            if (endDate != null) {
                stmt.setDate(2, endDate);
            } else {
                stmt.setNull(2, java.sql.Types.DATE);
            }

            if (empId != null) {
                stmt.setInt(3, empId);
            } else {
                stmt.setNull(3, java.sql.Types.INTEGER);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PayrollSummary summary = new PayrollSummary(
                            rs.getDate("pay_period_start"),
                            rs.getDate("pay_period_end"),
                            rs.getInt("employee_number"),
                            rs.getString("employee_full_name"),
                            rs.getString("job_position"),
                            rs.getString("department_name"),
                            rs.getDouble("gross_salary_calc"),
                            rs.getString("sss_govt_id"),
                            rs.getDouble("sss_deduction"),
                            rs.getString("philhealth_govt_id"),
                            rs.getDouble("philhealth_deduction"),
                            rs.getString("pagibig_govt_id"),
                            rs.getDouble("pagibig_contribution"),
                            rs.getString("tin_govt_id"),
                            rs.getDouble("tax_deduction"),
                            rs.getDouble("net_pay")
                    );
                    summaries.add(summary);
                }
            }
        }
        return summaries;
    }

}
