package dao;

import entity.Role;
import exception.DaoException;

public interface RoleDao extends CrudDao<Role, String> {
  Role read(int id) throws DaoException;
}
