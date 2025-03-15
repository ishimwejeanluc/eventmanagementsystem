package testcases;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import dao.InvitationDao;
import modal.Invitation;

import java.util.List;

public class GetInvitationsForGuestTest {

    private InvitationDao invitationDao;

    @Before
    public void setUp() {
        invitationDao = new InvitationDao();
    }

    @Test
    public void testGetInvitationsForGuest() {
        List<Invitation> invitations = invitationDao.getInvitationsForGuest(2);
        assertNotNull(invitations);
        assertFalse(invitations.isEmpty());
    }
}