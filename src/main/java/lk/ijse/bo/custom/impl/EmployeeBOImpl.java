package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.EmployeeBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.dto.CustomerDTO;
import lk.ijse.dto.EmployeeDTO;
import lk.ijse.entity.Customer;
import lk.ijse.entity.Employee;

import java.sql.SQLException;

public class EmployeeBOImpl implements EmployeeBO {
    EmployeeDAO employeeDAO= (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    public boolean saveEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.save(new Employee(dto.getId(),dto.getName(),dto.getAddress(),dto.getEmail(),dto.getTel()));
    }

    public boolean existEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.exist(id);
    }

    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update(new Employee(dto.getId(),dto.getName(),dto.getTel(),dto.getAddress(),dto.getEmail()));
    }

    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete(id);
    }
}
