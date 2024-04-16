package DaoInterface;

import java.util.List;
import java.util.Map;

import Entity.User;

public interface UserDAO {
  User findByID(Integer id);
  User findByEmail(String email);
  User findByUsername(String username);
  User findByUsernameAndPassword(String username, String password);
  User findByEmailAndPassword(String email, String password);
  List<User> findAll();
  List<User> findAll2();
  List<User> findAll(int pageNumber,int pageSize);
  User create(User entity);
  User update(User entity);
  User delete(User entity);
  //List<User> findUsersLikedByVideoHref(Map<String, Object> params);
  List<User> findUserByIDorEmail(String s, int type);
}
