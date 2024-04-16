package DaoInterface;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import Constant.NamedStored;
import Entity.User;
import Entity.Video;
import Utils.JPAUtils;

public class AbstractDao<T> {
	public static EntityManager entityManager = null;
	static {
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = JPAUtils.getEntityManager();
		}

	}
	
	public List<Video> findVideoByIDorTitle(String s,int type) {
		String entityName = Video.class.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");

		//sql.append(" WHERE o.online = 1");
		if(type == 0) {
			sql.append(" WHERE o.videoId LIKE '%"+s+"%'");
		}
		if(type == 1) {
			sql.append(" WHERE o.title LIKE '%"+s+"%'");
		}
		
		
		TypedQuery<Video> query = entityManager.createQuery(sql.toString(), Video.class);
		return query.getResultList();
	}
	
	public List<User> findUserByIdorEmail(String s,int type) {
		String entityName = User.class.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");

		//sql.append(" WHERE o.online = 1");
		if(type == 0) {
			sql.append(" WHERE o.userId LIKE '%"+s+"%'");
		}
		if(type == 1) {
			sql.append(" WHERE o.email LIKE '%"+s+"%'");
		}
		
		
		TypedQuery<User> query = entityManager.createQuery(sql.toString(), User.class);
		return query.getResultList();
	}

	public List<Video> findVideoByTitle(String title) {
		String entityName = Video.class.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");

		sql.append(" WHERE o.online = 1");

		sql.append(" AND o.title LIKE '%"+title+"%'");
		TypedQuery<Video> query = entityManager.createQuery(sql.toString(), Video.class);
		return query.getResultList();
	}

	public List<Storage.VideoLike> getVideoLiked() {
		entityManager = JPAUtils.getEntityManager();
		List<Storage.VideoLike> videos = null;

		try {
			entityManager.getTransaction().begin();
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery(NamedStored.GET_VIDEO_LIKED,
					Storage.VideoLike.class);
			// query.registerStoredProcedureParameter("IdVideo", Integer.class,
			// ParameterMode.IN);
			// query.setParameter("IdVideo", id);

			//query.execute();

			videos = query.getResultList();

			entityManager.getTransaction().commit();
			// System.out.println("Added Success!!");
			return videos;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			// System.out.println("Can't add entity!!");
			throw new RuntimeException(e);
		}

	}

	public List<Storage.UserVideo> getAllUserVideo(int id) {
		entityManager = JPAUtils.getEntityManager();
		List<Storage.UserVideo> videos = null;

		try {
			entityManager.getTransaction().begin();
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery(NamedStored.GET_USER_VIDEO,
					Storage.UserVideo.class);
			query.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
			query.setParameter("id", id);
			// query.registerStoredProcedureParameter("IdVideo", Integer.class,
			// ParameterMode.IN);
			// query.setParameter("IdVideo", id);

			//query.execute();

			videos = query.getResultList();

			entityManager.getTransaction().commit();
			// System.out.println("Added Success!!");
			return videos;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			// System.out.println("Can't add entity!!");
			throw new RuntimeException(e);
		}

	}

	public List<Storage.UserHistory> getAllUserHistory(int id) {
		entityManager = JPAUtils.getEntityManager();
		List<Storage.UserHistory> videos = null;

		try {
			entityManager.getTransaction().begin();
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery(NamedStored.GET_USER_HISTORY,
					Storage.UserHistory.class);
			query.registerStoredProcedureParameter("id", Integer.class, ParameterMode.IN);
			query.setParameter("id", id);
			// query.registerStoredProcedureParameter("IdVideo", Integer.class,
			// ParameterMode.IN);
			// query.setParameter("IdVideo", id);

			//query.execute();

			videos = query.getResultList();

			entityManager.getTransaction().commit();
			// System.out.println("Added Success!!");
			return videos;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			// System.out.println("Can't add entity!!");
			throw new RuntimeException(e);
		}

	}

	public List<Storage.UserLike> getUserLiked(int id) {
		entityManager = JPAUtils.getEntityManager();
		List<Storage.UserLike> users = null;

		try {
			entityManager.getTransaction().begin();
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery(NamedStored.FIND_USER_BY_ID,
					Storage.UserLike.class);
			query.registerStoredProcedureParameter("IdVideo", Integer.class, ParameterMode.IN);
			query.setParameter("IdVideo", id);

			//query.execute();

			users = query.getResultList();

			entityManager.getTransaction().commit();
			// System.out.println("Added Success!!");
			return users;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			// System.out.println("Can't add entity!!");
			throw new RuntimeException(e);
		}

	}

	public List<Video> getRandomVideo(int max) {
		entityManager = JPAUtils.getEntityManager();
		String hql = "FROM Video ORDER BY function('NEWID')";
		List<Video> resultList = entityManager.createQuery(hql, Video.class).setMaxResults(max).getResultList();
		if (resultList != null) {
			return resultList;
		}
		return null;
	}

	// gọi hàm này mỗi khi sử dụng class
	@Override
	protected void finalize() throws Throwable {
		if (entityManager != null || entityManager.isOpen())
			// entityManager.close();
			super.finalize();
	}

	// tìm và trả về 1 tài khoản dựa vào mã id
	public T findById(Class<T> clazz, Integer id) {
		return entityManager.find(clazz, id);
	}

	// trả về 1 danh sách
	public List<T> findAll(Class<T> clazz, boolean existIsActive) {
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		// Dung StringBuilder de noi chuoi
		sql.append("SELECT o FROM ").append(entityName).append(" o");
		if (existIsActive == true) {
			sql.append(" WHERE o.online = 1");
		}
		// System.out.println(sql);
		TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
		return query.getResultList();
		// Example SELECT o From User o WHERE isActive = 1?
	}

	// trả về 1 danh sách
	public List<T> findAllUser(Class<T> clazz) {
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		// Dung StringBuilder de noi chuoi
		sql.append("SELECT o FROM ").append(entityName).append(" o");

		sql.append(" WHERE o.role = 0");

		// System.out.println(sql);
		TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
		return query.getResultList();
		// Example SELECT o From User o WHERE isActive = 1?
	}

	public List<T> findAll(Class<T> clazz, boolean existIsActive, int pageNumber, int pageSize) {
		String entityName = clazz.getSimpleName();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT o FROM ").append(entityName).append(" o");
		if (existIsActive == true) {
			sql.append(" WHERE o.online = 1");
		}
		TypedQuery<T> query = entityManager.createQuery(sql.toString(), clazz);
		// Vi query index tu 0 nen phai tru 1 ( trang 1)
		query.setFirstResult((pageNumber - 1) * pageSize);

		// Vi tri bat dau
		query.setMaxResults(pageSize);
		// So luong thuc the toi da - Theo Slide
		return query.getResultList();
		/*
		 * 5 phan tu : Muon 1 trang co 2 phan tu => Tong so trang : 3 trang 1: 2pt trang
		 * 2: 2pt trang 3: 1pt
		 */
	}

	// Select o from user o where o.username = ?0 and o.password = ?1
	// câu truy vấn truyền có điều kiện hoặc không // lấy ra 1 Object
	public T findOne(Class<T> clazz, String sql, Object... params) {
		// Truyen dung theo thu tu Params de Mapping dung
		TypedQuery<T> query = entityManager.createQuery(sql, clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);

		}
		List<T> result = query.getResultList();
		// GetResultList tranh truong hop Null
		if (result.isEmpty()) {
			return null;
		}
		return result.get(0);
	}

	// câu truy vấn truyền có điều kiện hoặc không // lấy ra nhiều Object
	public List<T> findMany(Class<T> clazz, String sql, Object... params) {

		TypedQuery<T> query = entityManager.createQuery(sql, clazz);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);

		}
		return query.getResultList();
	}

	// truy vấn NativeQuery
	public List<Object[]> findManyByNativeQuerry(String sql, Object... params) {
		// Dung NativeQuery
		Query query = entityManager.createNativeQuery(sql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}

	public T create(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			// System.out.println("Added Success!!");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			// System.out.println("Can't add entity!!");
			throw new RuntimeException(e);
		}
	}

	public T update(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(entity);
			entityManager.getTransaction().commit();
			// System.out.println("Updated success!!");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			// System.out.println("Can't updated entity!!");
			throw new RuntimeException(e);
		}
	}

	public T delete(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
			// System.out.println("Enity has been deleted!!");
			return entity;
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			// System.out.println("Can't delete entity!!");
			throw new RuntimeException(e);
		}
	}

	public List<T> callStore(String namedStore, Map<String, Object> params) {
		// ten Store - list Param - key la tham so truyen vao trong cau SP
		// Value la gia tri truyen vao trong dieu kien where
		StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery(namedStore);

		params.forEach((key, value) -> query.setParameter(key, value));

		// duyet het cac phan tu
		return (List<T>) query.getResultList();
	}

}
