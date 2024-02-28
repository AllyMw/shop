package mitrofan.shop.application.service;

import lombok.RequiredArgsConstructor;
import mitrofan.shop.domain.entity.Product;
import mitrofan.shop.domain.entity.PurchaseHistory;
import mitrofan.shop.domain.entity.ShoppingList;
import mitrofan.shop.domain.entity.User;
import mitrofan.shop.infrastructure.repository.PurchaseHistoryRepositoty;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PurchaseHistoryService {
    private PurchaseHistoryRepositoty purchaseHistoryRepositoty;
    public void create(ShoppingList listProduct, User user) {
        PurchaseHistory purchaseHistory = new PurchaseHistory();

        purchaseHistory.setUser(user);
        purchaseHistory.setShoppingList(listProduct);
        purchaseHistory.setPurchaseDate(LocalDate.now());

        purchaseHistoryRepositoty.save(purchaseHistory);

    }
}
