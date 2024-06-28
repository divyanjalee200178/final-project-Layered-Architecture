package lk.ijse.dao.custom.impl;

import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemDAOImpl implements ItemDAO {
    public boolean delete(String code) throws SQLException {
        return SQLUtil.execute("DELETE FROM Item WHERE code=?",code);
    }

    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT code FROM Item WHERE code=?", code);
        return rst.next();
    }
    public boolean save(Item entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO Item (code,description,unitPrice,qtyOnHand,location) VALUES (?, ?, ?, ?, ?)", entity.getCode(), entity.getDescription(), entity.getUnitPrice(),entity.getQtyOnHand(),entity.getLocation());
    }

    public boolean update(Item entity) throws SQLException {
        return SQLUtil.execute("UPDATE Item SET description=? ,unitPrice=? ,qtyOnHand=? ,location=? WHERE code=?", entity.getDescription(),entity.getUnitPrice(), entity.getQtyOnHand(),entity.getLocation(), entity.getCode());
    }

    public Item search(String code) throws SQLException {
        return SQLUtil.execute("SELECT * FROM Item WHERE code=?",code);
    }

}
