/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.aoop_mph_payrollsystem_maven;

import dao.DeductionRateDao;
import dao.DeductionRateDaoImpl;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import service.DeductionRateService;
import service.DeductionRateServiceImpl;
import ui.admin.LoginView;
import util.DBConnect;

/**
 *
 * @author danilo
 */
public class AOOP_MPH_PayrollSystem_Maven {

    public static void main(String[] args) throws IOException, SQLException, Exception {
//        new LoginView().setVisible(true);
     
        DeductionRateService service = new DeductionRateServiceImpl();

// Compute all deductions for salary
        double salary = 46086.25;
        double sss = service.computeSss(salary);
        double philHealth = service.computePhilHealth(salary);
        double pagIbig = service.computePagIbig(salary);
        double tax = service.computeWithholdingTax(salary);
        double netpay = salary - sss- pagIbig - tax;

        System.out.printf("SSS: %.2f, PhilHealth: %.2f, Pag-IBIG: %.2f, Tax: %.2f\n", sss, philHealth, pagIbig, tax);

          }

}
