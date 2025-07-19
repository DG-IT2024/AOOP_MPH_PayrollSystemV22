package dao;

import model.Employee;
import java.sql.*;
import java.util.*;

public class EmployeeDAO {

    private Connection conn;

    public EmployeeDAO(Connection conn) {
        this.conn = conn;
    }

    private Employee mapEmployee(ResultSet rs) throws SQLException {
        Employee emp = new Employee();
        emp.setEmployeeId(rs.getInt("employee_id"));
        emp.setLastName(rs.getString("last_name"));
        emp.setFirstName(rs.getString("first_name"));
        emp.setBirthdate(rs.getDate("birthdate"));
        emp.setStreet(rs.getString("street"));
        emp.setBarangay(rs.getString("barangay"));
        emp.setCity(rs.getString("city"));
        emp.setProvince(rs.getString("province"));
        emp.setZip(rs.getString("zipcode"));
        emp.setPhoneNumber(rs.getString("phone_number"));
        emp.setSssNumber(rs.getString("sss"));
        emp.setPhilhealthNumber(rs.getString("philhealth"));
        emp.setPagibigNumber(rs.getString("pagibig"));
        emp.setTinNumber(rs.getString("tin"));
        emp.setStatus(rs.getString("employment_status"));
        emp.setPosition(rs.getString("job_position"));
        emp.setImmediateSupervisor(rs.getString("immediate_supervisor"));
        emp.setBasicSalary(rs.getDouble("basic_salary"));
        emp.setRiceSubsidy(rs.getDouble("rice_subsidy"));
        emp.setPhoneAllowance(rs.getDouble("phone_allowance"));
        emp.setClothingAllowance(rs.getDouble("clothing_allowance"));
        return emp;
    }

    // Get all employees (if your SP supports it)
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "{CALL sp_employee_details(NULL)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    employees.add(mapEmployee(rs));
                }
            }
        }
        return employees;
    }

    public Employee getEmployeeDetailsById(int empId) throws SQLException {
        String sql = "{CALL sp_employee_details(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, empId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Employee emp = mapEmployee(rs);
                    return emp;
                }
            }
        }
        return null;
    }

    public void createEmployee(Employee emp) throws SQLException {
        String sql = "{CALL sp_add_employee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"; // 20 parameters for insert
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, emp.getLastName());
            stmt.setString(2, emp.getFirstName());
          
            if (emp.getBirthdate() != null) {
                stmt.setDate(3, new java.sql.Date(emp.getBirthdate().getTime()));
            } else {
                stmt.setNull(3, java.sql.Types.DATE);
            }
            stmt.setString(4, emp.getStreet());
            stmt.setString(5, emp.getBarangay());
            stmt.setString(6, emp.getCity());
            stmt.setString(7, emp.getProvince());
            stmt.setString(8, emp.getZip());
            stmt.setString(9, emp.getPhoneNumber());
            stmt.setString(10, emp.getSssNumber());
            stmt.setString(11, emp.getPhilhealthNumber());
            stmt.setString(12, emp.getPagibigNumber());
            stmt.setString(13, emp.getTinNumber());
            stmt.setString(14, emp.getStatus());
            stmt.setString(15, emp.getPosition());
            stmt.setString(16, emp.getImmediateSupervisor());
            stmt.setDouble(17, emp.getBasicSalary());
            stmt.setDouble(18, emp.getRiceSubsidy());
            stmt.setDouble(19, emp.getPhoneAllowance());
            stmt.setDouble(20, emp.getClothingAllowance());
            // stmt.setInt(21, emp.getEmployeeId()); // ONLY for update, not create
            stmt.executeUpdate();
        }
    }

    public void updateEmployee(Employee emp) throws SQLException {
        String sql = "{CALL sp_update_employee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"; // 21 parameters
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, emp.getEmployeeId());
            stmt.setString(2, emp.getLastName());
            stmt.setString(3, emp.getFirstName());
            stmt.setDate(4, emp.getBirthdate() == null ? null : new java.sql.Date(emp.getBirthdate().getTime()));
            stmt.setString(5, emp.getStreet());
            stmt.setString(6, emp.getBarangay());
            stmt.setString(7, emp.getCity());
            stmt.setString(8, emp.getProvince());
            stmt.setString(9, emp.getZip());
            stmt.setString(10, emp.getPhoneNumber());
            stmt.setString(11, emp.getSssNumber());
            stmt.setString(12, emp.getPhilhealthNumber());
            stmt.setString(13, emp.getPagibigNumber());
            stmt.setString(14, emp.getTinNumber());
            stmt.setString(15, emp.getStatus());
            stmt.setString(16, emp.getPosition());
            stmt.setString(17, emp.getImmediateSupervisor());
            stmt.setDouble(18, emp.getBasicSalary());
            stmt.setDouble(19, emp.getRiceSubsidy());
            stmt.setDouble(20, emp.getPhoneAllowance());
            stmt.setDouble(21, emp.getClothingAllowance());
            stmt.executeUpdate();
        }
    }

    public void deleteEmployee(int employeeId) throws SQLException {
        String sql = "{CALL sp_delete_employee(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, employeeId);
            stmt.executeUpdate();
        }
    }

    // EmployeeDAO.java
    public boolean isGovtIdDuplicate(String sss, String tin, String philHealth, String pagIbig) {
        String sql = "SELECT COUNT(*) FROM government_id WHERE sss = ? OR tin = ? OR philhealth = ? OR pagibig = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, sss);
            stmt.setString(2, philHealth);
            stmt.setString(3, pagIbig);
            stmt.setString(4, tin);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // returns true if duplicate found
            }
        } catch (SQLException e) {
        }
        return false;
    }

}
