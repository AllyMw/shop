package mitrofan.shop.application.mappers;


import mitrofan.shop.domain.entity.User;
import mitrofan.shop.presentation.user.command.CreateUserCommand;
import mitrofan.shop.presentation.user.command.UpdateUserCommand;
import mitrofan.shop.presentation.user.query.UserQuery;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserQuery fromUserToQuery(User user);

    User fromCommandToUser(CreateUserCommand command);
    User fromCommandToUser(UpdateUserCommand command);

    List<UserQuery> fromUsersToQueries(List<User> users);
}

