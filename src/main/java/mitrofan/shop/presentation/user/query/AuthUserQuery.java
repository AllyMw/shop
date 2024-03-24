package mitrofan.shop.presentation.user.query;
import lombok.Data;

@Data
public class AuthUserQuery {

    private String email;
    private String password;

}