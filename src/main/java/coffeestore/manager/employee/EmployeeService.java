package coffeestore.manager.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    public Employee getById(Long id) {
        return this.employeeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id "+id+" not founded")
        );
    }

    public Employee add(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee employee) {
        Employee currentEmployee = this.getById(id);
        currentEmployee.setName(employee.getName());
        currentEmployee.setFirstname(employee.getFirstname());
        return this.employeeRepository.save(currentEmployee);
    }

    public void delete(Long id) {
        this.employeeRepository.deleteById(id);
    }
}
