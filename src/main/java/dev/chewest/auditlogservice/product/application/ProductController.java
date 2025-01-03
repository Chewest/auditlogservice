package dev.chewest.auditlogservice.product.application;

import dev.chewest.auditlogservice.product.domain.Product;
import dev.chewest.auditlogservice.product.domain.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createEmployee(@RequestParam UUID productId){
        var product = new Product();
        product.setId(productId);
        return productService.saveProduct(product);
    }
}
