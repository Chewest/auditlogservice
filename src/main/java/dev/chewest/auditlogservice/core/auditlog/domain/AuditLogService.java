package dev.chewest.auditlogservice.core.auditlog.domain;

import dev.chewest.auditlogservice.core.auditlog.persistence.AuditLogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class AuditLogService {

    private final AuditLogRepository auditLogRepository;

    public AuditLogService(AuditLogRepository auditLogRepository) {
        this.auditLogRepository = auditLogRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public AuditLog saveAuditLog(final AuditLog auditLog) {
        return auditLogRepository.save(auditLog);
    }

    public List<AuditLog> findByAssetId(final String assetId) {
        return auditLogRepository.findByAssetId(assetId);
    }
}
