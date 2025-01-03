package dev.chewest.auditlogservice.auditlog.application;

import dev.chewest.auditlogservice.CustomEvent;
import dev.chewest.auditlogservice.auditlog.domain.AssetStatus;
import dev.chewest.auditlogservice.auditlog.domain.AuditLog;
import dev.chewest.auditlogservice.auditlog.domain.AuditLogService;
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
        switch (event.getSource()) {
            case Product product -> {
                var auditLog = new AuditLog();
                auditLog.setAsset("Product");
                auditLog.setAssetStatus(AssetStatus.SUCCEEDED);
                auditLog.setAssetId(product.getId().toString());
                auditLogService.saveAuditLog(auditLog);
            }
            case Employee employee -> {
                var auditLog = new AuditLog();
                auditLog.setAsset("Employee");
                auditLog.setAssetStatus(AssetStatus.SUCCEEDED);
                auditLog.setAssetId(employee.getId().toString());
                auditLogService.saveAuditLog(auditLog);
            }
            default -> log.info("Not a resolvable type for {}", this);
        }
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void handleFailedEvent(CustomEvent event) {
        switch (event.getSource()) {
            case Product product -> {
                var auditLog = new AuditLog();
                auditLog.setAsset("Product");
                auditLog.setAssetStatus(AssetStatus.FAILED);
                auditLog.setAssetId(product.getId().toString());
                auditLogService.saveAuditLog(auditLog);
            }
            case Employee employee -> {
                var auditLog = new AuditLog();
                auditLog.setAsset("Employee");
                auditLog.setAssetStatus(AssetStatus.FAILED);
                auditLog.setAssetId(employee.getId().toString());
                auditLogService.saveAuditLog(auditLog);
            }
            default -> log.info("Not a resolvable type for {}", this);
        }
    }
}
