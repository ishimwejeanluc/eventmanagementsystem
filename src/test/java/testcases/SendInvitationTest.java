package testcases;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.InvitationDao;
import modal.Invitation;
import modal.InvitationStatus;
import modal.Event;
import modal.User;

public class SendInvitationTest {

    private InvitationDao invitationDao;
    private Invitation invitation;

    @Before
    public void setUp() {
        invitationDao = new InvitationDao();
        invitation = new Invitation();
        Event event = new Event();
        event.setId(1); // Tech Conference
        User guest = new User();
        guest.setId(2); // Bob Smith
        invitation.setId(5);
        invitation.setEvent(event);
        invitation.setGuest(guest);
        invitation.setStatus(InvitationStatus.PENDING);
    }

    @Test
    public void testSendInvitation() {
        String result = invitationDao.sendInvitation(invitation);
        assertEquals("Invitation sent successfully", result);
    }
}
