package DaoImplement;

import java.util.List;

import DaoInterface.AbstractDao;
import DaoInterface.HistoryDAO;
import Entity.History;

public class HistoryDaoImpl extends AbstractDao<History> implements HistoryDAO {

	@Override
	public List<History> findByUser(String username) {
		// 
		String sql = "SELECT o FROM History o WHERE o.user.username = ?0 AND o.video.isActive = 1"
				+ " ORDER BY o.viewedDate DESC";
		return super.findMany(History.class,sql, username);
	}

	@Override
	public List<History> findByUserAndIsLiked(String username) {
		// 
		String sql = "SELECT o FROM History o WHERE o.user.username = ?0 AND o.isLike = 1"
				+ " AND o.video.online = 1"
				+ " ORDER BY o.viewDate DESC";
		return super.findMany(History.class,sql, username);
	}

	@Override
	public History findByUserIdAndVideoId(Integer userId, Integer videoId) {
		// 
		String sql = "SELECT o FROM History o  WHERE o.user.userId = ?0 AND o.video.videoId = ?1 and o.video.online = 1" ;
		return super.findOne(History.class, sql, userId,videoId);
	}
}
