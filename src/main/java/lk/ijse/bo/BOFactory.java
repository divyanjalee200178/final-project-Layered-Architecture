package lk.ijse.bo;

import lk.ijse.bo.custom.impl.CustomerBOImpl;

import javax.swing.plaf.PanelUI;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;

    }
    public enum BOTypes{
        CUSTOMER,ITEM,SUPPLIER,EMPLOYEE,PO
    }
    public SuperBO getBO(BOTypes types){
        switch (types){
            case CUSTOMER:
                return  new CustomerBOImpl();
            default:
                return null;
        }
    }
}