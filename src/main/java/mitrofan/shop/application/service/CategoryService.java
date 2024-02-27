package mitrofan.shop.application.service;

import lombok.RequiredArgsConstructor;
import mitrofan.shop.domain.entity.Category;
import mitrofan.shop.infrastructure.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public Category getCategoriesById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }
    public Category getCategoriesByTitle(String title) {
        return categoryRepository.findByTitle(title);
    }
    public Category createCategories(Category categoryFromCommand) {
        Category category = categoryRepository.save(categoryFromCommand);
        return category;
    }

    public void deleteCategories(Long id) {
        categoryRepository.deleteById(id);
    }
}