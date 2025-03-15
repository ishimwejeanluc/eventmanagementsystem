package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dao.InvitationDao;
import modal.InvitationStatus;

public class UpdateInvitationStatusTest {

    private InvitationDao invitationDao;

    @Before
    public void setUp() {
        invitationDao = new InvitationDao();
    }

    @Test
    public void testUpdateInvitationStatus() {
        String result = invitationDao.updateInvitationStatus(1, InvitationStatus.ACCEPTED);
        assertEquals("Invitation status updated", result);
    }
}
