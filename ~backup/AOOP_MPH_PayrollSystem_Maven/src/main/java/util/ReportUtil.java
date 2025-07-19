package util;

import java.sql.SQLException;

import net.sf.jasperreports.engine.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.view.JasperViewer;

public class ReportUtil {

    public static void connectJaspter() {
        Connection conn = null;

        try {

            conn = DBConnect.getConnection(); // Get database connection

            String reportPath = "C:/Users/danilo/Documents/AOOP_MPH_PayrollSystem/src/Report/MyReports/employee_payslip.jrxml";

            HashMap<String, Object> parameters = new HashMap<>();     // Set up parameters if needed        // Example: parameters.put("paramName", value);
            parameters.put("empId", 10020);
            parameters.put("startDate", java.sql.Date.valueOf("2024-06-01"));
            parameters.put("endDate", java.sql.Date.valueOf("2024-06-30"));

            JasperPrint jasperPrint = generateReport(reportPath, parameters, conn);     // Generate report

            // Export to PDF
            String fileName = "Dennis";
            String pdfPath = "C:/Users/danilo/Documents/AOOP_MPH_PayrollSystem/src/Report/MyReports/" + fileName + ".pdf";
            exportToPdf(jasperPrint, pdfPath);

        } catch (SQLException | JRException e) {
        } finally {

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }

    }

    public static JasperPrint generateReport(String jrxmlPath, Map<String, Object> parameters, Connection connection) throws JRException {

        JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlPath);          // Compile the JRXML file to a JasperReport object
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);  // Fill the report (fetch data from DB using parameters)

        return jasperPrint;
    }

    public static void viewReport(int empId, java.sql.Date startDate, java.sql.Date endDate) throws SQLException, JRException {
        java.sql.Connection conn = DBConnect.getConnection();

        String reportPath = "C:/Users/danilo/Documents/AOOP_MPH_PayrollSystem/src/Report/MyReports/employee_payslip.jrxml";

        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("empId", empId);
        parameters.put("startDate", startDate);
        parameters.put("endDate", endDate);

        JasperReport jr = JasperCompileManager.compileReport(reportPath);
        JasperPrint jp = JasperFillManager.fillReport(jr, parameters, conn);
        JasperViewer.viewReport(jp);

    }

    public static void exportToPdf(JasperPrint jasperPrint, String pdfPath) throws JRException {
        JasperExportManager.exportReportToPdfFile(jasperPrint, pdfPath);
    }

    /**
     * Exports a JasperPrint to a PDF file.
     *
     * @param jasperPrint JasperPrint object (filled report).
     * @param pdfPath Output PDF file path.
     * @throws JRException if exporting fails.
     */
}
