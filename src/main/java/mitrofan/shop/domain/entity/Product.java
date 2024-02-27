package mitrofan.shop.domain.entity;


import jakarta.persistence.*;
import lombok.*;
import mitrofan.shop.converter.CategoryConverter;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "products")
@Builder
@Entity
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    @Convert(converter = CategoryConverter.class)
    private Category category;

}
