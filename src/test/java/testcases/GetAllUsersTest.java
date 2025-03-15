package testcases;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.UserDao;
import modal.User;

import java.util.List;

public class GetAllUsersTest {

    private UserDao userDao;

    @Before
    public void setUp() {
        userDao = new UserDao();
    }

    @Test
    public void testGetAllUsers() {
        List<User> users = userDao.getAllUsers();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }
}
