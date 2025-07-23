/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.PayrollSummary;

/**
 *
 * @author danilo
 */
public class PayrollUtil {

    public static DefaultTableModel loadToJTable(List<PayrollSummary> summaries) {
        String[] columnNames = {
            "Pay Period Start", "Pay Period End", "Employee Number", "Full Name",
            "Job Position", "Department", "Gross Salary", "SSS ID", "SSS Deduction",
            "PhilHealth ID", "PhilHealth Deduction", "Pag-IBIG ID", "Pag-IBIG Contribution",
            "TIN", "Tax Deduction", "Take Home Pay"
        };

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (PayrollSummary s : summaries) {
            Object[] row = {
                s.getPayPeriodStart(),
                s.getPayPeriodEnd(),
                s.getEmployeeNumber(),
                s.getEmployeeFullName(),
                s.getJobPosition(),
                s.getDepartmentName(),
                s.getGrossSalaryCalc(),
                s.getSssGovtId(),
                s.getSssDeduction(),
                s.getPhilhealthGovtId(),
                s.getPhilhealthDeduction(),
                s.getPagibigGovtId(),
                s.getPagibigContribution(),
                s.getTinGovtId(),
                s.getTaxDeduction(),
                s.getNetPay()
            };
            model.addRow(row);
        }
        return model;
    }
    
    
}
