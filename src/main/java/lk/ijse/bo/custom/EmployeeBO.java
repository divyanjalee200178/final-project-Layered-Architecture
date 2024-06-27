package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.EmployeeDTO;
import lk.ijse.entity.Employee;

import java.sql.SQLException;

public interface EmployeeBO extends SuperBO {
    public boolean saveEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;

    public boolean existEmployee(String id) throws SQLException, ClassNotFoundException;

    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException;
}
