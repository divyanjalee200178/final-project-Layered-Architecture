package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.SupplierDTO;
import lk.ijse.entity.Supplier;

import java.sql.SQLException;

public interface SupplierBO extends SuperBO {
    public boolean saveSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException;

    public boolean existSupplier(String id) throws SQLException, ClassNotFoundException;

    public boolean updateSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException;
}
