package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.model.User;
import lk.ijse.models.UserDTO;

import java.sql.SQLException;

public interface PasswordChangeBO extends SuperBO {
    public boolean updateUser(UserDTO dto) throws SQLException, ClassNotFoundException;
}
