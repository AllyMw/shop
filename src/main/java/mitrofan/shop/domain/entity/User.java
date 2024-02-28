package mitrofan.shop.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;

    @Embedded
    private FullName fullName;

    @Column(name = "age")
    private int age;

    @OneToOne
    private ShoppingList shoppingList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PurchaseHistory> purchaseHistoryList;
}