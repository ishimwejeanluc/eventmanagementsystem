package testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    CheckInGuestTest.class,
    GetAttendeesByEventTest.class,
    CreateEventTest.class,
    GetEventByIdTest.class,
    GetEventsByHostTest.class,
    SendInvitationTest.class,
    GetInvitationsForGuestTest.class,
    GetInvitedGuestsByEventTest.class,
    UpdateInvitationStatusTest.class,
    SaveUserTest.class,
    GetUserByIdTest.class,
    GetAllUsersTest.class
})
public class AllTestsSuite {
}