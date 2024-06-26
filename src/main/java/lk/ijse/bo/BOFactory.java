package lk.ijse.bo;

import lk.ijse.bo.custom.impl.CustomerBOImpl;
import lk.ijse.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.bo.custom.impl.ItemBOImpl;
import lk.ijse.bo.custom.impl.SupplierBOImpl;

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
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case SUPPLIER:
                return new SupplierBOImpl();
            case ITEM:
                return new ItemBOImpl();
            default:
                return null;
        }
    }
}
