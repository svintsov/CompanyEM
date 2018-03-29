package dao.mapper;

import entity.Entity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public interface ObjectMapper<T extends Entity> {

  T extractFromResultSet(ResultSet rs) throws SQLException;

  T makeUnique(Map<Integer, T> cache,
      T object);
}