package testcases;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.EventDao;
import modal.Event;

public class GetEventByIdTest {

    private EventDao eventDao;

    @Before
    public void setUp() {
        eventDao = new EventDao();
    }

    @Test
    public void testGetEventById() {
        Event fetchedEvent = eventDao.getEventById(1);
        assertNotNull(fetchedEvent);
        assertEquals("Tech Conference", fetchedEvent.getTitle());
    }
}