package dev.chewest.auditlogservice.core.decision.persistence;

import dev.chewest.auditlogservice.core.decision.domain.Decision;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DecisionRepository extends JpaRepository<Decision, UUID> {
}
