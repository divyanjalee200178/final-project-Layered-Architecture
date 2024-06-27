package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.CustomerDTO;

import java.sql.SQLException;

public interface CustomerBO extends SuperBO {
    //public boolean exsistCustomer(String id) throws SQLException, ClassNotFoundException ;

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;
    public boolean deleteCustomer(String id)throws SQLException, ClassNotFoundException;

    public boolean saveCustomer(CustomerDTO customerDTO)throws SQLException, ClassNotFoundException;
    public boolean updateCustomer(CustomerDTO customerDTO)throws SQLException, ClassNotFoundException;

    public CustomerDTO searchCustomer(CustomerDTO customerDTO)throws SQLException, ClassNotFoundException;
}
