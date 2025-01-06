package dev.chewest.auditlogservice.core.decision.domain;

import dev.chewest.auditlogservice.core.CustomEvent;
import dev.chewest.auditlogservice.core.decision.persistence.DecisionRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@Slf4j
public class DecisionService {

    private final DecisionRepository decisionRepository;
    private final ApplicationEventPublisher eventPublisher;

    public DecisionService(DecisionRepository decisionRepository, ApplicationEventPublisher eventPublisher) {
        this.decisionRepository = decisionRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public Decision saveDecision(final Decision decision) {
        eventPublisher.publishEvent(new CustomEvent(decision));
        return decisionRepository.save(decision);
    }
}
