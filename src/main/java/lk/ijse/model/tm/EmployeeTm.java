package lk.ijse.model.tm;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

public class EmployeeTm implements Comparable<EmployeeTm>{
    private String id;
    private String name;
    private String address;
    private String email;
    private String tel;

    @Override
    public int compareTo(EmployeeTm e) {
        if (id == null) {
            return (e.getId() == null) ? 0 : -1;
        }
        return id.compareTo(e.getId());
    }
}
