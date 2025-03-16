package testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ConnectionTest.class,
	DataInsertionTest.class,
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
    GetAllUsersTest.class,
    OtherFeaturesTest.class
})
public class AllTestsSuite {
}