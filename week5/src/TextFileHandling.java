/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danilo
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class TextFileHandling {
    public static void main(String[] args) {
        // Create a File object
        File file = new File("example.txt");

        try {
            // Create a FileWriter object
            FileWriter writer = new FileWriter(file);

            // Write data to the file
            writer.write("Hello, world!");
            // Close the FileWriter object
            writer.close();

            // Create a FileReader object
            FileReader reader = new FileReader(file);

            // Read data from the file
            int c = reader.read();
            while (c != -1) {
                System.out.print((char) c);
                c = reader.read();
            }

            // Close the FileReader object
            reader.close();

            // Delete the file
            file.delete();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
