package coffeestore.manager.coffee;

import coffeestore.manager.store.Store;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/coffees") /*this.http.get('localhost:8080/coffees')*/
public class CoffeeController {

    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    public List<Coffee> getAll(){
        return this.coffeeService.getAll();
    }

    @GetMapping(path="/{id}")
    public Coffee getById(@PathVariable("id") Long id){
        return this.coffeeService.getById(id);
    }

    @PostMapping(path = "/add")
    public Coffee add(@RequestBody Coffee coffee){
        return this.coffeeService.add(coffee);
    }

    @PutMapping(path = "/update/{id}")
    public Coffee update(@PathVariable("id") Long id, @RequestBody Coffee coffee){
        return this.coffeeService.update(id, coffee);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        this.coffeeService.delete(id);
    }
}
