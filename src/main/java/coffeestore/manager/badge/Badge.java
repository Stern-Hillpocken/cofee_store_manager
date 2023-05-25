package coffeestore.manager.badge;

import coffeestore.manager.employee.Employee;
import coffeestore.manager.employee.EmployeeService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isActivated;

//    @OneToOne(mappedBy = "badge")
//    @JsonIgnoreProperties("badge")
//    private Employee employee;
}
