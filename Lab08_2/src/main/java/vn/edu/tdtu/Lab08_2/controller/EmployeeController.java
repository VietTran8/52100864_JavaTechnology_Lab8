package vn.edu.tdtu.Lab08_2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.tdtu.Lab08_2.model.Employee;
import vn.edu.tdtu.Lab08_2.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("")
    public String employees(Model model){
        List<Employee> employees = employeeService.loadEmployees();
        model.addAttribute("employees", employees);
        return "index";
    }

    @GetMapping("/add")
    public String addPageEmployee(Model model){
        model.addAttribute("employee", new Employee());
        return "add";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute("employee") Employee addEmployee){
        if(addEmployee != null)
            employeeService.addEmployee(addEmployee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editPage(Model model, @PathVariable("id") Long id){
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("needEditEmployee", employee);
        return "add";
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(
            @PathVariable("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address
    ){
        Employee employee = new Employee();

        employee.setId(id);
        employee.setName(name);
        employee.setPhone(phone);
        employee.setAddress(address);
        employee.setEmail(email);

        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
