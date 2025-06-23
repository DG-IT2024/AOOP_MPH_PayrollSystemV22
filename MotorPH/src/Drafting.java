
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Drafting {

    public static void main(String[] args) {

        String searchLastName;

        String searchFirstName;

        searchLastName = "Santos";
        searchFirstName = "Vella";

            
        
        int index_ = determineIndex(searchLastName, searchFirstName);

        System.out.println(index_);

        double basicSalary = basicSalaryDatabase(index_);
        double riceSubsidy = riceSubsidyDatabase(index_);
        double phoneAllowance = phoneAllowanceDatabase(index_);
        double clothingAllowance = clothingAllowanceDatabase(index_);
        double grossSemi_monthlyRate = basicSalaryDatabase(index_) / 2;
        double hourly_Rate = hourlyRateDatabase(index_);

        System.out.println("Name: " + searchLastName + ", " + searchFirstName);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Rice Subsidy: " + riceSubsidy);
        System.out.println("Phone Allowance: " + phoneAllowance);
        System.out.println("Clothing Allowance: " + clothingAllowance);
        System.out.println("Gross Semi-monthly Rate: " + grossSemi_monthlyRate);
        System.out.println("Hourly Rate: " + hourly_Rate);
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

    public static double employeeNumberDatabase(int index_) {
        int[] employeeNumber = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34};

        int employeeNumber_ = employeeNumber[index_];
        return employeeNumber_;
    }

    public static double basicSalaryDatabase(int index_) {
        int[] salaries = {90000, 60000, 60000, 60000, 52670, 52670, 42975, 22500, 22500,
            52670, 50825, 38475, 24000, 24000, 53500, 42975,
            41850, 22500, 22500, 23250, 23250, 24000, 22500, 22500,
            24000, 24750, 24750, 24000, 22500, 22500, 22500, 52670, 52670, 52670};

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
}
