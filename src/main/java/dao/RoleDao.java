package dao;

import entity.Role;
import java.sql.SQLException;

public interface RoleDao extends CrudDao<Role, Integer> {

  Role findByName(String value) throws SQLException;

}
