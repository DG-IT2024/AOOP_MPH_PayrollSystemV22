
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConditionalPrintToFileOrConsole {

    public static void main(String[] args) {

        String lastName = "Garcia";
        String firstName = "ManuelIII";

        Scanner timeEntryScan = new Scanner(System.in);

        while (true) {
            boolean writeToConsole;
            writeToConsole = true; // Change this to switch between writing to console and file

// Define the file path
            writeToConsole = true; // Change this to switch between
            String filePath = lastName + firstName + "_" + getCurrentDate() + ".txt";

            System.out.println("\nDo you have to save payroll to a textfile?(Y/N)");
            String saveResponse = timeEntryScan.nextLine();
            if (saveResponse.equalsIgnoreCase("y")) {
                try {
                    writeToConsole = false;
                    PrintWriter printWriter = null;

                    // Check if writing to file or console
                    if (!writeToConsole) {
                        // Create a FileWriter object with the file path
                        FileWriter fileWriter = new FileWriter(filePath,true);
                        // Create a PrintWriter object to write to the file
                        printWriter = new PrintWriter(fileWriter);
                    }

                    // Example usage
                    if (writeToConsole) {
                        System.out.println("This will be displayed in the console.");
                    } else {
                        printWriter.println("This will be written to the file.");
                    }

                    // Close the PrintWriter if writing to file
                    if (printWriter != null) {
                        printWriter.close();
                        System.out.println("Output redirected to file successfully.");
                    }
                    
                    writeToConsole = true;

                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file: " + e.getMessage());
                }
            }
        }
    }

    private static String getCurrentDate() {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(new Date());

    }
}
