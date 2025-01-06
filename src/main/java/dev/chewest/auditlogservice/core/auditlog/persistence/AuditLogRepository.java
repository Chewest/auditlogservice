package dev.chewest.auditlogservice.core.auditlog.persistence;

import dev.chewest.auditlogservice.core.auditlog.domain.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, UUID> {
    List<AuditLog> findByAssetId(final String assetId);
}
