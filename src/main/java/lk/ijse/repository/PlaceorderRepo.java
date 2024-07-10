package lk.ijse.repository;

public class PlaceorderRepo {
   /* public static boolean placeOrder(PlaceOrder po) throws SQLException {
        Connection connection = DbConnection.getInstance().getConnection();
        connection.setAutoCommit(false);

        try {
            boolean isOrderSaved = OrderRepo.save(po.getOrder());
            if (isOrderSaved) {

              boolean isQtyUpdated = ItemRepo.placeOrderUpdate(po.getOderList());
               if(isQtyUpdated) {
                    boolean isOrderDetailSaved = OrderDeatilRepo.save(po.getOderList());
                    if (isOrderDetailSaved) {
                        connection.commit();
                        return true;
                    }
                }
            }
            connection.rollback();
            return false;
        } catch (Exception e) {
            connection.rollback();
            return false;
        } finally {
            connection.setAutoCommit(true);
        }
    }*/
}
