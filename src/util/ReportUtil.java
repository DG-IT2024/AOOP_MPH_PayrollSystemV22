package util;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

public class ReportUtil {
    
    public static void showReport(String jrxmlPath) throws SQLException {
        try (var conn = DBConnect.getConnection()) {
            // 1. Compile JRXML into JasperReport object
            JasperReport jr = JasperCompileManager.compileReport(jrxmlPath);

            // 2. Prepare parameters (empty for now)
            Map<String, Object> params = new HashMap<>();

            // 3. Fill the report using your DBConnect JDBC connection
            JasperPrint jp = JasperFillManager.fillReport(jr, params, conn);

            // 4. Display the report in a Swing viewer
            JasperViewer.viewReport(jp, false);
        } catch (JRException | SQLException e) {
            e.printStackTrace();
        }
    }
}
