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

//    

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
