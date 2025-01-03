package dev.chewest.auditlogservice.auditlog.persistence;

import dev.chewest.auditlogservice.auditlog.domain.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, UUID> {
}
