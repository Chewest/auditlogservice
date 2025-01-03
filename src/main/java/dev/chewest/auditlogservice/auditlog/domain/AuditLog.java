package dev.chewest.auditlogservice.auditlog.domain;

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
    @Enumerated(value = EnumType.STRING)
    private AssetStatus assetStatus;

}
