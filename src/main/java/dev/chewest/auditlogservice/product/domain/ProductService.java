package dev.chewest.auditlogservice.product.domain;

import dev.chewest.auditlogservice.CustomEvent;
import dev.chewest.auditlogservice.product.persistence.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@EnableScheduling
public class ProductService {

    private final ProductRepository productRepository;
    private final ApplicationEventPublisher eventPublisher;

    public ProductService(ProductRepository productRepository, ApplicationEventPublisher eventPublisher) {
        this.productRepository = productRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public Product saveProduct(Product product) {
        eventPublisher.publishEvent(new CustomEvent(product));
        return productRepository.save(product);
    }
}
