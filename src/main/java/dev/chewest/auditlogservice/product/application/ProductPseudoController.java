package dev.chewest.auditlogservice.product.application;

import dev.chewest.auditlogservice.product.domain.Product;
import dev.chewest.auditlogservice.product.domain.ProductService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ProductPseudoController {

    private final ProductService productService;

    public ProductPseudoController(ProductService productService) {
        this.productService = productService;
    }

    @Scheduled(fixedRate = 5000)
    public void publishEvent(){
        var product = new Product();
        productService.saveProduct(product);
    }
}
