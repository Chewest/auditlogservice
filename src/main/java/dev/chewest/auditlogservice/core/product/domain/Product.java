package dev.chewest.auditlogservice.core.product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Product {

    @Id
    private UUID id;
    private String key;
    private String message;
}
