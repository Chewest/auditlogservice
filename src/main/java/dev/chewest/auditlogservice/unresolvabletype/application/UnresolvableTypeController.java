package dev.chewest.auditlogservice.unresolvabletype.application;

import dev.chewest.auditlogservice.unresolvabletype.domain.UnresolvableType;
import dev.chewest.auditlogservice.unresolvabletype.domain.UnresolvableTypeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class UnresolvableTypeController {

    private final UnresolvableTypeService unresolvableTypeService;

    public UnresolvableTypeController(UnresolvableTypeService unresolvableTypeService) {
        this.unresolvableTypeService = unresolvableTypeService;
    }

    @PostMapping
    public UnresolvableType createTest(){
        var unresolvableType = new UnresolvableType();
        return unresolvableTypeService.saveUnresolvableType(unresolvableType);
    }
}
