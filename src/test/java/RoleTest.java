import dao.RoleDao;
import dao.datasource.ConnectionPoolHolder;
import dao.factory.DaoFactory;
import entity.Role;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.ConnectionUtil;

public class RoleTest {

  Connection connection=null;
  DataSource dataSource;

  @Before
  public void init(){
    dataSource = ConnectionPoolHolder.getDataSource();
  }

  @Test
  public void testRoleRead(){
    try (Connection connection = dataSource.getConnection()) {
      connection.setAutoCommit(false);
      DaoFactory daoFactory = DaoFactory.getDaoFactory(connection);
      RoleDao roleDao = daoFactory.createRoleDao();
      Role role = roleDao.findByName("Admin");
      Assert.assertEquals("Admin",role.getName());
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  @After
  public void after(){
    ConnectionUtil.close(connection);
  }

}
