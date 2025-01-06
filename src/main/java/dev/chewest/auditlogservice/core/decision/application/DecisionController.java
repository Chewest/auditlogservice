package dev.chewest.auditlogservice.core.decision.application;

import dev.chewest.auditlogservice.core.decision.domain.Decision;
import dev.chewest.auditlogservice.core.decision.domain.DecisionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class DecisionController {
    private final DecisionService decisionService;

    public DecisionController(DecisionService productService) {
        this.decisionService = productService;
    }

    @PostMapping
    public Decision createEmployee(@RequestParam final UUID employeeId){
        var employee = new Decision();
        employee.setId(employeeId);
        return decisionService.saveEmployee(employee);
    }
}
