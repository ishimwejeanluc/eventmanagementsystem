package testcases;




import dao.UserDao;
import dao.EventDao;
import dao.InvitationDao;
import dao.AttendanceDao;
import modal.User;
import modal.Event;
import modal.Invitation;
import modal.InvitationStatus;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OtherFeaturesTest {
    private UserDao userDao;
    private EventDao eventDao;
    private InvitationDao invitationDao;
    private AttendanceDao attendanceDao;

    @Before
    public void setUp() {
        userDao = new UserDao();
        eventDao = new EventDao();
        invitationDao = new InvitationDao();
        attendanceDao = new AttendanceDao();
    }

    @Test
    public void test1_GetEventByTitle() {
        Event event = eventDao.getEventByTitle("Tech Conference");
        assertNotNull(event);
        assertEquals("Tech Conference", event.getTitle());
    }

    @Test
    public void test2_GetAllInvitationsForEvent() {
        List<Invitation> invitations = invitationDao.getAllInvitationsForEvent(1);
        assertNotNull(invitations);
        assertFalse(invitations.isEmpty());
    }

    @Test
    public void test3_DeleteEvent() {
        assertTrue(eventDao.deleteEvent(2)); // Assuming event with ID 2 exists
    }

    @Test
    public void test4_GetAllAttendeesForEvent() {
        List<?> attendees = attendanceDao.getAllAttendeesForEvent(1);
        assertNotNull(attendees);
        assertFalse(attendees.isEmpty());
    }

    

   

    @Test
    public void test7_GetUserByEmail() {
        User user = userDao.getUserByEmail("alice@example.com");
        assertNotNull(user);
        assertEquals("alice@example.com", user.getEmail());
    }

    @Test
    public void test8_CheckIfHostHasEvents() {
        assertTrue(eventDao.hostHasEvents(1)); // Assuming host 1 has events
    }

   

    @Test
    public void test10_GetTotalAttendanceForEvent() {
        Long count = attendanceDao.getTotalAttendanceForEvent(1);
        assertNotNull(count);
        assertTrue(count > 0);
    }

    @Test
    public void test11_VerifyIfEventExists() {
        assertTrue(eventDao.eventExists(1)); 
    }

    @Test
    public void test12_VerifyIfUserExists() {
        assertTrue(userDao.userExists(1)); 
    }

   
}

