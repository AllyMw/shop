package mitrofan.shop.application.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mitrofan.shop.domain.entity.Category;
import mitrofan.shop.domain.entity.Product;
import mitrofan.shop.domain.entity.ShoppingList;
import mitrofan.shop.domain.entity.User;
import mitrofan.shop.infrastructure.repository.UserRepository;
import mitrofan.shop.presentation.product.command.CreateProductCommands;
import mitrofan.shop.presentation.product.query.ProductQuery;
import mitrofan.shop.presentation.user.command.CreateUserCommand;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

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



        User saved = userRepository.save(user);

        return saved;
    }
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User auth(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> {
            log.error("Пользователь с email={} не найден", email);
            return new EntityNotFoundException("Пользователь не найден");
        });

        if (user.getPassword().equals(password)) {
            return user;
        }

        throw new IllegalArgumentException("Неверный пароль");
    }
}

