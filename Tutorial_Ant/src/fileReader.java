
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class fileReader {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Provide filePath of text file?\n(Example. C:\\Users\\danilo\\Downloads\\RomualdezFredrick_020124.txt)");

        String filepath = scan.nextLine();

        ArrayList<String> inputs = extractData(filepath);

        scan.close();
        //Extract LastName and First Name. Use as search criteria
        System.out.println(inputs);

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

}
