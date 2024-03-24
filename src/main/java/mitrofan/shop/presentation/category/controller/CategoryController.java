package mitrofan.shop.presentation.category.controller;

import lombok.AllArgsConstructor;
import mitrofan.shop.application.service.CategoryService;
import mitrofan.shop.domain.entity.Category;
import mitrofan.shop.presentation.category.command.CreateCategoryCommand;
import mitrofan.shop.presentation.category.query.CategoryQuery;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;
    private ModelMapper modelMapper;

    @GetMapping
    public Stream<CategoryQuery> getAllCategories() {
        return categoryService.getAllCategories().stream()
                .map(category -> modelMapper.map(category, CategoryQuery.class));
    }

    @GetMapping("/{id}")
    public CategoryQuery getCategoriesById(@PathVariable Long id) {
        return modelMapper.map(categoryService.getCategoriesById(id), CategoryQuery.class);
    }

    @GetMapping("/title/{title}")
    public CategoryQuery getCategoriesByTitle(@PathVariable String title) {
        return modelMapper.map(categoryService.getCategoriesByTitle(title), CategoryQuery.class);
    }

    @PostMapping("/add")
    public CategoryQuery createNewCategories(@RequestBody CreateCategoryCommand categoriesCommand) {
        Category categoriesFromCommand = new Category();
        categoriesFromCommand.setTitle(categoriesCommand.getTitle());
        Category category = categoryService.createCategories(categoriesFromCommand);
        CategoryQuery categoriesQueryResponse = modelMapper.map(category, CategoryQuery.class);
        return categoriesQueryResponse;
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCategories(@PathVariable Long id) {
        categoryService.deleteCategories(id);
    }
}
