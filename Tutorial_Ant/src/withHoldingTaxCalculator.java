
public class withHoldingTaxCalculator {
    public static void main(String[] args) {
        double basicSalary  = 1000000; 
        double deductions  = 0; 
        //with holding tax
        double taxableMonthlyPay = basicSalary - deductions;
        System.out.println( "netMonthlyPay: " + taxableMonthlyPay);    
        double withHoldingTax = calculateWithholdingTax(taxableMonthlyPay);
        System.out.println( "withHoldingTax: " + withHoldingTax);    
    }
    
    public static double calculateWithholdingTax(double taxableMonthlyPay){ 
        double[] BIRincomeThresholds = {
            20833,
            33333,
            66667,
            166667,
            666667,
        };
        double[] BIRTaxRate= {0,
            0.2*(taxableMonthlyPay - BIRincomeThresholds[0]),
            2500+0.25*(taxableMonthlyPay - BIRincomeThresholds[1]),
            10833+0.3*(taxableMonthlyPay - BIRincomeThresholds[2]),
            40833.33+0.32*(taxableMonthlyPay - BIRincomeThresholds[3]),
            200833.33+0.35*(taxableMonthlyPay - BIRincomeThresholds[4]),
        };
        
        double whTax = 0;
        for (int i = 0 ; i < BIRincomeThresholds.length; i++){
            if( taxableMonthlyPay < BIRincomeThresholds[i]){
                whTax = BIRTaxRate[i];
                break;
            }else
                whTax = BIRTaxRate[i+1];
        }
        return whTax;
    }
    
}