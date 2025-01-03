package dev.chewest.auditlogservice.employee.application;

import dev.chewest.auditlogservice.employee.domain.Employee;
import dev.chewest.auditlogservice.employee.domain.EmployeeService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmployeePseudoController {
    private final EmployeeService employeeService;

    public EmployeePseudoController(EmployeeService productService) {
        this.employeeService = productService;
    }

    @Scheduled(fixedRate = 5000)
    public void publishEvent(){
        var employee = new Employee();
        employeeService.saveEmployee(employee);
    }
}
