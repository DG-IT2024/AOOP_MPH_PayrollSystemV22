import java.time.*;

public class dailyWorkedHours {

    public static void main(String[] args) {
        String TimeIn = "08:00";
        String TimeOut = "10:00";
        // Split the input string by ":"
        String[] part1 = TimeIn.split(":");
        String[] part2 = TimeOut.split(":");
        
        // Convert the hour and minute parts to integers
        int hour_TimeIN = Integer.parseInt(part1[0]);
        int minute_TimeIN = Integer.parseInt(part1[1]);
                
        int hour_TimeOut = Integer.parseInt(part2[0]);
        int minute_TimeOut = Integer.parseInt(part2[1]);
        
        int gracePeriod = 10; // grace period in minutes
           
        LocalTime targetTime = LocalTime.of(8, gracePeriod + 1); //parameter for grace period
        
        LocalTime parsedTime1 = LocalTime.parse(TimeIn); // Parse the TimeIN into a LocalTime object
        
        if (parsedTime1.isBefore(targetTime)&& hour_TimeIN == 8 ){  //TimeIN within graceperiod 8:00AM - 8:10AM
            minute_TimeIN = 0;
        }
        
        // Calculate the difference in minutes
        int totalMinutes1 = hour_TimeIN * 60 + minute_TimeIN;
        int totalMinutes2 =hour_TimeOut * 60 + minute_TimeOut;

        int workedMinutes = totalMinutes2 - totalMinutes1;
           
        // Calculate the worked hours. only consider hours. paid by the hour.
        int workedHour = workedMinutes / 60; 
         
        LocalTime breakStart = LocalTime.of(12, 1);//Set breaktime starts 12PM
        LocalTime breakEnd = LocalTime.of(12, 59);//Set breaktime ends 12:59PM
        
        LocalTime parsedTime2 = LocalTime.parse(TimeOut); // Parse the TimeOut into a LocalTime object
        
        int breakTime = 0; // initialize breakTime
        if(parsedTime1.isBefore(breakStart)&&parsedTime2.isAfter(breakEnd)){ //TimeIn after 12:00PM but before 1:00PM, not counted
            breakTime = 1;
        }
        
        int worked_ = workedHour - breakTime; 
        
        int maxHour = 8; // set maximum paid regular hour  
        int workedHour_ = Math.min(worked_, maxHour); 
        
        System.out.println("hour_TimeIN: " + hour_TimeIN);
        System.out.println("breakTime: " + breakTime);
        System.out.println("workedHour: " + workedHour );  
        System.out.println("worked_: " + worked_ );  
        System.out.println("workedHour_: " + workedHour_ );  
          
    }
}
