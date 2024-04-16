package Service;

import Storage.UserLike;
import Storage.VideoLike;

import java.util.List;

import DaoInterface.StatsDAO;
import DaoImplement.StatsDAOImpl;

public class StatsServiceImpl {

	private StatsDAO statsDAO;

	public StatsServiceImpl() {
		statsDAO = new StatsDAOImpl();
	}
	
	public List<Storage.UserVideo> getAllUserVideo(int id){
		return statsDAO.getAllUserVideo(id);
	}
	
	public List<VideoLike> findVideoLikedInfo() {
		//Goi ham Dao tao de su dung

		return statsDAO.findVideoLikedInfo();
	}

	
	public List<UserLike> getFavouries_info(String href) {
		//Goi ham Dao tao de su dung

		return statsDAO.getFavouries_info(href);
	}
	
	public List<Storage.UserLike> getUserLikeById(int id) {
		return statsDAO.getUserLikeById(id);
	}
	
	public List<Storage.VideoLike> getAllVideoLike(){
		return statsDAO.getAllVideoLiked();
	}
	
	public List<Storage.UserHistory> getAllUserHistory(int id){
		return statsDAO.getAllUserHistory(id);
	}
}
