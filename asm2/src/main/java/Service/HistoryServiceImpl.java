package Service;

import java.sql.Timestamp;
import java.util.List;

import DaoImplement.HistoryDaoImpl;
import DaoInterface.HistoryDAO;
import Entity.History;
import Entity.User;
import Entity.Video;

public class HistoryServiceImpl {
	private HistoryDAO dao;
	
	private VideoServiceImpl videoService = new VideoServiceImpl();
	
	public HistoryServiceImpl() {
		dao = new HistoryDaoImpl();
	}

	public List<History> findByUser(String username) {
		//
		return dao.findByUser(username);
	}

	
	public List<History> findByUserAndIsLiked(String username) {
		// 
		return dao.findByUserAndIsLiked(username);
	}

	
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		// 
		return dao.findByUserIdAndVideoId(userId, videoId);
	}

	
	public History create(User user, Video video) {
		// 
		History existHistory = findByUserIdAndVideoId(user.getUserId(), video.getVideoId());
		// neu user chua xem video
		if (existHistory == null) {
			existHistory = new History();
			
			existHistory.setUser(user);
			existHistory.setVideo(video);
			existHistory.setViewDate(new Timestamp(System.currentTimeMillis()));
			existHistory.setIsLike(false);
			return dao.create(existHistory);
			
		}
		return existHistory;
	}

	
	public boolean updateLikeOrUnlike(User user, Video video) {
		// 
		
		History existHistory = findByUserIdAndVideoId(user.getUserId(), video.getVideoId());
		
		
		if(existHistory == null) {
			//existHistory.setId(existHistory.getId());
			
		}else {
			
			if(existHistory.getIsLike() == Boolean.FALSE) {
				existHistory.setId(existHistory.getId());
				existHistory.setIsLike(Boolean.TRUE);
				existHistory.setLikeDate(new Timestamp(System.currentTimeMillis()));
				
			}else {
				existHistory.setId(existHistory.getId());
				existHistory.setIsLike(Boolean.FALSE);
				existHistory.setLikeDate(null);
				
			}
		}
		 
		 
		History updateHistory = dao.update(existHistory);
		return updateHistory != null ? true : false ;
	}
	

}
