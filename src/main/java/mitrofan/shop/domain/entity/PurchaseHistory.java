package mitrofan.shop.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "purchase_history")
@Builder
@Entity
@ToString(exclude = "user")
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @OneToOne
    private ShoppingList shoppingList;
    private LocalDate purchaseDate;

}
