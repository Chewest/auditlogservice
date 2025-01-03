package dev.chewest.auditlogservice.unresolvabletype.domain;

import dev.chewest.auditlogservice.CustomEvent;
import dev.chewest.auditlogservice.unresolvabletype.presistence.UnresolvableTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UnresolvableTypeService {

    private final UnresolvableTypeRepository unresolvableTypeRepository;
    private final ApplicationEventPublisher eventPublisher;

    public UnresolvableTypeService(UnresolvableTypeRepository unresolvableTypeRepository, ApplicationEventPublisher eventPublisher) {
        this.unresolvableTypeRepository = unresolvableTypeRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public void saveUnresolvableType(UnresolvableType unresolvableType) {
        eventPublisher.publishEvent(new CustomEvent(unresolvableType));
        unresolvableTypeRepository.save(unresolvableType);
    }
}
