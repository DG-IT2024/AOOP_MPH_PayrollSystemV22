import java.time.LocalTime;

public class Test_Time2 {
    public static void main(String[] args) {
  
        // Define the target time (8:05 AM)
        LocalTime targetTime = LocalTime.of(8, 5);

        String inputTime = "09:05:10";
                
        // Parse the input time into a LocalTime object
        LocalTime parsedTime = LocalTime.parse(inputTime);
        
        // Check if the parsed time is before 8:05
        if (parsedTime.isBefore(targetTime)) {
            System.out.println("The entered time is before 8:05");
        } else {
            System.out.println("The entered time is after or equal to 8:05");
        }
    }
}