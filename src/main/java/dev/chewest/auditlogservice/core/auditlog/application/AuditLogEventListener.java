package dev.chewest.auditlogservice.core.auditlog.application;

import dev.chewest.auditlogservice.core.CustomEvent;
import dev.chewest.auditlogservice.core.auditlog.domain.AuditLog;
import dev.chewest.auditlogservice.core.auditlog.domain.AuditLogService;
import dev.chewest.auditlogservice.core.auditlog.domain.TransactionStatus;
import dev.chewest.auditlogservice.core.decision.domain.Decision;
import dev.chewest.auditlogservice.core.product.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Slf4j
public class AuditLogEventListener {

    private final AuditLogService auditLogService;

    public AuditLogEventListener(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleSuccessfulEvent(final CustomEvent event) {

        AuditLog saved = null;

        switch (event.getSource()) {
            case Product product -> {
                var auditLog = new AuditLog(product);
                auditLog.setTransactionStatus(TransactionStatus.SUCCEEDED);
                saved = auditLogService.saveAuditLog(auditLog);
            }
            case Decision decision -> {
                var auditLog = new AuditLog(decision);
                auditLog.setTransactionStatus(TransactionStatus.SUCCEEDED);
                saved = auditLogService.saveAuditLog(auditLog);
            }
            default -> log.info("Not a resolvable type for {}", this);
        }
        if (saved == null) return;
        log.info("Persisted new audit log -> {}", saved);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handleFailedEvent(final CustomEvent event) {
        AuditLog saved = null;

        switch (event.getSource()) {
            case Product product -> {
                var auditLog = new AuditLog(product);
                auditLog.setTransactionStatus(TransactionStatus.FAILED);
                saved = auditLogService.saveAuditLog(auditLog);
            }
            case Decision decision -> {
                var auditLog = new AuditLog(decision);
                auditLog.setTransactionStatus(TransactionStatus.FAILED);
                saved = auditLogService.saveAuditLog(auditLog);
            }
            default -> log.info("Not a resolvable type for {}", this);
        }
        if (saved == null) return;
        log.info("Persisted new audit log -> {}", saved);
    }
}
