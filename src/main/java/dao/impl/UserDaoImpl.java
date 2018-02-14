package dao.impl;

import static util.constant.table.UserConstants.EMAIL;
import static util.constant.table.UserConstants.ID;
import static util.constant.table.UserConstants.PASSWORD;
import static util.constant.table.UserConstants.TABLE;

import dao.AbstractDao;
import dao.UserDao;
import dao.util.QueryBuilder;
import entity.User;
import entity.proxy.UserProxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoImpl extends AbstractDao<User> implements UserDao {

  private UserDaoImpl(Connection connection) {
    super(TABLE, connection);
  }

  @Override
  public User findByEmail(String email) throws SQLException {
    String query = new QueryBuilder()
        .selectAll()
        .from()
        .table(TABLE)
        .where()
        .condition(TABLE, EMAIL)
        .build();
    return getEntityByQuery(query, email);
  }

  /*@Override
  public void setUserRole(Integer userId, Integer roleId) {
    String query = new QueryBuilder()
        .insert()
        .into()
        .table(USER_ROLE_TABLE)
        .insertValues(new String[]{USER_COLUMN, ROLE_COLUMN})
        .build();
    try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
      statement.setLong(1, userId);
      statement.setLong(2, roleId);
      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }*/

  private static class UserDaoImplHolder {
    private static UserDaoImpl instance(Connection connection) {
      return new UserDaoImpl(connection);
    }
  }

  public static UserDaoImpl getInstance(Connection connection) {
    return UserDaoImplHolder.instance(connection);
  }

  @Override
  protected String[] getParameterNames() {
    return new String[]{EMAIL, PASSWORD};
  }

  @Override
  protected void setEntityParameters(User user, PreparedStatement statement) throws SQLException {
    statement.setString(1, user.getEmail());
    statement.setString(2, user.getPassword());

  }

  @Override
  protected User getEntityFromResultSet(ResultSet resultSet) throws SQLException {
    int id = Integer.valueOf(resultSet.getString(ID));
    String email = resultSet.getString(EMAIL);
    String password = resultSet.getString(PASSWORD);
    return new UserProxy.UserBuilder()
        .setId(id)
        .setEmail(email)
        .setPassword(password)
        .buildUserProxy();
  }
}
