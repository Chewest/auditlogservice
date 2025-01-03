package dev.chewest.auditlogservice.auditlog.application;

import dev.chewest.auditlogservice.CustomEvent;
import dev.chewest.auditlogservice.auditlog.domain.AuditLog;
import dev.chewest.auditlogservice.auditlog.domain.AuditLogService;
import dev.chewest.auditlogservice.auditlog.domain.TransactionStatus;
import dev.chewest.auditlogservice.employee.domain.Employee;
import dev.chewest.auditlogservice.product.domain.Product;
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
    public void handleSuccessfulEvent(CustomEvent event) {

        AuditLog saved = null;

        switch (event.getSource()) {
            case Product product -> {
                var auditLog = new AuditLog(product);
                auditLog.setTransactionStatus(TransactionStatus.SUCCEEDED);
                saved = auditLogService.saveAuditLog(auditLog);
            }
            case Employee employee -> {
                var auditLog = new AuditLog(employee);
                auditLog.setTransactionStatus(TransactionStatus.SUCCEEDED);
                saved = auditLogService.saveAuditLog(auditLog);
            }
            default -> log.info("Not a resolvable type for {}", this);
        }
        if (saved == null)
            return;
        log.info("Persisted new audit log -> {}", saved);
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handleFailedEvent(CustomEvent event) {
        AuditLog saved = null;

        switch (event.getSource()) {
            case Product product -> {
                var auditLog = new AuditLog(product);
                auditLog.setTransactionStatus(TransactionStatus.FAILED);
                saved = auditLogService.saveAuditLog(auditLog);
            }
            case Employee employee -> {
                var auditLog = new AuditLog(employee);
                auditLog.setTransactionStatus(TransactionStatus.FAILED);
                saved = auditLogService.saveAuditLog(auditLog);
            }
            default -> log.info("Not a resolvable type for {}", this);
        }
        if (saved == null)
            return;
        log.info("Persisted new audit log -> {}", saved);
    }
}
