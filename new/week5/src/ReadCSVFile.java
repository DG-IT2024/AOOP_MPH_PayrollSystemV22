/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danilo
 */
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class ReadCSVFile {

    public static void main(String[] args) throws IOException {
        // Open the CSV file and create a reader object
        String csvFile = "student_grades.csv";
        CSVReader reader = new CSVReader(new FileReader(csvFile));

        // Read the headers from the CSV file
        String[] headers = reader.readNext();

        // Create a list to store the quiz grades for each student
        List<StudentQuizScores> studentScores = new ArrayList<>();

        // Read each line of the CSV file and store the student quiz scores
        String[] line;
        while ((line = reader.readNext()) != null) {
            String studentNumber = line[0];
            String studentName = line[1];
            int[] quizGrades = new int[5];
            for (int i = 0; i < 5; i++) {
                quizGrades[i] = Integer.parseInt(line[i + 2]);
            }
            studentScores.add(new StudentQuizScores(studentNumber, studentName, quizGrades));
        }
        reader.close();

        // Calculate the average quiz grade for each student and display the results
        for (StudentQuizScores student : studentScores) {
            double average = student.getQuizAverage();
            System.out.println("Student Number: " + student.getStudentNumber());
            System.out.println("Student Name: " + student.getStudentName());
            System.out.println("Quiz Average: " + average);
        }
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

        public double getQuizAverage() {
            int total = 0;
            for (int grade : quizGrades) {
                total += grade;
            }
            return (double) total / quizGrades.length;
        }
    }
}
