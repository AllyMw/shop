package mitrofan.shop.application.service;

import lombok.RequiredArgsConstructor;
import mitrofan.shop.domain.entity.Product;
import mitrofan.shop.domain.entity.ShoppingList;
import mitrofan.shop.domain.entity.User;
import mitrofan.shop.infrastructure.repository.ShoppingListRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingListService {
    private final UserService userService;
    private final ProductService productService;
    private final ShoppingListRepository shoppingListRepository;
    private final PurchaseHistoryService purchaseHistoryService;

    public ShoppingList addToCart(String login, Long productId) {
        User user = userService.getByLogin(login);
        Product product = productService.getProductById(productId);
        ShoppingList cart = user.getShoppingList();
        if (cart == null) {
            cart = new ShoppingList();
            cart.setProducts(new ArrayList<>());
            cart.setUser(user);
        }
        List<Product> list = cart.getProducts();
        if (!list.contains(product)) {
            list.add(product);
            cart.setProducts(list);
        }
        shoppingListRepository.save(cart);
        return cart;
    }

    public void buy(String login) {
        User user = userService.getByLogin(login);
        ShoppingList cart = user.getShoppingList();
        if (cart != null) {
            purchaseHistoryService.create(cart, user);

            cart.setProducts(new ArrayList<>());
            ;
            user.setShoppingList(cart);
            userService.update(user.getId(), user);
        } else {
            user.setShoppingList(new ShoppingList());
            userService.update(user.getId(), user);
        }

        shoppingListRepository.save(cart);
    }

    public void deleteFromCart(String login, Long productId) {
        User user = userService.getByLogin(login);
        ShoppingList cart = user.getShoppingList();
        List<Product> listProduct = cart.getProducts();
        listProduct.removeIf(product -> product.getId().equals(productId));
        user.setShoppingList(cart);
        userService.update(user.getId(), user);
        shoppingListRepository.save(cart);
    }
}

