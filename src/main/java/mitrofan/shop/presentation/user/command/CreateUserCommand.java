package mitrofan.shop.presentation.user.command;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserCommand {
    private String login;
    private String firstName;
    private String lastName;
    private int age;
}
