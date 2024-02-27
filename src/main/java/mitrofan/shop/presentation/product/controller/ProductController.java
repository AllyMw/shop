package mitrofan.shop.presentation.product.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mitrofan.shop.application.service.ProductService;
import mitrofan.shop.domain.entity.Product;
import mitrofan.shop.presentation.product.command.CreateProductCommands;
import mitrofan.shop.presentation.product.query.ProductQuery;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Slf4j
public class ProductController {
    private ProductService productService;
    private ModelMapper modelMapper;


    @GetMapping
    public Stream<ProductQuery> getAllProducts() {
        return productService.getAllProducts().stream()
                .map(products -> modelMapper.map(products, ProductQuery.class));
    }

    @PostMapping("/add")
    public ProductQuery addNewProduct(@RequestBody CreateProductCommands createProductCommands) {
        log.info("{}", createProductCommands.toString());
        Product products = productService.addNewProduct(createProductCommands);
        if (products == null) {
            return null;
        }

        return modelMapper.map(products, ProductQuery.class);
    }
}