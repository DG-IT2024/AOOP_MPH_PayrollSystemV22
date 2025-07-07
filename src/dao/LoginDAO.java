/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author danilo
 */
import java.sql.*;
import java.util.*;
import model.*;

public class LoginDAO {

    private Connection conn;

    // Add this constructor
    public LoginDAO(Connection conn) {
        this.conn = conn;
    }

    public Login getLoginByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM login WHERE username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Login login = new Login();
                login.setLoginId(rs.getInt("login_id"));
                login.setUsername(rs.getString("username"));
                login.setEmployeeId(rs.getInt("employee_id"));
                login.setLastLogin(rs.getTimestamp("last_login"));
                login.setNoAttempts(rs.getInt("no_attempt"));
                return login;
            }
        }
        return null;
    }

    public Password getPasswordByLoginId(int loginId) throws SQLException {
        String sql = "SELECT * FROM password WHERE login_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, loginId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Password pw = new Password();
                pw.setPasswordId(rs.getInt("password_id"));
                pw.setLoginId(rs.getInt("login_id"));
                pw.setPasswordSaltHash(rs.getString("password_salt_hash"));
                return pw;
            }
        }
        return null;
    }

    public List<Role> getRolesByLoginId(int loginId) throws SQLException {
        String sql = "SELECT r.role_id, r.role_name, r.description FROM role r "
                + "JOIN user_role ur ON r.role_id = ur.role_id WHERE ur.login_id = ?";
        List<Role> roles = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, loginId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setRoleId(rs.getInt("role_id"));
                role.setRoleName(rs.getString("role_name"));
                role.setDescription(rs.getString("description"));
                roles.add(role);
            }
        }
        return roles;
    }

    // Increase the no_attempt count by 1 for a user
    public void incrementLoginAttempts(String username) throws SQLException {
        String sql = "UPDATE login SET no_attempt = no_attempt + 1 WHERE username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.executeUpdate();
        }
    }

// Reset the no_attempt count to 0 for a user (after successful login)
    public void resetLoginAttempts(String username) throws SQLException {
        String sql = "UPDATE login SET no_attempt = 0 WHERE username = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.executeUpdate();
        }
    }

    public Password getRoleByEmpId(int empId) throws SQLException {
        String sql = "SELECT * FROM role WHERE empId = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, empId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Password pw = new Password();
                pw.setPasswordId(rs.getInt("password_id"));
                pw.setLoginId(rs.getInt("login_id"));
                pw.setPasswordSaltHash(rs.getString("password_salt_hash"));
                return pw;
            }
        }
        return null;
    }

}
