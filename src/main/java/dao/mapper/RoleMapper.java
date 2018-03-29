package dao.mapper;

import static util.constant.SQLRoleColumns.ROLE_ID;
import static util.constant.SQLRoleColumns.ROLE_NAME;

import entity.Role;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class RoleMapper implements ObjectMapper<Role>{


  @Override
  public Role extractFromResultSet(final ResultSet rs) throws SQLException {
    Role result = new Role();
    result.setId(rs.getInt(ROLE_ID));
    result.setName(rs.getString(ROLE_NAME));
    return result;
  }

  @Override
  public Role makeUnique(final Map<Integer, Role> cache, final Role object) {
    return null;
  }
}
