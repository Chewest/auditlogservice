package dev.chewest.auditlogservice.core.auditlog.domain;

import dev.chewest.auditlogservice.core.decision.domain.Decision;
import dev.chewest.auditlogservice.core.product.domain.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String message;
    private String asset;
    private String assetId;
    private String key;
    @Enumerated(value = EnumType.STRING)
    private TransactionStatus transactionStatus;

    public AuditLog(Product product){
        this.asset = "Product";
        this.message = product.getMessage();
        this.assetId = product.getId().toString();
        this.key = product.getKey();
    }

    public AuditLog(Decision decision){
        this.asset = "Employee";
        this.message = decision.getMessage();
        this.assetId = decision.getId().toString();
        this.key = decision.getKey();
    }
}
