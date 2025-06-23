
import java.util.*;

public class SalaryDeduction {

    public static void main(String[] args) {
        double basicSalary = 25000;
        double riceSubsidy = 1500;
        double phoneAllowance = 500;
        double clothingAllowance = 1000;
        double grossSemi_monthlyRate = basicSalary / 2;
        double hourly_Rate = 535.71;

        double workedHour = 8.5;

        double sssDeduction = calculateSSSDeduction(basicSalary);
        double philHealthDeduction = calculatePhilHealthDeduction(basicSalary);
        double pagIbigDeduction = calculatePagIbigDeduction(basicSalary);
        double totalGovtDeduction = sssDeduction + pagIbigDeduction + philHealthDeduction;
        double netMonthPay = basicSalary - totalGovtDeduction;
        double withHoldingTax = calculateWithholdingTax(netMonthPay);
        
        System.out.println(basicSalary);
        System.out.println(sssDeduction);
        System.out.println(philHealthDeduction);
        System.out.println(pagIbigDeduction);
        System.out.println(totalGovtDeduction);
        System.out.println(netMonthPay);
        System.out.println(withHoldingTax);
        
    }

    public static double calculateWithholdingTax(double taxableMonthlyPay) {
        double[] BIRincomeThresholds = {
            20833,
            33333,
            66667,
            166667,
            666667,};
        double[] BIRTaxRate = {0,
            0.2 * (taxableMonthlyPay - BIRincomeThresholds[0]),
            2500 + 0.25 * (taxableMonthlyPay - BIRincomeThresholds[1]),
            10833 + 0.3 * (taxableMonthlyPay - BIRincomeThresholds[2]),
            40833.33 + 0.32 * (taxableMonthlyPay - BIRincomeThresholds[3]),
            200833.33 + 0.35 * (taxableMonthlyPay - BIRincomeThresholds[4]),};

        double whTax = 0;
        for (int i = 0; i < BIRincomeThresholds.length; i++) {
            if (taxableMonthlyPay < BIRincomeThresholds[i]) {
                whTax = BIRTaxRate[i];
                break;
            } else {
                whTax = BIRTaxRate[i + 1];
            }
        }
        return whTax;
    }

    public static double calculateSSSDeduction(double basicSalary) {
        ArrayList<Integer> sssSalary = new ArrayList<>();
        ArrayList<Double> sssContribution = new ArrayList<>();

        // create Salary range
        for (int i = 0; i < 44; i++) {
            int premium = 3250 + 500 * i;
            sssSalary.add(premium);
        }

        // create contribution range
        for (int i = 0; i < 44; i++) {
            double contribution = 135 + 22.5 * i;
            sssContribution.add(contribution);
        }

        // determine SSS deduction
        double SSS_ = 0;
        for (int i = 0; i < 44; i++) {
            if (basicSalary < sssSalary.get(i)) {
                SSS_ = sssContribution.get(i);
                break;
            } else {
                SSS_ = 1125.0;   // max contribution
            }
        }

        return SSS_;
    }

    public static double calculatePagIbigDeduction(double basicSalary) {
        double pagIBIG = 0;

        if (basicSalary >= 1000 && basicSalary <= 1500) {
            pagIBIG = basicSalary * 0.02;
        } else if (basicSalary > 1500) {
            pagIBIG = basicSalary * 0.01;
        }

        double maxContribution = 100.0; // ( need to verify) set max pag-ibig contribution to 100 
        double pagIBIG_ = Math.min(pagIBIG, maxContribution);

        return pagIBIG_;
    }

    public static double calculatePhilHealthDeduction(double basicSalary) {
        double philHealth = basicSalary * 0.03 / 2; // Employees contribution half of 3% of basicSalary.2020 mandate

        int minValue = 300 / 2; // Example minimum value
        int maxValue = 1800 / 2; // Example maximum value
        double philHealth_;
        philHealth_ = Math.min(Math.max(philHealth, minValue), maxValue);

        return philHealth_;
    }

}
