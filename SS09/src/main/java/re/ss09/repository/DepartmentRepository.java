package re.ss09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import re.ss09.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
