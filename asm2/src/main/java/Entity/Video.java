package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Video database table.
 * 
 */
@Entity
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="video_id")
	private int videoId;

	@Lob
	private String description;

	private boolean online;

	private String poster;

	private int share;

	private String title;

	private String url;

	@Column(name="user_id")
	private int userId;

	//bi-directional many-to-one association to History
	@OneToMany(mappedBy="video")
	private List<History> histories;

	public Video() {
	}

	public int getVideoId() {
		return this.videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getOnline() {
		return this.online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getPoster() {
		return this.poster.trim();
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getShare() {
		return this.share;
	}

	public void setShare(int share) {
		this.share = share;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<History> getHistories() {
		return this.histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public History addHistory(History history) {
		getHistories().add(history);
		history.setVideo(this);

		return history;
	}

	public History removeHistory(History history) {
		getHistories().remove(history);
		history.setVideo(null);

		return history;
	}

}