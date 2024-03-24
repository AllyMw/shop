package mitrofan.shop.presentation.product.query;

import lombok.Data;
import mitrofan.shop.presentation.category.query.CategoryQuery;

@Data
public class ProductQuery {
    private Long id;
    private String title;
    private Integer price;
    private String description;
    private CategoryQuery productCategory;
}