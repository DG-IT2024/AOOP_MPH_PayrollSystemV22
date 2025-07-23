
import java.io.File;
import java.sql.Connection;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import util.ReportUtil;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import net.sf.jasperreports.engine.JRException;
import service.AttendanceService;
import util.DBConnect;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReportUtilTest {

    private static Connection conn;
    private AttendanceService service;

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for ReportUtilTest.");
    }

    @BeforeEach
    public void setUp() throws Exception {
        service = new AttendanceService();
    }

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
        System.out.println("Test 2: generatePayslip - Generates PDF file and builds correct parameters");

        int empId = 10001;
        String name = "Garcia";
        Date startDate = Date.valueOf("2024-07-01");
        Date endDate = Date.valueOf("2024-07-31");

        assertDoesNotThrow(() -> {
            ReportUtil.generatePayslip(empId, name, startDate, endDate);
        });

        String pdfPath = "src/main/resources/reports/" + name + ReportUtil.getTodayYYYYMMDD() + ".pdf";
        File file = new File(pdfPath);
        assertTrue(file.exists(), "PDF file should exist at path: " + pdfPath);

        System.out.println("PDF generated at: " + pdfPath);
    }

    @Test
    public void test3_generateReport_missingFile() {
        System.out.println("Test 3: generateReport - Missing JRXML throws expected exception");

        String fakeJrxml = "not_a_real_file.jrxml";
        Map<String, Object> params = new HashMap<>();
        params.put("empId", 10001);
        params.put("startDate", Date.valueOf("2024-07-01"));
        params.put("endDate", Date.valueOf("2024-07-15"));

        Exception ex = assertThrows(Exception.class, () -> {
            ReportUtil.generateReport(fakeJrxml, params, null);
        });

        // Optional: Check for JRException or message content
        assertTrue(ex instanceof JRException || ex.getMessage().toLowerCase().contains("not_a_real_file"),
                "Expected JRException or message indicating missing .jrxml file");

        System.out.println("Expected exception type: " + ex.getClass().getSimpleName());
    }

}
