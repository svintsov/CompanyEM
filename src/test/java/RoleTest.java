import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import dao.RoleDao;
import dao.datasource.ConnectionPoolHolder;
import dao.factory.DaoFactory;
import entity.Role;
import exception.DaoException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.ConnectionUtil;

public class RoleTest {

  Connection connection;
  DataSource dataSource;
  DaoFactory daoFactory;

  @Before
  public void init() throws SQLException{
    dataSource = ConnectionPoolHolder.getDataSource();
    Connection connection = dataSource.getConnection();
    connection.setAutoCommit(false);
    daoFactory = DaoFactory.getDaoFactory(connection);
  }

  @Test
  public void whenReadAnyRoleThenReturnExceptMinusOne(){
    try {
      RoleDao roleDao = daoFactory.createRoleDao();
      Role role = roleDao.read("Admin");
      assertThat(role.getId(), not(-1));
    } catch (DaoException e) {
      e.printStackTrace();
    }

  }

  @Test
  public void whenSearchAdminThenReturnRole(){
    try {
      RoleDao roleDao = daoFactory.createRoleDao();
      Role role = roleDao.read("Admin");
      assertThat(role.getName(), is("Admin"));
    } catch (DaoException e) {
      e.printStackTrace();
    }
  }
  
  @Test
  public void whenSearchAdminByIdThenReturnRole(){
    final int ADMIN_ID=5;
    try {
      RoleDao roleDao = daoFactory.createRoleDao();
      Role role = roleDao.read(ADMIN_ID);
      assertThat(role.getName(), is("Admin"));
    } catch (DaoException e) {
      e.printStackTrace();
    }
  }

  @After
  public void after(){
    ConnectionUtil.rollback(connection);
    ConnectionUtil.close(connection);
  }

}
