/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.List;
import javax.swing.JTable;

public class PayrollSummary {

    private java.sql.Date payPeriodStart;
    private java.sql.Date payPeriodEnd;
    private int employeeNumber;
    private String employeeFullName;
    private String jobPosition;
    private String departmentName;
    private double grossSalaryCalc;
    private String sssGovtId;
    private double sssDeduction;
    private String philhealthGovtId;
    private double philhealthDeduction;
    private String pagibigGovtId;
    private double pagibigContribution;
    private String tinGovtId;
    private double taxDeduction;
    private double netPay;

    public PayrollSummary() {

    }

    // Constructor
    public PayrollSummary(
            java.sql.Date payPeriodStart,
            java.sql.Date payPeriodEnd,
            int employeeNumber,
            String employeeFullName,
            String jobPosition,
            String departmentName,
            double grossSalaryCalc,
            String sssGovtId,
            double sssDeduction,
            String philhealthGovtId,
            double philhealthDeduction,
            String pagibigGovtId,
            double pagibigContribution,
            String tinGovtId,
            double taxDeduction,
            double netPay
    ) {
        this.payPeriodStart = payPeriodStart;
        this.payPeriodEnd = payPeriodEnd;
        this.employeeNumber = employeeNumber;
        this.employeeFullName = employeeFullName;
        this.jobPosition = jobPosition;
        this.departmentName = departmentName;
        this.grossSalaryCalc = grossSalaryCalc;
        this.sssGovtId = sssGovtId;
        this.sssDeduction = sssDeduction;
        this.philhealthGovtId = philhealthGovtId;
        this.philhealthDeduction = philhealthDeduction;
        this.pagibigGovtId = pagibigGovtId;
        this.pagibigContribution = pagibigContribution;
        this.tinGovtId = tinGovtId;
        this.taxDeduction = taxDeduction;
        this.netPay = netPay;
    }

    // Getters and Setters
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

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
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

    public double getGrossSalaryCalc() {
        return grossSalaryCalc;
    }

    public void setGrossSalaryCalc(double grossSalaryCalc) {
        this.grossSalaryCalc = grossSalaryCalc;
    }

    public String getSssGovtId() {
        return sssGovtId;
    }

    public void setSssGovtId(String sssGovtId) {
        this.sssGovtId = sssGovtId;
    }

    public double getSssDeduction() {
        return sssDeduction;
    }

    public void setSssDeduction(double sssDeduction) {
        this.sssDeduction = sssDeduction;
    }

    public String getPhilhealthGovtId() {
        return philhealthGovtId;
    }

    public void setPhilhealthGovtId(String philhealthGovtId) {
        this.philhealthGovtId = philhealthGovtId;
    }

    public double getPhilhealthDeduction() {
        return philhealthDeduction;
    }

    public void setPhilhealthDeduction(double philhealthDeduction) {
        this.philhealthDeduction = philhealthDeduction;
    }

    public String getPagibigGovtId() {
        return pagibigGovtId;
    }

    public void setPagibigGovtId(String pagibigGovtId) {
        this.pagibigGovtId = pagibigGovtId;
    }

    public double getPagibigContribution() {
        return pagibigContribution;
    }

    public void setPagibigContribution(double pagibigContribution) {
        this.pagibigContribution = pagibigContribution;
    }

    public String getTinGovtId() {
        return tinGovtId;
    }

    public void setTinGovtId(String tinGovtId) {
        this.tinGovtId = tinGovtId;
    }

    public double getTaxDeduction() {
        return taxDeduction;
    }

    public void setTaxDeduction(double taxDeduction) {
        this.taxDeduction = taxDeduction;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double takeHomePay) {
        this.netPay = takeHomePay;
    }

    public List<PayrollSummary> fetchPayrollSummaries(JTable jTablePayrollSummary, Date startDate, Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
