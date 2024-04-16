package DaoInterface;

import java.util.List;

import Storage.UserHistory;
import Storage.UserLike;
import Storage.UserVideo;
//import Entitys.User;
import Storage.VideoLike;

public interface StatsDAO {
	
	List<VideoLike> findVideoLikedInfo ();
	List<UserLike> getFavouries_info (String href);
	
	List<UserLike> getUserLikeById (int id);
	
	List<VideoLike> getAllVideoLiked ();
	
	List<UserVideo> getAllUserVideo (int id);
	
	List<UserHistory> getAllUserHistory (int id);
}
