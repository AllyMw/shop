package mitrofan.shop.presentation.user.controller;

import lombok.AllArgsConstructor;
import mitrofan.shop.application.service.ShoppingListService;
import mitrofan.shop.application.service.UserService;
import mitrofan.shop.domain.entity.ShoppingList;
import mitrofan.shop.domain.entity.User;
import mitrofan.shop.presentation.shoppingList.query.ShoppingListQuery;
import mitrofan.shop.presentation.user.command.CreateUserCommand;
import mitrofan.shop.presentation.user.command.UpdateUserCommand;
import mitrofan.shop.presentation.user.query.UserQuery;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
class UserController {

    private UserService userService;
    private ModelMapper modelMapper;
    private ShoppingListService shoppingListService;


    @GetMapping
    public List<UserQuery> getAll() {
        return userService.getAllUsers().stream()
                .map(user -> modelMapper.map(user, UserQuery.class))
                .toList();
    }

    @PostMapping("/{id}")
    public UserQuery getById(@PathVariable Long id) {
        return modelMapper.map(userService.getById(id), UserQuery.class);
    }

    @PostMapping("/create")
    public UserQuery create(@RequestBody CreateUserCommand command) {
        User user = userService.addNewUser(command);
        UserQuery userQueryResponse = modelMapper.map(user, UserQuery.class);
        return userQueryResponse;
    }

    @PostMapping("/update/{id}")
    public UserQuery update(@PathVariable Long id, @RequestBody UpdateUserCommand command) {
        User userFromCommand = modelMapper.map(command, User.class);

        User user = userService.update(id, userFromCommand);

        UserQuery userQueryResponse = modelMapper.map(user, UserQuery.class);

        return userQueryResponse;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PostMapping("/cart/add")
    public ShoppingListQuery addToCart(@RequestParam String login, @RequestParam Long productId) {
        ShoppingList cart = shoppingListService.addToCart(login, productId);
        ShoppingListQuery shoppingListQuery = new ShoppingListQuery();
        shoppingListQuery.setShoppingList(cart);
        shoppingListQuery.setLogin(login);
        return shoppingListQuery;
    }
}