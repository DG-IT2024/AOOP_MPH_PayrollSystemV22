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
    
     // Calculate SSS deduction based on salary
    public static double calculateSSSContribution(double monthlySalary) {
        ArrayList<Integer> salaryThresholds = new ArrayList<>();
        ArrayList<Double> sssContributions = new ArrayList<>();

        // Set up SSS salary brackets
        for (int i = 0; i < 44; i++) {
            int threshold = 3250 + 500 * i;
            salaryThresholds.add(threshold);
        }

        // Set up SSS contribution brackets
        for (int i = 0; i < 44; i++) {
            double contribution = 135 + 22.5 * i;
            sssContributions.add(contribution);
        }

        // Find the correct SSS contribution for the salary
        double sssContribution = 0;
        for (int i = 0; i < 44; i++) {
            if (monthlySalary < salaryThresholds.get(i)) {
                sssContribution = sssContributions.get(i);
                break;
            } else {
                sssContribution = 1125.0; // Maximum SSS contribution
            }
        }
        return sssContribution;
    }

    // Calculate Pag-IBIG deduction based on salary
    public static double calculatePagIbigContribution(double monthlySalary) {
        double pagIbigContribution;

        if (monthlySalary >= 1000 && monthlySalary <= 1500) {
            pagIbigContribution = monthlySalary * 0.01;
        } else if (monthlySalary > 1500) {
            pagIbigContribution = monthlySalary * 0.02;
        } else {
            pagIbigContribution = 0;
        }

        double maxPagIbigContribution = 100.0; // Max Pag-IBIG deduction
        return Math.min(pagIbigContribution, maxPagIbigContribution);
    }

    // Calculate PhilHealth deduction based on salary
    public static double calculatePhilHealthContribution(double monthlySalary) {
        double philHealthRate = 0.03; // 3% as of 2020, split by employee/employer
        double philHealthContribution = (monthlySalary * philHealthRate) / 2;

        double minPhilHealth = 150.0;  // 300 / 2 (employee share)
        double maxPhilHealth = 900.0;  // 1800 / 2 (employee share)
        // Clamp to minimum and maximum values
        return Math.min(Math.max(philHealthContribution, minPhilHealth), maxPhilHealth);
    }

    // Sum of statutory benefit deductions
    public static double calculateTotalBenefitsDeductions(double monthlySalary) {
        double sss = calculateSSSContribution(monthlySalary);
        double pagIbig = calculatePagIbigContribution(monthlySalary);
        double philHealth = calculatePhilHealthContribution(monthlySalary);
        return sss + pagIbig + philHealth;
    }

    // Calculate withholding tax based on net taxable income (after statutory deductions)
    public static double calculateWithholdingTax(double monthlySalary) {
        double taxableIncome = monthlySalary - calculateTotalBenefitsDeductions(monthlySalary);

        double[] birThresholds = {20833, 33333, 66667, 166667, 666667};
        double[] birTaxBrackets = {
            0,
            0.2 * (taxableIncome - birThresholds[0]),
            2500 + 0.25 * (taxableIncome - birThresholds[1]),
            10833 + 0.3 * (taxableIncome - birThresholds[2]),
            40833.33 + 0.32 * (taxableIncome - birThresholds[3]),
            200833.33 + 0.35 * (taxableIncome - birThresholds[4]),};

        double withholdingTax = 0;
        for (int i = 0; i < birThresholds.length; i++) {
            if (taxableIncome < birThresholds[i]) {
                withholdingTax = birTaxBrackets[i];
                break;
            } else {
                withholdingTax = birTaxBrackets[i + 1];
            }
        }
        return withholdingTax;
    }
    
}
