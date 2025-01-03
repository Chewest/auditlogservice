package dev.chewest.auditlogservice.unresolvabletype.application;

import dev.chewest.auditlogservice.unresolvabletype.domain.UnresolvableType;
import dev.chewest.auditlogservice.unresolvabletype.domain.UnresolvableTypeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UnresolvableTypePseudoController {

    private final UnresolvableTypeService unresolvableTypeService;

    public UnresolvableTypePseudoController(UnresolvableTypeService unresolvableTypeService) {
        this.unresolvableTypeService = unresolvableTypeService;
    }

    @Scheduled(fixedRate = 5000)
    public void publishEvent(){
        var unresolvableType = new UnresolvableType();
        unresolvableTypeService.saveUnresolvableType(unresolvableType);
    }
}
