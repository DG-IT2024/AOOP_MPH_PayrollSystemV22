package dao;

import java.sql.*;
import java.util.*;
import model.DeductionRate;

public class DeductionRateDAO {

    private Connection conn;

    public DeductionRateDAO(Connection conn) {
        this.conn = conn;
    }

    public void addDeductionRate(DeductionRate rate) throws SQLException {
        String sql = "INSERT INTO deduction_rate (type, description, min_income, max_income, deduction_rate, amount) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, rate.getType());
            stmt.setString(2, rate.getDescription());
            stmt.setDouble(3, rate.getMinIncome());
            stmt.setDouble(4, rate.getMaxIncome());
            stmt.setDouble(5, rate.getDeductionRate());
            stmt.setDouble(6, rate.getAmount());
            stmt.executeUpdate();
        }
    }

    public DeductionRate getDeductionRateById(int id) throws SQLException {
        String sql = "SELECT * FROM deduction_rate WHERE deduction_rate_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToDeductionRate(rs);
                }
            }
        }
        return null;
    }

    public List<DeductionRate> getAllDeductionRates() throws SQLException {
        List<DeductionRate> rates = new ArrayList<>();
        String sql = "SELECT * FROM deduction_rate";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rates.add(mapRowToDeductionRate(rs));
            }
        }
        return rates;
    }

    public void updateDeductionRate(DeductionRate rate) throws SQLException {
        String sql = "UPDATE deduction_rate SET type=?, description=?, min_income=?, max_income=?, deduction_rate=?, amount=? WHERE deduction_rate_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, rate.getType());
            stmt.setString(2, rate.getDescription());
            stmt.setDouble(3, rate.getMinIncome());
            stmt.setDouble(4, rate.getMaxIncome());
            stmt.setDouble(5, rate.getDeductionRate());
            stmt.setDouble(6, rate.getAmount());
            stmt.setInt(7, rate.getDeductionRateId());
            stmt.executeUpdate();
        }
    }

    public void deleteDeductionRate(int id) throws SQLException {
        String sql = "DELETE FROM deduction_rate WHERE deduction_rate_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    private DeductionRate mapRowToDeductionRate(ResultSet rs) throws SQLException {
        DeductionRate rate = new DeductionRate();
        rate.setDeductionRateId(rs.getInt("deduction_rate_id"));
        rate.setType(rs.getString("type"));
        rate.setDescription(rs.getString("description"));
        rate.setMinIncome(rs.getDouble("min_income"));
        rate.setMaxIncome(rs.getDouble("max_income"));
        rate.setDeductionRate(rs.getDouble("deduction_rate"));
        rate.setAmount(rs.getDouble("amount"));
        return rate;
    }
}
