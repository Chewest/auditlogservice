package dev.chewest.auditlogservice.employee.application;

import dev.chewest.auditlogservice.employee.domain.Employee;
import dev.chewest.auditlogservice.employee.domain.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller("employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService productService) {
        this.employeeService = productService;
    }

    @PostMapping
    public Employee createEmployee(@RequestParam UUID employeeId){
        var employee = new Employee();
        employee.setId(employeeId);
        return employeeService.saveEmployee(employee);
    }
}
