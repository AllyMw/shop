package mitrofan.shop.domain.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "shopping_list")
@Builder

public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToMany
    private List<Product> products;
}
