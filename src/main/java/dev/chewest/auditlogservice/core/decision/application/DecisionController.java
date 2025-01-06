package dev.chewest.auditlogservice.core.decision.application;

import dev.chewest.auditlogservice.core.decision.domain.Decision;
import dev.chewest.auditlogservice.core.decision.domain.DecisionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/decisions")
public class DecisionController {
    private final DecisionService decisionService;

    public DecisionController(DecisionService productService) {
        this.decisionService = productService;
    }

    @PostMapping
    public Decision createDecision(@RequestParam final UUID decisionId){
        var decision = new Decision();
        decision.setId(decisionId);
        return decisionService.saveDecision(decision);
    }
}
