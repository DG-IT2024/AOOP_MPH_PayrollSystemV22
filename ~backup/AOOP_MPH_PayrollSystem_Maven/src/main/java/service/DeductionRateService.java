/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.DeductionRateDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.DeductionRate;

public class DeductionRateService {

    private DeductionRateDAO deductionRateDAO;

    public DeductionRateService(Connection conn) {
        this.deductionRateDAO = new DeductionRateDAO(conn);
    }

    public void addDeductionRate(DeductionRate rate) throws SQLException {
        deductionRateDAO.addDeductionRate(rate);
    }

    public DeductionRate getDeductionRateById(int id) throws SQLException {
        return deductionRateDAO.getDeductionRateById(id);
    }

    public List<DeductionRate> getAllDeductionRates() throws SQLException {
        return deductionRateDAO.getAllDeductionRates();
    }

}
