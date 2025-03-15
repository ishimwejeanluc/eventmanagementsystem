package testcases;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.UserDao;
import modal.User;
import modal.Role;

public class SaveUserTest {

    private UserDao userDao;
    private User user;

    @Before
    public void setUp() {
        userDao = new UserDao();
        user = new User();
        user.setId(5);
        user.setName("Test User");
        user.setEmail("test@example.com");
        user.setRole( Role.GUEST);
        
    }

    @Test
    public void testSaveUser () {
        String result = userDao.saveUser (user);
        assertEquals("User saved successfully", result);
    }
}
