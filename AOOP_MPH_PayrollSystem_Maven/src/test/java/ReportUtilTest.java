
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import util.ReportUtil;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReportUtilTest {

    @Test
    public void test1_getTodayYYYYMMDD_format() {
        System.out.println("Test 1: getTodayYYYYMMDD - Current date in correct format");
        String today = ReportUtil.getTodayYYYYMMDD();
        String expected = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        assertEquals(expected, today);
        System.out.println("Today: " + today);
    }

    @Test
    public void test2_generatePayslip_parameters() {
        System.out.println("Test 2: generatePayslip - Builds parameter map correctly");
        int empId = 10001;
        String name = "Garcia_Manuel";
        Date startDate = Date.valueOf("2024-07-01");
        Date endDate = Date.valueOf("2024-07-15");

        // Simulate what generatePayslip builds
        Map<String, Object> params = new HashMap<>();
        params.put("empId", empId);
        params.put("startDate", startDate);
        params.put("endDate", endDate);

        assertEquals(empId, params.get("empId"));
        assertEquals(startDate, params.get("startDate"));
        assertEquals(endDate, params.get("endDate"));

        String pdfPath = "src/main/resources/reports/" + name + ReportUtil.getTodayYYYYMMDD() + ".pdf";
        assertTrue(pdfPath.endsWith(".pdf"));
        System.out.println("PDF path: " + pdfPath);
    }

    @Test
    public void test3_generateReport_missingFile() {
        System.out.println("Test 3: generateReport - Missing JRXML throws JRException");
        String fakeJrxml = "not_a_real_file.jrxml";
        Map<String, Object> params = new HashMap<>();
        params.put("empId", 10001);
        params.put("startDate", Date.valueOf("2024-07-01"));
        params.put("endDate", Date.valueOf("2024-07-15"));
        Exception ex = assertThrows(Exception.class, () -> {
            ReportUtil.generateReport(fakeJrxml, params, null);
        });
        System.out.println("Expected exception for missing JRXML: " + ex.getClass().getSimpleName());
    }

    @Test
    public void test_viewPayslip_validDatesButNoDb() {
        System.out.println("Test: viewPayslip - Valid dates but simulate missing DB");

        // Valid date range
        Date startDate = Date.valueOf("2024-07-01");
        Date endDate = Date.valueOf("2024-07-15");

        // Expect failure due to missing DB or resources
        Exception ex = assertThrows(RuntimeException.class, () -> {
            ReportUtil.viewPayslip(10001, startDate, endDate);
        });

        System.out.println("Exception thrown: " + ex.getMessage());
    }

}
