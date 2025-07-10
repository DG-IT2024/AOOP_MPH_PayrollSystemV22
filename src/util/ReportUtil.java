package util;

import java.sql.SQLException;

import net.sf.jasperreports.engine.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

public class ReportUtil {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Get database connection
            conn = DBConnect.getConnection();

            // Path to your JRXML file
            String jrxmlPath = "C:/Users/danilo/Documents/AOOP_MPH_PayrollSystem/src/Report/MyReports/demo.jrxml";

            // Set up parameters if needed
            HashMap<String, Object> parameters = new HashMap<>();
            // Example: parameters.put("paramName", value);

            // Generate report
            JasperPrint jasperPrint = generateReport(jrxmlPath, parameters, conn);

            // Export to PDF
            String pdfPath = "C:/Users/danilo/Documents/AOOP_MPH_PayrollSystem/src/Report/MyReports/demo.pdf";
            exportToPdf(jasperPrint, pdfPath);

            System.out.println("Report generated successfully: " + pdfPath);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Always close your connection
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    public static JasperPrint generateReport(String jrxmlPath, Map<String, Object> parameters, Connection connection) throws JRException {
        // Compile the JRXML file to a JasperReport object
        JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlPath);

        // Fill the report (fetch data from DB using parameters)
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);

        return jasperPrint;
    }

    /**
     * Exports a JasperPrint to a PDF file.
     *
     * @param jasperPrint JasperPrint object (filled report).
     * @param pdfPath Output PDF file path.
     * @throws JRException if exporting fails.
     */
    public static void exportToPdf(JasperPrint jasperPrint, String pdfPath) throws JRException {
        JasperExportManager.exportReportToPdfFile(jasperPrint, pdfPath);
    }
}
