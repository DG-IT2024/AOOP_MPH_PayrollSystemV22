/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.DeductionRateDao;
import dao.DeductionRateDaoImpl;
import java.sql.Connection;
import java.sql.SQLException;
import model.DeductionRate;
import util.DBConnect;

/**
 *
 * @author danilo
 */
public class DeductionRateServiceImpl implements DeductionRateService {

    private DeductionRateDao deductionRateDao;

    public DeductionRateServiceImpl() throws SQLException {
        Connection conn = DBConnect.getConnection();
        this.deductionRateDao = new DeductionRateDaoImpl(conn);

    }

    @Override
    public double computeSss(double grossSalary) throws Exception {
        DeductionRate rate = deductionRateDao.findMatchingRate("SSS", grossSalary);
        return (rate == null) ? 0.0 : rate.getAmount(); // 
    }

    @Override
    public double computePhilHealth(double grossSalary) throws Exception {
        DeductionRate rate = deductionRateDao.findMatchingRate("PhilHealth", grossSalary);
        if (rate == null) {
            return 0.0;
        }
        if (rate.getAmount() != 0) { // Use fixed amount if present
            return rate.getAmount();
        } else {
            return roundToTwo(grossSalary * rate.getDeductionRate() / 100.0);
        }
    }

    @Override
    public double computePagIbig(double grossSalary) throws Exception {
        DeductionRate rate = deductionRateDao.findMatchingRate("Pag-IBIG", grossSalary);
        if (rate == null) {
            return 0.0;
        }
        double computed = roundToTwo(grossSalary * rate.getDeductionRate() / 100.0);
        // Cap at 100 as per your table
        return Math.min(computed, 100.0);
    }

    @Override
    public double taxableIncome(double grossSalary) throws Exception {
        Double taxableIncome = grossSalary - computeSss(grossSalary) - computePagIbig(grossSalary) - computePhilHealth(grossSalary);
        return taxableIncome;
    }

    @Override
    public double computeWithholdingTax(double grossSalary) throws Exception {
        double taxableIncome = taxableIncome(grossSalary);
        DeductionRate rate = deductionRateDao.findMatchingRate("Withholding Tax", taxableIncome);
        if (rate == null) {
            return 0.0;
        }
        if (rate.getDeductionRate() == 0 && rate.getAmount() == 0) {
            return 0.0;
        }
        double excess = taxableIncome - rate.getMinIncome();
        double computedTax = rate.getAmount() + (excess * (rate.getDeductionRate() / 100.0));
        return roundToTwo(computedTax);
    }

    @Override
    public double totalDeduction(double grossSalary) throws Exception {
        double totalDeductions = computeSss(grossSalary) + computePagIbig(grossSalary) + computePhilHealth(grossSalary) + computeWithholdingTax(grossSalary);
        return totalDeductions;
    }

    @Override
    public DeductionRate getDeductionRateForIncome(String type, double income) throws Exception {
        return deductionRateDao.findMatchingRate(type, income);
    }

    private double roundToTwo(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
