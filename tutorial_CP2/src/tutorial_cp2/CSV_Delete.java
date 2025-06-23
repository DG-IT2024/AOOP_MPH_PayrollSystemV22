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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author danilo
 */
public class CSV_Delete {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        String csvFile = "example.csv";

        CSVReader reader = new CSVReader(new FileReader(csvFile));

        List<String[]> records = reader.readAll();

        System.out.println("Current Records in the CSV File.");

        for (String[] record : records) {

            System.out.println(Arrays.toString(record));
        }
        //Deleting a line in the CSV file. 

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the recrod ID to delete: ");
        String recordIDTODelete = scanner.nextLine();

        boolean isDeleted = false;
        
        for (int i = 0; i < records.size(); i++) 
        {
            String[] record = records.get(i);
            if(record[0].equals(recordIDTODelete))
            {
                records.remove(i);
                isDeleted = true;
                System.out.println("Record with ID "+ recordIDTODelete + "delete successfully");
                break;
                                        
            }
            

        }

        if(!isDeleted){
        System.out.println("Record with ID "+ recordIDTODelete + "not found.");
        }
        
        CSVWriter writer = new CSVWriter (new FileWriter(csvFile));
        writer.writeAll(records);
        
        writer.close();
        
        reader = new CSVReader(new FileReader(csvFile));
        records = reader.readAll();

        System.out.println("Updated records in the CSV File.");
        for (String[] updatedRecord : records) {
            System.out.println(Arrays.toString(updatedRecord));
        }

        reader.close();
    }

}


