package testcases;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.EventDao;
import modal.Event;
import modal.User;

public class CreateEventTest {

    private EventDao eventDao;
    private Event event;

    @Before
    public void setUp() {
        eventDao = new EventDao();
        event = new Event();
        User host = new User();
        host.setId(1); 
        event.setId(5);
        event.setHost(host);
        event.setTitle("New Event");
        event.setDescription("Description of new event");
    }

    @Test
    public void testCreateEvent() {
        String result = eventDao.createEvent(event);
        assertEquals("Event created successfully", result);
    }
}