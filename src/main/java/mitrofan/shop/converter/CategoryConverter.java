package mitrofan.shop.converter;


import jakarta.persistence.Convert;
import mitrofan.shop.domain.entity.Category;
import mitrofan.shop.infrastructure.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
@Component
@Convert
public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category convert(String categoryTitle) {
        return categoryRepository.findByTitle(categoryTitle);
    }

}