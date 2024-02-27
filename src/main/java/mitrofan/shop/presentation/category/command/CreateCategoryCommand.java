package mitrofan.shop.presentation.category.command;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryCommand {
    private String title;
}