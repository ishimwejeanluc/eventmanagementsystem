package modal;

import jakarta.persistence.*;

@Entity
@Table(name = "invitations")
public class Invitation {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private User guest;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private InvitationStatus status;

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

	public InvitationStatus getStatus() {
		return status;
	}

	public void setStatus(InvitationStatus status) {
		this.status = status;
	}  
    
    
}

