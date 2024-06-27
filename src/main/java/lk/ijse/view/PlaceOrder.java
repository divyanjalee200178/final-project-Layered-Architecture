package lk.ijse.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlaceOrder {
    private Order order;
    private List<OrderDetail> oderList;


}
