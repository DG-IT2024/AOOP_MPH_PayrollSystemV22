
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class parseDate {

    public static void main(String[] args) {

        String coveredDateStart = "02/01/24";
        String coveredDateEnd = "02/30/24";
        
        Boolean statusPayroll = qualifierBenefitsDeduction(coveredDateEnd);
        
        System.out.println(statusPayroll);
        
    }

    public static Boolean qualifierBenefitsDeduction(String coveredDateEnd) {
        String[] coveredDateEnd_ = coveredDateEnd.split("/");
        int dateEnd = Integer.parseInt(coveredDateEnd_[1]);
        Boolean statusPayroll = false;
        if (dateEnd > 20) { // qualifier to consider fov't mandated deduction and benefits.
            statusPayroll = true;
        }

        return statusPayroll;
    }

    
    /* will also count weekends
    public static int computeCoveredDays(String coveredDateStart, String coveredDateEnd) {
        String[] coveredDateStart_ = coveredDateStart.split("/");
        String[] coveredDateEnd_ = coveredDateEnd.split("/");

        int dateStart = Integer.parseInt(coveredDateStart_[1]);
        int dateEnd = Integer.parseInt(coveredDateEnd_[1]);
        int coveredDays = dateEnd - dateStart +1;

        
        
        return coveredDays;
    }
    */
}
