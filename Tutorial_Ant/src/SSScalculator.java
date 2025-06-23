import java.util.ArrayList;

public class SSScalculator {
    
    public static void main(String[] args) {
        double basicSalary = 30000; // Example value for 'a'
        double sssDeduction = calculateSSSDeduction(basicSalary);
        System.out.println("SSS Deduction: " + sssDeduction);
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
}
