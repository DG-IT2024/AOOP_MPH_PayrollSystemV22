/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class Payroll {

    private int employeeId;
    private String employeeFullName;
    private String jobPosition;
    private String departmentName;
    private java.sql.Date payPeriodStart;
    private java.sql.Date payPeriodEnd;
    private double basicSalary;
    private double dailyRate;
    private double totalWorkedHours;
    private double overtimeHours;
    private int daysWorked;
    private double grossSalaryCalc;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double totalBenefits;
    private double sssDeduction;
    private double philhealth;
    private double pagibig;
    private double taxableIncome;
    private double withholdingTax;
    private double totalDeductions;
    private double takehomePay;

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFullName() {
        return employeeFullName;
    }

    public void setEmployeeFullName(String employeeFullName) {
        this.employeeFullName = employeeFullName;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public java.sql.Date getPayPeriodStart() {
        return payPeriodStart;
    }

    public void setPayPeriodStart(java.sql.Date payPeriodStart) {
        this.payPeriodStart = payPeriodStart;
    }

    public java.sql.Date getPayPeriodEnd() {
        return payPeriodEnd;
    }

    public void setPayPeriodEnd(java.sql.Date payPeriodEnd) {
        this.payPeriodEnd = payPeriodEnd;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getTotalWorkedHours() {
        return totalWorkedHours;
    }

    public void setTotalWorkedHours(double totalWorkedHours) {
        this.totalWorkedHours = totalWorkedHours;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public int getDaysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }

    public double getGrossSalaryCalc() {
        return grossSalaryCalc;
    }

    public void setGrossSalaryCalc(double grossSalaryCalc) {
        this.grossSalaryCalc = grossSalaryCalc;
    }

    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    public void setRiceSubsidy(double riceSubsidy) {
        this.riceSubsidy = riceSubsidy;
    }

    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    public void setPhoneAllowance(double phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }

    public double getClothingAllowance() {
        return clothingAllowance;
    }

    public void setClothingAllowance(double clothingAllowance) {
        this.clothingAllowance = clothingAllowance;
    }

    public double getTotalBenefits() {
        return totalBenefits;
    }

    public void setTotalBenefits(double totalBenefits) {
        this.totalBenefits = totalBenefits;
    }

    public double getSssDeduction() {
        return sssDeduction;
    }

    public void setSssDeduction(double sssDeduction) {
        this.sssDeduction = sssDeduction;
    }

    public double getPhilhealth() {
        return philhealth;
    }

    public void setPhilhealth(double philhealth) {
        this.philhealth = philhealth;
    }

    public double getPagibig() {
        return pagibig;
    }

    public void setPagibig(double pagibig) {
        this.pagibig = pagibig;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double getWithholdingTax() {
        return withholdingTax;
    }

    public void setWithholdingTax(double withholdingTax) {
        this.withholdingTax = withholdingTax;
    }

    public double getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public double getTakehomePay() {
        return takehomePay;
    }

    public void setTakehomePay(double takehomePay) {
        this.takehomePay = takehomePay;
    }
}
