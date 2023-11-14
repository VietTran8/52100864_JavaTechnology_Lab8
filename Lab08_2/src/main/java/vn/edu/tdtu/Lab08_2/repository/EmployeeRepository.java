package vn.edu.tdtu.Lab08_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.tdtu.Lab08_2.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public boolean existsByName(String name);
}
