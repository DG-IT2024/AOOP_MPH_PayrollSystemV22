package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.Calendar;

public class DateUtil {

    // Convert Object (Date or String) to java.util.Date
    public static Date convertToDate(Object dateObj) throws ParseException {
        if (dateObj instanceof Date) {
            return (Date) dateObj;
        } else if (dateObj instanceof String) {
            String[] formats = {"MM/dd/yyyy", "yyyy-MM-dd"};
            ParseException lastException = null;
            for (String fmt : formats) {
                try {
                    return new SimpleDateFormat(fmt).parse((String) dateObj);
                } catch (ParseException e) {
                    lastException = e;
                }
            }
            throw lastException != null ? lastException
                    : new ParseException("Unparseable date: " + dateObj, 0);
        } else {
            throw new ParseException("Unparseable date: " + dateObj, 0);
        }
    }

    // Convert java.util.Date to formatted String (for display)
    public static String dateToString(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(pattern).format(date);
    }

    // Convert java.util.Date to default string "MM/dd/yyyy"
    public static String dateToDefaultString(Date date) {
        return dateToString(date, "MM/dd/yyyy");
    }

    // Convert java.util.Date to java.sql.Date
    public static java.sql.Date utilDateToSqlDate(Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

    // Convert java.sql.Date to java.util.Date (actually same in most cases, but for clarity)
    public static Date sqlDateToUtilDate(java.sql.Date sqlDate) {
        return sqlDate == null ? null : new Date(sqlDate.getTime());
    }

    // Compare two dates (ignoring time)
    public static boolean isSameDay(Date d1, Date d2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(d1).equals(fmt.format(d2));
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return dateFormat.format(date);
    }

    public static boolean isValidDateRange(String startDateStr, String endDateStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);

            if (startDate.after(endDate)) {
                JOptionPane.showMessageDialog(null,
                        "Start Date must be earlier than or equal to End Date.",
                        "Invalid Date Range",
                        JOptionPane.WARNING_MESSAGE
                );
                return false;
            }

        } catch (ParseException e) {

            return false;
        }

        return true; // ✅ Dates are valid
    }

    public static boolean isSunday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }

    public static int getLeaveDaysExcludingSundays(Date startDate, Date endDate) {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(startDate);
        end.setTime(endDate);

        int leaveDays = 0;

        // Iterate from startDate to endDate
        while (!start.after(end)) {
            if (!isSunday(start.getTime())) {
                leaveDays++;
            }
            start.add(Calendar.DATE, 1);
        }

        return leaveDays;
    }

}
