package util;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.HashMap;

public class ReportUtil {

    private static final String JRXML_PATH = "src/main/resources/reports/employee_payslip.jrxml";
    private static final String REPORT_DIR = "src/main/resources/reports/";

    private static Map<String, Object> createParams(int empId, java.sql.Date startDate, java.sql.Date endDate) {
        Map<String, Object> params = new HashMap<>();
        params.put("empId", empId);
        params.put("startDate", startDate);
        params.put("endDate", endDate);
        return params;
    }


    public static void generatePayslip(int empId, String name, java.sql.Date startDate, java.sql.Date endDate) {
        try (Connection conn = DBConnect.getConnection()) {
            Map<String, Object> params = createParams(empId, startDate, endDate);
            JasperPrint jp = generateReport(JRXML_PATH, params, conn);
            String pdfPath = REPORT_DIR + name + getTodayYYYYMMDD() + ".pdf";
            JasperExportManager.exportReportToPdfFile(jp, pdfPath);
        } catch (SQLException | JRException ignored) {
        }
    }

    public static void viewPayslip(int empId, java.sql.Date startDate, java.sql.Date endDate) {
        try (Connection conn = DBConnect.getConnection()) {

            Map<String, Object> params = createParams(empId, startDate, endDate);
            JasperPrint jp = generateReport(JRXML_PATH, params, conn);
            JasperViewer viewer = new JasperViewer(jp, false); // Prevent app from exiting
            viewer.setVisible(true);
        } catch (SQLException | JRException ignored) {
        }
    }

    public static JasperPrint generateReport(String jrxmlPath, Map<String, Object> params, Connection conn) throws JRException {
        JasperReport jr = JasperCompileManager.compileReport(jrxmlPath);
        return JasperFillManager.fillReport(jr, params, conn);
    }

    public static String getTodayYYYYMMDD() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
