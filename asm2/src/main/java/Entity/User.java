package Entity;

import java.io.Serializable;
import javax.persistence.*;

import Constant.NamedStored;
import Entity.User;

import java.util.List;

/**
 * The persistent class for the User database table.
 * 
 */
@Entity
@Table(name = "`User`")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;

	private String email;

	private boolean online;

	private String password;

	private boolean role;

	private String username;

	//bi-directional many-to-one association to History
	@OneToMany(mappedBy="user")
	private List<History> histories;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getOnline() {
		return this.online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getRole() {
		return this.role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<History> getHistories() {
		return this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public History addHistory(History history) {
		getHistories().add(history);
		history.setUser(this);

		return history;
	}

	public History removeHistory(History history) {
		getHistories().remove(history);
		history.setUser(null);

		return history;
	}

}