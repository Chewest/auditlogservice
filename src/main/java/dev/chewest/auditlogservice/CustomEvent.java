package dev.chewest.auditlogservice;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

    public CustomEvent(Object source){
        super(source);
    }
}
