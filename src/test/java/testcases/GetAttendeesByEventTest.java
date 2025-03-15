package testcases;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.AttendanceDao;
import modal.Attendance;

import java.util.List;

public class GetAttendeesByEventTest {

    private AttendanceDao attendanceDao;

    @Before
    public void setUp() {
        attendanceDao = new AttendanceDao();
    }

    @Test
    public void testGetAttendeesByEvent() {
        List<Attendance> attendees = attendanceDao.getAttendeesByEvent(1);
        assertNotNull(attendees);
        assertFalse(attendees.isEmpty());
    }
}