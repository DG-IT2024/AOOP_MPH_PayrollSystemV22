package util;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTextField;
import model.Employee;
import service.EmployeeService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author danilo
 */
// Utility Class
public class InputValidator {

    private EmployeeService service;

    public static void allowOnlyDigits(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }
    
        
   
    // Allow only digits with max length
    public static void allowOnlyDigits(KeyEvent evt, JTextField textField, int maxLength) {
        char c = evt.getKeyChar();
        int currentLength = textField.getText().length();

        // Allow backspace (8) and delete (127)
        if (!Character.isDigit(c) && c != '\b' && c != '\u007F') {
            evt.consume();
        }

        // Block input if max length is reached
        if (currentLength >= maxLength && c != '\b' && c != '\u007F') {
            evt.consume();
        }
    }

    public static void allowOnlyDate(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '/' && c != '-' && c != '.') {
            evt.consume();
        }
    }

    public static void allowOnlyDigitsSpecial(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '-') {
            evt.consume();
        }
    }

// Allow only digits and '-' with max length, but allow Backspace/Delete anytime
    public static void allowOnlyDigitsSpecial(KeyEvent evt, String currentText, int maxLength) {
        char c = evt.getKeyChar();

        if (c == '\b' || c == '\u007F') {
            return;
        }

        if ((!Character.isDigit(c) && c != '-') || currentText.length() >= maxLength) {
            evt.consume();
        }
    }

    // Allow only alphabets (A-Z, a-z)
    public void allowOnlyAlphabets(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
        }
    }

    public static void allowValidNameCharacters(KeyEvent evt) {
        char c = evt.getKeyChar();

        // Allow letters, space, hyphen, apostrophe, backspace, and delete
        if (!Character.isLetter(c) && c != ' ' && c != '-' && c != '\'' && c != '\b' && c != '\u007F') {
            evt.consume(); // Block invalid input
        }
    }

    // Allow only alphabets (A-Z, a-z)
    public void allowOnlyAlphabets(KeyEvent evt, JTextField textField, int maxLength) {
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) || textField.getText().length() >= maxLength) {
            evt.consume();
        }
    }

    // Set length of text
    public static void allowInputLength(KeyEvent evt, String currentText, int allowedLength) {
        char c = evt.getKeyChar();
        if (c == '\b' || c == '\u007F') {
            return;
        }
        if (currentText.length() >= allowedLength) {
            evt.consume();
        }
    }

    public static boolean isOnlyDigit(char c) {
        return Character.isDigit(c);
    }

    public static boolean isOnlyDigitWithMaxLength(char c, String text, int maxLength) {
        return (Character.isDigit(c) || c == '\b' || c == '\u007F') && (text.length() < maxLength || c == '\b' || c == '\u007F');
    }

    public static boolean isValidDateChar(char c) {
        return Character.isDigit(c) || c == '/' || c == '-' || c == '.';
    }

    public static boolean isOnlyDigitOrDash(char c) {
        return Character.isDigit(c) || c == '-';
    }

    public static boolean isOnlyDigitOrDashWithMaxLength(char c, String currentText, int maxLength) {
        return (Character.isDigit(c) || c == '-') && currentText.length() < maxLength;
    }

    public static boolean isOnlyAlphabet(char c) {
        return Character.isLetter(c);
    }

    public static boolean isOnlyAlphabetWithMaxLength(char c, String text, int maxLength) {
        return Character.isLetter(c) && text.length() < maxLength;
    }

    private static boolean isValidNameCharacter(char c) {
        return Character.isLetter(c) || c == '-' || c == '\'' || c == ' ';
    }

    public static boolean isWithinAllowedLength(char c, String currentText, int allowedLength) {
        return (c == '\b' || c == '\u007F') || currentText.length() < allowedLength;
    }

    public static boolean isAlphanumeric(String input, int maxLength) {
        return input != null && input.length() <= maxLength && input.chars().allMatch(Character::isLetterOrDigit);
    }

    public static boolean isNumericSpecial(String input, int maxLength) {
        // Allows digits and hyphens
        return input != null && input.length() <= maxLength && input.matches("^[0-9\\-]+$");
    }

    public static void validateEmployee(Employee employee) throws SQLException {

        // Status
        if (employee.getStatus() == null || employee.getStatus().trim().isEmpty()) {
            throw new IllegalArgumentException("Status must not be empty.");
        }

        // ID numbers
        if (!isNumericSpecial(employee.getSssNumber(), 20)) {
            throw new IllegalArgumentException("Invalid SSS number.");
        }
        if (!isNumericSpecial(employee.getPhilhealthNumber(), 20)) {
            throw new IllegalArgumentException("Invalid PhilHealth number.");
        }
        if (!isNumericSpecial(employee.getPagibigNumber(), 20)) {
            throw new IllegalArgumentException("Invalid Pag-IBIG number.");
        }
        if (!isNumericSpecial(employee.getTinNumber(), 20)) {
            throw new IllegalArgumentException("Invalid TIN number.");
        }

        // Salary & allowances
        if (employee.getBasicSalary() < 0 || employee.getRiceSubsidy() < 0
                || employee.getPhoneAllowance() < 0 || employee.getClothingAllowance() < 0) {
            throw new IllegalArgumentException("Salary and allowances must be non-negative.");
        }


    }

//    
}
