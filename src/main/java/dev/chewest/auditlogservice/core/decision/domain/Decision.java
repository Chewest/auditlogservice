package dev.chewest.auditlogservice.core.decision.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Decision {

    @Id
    private UUID id;
    private String key;
    private String message;
}
