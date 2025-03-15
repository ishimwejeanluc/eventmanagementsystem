package testcases;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.EventDao;
import modal.Event;

import java.util.List;

public class GetEventsByHostTest {

    private EventDao eventDao;

    @Before
    public void setUp() {
        eventDao = new EventDao();
    }

    @Test
    public void testGetEventsByHost() {
        List<Event> events = eventDao.getEventsByHost(1);
        assertNotNull(events);
        assertFalse(events.isEmpty());
    }
}