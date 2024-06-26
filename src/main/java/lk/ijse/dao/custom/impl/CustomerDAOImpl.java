package lk.ijse.dao.custom.impl;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM customer WHERE id=?",id);
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT id FROM customer WHERE id=?", id);
        return rst.next();
    }
    public boolean save(Customer entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO Customer (id, name, address, email,number) VALUES (?, ?, ?, ?, ?)", entity.getId(), entity.getName(), entity.getAddress(),entity.getEmail(),entity.getTel());
    }

    public boolean update(Customer entity) throws SQLException {
        return SQLUtil.execute("UPDATE Customer SET name=?,number=? ,address=? ,email=? WHERE id=?", entity.getName(),entity.getTel(), entity.getAddress(),entity.getEmail(), entity.getId());
    }

    public Customer search(String id) throws SQLException {
        return SQLUtil.execute("SELECT * FROM Customer WHERE id=?",id);
    }

    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Customer");
        while (rst.next()) {
            Customer customer = new Customer(rst.getString("id"), rst.getString("name"), rst.getString("address"),rst.getString("email"),rst.getString("number"));
            allCustomers.add(customer);
        }
        return allCustomers;
    }


}
