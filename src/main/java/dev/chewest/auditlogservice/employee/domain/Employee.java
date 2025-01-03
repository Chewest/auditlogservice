package dev.chewest.auditlogservice.employee.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Employee {

    @Id
    private UUID id;
    private String key;
    private String message;
}
