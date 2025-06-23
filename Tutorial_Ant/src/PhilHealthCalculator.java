
public class PhilHealthCalculator {

    public static void main(String[] args) {
        double basicSalary = 100000; // Example value for 'a'
        double philHealthDeduction = calculatePhilHealthDeduction(basicSalary);
        System.out.println("PhilHealth Deduction: " + philHealthDeduction);
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
