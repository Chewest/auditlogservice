package dev.chewest.auditlogservice.employee.persistence;

import dev.chewest.auditlogservice.employee.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
