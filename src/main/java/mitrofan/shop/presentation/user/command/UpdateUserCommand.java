package mitrofan.shop.presentation.user.command;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserCommand {
    private String login;
    private String firstName;
    private String lastName;
    private int age;
}