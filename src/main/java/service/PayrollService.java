package service;

import dao.PayrollDAO;
import model.Payroll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import model.Employee;

import util.DBConnect;

public class PayrollService {

    private PayrollDAO payrollDAO;
    private AttendanceService attendanceService;
    private EmployeeService employeeService;

    public PayrollService() throws SQLException, Exception {
        Connection conn = DBConnect.getConnection();
        this.payrollDAO = new PayrollDAO(conn);
        this.attendanceService = new AttendanceService();
        this.employeeService = new EmployeeService();

    }

    public Payroll getPayroll(int employeeId, Date periodStart, Date periodEnd) throws SQLException {
        return payrollDAO.getPayrollDetails(employeeId, periodStart, periodEnd);
    }

    public Payroll getPayroll(int employeeId) throws SQLException {
        return payrollDAO.getPayrollDetails(employeeId, null, null);
    }

    public List<Payroll> getAllPayroll(int employeeId, Date periodStart, Date periodEnd) throws SQLException {
        return payrollDAO.getPayroll(employeeId, periodStart, periodEnd);

    }

    public Payroll computePayroll(int employeeId, java.sql.Date start, java.sql.Date end) throws Exception {
        Payroll payroll = new Payroll();

        // Set employee info (assuming you have a method to get Employee object)
        Employee employee = employeeService.findEmployeeById(employeeId);
        payroll.setEmployeeId(employeeId);
        String lastName = employee.getLastName();
        String firstName = employee.getFirstName();
        String FullName = lastName + ", " + firstName;
        payroll.setEmployeeFullName(FullName);
        payroll.setJobPosition(employee.getPosition());
        payroll.setDepartmentName(employee.getPosition());

        payroll.setPayPeriodStart(start);
        payroll.setPayPeriodEnd(end);

        // Calculations (use your helper methods, adjust as needed)
        double basicSalary = employee.getBasicSalary();
        payroll.setBasicSalary(basicSalary);

        double dailyRate = getdailyRate(employeeId, start, end);
        payroll.setDailyRate(dailyRate);

        double totalWorkedHours = getTotalRegularHours(employeeId, start, end);
        payroll.setTotalWorkedHours(totalWorkedHours);

        double overtimeHours = getTotalOvertimeHours(employeeId, start, end);
        payroll.setOvertimeHours(overtimeHours);

        java.sql.Date sqlStart = new java.sql.Date(start.getTime());
        java.sql.Date sqlEnd = new java.sql.Date(end.getTime());
        int daysWorked = attendanceService.getWorkingDays(sqlStart);

        payroll.setDaysWorked(daysWorked);

        double grossSalaryCalc = getGrossIncome(employeeId, start, end);
        payroll.setGrossSalaryCalc(grossSalaryCalc);

        // Benefits (from Employee object)
        payroll.setRiceSubsidy(employee.getRiceSubsidy());
        payroll.setPhoneAllowance(employee.getPhoneAllowance());
        payroll.setClothingAllowance(employee.getClothingAllowance());
        double totalBenefits = payroll.getRiceSubsidy() + payroll.getPhoneAllowance() + payroll.getClothingAllowance();
        payroll.setTotalBenefits(totalBenefits);

        DeductionRateService service = new DeductionRateServiceImpl();

        // Deductions (call your deduction helper/class)
        double sssDeduction = service.computeSss(grossSalaryCalc);
        payroll.setSssDeduction(sssDeduction);

        double philhealth = service.computePhilHealth(grossSalaryCalc);
        payroll.setPhilhealth(philhealth);

        double pagibig = service.computePagIbig(grossSalaryCalc);
        payroll.setPagibig(pagibig);

        double taxableIncome = service.taxableIncome(grossSalaryCalc);
        payroll.setTaxableIncome(taxableIncome);

        double withholdingTax = service.computeWithholdingTax(taxableIncome);
        payroll.setWithholdingTax(withholdingTax);

        double totalDeductions = service.totalDeduction(grossSalaryCalc);
        payroll.setTotalDeductions(totalDeductions);

        // Take-home pay
        double takehomePay = grossSalaryCalc + totalBenefits - totalDeductions;
        payroll.setTakehomePay(takehomePay);

        return payroll;
    }

    public double getTotalRegularHours(int employeeId, Date sqlStartDate, Date sqlEndDate) throws SQLException {
        return attendanceService.getRegularHours(employeeId, sqlStartDate, sqlEndDate);
    }

    public double getTotalOvertimeHours(int employeeId, Date sqlStartDate, Date sqlEndDate) throws SQLException {
        return attendanceService.getOvertimeHours(employeeId, sqlStartDate, sqlEndDate);
    }

    public double getWeightedTotalOvertimeHours(int employeeId, Date sqlStartDate, Date sqlEndDate) throws SQLException {

        return attendanceService.getWeightedOvertimes(employeeId, sqlStartDate, sqlEndDate);
    }

    public double getBasicRate(int employeeId) throws SQLException {

        Employee employee = employeeService.findEmployeeById(employeeId);
        return employee.getBasicSalary();
    }

    public double getdailyRate(int employeeId, Date sqlStartDate, Date sqlEndDate) throws Exception {
        double basicSalary = getBasicRate(employeeId);
        Payroll payroll = getPayroll(employeeId, sqlStartDate, sqlEndDate);
        int workingDayMonthly;
//        if (payroll.getDaysWorked() != 0) {
//            workingDayMonthly = payroll.getDaysWorked();
//        } else {
            workingDayMonthly = attendanceService.getWorkingDays(sqlStartDate);
//        }

        return basicSalary / workingDayMonthly;
    }

    public double getHourlyRate(int employeeId, Date sqlStartDate, Date sqlEndDate) throws Exception {
        return getdailyRate(employeeId, sqlStartDate, sqlEndDate) / 8;
    }

    public double getWeightedOvertimeRate(int employeeId, Date sqlStartDate, Date sqlEndDate) throws SQLException {
        return attendanceService.getWeightedOvertimes(employeeId, sqlStartDate, sqlEndDate);
    }

    public double getGrossIncome(int employeeId, Date periodStart, Date periodEnd) throws Exception {
        double hourlyRate = getHourlyRate(employeeId, periodStart, periodEnd); // usually the rate doesn't change but add params if needed
        double totalRegularHours = getTotalRegularHours(employeeId, periodStart, periodEnd);
        double totalOvertimePay = hourlyRate * getWeightedOvertimeRate(employeeId, periodStart, periodEnd); // this should return already weighted OT
        double grossIncome = (hourlyRate * totalRegularHours) + totalOvertimePay;
        return grossIncome;
    }

    public List<Double> getPayDetails(int employeeId, Date sqlStartDate, Date sqlEndDate) throws Exception {
        List<Double> payDetails = new ArrayList<>();
        payDetails.add(getTotalRegularHours(employeeId, sqlStartDate, sqlEndDate));
        payDetails.add(getTotalOvertimeHours(employeeId, sqlStartDate, sqlEndDate));
        payDetails.add(getBasicRate(employeeId));//Basic Salary
        payDetails.add(getHourlyRate(employeeId, sqlStartDate, sqlEndDate)); // hourly rate
        payDetails.add(getGrossIncome(employeeId, sqlStartDate, sqlEndDate));

        return payDetails;
    }

    public double getTotalBenefit(int employeeId) throws SQLException {

        Employee employee = employeeService.findEmployeeById(employeeId);
        double riceSubsidy = employee.getRiceSubsidy();
        double clothingAllowance = employee.getClothingAllowance();
        double phoneAllowance = employee.getPhoneAllowance();
        double totalBenefit = riceSubsidy + clothingAllowance + phoneAllowance;
        return totalBenefit;
    }

    public double getTakehomePay(int employeeId, Date sqlStartDate, Date sqlEndDate) throws Exception {
        DeductionRateService service = new DeductionRateServiceImpl();

        double grossIncome = getGrossIncome(employeeId, sqlStartDate, sqlEndDate);
        double TotalBenefit = getTotalBenefit(employeeId);
        double TotalDeduction = service.totalDeduction(grossIncome);
        double takeHomePay = grossIncome + TotalBenefit - TotalDeduction;
        return takeHomePay;

    }

}
