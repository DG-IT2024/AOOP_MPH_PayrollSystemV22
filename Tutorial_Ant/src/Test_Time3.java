// Java Program to Find the difference 
// between Two Time Periods 

import java.util.*; // Importing the Date Class from the util package 
import java.text.*; //Importing the SimpleDateFormat Class from the text package 
import java.time.LocalTime; //Importing the date and time API

public class Test_Time3 { 
  
    public static void main(String[] args) throws Exception 
    { 
        String RecordedDate = "02/14/23";
        // Dates to be parsed HH:MM:SS
        String TimeIn = "9:00:00"; 
        String TimeOut = "17:00:00"; 
  
        // Creating a SimpleDateFormat object 
        // to parse time in the format HH:MM:SS 
        SimpleDateFormat parseTime = new SimpleDateFormat("HH:mm:ss"); 
  
        // Parsing the Time Period 
        Date t_In = parseTime.parse(TimeIn); 
        Date t_Out = parseTime.parse(TimeOut); 
  
        // Calculating the difference in milliseconds 
        long differenceInMilliSeconds = Math.abs(t_Out.getTime() - t_In.getTime()); 
  
        // Calculating the difference in Hours 
        long differenceInHours  = (differenceInMilliSeconds / (60 * 60 * 1000))  % 24; 
  
        // Calculating the difference in Minutes 
        long differenceInMinutes = (differenceInMilliSeconds / (60 * 1000)) % 60; 
  
        // Calculating the difference in Seconds 
        long differenceInSeconds = (differenceInMilliSeconds / 1000) % 60; 
        
        long breakTime = 1;
        long workedHour = differenceInHours - breakTime;
        
        System.out.println(workedHour);
        
        
        System.out.println(RecordedDate);
         // Printing the answer 
        System.out.println( 
            "Total Worked Hours is " + differenceInHours + " hours "
            + differenceInMinutes + " minutes "
            + differenceInSeconds + " Seconds. "); 
       
        
    } 
}