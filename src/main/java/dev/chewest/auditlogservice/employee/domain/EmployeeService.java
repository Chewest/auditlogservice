package dev.chewest.auditlogservice.employee.domain;

import dev.chewest.auditlogservice.CustomEvent;
import dev.chewest.auditlogservice.employee.persistence.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ApplicationEventPublisher eventPublisher;

    public EmployeeService(EmployeeRepository employeeRepository, ApplicationEventPublisher eventPublisher) {
        this.employeeRepository = employeeRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public Employee saveEmployee(Employee employee) {
        eventPublisher.publishEvent(new CustomEvent(employee));
        return employeeRepository.save(employee);
    }
}
