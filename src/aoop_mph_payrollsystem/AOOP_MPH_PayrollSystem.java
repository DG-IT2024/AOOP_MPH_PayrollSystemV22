/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aoop_mph_payrollsystem;

import dao.AttendanceDAO;
import dao.LoginDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import model.Login;
import ui.LoginView;
import util.DBConnect;
import java.sql.Time;

/**
 *
 * @author danilo
 */
public class AOOP_MPH_PayrollSystem {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, SQLException {
        new LoginView().setVisible(true);

    }
    
}
