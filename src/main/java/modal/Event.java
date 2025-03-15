package modal;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private User host;

    private String title;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date eventDate;

    private String location;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Invitation> invitations;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<Attendance> attendances;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Invitation> getInvitations() {
		return invitations;
	}

	public void setInvitations(List<Invitation> invitations) {
		this.invitations = invitations;
	}

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

    
}

