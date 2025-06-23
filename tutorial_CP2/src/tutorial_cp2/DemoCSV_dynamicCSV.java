/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class DemoCSV_dynamicCSV {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String csvFile = "example.csv";
//        CSVWriter writer = new CSVWriter(new FileWriter(csvFile));
//
//        String[] record1 = {"1","Glenn", "Baluyot", "100"};
//        String[] record2 = {"2","David", "Malonjao", "45"};
//        String[] record3 = {"3","Danyy", "Morales", "45"};
//
//        writer.writeNext(record1);
//        writer.writeNext(record2);
//        writer.writeNext(record3);
//
//        writer.close();

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
                System.out.print("Enter the column index to update(starting from 0): ");
                int columnIndex = Integer.parseInt(scanner.nextLine());

                if (columnIndex >= 0 && columnIndex < record.length) {
                    System.out.print("Enter the new value for column" + columnIndex + ": ");
                    String newValue = scanner.nextLine();
                    record[columnIndex] = newValue;
                    System.out.println("Record updated successfully.");
                }
                else{
                    System.out.println("Invalid column index.");
                }
            }
        }

        if (!isFound) {
            System.out.println("Record ID: " + recordID + "doesn't exist.");
        }

        CSVWriter writer = new CSVWriter(new FileWriter(csvFile));

        for (String[] updatedRecord : records) {
            writer.writeNext(updatedRecord);
        }
        writer.close();

        reader = new CSVReader(new FileReader(csvFile));
        for (String[] updatedRecord : records) {
            System.out.println(Arrays.toString(updatedRecord));
        }

        reader.close();

    }

}
