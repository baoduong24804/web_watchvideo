package Service;

import java.util.List;

import DaoInterface.VideoDAO;
import Entity.User;
import Entity.Video;
import Main.main;
import DaoImplement.VideoDaoImpl;

//Lop DAO va Controller k xu li Logic ma lop Servide se xu li no!
public class VideoServiceImpl  {

	private VideoDAO dao;

	// New hàm tạo để có the goi no
	public VideoServiceImpl() {
		dao = new VideoDaoImpl();
	}
	
	
	public List<Video> getRandomVideo(int max) {
		return dao.getRandomVideo(max);
	}
	
	public Video findByID(Integer id) {
		//
		return dao.findByID(id);
	}
	


	
	public Video findByHref(String href) {
		//
		return dao.findByHref(href);
	}

	
	public List<Video> findAll() {
		//
		return dao.findAll();
	}

	
	public List<Video> findAll(int pageNumber, int pageSize) {
		//
		return dao.findAll(pageNumber, pageSize);
	}

	
	public Video create(Video entity, User user) {
		//
		Video u = new Video();
		u.setOnline(entity.getOnline());
		u.setPoster(entity.getPoster());
		u.setTitle(entity.getTitle());
		u.setUrl(entity.getUrl());
		u.setUserId(user.getUserId());
		u.setDescription(entity.getDescription());
//		entity.setViews(0);
//		entity.setShares(0);
		return dao.create(u);
	}
	
	public Video update(Video entity, User user) {
		//
		Video u = new Video();
		u.setOnline(Boolean.TRUE);
		u.setPoster(entity.getPoster());
		
		if(String.valueOf(u.getShare()) != null) {
			u.setShare(entity.getShare());
		}
	
		u.setTitle(entity.getTitle());
		u.setUrl(entity.getUrl());
		u.setUserId(user.getUserId());
		u.setDescription(entity.getDescription());
		u.setVideoId(entity.getVideoId());
		
		return dao.update(u);
	}

	
	public Video delete(String href) {
		//
		Video entity = findByHref(href);
		
		entity.setOnline(Boolean.FALSE);
		return dao.update(entity);
	}
	
	public List<Video> findAll2(){
		return dao.findAll2();
	}
	
	public List<Video> findVideoByTitle(String title){
		return dao.findVideoByTitle(title);
	}
	
	public List<Video> findVideoByIDorTitle(String s,int type){
		return dao.findVideoByIDorTitle(s, type);
	}
	
}
