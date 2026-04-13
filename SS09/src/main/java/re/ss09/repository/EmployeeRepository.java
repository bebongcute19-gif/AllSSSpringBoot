package re.ss09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.ss09.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    boolean existsByEmail(String email);
}
