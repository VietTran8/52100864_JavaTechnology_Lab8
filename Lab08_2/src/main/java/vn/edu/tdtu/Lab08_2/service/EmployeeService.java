package vn.edu.tdtu.Lab08_2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.tdtu.Lab08_2.model.Employee;
import vn.edu.tdtu.Lab08_2.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> loadEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public void updateEmployee(Employee employee){
        employeeRepository.findById(employee.getId()).ifPresent(empl -> {
            empl.setName(employee.getName());
            empl.setPhone(employee.getPhone());
            empl.setAddress(employee.getAddress());
            empl.setEmail(employee.getEmail());

            employeeRepository.save(empl);
        });
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void deleteEmployee(long id){
        employeeRepository.findById(id).ifPresent(employeeRepository::delete);
    }
}
