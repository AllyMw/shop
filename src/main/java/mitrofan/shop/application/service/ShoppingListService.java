package mitrofan.shop.application.service;

import lombok.RequiredArgsConstructor;
import mitrofan.shop.domain.entity.Product;
import mitrofan.shop.domain.entity.ShoppingList;
import mitrofan.shop.domain.entity.User;
import mitrofan.shop.infrastructure.repository.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingListService {
    private UserService userService;
    private ProductService productService;
    private ShoppingListRepository shoppingListRepository;

    public ShoppingList addToCart(String login, Long productId) {
        User user = userService.getByLogin(login);
        Product product = productService.getProductById(productId);
        ShoppingList cart = user.getShoppingList();
        if (cart == null) {
            cart = new ShoppingList();
        }
        List<Product> list = cart.getProducts();
        if (!list.contains(product)) {
            list.add(product);
            cart.setProducts(list);
        }
        shoppingListRepository.save(cart);
        return cart;
    }
}
