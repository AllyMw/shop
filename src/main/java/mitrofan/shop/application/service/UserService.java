package mitrofan.shop.application.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import mitrofan.shop.domain.entity.Category;
import mitrofan.shop.domain.entity.Product;
import mitrofan.shop.domain.entity.User;
import mitrofan.shop.infrastructure.repository.UserRepository;
import mitrofan.shop.presentation.product.command.CreateProductCommands;
import mitrofan.shop.presentation.product.query.ProductQuery;
import mitrofan.shop.presentation.user.command.CreateUserCommand;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    private ProductService productService;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addNewUser(CreateUserCommand createUserCommand) {
        User newUser = modelMapper.map(createUserCommand, User.class);
        userRepository.save(newUser);
        return newUser;
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User update(Long id, User userFromCommand) {
        var user = getById(id);

        if (!user.getFirstName().equals(userFromCommand.getFirstName()))
            user.setFirstName(userFromCommand.getFirstName());

        User saved = userRepository.save(user);

        return saved;
    }
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}

