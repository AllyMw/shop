package mitrofan.shop.presentation.shoppingList.query;

import lombok.Data;
import mitrofan.shop.domain.entity.ShoppingList;
@Data
public class ShoppingListQuery {
    private String login;
    private ShoppingList shoppingList;
}
