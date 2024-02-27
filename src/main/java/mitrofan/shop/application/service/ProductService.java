package mitrofan.shop.application.service;

import lombok.RequiredArgsConstructor;
import mitrofan.shop.domain.entity.Category;
import mitrofan.shop.domain.entity.Product;
import mitrofan.shop.infrastructure.repository.ProductRepository;
import mitrofan.shop.presentation.product.command.CreateProductCommands;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productsRepository;
    private final CategoryService categoriesService;
    private final ModelMapper modelMapper;
    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }

    public Product addNewProduct(CreateProductCommands createProductCommands) {
        String categoryTitle = createProductCommands.getCategoryTitle();
        Category categoriesById = categoriesService.getCategoriesByTitle(categoryTitle);
        if (categoriesById == null) {
            return null;
        }
        Product newProduct = modelMapper.map(createProductCommands, Product.class);
        newProduct.setCategory(categoriesById);
        productsRepository.save(newProduct);
        return newProduct;
    }

    public Product getProductById(Long productId) {
        return productsRepository.findById(productId).orElseThrow();
    }
}