package DaoImplement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.StoredProcedureQuery;

import Constant.NamedStored;
import DaoInterface.AbstractDao;
import DaoInterface.StatsDAO;
import Entity.Video;
import Storage.UserHistory;
import Storage.UserLike;
import Storage.UserVideo;
import Storage.VideoLike;

public class StatsDAOImpl extends AbstractDao<Object []> implements StatsDAO{

	@Override
	public List<VideoLike> findVideoLikedInfo() {
		// Viet cau query
		String sql = "select v.video_id,v.title,v.url, sum(cast(h.is_like as int)) as totalLike \n"
				+ "from video v left join history h on h.video_id = v.video_id\n"
				+ "where v.online = 1\n"
				+ "group by v.video_id,v.title,v.url\n"
				+ "order by sum(cast(h.is_like as int)) desc";
		List<Object[]> objects = super.findManyByNativeQuerry(sql);
		List<VideoLike> result = new ArrayList<>();
		// Duyet list objects
		objects.forEach(object ->{
			VideoLike videolikedInfo = setDataVideoLikedInfor(object);
			result.add(videolikedInfo);
		});
		return result;
	}
	
	@Override
	public List<UserLike> getFavouries_info(String href) {
		StoredProcedureQuery storedProcedure = entityManager.createNamedStoredProcedureQuery("sp_selectUsersLikedVideoByHref");
        storedProcedure.setParameter("videoHref", href);

        List<UserLike> resultList = storedProcedure.getResultList();
        if(resultList != null) {
        	return resultList;
        }else {
        	return null;
        }
	}
	
	public List<Storage.UserLike> getUsersLike(int id){
		return super.getUserLiked(id);
	}
	
	private VideoLike setDataVideoLikedInfor(Object[] object) {
		VideoLike videolikedInfo = new VideoLike();
		//Mapping theo từng field Object 
		videolikedInfo.setVideoId((Integer)object[0]);
		videolikedInfo.setTitle((String)object[1]);
		videolikedInfo.setUrl((String)object[2]);
		videolikedInfo.setTotalLike(object[3] == null ? 0 : (Integer)object[3]);
		return videolikedInfo;
	}

	@Override
	public List<UserLike> getUserLikeById(int id) {
		// TODO Auto-generated method stub
		return super.getUserLiked(id);
	}

	@Override
	public List<Storage.VideoLike> getAllVideoLiked() {
		return super.getVideoLiked();
		
	}

	@Override
	public List<UserVideo> getAllUserVideo(int id) {
		// TODO Auto-generated method stub
		return super.getAllUserVideo(id);
	}

	@Override
	public List<UserHistory> getAllUserHistory(int id) {
		// TODO Auto-generated method stub
		return super.getAllUserHistory(id);
	}
		
}
