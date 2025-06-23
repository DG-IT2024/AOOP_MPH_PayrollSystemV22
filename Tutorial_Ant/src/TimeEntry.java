
/*
Notes:
Format HH:mm. This calculator will not give accurate results for HH:mm:ss
Time in 12:00 to 13:00. 
Time in before 8:00. credited as regular paid hour
Maximum regular paid hour is 8hours
Program allows multi Time In, Time Out entry. 
Enter Time without spacing. 
Separate entry with comma
Write Time In followed by Timeout.
Time should follow HH:MM format
Causes of Error: Empty entry, spacing, submitting wrong format
 */
import java.time.LocalTime;
import java.util.Scanner;
import java.util.ArrayList;

public class TimeEntry {

    public static void main(String[] args) {

        Scanner entry = new Scanner(System.in);

        System.out.println("Enter multiple Time-In and Time-out:(format: HH:MM,HH:MM). Type 'p' to finish");
        ArrayList<String> timeSheet = new ArrayList<>();

        while (true) {

            String inputline = entry.nextLine(); //before "\n" newline charter
            if (inputline.equalsIgnoreCase("p")) { // equalsIgnoreCase ignores the case (uppercase or lowercase) of "done"
                break; // Exit the loop if 'done' is entered
            }

            String[] elements = inputline.split(","); // Split input by delimiter ","
            for (String element : elements) {
                timeSheet.add(element.trim()); // Trim spaces and add each elemen
            }
        }

        System.out.println("Inputs stored in the TimeSheet:");

        System.out.println("timeSheet :" + timeSheet);

        ArrayList<String> timeIn = extractTimeIn(timeSheet);
        ArrayList<String> timeOut = extractTimeOut(timeSheet);

        System.out.println("time In :" + timeIn);
        System.out.println("time Out :" + timeOut);

        int maxRegularHours;
        maxRegularHours = 8; // Maximum paid regular hours : 8

        ArrayList< Integer> dailyWorkedHours = new ArrayList<>();

        for (int i = 0; i < timeIn.size(); i++) {
            dailyWorkedHours.add(calculateWorkedHours(timeIn.get(i), timeOut.get(i)));
        }

        int regularWorkedHour;
        regularWorkedHour = regularWorkedHoursComputation(dailyWorkedHours, maxRegularHours);

        int overtimeHour;
        overtimeHour = overtimeComputation(dailyWorkedHours, maxRegularHours);
        System.out.println("dailyWorkedHours :" + dailyWorkedHours);
        System.out.println("regularWorkedHour :" + regularWorkedHour);
        System.out.println("overtimeHour :" + overtimeHour);

    }

    public static ArrayList<String> extractTimeIn(ArrayList<String> timeSheet) {
        ArrayList<String> timeIn = new ArrayList<>();

        for (int i = 0; i < timeSheet.size(); i += 2) {
            if (!timeSheet.get(i).isEmpty()) {
                timeIn.add(timeSheet.get(i));
            }
        }
        return timeIn;
    }

    public static ArrayList<String> extractTimeOut(ArrayList<String> timeSheet) {
        ArrayList<String> timeOut = new ArrayList<>();

        for (int i = 1; i < timeSheet.size(); i += 2) {
            if (!timeSheet.get(i).isEmpty()) {
                timeOut.add(timeSheet.get(i));
            }
        }
        return timeOut;
    }

    public static int calculateWorkedHours(String timeIn, String timeOut) {
        // break time 12:00PM to 13:00PM
        // parsed timeIn and timeOut       
        LocalTime parsedTimeIn = LocalTime.parse(timeIn); // Parse the TimeIN into a LocalTime object
        LocalTime parsedTimeOut = LocalTime.parse(timeOut); // Parse the TimeOut into a LocalTime object

                //Grace period consideration
        int gracePeriod = 10; // grace period in minutes

        LocalTime OfficeStart = LocalTime.of(8, 0);//Set Office starts 8AM

        LocalTime targetTime = LocalTime.of(8, gracePeriod + 1); //parameter for grace period after Office start        

        if (parsedTimeIn.isBefore(targetTime) && parsedTimeIn.getHour() == OfficeStart.getHour()) {  //if within graceperiod 8:00AM - 8:10AM. set TimeIN = 8:00AM
            parsedTimeIn = OfficeStart;
        }

        //Breaktime
        LocalTime breakStart = LocalTime.of(12, 0);//Set breaktime starts 12PM
        LocalTime breakEnd = LocalTime.of(13, 00);//Set breaktime ends before 1PM

        //Exclude worked hour during breaktime
        if (parsedTimeIn.isAfter(LocalTime.of(11, 59)) && parsedTimeIn.isBefore(breakEnd)) {
            parsedTimeIn = breakEnd;
        }

        //Deduct Breaktime in the total worked hours
        int breakTime = 0; // initialize breakTime
        if (parsedTimeIn.isBefore(breakStart) && parsedTimeOut.isAfter(LocalTime.of(12, 59))) { //TimeIn during breaktime is not counted
            breakTime = 1;
        }

        // Calculate the difference in minutes
        int totalMinutesIn = parsedTimeIn.getHour() * 60 + parsedTimeIn.getMinute();
        int totalMinutesOut = parsedTimeOut.getHour() * 60 + parsedTimeOut.getMinute();

        int workedMinutes = totalMinutesOut - totalMinutesIn;

        // Calculate the worked hours. only consider hours. paid by the hour.
        int workedHour = workedMinutes / 60;

        int workedHour_ = workedHour - breakTime;

        return workedHour_;

    }

    public static Integer regularWorkedHoursComputation(ArrayList< Integer> dailyWorkedHours, Integer maxRegularHours) {
        ArrayList<Integer> dailyRegularHour = new ArrayList<>();

        int totalRegularHour = 0;

        for (int i = 0; i < dailyWorkedHours.size(); i++) {
            int dailyRegular = Math.min(dailyWorkedHours.get(i), maxRegularHours);
            dailyRegularHour.add(dailyRegular);
            totalRegularHour += dailyRegular;
        }
        return totalRegularHour;
    }

    public static Integer overtimeComputation(ArrayList< Integer> dailyWorkedHours, Integer maxRegularHours) {
        ArrayList<Integer> dailyOvertimeHour = new ArrayList<>();

        int totalOvertimeHour = 0;

        for (int i = 0; i < dailyWorkedHours.size(); i++) {
            int dailyOvertime = dailyWorkedHours.get(i) - maxRegularHours;
            if (dailyOvertime > 0) {
                dailyOvertimeHour.add(dailyOvertime);
                totalOvertimeHour += dailyOvertime;
            } else {
                dailyOvertime = 0;
                dailyOvertimeHour.add(dailyOvertime);
            }
        }

        return totalOvertimeHour;
    }

}
