package coffeestore.manager.coffee;

import coffeestore.manager.store.Store;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;
    private String description;

    @ManyToMany(mappedBy = "coffeeList")
    @JsonIgnoreProperties("coffeeList")
    private Set<Store> storeList = new HashSet<>();
}
