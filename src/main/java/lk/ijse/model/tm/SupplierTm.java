package lk.ijse.model.tm;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class SupplierTm implements Comparable<SupplierTm> {
    private String id;
    private String name;
    private String address;
    private String email;
    private String tel;


    @Override
    public int compareTo(SupplierTm s) {
        if (id == null) {
            return (s.getId() == null) ? 0 : -1;
        }
        return id.compareTo(s.getId());
    }
}