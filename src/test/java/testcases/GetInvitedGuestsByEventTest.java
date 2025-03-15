package testcases;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.InvitationDao;
import modal.Invitation;

import java.util.List;

public class GetInvitedGuestsByEventTest {

    private InvitationDao invitationDao;

    @Before
    public void setUp() {
        invitationDao = new InvitationDao();
    }

    @Test
    public void testGetInvitedGuestsByEvent() {
        List<Invitation> invitedGuests = invitationDao.getInvitedGuestsByEvent(1);
        assertNotNull(invitedGuests);
        assertFalse(invitedGuests.isEmpty());
    }
}
