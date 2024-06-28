package lk.ijse.model.tm;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

public class ItemTm implements Comparable<ItemTm>{
    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
    private String location;

    @Override
    public int compareTo(ItemTm i) {
        if (code == null) {
            return (i.getCode() == null) ? 0 : -1;
        }
        return code.compareTo(i.getCode());
    }
}
