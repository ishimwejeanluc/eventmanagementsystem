package modal;

import jakarta.persistence.*;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private User guest;

    private boolean checkedIn;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date checkInTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getGuest() {
		return guest;
	}

	public void setGuest(User guest) {
		this.guest = guest;
	}

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public java.util.Date getCheckInTime() {
		return checkInTime;
	}

	public void setCheckInTime(java.util.Date checkInTime) {
		this.checkInTime = checkInTime;
	}

    
    
}

