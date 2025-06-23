package combinedfile;


/*
Group 2
  @DGiltendez
  @AMatibag
  @ADadea
  @LBlasurca

 */
import java.util.*;
import java.io.*;
import java.time.*;

public class CombinedFile {

    public static void main(String[] args) throws FileNotFoundException {
        //print out list of employee
        System.out.println("Hello\nHere's the list of Motor PH employees.");
        System.out.println("Please choose associate details you want to view by entering Employee Number below:\n");

        File employeeList = new File("EmployeeList.txt");
        Scanner employeefile = new Scanner(employeeList);

        while (employeefile.hasNextLine()) {
            System.out.println(employeefile.nextLine());
        }

        //delete existing file
        File paySumC = new File("paySummary.txt");

        if (paySumC.delete()) {
            System.out.println("\nResetting any existing paySummary.txt to blank file...");
        } else {
            System.out.println(" ");
        }

        //create a paysummary file
        File paySum = new File("paySummary.txt");

        try {
            if (paySum.createNewFile()) {
                System.out.println("\nNew paySummary file is created sucessfully.\n");
            } else {
                System.out.println(" ");
            }
        } catch (IOException ex) {
            System.out.println(" ");
        }

        //print header into the file
        try {
            FileWriter header = new FileWriter("paySummary.txt");
            PrintWriter prheader = new PrintWriter(header);

            prheader.printf("%-15s%-33s%-16s%-12s%-20s%-16s%-24s%-15s%-15s", "Employee#", "Employee Name", "GrossPay", "SSS", "PhilHealth", "PagIbig", "WitholdingTax", "Benefits", "NetPay");
            header.close();
        } catch (IOException ex) {
            System.out.println(" ");
        }
        enterEmployeeNo();
    }

    public static void enterEmployeeNo() {
        System.out.println("Please enter the employee number:");
        Scanner employeNoEntry = new Scanner(System.in);
        int employeeNoEntry = employeNoEntry.nextInt();

        try {

            if (employeeNoEntry > 0 && employeeNoEntry <= 35) {
                searchEmployeeDB(employeeNoEntry);
            }

        } catch (Exception invalidEntry) {
            System.out.println("!!! INVALID ENTRY ENTERED !!!\n");
            enterEmployeeNo();
        }

    }

    public static void searchEmployeeDB(int employeeNoEntry) {
        String lastName;
        String firstName;
        String birthday;
        String address;
        String phoneNumber;
        String sssNumber;
        String philhealthNo;
        String tinNo;
        String pagibig;
        String status;
        String position;
        String immediateSupervisor;
        double basicSalary;
        double riceSubsidy;
        double phoneAllowance;
        double clothingAllowance;
        double grossSemiMonthlyRate;
        double hourlyRate;
        int coveredDays;
        int index_;
        
        coveredDays = 21;  // total working days in a month, set to 21days
        index_ = employeeNoEntry;
        lastName = employeeNameDB(index_).get(0);
        firstName = employeeNameDB(index_).get(1);
        birthday = birthdayDB(index_);
        address = addressDB(index_);
        phoneNumber = phoneNumberDB(index_);
        sssNumber = sssNumberDB(index_);
        philhealthNo = philhealthNoDB(index_);
        tinNo = tinNoDB(index_);
        pagibig = pagibigDB(index_);
        status = employeeStatusDB(index_);
        position = employeePositionDB(index_);
        immediateSupervisor = immediateSupervisorsDB(index_);
        basicSalary = basicSalaryDB(index_);
        riceSubsidy = riceSubsidyDB(index_);
        phoneAllowance = phoneAllowanceDB(index_);
        clothingAllowance = clothingAllowanceDB(index_);
        grossSemiMonthlyRate = basicSalary / 2;
        hourlyRate = basicSalary / coveredDays;

        System.out.println("Here are the details based on the Employee Number you entered: " + "\n"
                + "Employee #:            " + employeeNoEntry + "\n"
                + "Last Name:             " + lastName + "\n"
                + "First Name:            " + firstName + "\n"
                + "Birthday:              " + birthday + "\n"
                + "Address:               " + address + "\n"
                + "Phone Number:          " + phoneNumber + "\n"
                + "SSS Number:            " + sssNumber + "\n"
                + "Philhealth Number:     " + philhealthNo + "\n"
                + "TIN Number:            " + tinNo + "\n"
                + "Pag-ibig Number:       " + pagibig + "\n"
                + "Status:                " + status + "\n"
                + "Position:              " + position+ "\n"
                + "Immediate Supervisor:  " + immediateSupervisor + "\n"
                + "Basic Salary:          " + basicSalary + "\n"
                + "Rice Subsidy:          " + riceSubsidy + "\n"
                + "Phone Allowance:       " + phoneAllowance + "\n"
                + "Clothing Allowance:    " + clothingAllowance + "\n"
                + "Gross Semi-monthly Rate:" + grossSemiMonthlyRate + "\n"
                + "Hourly Rate:           " + hourlyRate + "\n");

    }

    public static int[] employeeNumberDatabase() {
        int[] employeeNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34};

        return employeeNumber;
    }

    public static ArrayList<String> employeeNameDB(int index_) {
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

        ArrayList<String> employeeName = new ArrayList<>();
        employeeName.add(lastName[index_]);
        employeeName.add(firstName[index_]);

        return employeeName;
    }

    public static int[] employeeNumberDB(int index_) {
        int[] employeeNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34};

        return employeeNumber;
    }

    public static double basicSalaryDB(int index_) {
        int[] salaries = {90000, 60000, 60000, 60000, 52670, 52670, 42975, 22500, 22500, 52670,
            50825, 38475, 24000, 24000, 53500, 42975, 41850, 22500, 22500, 23250,
            23250, 24000, 22500, 22500, 24000, 24750, 24750, 24000, 22500, 22500,
            22500, 52670, 52670, 52670};

        int basicSalary = salaries[index_];
        return basicSalary;
    }

    public static double phoneAllowanceDB(int index_) {
        // Phone allowance based on search criteria
        int[] phoneAllowance = {2000, 2000, 2000, 1000, 1000, 800, 500, 500, 1000, 1000,
            800, 500, 500, 1000, 800, 800, 500, 500, 500, 500,
            500, 500, 500, 500, 500, 500, 500, 500, 500, 500,
            500, 1000, 1000, 1000};

        int phoneAllowance_ = phoneAllowance[index_];
        return phoneAllowance_;
    }

    public static double clothingAllowanceDB(int index_) {
        // Clothing allowance based on search criteria
        int[] clothingAllowance = {1000, 1000, 1000, 1000, 1000, 800, 500, 500, 1000, 1000,
            800, 500, 500, 1000, 800, 800, 500, 500, 500, 500,
            500, 500, 500, 500, 500, 500, 500, 500, 500, 500,
            500, 1000, 1000, 1000};

        int clothingAllowance_ = clothingAllowance[index_];
        return clothingAllowance_;
    }

    public static double riceSubsidyDB(int index_) {

        int riceSubsidy = 1500;
        return riceSubsidy;
    }

    public static String employeePositionDB(int index_) {

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

    public static String birthdayDB(int index_) {

        String[] birthdayDB = {
            "10/11/1983", "06/19/1988", "08/04/1989", "06/16/1994", "09/23/1989",
            "02/14/1988", "03/15/1996", "05/14/1992", "09/24/1948", "03/30/1988",
            "09/14/1993", "01/14/1987", "01/11/1942", "07/11/1970", "03/10/1985",
            "10/21/1987", "02/20/1975", "06/24/1986", "10/06/1996", "02/12/1991",
            "11/25/1985", "02/26/1980", "12/31/1983", "12/18/1978", "05/19/1984",
            "12/18/1970", "08/28/1986", "12/12/1981", "08/20/1978", "04/14/1973",
            "01/27/1989", "02/09/1992", "11/16/1990", "08/07/1990"
        };

        String birthdayDB_ = birthdayDB[index_];

        return birthdayDB_;

    }

    public static String addressDB(int index_) {

        String[] addressDB = {
            "Valero Carpark Building Valero Street 1227, Makati City",
            "San Antonio De Padua 2, Block 1 Lot 8 and 2, Dasmarinas, Cavite",
            "Rm. 402 4/F Jiao Building Timog Avenue Cor. Quezon Avenue 1100, Quezon City",
            "460 Solanda Street Intramuros 1000, Manila",
            "National Highway, Gingoog, Misamis Occidental",
            "17/85 Stracke Via Suite 042, Poblacion, Las Piñas 4783 Dinagat Islands",
            "99 Strosin Hills, Poblacion, Bislig 5340 Tawi-Tawi",
            "12A/33 Upton Isle Apt. 420, Roxas City 1814 Surigao del Norte",
            "90A Dibbert Terrace Apt. 190, San Lorenzo 6056 Davao del Norte",
            "#284 T. Morato corner, Scout Rallos Street, Quezon City",
            "93/54 Shanahan Alley Apt. 183, Santo Tomas 1572 Masbate",
            "49 Springs Apt. 266, Poblacion, Taguig 3200 Occidental Mindoro",
            "42/25 Sawayn Stream, Ubay 1208 Zamboanga del Norte",
            "37/46 Kulas Roads, Maragondon 0962 Quirino",
            "22A/52 Lubowitz Meadows, Pililla 4895 Zambales",
            "90 O'Keefe Spur Apt. 379, Catigbian 2772 Sulu",
            "89A Armstrong Trace, Compostela 7874 Maguindanao",
            "08 Grant Drive Suite 406, Poblacion, Iloilo City 9186 La Union",
            "93A/21 Berge Points, Tapaz 2180 Quezon",
            "65 Murphy Center Suite 094, Poblacion, Palayan 5636 Quirino",
            "47A/94 Larkin Plaza Apt. 179, Poblacion, Caloocan 2751 Quirino",
            "06A Gulgowski Extensions, Bongabon 6085 Zamboanga del Sur",
            "99A Padberg Spring, Poblacion, Mabalacat 3959 Lanao del Sur",
            "80A/48 Ledner Ridges, Poblacion, Kabankalan 8870 Marinduque",
            "96/48 Watsica Flats Suite 734, Poblacion, Malolos 1844 Ifugao",
            "58A Wilderman Walks, Poblacion, Digos 5822 Davao del Sur",
            "60 Goyette Valley Suite 219, Poblacion, Tabuk 3159 Lanao del Sur",
            "66/77 Mann Views, Luisiana 1263 Dinagat Islands",
            "72/70 Stamm Spurs, Bustos 4550 Iloilo",
            "50A/83 Bahringer Oval Suite 145, Kiamba 7688 Nueva Ecija",
            "95 Cremin Junction, Surallah 2809 Cotabato",
            "Hi-way, Yati, Liloan Cebu",
            "Bulala, Camalaniugan",
            "Agapita Building, Metro Manila"
        };
        String addressDB_ = addressDB[index_];

        return addressDB_;
    }

    public static String phoneNumberDB(int index_) {
        String[] phoneNumberDB = {
            "966-860-270", "171-867-411", "966-889-370", "786-868-477", "088-861-012",
            "918-621-603", "797-009-261", "983-606-799", "266-036-427", "053-381-386",
            "070-766-300", "478-355-427", "329-034-366", "877-110-749", "023-079-009",
            "783-776-744", "975-432-139", "179-075-129", "868-819-912", "683-725-348",
            "740-721-558", "739-443-033", "955-879-269", "882-550-989", "675-757-366",
            "512-899-876", "948-628-136", "332-372-215", "250-700-389", "973-358-041",
            "529-705-439", "332-424-955", "078-854-208", "526-639-511"
        };
        String phoneNumberDB_ = phoneNumberDB[index_];

        return phoneNumberDB_;
    }

    public static String sssNumberDB(int index_) {
        String[] sssNumberDB = {
            "44-4506057-3", "52-2061274-9", "30-8870406-2", "40-2511815-0", "50-5577638-1",
            "49-1632020-8", "40-2400714-1", "55-4476527-2", "41-0644692-3", "64-7605054-4",
            "26-9647608-3", "44-8563448-3", "45-5656375-0", "27-2090996-4", "26-8768374-1",
            "49-2959312-6", "27-2090208-8", "45-3251383-0", "49-1629900-2", "49-1647342-5",
            "45-5617168-2", "52-0109570-6", "52-9883524-3", "45-5866331-6", "47-1692793-0",
            "40-9504657-8", "45-3298166-4", "40-2400719-4", "60-1152206-4", "54-1331005-0",
            "52-1859253-1", "26-7145133-4", "11-5062972-7", "20-2987501-5"
        };
        String sssNumberDB_ = sssNumberDB[index_];

        return sssNumberDB_;
    }

    public static String philhealthNoDB(int index_) {
        String[] philhealthNoDB = {
            "820126853951", "331735646338", "177451189665", "341911411254", "957436191812",
            "382189453145", "239192926939", "545652640232", "708988234853", "578114853194",
            "126445315651", "431709011012", "233693897247", "515741057496", "308366860059",
            "824187961962", "587272469938", "745148459521", "579253435499", "399665157135",
            "606386917510", "357451271274", "548670482885", "953901539995", "753800654114",
            "797639382265", "810909286264", "934389652994", "351830469744", "465087894112",
            "136451303068", "601644902402", "380685387212", "918460050077"
        };
        String philhealthNoDB_ = philhealthNoDB[index_];

        return philhealthNoDB_;
    }

    public static String pagibigDB(int index_) {
        String[] pagibigNumbers = {
            "691295330870", "663904995411", "171519773969", "416946776041", "952347222457",
            "441093369646", "210850209964", "211385556888", "260107732354", "799254095212",
            "218002473454", "113071293354", "631130283546", "101205445886", "223057707853",
            "631052853464", "719007608464", "114901859343", "265104358643", "260054585575",
            "104907708845", "113017988667", "360028104576", "913108649964", "210546661243",
            "210897095686", "211274476563", "122238077997", "212141893454", "515012579765",
            "110018813465", "697764069311", "993372963726", "874042259378"
        };
        String pagibigNumbers_ = pagibigNumbers[index_];

        return pagibigNumbers_;
    }

    public static String tinNoDB(int index_) {
        String[] tinNumbers = {
            "442-605-657-000", "683-102-776-000", "971-711-280-000", "876-809-437-000", "031-702-374-000",
            "317-674-022-000", "672-474-690-000", "888-572-294-000", "604-997-793-000", "525-420-419-000",
            "210-805-911-000", "218-489-737-000", "210-835-851-000", "275-792-513-000", "598-065-761-000",
            "103-100-522-000", "482-259-498-000", "121-203-336-000", "122-244-511-000", "273-970-941-000",
            "354-650-951-000", "187-500-345-000", "101-558-994-000", "560-735-732-000", "841-177-857-000",
            "502-995-671-000", "336-676-445-000", "210-395-397-000", "395-032-717-000", "215-973-013-000",
            "599-312-588-000", "404-768-309-000", "256-436-296-000", "911-529-713-000"
        };

        String tinNumbers_ = tinNumbers[index_];

        return tinNumbers_;
    }

    public static String employmentStatusDB(int index_) {
        String[] employmentStatusesDB = {
            "Regular", "Regular", "Regular", "Regular", "Regular",
            "Regular", "Regular", "Regular", "Regular", "Regular",
            "Regular", "Regular", "Regular", "Regular", "Regular",
            "Regular", "Regular", "Regular", "Regular", "Regular",
            "Probationary", "Probationary", "Probationary", "Probationary", "Probationary",
            "Probationary", "Probationary", "Probationary", "Probationary", "Probationary",
            "Probationary", "Regular", "Regular", "Regular"
        };

        String employmentStatusesDB_ = employmentStatusesDB[index_];

        return employmentStatusesDB_;
    }

    public static String immediateSupervisorsDB(int index_) {
        String[] immediateSupervisorsDB = {
            "N/A", "Garcia, Manuel III", "Garcia, Manuel III", "Garcia, Manuel III", "Lim, Antonio",
            "Lim, Antonio", "Villanueva, Andrea Mae", "San, Jose Brad", "San, Jose Brad", "Aquino, Bianca Sofia",
            "Alvaro, Roderick", "Salcedo, Anthony", "Salcedo, Anthony", "Salcedo, Anthony", "Lim, Antonio",
            "Romualdez, Fredrick", "Romualdez, Fredrick", "Mata, Christian", "Mata, Christian", "Mata, Christian",
            "Mata, Christian", "Mata, Christian", "Mata, Christian", "Mata, Christian", "De Leon, Selena",
            "De Leon, Selena", "De Leon, Selena", "De Leon, Selena", "De Leon, Selena", "De Leon, Selena",
            "De Leon, Selena", "Reyes, Isabella", "Reyes, Isabella", "Reyes, Isabella"
        };

        String immediateSupervisorsDB_ = immediateSupervisorsDB[index_];

        return immediateSupervisorsDB_;
    }

    public static String employeeStatusDB(int index_) {
        String[] employeeStatusDB = {
            "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular",
            "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular", "Regular",
            "Regular", "Regular", "Regular", "Regular", "Probationary", "Probationary", "Probationary",
            "Probationary", "Probationary", "Probationary", "Probationary", "Probationary", "Probationary",
            "Probationary", "Regular", "Regular", "Regular"
        };

        String employeeStatusDB_ = employeeStatusDB[index_];

        return employeeStatusDB_;

    }

}
