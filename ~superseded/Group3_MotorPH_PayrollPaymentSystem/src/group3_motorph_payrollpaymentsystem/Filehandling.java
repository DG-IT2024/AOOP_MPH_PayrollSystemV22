/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group3_motorph_payrollpaymentsystem;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filehandling {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String csvFile = "MotorPHEmployeeData.csv"; // Use your file path here
//        CSVReader reader = null;

        CSVReader reader = new CSVReader(new FileReader(csvFile));
        List<String[]> records = reader.readAll();
        List<Employee> employees = new ArrayList<>();

        for (String[] record : records) {
            if (record.length == 18) { // Ensure the record has all the necessary fields
                int employeeNumber = Integer.parseInt(record[0]);
                String lastName = record[1];
                String firstName = record[2];
                String employeeBirthday = record[3];
                String address = record[4];
                String phoneNumber = record[5];
                String sssNumber = record[6];
                String philHealthNumber = record[7];
                String tinNumber = record[8];
                String pagIbigNumber = record[9];
                String status = record[10];
                String position = record[11];
                String immediateSupervisor = record[12];
                double basicSalary = Double.parseDouble(record[13]);
                double riceSubsidy = Double.parseDouble(record[14]);
                double phoneAllowance = Double.parseDouble(record[15]);
                double clothingAllowance = Double.parseDouble(record[16]);
                double grossSemiMonthlyRate = Double.parseDouble(record[17]);

                Employee employee = new Employee(employeeNumber, lastName, firstName, employeeBirthday, address, phoneNumber, sssNumber, philHealthNumber, tinNumber, pagIbigNumber, status, position, immediateSupervisor, basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate);
                employees.add(employee);
                System.out.println(Arrays.toString(record));

            }
        }

    }
}

//    private static List<String> readLinesFromFile(String fileName) {
//        List<String> lines = new ArrayList<>();
//        try (BufferedReader brReader = new BufferedReader(new FileReader(fileName))) {
//            String line;
//            while ((line = brReader.readLine()) != null) {
//                lines.add(line); // Add each line to the ArrayList
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return lines;
//    }

