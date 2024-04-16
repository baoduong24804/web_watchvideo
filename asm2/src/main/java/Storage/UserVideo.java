package Storage;

import java.text.SimpleDateFormat;
import java.util.Date;

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

public class UserVideo {

	    @Id
	    @Column(name = "video_id")
	    private int videoId;
	    
	    @Column(name = "title")
	    private String title;
	    
	    @Column(name = "url")
	    private String url;
	    
	    @Column(name = "mes")
	    private String mes;
	    
	    @Column(name = "share")
	    private int share;
	    
	    @Column(name = "like_date")
	    private Date like_date;
	    
	    @Column(name = "view_date")
	    private Date view_date;
	    
	    // Các getter và setter khác
	

	public Integer getVideoId() {
		return videoId;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
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

	public String getView_date() {
		String inputDate = view_date.toString();
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

	public void setView_date(Date view_date) {
		this.view_date = view_date;
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

	public Integer getShare() {
		return share;
	}

	public void setShare(Integer share) {
		this.share = share;
	}

	public UserVideo() {
		super();
	}
	
	
	
}
