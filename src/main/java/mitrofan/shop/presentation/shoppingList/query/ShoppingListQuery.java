package mitrofan.shop.presentation.shoppingList.query;

import lombok.Data;
import mitrofan.shop.domain.entity.Product;
import mitrofan.shop.domain.entity.ShoppingList;

import java.util.List;

@Data
public class ShoppingListQuery {
    private String login;
    private List<Product> productList;
}
