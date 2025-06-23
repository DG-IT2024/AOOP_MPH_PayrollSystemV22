
public class pagIbigCalculator {

    public static void main(String[] args) {
        double basicSalary = 900; // Example value for 'a'
        double pagIbigDeduction = calculatePagIbigDeduction(basicSalary);
        System.out.println("pagIbigDeduction: " + pagIbigDeduction);
    }

    public static double calculatePagIbigDeduction(double basicSalary) {
        double pagIBIG = 0;

        if (basicSalary >= 1000 && basicSalary <= 1500) {
            pagIBIG = basicSalary * 0.01;
        } else if (basicSalary > 1500) {
            pagIBIG = basicSalary * 0.02;
        }

        double maxContribution = 100.0; // ( need to verify) set max pag-ibig contribution to 100 
        double pagIBIG_ = Math.min(pagIBIG, maxContribution);
        
        return pagIBIG_;
    }
}
