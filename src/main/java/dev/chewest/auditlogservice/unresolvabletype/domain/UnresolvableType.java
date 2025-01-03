package dev.chewest.auditlogservice.unresolvabletype.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class UnresolvableType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;
}
