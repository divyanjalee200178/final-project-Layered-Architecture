package lk.ijse.model.tm;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode

public class EmployeeTm {
    private String id;
    private String name;
    private String address;
    private String email;
    private String tel;
}
