package dev.chewest.auditlogservice.product.application;

import dev.chewest.auditlogservice.product.domain.Product;
import dev.chewest.auditlogservice.product.domain.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController()
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestParam UUID productId){
        var product = new Product();
        product.setId(productId);
        return productService.saveProduct(product);
    }
}
