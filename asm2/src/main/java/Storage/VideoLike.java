package Storage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import Constant.NamedStored;


@Entity
@Table(name = "video")

public class VideoLike {

	    @Id
	    @Column(name = "video_id")
	    private int videoId;
	    
	    @Column(name = "title")
	    private String title;
	    
	    @Column(name = "url")
	    private String url;
	    
	    @Column(name = "totalLike")
	    private int totalLike;
	    
	    @Column(name = "share")
	    private int share;
	    
	    // Các getter và setter khác
	

	public Integer getVideoId() {
		return videoId;
	}

	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getTotalLike() {
		return totalLike;
	}

	public void setTotalLike(Integer totalLike) {
		this.totalLike = totalLike;
	}

	public Integer getShare() {
		return share;
	}

	public void setShare(Integer share) {
		this.share = share;
	}

	public VideoLike() {
		super();
	}
	
	
	
}
