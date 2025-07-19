import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.util.List;

import dao.LoginDAO;
import model.Login;
import model.Password;
import model.Role;
import util.DBConnect;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginDAOTest {

    private static Connection conn;
    private LoginDAO loginDAO;

    @BeforeAll
    public static void setupDB() throws Exception {
        conn = DBConnect.getConnection();
        System.out.println("Database connection established for LoginDAOTest.");
    }

    @AfterAll
    public static void teardown() throws Exception {
        if (conn != null && !conn.isClosed()) {
            conn.close();
            System.out.println("Database connection closed after LoginDAOTest.");
        }
    }

    @BeforeEach
    public void setUp() {
        loginDAO = new LoginDAO(conn);
    }

    @Test
    public void test1_getLoginByUsername() throws Exception {
        System.out.println("Test 1: getLoginByUsername - Retrieve login by username");
        String username = "admin"; // Replace with a username from your DB
        Login login = loginDAO.getLoginByUsername(username);
        assertNotNull(login, "Login should not be null for an existing username");
        assertEquals(username, login.getUsername());
        System.out.println("Retrieved Login: " + login.getUsername());
    }

    @Test
    public void test2_getPasswordByLoginId() throws Exception {
        System.out.println("Test 2: getPasswordByLoginId - Retrieve password by login id");
        String username = "admin"; // Replace with a username from your DB
        Login login = loginDAO.getLoginByUsername(username);
        assertNotNull(login, "Login should exist");
        Password pw = loginDAO.getPasswordByLoginId(login.getLoginId());
        assertNotNull(pw, "Password should not be null for valid login_id");
        System.out.println("Password (salted hash): " + pw.getPasswordSaltHash());
    }

    @Test
    public void test3_getRolesByLoginId() throws Exception {
        System.out.println("Test 3: getRolesByLoginId - Retrieve roles by login id");
        String username = "admin"; // Replace with a username that has roles
        Login login = loginDAO.getLoginByUsername(username);
        assertNotNull(login, "Login should exist");
        List<Role> roles = loginDAO.getRolesByLoginId(login.getLoginId());
        assertNotNull(roles, "Roles should not be null");
        assertTrue(roles.size() > 0, "User should have at least one role");
        for (Role role : roles) {
            System.out.println("Role: " + role.getRoleName());
        }
    }

    @Test
    public void test4_incrementLoginAttempts() throws Exception {
        System.out.println("Test 4: incrementLoginAttempts - Increment login attempts for a user");
        String username = "admin"; // Use a real username
        Login loginBefore = loginDAO.getLoginByUsername(username);
        int before = loginBefore.getNoAttempts();
        loginDAO.incrementLoginAttempts(username);
        Login loginAfter = loginDAO.getLoginByUsername(username);
        int after = loginAfter.getNoAttempts();
        assertEquals(before + 1, after, "Login attempts should increment by 1");
        System.out.println("No_attempt before: " + before + ", after: " + after);
    }

    @Test
    public void test5_resetLoginAttempts() throws Exception {
        System.out.println("Test 5: resetLoginAttempts - Reset login attempts for a user");
        String username = "admin"; // Use a real username
        loginDAO.incrementLoginAttempts(username); // Increment first to ensure not 0
        loginDAO.resetLoginAttempts(username);
        Login loginAfter = loginDAO.getLoginByUsername(username);
        assertEquals(0, loginAfter.getNoAttempts(), "Login attempts should be reset to 0");
        System.out.println("No_attempt reset to: " + loginAfter.getNoAttempts());
    }

    @Test
    public void test6_updateLastLogin() throws Exception {
        System.out.println("Test 6: updateLastLogin - Update last login timestamp");
        String username = "admin"; // Use a real username
        loginDAO.updateLastLogin(username);
        Login login = loginDAO.getLoginByUsername(username);
        assertNotNull(login.getLastLogin(), "Last login timestamp should not be null after update");
        System.out.println("Updated last_login: " + login.getLastLogin());
    }
}
