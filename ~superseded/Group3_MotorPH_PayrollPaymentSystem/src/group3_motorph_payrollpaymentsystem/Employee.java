package group3_motorph_payrollpaymentsystem;

import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author danilo
 */
class Employee {

    // Attributes
    public int employeeNumber;
    public String lastName;
    public String firstName;
    public String employeeBirthday;
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

    // Constructor
    public Employee(int employeeNumber, String lastName, String firstName, String employeeBirthday, String address, String phoneNumber, String sssNumber, String philHealthNumber, String tinNumber, String pagIbigNumber, String status, String position, String immediateSupervisor, double basicSalary, double riceSubsidy, double phoneAllowance, double clothingAllowance, double grossSemiMonthlyRate) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
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

    }

    // Getters and Setters
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public void setSssNumber(String sssNumber) {
        this.sssNumber = sssNumber;
    }

    public String getPhilHealthNumber() {
        return philHealthNumber;
    }

    public void setPhilHealthNumber(String philHealthNumber) {
        this.philHealthNumber = philHealthNumber;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getPagIbigNumber() {
        return pagIbigNumber;
    }

    public void setPagIbigNumber(String pagIbigNumber) {
        this.pagIbigNumber = pagIbigNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImmediateSupervisor() {
        return immediateSupervisor;
    }

    public void setImmediateSupervisor(String immediateSupervisor) {
        this.immediateSupervisor = immediateSupervisor;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getRiceSubsidy() {
        return riceSubsidy;
    }

    public void setRiceSubsidy(double riceSubsidy) {
        this.riceSubsidy = riceSubsidy;
    }

    public double getPhoneAllowance() {
        return phoneAllowance;
    }

    public void setPhoneAllowance(double phoneAllowance) {
        this.phoneAllowance = phoneAllowance;
    }

    public double getClothingAllowance() {
        return clothingAllowance;
    }

    public void setClothingAllowance(double clothingAllowance) {
        this.clothingAllowance = clothingAllowance;
    }

    public double getGrossSemiMonthlyRate() {
        return grossSemiMonthlyRate;
    }

    public void setGrossSemiMonthlyRate(double grossSemiMonthlyRate) {
        this.grossSemiMonthlyRate = grossSemiMonthlyRate;
    }

    @Override
    public String toString() {
        return "Employee{"
                + "employeeNumber=" + employeeNumber
                + ", lastName='" + lastName + '\''
                + ", firstName='" + firstName + '\''
                + ", employeeBirthday='" + employeeBirthday + '\''
                + ", address='" + address + '\''
                + ", phoneNumber='" + phoneNumber + '\''
                + ", sssNumber='" + sssNumber + '\''
                + ", philHealthNumber='" + philHealthNumber + '\''
                + ", tinNumber='" + tinNumber + '\''
                + ", pagIbigNumber='" + pagIbigNumber + '\''
                + ", status='" + status + '\''
                + ", position='" + position + '\''
                + ", immediateSupervisor='" + immediateSupervisor + '\''
                + ", basicSalary=" + basicSalary
                + ", riceSubsidy=" + riceSubsidy
                + ", phoneAllowance=" + phoneAllowance
                + ", clothingAllowance=" + clothingAllowance
                + ", grossSemiMonthlyRate=" + grossSemiMonthlyRate
                + '}';
    }
}
/*
    public static Employee[] initializeEmployees() {
        // Create array to store employee objects
        Employee[] employees = new Employee[34];

        // Initializing employee objects
        employees[0] = new Employee(1, "Manuel Garcia III", "10/11/1983", "Valero Carpark Building Valero Street 1227, Makati City", "966-860-270", "44-4506057-3", "820126853951", "442-605-657-000", "691295330870", "Regular", "Chief Executive Officer", "N/A", 90000, 1500, 2000, 1000, 45000, 535.71);
        employees[1] = new Employee(2, "Antonio Lim", "06/19/1988", "San Antonio De Padua 2, Block 1 Lot 8 and 2, Dasmarinas, Cavite", "171-867-411", "52-2061274-9", "331735646338", "683-102-776-000", "663904995411", "Regular", "Chief Operating Officer", "Garcia, Manuel III", 60000, 1500, 2000, 1000, 30000, 357.14);
        employees[2] = new Employee(3, "Bianca Sofia Aquino", "08/04/1989", "Rm. 402 4/F Jiao Building Timog Avenue Cor. Quezon Avenue 1100, Quezon City", "966-889-370", "30-8870406-2", "177451189665", "971-711-280-000", "171519773969", "Regular", "Chief Finance Officer", "Garcia, Manuel III", 60000, 1500, 2000, 1000, 30000, 357.14);
        employees[3] = new Employee(4, "Isabella Reyes", "06/16/1994", "460 Solanda Street Intramuros 1000, Manila", "786-868-477", "40-2511815-0", "341911411254", "876-809-437-000", "416946776041", "Regular", "Chief Marketing Officer", "Garcia, Manuel III", 60000, 1500, 2000, 1000, 30000, 357.14);
        employees[4] = new Employee(5, "Eduard Hernandez", "09/23/1989", "National Highway, Gingoog, Misamis Occidental", "088-861-012", "50-5577638-1", "957436191812", "031-702-374-000", "952347222457", "Regular", "IT Operations and Systems", "Lim, Antonio", 52670, 1500, 1000, 1000, 26335, 313.51);
        employees[5] = new Employee(6, "Andrea Mae Villanueva", "02/14/1988", "17/85 Stracke Via Suite 042, Poblacion, Las Pinas 4783 Dinagat Islands", "918-621-603", "49-1632020-8", "382189453145", "317-674-022-000", "441093369646", "Regular", "HR Manager", "Lim, Antonio", 52670, 1500, 1000, 1000, 26335, 313.51);
        employees[6] = new Employee(7, "Brad San Jose", "03/15/1996", "99 Strosin Hills, Poblacion, Bislig 5340 Tawi-Tawi", "797-009-261", "40-2400714-1", "239192926939", "672-474-690-000", "210850209964", "Regular", "HR Team Leader", "Villanueva, Andrea Mae", 42975, 1500, 800, 800, 21488, 255.80);
        employees[7] = new Employee(8, "Alice Romualdez", "05/14/1992", "12A/33 Upton Isle Apt. 420, Roxas City 1814 Surigao del Norte", "983-606-799", "55-4476527-2", "545652640232", "888-572-294-000", "211385556888", "Regular", "HR Rank and File", "San, Jose Brad", 22500, 1500, 500, 500, 11250, 133.93);
        employees[8] = new Employee(9, "Rosie Atienza", "09/24/1948", "90A Dibbert Terrace Apt. 190, San Lorenzo 6056 Davao del Norte", "266-036-427", "41-0644692-3", "708988234853", "604-997-793-000", "260107732354", "Regular", "HR Rank and File", "San, Jose Brad", 22500, 1500, 500, 500, 11250, 133.93);
        employees[9] = new Employee(10, "Roderick Alvaro", "03/30/1988", "#284 T. Morato corner, Scout Rallos Street, Quezon City", "053-381-386", "64-7605054-4", "578114853194", "525-420-419-000", "799254095212", "Regular", "Accounting Head", "Aquino, Bianca Sofia", 52670, 1500, 1000, 1000, 26335, 313.51);
        employees[10] = new Employee(11, "Anthony Salcedo", "09/14/1993", "93/54 Shanahan Alley Apt. 183, Santo Tomas 1572 Masbate", "070-766-300", "26-9647608-3", "126445315651", "210-805-911-000", "218002473454", "Regular", "Payroll Manager", "Alvaro, Roderick", 50825, 1500, 1000, 1000, 25413, 302.53);
        employees[11] = new Employee(12, "Josie Lopez", "01/14/1987", "49 Springs Apt. 266, Poblacion, Taguig 3200 Occidental Mindoro", "478-355-427", "44-8563448-3", "431709011012", "218-489-737-000", "113071293354", "Regular", "Payroll Team Leader", "Salcedo, Anthony", 38475, 1500, 800, 800, 19238, 229.02);
        employees[12] = new Employee(13, "Martha Farala", "01/11/1942", "42/25 Sawayn Stream, Ubay 1208 Zamboanga del Norte", "329-034-366", "45-5656375-0", "233693897247", "210-835-851-000", "631130283546", "Regular", "Payroll Rank and File", "Salcedo, Anthony", 24000, 1500, 500, 500, 12000, 142.86);
        employees[13] = new Employee(14, "Leila Martinez", "07/11/1970", "37/46 Kulas Roads, Maragondon 0962 Quirino", "877-110-749", "27-2090996-4", "515741057496", "275-792-513-000", "101205445886", "Regular", "Payroll Rank and File", "Salcedo, Anthony", 24000, 1500, 500, 500, 12000, 142.86);
        employees[14] = new Employee(15, "Fredrick Romualdez", "03/10/1985", "22A/52 Lubowitz Meadows, Pililla 4895 Zambales", "023-079-009", "26-8768374-1", "308366860059", "598-065-761-000", "223057707853", "Regular", "Account Manager", "Lim, Antonio", 53500, 1500, 1000, 1000, 26750, 318.45);
        employees[15] = new Employee(16, "Christian Mata", "10/21/1987", "90 O'Keefe Spur Apt. 379, Catigbian 2772 Sulu", "783-776-744", "49-2959312-6", "824187961962", "103-100-522-000", "631052853464", "Regular", "Account Team Leader", "Romualdez, Fredrick", 42975, 1500, 800, 800, 21488, 255.80);
        employees[16] = new Employee(17, "Selena De Leon", "02/20/1975", "89A Armstrong Trace, Compostela 7874 Maguindanao", "975-432-139", "27-2090208-8", "587272469938", "482-259-498-000", "719007608464", "Regular", "Account Team Leader", "Romualdez, Fredrick", 41850, 1500, 800, 800, 20925, 249.11);
        employees[17] = new Employee(18, "Allison San Jose", "06/24/1986", "08 Grant Drive Suite 406, Poblacion, Iloilo City 9186 La Union", "179-075-129", "45-3251383-0", "745148459521", "121-203-336-000", "114901859343", "Regular", "Account Rank and File", "Mata, Christian", 22500, 1500, 500, 500, 11250, 133.93);
        employees[18] = new Employee(19, "Cydney Rosario", "10/06/1996", "93A/21 Berge Points, Tapaz 2180 Quezon", "868-819-912", "49-1629900-2", "579253435499", "122-244-511-000", "265104358643", "Regular", "Account Rank and File", "Mata, Christian", 22500, 1500, 500, 500, 11250, 133.93);
        employees[19] = new Employee(20, "Mark Bautista", "02/12/1991", "65 Murphy Center Suite 094, Poblacion, Palayan 5636 Quirino", "683-725-348", "49-1647342-5", "399665157135", "273-970-941-000", "260054585575", "Regular", "Account Rank and File", "Mata, Christian", 23250, 1500, 500, 500, 11625, 138.39);
        employees[20] = new Employee(21, "Darlene Lazaro", "11/25/1985", "47A/94 Larkin Plaza Apt. 179, Poblacion, Caloocan 2751 Quirino", "740-721-558", "45-5617168-2", "606386917510", "354-650-951-000", "104907708845", "Probationary", "Account Rank and File", "Mata, Christian", 23250, 1500, 500, 500, 11625, 138.39);
        employees[21] = new Employee(22, "Kolby Delos Santos", "02/26/1980", "06A Gulgowski Extensions, Bongabon 6085 Zamboanga del Sur", "739-443-033", "52-0109570-6", "357451271274", "187-500-345-000", "113017988667", "Probationary", "Account Rank and File", "Mata, Christian", 24000, 1500, 500, 500, 12000, 142.86);
        employees[22] = new Employee(23, "Vella Santos", "12/31/1983", "99A Padberg Spring, Poblacion, Mabalacat 3959 Lanao del Sur", "955-879-269", "52-9883524-3", "548670482885", "101-558-994-000", "360028104576", "Probationary", "Account Rank and File", "Mata, Christian", 22500, 1500, 500, 500, 11250, 133.93);
        employees[23] = new Employee(24, "Tomas Del Rosario", "12/18/1978", "80A/48 Ledner Ridges, Poblacion, Kabankalan 8870 Marinduque", "882-550-989", "45-5866331-6", "953901539995", "560-735-732-000", "913108649964", "Probationary", "Account Rank and File", "Mata, Christian", 22500, 1500, 500, 500, 11250, 133.93);
        employees[24] = new Employee(25, "Jacklyn Tolentino", "05/19/1984", "96/48 Watsica Flats Suite 734, Poblacion, Malolos 1844 Ifugao", "675-757-366", "47-1692793-0", "753800654114", "841-177-857-000", "210546661243", "Probationary", "Account Rank and File", "De Leon, Selena", 24000, 1500, 500, 500, 12000, 142.86);
        employees[25] = new Employee(26, "Percival Gutierrez", "12/18/1970", "58A Wilderman Walks, Poblacion, Digos 5822 Davao del Sur", "512-899-876", "40-9504657-8", "797639382265", "502-995-671-000", "210897095686", "Probationary", "Account Rank and File", "De Leon, Selena", 24750, 1500, 500, 500, 12375, 147.32);
        employees[26] = new Employee(27, "Garfield Manalaysay", "08/28/1986", "60 Goyette Valley Suite 219, Poblacion, Tabuk 3159 Lanao del Sur", "948-628-136", "45-3298166-4", "810909286264", "336-676-445-000", "211274476563", "Probationary", "Account Rank and File", "De Leon, Selena", 24750, 1500, 500, 500, 12375, 147.32);
        employees[27] = new Employee(28, "Lizeth Villegas", "12/12/1981", "66/77 Mann Views, Luisiana 1263 Dinagat Islands", "332-372-215", "40-2400719-4", "934389652994", "210-395-397-000", "122238077997", "Probationary", "Account Rank and File", "De Leon, Selena", 24000, 1500, 500, 500, 12000, 142.86);
        employees[28] = new Employee(29, "Carol Ramos", "08/20/1978", "72/70 Stamm Spurs, Bustos 4550 Iloilo", "250-700-389", "60-1152206-4", "351830469744", "395-032-717-000", "212141893454", "Probationary", "Account Rank and File", "De Leon, Selena", 22500, 1500, 500, 500, 11250, 133.93);
        employees[29] = new Employee(30, "Emelia Maceda", "04/14/1973", "50A/83 Bahringer Oval Suite 145, Kiamba 7688 Nueva Ecija", "973-358-041", "54-1331005-0", "465087894112", "215-973-013-000", "515012579765", "Probationary", "Account Rank and File", "De Leon, Selena", 22500, 1500, 500, 500, 11250, 133.93);
        employees[30] = new Employee(31, "Delia Aguilar", "01/27/1989", "95 Cremin Junction, Surallah 2809 Cotabato", "529-705-439", "52-1859253-1", "136451303068", "599-312-588-000", "110018813465", "Probationary", "Account Rank and File", "De Leon, Selena", 22500, 1500, 500, 500, 11250, 133.93);
        employees[31] = new Employee(32, "John Rafael Castro", "02/09/1992", "Hi-way, Yati, Liloan Cebu", "332-424-955", "26-7145133-4", "601644902402", "404-768-309-000", "697764069311", "Regular", "Sales & Marketing", "Reyes, Isabella", 52670, 1500, 1000, 1000, 26335, 313.51);
        employees[32] = new Employee(33, "Carlos Ian Martinez", "11/16/1990", "Bulala, Camalaniugan", "078-854-208", "11-5062972-7", "380685387212", "256-436-296-000", "993372963726", "Regular", "Supply Chain and Logistics", "Reyes, Isabella", 52670, 1500, 1000, 1000, 26335, 313.51);
        employees[33] = new Employee(34, "Beatriz Santos", "08/07/1990", "Agapita Building, Metro Manila", "526-639-511", "20-2987501-5", "918460050077", "911-529-713-000", "874042259378", "Regular", "Customer Service and Relations", "Reyes, Isabella", 52670, 1500, 1000, 1000, 26335, 313.51);

        return employees;
    }
 */

 /*
      Employee emp1 = new Employee(1, "Manuel Garcia III", "10/11/1983", "Valero Carpark Building Valero Street 1227, Makati City", "966-860-270", "44-4506057-3", "820126853951", "442-605-657-000", "691295330870", "Regular", "Chief Executive Officer", "N/A", 90000, 1500, 2000, 1000, 45000, 535.71);
         Employee emp2 = new Employee(2, "Antonio Lim", "06/19/1988", "San Antonio De Padua 2, Block 1 Lot 8 and 2, Dasmarinas, Cavite", "171-867-411", "52-2061274-9", "331735646338", "683-102-776-000", "663904995411", "Regular", "Chief Operating Officer", "Garcia, Manuel III", 60000, 1500, 2000, 1000, 30000, 357.14);
         Employee emp3 = new Employee(3, "Bianca Sofia Aquino", "08/04/1989", "Rm. 402 4/F Jiao Building Timog Avenue Cor. Quezon Avenue 1100, Quezon City", "966-889-370", "30-8870406-2", "177451189665", "971-711-280-000", "171519773969", "Regular", "Chief Finance Officer", "Garcia, Manuel III", 60000, 1500, 2000, 1000, 30000, 357.14);
         Employee emp4 = new Employee(4, "Isabella Reyes", "06/16/1994", "460 Solanda Street Intramuros 1000, Manila", "786-868-477", "40-2511815-0", "341911411254", "876-809-437-000", "416946776041", "Regular", "Chief Marketing Officer", "Garcia, Manuel III", 60000, 1500, 2000, 1000, 30000, 357.14);
         Employee emp5 = new Employee(5, "Eduard Hernandez", "09/23/1989", "National Highway, Gingoog, Misamis Occidental", "088-861-012", "50-5577638-1", "957436191812", "031-702-374-000", "952347222457", "Regular", "IT Operations and Systems", "Lim, Antonio", 52670, 1500, 1000, 1000, 26335, 313.51);
         Employee emp6 = new Employee(6, "Andrea Mae Villanueva", "02/14/1988", "17/85 Stracke Via Suite 042, Poblacion, Las Pinas 4783 Dinagat Islands", "918-621-603", "49-1632020-8", "382189453145", "317-674-022-000", "441093369646", "Regular", "HR Manager", "Lim, Antonio", 52670, 1500, 1000, 1000, 26335, 313.51);
         Employee emp7 = new Employee(7, "Brad San Jose", "03/15/1996", "99 Strosin Hills, Poblacion, Bislig 5340 Tawi-Tawi", "797-009-261", "40-2400714-1", "239192926939", "672-474-690-000", "210850209964", "Regular", "HR Team Leader", "Villanueva, Andrea Mae", 42975, 1500, 800, 800, 21488, 255.80);
        Employee emp8 = new Employee(8, "Alice Romualdez", "05/14/1992", "12A/33 Upton Isle Apt. 420, Roxas City 1814 Surigao del Norte", "983-606-799", "55-4476527-2", "545652640232", "888-572-294-000", "211385556888", "Regular", "HR Rank and File", "San, Jose Brad", 22500, 1500, 500, 500, 11250, 133.93);
         Employee emp9 = new Employee(9, "Rosie Atienza", "09/24/1948", "90A Dibbert Terrace Apt. 190, San Lorenzo 6056 Davao del Norte", "266-036-427", "41-0644692-3", "708988234853", "604-997-793-000", "260107732354", "Regular", "HR Rank and File", "San, Jose Brad", 22500, 1500, 500, 500, 11250, 133.93);
        Employee emp10 = new Employee(10, "Roderick Alvaro", "03/30/1988", "#284 T. Morato corner, Scout Rallos Street, Quezon City", "053-381-386", "64-7605054-4", "578114853194", "525-420-419-000", "799254095212", "Regular", "Accounting Head", "Aquino, Bianca Sofia", 52670, 1500, 1000, 1000, 26335, 313.51);
         Employee emp11= new Employee(11, "Anthony Salcedo", "09/14/1993", "93/54 Shanahan Alley Apt. 183, Santo Tomas 1572 Masbate", "070-766-300", "26-9647608-3", "126445315651", "210-805-911-000", "218002473454", "Regular", "Payroll Manager", "Alvaro, Roderick", 50825, 1500, 1000, 1000, 25413, 302.53);
         Employee emp12 = new Employee(12, "Josie Lopez", "01/14/1987", "49 Springs Apt. 266, Poblacion, Taguig 3200 Occidental Mindoro", "478-355-427", "44-8563448-3", "431709011012", "218-489-737-000", "113071293354", "Regular", "Payroll Team Leader", "Salcedo, Anthony", 38475, 1500, 800, 800, 19238, 229.02);
         Employee emp13 = new Employee(13, "Martha Farala", "01/11/1942", "42/25 Sawayn Stream, Ubay 1208 Zamboanga del Norte", "329-034-366", "45-5656375-0", "233693897247", "210-835-851-000", "631130283546", "Regular", "Payroll Rank and File", "Salcedo, Anthony", 24000, 1500, 500, 500, 12000, 142.86);
         Employee emp14 = new Employee(14, "Leila Martinez", "07/11/1970", "37/46 Kulas Roads, Maragondon 0962 Quirino", "877-110-749", "27-2090996-4", "515741057496", "275-792-513-000", "101205445886", "Regular", "Payroll Rank and File", "Salcedo, Anthony", 24000, 1500, 500, 500, 12000, 142.86);
         Employee emp15 = new Employee(15, "Fredrick Romualdez", "03/10/1985", "22A/52 Lubowitz Meadows, Pililla 4895 Zambales", "023-079-009", "26-8768374-1", "308366860059", "598-065-761-000", "223057707853", "Regular", "Account Manager", "Lim, Antonio", 53500, 1500, 1000, 1000, 26750, 318.45);
        Employee emp16 = new Employee(16, "Christian Mata", "10/21/1987", "90 O'Keefe Spur Apt. 379, Catigbian 2772 Sulu", "783-776-744", "49-2959312-6", "824187961962", "103-100-522-000", "631052853464", "Regular", "Account Team Leader", "Romualdez, Fredrick", 42975, 1500, 800, 800, 21488, 255.80);
        Employee emp17= new Employee(17, "Selena De Leon", "02/20/1975", "89A Armstrong Trace, Compostela 7874 Maguindanao", "975-432-139", "27-2090208-8", "587272469938", "482-259-498-000", "719007608464", "Regular", "Account Team Leader", "Romualdez, Fredrick", 41850, 1500, 800, 800, 20925, 249.11);
        Employee emp18 = new Employee(18, "Allison San Jose", "06/24/1986", "08 Grant Drive Suite 406, Poblacion, Iloilo City 9186 La Union", "179-075-129", "45-3251383-0", "745148459521", "121-203-336-000", "114901859343", "Regular", "Account Rank and File", "Mata, Christian", 22500, 1500, 500, 500, 11250, 133.93);
        Employee emp19 = new Employee(19, "Cydney Rosario", "10/06/1996", "93A/21 Berge Points, Tapaz 2180 Quezon", "868-819-912", "49-1629900-2", "579253435499", "122-244-511-000", "265104358643", "Regular", "Account Rank and File", "Mata, Christian", 22500, 1500, 500, 500, 11250, 133.93);
         Employee emp20 = new Employee(20, "Mark Bautista", "02/12/1991", "65 Murphy Center Suite 094, Poblacion, Palayan 5636 Quirino", "683-725-348", "49-1647342-5", "399665157135", "273-970-941-000", "260054585575", "Regular", "Account Rank and File", "Mata, Christian", 23250, 1500, 500, 500, 11625, 138.39);
         Employee emp21 = new Employee(21, "Darlene Lazaro", "11/25/1985", "47A/94 Larkin Plaza Apt. 179, Poblacion, Caloocan 2751 Quirino", "740-721-558", "45-5617168-2", "606386917510", "354-650-951-000", "104907708845", "Probationary", "Account Rank and File", "Mata, Christian", 23250, 1500, 500, 500, 11625, 138.39);
         Employee emp22 = new Employee(22, "Kolby Delos Santos", "02/26/1980", "06A Gulgowski Extensions, Bongabon 6085 Zamboanga del Sur", "739-443-033", "52-0109570-6", "357451271274", "187-500-345-000", "113017988667", "Probationary", "Account Rank and File", "Mata, Christian", 24000, 1500, 500, 500, 12000, 142.86);
        Employee emp23 = new Employee(23, "Vella Santos", "12/31/1983", "99A Padberg Spring, Poblacion, Mabalacat 3959 Lanao del Sur", "955-879-269", "52-9883524-3", "548670482885", "101-558-994-000", "360028104576", "Probationary", "Account Rank and File", "Mata, Christian", 22500, 1500, 500, 500, 11250, 133.93);
        Employee emp24 = new Employee(24, "Tomas Del Rosario", "12/18/1978", "80A/48 Ledner Ridges, Poblacion, Kabankalan 8870 Marinduque", "882-550-989", "45-5866331-6", "953901539995", "560-735-732-000", "913108649964", "Probationary", "Account Rank and File", "Mata, Christian", 22500, 1500, 500, 500, 11250, 133.93);
        Employee emp25 = new Employee(25, "Jacklyn Tolentino", "05/19/1984", "96/48 Watsica Flats Suite 734, Poblacion, Malolos 1844 Ifugao", "675-757-366", "47-1692793-0", "753800654114", "841-177-857-000", "210546661243", "Probationary", "Account Rank and File", "De Leon, Selena", 24000, 1500, 500, 500, 12000, 142.86);
        Employee emp26 = new Employee(26, "Percival Gutierrez", "12/18/1970", "58A Wilderman Walks, Poblacion, Digos 5822 Davao del Sur", "512-899-876", "40-9504657-8", "797639382265", "502-995-671-000", "210897095686", "Probationary", "Account Rank and File", "De Leon, Selena", 24750, 1500, 500, 500, 12375, 147.32);
       Employee emp27 = new Employee(27, "Garfield Manalaysay", "08/28/1986", "60 Goyette Valley Suite 219, Poblacion, Tabuk 3159 Lanao del Sur", "948-628-136", "45-3298166-4", "810909286264", "336-676-445-000", "211274476563", "Probationary", "Account Rank and File", "De Leon, Selena", 24750, 1500, 500, 500, 12375, 147.32);
        Employee emp28 = new Employee(28, "Lizeth Villegas", "12/12/1981", "66/77 Mann Views, Luisiana 1263 Dinagat Islands", "332-372-215", "40-2400719-4", "934389652994", "210-395-397-000", "122238077997", "Probationary", "Account Rank and File", "De Leon, Selena", 24000, 1500, 500, 500, 12000, 142.86);
        Employee emp29 = new Employee(29, "Carol Ramos", "08/20/1978", "72/70 Stamm Spurs, Bustos 4550 Iloilo", "250-700-389", "60-1152206-4", "351830469744", "395-032-717-000", "212141893454", "Probationary", "Account Rank and File", "De Leon, Selena", 22500, 1500, 500, 500, 11250, 133.93);
        Employee emp30 = new Employee(30, "Emelia Maceda", "04/14/1973", "50A/83 Bahringer Oval Suite 145, Kiamba 7688 Nueva Ecija", "973-358-041", "54-1331005-0", "465087894112", "215-973-013-000", "515012579765", "Probationary", "Account Rank and File", "De Leon, Selena", 22500, 1500, 500, 500, 11250, 133.93);
        Employee emp31 = new Employee(31, "Delia Aguilar", "01/27/1989", "95 Cremin Junction, Surallah 2809 Cotabato", "529-705-439", "52-1859253-1", "136451303068", "599-312-588-000", "110018813465", "Probationary", "Account Rank and File", "De Leon, Selena", 22500, 1500, 500, 500, 11250, 133.93);
        Employee emp32= new Employee(32, "John Rafael Castro", "02/09/1992", "Hi-way, Yati, Liloan Cebu", "332-424-955", "26-7145133-4", "601644902402", "404-768-309-000", "697764069311", "Regular", "Sales & Marketing", "Reyes, Isabella", 52670, 1500, 1000, 1000, 26335, 313.51);
        Employee emp33 = new Employee(33, "Carlos Ian Martinez", "11/16/1990", "Bulala, Camalaniugan", "078-854-208", "11-5062972-7", "380685387212", "256-436-296-000", "993372963726", "Regular", "Supply Chain and Logistics", "Reyes, Isabella", 52670, 1500, 1000, 1000, 26335, 313.51);
        Employee emp34 = new Employee(34, "Beatriz Santos", "08/07/1990", "Agapita Building, Metro Manila", "526-639-511", "20-2987501-5", "918460050077", "911-529-713-000", "874042259378", "Regular", "Customer Service and Relations", "Reyes, Isabella", 52670, 1500, 1000, 1000, 26335, 313.51);
 */
 /*
    //Methods below are for the database
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

    public static int[] employeeNumberDB() {
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
        int[] phoneAllowance = {
            2000, 2000, 2000, 2000, 1000, 1000, 800, 500, 500, 1000,
            1000, 800, 500, 500, 1000, 800, 800, 500, 500, 500,
            500, 500, 500, 500, 500, 500, 500, 500, 500, 500,
            500, 1000, 1000, 1000,};

        int phoneAllowance_ = phoneAllowance[index_];
        return phoneAllowance_;
    }

    public static double clothingAllowanceDB(int index_) {
        // Clothing allowance based on search criteria
        int[] clothingAllowance = {1000, 1000, 1000, 1000, 1000, 1000, 800, 500, 500, 1000,
            1000, 800, 500, 500, 1000, 800, 800, 500, 500, 500,
            500, 500, 500, 500, 500, 500, 500, 500, 500, 500,
            500, 1000, 1000, 1000};

        int clothingAllowance_ = clothingAllowance[index_];
        return clothingAllowance_;
    }

    public static double riceSubsidyDB(int index_) {

        int riceSubsidy = 1500;
        return riceSubsidy;
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
            "Regular", "Regular", "Regular", "Regular", "Regular", "Regular",
            "Regular", "Regular", "Regular", "Regular", "Regular", "Regular",
            "Regular", "Regular", "Regular", "Regular", "Regular", "Regular",
            "Regular", "Regular", "Probationary", "Probationary", "Probationary", "Probationary",
            "Probationary", "Probationary", "Probationary", "Probationary", "Probationary", "Probationary",
            "Regular", "Regular", "Regular", "Regular"
        };

        String employeeStatusDB_ = employeeStatusDB[index_];

        return employeeStatusDB_;

    }
    
    
 */

