package dev.chewest.auditlogservice.auditlog.application;

import dev.chewest.auditlogservice.auditlog.domain.AuditLog;
import dev.chewest.auditlogservice.auditlog.domain.AuditLogService;
import org.springframework.stereotype.Controller;
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
    public List<AuditLog> findByAssetId(@PathVariable String assetId){
       return auditLogService.findByAssetId(assetId);
    }
}
