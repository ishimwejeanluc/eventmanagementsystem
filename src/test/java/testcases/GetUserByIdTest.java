package testcases;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.UserDao;
import modal.User;

public class GetUserByIdTest {

    private UserDao userDao;

    @Before
    public void setUp() {
        userDao = new UserDao();
    }

    @Test
    public void testGetUserById() {
        User fetchedUser  = userDao.getUserById(1);
        assertNotNull(fetchedUser );
        assertEquals("Alice Johnson", fetchedUser .getName());
    }
}
