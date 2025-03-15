package testcases;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.AttendanceDao;
import modal.Attendance;
import modal.Event;
import modal.User;

public class CheckInGuestTest {

    private AttendanceDao attendanceDao;
    private Attendance attendance;

    @Before
    public void setUp() {
        attendanceDao = new AttendanceDao();
        attendance = new Attendance();
        Event event = new Event();
        event.setId(1); // Tech Conference
        User guest = new User();
        guest.setId(2); // Bob Smith
        attendance.setId(5);
        attendance.setEvent(event);
        attendance.setGuest(guest);
        attendance.setCheckedIn(true);
    }

    @Test
    public void testCheckInGuest() {
        String result = attendanceDao.checkInGuest(attendance);
        assertEquals("Guest checked in successfully", result);
    }
}