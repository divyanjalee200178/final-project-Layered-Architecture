package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAOImpl implements UserDAO {

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean save(User entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(User entity) throws SQLException {
        return SQLUtil.execute("UPDATE user SET name=?,password=? WHERE useId=?", entity.getName(), entity.getPassword(),entity.getUserId());
    }



    public User check(String id,String password) throws SQLException, ClassNotFoundException {
        ResultSet rst= SQLUtil.execute("SELECT userId, password,name FROM users WHERE userId = ?", id);
        rst.next();
        return new User(rst.getString("userId"), rst.getString("name"),rst.getString("password"));
    }

    @Override
    public ArrayList<User> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    public User search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public User searchContact(String tel) throws SQLException, ClassNotFoundException {
        return null;
    }
}
