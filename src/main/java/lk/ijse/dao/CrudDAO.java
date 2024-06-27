package lk.ijse.dao;

import java.sql.SQLException;

public interface CrudDAO<T> extends SuperDAO {
    public boolean delete(String id)throws SQLException, ClassNotFoundException;
    public boolean exist(String id) throws SQLException, ClassNotFoundException;
    public boolean save(T entity) throws SQLException, ClassNotFoundException;
    public boolean update(T entity)throws SQLException, ClassNotFoundException;
    public T search(String id) throws SQLException, ClassNotFoundException;



}