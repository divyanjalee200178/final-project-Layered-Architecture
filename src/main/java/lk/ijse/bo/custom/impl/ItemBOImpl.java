package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ItemBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.EmployeeDAO;
import lk.ijse.dao.custom.ItemDAO;
import lk.ijse.dto.EmployeeDTO;
import lk.ijse.dto.ItemDTO;
import lk.ijse.entity.Employee;
import lk.ijse.entity.Item;

import java.sql.SQLException;

public class ItemBOImpl implements ItemBO {
    ItemDAO itemDAO= (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    public boolean existItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.exist(code);
    }

    public boolean saveItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.save(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getLocation()));
    }

    public boolean deleteItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.delete(code);
    }

    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDAO.update(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getLocation()));
    }
}
