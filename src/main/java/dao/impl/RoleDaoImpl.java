package dao.impl;

import static util.constant.SQLRoleColumns.ROLE_ID;
import static util.constant.SQLRoleColumns.ROLE_NAME;

import dao.RoleDao;
import dao.mapper.ObjectMapper;
import dao.mapper.RoleMapper;
import entity.Role;
import exception.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class RoleDaoImpl implements RoleDao {

  private Connection connection;
  private static volatile RoleDaoImpl instance;
  private ObjectMapper<Role> mapper;

  public RoleDaoImpl(Connection connection) {
    this.connection = connection;
    this.mapper = new RoleMapper();
  }


  @Override
  public Role create(final Role entity) throws DaoException {
    return null;
  }


  @Override
  public Role read(final String name) throws DaoException {
    Role result = new Role();
    result.setId(-1);

    try (PreparedStatement statement = connection.prepareStatement(SQLRole.READ_BY_NAME.QUERY)) {
      statement.setString(1, name);
      final ResultSet rs = statement.executeQuery();

      if (rs.next()) {
        result = mapper.extractFromResultSet(rs);
      }

    } catch (SQLException e) {
      throw new DaoException(e);
    }

    return result;
  }

  @Override
  public Role read(final int id) throws DaoException {
    Role result = new Role();
    result.setId(-1);

    try (PreparedStatement statement = connection.prepareStatement(SQLRole.READ_BY_ID.QUERY)) {
      statement.setInt(1, id);
      final ResultSet rs = statement.executeQuery();

      if (rs.next()) {
        result = mapper.extractFromResultSet(rs);
      }

    } catch (SQLException e) {
      throw new DaoException(e);
    }

    return result;
  }


  @Override
  public Role update(final Role entity) throws DaoException {
    return null;
  }

  @Override
  public void delete(final String s) throws DaoException {

  }


  @Override
  public List<Role> findAll() throws DaoException {
    return null;
  }


  enum SQLRole {
    READ_BY_NAME("SELECT * FROM my_role WHERE " + ROLE_NAME +" = (?)"),
    READ_BY_ID("SELECT * FROM my_role WHERE "+ ROLE_ID +" = (?)");

    String QUERY;

    SQLRole(String QUERY) {
      this.QUERY = QUERY;
    }
  }
}
