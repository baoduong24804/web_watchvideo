package Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import DaoInterface.UserDAO;
import Entity.User;
import DaoImplement.UserDaoImpl;

public class UserServiceImpl{
	private  UserDAO dao;
	public UserServiceImpl() {
		dao = new UserDaoImpl();
	}
	
	public User findByID(Integer id) {
		// 
		return dao.findByID(id);
	}
	

	
	public User findByEmail(String email) {
		// 
		return dao.findByEmail(email);
	}

	
	public User findByUsername(String username) {
		// 
		return dao.findByUsername(username);
	}

	
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.findByUsernameAndPassword(username, password);
	}
	
	public User login1(String email, String password) {
		// TODO Auto-generated method stub
		return dao.findByEmailAndPassword(email, password);
	}

	
	public User resetPassword(String email) {
		User existUser = findByEmail(email); // Tim xem da ton tai User voiw Email nay chua
		if(existUser != null) {
			//Math.random -> pass
			//(Math.random()) * ((max - min) + 1)) + min
			String newPass = String.valueOf((int)(Math.random() * ((9999 - 1000) + 1)) + 1000);
			existUser.setPassword(newPass);
			return dao.update(existUser);
		}
		return null;
	}

	
	public List<User> findAll() {
		
		return dao.findAll();
	}
	
	public List<User> findAll2() {
		
		return dao.findAll2();
	}

	
	public List<User> findAll(int pageNumber, int pageSize) {
		// 
		return dao.findAll(pageNumber, pageSize);
	}

	
	public User create(User user) {
		//
		User newUser = new User();
		newUser.setPassword(user.getPassword());
		newUser.setUsername(user.getUsername());
		newUser.setEmail(user.getEmail());
		newUser.setRole(Boolean.FALSE);
		newUser.setOnline(Boolean.TRUE);
		
		return dao.create(newUser);
		
	}

	
	public User update(User entity) {
		// 
		User u = new User();
		u.setUserId(entity.getUserId());
		u.setOnline(entity.getOnline());
		u.setPassword(entity.getPassword());
		u.setRole(entity.getRole());
		u.setUsername(entity.getUsername());
		u.setEmail(entity.getEmail().trim());
		return dao.update(u);
	}

	
	public User delete(Integer id) {
		//
		User user = dao.findByID(id);
		user.setOnline(Boolean.FALSE);
		return dao.update(user);
	}
	
	public List<User> findUserByIDorEmail(String s, int type){
		return dao.findUserByIDorEmail(s, type);
	}
	

}
