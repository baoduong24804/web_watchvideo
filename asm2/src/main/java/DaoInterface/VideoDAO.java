package DaoInterface;

import java.util.List;

import Entity.Video;

public interface VideoDAO {
	Video findByID(Integer id);

	Video findByHref(String href);

	List<Video> findAll();
	
	List<Video> findAll2();

	List<Video> findAll(int pageNumber, int pageSize);

	Video create(Video entity);

	Video update(Video entity);

	Video delete(Video entity);
	
	List<Video> getRandomVideo(int max);
	
	List<Video> findVideoByTitle(String title);
	
	List<Video> findVideoByIDorTitle(String s,int type);
	 
}
