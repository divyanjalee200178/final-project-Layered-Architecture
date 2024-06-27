package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.SupplierBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.SupplierDAO;
import lk.ijse.dto.EmployeeDTO;
import lk.ijse.dto.SupplierDTO;
import lk.ijse.entity.Employee;
import lk.ijse.entity.Supplier;

import java.sql.SQLException;

public class SupplierBOImpl implements SupplierBO {
    SupplierDAO supplierDAO= (SupplierDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SUPPLIER);

    public boolean saveSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.save(new Supplier(dto.getId(),dto.getName(),dto.getAddress(),dto.getEmail(),dto.getTel()));
    }

    public boolean existSupplier(String id) throws SQLException, ClassNotFoundException {
        return supplierDAO.exist(id);
    }

    public boolean updateSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDAO.update(new Supplier(dto.getId(),dto.getName(),dto.getTel(),dto.getAddress(),dto.getEmail()));
    }
}
