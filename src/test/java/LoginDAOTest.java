
import dao.LoginDAO;
import model.Login;
import model.Password;
import model.Role;
import org.junit.jupiter.api.*;
import util.DBConnect;

import java.sql.Connection;
import java.util.List;

public class LoginDAOTest {

    private static Connection conn;
    private LoginDAO loginDAO;
    private final String username = "manuel_garcia";

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for LoginDAOTest.");
    }

    @BeforeEach
    public void initDAO() {
        loginDAO = new LoginDAO(conn);
    }

    @Test
    public void testCase1_getLoginByUsername_validUsername() throws Exception {
        Login login = loginDAO.getLoginByUsername(username);
        System.out.println("Test Case 1 - getLoginByUsername with valid username: " + (login != null ? login.getUsername() : null));
        Assertions.assertNotNull(login);
    }

    @Test
    public void testCase2_getPasswordByLoginId_validLoginId() throws Exception {
        Login login = loginDAO.getLoginByUsername(username);
        Password pw = loginDAO.getPasswordByLoginId(login.getLoginId());
        System.out.println("Test Case 2 - getPasswordByLoginId with valid loginId: " + (pw != null ? pw.getPasswordSaltHash() : null));
        Assertions.assertNotNull(pw);
    }

    @Test
    public void testCase3_getRolesByLoginId_validLoginId() throws Exception {
        Login login = loginDAO.getLoginByUsername(username);
        List<Role> roles = loginDAO.getRolesByLoginId(login.getLoginId());
        System.out.println("Test Case 3 - getRolesByLoginId: " + (!roles.isEmpty() ? roles.get(0).getRoleName() : "No roles found"));
        Assertions.assertFalse(roles.isEmpty());
    }

    @Test
    public void testCase4_incrementAndResetLoginAttempts() throws Exception {
        loginDAO.incrementLoginAttempts(username);
        Login loginAfterIncrement = loginDAO.getLoginByUsername(username);
        System.out.println("Test Case 4 - incrementLoginAttempts: Attempts = " + loginAfterIncrement.getNoAttempts());
        Assertions.assertTrue(loginAfterIncrement.getNoAttempts() > 0);

        loginDAO.resetLoginAttempts(username);
        Login loginAfterReset = loginDAO.getLoginByUsername(username);
        System.out.println("Test Case 4 - resetLoginAttempts: Attempts after reset = " + loginAfterReset.getNoAttempts());
        Assertions.assertEquals(0, loginAfterReset.getNoAttempts());
    }

    @Test
    public void testCase5_updateLastLogin() throws Exception {
        loginDAO.updateLastLogin(username);
        Login login = loginDAO.getLoginByUsername(username);
        System.out.println("Test Case 5 - updateLastLogin: Last login timestamp = " + login.getLastLogin());
        Assertions.assertNotNull(login.getLastLogin());
    }
}
