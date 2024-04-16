package Storage;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.persistence.*;



@Entity
@Table(name = "user")
public class UserLike {
    @Id
    @Column(name = "user_id")
    private int userId;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "online")
    private boolean online;
    
    @Column(name = "like_date")
    private Date like_date;
    
    @Column(name = "view_date")
    private Date view_date;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	
	
	public String getLike_date() {
		String inputDate = like_date.toString();
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        try {
            Date date = inputFormat.parse(inputDate);

            SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm:ss a, dd/MM/yyyy");
            String formattedDate = outputFormat.format(date);
            return formattedDate;
            //System.out.println("Formatted Date: " + formattedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "";
	}

	public void setLike_date(Date like_date) {
		this.like_date = like_date;
	}

	public Date getView_date() {
		return view_date;
	}

	public void setView_date(Date view_date) {
		this.view_date = view_date;
	}

	public UserLike() {
		super();
	}

    
    
}

    
