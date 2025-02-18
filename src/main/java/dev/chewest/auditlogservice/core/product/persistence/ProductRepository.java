package dev.chewest.auditlogservice.core.product.persistence;

import dev.chewest.auditlogservice.core.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
