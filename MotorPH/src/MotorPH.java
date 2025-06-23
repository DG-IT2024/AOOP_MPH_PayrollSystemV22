/*
Notes:
Time in 12:00 to 13:00. no counted
Time in before 8:00. credited as regular paid hour
Maximum regular paid hours is 8hours
text file contents name of employee and timeIn/timeOut per covered period
Enter Time without spacing. 
Separate entry with comma
Write Time In followed by Timeout.
Time should follow HH:MM format
Deductions and benefits will only be considered as part of the end-the-month payroll
 
work on this sheet if employee is wholeday absent
and consider overtime

 */
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalTime;

public class MotorPH {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Provide filePath of text file?\n(Example. C:\\Users\\danilo\\Downloads\\RomualdezFredrick_020124.txt )");

        String filepath = scan.nextLine();

        ArrayList<String> inputs = extractData(filepath);

        scan.close();
        //Extract LastName and First Name. Use as search criterion
        String searchLastName;
        searchLastName = inputs.get(1);

        String searchFirstName;
        searchFirstName = inputs.get(2);

        String coveredDateStart;
        coveredDateStart = inputs.get(4);

        String coveredDateEnd;
        coveredDateEnd = inputs.get(5);

        int coveredDays;
        coveredDays = Integer.parseInt(inputs.get(7));

        Double payAdjustments;
        payAdjustments = Double.valueOf(inputs.get(9));

        Double overtimeHour;
        overtimeHour = Double.valueOf(inputs.get(13));
                
        Double overtimeRate;
        overtimeRate = Double.valueOf(inputs.get(14));

        ArrayList<String> timeSheet = new ArrayList<>(inputs.subList(18, inputs.size()));

        //Extract date. Use as criterion to determine deduction and benefits
        Boolean statusPayroll = qualifierBenefitsDeduction(coveredDateEnd);  //deduction and benefit qualifier

        //determine the values of each variable
        int index_ = determineIndex(searchLastName, searchFirstName);

        double grossSemi_monthlyRate = basicSalaryDatabase(index_) / 2;
        double basicSalary = basicSalaryDatabase(index_);
        double hourlyRate = hourlyRateDatabase(index_);
        int employeeNumber = employeeNumberDatabase(index_);
        
                
        //Benefits
        double riceSubsidy;
        double phoneAllowance;
        double clothingAllowance;

        if (statusPayroll) {
            riceSubsidy = riceSubsidyDatabase(index_);
            phoneAllowance = phoneAllowanceDatabase(index_);
            clothingAllowance = clothingAllowanceDatabase(index_);
        } else {
            riceSubsidy = 0;
            phoneAllowance = 0;
            clothingAllowance = 0;

        }
        double totalBenefits = riceSubsidy + phoneAllowance + clothingAllowance;

        //Government Deductions (SSS, PhilHealth, Pagibig)
        double sssDeduction;
        double philHealthDeduction;
        double pagIbigDeduction;

        if (statusPayroll) {
            sssDeduction = calculateSSSDeduction(basicSalary);
            philHealthDeduction = calculatePhilHealthDeduction(basicSalary);
            pagIbigDeduction = calculatePagIbigDeduction(basicSalary);

        } else {
            sssDeduction = 0;
            philHealthDeduction = 0;
            pagIbigDeduction = 0;
        }

        double benefitDeduction = sssDeduction + pagIbigDeduction + philHealthDeduction;

        double netMonthPay = basicSalary - benefitDeduction;
        double withHoldingTax;

        if (statusPayroll) {
            withHoldingTax = calculateWithholdingTax(netMonthPay);

        } else {
            withHoldingTax = 0;
        }
        double totalDeduction = withHoldingTax + benefitDeduction;

        //create timesheet containing timeIN and time 
        ArrayList<String> timeIn = extractTimeIn(timeSheet);
        ArrayList<String> timeOut = extractTimeOut(timeSheet);

        //Create arrayList compute worked hours per day
        ArrayList< Integer> dailyWorkedHours = new ArrayList<>();
        for (int i = 0; i < timeIn.size(); i++) {
            dailyWorkedHours.add(calculateWorkedHours(timeIn.get(i), timeOut.get(i)));
        }

        int totalWorked = 0;
        for (int num : dailyWorkedHours) {
            totalWorked += num;
        }

        // Computation of Earnings
        double dailyRateCutoff = grossSemi_monthlyRate / coveredDays;
        double hourlyRateCutoff = dailyRateCutoff / 8; //regular hours per day 
        double grossIncome = hourlyRateCutoff * totalWorked;
        double overtimePay = overtimeHour*overtimeRate*hourlyRateCutoff ;
        double takeHomePay = grossIncome - totalDeduction + totalBenefits;
        String employeePosition_ = employeePosition(index_);
               
        String textFileName = "C:\\Users\\danilo\\Downloads\\"+searchLastName + searchFirstName +".txt";
        
        // Print Personal Information Section
        int printOutWidth = 55;
        System.out.printf("%" + (55 + "EMPLOYEE PAYSLIP".length()) / 2 + "s%n", "EMPLOYEE PAYSLIP");
        System.out.println("-".repeat(printOutWidth));
        System.out.println("EMPLOYEE INFORMATION:");
        System.out.printf("%-30s: %s, %s%n", "Name", searchLastName, searchFirstName);
        System.out.printf("%-30s: %s%n", "Employee Position/ Department", employeePosition_);
        System.out.printf("%-30s: %s%n", "Employee Number", employeeNumber);
        System.out.printf("%-30s: %s%n", "Period Start Date", coveredDateStart);
        System.out.printf("%-30s: %s%n", "Period End Date", coveredDateEnd);
        System.out.printf("%-30s: %s%n", "Cut-off Covered Days", coveredDays);

        // Print Earnings Section
        System.out.println("\nEARNINGS:");
        System.out.printf("%-30s: P%,.2f%n", "Basic Salary", basicSalary);
        System.out.printf("%-30s: P%,.2f%n", "Semi-monthly Rate", grossSemi_monthlyRate);
        System.out.printf("%-30s: %d%n", "Total Worked Hours", totalWorked);
        System.out.printf("%-30s: P%,.2f%n", "Overtime Hour", overtimeHour);
        System.out.printf("%-30s: P%,.2f%n", "Overtime Pay", overtimePay);
        System.out.printf("%-30s: P%,.2f%n", "Gross Income", grossIncome);

        // Print Deductions Section
        System.out.println("\nDEDUCTIONS:");
        System.out.printf("%-30s: P%,.2f%n", "SSS Deduction", sssDeduction);
        System.out.printf("%-30s: P%,.2f%n", "PhilHealth Deduction", philHealthDeduction);
        System.out.printf("%-30s: P%,.2f%n", "Pag-Ibig Deduction", pagIbigDeduction);
        System.out.printf("%-30s: P%,.2f%n", "Withholding Tax", withHoldingTax);
        System.out.printf("%-30s: P%,.2f%n", "Total Deduction", totalDeduction);

        // Print Benefits Section
        System.out.println("\nBENEFITS ");
        System.out.printf("%-30s: P%,.2f%n", "Rice Subsidy", riceSubsidy);
        System.out.printf("%-30s: P%,.2f%n", "phone Allowance", phoneAllowance);
        System.out.printf("%-30s: P%,.2f%n", "Clothing Allowance", clothingAllowance);
        System.out.printf("%-30s: P%,.2f%n", "Total Benefits", totalBenefits);

        // Print Summary Section
        System.out.println("\nSUMMARY:");
        System.out.printf("%-30s: P%,.2f%n", "Gross Income", grossIncome);
        System.out.printf("%-30s: P%,.2f%n", "Total Deduction", totalDeduction);
        System.out.printf("%-30s: P%,.2f%n", "Pay Adjustments", payAdjustments);
        System.out.printf("%-30s: P%,.2f%n", "Take-Home Pay", takeHomePay);

        }



    public static ArrayList<String> extractData(String filePath) {
        File filePath_ = new File(filePath);

        try {
            Scanner criteria = new Scanner(filePath_);

            ArrayList<String> inputs = new ArrayList<>();

            while (criteria.hasNextLine()) {
                String inputline = criteria.nextLine(); //before "\n" newline charter

                String[] elements = inputline.split(","); // Split input by delimiter ","
                for (String element : elements) {
                    inputs.add(element.trim()); // Trim spaces and add each element
                }

            }

            // Close the Scanner after the loop
            criteria.close();

            return inputs;

        } catch (FileNotFoundException e) {
            System.out.println("Text file not found");
        }
        return null;
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

    public static int calculateWorkedHours(String TimeIn, String TimeOut) {
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

        if (parsedTime1.isBefore(targetTime) && hour_TimeIN == 8) {  //if within graceperiod 8:00AM - 8:10AM. set TimeIN = 8:00AM
            minute_TimeIN = 0;
        }

        // Calculate the difference in minutes
        int totalMinutes1 = hour_TimeIN * 60 + minute_TimeIN;
        int totalMinutes2 = hour_TimeOut * 60 + minute_TimeOut;

        int workedMinutes = totalMinutes2 - totalMinutes1;

        // Calculate the worked hours. only consider hours. paid by the hour.
        int workedHour = workedMinutes / 60;

        LocalTime breakStart = LocalTime.of(12, 1);//Set breaktime starts 12PM
        LocalTime breakEnd = LocalTime.of(12, 59);//Set breaktime ends 12:59PM

        LocalTime parsedTime2 = LocalTime.parse(TimeOut); // Parse the TimeOut into a LocalTime object

        int breakTime = 0; // initialize breakTime
        if (parsedTime1.isBefore(breakStart) && parsedTime2.isAfter(breakEnd)) { //TimeIn after 12:00PM but before 1:00PM, not counted
            breakTime = 1;
        }

        int worked_ = workedHour - breakTime;

        int maxHour = 8; // set maximum paid regular hour  
        int workedHour_ = Math.min(worked_, maxHour);

        return workedHour_;

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

    public static double calculateWithholdingTax(double taxableMonthlyPay) {
        double[] BIRincomeThresholds = {
            20833,
            33333,
            66667,
            166667,
            666667,};
        double[] BIRTaxRate = {0,
            0.2 * (taxableMonthlyPay - BIRincomeThresholds[0]),
            2500 + 0.25 * (taxableMonthlyPay - BIRincomeThresholds[1]),
            10833 + 0.3 * (taxableMonthlyPay - BIRincomeThresholds[2]),
            40833.33 + 0.32 * (taxableMonthlyPay - BIRincomeThresholds[3]),
            200833.33 + 0.35 * (taxableMonthlyPay - BIRincomeThresholds[4]),};

        double whTax = 0;
        for (int i = 0; i < BIRincomeThresholds.length; i++) {
            if (taxableMonthlyPay < BIRincomeThresholds[i]) {
                whTax = BIRTaxRate[i];
                break;
            } else {
                whTax = BIRTaxRate[i + 1];
            }
        }
        return whTax;
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

    public static double calculatePagIbigDeduction(double basicSalary) {
        double pagIBIG = 0;

        if (basicSalary >= 1000 && basicSalary <= 1500) {
            pagIBIG = basicSalary * 0.02;
        } else if (basicSalary > 1500) {
            pagIBIG = basicSalary * 0.01;
        }

        double maxContribution = 100.0; // ( need to verify) set max pag-ibig contribution to 100 
        double pagIBIG_ = Math.min(pagIBIG, maxContribution);

        return pagIBIG_;
    }

    public static double calculatePhilHealthDeduction(double basicSalary) {
        double philHealth = basicSalary * 0.03 / 2; // Employees contribution half of 3% of basicSalary.2020 mandate

        int minValue = 300 / 2; // Example minimum value
        int maxValue = 1800 / 2; // Example maximum value
        double philHealth_;
        philHealth_ = Math.min(Math.max(philHealth, minValue), maxValue);

        return philHealth_;
    }

    public static int determineIndex(String searchLastName, String searchFirstName) {
        String[] lastName = {
            "Garcia",
            "Lim",
            "Aquino",
            "Reyes",
            "Hernandez",
            "Villanueva",
            "San Jose",
            "Romualdez",
            "Atienza",
            "Alvaro",
            "Salcedo",
            "Lopez",
            "Farala",
            "Martinez",
            "Romualdez",
            "Mata",
            "De Leon",
            "San Jose",
            "Rosario",
            "Bautista",
            "Lazaro",
            "Delos Santos",
            "Santos",
            "Del Rosario",
            "Tolentino",
            "Gutierrez",
            "Manalaysay",
            "Villegas",
            "Ramos",
            "Maceda",
            "Aguilar",
            "Castro",
            "Martinez",
            "Santos"
        };

        // Create Array with First Names
        String[] firstName = {
            "Manuel III",
            "Antonio",
            "Bianca Sofia",
            "Isabella",
            "Eduard",
            "Andrea Mae",
            "Brad",
            "Alice",
            "Rosie",
            "Roderick",
            "Anthony",
            "Josie",
            "Martha",
            "Leila",
            "Fredrick",
            "Christian",
            "Selena",
            "Allison",
            "Cydney",
            "Mark",
            "Darlene",
            "Kolby",
            "Vella",
            "Tomas",
            "Jacklyn",
            "Percival",
            "Garfield",
            "Lizeth",
            "Carol",
            "Emelia",
            "Delia",
            "John Rafael",
            "Carlos Ian",
            "Beatriz"
        };
        int numberEmployee = lastName.length;

        int index_ = 0;

        ArrayList<Integer> index = new ArrayList<>();

        for (int i = 0; i < numberEmployee; i++) {
            if (lastName[i].equals(searchLastName)) {
                index.add(i);
            }
        }

        for (int i = 0; i < index.size(); i++) {
            if (firstName[index.get(i)].equals(searchFirstName)) {
                index_ = index.get(i);
            }
        }

        return index_;
    }

    public static int employeeNumberDatabase(int index_) {
        int[] employeeNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34};

        int employeeNumber_ = employeeNumber[index_];
        return employeeNumber_;
    }

    public static double basicSalaryDatabase(int index_) {
        int[] salaries = {90000, 60000, 60000, 60000, 52670, 52670, 42975, 22500, 22500, 52670,
            50825, 38475, 24000, 24000, 53500, 42975, 41850, 22500, 22500, 23250,
            23250, 24000, 22500, 22500, 24000, 24750, 24750, 24000, 22500, 22500,
            22500, 52670, 52670, 52670};

        int basicSalary = salaries[index_];
        return basicSalary;
    }

    public static double phoneAllowanceDatabase(int index_) {
        // Phone allowance based on search criteria
        int[] phoneAllowance = {2000, 2000, 2000, 1000, 1000, 800, 500, 500, 1000, 1000,
            800, 500, 500, 1000, 800, 800, 500, 500, 500, 500,
            500, 500, 500, 500, 500, 500, 500, 500, 500, 500,
            500, 1000, 1000, 1000};

        int phoneAllowance_ = phoneAllowance[index_];
        return phoneAllowance_;
    }

    public static double clothingAllowanceDatabase(int index_) {
        // Clothing allowance based on search criteria
        int[] clothingAllowance = {1000, 1000, 1000, 1000, 1000, 800, 500, 500, 1000, 1000,
            800, 500, 500, 1000, 800, 800, 500, 500, 500, 500,
            500, 500, 500, 500, 500, 500, 500, 500, 500, 500,
            500, 1000, 1000, 1000};

        int clothingAllowance_ = clothingAllowance[index_];
        return clothingAllowance_;
    }

    public static double riceSubsidyDatabase(int index_) {

        int riceSubsidy = 1500;
        return riceSubsidy;
    }

    public static double hourlyRateDatabase(int index_) {
        // hourly Rate based on search criteria
        double[] hourlyRate = {535.71, 357.14, 357.14, 357.14, 313.51, 313.51, 255.80, 133.93, 133.93,
            313.51, 302.53, 229.02, 142.86, 142.86, 318.45, 255.80, 249.11, 133.93,
            133.93, 138.39, 138.39, 142.86, 133.93, 133.93, 142.86, 147.32, 147.32,
            142.86, 133.93, 133.93, 133.93, 313.51, 313.51, 313.51};

        double hourlyRate_ = hourlyRate[index_];

        return hourlyRate_;
    }

    public static String employeePosition(int index_) {

        String[] employeePosition = {
            "Chief Executive Officer",
            "Chief Operating Officer",
            "Chief Finance Officer",
            "Chief Marketing Officer",
            "IT Operations and Systems",
            "HR Manager",
            "HR Team Leader",
            "HR Rank and File",
            "HR Rank and File",
            "Accounting Head",
            "Payroll Manager",
            "Payroll Team Leader",
            "Payroll Rank and File",
            "Payroll Rank and File",
            "Account Manager",
            "Account Team Leader",
            "Account Team Leader",
            "Account Rank and File",
            "Account Rank and File",
            "Account Rank and File",
            "Account Rank and File",
            "Account Rank and File",
            "Account Rank and File",
            "Account Rank and File",
            "Account Rank and File",
            "Account Rank and File",
            "Account Rank and File",
            "Account Rank and File",
            "Account Rank and File",
            "Account Rank and File",
            "Account Rank and File",
            "Sales & Marketing",
            "Supply Chain and Logistics",
            "Customer Service and Relations"
        };

        String employeePosition_ = employeePosition[index_];

        return employeePosition_;

    }
}
