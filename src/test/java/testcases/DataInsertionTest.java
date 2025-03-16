package testcases;

import dao.UserDao;
import dao.EventDao;
import dao.InvitationDao;
import dao.AttendanceDao;
import modal.User;
import modal.Event;
import modal.Invitation;
import modal.Attendance;
import modal.Role;
import modal.InvitationStatus;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import java.util.Date;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataInsertionTest {
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
    public void test1_InsertUsers() {
        User user1 = new User(1,"Alice Johnson", "alice@example.com", Role.HOST);
        User user2 = new User(2,"Bob Smith", "bob@example.com", Role.GUEST);
        User user3 = new User(3,"Charlie Brown", "charlie@example.com", Role.GUEST);

        assertEquals("User saved successfully", userDao.saveUser(user1));
        assertEquals("User saved successfully", userDao.saveUser(user2));
        assertEquals("User saved successfully", userDao.saveUser(user3));
    }

    @Test
    public void test2_InsertEvents() {
        User host = userDao.getUserById(1);
        assertNotNull(host);

        Event event1 = new Event();
        event1.setId(1);
        event1.setTitle("Tech Conference");
        event1.setDescription("Annual Tech Conference");
        event1.setHost(host);
        event1.setEventDate(new Date());
        event1.setLocation("Convention Center");

        Event event2 = new Event();
        event2.setId(2);
        event2.setTitle("Networking Meetup");
        event2.setDescription("Professional Networking Event");
        event2.setHost(host);
        event2.setEventDate(new Date());
        event2.setLocation("City Hall");

        assertEquals("Event created successfully", eventDao.createEvent(event1));
        assertEquals("Event created successfully", eventDao.createEvent(event2));
    }

    @Test
    public void test3_InsertInvitations() {
        Event event = eventDao.getEventById(1);
        assertNotNull(event);

        User guest1 = userDao.getUserById(2);
        User guest2 = userDao.getUserById(3);
        assertNotNull(guest1);
        assertNotNull(guest2);

        Invitation invitation1 = new Invitation();
        invitation1.setId(1);
        invitation1.setEvent(event);
        invitation1.setGuest(guest1);
        invitation1.setStatus(InvitationStatus.PENDING);

        Invitation invitation2 = new Invitation();
        invitation2.setId(2);
        invitation2.setEvent(event);
        invitation2.setGuest(guest2);
        invitation2.setStatus(InvitationStatus.ACCEPTED);

        assertEquals("Invitation sent successfully", invitationDao.sendInvitation(invitation1));
        assertEquals("Invitation sent successfully", invitationDao.sendInvitation(invitation2));
    }

    @Test
    public void test4_InsertAttendance() {
        Event event = eventDao.getEventById(1);
        assertNotNull(event);

        User guest = userDao.getUserById(3);
        assertNotNull(guest);

        Attendance attendance1 = new Attendance();
        attendance1.setId(1);
        attendance1.setEvent(event);
        attendance1.setGuest(guest);
        attendance1.setCheckedIn(true);
        attendance1.setCheckInTime(new Date());

        assertEquals("Attendance recorded successfully", attendanceDao.saveAttendance(attendance1));
    }
}

