package coffeestore.manager.employee;

import coffeestore.manager.badge.Badge;
import coffeestore.manager.store.Store;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String firstname;

    @ManyToOne
    @JsonIgnoreProperties("employeeList")
    private Store store;

//    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JsonIgnoreProperties("employee")
//    private Badge badge;
}
