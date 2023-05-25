package coffeestore.manager.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll(){
        return this.employeeService.getAll();
    }

    @GetMapping(path="/{id}")
    public Employee getById(@PathVariable("id") Long id){
        return this.employeeService.getById(id);
    }

    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee){
        return this.employeeService.add(employee);
    }

    @PutMapping("/update/{id}")
    public Employee update(@PathVariable("id") Long id, @RequestBody Employee employee){
        return this.employeeService.update(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        this.employeeService.delete(id);
    }
}
