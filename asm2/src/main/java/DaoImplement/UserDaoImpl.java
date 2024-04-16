package DaoImplement;

import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import Constant.NamedStored;
import DaoInterface.AbstractDao;
import DaoInterface.UserDAO;
import Entity.User;

public class UserDaoImpl extends AbstractDao<User> implements UserDAO {
	@Override
	public User findByID(Integer id) {
		// Ke thua tu UserDAO
		return super.findById(User.class, id);
	}
	

	@Override
	public User findByEmail(String email) {
		// Su dung cau lenh SQL
		String sql = "SELECT o FROM User o WHERE o.email = ?0";
		return super.findOne(User.class, sql, email);
	}

	@Override
	public User findByUsername(String username) {
		String sql = "SELECT o FROM User o WHERE o.username = ?0";
		return super.findOne(User.class, sql, username);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		String sql = "SELECT o FROM User o WHERE o.username = ?0 AND o.password = ?1";
		return super.findOne(User.class, sql, username, password);
	}

	@Override
	public List<User> findAll() {
		// Tim nhung User dang hoat dong
		return super.findAll(User.class, true);
	}

	@Override
	public List<User> findAll(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		return super.findAll(User.class, true, pageNumber, pageSize);
	}


	@Override
	public User findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		String sql = "SELECT o FROM User o WHERE o.email = :email AND o.password = :password";
		return super.findById(User.class, 1);
	
	}


	@Override
	public List<User> findAll2() {
		// TODO Auto-generated method stub
		return super.findAllUser(User.class);
	}


	@Override
	public List<User> findUserByIDorEmail(String s, int type) {
		// TODO Auto-generated method stub
		return super.findUserByIdorEmail(s, type);
	}

//	@Override
//	public User create(User entity) {
//		return entity;
//	}
//
//	@Override
//	public User update(User entity) {
//		return entity;
//	}
//
//	@Override
//	public User delete(User entity) {
//		return entity;
//	}

}
