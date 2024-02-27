package mitrofan.shop.presentation.product.command;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateProductCommands {
    private String title;
    private Integer price;
    private String description;
    private String categoryTitle;
}