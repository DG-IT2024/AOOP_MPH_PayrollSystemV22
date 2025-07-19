import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import util.DateUtil;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DateUtilTest {

    @Test
    public void test1_convertToDate_stringMMDDYYYY() throws Exception {
        System.out.println("Test 1: convertToDate - String MM/dd/yyyy");
        String dateStr = "07/14/2025";
        Date date = DateUtil.convertToDate(dateStr);
        assertNotNull(date);
        System.out.println("Parsed: " + date);
    }

    @Test
    public void test2_convertToDate_stringYYYYMMDD() throws Exception {
        System.out.println("Test 2: convertToDate - String yyyy-MM-dd");
        String dateStr = "2025-07-14";
        Date date = DateUtil.convertToDate(dateStr);
        assertNotNull(date);
        System.out.println("Parsed: " + date);
    }

    @Test
    public void test3_convertToDate_invalidString() {
        System.out.println("Test 3: convertToDate - Invalid string");
        String invalid = "not-a-date";
        Exception ex = assertThrows(ParseException.class, () -> DateUtil.convertToDate(invalid));
        System.out.println("Expected exception: " + ex.getMessage());
    }

    @Test
    public void test4_dateToString_customPattern() throws Exception {
        System.out.println("Test 4: dateToString - Custom pattern");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2025-07-14");
        String str = DateUtil.dateToString(date, "MM/dd/yyyy");
        assertEquals("07/14/2025", str);
        System.out.println("Formatted: " + str);
    }

    @Test
    public void test5_dateToDefaultString() throws Exception {
        System.out.println("Test 5: dateToDefaultString");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2025-07-14");
        String str = DateUtil.dateToDefaultString(date);
        assertEquals("07/14/2025", str);
        System.out.println("Default formatted: " + str);
    }

    @Test
    public void test6_utilDateToSqlDate_andBack() throws Exception {
        System.out.println("Test 6: utilDateToSqlDate & sqlDateToUtilDate");
        Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse("2025-07-14");
        java.sql.Date sqlDate = DateUtil.utilDateToSqlDate(utilDate);
        Date utilDate2 = DateUtil.sqlDateToUtilDate(sqlDate);
        assertEquals(utilDate.getTime(), utilDate2.getTime());
        System.out.println("Conversion round-trip successful");
    }

    @Test
    public void test7_isSameDay_true() throws Exception {
        System.out.println("Test 7: isSameDay - True");
        Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse("2025-07-14");
        Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse("2025-07-14");
        assertTrue(DateUtil.isSameDay(d1, d2));
        System.out.println("Dates are same day.");
    }

    @Test
    public void test8_isSameDay_false() throws Exception {
        System.out.println("Test 8: isSameDay - False");
        Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse("2025-07-14");
        Date d2 = new SimpleDateFormat("yyyy-MM-dd").parse("2025-07-15");
        assertFalse(DateUtil.isSameDay(d1, d2));
        System.out.println("Dates are not the same day.");
    }

    @Test
    public void test9_formatDate() throws Exception {
        System.out.println("Test 9: formatDate");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2025-07-14");
        String formatted = DateUtil.formatDate(date);
        assertEquals("07/14/2025", formatted);
        System.out.println("Formatted: " + formatted);
    }

    @Test
    public void test10_isValidDateRange_valid() {
        System.out.println("Test 10: isValidDateRange - Valid range");
        boolean valid = DateUtil.isValidDateRange("2024-01-01", "2024-12-31");
        assertTrue(valid);
        System.out.println("Valid date range.");
    }

    @Test
    public void test11_isValidDateRange_invalid() {
        System.out.println("Test 11: isValidDateRange - Invalid (start > end)");
        boolean valid = DateUtil.isValidDateRange("2024-12-31", "2024-01-01");
        assertFalse(valid);
        System.out.println("Invalid date range detected.");
    }

    @Test
    public void test12_isValidDateRange_malformed() {
        System.out.println("Test 12: isValidDateRange - Malformed date");
        boolean valid = DateUtil.isValidDateRange("not-a-date", "2024-01-01");
        assertFalse(valid);
        System.out.println("Malformed date detected as invalid.");
    }

    @Test
    public void test13_isSunday_true_false() throws Exception {
        System.out.println("Test 13: isSunday - Sunday and non-Sunday");
        Date sunday = new SimpleDateFormat("yyyy-MM-dd").parse("2024-07-14"); // 2024-07-14 is Sunday
        Date monday = new SimpleDateFormat("yyyy-MM-dd").parse("2024-07-15");
        assertTrue(DateUtil.isSunday(sunday));
        assertFalse(DateUtil.isSunday(monday));
        System.out.println("Sunday check correct.");
    }

    @Test
    public void test14_getLeaveDaysExcludingSundays() throws Exception {
        System.out.println("Test 14: getLeaveDaysExcludingSundays - Exclude Sundays");
        Date start = new SimpleDateFormat("yyyy-MM-dd").parse("2024-07-12"); // Friday
        Date end = new SimpleDateFormat("yyyy-MM-dd").parse("2024-07-15");   // Monday
        // 12 (Fri), 13 (Sat), 14 (Sun), 15 (Mon) --> Exclude 14th
        int days = DateUtil.getLeaveDaysExcludingSundays(start, end);
        assertEquals(3, days);
        System.out.println("Leave days (excluding Sundays): " + days);
    }
}
