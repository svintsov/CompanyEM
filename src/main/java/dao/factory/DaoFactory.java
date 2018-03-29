package dao.factory;

import dao.RoleDao;
import java.sql.Connection;

public abstract class DaoFactory {


  public abstract RoleDao createRoleDao();

  public static DaoFactory getDaoFactory(Connection connection) {
    return MySqlDaoFactory.getInstance(connection);
  }
}
