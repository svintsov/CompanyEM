package dao.datasource;

import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class ConnectionPoolHolder {
  private static volatile DataSource dataSource;

  public static DataSource getDataSource(){

    if (dataSource == null){
      synchronized (ConnectionPoolHolder.class) {
        if (dataSource == null) {
          BasicDataSource ds = new BasicDataSource();
          ds.setUrl("jdbc:postgresql://localhost:5432/companydb");
          ds.setUsername("postgres");
          ds.setPassword("qwaszx45");
          ds.setMinIdle(5);
          ds.setMaxIdle(10);
          ds.setMaxOpenPreparedStatements(100);
          ds.setDriverClassName("org.postgresql.Driver");
          ds.setConnectionProperties("useUnicode=yes;characterEncoding=utf8");
          dataSource = ds;
        }
      }
    }
    return dataSource;

  }


}