package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.CustomerBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete(id);
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.exist(id);

    }
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.save(new Customer(dto.getId(),dto.getName(),dto.getAddress(),dto.getEmail(),dto.getTel()));
    }

    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update(new Customer(dto.getId(),dto.getName(),dto.getTel(),dto.getAddress(),dto.getEmail()));
    }

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers= new ArrayList<>();
        ArrayList<Customer> all = customerDAO.getAll();
        for (Customer c : all) {
            allCustomers.add(new CustomerDTO(c.getId(),c.getName(),c.getAddress(),c.getEmail(),c.getTel()));
        }
        return allCustomers;
    }

    @Override
    public CustomerDTO searchCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        Customer c=customerDAO.search(customerDTO.getId());
        return new CustomerDTO(c.getId(),c.getName(),c.getTel(),c.getAddress(),c.getEmail());
    }


    public CustomerDTO searchCustomer(String id) throws SQLException, ClassNotFoundException {
        Customer c=customerDAO.search(id);
        return new CustomerDTO(c.getId(),c.getName(),c.getTel(),c.getAddress(),c.getEmail());
    }
}
