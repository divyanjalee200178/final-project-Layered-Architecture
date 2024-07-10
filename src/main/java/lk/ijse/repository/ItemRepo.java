package lk.ijse.repository;

import lk.ijse.db.DbConnection;
import lk.ijse.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemRepo {

    /*public static Item searchByCode(String code) throws SQLException {
        String sql = "SELECT * FROM Item WHERE code = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, code);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            String it_code= resultSet.getString(1);
            String description = resultSet.getString(2);
            double unitPrice =Double.parseDouble(resultSet.getString(3));
            int qty= Integer.parseInt(resultSet.getString(4));
            String location = resultSet.getString(5);

            Item item = new Item(code, description, unitPrice,qty, location);

            return item;
        }

        return null;
    }





    public static boolean updateQty(String itemCode, int qty) throws SQLException {
        String sql = "UPDATE Item SET qtyOnHand = qtyOnHand - ? WHERE code = ?";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        pstm.setInt(1, qty);
        pstm.setString(2, itemCode);

        return pstm.executeUpdate() > 0;
    }



    public static List<String> getCodes() throws SQLException {
        String sql = "SELECT code FROM Item";
        ResultSet resultSet = DbConnection.getInstance()
                .getConnection()
                .prepareStatement(sql)
                .executeQuery();

        List<String> codeList = new ArrayList<>();
        while (resultSet.next()) {
            codeList.add(resultSet.getString(1));
        }
        return codeList;
    }

   /* public static boolean placeOrderUpdate(List<OrderDetail> oderList) throws SQLException {
        for(OrderDetail orderDetail : oderList){
            System.out.println("place order update >>>" +oderList);
            boolean isupdated = updateQty(orderDetail.getCode(),orderDetail.getQty());
            if (isupdated){
                return true;
            }
        }

        return false;

    }
/*
    public static boolean updateQty(List<OrderDetail> oderList) throws SQLException {
        String sql = "UPDATE Item SET qtyOnHand = qtyOnHand - ? WHERE code = ?";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        pstm.setInt(1, oderList.get(getAllItem().indexOf()));
        pstm.setString(2, itemCode);

        return pstm.executeUpdate() > 0;
    }*/
}
