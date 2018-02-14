package dao.factory;

import dao.RoleDao;
import dao.UserDao;
import java.sql.Connection;

public abstract class DaoFactory {


  public abstract UserDao createUserDao();

  public abstract RoleDao createRoleDao();

  public static DaoFactory getDaoFactory(Connection connection) {
    return MySqlDaoFactory.getInstance(connection);
  }
}
