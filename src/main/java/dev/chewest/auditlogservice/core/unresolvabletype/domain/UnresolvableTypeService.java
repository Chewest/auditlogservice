package dev.chewest.auditlogservice.core.unresolvabletype.domain;

import dev.chewest.auditlogservice.core.CustomEvent;
import dev.chewest.auditlogservice.core.unresolvabletype.presistence.UnresolvableTypeRepository;
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
    public UnresolvableType saveUnresolvableType(final UnresolvableType unresolvableType) {
        eventPublisher.publishEvent(new CustomEvent(unresolvableType));
        return unresolvableTypeRepository.save(unresolvableType);
    }
}
