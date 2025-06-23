/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danilo
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVWriter;

public class CSVCreateAndWrite {

    public static void main(String[] args) throws IOException {
        // Create a list to store the quiz scores for each student
        List<StudentQuizScores> studentScores = new ArrayList<>();

        // Prompt the user to enter the student details and quiz grades
        Scanner scanner = new Scanner(System.in);
        boolean done = false;
        while (!done) {
            System.out.print("Enter student number (or type 'done' to finish): ");
            String studentNumber = scanner.nextLine();
            if (studentNumber.equalsIgnoreCase("done")) {
                done = true;
                continue;
            }
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            int[] quizGrades = new int[5];
            for (int i = 0; i < 5; i++) {
                System.out.print("Enter quiz " + (i+1) + " grade: ");
                quizGrades[i] = scanner.nextInt();
            }
            scanner.nextLine(); // Consume the newline left-over
            studentScores.add(new StudentQuizScores(studentNumber, studentName, quizGrades));
        }
        scanner.close();

        // Write the student details and quiz averages to a CSV file
        String csvFile = "student_grades.csv";
        CSVWriter writer = new CSVWriter(new FileWriter(csvFile));

        // Write the headers to the CSV file
        String[] headers = {"student_number", "student_name", "quiz_1", "quiz_2", "quiz_3", "quiz_4", "quiz_5"};
        writer.writeNext(headers);

        // Write each student's details and quiz averages to the CSV file
        for (StudentQuizScores student : studentScores) {
            String[] data = new String[8];
            data[0] = student.getStudentNumber();
            data[1] = student.getStudentName();
            int[] grades = student.getQuizGrades();
            for (int i = 0; i < 5; i++) {
                data[i+2] = Integer.toString(grades[i]);
            }
            writer.writeNext(data);
        }
        writer.close();
    }

    // A helper class to store the quiz scores for each student
    private static class StudentQuizScores {
        private String studentNumber;
        private String studentName;
        private int[] quizGrades;

        public StudentQuizScores(String studentNumber, String studentName, int[] quizGrades) {
            this.studentNumber = studentNumber;
            this.studentName = studentName;
            this.quizGrades = quizGrades;
        }

        public String getStudentNumber() {
            return studentNumber;
        }

        public String getStudentName() {
            return studentName;
        }

        public int[] getQuizGrades() {
            return quizGrades;
        }
    }
}
