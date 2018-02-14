package dao;

import entity.User;
import java.sql.SQLException;

public interface UserDao extends CrudDao<User, Integer> {
  User findByEmail(String email) throws SQLException;

  //void setUserRole(Integer userId, Integer roleId);

}
