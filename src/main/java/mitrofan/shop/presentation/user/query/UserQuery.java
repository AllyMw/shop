package mitrofan.shop.presentation.user.query;

import lombok.Data;

@Data
public class UserQuery {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
}
