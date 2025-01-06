package dev.chewest.auditlogservice.core.auditlog.application;

import dev.chewest.auditlogservice.core.auditlog.domain.AuditLog;
import dev.chewest.auditlogservice.core.auditlog.domain.AuditLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/auditLogs")
public class AuditLogController {

    private final AuditLogService auditLogService;

    public AuditLogController(AuditLogService auditLogService) {
        this.auditLogService = auditLogService;
    }

    @GetMapping("{assetId}")
    public List<AuditLog> findByAssetId(@PathVariable final String assetId){
       return auditLogService.findByAssetId(assetId);
    }
}
