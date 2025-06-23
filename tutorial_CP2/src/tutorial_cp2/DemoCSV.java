
package tutorial_cp2;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author danilo
 */
public class DemoCSV {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String csvFile = "example.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csvFile));

        String[] record1 = {"1","danilo", "g", "100"};
        String[] record2 = {"2","abegail", "m", "45"};
        String[] record3 = {"3","edward", "M", "45"};

        writer.writeNext(record1);
        writer.writeNext(record2);
        writer.writeNext(record3);

        writer.close();

        CSVReader reader = new CSVReader(new FileReader(csvFile));

        List<String[]> records = reader.readAll();

        System.out.println("Current Records in the CSV File.");
        
        /* another way of printing the array
        for (String[] record : records) {
            for (String anotherRecord : record) {
                System.out.print(anotherRecord + "");
                System.out.println();

            }
        }
         */
        for (String[] record : records) {
            System.out.println(Arrays.toString(record));
        }

        // update csv
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the record ID to update: ");
        String recordID = scanner.nextLine();

        boolean isFound = false;

        for (String[] record : records) {
            if (record[0].equals(recordID)) {
                isFound = true;
                System.out.print("Enter the new value for column 2: ");
                String newValue = scanner.nextLine();
                record[1] = newValue;
                break; //Exit the loop once the record has been updated

            }
        }

        if (!isFound) {
            System.out.println("Record ID: " + recordID + "doesn't exist.");
        }

        writer = new CSVWriter(new FileWriter(csvFile));

        
        for(String[] updatedRecord:records)
        {
            writer.writeNext(updatedRecord);
        }
        writer.close();
        
        reader = new CSVReader(new FileReader(csvFile));
        for(String []updatedRecord:records)
        {
            System.out.println(Arrays.toString(updatedRecord));
        }
            
        reader.close();

    }

}
