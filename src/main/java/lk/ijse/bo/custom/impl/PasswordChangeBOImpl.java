package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PasswordChangeBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.CustomerDAO;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.Customer;
import lk.ijse.model.User;
import lk.ijse.models.CustomerDTO;
import lk.ijse.models.UserDTO;

import java.sql.SQLException;

public class PasswordChangeBOImpl implements PasswordChangeBO {

    UserDAO userDAO= (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    public boolean updateUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        return userDAO.update(new User(dto.getUserId(),dto.getName(),dto.getPassword() ));
    }
}
