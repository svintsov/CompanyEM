package dao.impl;

import static util.constant.table.RoleConstants.ID;
import static util.constant.table.RoleConstants.NAME;
import static util.constant.table.RoleConstants.TABLE;

import dao.AbstractDao;
import dao.RoleDao;
import dao.util.QueryBuilder;
import entity.Role;
import entity.proxy.RoleProxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {

  private RoleDaoImpl(Connection connection) {
    super(TABLE, connection);
  }

  private static final class RoleDaoImplHolder {

    private static RoleDaoImpl instance(Connection connection) {
      return new RoleDaoImpl(connection);
    }
  }

  public static RoleDaoImpl getInstance(Connection connection) {
    return RoleDaoImplHolder.instance(connection);
  }

  @Override
  public Role findByName(String value) throws SQLException {
    String query = new QueryBuilder()
        .selectAll()
        .from()
        .table(TABLE)
        .where()
        .condition(TABLE, NAME)
        .build();
    return getEntityByQuery(query, value);
  }


  @Override
  protected String[] getParameterNames() {
    return new String[]{NAME};
  }

  @Override
  protected void setEntityParameters(Role entity, PreparedStatement statement) throws SQLException {
    statement.setString(1, entity.getName());
  }

  @Override
  protected Role getEntityFromResultSet(ResultSet resultSet) throws SQLException {
    int id = resultSet.getInt(ID);
    String name = resultSet.getString(NAME);
    return new RoleProxy.RoleBuilder()
        .setId(id)
        .setName(name)
        .buildRoleProxy();
  }
}
