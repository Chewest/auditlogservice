package dev.chewest.auditlogservice.auditlog.domain;

import dev.chewest.auditlogservice.employee.domain.Employee;
import dev.chewest.auditlogservice.product.domain.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
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

    public AuditLog(Employee employee){
        this.asset = "Employee";
        this.message = employee.getMessage();
        this.assetId = employee.getId().toString();
        this.key = employee.getKey();
    }
}
