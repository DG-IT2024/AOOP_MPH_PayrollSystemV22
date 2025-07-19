import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import util.PayrollUtil;
import model.PayrollSummary;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.util.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PayrollUtilTest {

    private List<PayrollSummary> summaries;

    @BeforeEach
    public void setUp() {
        summaries = new ArrayList<>();
        PayrollSummary ps = new PayrollSummary(
            Date.valueOf("2024-07-01"),
            Date.valueOf("2024-07-15"),
            10001,
            "Garcia, Manuel",
            "Chief Executive Officer",
            "Executive",
            90000.0,
            "44-4506057-3",
            1125.0,
            "820126853951",
            900.0,
            "442-605-657-000",
            100.0,
            "691295330870",
            40833.33,
            85000.0
        );
        summaries.add(ps);
    }

    @Test
    public void test1_loadToJTable_conversion() {
        System.out.println("Test 1: loadToJTable - Convert payroll summaries to table model");
        DefaultTableModel model = PayrollUtil.loadToJTable(summaries);
        assertEquals(1, model.getRowCount());
        assertEquals(16, model.getColumnCount());
        assertEquals("Garcia, Manuel", model.getValueAt(0, 3));
        assertEquals(90000.0, model.getValueAt(0, 6));
        System.out.println("Table row: " + model.getRowCount() + ", columns: " + model.getColumnCount());
    }

    @Test
    public void test2_calculateSSSContribution_thresholds() {
        System.out.println("Test 2: calculateSSSContribution - SSS brackets (min, max, mid)");
        double minSalary = 3000;
        double midSalary = 18000;
        double maxSalary = 50000;
        double minSSS = PayrollUtil.calculateSSSContribution(minSalary);
        double midSSS = PayrollUtil.calculateSSSContribution(midSalary);
        double maxSSS = PayrollUtil.calculateSSSContribution(maxSalary);
        assertTrue(minSSS > 0 && midSSS > minSSS && maxSSS == 1125.0);
        System.out.println("Min: " + minSSS + ", Mid: " + midSSS + ", Max: " + maxSSS);
    }

    @Test
    public void test3_calculatePagIbigContribution() {
        System.out.println("Test 3: calculatePagIbigContribution - Pag-IBIG rules");
        double salary1 = 1200;    // 1% bracket
        double salary2 = 1600;    // 2% bracket, below max
        double salary3 = 100000;  // should be capped at 100
        assertEquals(12.0, PayrollUtil.calculatePagIbigContribution(salary1));
        assertEquals(32.0, PayrollUtil.calculatePagIbigContribution(salary2));
        assertEquals(100.0, PayrollUtil.calculatePagIbigContribution(salary3));
        System.out.println("Pag-IBIG: 1%=" + PayrollUtil.calculatePagIbigContribution(salary1) +
            ", 2%=" + PayrollUtil.calculatePagIbigContribution(salary2) +
            ", capped=" + PayrollUtil.calculatePagIbigContribution(salary3));
    }

    @Test
    public void test4_calculatePhilHealthContribution() {
        System.out.println("Test 4: calculatePhilHealthContribution - Clamped values");
        double low = 4000;    // Below min
        double mid = 40000;   // Within range
        double high = 100000; // Should be capped at max
        assertEquals(150.0, PayrollUtil.calculatePhilHealthContribution(low));  // clamped to min
        assertTrue(PayrollUtil.calculatePhilHealthContribution(mid) > 150.0);
        assertEquals(900.0, PayrollUtil.calculatePhilHealthContribution(high));  // clamped to max
        System.out.println("PhilHealth: min=" + PayrollUtil.calculatePhilHealthContribution(low) +
            ", mid=" + PayrollUtil.calculatePhilHealthContribution(mid) +
            ", max=" + PayrollUtil.calculatePhilHealthContribution(high));
    }

    @Test
    public void test5_calculateTotalBenefitsDeductions() {
        System.out.println("Test 5: calculateTotalBenefitsDeductions");
        double salary = 30000;
        double total = PayrollUtil.calculateTotalBenefitsDeductions(salary);
        assertTrue(total > 0);
        System.out.println("Total benefits deductions for salary " + salary + ": " + total);
    }

    @Test
    public void test6_calculateWithholdingTax_brackets() {
        System.out.println("Test 6: calculateWithholdingTax - Withholding tax by salary bracket");
        double salary1 = 18000;   // Below 20,833, should be 0
        double salary2 = 25000;   // 0.2 bracket
        double salary3 = 40000;   // 0.25 bracket
        double salary4 = 100000;  // 0.3+ brackets
        assertEquals(0, PayrollUtil.calculateWithholdingTax(salary1), 0.01);
        assertTrue(PayrollUtil.calculateWithholdingTax(salary2) > 0);
        assertTrue(PayrollUtil.calculateWithholdingTax(salary3) > PayrollUtil.calculateWithholdingTax(salary2));
        assertTrue(PayrollUtil.calculateWithholdingTax(salary4) > PayrollUtil.calculateWithholdingTax(salary3));
        System.out.println("WHTax: 18k=" + PayrollUtil.calculateWithholdingTax(salary1) +
            ", 25k=" + PayrollUtil.calculateWithholdingTax(salary2) +
            ", 40k=" + PayrollUtil.calculateWithholdingTax(salary3) +
            ", 100k=" + PayrollUtil.calculateWithholdingTax(salary4));
    }

    @Test
    public void test7_calculateAll_zeroSalary() {
        System.out.println("Test 7: Zero salary - should return 0 for all");
        double salary = 0;
        assertEquals(0, PayrollUtil.calculateSSSContribution(salary), 0.01);
        assertEquals(0, PayrollUtil.calculatePagIbigContribution(salary), 0.01);
        assertEquals(150, PayrollUtil.calculatePhilHealthContribution(salary), 0.01);
        assertEquals(150, PayrollUtil.calculateTotalBenefitsDeductions(salary), 0.01);
        assertEquals(0, PayrollUtil.calculateWithholdingTax(salary), 0.01);
        System.out.println("All contributions/tax for 0 salary tested.");
    }
}
