package coffeestore.manager.coffee;

import coffeestore.manager.store.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public List<Coffee> getAll() {
        return this.coffeeRepository.findAll();
    }

    public Coffee add(Coffee coffee) {
        return this.coffeeRepository.save(coffee);
    }

    public Coffee getById(Long id) {
        return this.coffeeRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("id "+id+" not found")
                );
    }

    public Coffee update(Long id, Coffee coffee) {
        Coffee foundCoffee = this.getById(id);
        foundCoffee.setName(coffee.getName());
        foundCoffee.setPrice(coffee.getPrice());
        foundCoffee.setDescription(coffee.getDescription());
        return this.coffeeRepository.save(foundCoffee);
    }

    public void delete(Long id) {
        this.coffeeRepository.deleteById(id);
    }
}
