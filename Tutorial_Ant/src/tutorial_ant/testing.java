// Java Program to Find the difference 
// between Two Time Periods 

import java.util.*; // Importing the Date Class from the util package 
import java.text.*; //Importing the SimpleDateFormat Class from the text package 
  
public class testing { 
  
    public static void main(String[] args) throws Exception 
    { 
        String RecordedDate = "02/14/23";
        // Dates to be parsed HH:MM:SS
        String TimeIn = "8:05:00"; 
        String TimeOut = "12:30:00"; 
  
        // Creating a SimpleDateFormat object 
        // to parse time in the format HH:MM:SS 
        SimpleDateFormat parseTime = new SimpleDateFormat("HH:mm:SS"); 
  
        // Parsing the Time Period 
        Date t_In = parseTime.parse(TimeIn); 
        Date t_Out = parseTime.parse(TimeOut); 
  
        System.out.println(t_In); 
        System.out.println(t_Out);
        // Calculating the difference in milliseconds 
        long differenceInMilliSeconds = Math.abs(t_Out.getTime() - t_In.getTime()); 
  
        // Calculating the difference in Hours 
        long differenceInHours  = (differenceInMilliSeconds / (60 * 60 * 1000))  % 24; 
  
        // Calculating the difference in Minutes 
        long differenceInMinutes = (differenceInMilliSeconds / (60 * 1000)) % 60; 
  
        // Calculating the difference in Seconds 
        long differenceInSeconds = (differenceInMilliSeconds / 1000) % 60; 
  
        System.out.println(RecordedDate);
        
        // Printing the answer 
        System.out.println( 
            "Total Worked Hours is " + differenceInHours + " hours "
            + differenceInMinutes + " minutes "
            + differenceInSeconds + " Seconds. "); 
        
        //condition for late
        if(5 < 0){
            System.out.println("Your late");
        }else
            System.out.println("Your On Time");
        
        

    } 
}