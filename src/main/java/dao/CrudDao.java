package dao;

import exception.DaoException;
import java.util.List;

public interface CrudDao<T, Key> {

  T create(T entity) throws DaoException;

  T read(Key key) throws DaoException;

  T update(T entity) throws DaoException;

  void delete(Key key) throws DaoException;

  List<T> findAll() throws DaoException;

}