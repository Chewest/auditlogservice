package dev.chewest.auditlogservice.product.persistence;

import dev.chewest.auditlogservice.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
