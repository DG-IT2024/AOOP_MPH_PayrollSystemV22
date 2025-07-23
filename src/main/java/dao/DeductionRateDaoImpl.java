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
import java.util.ArrayList;
import java.util.List;
import model.DeductionRate;

public class DeductionRateDaoImpl implements DeductionRateDao {

    private Connection conn;

    public DeductionRateDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public DeductionRate getById(int id) throws Exception {
        String sql = "SELECT * FROM deduction_rate WHERE deduction_rate_id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return map(rs);
            }
            return null;
        }
    }

    @Override
    public List<DeductionRate> getAll() throws Exception {
        String sql = "SELECT * FROM deduction_rate";
        List<DeductionRate> list = new ArrayList<>();
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(map(rs));
            }
        }
        return list;
    }

    @Override
    public List<DeductionRate> getByType(String type) throws Exception {
        String sql = "SELECT * FROM deduction_rate WHERE type=?";
        List<DeductionRate> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, type);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add(map(rs));
            }
        }
        return list;
    }

    // Find the deduction rate matching a specific type and income bracket
    @Override
    public DeductionRate findMatchingRate(String type, double income) throws Exception {
        String sql = "SELECT * FROM deduction_rate "
                + "WHERE type = ? "
                + "AND ? >= min_income "
                + "AND (max_income IS NULL OR ? <= max_income) "
                + "LIMIT 1";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, type);
            stmt.setDouble(2, income);
            stmt.setDouble(3, income);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return map(rs);
            }
            return null;
        }
    }

    private DeductionRate map(ResultSet rs) throws SQLException {
        DeductionRate dr = new DeductionRate();
        dr.setDeductionRateId(rs.getInt("deduction_rate_id"));
        dr.setType(rs.getString("type"));
        dr.setDescription(rs.getString("description"));
        dr.setMinIncome(rs.getDouble("min_income"));
        dr.setMaxIncome(rs.getDouble("max_income"));
        dr.setDeductionRate(rs.getDouble("deduction_rate"));
        dr.setAmount(rs.getDouble("amount"));
        return dr;
    }

}
