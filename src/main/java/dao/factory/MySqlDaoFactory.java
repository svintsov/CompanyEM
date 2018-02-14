package dao.factory;

import dao.RoleDao;
import dao.UserDao;
import dao.impl.RoleDaoImpl;
import dao.impl.UserDaoImpl;
import java.sql.Connection;

public class MySqlDaoFactory extends DaoFactory {

  private Connection connection;

  private MySqlDaoFactory(Connection connection) {
    this.connection = connection;
  }


  @Override
  public RoleDao createRoleDao() {
    return RoleDaoImpl.getInstance(connection);
  }

  @Override
  public UserDao createUserDao() {
    return UserDaoImpl.getInstance(connection);
  }


  private static class MySqlDaoFactoryHolder {

    private static MySqlDaoFactory instance(Connection connection) {
      return new MySqlDaoFactory(connection);
    }
  }

  public static MySqlDaoFactory getInstance(Connection connection) {
    return MySqlDaoFactoryHolder.instance(connection);
  }

}
