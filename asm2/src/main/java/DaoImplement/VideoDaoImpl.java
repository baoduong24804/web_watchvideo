package DaoImplement;

import java.util.List;

import DaoInterface.AbstractDao;
import DaoInterface.VideoDAO;
import Entity.Video;

public class VideoDaoImpl extends AbstractDao<Video> implements VideoDAO{

	@Override
	public Video findByID(Integer id) {
		// 
		return super.findById(Video.class, id);
	}

	
	@Override
	public Video findByHref(String href) {
		// 
		String sql = "SELECT o FROM Video o WHERE o.url = ?0";
		return super.findOne(Video.class, sql, href);
	}
	

	@Override
	public List<Video> findAll() {
		// 
		return super.findAll(Video.class, true);
	}

	@Override
	public List<Video> findAll(int pageNumber, int pageSize) {
		// Write Comment
		return super.findAll(Video.class, true, pageNumber, pageSize);
	}


	@Override
	public List<Video> getRandomVideo(int max) {
		// TODO Auto-generated method stub
		
		return super.getRandomVideo(max);
	}


	@Override
	public List<Video> findAll2() {
		// TODO Auto-generated method stub
		return super.findAll(Video.class, false);
	}

	@Override
	public List<Video> findVideoByTitle(String title){
		return super.findVideoByTitle(title);
	}

	@Override
	public List<Video> findVideoByIDorTitle(String s,int type){
		return super.findVideoByIDorTitle(s, type);
	}

}
