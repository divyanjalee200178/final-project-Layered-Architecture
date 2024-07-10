package lk.ijse.repository;

import lk.ijse.db.DbConnection;
import lk.ijse.entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {
    public static Employee searchById(String id) throws SQLException{
        String sql="SELECT * FROM Employee WHERE id=?";

        Connection connection=DbConnection.getInstance().getConnection();
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setObject(1,id);

        ResultSet resultSet=pstm.executeQuery();
        if(resultSet.next()){
            String em_id=resultSet.getString(1);
            String name=resultSet.getString(2);
            String address=resultSet.getString(3);
            String email=resultSet.getString(4);
            String tel=resultSet.getString(5);

            Employee employee=new Employee(em_id,name,address,email,tel);

            return employee;

        }
        return null;
    }





    public static List<String> getIds() throws SQLException {
        String sql = "SELECT id FROM Employee";
        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        List<String> idList = new ArrayList<>();

        ResultSet resultSet = pstm.executeQuery();
        while (resultSet.next()) {
            String id = resultSet.getString(1);
            idList.add(id);
        }
        return idList;
    }

    public static Employee searchByTel(String tele) throws SQLException{
        String sql="SELECT * FROM Employee WHERE number=?";

        Connection connection=DbConnection.getInstance().getConnection();
        PreparedStatement pstm=connection.prepareStatement(sql);
        pstm.setObject(1,tele);

        ResultSet resultSet=pstm.executeQuery();
        if(resultSet.next()){
            String em_id=resultSet.getString(1);
            String name=resultSet.getString(2);
            String address=resultSet.getString(3);
            String email=resultSet.getString(4);
            String tel=resultSet.getString(5);

            Employee employee=new Employee(em_id,name,address,email,tel);

            return employee;

        }
        return null;
    }

}
