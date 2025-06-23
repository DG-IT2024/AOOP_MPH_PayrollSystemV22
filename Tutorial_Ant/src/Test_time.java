import java.time.*; //Importing the date and time API
import java.lang.Math;

public class Test_time {
    
    public static void main(String[] args) {
        String TimeIn = "08:20";
        String TimeOut = "11:30";
            
       // Split the input string by ":"
        String[] part1 = TimeIn.split(":");
        String[] part2 = TimeOut.split(":");
        
        // Convert the hour and minute parts to integers
        long hour1 = Integer.parseInt(part1[0]);
        long minute1 = Integer.parseInt(part1[1]);
        
        long hour2 = Integer.parseInt(part2[0]);
        long minute2 = Integer.parseInt(part2[1]);
        
        
        System.out.println("minute2: " + minute2);
        
        float workedHour =   Math.abs(minute2-minute1)/60 ;
        String workedHour_= Float.toString(workedHour);
        
        System.out.println("Worked Hour: " + workedHour_);
  
        LocalTime targetTime = LocalTime.of(8, 5);
        
        // Parse the input time into a LocalTime object
        LocalTime parsedTime = LocalTime.parse(TimeIn);
        System.out.println(parsedTime );
        // Check if the parsed time is before 8:05
        if (parsedTime.isBefore(targetTime)) {
            System.out.println("The entered time is before 8:05");
        } else {
            System.out.println("The entered time is after or equal to 8:05");
        }
       
    }
}

