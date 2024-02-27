package mitrofan.shop.presentation.category.query;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Data
public class CategoryQuery {
    private Integer id;
    private String title;

}

