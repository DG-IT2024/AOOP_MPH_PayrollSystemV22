/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aoop_mph_payrollsystem;

import util.StatutoryDeductions;

/**
 *
 * @author danilo
 */
public class AOOP_MPH_PayrollSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //         double grossSalary = 26750;

        
        double grossSalary = 26750;

        double basis = grossSalary;

        double sssDeduction = StatutoryDeductions.calculateSSSContribution(basis);
        double pagibigDeduction = StatutoryDeductions.calculatePagIbigContribution(basis);
        double philhealthDeduction = StatutoryDeductions.calculatePhilHealthContribution(basis);
        double whtax = StatutoryDeductions.calculateWithholdingTax(basis);

        double totalDeductions = sssDeduction + pagibigDeduction + philhealthDeduction + whtax;

        double netPay = basis - totalDeductions;

        System.out.println("Gross Salary:          " + grossSalary);
        System.out.println("SSS Deduction:         " + sssDeduction);
        System.out.println("Pag-IBIG Deduction:    " + pagibigDeduction);
        System.out.println("PhilHealth Deduction:  " + philhealthDeduction);
        System.out.println("Withholding Tax:       " + whtax);
        System.out.println("-------------------------------");
        System.out.println("Total Deductions:      " + totalDeductions);
        System.out.println("Net Pay:               " + netPay);

    }
}