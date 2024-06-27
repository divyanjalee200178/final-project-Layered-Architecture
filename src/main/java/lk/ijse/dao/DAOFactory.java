package lk.ijse.dao;

import lk.ijse.dao.custom.impl.CustomerDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)? daoFactory=new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
        CUSTOMER,SUPPLIER,EMPLOYEE,ORDER_DETAILS,QUERY_DAO
    }
    public SuperDAO getDAO(DAOTypes types){
       switch (types){
           case CUSTOMER :
               return  new CustomerDAOImpl();
           default:
               return null;
       }
    }
}
