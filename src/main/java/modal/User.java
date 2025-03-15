package modal;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    private int id;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;  

    // Getters and Setters
    public User() {}

    public User(String name, String email, Role role) {
        this.name = name;
        this.email = email;
        this.role = role;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
    
    
}

