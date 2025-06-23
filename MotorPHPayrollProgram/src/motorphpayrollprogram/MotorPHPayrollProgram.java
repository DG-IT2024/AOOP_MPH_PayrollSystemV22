/*


FEATURES:

- Display employee details based on the inputted employee number.
- Calculate gross income based on hours worked, hourly rate, and overtime pay.
- Calculate total benefits including rice subsidy, phone allowance, and clothing allowance.
- Calculate mandatory government contributions including SSS, PhilHealth, and Pag-IBIG.
- Calculate the taxable income.
- Calculate the withholding tax based on the monthly income tax bracket.
- Calculate the net income after applying all contributions and tax.
- Generate detailed monthly payslips for employees.
- Option to calculate another employee’s salary.


LIMITATIONS: 

- The program computes for a 1-month payslip.
- Work starts at 08:00 with a grace period of 10 minutes.
- The user is expected to input the correct cutoff dates for the work period, as these dates will appear on the payslip.
- The maximum number of working days in a month is 20 days.
- The fixed break time period from 12:00 to 13:00 will never be considered part of the working hours.
- Hours are only considered for hours worked per day; any excess minutes worked are disregarded.
- The maximum regular paid hours are 8 hours; exceeding this is considered overtime hours.
- The overtime rate is fixed at 125% of the hourly rate.
- The basic salary (fixed) is used to calculate SSS, PhilHealth, and Pag-ibig contributions.


*/


package MotorPHPayrollProgram;

// author Group 4

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MotorPHPayrollProgram {
    
    private static Scanner scan = new Scanner(System.in);
    
    // Attributes
    private int employeeNumber;
    private String employeeName;
    private String employeeBirthday;
    private String address;
    private String phoneNumber;
    private String sssNumber;
    private String philHealthNumber;
    private String tinNumber;
    private String pagIbigNumber;
    private String status;
    private String position;
    private String immediateSupervisor;
    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossSemiMonthlyRate;
    private double hourlyRate;
            

    // Constructor
    public MotorPHPayrollProgram(int employeeNumber, String employeeName, String employeeBirthday, String address, String phoneNumber, String sssNumber, String philHealthNumber, String tinNumber, String pagIbigNumber, String status, String position, String immediateSupervisor, double basicSalary, double riceSubsidy, double phoneAllowance, double clothingAllowance, double grossSemiMonthlyRate, double hourlyRate) {
        this.employeeNumber = employeeNumber;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.sssNumber = sssNumber;
        this.philHealthNumber = philHealthNumber;
        this.tinNumber = tinNumber;
        this.pagIbigNumber = pagIbigNumber;
        this.status = status;
        this.position = position;
        this.immediateSupervisor = immediateSupervisor;
        this.basicSalary = basicSalary;
        this.riceSubsidy = riceSubsidy;
        this.phoneAllowance = phoneAllowance;
        this.clothingAllowance = clothingAllowance;
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
        this.hourlyRate = hourlyRate;
    }

    
    public static void main(String[] args) {
        runPayrollProgram();
    }
    
    
    public static void runPayrollProgram() {
        // Call methods
        MotorPHPayrollProgram[] employees = initializeEmployees();
        employeeList();
        int employeeNumber = employeeDetailsPresentation(employees);
        String[] dates = workPeriod();
        int[] daysAndHoursWorked = monthlyHoursWorkedCalculation();
        double overtimePay = overtimeCalculation(employees, employeeNumber, daysAndHoursWorked[2]);
        double grossIncome = grossIncomeCalculation(employees, employeeNumber, daysAndHoursWorked[1], overtimePay);
        double totalBenefits = totalBenefitsCalculation(employees, employeeNumber);
        double sssMonthlyContribution = sssCalculation(employees, employeeNumber);
        double[] philHealthContribution = philHealthCalculation(employees, employeeNumber);
        double pagIbigMonthlyContribution = pagIbigCalculation(employees, employeeNumber);
        double totalMonthlyContribution = governmentContributions(sssMonthlyContribution, philHealthContribution[1], pagIbigMonthlyContribution);
        double taxableIncome = taxableIncomeCalculation(grossIncome, totalMonthlyContribution);
        double[] taxAndNetIncome = withholdingTaxCalculation(taxableIncome);
        double totalDeductions = summary(sssMonthlyContribution, philHealthContribution[1], pagIbigMonthlyContribution, taxAndNetIncome[0], taxAndNetIncome[1]);
        
        String userInput;
        
        // Handle input validation
        do {
            try {
                // Ask user for an input to generate payslip
                System.out.print("\nDo you want to generate the monthly payslip?   ");
                userInput = scan.nextLine();
                
                // Make the input case insensitive
                userInput = userInput.toLowerCase();

                // Make the input spelling insensitive
                if (userInput.contains("y")) {
                    generatePayslip(employees, employeeNumber, dates[0], dates[1], daysAndHoursWorked[0], daysAndHoursWorked[1], daysAndHoursWorked[2], overtimePay, grossIncome, totalBenefits, sssMonthlyContribution, philHealthContribution[0], philHealthContribution[1], pagIbigMonthlyContribution, totalMonthlyContribution, taxableIncome, taxAndNetIncome[0], taxAndNetIncome[1], totalDeductions);
                    break;
                } else if (userInput.contains("n")) {
                    break;
                } else {
                    System.out.println("ERROR: Please enter yes or no.");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Please enter yes or no.");
            } catch (Exception e) {
                System.out.println("ERROR: Something went wrong.");
            }
        } while (true);
        
        calculateAnotherSalary();
    }
    
    
    public void displayEmployeeInformation() {
        // Create title
        System.out.println("\n\nEMPLOYEE DETAILS");
        
        // Print employee details
        System.out.println(
                "    Employee #:                                " + employeeNumber + "\n" +
                "    Employee Name:                             " + employeeName + "\n" + 
                "    Date of Birth:                             " + employeeBirthday + "\n" +
                "    Address:                                   " + address + "\n" +
                "    Phone Number:                              " + phoneNumber + "\n" +
                "    SSS #:                                     " + sssNumber + "\n" +
                "    Philhealth #:                              " + philHealthNumber + "\n" +
                "    TIN #:                                     " + tinNumber + "\n" +
                "    Pag-ibig #:                                " + pagIbigNumber + "\n" +
                "    Status:                                    " + status + "\n" +
                "    Position:                                  " + position + "\n" +
                "    Immediate Supervisor:                      " + immediateSupervisor + "\n" +
                "    Basic Salary:                              " + basicSalary + "\n" +
                "    Rice Subsidy:                              " + riceSubsidy + "\n" +
                "    Phone Allowance:                           " + phoneAllowance + "\n" +
                "    Clothing Allowance:                        " + clothingAllowance + "\n" +
                "    Gross Semi-monthly Rate:                   " + grossSemiMonthlyRate + "\n" +
                "    Hourly Rate:                               " + hourlyRate
        );
    }


    public static MotorPHPayrollProgram[] initializeEmployees() {
        // Create array to store employee objects
        MotorPHPayrollProgram[] employees = new MotorPHPayrollProgram[34];

        // Initializing employee objects
        employees[0] = new MotorPHPayrollProgram(1, "Manuel Garcia III", "10/11/1983", "Valero Carpark Building Valero Street 1227, Makati City", "966-860-270", "44-4506057-3", "820126853951", "442-605-657-000", "691295330870", "Regular", "Chief Executive Officer", "N/A", 90000, 1500, 2000, 1000, 45000, 535.71);
        employees[1] = new MotorPHPayrollProgram(2, "Antonio Lim", "06/19/1988", "San Antonio De Padua 2, Block 1 Lot 8 and 2, Dasmarinas, Cavite", "171-867-411", "52-2061274-9", "331735646338", "683-102-776-000", "663904995411", "Regular", "Chief Operating Officer", "Garcia, Manuel III", 60000, 1500, 2000, 1000, 30000, 357.14);
        employees[2] = new MotorPHPayrollProgram(3, "Bianca Sofia Aquino", "08/04/1989", "Rm. 402 4/F Jiao Building Timog Avenue Cor. Quezon Avenue 1100, Quezon City", "966-889-370", "30-8870406-2", "177451189665", "971-711-280-000", "171519773969", "Regular", "Chief Finance Officer", "Garcia, Manuel III", 60000, 1500, 2000, 1000, 30000, 357.14);
        employees[3] = new MotorPHPayrollProgram(4, "Isabella Reyes", "06/16/1994", "460 Solanda Street Intramuros 1000, Manila", "786-868-477", "40-2511815-0", "341911411254", "876-809-437-000", "416946776041", "Regular", "Chief Marketing Officer", "Garcia, Manuel III", 60000, 1500, 2000, 1000, 30000, 357.14);
        employees[4] = new MotorPHPayrollProgram(5, "Eduard Hernandez", "09/23/1989", "National Highway, Gingoog, Misamis Occidental", "088-861-012", "50-5577638-1", "957436191812", "031-702-374-000", "952347222457", "Regular", "IT Operations and Systems", "Lim, Antonio", 52670, 1500, 1000, 1000, 26335, 313.51);
        employees[5] = new MotorPHPayrollProgram(6, "Andrea Mae Villanueva", "02/14/1988", "17/85 Stracke Via Suite 042, Poblacion, Las Pinas 4783 Dinagat Islands", "918-621-603", "49-1632020-8", "382189453145", "317-674-022-000", "441093369646", "Regular", "HR Manager", "Lim, Antonio", 52670, 1500, 1000, 1000, 26335, 313.51);
        employees[6] = new MotorPHPayrollProgram(7, "Brad San Jose", "03/15/1996", "99 Strosin Hills, Poblacion, Bislig 5340 Tawi-Tawi", "797-009-261", "40-2400714-1", "239192926939", "672-474-690-000", "210850209964", "Regular", "HR Team Leader", "Villanueva, Andrea Mae", 42975, 1500, 800, 800, 21488, 255.80);
        employees[7] = new MotorPHPayrollProgram(8, "Alice Romualdez", "05/14/1992", "12A/33 Upton Isle Apt. 420, Roxas City 1814 Surigao del Norte", "983-606-799", "55-4476527-2", "545652640232", "888-572-294-000", "211385556888", "Regular", "HR Rank and File", "San, Jose Brad", 22500, 1500, 500, 500, 11250, 133.93);
        employees[8] = new MotorPHPayrollProgram(9, "Rosie Atienza", "09/24/1948", "90A Dibbert Terrace Apt. 190, San Lorenzo 6056 Davao del Norte", "266-036-427", "41-0644692-3", "708988234853", "604-997-793-000", "260107732354", "Regular", "HR Rank and File", "San, Jose Brad", 22500, 1500, 500, 500, 11250, 133.93);
        employees[9] = new MotorPHPayrollProgram(10, "Roderick Alvaro", "03/30/1988", "#284 T. Morato corner, Scout Rallos Street, Quezon City", "053-381-386", "64-7605054-4", "578114853194", "525-420-419-000", "799254095212", "Regular", "Accounting Head", "Aquino, Bianca Sofia", 52670, 1500, 1000, 1000, 26335, 313.51);
        employees[10] = new MotorPHPayrollProgram(11, "Anthony Salcedo", "09/14/1993", "93/54 Shanahan Alley Apt. 183, Santo Tomas 1572 Masbate", "070-766-300", "26-9647608-3", "126445315651", "210-805-911-000", "218002473454", "Regular", "Payroll Manager", "Alvaro, Roderick", 50825, 1500, 1000, 1000, 25413, 302.53);
        employees[11] = new MotorPHPayrollProgram(12, "Josie Lopez", "01/14/1987", "49 Springs Apt. 266, Poblacion, Taguig 3200 Occidental Mindoro", "478-355-427", "44-8563448-3", "431709011012", "218-489-737-000", "113071293354", "Regular", "Payroll Team Leader", "Salcedo, Anthony", 38475, 1500, 800, 800, 19238, 229.02);
        employees[12] = new MotorPHPayrollProgram(13, "Martha Farala", "01/11/1942", "42/25 Sawayn Stream, Ubay 1208 Zamboanga del Norte", "329-034-366", "45-5656375-0", "233693897247", "210-835-851-000", "631130283546", "Regular", "Payroll Rank and File", "Salcedo, Anthony", 24000, 1500, 500, 500, 12000, 142.86);
        employees[13] = new MotorPHPayrollProgram(14, "Leila Martinez", "07/11/1970", "37/46 Kulas Roads, Maragondon 0962 Quirino", "877-110-749", "27-2090996-4", "515741057496", "275-792-513-000", "101205445886", "Regular", "Payroll Rank and File", "Salcedo, Anthony", 24000, 1500, 500, 500, 12000, 142.86);
        employees[14] = new MotorPHPayrollProgram(15, "Fredrick Romualdez", "03/10/1985", "22A/52 Lubowitz Meadows, Pililla 4895 Zambales", "023-079-009", "26-8768374-1", "308366860059", "598-065-761-000", "223057707853", "Regular", "Account Manager", "Lim, Antonio", 53500, 1500, 1000, 1000, 26750, 318.45);
        employees[15] = new MotorPHPayrollProgram(16, "Christian Mata", "10/21/1987", "90 O'Keefe Spur Apt. 379, Catigbian 2772 Sulu", "783-776-744", "49-2959312-6", "824187961962", "103-100-522-000", "631052853464", "Regular", "Account Team Leader", "Romualdez, Fredrick", 42975, 1500, 800, 800, 21488, 255.80);
        employees[16] = new MotorPHPayrollProgram(17, "Selena De Leon", "02/20/1975", "89A Armstrong Trace, Compostela 7874 Maguindanao", "975-432-139", "27-2090208-8", "587272469938", "482-259-498-000", "719007608464", "Regular", "Account Team Leader", "Romualdez, Fredrick", 41850, 1500, 800, 800, 20925, 249.11);
        employees[17] = new MotorPHPayrollProgram(18, "Allison San Jose", "06/24/1986", "08 Grant Drive Suite 406, Poblacion, Iloilo City 9186 La Union", "179-075-129", "45-3251383-0", "745148459521", "121-203-336-000", "114901859343", "Regular", "Account Rank and File", "Mata, Christian", 22500, 1500, 500, 500, 11250, 133.93);
        employees[18] = new MotorPHPayrollProgram(19, "Cydney Rosario", "10/06/1996", "93A/21 Berge Points, Tapaz 2180 Quezon", "868-819-912", "49-1629900-2", "579253435499", "122-244-511-000", "265104358643", "Regular", "Account Rank and File", "Mata, Christian", 22500, 1500, 500, 500, 11250, 133.93);
        employees[19] = new MotorPHPayrollProgram(20, "Mark Bautista", "02/12/1991", "65 Murphy Center Suite 094, Poblacion, Palayan 5636 Quirino", "683-725-348", "49-1647342-5", "399665157135", "273-970-941-000", "260054585575", "Regular", "Account Rank and File", "Mata, Christian", 23250, 1500, 500, 500, 11625, 138.39);
        employees[20] = new MotorPHPayrollProgram(21, "Darlene Lazaro", "11/25/1985", "47A/94 Larkin Plaza Apt. 179, Poblacion, Caloocan 2751 Quirino", "740-721-558", "45-5617168-2", "606386917510", "354-650-951-000", "104907708845", "Probationary", "Account Rank and File", "Mata, Christian", 23250, 1500, 500, 500, 11625, 138.39);
        employees[21] = new MotorPHPayrollProgram(22, "Kolby Delos Santos", "02/26/1980", "06A Gulgowski Extensions, Bongabon 6085 Zamboanga del Sur", "739-443-033", "52-0109570-6", "357451271274", "187-500-345-000", "113017988667", "Probationary", "Account Rank and File", "Mata, Christian", 24000, 1500, 500, 500, 12000, 142.86);
        employees[22] = new MotorPHPayrollProgram(23, "Vella Santos", "12/31/1983", "99A Padberg Spring, Poblacion, Mabalacat 3959 Lanao del Sur", "955-879-269", "52-9883524-3", "548670482885", "101-558-994-000", "360028104576", "Probationary", "Account Rank and File", "Mata, Christian", 22500, 1500, 500, 500, 11250, 133.93);
        employees[23] = new MotorPHPayrollProgram(24, "Tomas Del Rosario", "12/18/1978", "80A/48 Ledner Ridges, Poblacion, Kabankalan 8870 Marinduque", "882-550-989", "45-5866331-6", "953901539995", "560-735-732-000", "913108649964", "Probationary", "Account Rank and File", "Mata, Christian", 22500, 1500, 500, 500, 11250, 133.93);
        employees[24] = new MotorPHPayrollProgram(25, "Jacklyn Tolentino", "05/19/1984", "96/48 Watsica Flats Suite 734, Poblacion, Malolos 1844 Ifugao", "675-757-366", "47-1692793-0", "753800654114", "841-177-857-000", "210546661243", "Probationary", "Account Rank and File", "De Leon, Selena", 24000, 1500, 500, 500, 12000, 142.86);
        employees[25] = new MotorPHPayrollProgram(26, "Percival Gutierrez", "12/18/1970", "58A Wilderman Walks, Poblacion, Digos 5822 Davao del Sur", "512-899-876", "40-9504657-8", "797639382265", "502-995-671-000", "210897095686", "Probationary", "Account Rank and File", "De Leon, Selena", 24750, 1500, 500, 500, 12375, 147.32);
        employees[26] = new MotorPHPayrollProgram(27, "Garfield Manalaysay", "08/28/1986", "60 Goyette Valley Suite 219, Poblacion, Tabuk 3159 Lanao del Sur", "948-628-136", "45-3298166-4", "810909286264", "336-676-445-000", "211274476563", "Probationary", "Account Rank and File", "De Leon, Selena", 24750, 1500, 500, 500, 12375, 147.32);
        employees[27] = new MotorPHPayrollProgram(28, "Lizeth Villegas", "12/12/1981", "66/77 Mann Views, Luisiana 1263 Dinagat Islands", "332-372-215", "40-2400719-4", "934389652994", "210-395-397-000", "122238077997", "Probationary", "Account Rank and File", "De Leon, Selena", 24000, 1500, 500, 500, 12000, 142.86);
        employees[28] = new MotorPHPayrollProgram(29, "Carol Ramos", "08/20/1978", "72/70 Stamm Spurs, Bustos 4550 Iloilo", "250-700-389", "60-1152206-4", "351830469744", "395-032-717-000", "212141893454", "Probationary", "Account Rank and File", "De Leon, Selena", 22500, 1500, 500, 500, 11250, 133.93);
        employees[29] = new MotorPHPayrollProgram(30, "Emelia Maceda", "04/14/1973", "50A/83 Bahringer Oval Suite 145, Kiamba 7688 Nueva Ecija", "973-358-041", "54-1331005-0", "465087894112", "215-973-013-000", "515012579765", "Probationary", "Account Rank and File", "De Leon, Selena", 22500, 1500, 500, 500, 11250, 133.93);
        employees[30] = new MotorPHPayrollProgram(31, "Delia Aguilar", "01/27/1989", "95 Cremin Junction, Surallah 2809 Cotabato", "529-705-439", "52-1859253-1", "136451303068", "599-312-588-000", "110018813465", "Probationary", "Account Rank and File", "De Leon, Selena", 22500, 1500, 500, 500, 11250, 133.93);
        employees[31] = new MotorPHPayrollProgram(32, "John Rafael Castro", "02/09/1992", "Hi-way, Yati, Liloan Cebu", "332-424-955", "26-7145133-4", "601644902402", "404-768-309-000", "697764069311", "Regular", "Sales & Marketing", "Reyes, Isabella", 52670, 1500, 1000, 1000, 26335, 313.51);
        employees[32] = new MotorPHPayrollProgram(33, "Carlos Ian Martinez", "11/16/1990", "Bulala, Camalaniugan", "078-854-208", "11-5062972-7", "380685387212", "256-436-296-000", "993372963726", "Regular", "Supply Chain and Logistics", "Reyes, Isabella", 52670, 1500, 1000, 1000, 26335, 313.51);
        employees[33] = new MotorPHPayrollProgram(34, "Beatriz Santos", "08/07/1990", "Agapita Building, Metro Manila", "526-639-511", "20-2987501-5", "918460050077", "911-529-713-000", "874042259378", "Regular", "Customer Service and Relations", "Reyes, Isabella", 52670, 1500, 1000, 1000, 26335, 313.51);
        
        return employees;
    }
    
    public static void employeeList() {
        System.out.printf("========================================================================================================================");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("%-49s%-32s%39s", "|", "MOTORPH EMPLOYEE LIST", "|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("|======================================================================================================================|");
        System.out.println();
        System.out.printf("%1s%-39s%1s%-39s%1s%-38s%1s", "|", "     1   -   Manuel Garcia III", "|", "     13  -   Martha Farala", "|", "     25  -   Jacklyn Tolentino", "|");
        System.out.println();
        System.out.printf("%1s%-39s%1s%-39s%1s%-38s%1s", "|", "     2   -   Antonio Lim", "|", "     14  -   Leila Martinez", "|", "     26  -   Percival Gutierrez", "|");
        System.out.println();
        System.out.printf("%1s%-39s%1s%-39s%1s%-38s%1s", "|", "     3   -   Bianca Sofia Aquino", "|", "     15  -   Fredrick Romualdez", "|", "     27  -   Garfield Manalaysay", "|");
        System.out.println();
        System.out.printf("%1s%-39s%1s%-39s%1s%-38s%1s", "|", "     4   -   Isabella Reyes", "|", "     16  -   Christian Mata", "|", "     28  -   Lizeth Villegas", "|");
        System.out.println();
        System.out.printf("%1s%-39s%1s%-39s%1s%-38s%1s", "|", "     5   -   Eduard Hernandez", "|", "     17  -   Selena De Leon", "|", "     29  -   Carol Ramos", "|");
        System.out.println();
        System.out.printf("%1s%-39s%1s%-39s%1s%-38s%1s", "|", "     6   -   Andrea Mae Villanueva", "|", "     18  -   Allison San Jose", "|", "     30  -   Emelia Maceda", "|");
        System.out.println();
        System.out.printf("%1s%-39s%1s%-39s%1s%-38s%1s", "|", "     7   -   Brad San Jose", "|", "     19  -   Cydney Rosario", "|", "     31  -   Delia Aguilar", "|");
        System.out.println();
        System.out.printf("%1s%-39s%1s%-39s%1s%-38s%1s", "|", "     8   -   Alice Romualdez", "|", "     20  -   Mark Bautista", "|", "     32  -   John Rafael Castro", "|");
        System.out.println();
        System.out.printf("%1s%-39s%1s%-39s%1s%-38s%1s", "|", "     9   -   Rosie Atienza", "|", "     21  -   Darlene Lazaro", "|", "     33  -   Carlos Ian Martinez", "|");
        System.out.println();
        System.out.printf("%1s%-39s%1s%-39s%1s%-38s%1s", "|", "     10  -   Roderick Alvaro", "|", "     22  -   Kolby Delos Santos  ", "|", "     34  -   Beatriz Santos", "|");
        System.out.println();
        System.out.printf("%1s%-39s%1s%-39s%1s%-38s%1s", "|", "     11  -   Anthony Salcedo", "|", "     23  -   Vella Santos", "|", "", "|");
        System.out.println();
        System.out.printf("%1s%-39s%1s%-39s%1s%-38s%1s", "|", "     12  -   Josie Lopez", "|", "     24  -   Tomas Del Rosario", "|", "", "|");
        System.out.println();
        System.out.printf("========================================================================================================================");
        System.out.println();
        System.out.println();
        System.out.println();
    }
    
    
    public static int employeeDetailsPresentation(MotorPHPayrollProgram[] employees) {
        int employeeNumber;
        
        // Handle input validation
        do {
            try {
                // Prompt user to enter employee number
                System.out.printf("%-47s", "Enter employee number: ");
                employeeNumber = scan.nextInt();

                // Consume excess line
                scan.nextLine();

                // Display employee information based on the entered employee number
                if (employeeNumber >= 1 && employeeNumber <= 34) {
                    employees[employeeNumber - 1].displayEmployeeInformation();
                    return employeeNumber;
                } else {
                    System.out.println("ERROR: Employee not found. Please enter a valid employee number between 1 and 34.");
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Please enter an integer.");
                scan.nextLine(); // Consume invalid input
                System.out.println();
            } catch (Exception e) {
                System.out.println("ERROR: Something went wrong.");
                scan.nextLine(); // Consume invalid input
                System.out.println();
            }
        } while (true);
    }


    public static String[] workPeriod() {
        LocalDate startDate;
        LocalDate endDate;
        
        // Create title
        System.out.println("\n\nMONTHLY WORK PERIOD (type in MM/DD/YYYY format)");
        
        // Set the format to expect a 24-hour clock format from the user
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        
        // Handle input validation
        do {
            try {
                // Prompt user for work period dates
                System.out.printf("%-4s%-43s", "", "Start date: ");
                String start = scan.nextLine();

                System.out.printf("%-4s%-43s", "", "End date: ");
                String end = scan.nextLine();
                
                startDate = LocalDate.parse(start, formatTime);
                endDate = LocalDate.parse(end, formatTime);

                // If parsing succeeds, break the loop
                break;
            } catch (DateTimeParseException e) {
                System.out.println("    ERROR: Please enter a valid time in MM/DD/YYYY format.");
                System.out.println();
            } catch (Exception e) {
                System.out.println("    ERROR: Something went wrong.");
                System.out.println();
            }
        } while (true);
        
        String workStartDate = startDate.format(formatTime);
        String workEndDate = endDate.format(formatTime);
        
        String[] dates = {workStartDate, workEndDate};
        return dates;
    }
    
    
    public static int[] monthlyHoursWorkedCalculation() {
        int numberOfWorkDays = 0;
        int totalRegularHoursWorkedInAMonth = 0;
        int totalOvertimeHoursWorkedInAMonth = 0;
        
        // Set the format to expect a 24-hour clock format from the user
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm");
        
        // Create title
        System.out.println("\n\nHOURS WORKED CALCULATOR (input time in HH:mm format)");
        
        // Handle input validation
        do {
            try {
                // Ask user to input number of work days in a month
                System.out.printf("%-4s%-43s", "", "Enter no. of work days in a month: ");
                numberOfWorkDays = scan.nextInt();

                scan.nextLine(); // Consume excess line

                if (numberOfWorkDays >= 0 && numberOfWorkDays <= 20) {
                    break;
                } else {
                    System.out.println("    ERROR: Please enter a number of work days between 0 and 20.");
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("    ERROR: Please enter an integer.");
                scan.nextLine(); // Consume invalid input
                System.out.println();
            } catch (Exception e) {
                System.out.println("    ERROR: Something went wrong.");
                scan.nextLine(); // Consume invalid input
                System.out.println();
            }
        } while (true);
        
        // Iterate over each day of the month
        for (int i = 0; i < numberOfWorkDays; i++) {
            String clockInTime;
            String clockOutTime;    
            LocalTime clockIn;
            LocalTime clockOut;
            
            // Handle input validation
            do {
                try {
                    // Print the day number
                    System.out.println();
                    System.out.printf("%-4s%-43s", "", "DAY " + (i + 1));
                    System.out.println();
            
                    // Prompt user for clock-in and clock-out times
                    System.out.printf("%-8s%-39s", "", "Clock-in: ");
                    clockInTime = scan.nextLine();

                    System.out.printf("%-8s%-39s", "", "Clock-out: ");
                    clockOutTime = scan.nextLine();

                    // Parse clock-in and clock-out times
                    clockIn = LocalTime.parse(clockInTime, formatTime);
                    clockOut = LocalTime.parse(clockOutTime, formatTime);

                    // If parsing succeeds, break the loop
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("        ERROR: Please enter a valid time in HH:mm format.");
                } catch (Exception e) {
                    System.out.println("        ERROR: Something went wrong.");
                }
            } while (true);

            // Initialize variables
            Duration total = Duration.between(clockIn, clockOut);
            int totalWorkedHours = total.toHoursPart();
            int regularHours = 0;
            int overtimeHours = 0;
            int clockInMinutes = clockIn.getMinute();
            int clockOutMinutes = clockOut.getMinute();
            
            // For considering grace period of 08:00 to 08:10
            if ((clockIn.isAfter(LocalTime.of(8, 00)) && clockIn.isBefore(LocalTime.of(8, 11))) && clockInMinutes > clockOutMinutes){
                totalWorkedHours++;
            }
            
            // For calculating breaktime
            if (clockIn.isBefore(LocalTime.of(12, 00)) && clockOut.isAfter(LocalTime.of(12, 59))) {
                totalWorkedHours--;
            } else if ((clockIn.equals(LocalTime.of(12, 00)) && clockOut.equals(LocalTime.of(13, 00)))) {
                totalWorkedHours--;
            } else if (clockIn.isAfter(LocalTime.of(11, 59)) && clockOut.isBefore(LocalTime.of(13, 01))) {
                totalWorkedHours = 0;
            } else if ((clockOut.isAfter(LocalTime.of(12, 00)) && clockOut.isBefore(LocalTime.of(13, 00))) && (clockInMinutes == clockOutMinutes) && !(clockIn.isAfter(LocalTime.of(8, 00)) && clockIn.isBefore(LocalTime.of(8, 11)))) {
                totalWorkedHours--;
            } else if ((clockIn.isAfter(LocalTime.of(11, 59)) && clockIn.isBefore(LocalTime.of(13, 00))) && clockInMinutes <= clockOutMinutes) {
                totalWorkedHours--;
            } 
            
            // For calculating regular and overtime hours
            if (totalWorkedHours <= 8) {
                regularHours = totalWorkedHours;
            } else if (totalWorkedHours > 8) {
                regularHours = 8;
                overtimeHours = totalWorkedHours - regularHours;
            }

            // Print regular and overtime hours for the day
            System.out.printf("%-8s%-39s%-10s", "", "Regular Hours Worked: ", regularHours + " hours");
            System.out.println();
            System.out.printf("%-8s%-39s%-10s", "", "Overtime Hours Worked: ", overtimeHours + " hours");
            System.out.println();

            // Calculate total regular and overtime hours worked in the month
            totalRegularHoursWorkedInAMonth += regularHours;
            totalOvertimeHoursWorkedInAMonth += overtimeHours;
        }
        
        // Print the total hours worked in a month
        System.out.println();
        System.out.printf("%-4s%-43s%-20s", "", "TOTAL REGULAR HOURS WORKED IN A MONTH: ", totalRegularHoursWorkedInAMonth + " hours");
        System.out.println();
        System.out.printf("%-4s%-43s%-20s", "", "TOTAL OVERTIME HOURS WORKED IN A MONTH: ", totalOvertimeHoursWorkedInAMonth + " hours");
        System.out.println();
        System.out.println();

        int[] daysAndHoursWorked = {numberOfWorkDays, totalRegularHoursWorkedInAMonth, totalOvertimeHoursWorkedInAMonth};
        return daysAndHoursWorked;
    }
    
    
    public static double overtimeCalculation(MotorPHPayrollProgram[] employees, int employeeNumber, int totalOvertimeHoursWorkedInAMonth) {
        // Get the employee's overtime pay
        double overtimePay = employees[employeeNumber - 1].hourlyRate * 1.25 * totalOvertimeHoursWorkedInAMonth;
        return overtimePay;
    }
    

    public static double grossIncomeCalculation(MotorPHPayrollProgram[] employees, int employeeNumber, int totalRegularHoursWorkedInAMonth, double overtimePay) {
        // Get the employee's gross income by multiplying hourly rate by total hours worked plus overtime pay
        double grossIncome = (employees[employeeNumber - 1].hourlyRate * totalRegularHoursWorkedInAMonth) + overtimePay;
        return grossIncome;
    }
    
    
    public static double totalBenefitsCalculation(MotorPHPayrollProgram[] employees, int employeeNumber) {
        // Get the sum of employee benefits
        double totalBenefits = employees[employeeNumber - 1].riceSubsidy + employees[employeeNumber - 1].phoneAllowance + employees[employeeNumber - 1].clothingAllowance;
        return totalBenefits;
    }
    
    
    public static double sssCalculation(MotorPHPayrollProgram[] employees, int employeeNumber) {
        double sssMonthlyContribution = 0;
                
        double[] BASICSALARY_RANGES = {
        3250, 3750, 4250, 4750, 5250, 5750, 6250, 6750, 7250, 7750,
        8250, 8750, 9250, 9750, 10250, 10750, 11250, 11750, 12250, 12750,
        13250, 13750, 14250, 14750, 15250, 15750, 16250, 16750, 17250, 17750,
        18250, 18750, 19250, 19750, 20250, 20750, 21250, 21750, 22250, 22750,
        23250, 23750, 24250, 24750
    };
        
        double[] SSS_MONTHLY_CONTRIBUTIONS = {
        135.00, 157.50, 180.00, 202.50, 225.00, 247.50, 270.00, 292.50, 315.00, 337.50,
        360.00, 382.50, 405.00, 427.50, 450.00, 472.50, 495.00, 517.50, 540.00, 562.50,
        585.00, 607.50, 630.00, 652.50, 675.00, 697.50, 720.00, 742.50, 765.00, 787.50,
        810.00, 832.50, 855.00, 877.50, 900.00, 922.50, 945.00, 967.50, 990.00, 1012.50,
        1035.00, 1057.50, 1080.00, 1102.50
    };
        
        // Get the monthly SSS contribution based on employee's basic monthly salary
        for (int i = 0; i < BASICSALARY_RANGES.length; i++) {
            if (employees[employeeNumber - 1].basicSalary < BASICSALARY_RANGES[i]) {
                sssMonthlyContribution = SSS_MONTHLY_CONTRIBUTIONS[i];
                break;
            }
        }
        
        // For basic salary over 24,750
        if (employees[employeeNumber - 1].basicSalary >= BASICSALARY_RANGES[BASICSALARY_RANGES.length - 1]) {   
            sssMonthlyContribution = 1125.00;
        }
        
        return sssMonthlyContribution;
    }
    
    
    public static double[] philHealthCalculation(MotorPHPayrollProgram[] employees, int employeeNumber) {
        double premiumRate = 0.03;
        double monthlyPremium = 0;

        // Calculate 3% monthly premium rate based on employee's basic salary
        if (employees[employeeNumber - 1].basicSalary <= 10000) {
            monthlyPremium = 300;
        } else if (employees[employeeNumber - 1].basicSalary > 10000 && employees[employeeNumber - 1].basicSalary < 60000) {
            monthlyPremium = employees[employeeNumber - 1].basicSalary * premiumRate;
        } else if (employees[employeeNumber - 1].basicSalary >= 60000) {
            monthlyPremium = 1800;
        }
        
        // Monthly premium contribution payments are equally shared between the employee and employer.
        double employeeShare = monthlyPremium * 0.5;
        
        double[] philHealthContribution = {monthlyPremium, employeeShare};
        return philHealthContribution;
    }
    
    
    public static double pagIbigCalculation(MotorPHPayrollProgram[] employees, int employeeNumber) {
        double pagIbigMonthlyContribution = 0;
       
        if (employees[employeeNumber - 1].basicSalary >= 1000 && employees[employeeNumber - 1].basicSalary <= 1500) {
            pagIbigMonthlyContribution = employees[employeeNumber - 1].basicSalary * 0.01;
        } else if (employees[employeeNumber - 1].basicSalary > 1500) {
            pagIbigMonthlyContribution = employees[employeeNumber - 1].basicSalary * 0.02;
            
            // The maximum Pag-Ibig contribution amount is 100
            if (pagIbigMonthlyContribution > 100) {
                pagIbigMonthlyContribution = 100;
            }
        }
        
        return pagIbigMonthlyContribution;
    }
    
    
    public static double governmentContributions(double sssMonthlyContribution, double employeeShare, double pagIbigMonthlyContribution) {
        double totalMonthlyContribution = sssMonthlyContribution + employeeShare + pagIbigMonthlyContribution;
        return totalMonthlyContribution;
    }
    
    
    public static double taxableIncomeCalculation(double grossIncome, double totalMonthlyContribution) {
        double taxableIncome = grossIncome - totalMonthlyContribution;
        
        // Prevent a negative value for employee's income
        if (taxableIncome < 0) {
            taxableIncome = 0;
        }
        
        return taxableIncome;
    }
    
    
    public static double[] withholdingTaxCalculation(double taxableIncome) {
        // Withholding tax is calculated after applying deductions
        double withholdingTax = 0;
        
        // Monthly Tax Rate
        if (taxableIncome <= 20832) {
            withholdingTax = 0;
        } else if (taxableIncome >= 20833 && taxableIncome < 33333) {
            withholdingTax = (taxableIncome - 20833) * 0.20;
        } else if (taxableIncome >= 33333 && taxableIncome < 66667) {
            withholdingTax = 2500 + (taxableIncome - 33333) * 0.25;
        } else if (taxableIncome >= 66667 && taxableIncome < 166667) {
            withholdingTax = 10833 + (taxableIncome - 66667) * 0.30;
        } else if (taxableIncome >= 166667 && taxableIncome < 666667) {
            withholdingTax = 40833.33 + (taxableIncome - 166667) * 0.32;
        } else if (taxableIncome >= 666667) {
            withholdingTax = 200833.33 + (taxableIncome - 666667) * 0.35;
        }

        // Get employee's monthly net income or take home pay
        double netIncome = taxableIncome - withholdingTax;
        
        double[] taxAndNetIncome = {withholdingTax, netIncome};
        return taxAndNetIncome;
    }
    
    
    public static double summary(double sssMonthlyContribution, double employeeShare, double pagIbigMonthlyContribution, double withholdingTax, double netIncome) {
        // Total deductions breakdown
        double totalDeductions = sssMonthlyContribution + employeeShare + pagIbigMonthlyContribution + withholdingTax;
        return totalDeductions;
    }
    
    
    public static void generatePayslip(MotorPHPayrollProgram[] employees, int employeeNumber, String workStartDate, String workEndDate, int numberOfWorkDays, int totalRegularHoursWorkedInAMonth, int totalOvertimeHoursWorkedInAMonth, double overtimePay, double grossIncome, double totalBenefits, double sssMonthlyContribution, double monthlyPremium, double employeeShare, double pagIbigMonthlyContribution, double totalMonthlyContribution, double taxableIncome, double withholdingTax, double netIncome, double totalDeductions) {
        System.out.println();
        System.out.println();
        System.out.printf("========================================================================================================================");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("%-44s%32s%44s", "|", "MOTORPH MONTHLY EMPLOYEE PAYSLIP", "|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("|======================================================================================================================|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("%-18s%-50s%-20s%-30s%2s", "| PAYSLIP NO.: ", employeeNumber + "-2022-2024", "EMPLOYEE POSITION: ", employees[employeeNumber - 1].position, "|");
        System.out.println();
        System.out.printf("%-18s%-50d%-20s%-30s%2s", "| EMPLOYEE ID: ", employeeNumber, "PAY TYPE: ", "Monthly", "|");
        System.out.println();
        System.out.printf("%-18s%-50s%-20s%-30s%2s", "| FULL NAME: ", employees[employeeNumber - 1].employeeName, "PERIOD START DATE: ", workStartDate, "|");
        System.out.println();
        System.out.printf("%-18s%-50s%-20s%-30s%2s", "| DATE OF BIRTH: ", employees[employeeNumber - 1].employeeBirthday, "PERIOD END DATE: ", workEndDate, "|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("|======================================================================================================================|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("%-60s%60s", "| EARNINGS", "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35.2f%25s", "|", "Basic Monthly Salary", employees[employeeNumber - 1].basicSalary, "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35d%25s", "|", "Days Worked", numberOfWorkDays, "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20.2f%5s", "|", "Hourly Rate", "", employees[employeeNumber - 1].hourlyRate, "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20d%5s", "|", "Regular Hours Worked", "", totalRegularHoursWorkedInAMonth, "|");
        System.out.println();
        
        // Display overtime pay calculation
        if (overtimePay <= 0) {
            System.out.printf("%-6s%-54s%35s%20d%5s", "|", "Overtime Pay", "", 0, "|");
            System.out.println();
        } else if (overtimePay > 0) {
            System.out.printf("%-6s%-54s%60s", "|", "Overtime Pay", "|");
            System.out.println();
            System.out.printf("%-11s%-59s%50s", "|", "Hourly Rate * Overtime Rate * Overtime Hours Worked", "|");
            System.out.println();
            System.out.printf("%-11s%-49s%35s%20.2f%5s", "|", employees[employeeNumber - 1].hourlyRate + " * 1.25 * " + totalOvertimeHoursWorkedInAMonth, "", overtimePay, "|");
            System.out.println();
        }
        
        System.out.printf("%-6s%-109s%5s", "|", "-------------------------------------------------------------------------------------------------------------", "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20.2f%5s", "|", "GROSS INCOME", "", grossIncome, "|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("|======================================================================================================================|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("%-60s%60s", "| BENEFITS", "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20.2f%5s", "|", "Rice Subsidy", "", employees[employeeNumber - 1].riceSubsidy, "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20.2f%5s", "|", "Phone Allowance", "", employees[employeeNumber - 1].phoneAllowance, "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20.2f%5s", "|", "Clothing Allowance", "", employees[employeeNumber - 1].clothingAllowance, "|");
        System.out.println();
        System.out.printf("%-6s%-109s%5s", "|", "-------------------------------------------------------------------------------------------------------------", "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20.2f%5s", "|", "TOTAL BENEFITS", "", totalBenefits, "|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("|======================================================================================================================|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("%-60s%60s", "| GOVERNMENT CONTRIBUTIONS", "|");
        System.out.println();
        System.out.printf("%-6s%-54s%60s", "|", "Social Security System", "|");
        System.out.println();
        System.out.printf("%-11s%-49s%35s%20.2f%5s", "|", "Monthly Contribution", "", sssMonthlyContribution, "|");
        System.out.println();
        System.out.printf("%-6s%-54s%60s", "|", "PhilHealth", "|");
        System.out.println();
        System.out.printf("%-11s%-49s%35.2f%25s", "|", "3% Monthly Premium Rate", monthlyPremium, "|");
        System.out.println();
        System.out.printf("%-11s%-49s%35s%20.2f%5s", "|", "Employee Share (50%)", "", employeeShare, "|");
        System.out.println();
        System.out.printf("%-6s%-54s%60s", "|", "Pag-IBIG", "|");
        System.out.println();
        System.out.printf("%-11s%-49s%35s%20.2f%5s", "|", "2% Monthly Contribution Rate", "", pagIbigMonthlyContribution, "|");
        System.out.println();
        System.out.printf("%-6s%-109s%5s", "|", "-------------------------------------------------------------------------------------------------------------", "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20.2f%5s", "|", "TOTAL CONTRIBUTIONS", "", totalMonthlyContribution, "|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("|======================================================================================================================|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("%-60s%60s", "| TAXABLE INCOME", "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20.2f%5s", "|", "Gross Income", "", grossIncome, "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20.2f%5s", "|", "Total Government Contributions", "", totalMonthlyContribution, "|");
        System.out.println();
        System.out.printf("%-6s%-109s%5s", "|", "-------------------------------------------------------------------------------------------------------------", "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20.2f%5s", "|", "TAXABLE INCOME", "", taxableIncome, "|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("|======================================================================================================================|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("%-60s%60s", "| APPLY TAX", "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20.2f%5s", "|", "Taxable Income", "", taxableIncome, "|");
        System.out.println();
        System.out.printf("%-6s%-54s%60s", "|", "Witholding Tax", "|");
        System.out.println();
        
        // Display monthly tax rate calculation
        if (taxableIncome <= 20832) {
            System.out.printf("%-11s%-57s%27s%20.2f%5s", "|", "No withholding tax for monthly income below 20,832.00", "", withholdingTax, "|");
            System.out.println();
        } else if (taxableIncome >= 20833 && taxableIncome < 33333) {
            System.out.printf("%-11s%-49s%60s", "|", "20% in excess of 20,833.00", "|");
            System.out.println();
            System.out.printf("%-11s%-49s%35s%20.2f%5s", "|", "(" + String.format("%.2f", taxableIncome) + " - 20,833.00)" + " * 20%", "", withholdingTax, "|");
            System.out.println();
        
        } else if (taxableIncome >= 33333 && taxableIncome < 66667) {
            System.out.printf("%-11s%-49s%60s", "|", "2,500.00 plus 25% in excess of 33,333.00", "|");
            System.out.println();
            System.out.printf("%-11s%-49s%35s%20.2f%5s", "|", "2,500.00 + (" + String.format("%.2f", taxableIncome) + " - 33,333.00)" + " * 25%", "", withholdingTax, "|");
            System.out.println();
          
        } else if (taxableIncome >= 66667 && taxableIncome < 166667) {
            System.out.printf("%-11s%-49s%60s", "|", "10,833.00 plus 30% in excess of 66,667.00", "|");
            System.out.println();
            System.out.printf("%-11s%-49s%35s%20.2f%5s", "|", "10,833.00 + (" + String.format("%.2f", taxableIncome) + " - 66,667.00)" + " * 30%", "", withholdingTax, "|");
            System.out.println();
            
        } else if (taxableIncome >= 166667 && taxableIncome < 666667) {
            System.out.printf("%-11s%-49s%60s", "|", "40,833.33 plus 32% in excess over 166,667.00", "|");
            System.out.println();
            System.out.printf("%-11s%-49s%35s%20.2f%5s", "|", "40,833.33 + (" + String.format("%.2f", taxableIncome) + " - 166,667.00)" + " * 32%", "", withholdingTax, "|");
            System.out.println();
            
        } else if (taxableIncome >= 666667) {
            System.out.printf("%-11s%-49s%60s", "|", "200,833.33 plus 35% in excess of 666,667.00", "|");
            System.out.println();
            System.out.printf("%-11s%-49s%35s%20.2f%5s", "|", "200,833.33 + (" + String.format("%.2f", taxableIncome) + " - 666,667.00)" + " * 35%", "", withholdingTax, "|");
            System.out.println();
        }

        System.out.printf("%-6s%-109s%5s", "|", "-------------------------------------------------------------------------------------------------------------", "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20.2f%5s", "|", "NET INCOME", "", netIncome, "|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("|======================================================================================================================|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("%-60s%60s", "| SUMMARY", "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20.2f%5s", "|", "Gross Income", "", grossIncome, "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35.2f%25s", "|", "Total Benefits", totalBenefits, "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20.2f%5s", "|", "Total Deductions", "", totalDeductions, "|");
        System.out.println();
        System.out.printf("%-6s%-109s%5s", "|", "-------------------------------------------------------------------------------------------------------------", "|");
        System.out.println();
        System.out.printf("%-6s%-54s%35s%20.2f%5s", "|", "TAKE HOME PAY", "", netIncome, "|");
        System.out.println();
        System.out.printf("%-60s%60s", "|", "|");
        System.out.println();
        System.out.printf("========================================================================================================================");
        System.out.println();
        System.out.println();
    }
    
    
    public static void calculateAnotherSalary() {
        String userInput;
        
        // Handle input validation
        do {
            try {
                // Ask user if they want to calculate another employee
                System.out.print("\nDo you want to enter another employee?         ");
                userInput = scan.nextLine();

                // Make the input case insensitive
                userInput = userInput.toLowerCase();

                // Make the input spelling insensitive
                if (userInput.contains("y")) {
                    // Clear the console
                    for (int i = 0; i < 100; i++) {
                        System.out.println();
                    }
                    
                    // Re-run the program
                    runPayrollProgram();
                    
                    break;
                } else if (userInput.contains("n")) {
                    System.out.println("Thanks! Have a good day!");
                    break;
                } else {
                    System.out.println("ERROR: Please type yes or no.");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Please type yes or no.");
            } catch (Exception e) {
                System.out.println("ERROR: Something went wrong.");
            }
        } while (true);
    }
    
}