/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.DeductionRate;

/**
 *
 * @author danilo
 */
public interface DeductionRateService {

    DeductionRate getDeductionRateForIncome(String type, double income) throws Exception;

    double computeSss(double grossSalary) throws Exception;

    double computePhilHealth(double grossSalary) throws Exception;

    double computePagIbig(double grossSalary) throws Exception;

    double taxableIncome(double grossSalary) throws Exception;

    double computeWithholdingTax(double grossSalary) throws Exception;

    double totalDeduction(double grossSalary) throws Exception;

}
