package util;

import controller.EmployeeController;
import java.sql.SQLException;

import net.sf.jasperreports.engine.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.view.JasperViewer;
import service.EmployeeService;

public class ReportUtil {

    public static void connectJaspter(int empId, String Name, java.sql.Date startDate, java.sql.Date endDate) {
        Connection conn = null;

        try {

            conn = DBConnect.getConnection(); // Get database connection

            String reportPath = "C:/Users/danilo/Documents/AOOP_MPH_PayrollSystem/src/Report/MyReports/employee_payslip.jrxml";

            HashMap<String, Object> parameters = new HashMap<>();     // Set up parameters if needed        // Example: parameters.put("paramName", value);
            parameters.put("empId", empId);
            parameters.put("startDate", startDate);
            parameters.put("endDate", endDate);

            JasperPrint jasperPrint = generateReport(reportPath, parameters, conn);     // Generate report


            String fileName = Name;
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
