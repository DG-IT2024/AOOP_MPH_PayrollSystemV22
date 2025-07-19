/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import ui.employeeuser.EmployeeProfileUser;
import ui.admin.EmployeeProfileAdmin;
import model.Login;
import service.*;

public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public boolean processLogin(String username, String password) {
        try {
            loginService.updateLastLogin(username);
            return loginService.authenticate(username, password);
        } catch (Exception e) {
            System.err.println("Login error: " + e.getMessage());
            return false;
        }
    }

    public void openAdminPanel(int empId) throws Exception {

        try {
            EmployeeProfileAdmin adminFrame = new EmployeeProfileAdmin(empId);
            adminFrame.setVisible(true);
        } catch (Exception ex) {
        }

    }

    public void openEmployeeUserPanel(int empId) throws Exception {
        try {
            EmployeeProfileUser userFrame = new EmployeeProfileUser(empId);
            userFrame.setVisible(true);
        } catch (Exception ex) {

        }

    }

    public void directToPanel(String username) throws Exception {
        Login login = loginService.getLoginDetail(username);
        int empId = login.getEmployeeId();
        String role = loginService.getRole(username);

        switch (role.toLowerCase()) {
            case "admin" -> {
                openAdminPanel(empId);
            }
            case "hr" -> {
                openAdminPanel(empId);
            }
            case "finance" -> {
                openAdminPanel(empId);
            }
            case "it" -> {
                openAdminPanel(empId);
            }
            case "employeeuser" ->
                openEmployeeUserPanel(empId);
            default -> {
                return;
            }
        }

    }

    public int pendingCounter() throws Exception {
        LeaveRequestService leave = new LeaveRequestService();
        return leave.getPendingLeaveRequestCount();
    }
   

}
