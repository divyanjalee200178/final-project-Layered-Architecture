package lk.ijse.dao.custom.impl;

import jdk.jfr.RecordingState;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {
    public boolean save(Employee entity) throws SQLException {
        return SQLUtil.execute("INSERT INTO Employee (id, name, address, email,number) VALUES (?, ?, ?, ?, ?)", entity.getId(), entity.getName(), entity.getAddress(),entity.getEmail(),entity.getTel());
    }

    public boolean exist(String id) throws SQLException {
        ResultSet rst=SQLUtil.execute("SELECT id FROM employee WHERE id=?", id);
        return rst.next();
    }

    public boolean delete(String id) throws SQLException {
        return SQLUtil.execute("DELETE FROM employee WHERE id=?",id);
    }

    public boolean update(Employee entity) throws SQLException {
        return SQLUtil.execute("UPDATE employee SET name=?,number=? ,address=? ,email=? WHERE id=?", entity.getName(),entity.getTel(), entity.getAddress(),entity.getEmail(), entity.getId());
    }

    public Employee search(String id) throws SQLException {
        return SQLUtil.execute("SELECT * FROM employee WHERE id=?",id);
    }
}
