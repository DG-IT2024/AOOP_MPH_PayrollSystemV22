package dao;

import model.Payroll;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayrollDAO {

    private Connection conn;

    public PayrollDAO(Connection conn) {
        this.conn = conn;
    }

    public Payroll getPayrollDetails(Integer employeeId, Date periodStart, Date periodEnd) throws SQLException {
        String sql = "{CALL sp_payslip(?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            if (employeeId != null) {
                stmt.setInt(1, employeeId);
            } else {
                stmt.setNull(1, Types.INTEGER);
            }

            if (periodStart != null) {
                stmt.setDate(2, periodStart);
            } else {
                stmt.setNull(2, Types.DATE);
            }

            if (periodEnd != null) {
                stmt.setDate(3, periodEnd);
            } else {
                stmt.setNull(3, Types.DATE);
            }

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapResultSetToPayroll(rs);
            }
        }
        return null;
    }

    public List<Payroll> getPayroll(Integer employeeId) throws SQLException {
        List<Payroll> payrollList = new ArrayList<>();
        String sql = "{CALL sp_payslip(?, null, null)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, employeeId); // employeeId
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                payrollList.add(mapResultSetToPayroll(rs));
            }
        }
        return payrollList;
    }

    public List<Payroll> getPayroll(Integer employeeId, Date periodStart, Date periodEnd) throws SQLException {
        List<Payroll> payrollList = new ArrayList<>();
        String sql = "{CALL sp_payslip(?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, employeeId); // employeeId
            stmt.setDate(2, periodStart);
            stmt.setDate(3, periodEnd);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                payrollList.add(mapResultSetToPayroll(rs));
            }
        }
        return payrollList;
    }

    public boolean insertPayroll(Payroll payroll) throws SQLException {

        String sql = "INSERT INTO payroll (employee_id, employee_full_name, job_position, department_name, pay_period_start, pay_period_end, basic_salary, daily_rate, total_worked_hours, overtime_hours, days_worked, gross_salary_calc, rice_subsidy, phone_allowance, clothing_allowance, total_benefits, sss_deduction, philhealth, pagibig, taxable_income, withholding_tax, total_deductions, takehome_pay) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, payroll.getEmployeeId());
            stmt.setString(2, payroll.getEmployeeFullName());
            stmt.setString(3, payroll.getJobPosition());
            stmt.setString(4, payroll.getDepartmentName());
            stmt.setDate(5, payroll.getPayPeriodStart());
            stmt.setDate(6, payroll.getPayPeriodEnd());
            stmt.setDouble(7, payroll.getBasicSalary());
            stmt.setDouble(8, payroll.getDailyRate());
            stmt.setDouble(9, payroll.getTotalWorkedHours());
            stmt.setDouble(10, payroll.getOvertimeHours());
            stmt.setInt(11, payroll.getDaysWorked());
            stmt.setDouble(12, payroll.getGrossSalaryCalc());
            stmt.setDouble(13, payroll.getRiceSubsidy());
            stmt.setDouble(14, payroll.getPhoneAllowance());
            stmt.setDouble(15, payroll.getClothingAllowance());
            stmt.setDouble(16, payroll.getTotalBenefits());
            stmt.setDouble(17, payroll.getSssDeduction());
            stmt.setDouble(18, payroll.getPhilhealth());
            stmt.setDouble(19, payroll.getPagibig());
            stmt.setDouble(20, payroll.getTaxableIncome());
            stmt.setDouble(21, payroll.getWithholdingTax());
            stmt.setDouble(22, payroll.getTotalDeductions());
            stmt.setDouble(23, payroll.getTakehomePay());
            return stmt.executeUpdate() == 1;
        }
    }

    private Payroll mapResultSetToPayroll(ResultSet rs) throws SQLException {
        Payroll payroll = new Payroll();
        payroll.setEmployeeId(rs.getInt("employee_id"));
        payroll.setEmployeeFullName(rs.getString("employee_full_name"));
        payroll.setJobPosition(rs.getString("job_position"));
        payroll.setDepartmentName(rs.getString("department_name"));
        payroll.setPayPeriodStart(rs.getDate("pay_period_start"));
        payroll.setPayPeriodEnd(rs.getDate("pay_period_end"));
        payroll.setBasicSalary(rs.getDouble("basic_salary"));
        payroll.setDailyRate(rs.getDouble("daily_rate"));
        payroll.setTotalWorkedHours(rs.getDouble("total_worked_hours"));
        payroll.setOvertimeHours(rs.getDouble("overtime_hours"));
        payroll.setDaysWorked(rs.getInt("days_worked"));
        payroll.setGrossSalaryCalc(rs.getDouble("gross_salary_calc"));
        payroll.setRiceSubsidy(rs.getDouble("rice_subsidy"));
        payroll.setPhoneAllowance(rs.getDouble("phone_allowance"));
        payroll.setClothingAllowance(rs.getDouble("clothing_allowance"));
        payroll.setTotalBenefits(rs.getDouble("total_benefits"));
        payroll.setSssDeduction(rs.getDouble("sss_deduction"));
        payroll.setPhilhealth(rs.getDouble("philhealth"));
        payroll.setPagibig(rs.getDouble("pagibig"));
        payroll.setTaxableIncome(rs.getDouble("taxable_income"));
        payroll.setWithholdingTax(rs.getDouble("withholding_tax"));
        payroll.setTotalDeductions(rs.getDouble("total_deductions"));
        payroll.setTakehomePay(rs.getDouble("takehome_pay"));
        return payroll;
    }
}
