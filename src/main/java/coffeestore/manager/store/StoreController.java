package coffeestore.manager.store;

import coffeestore.manager.coffee.Coffee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    public List<Store> getAll(){
        return this.storeService.getAll();
    }

    @GetMapping("/{id}")
    public Store getById(@PathVariable("id") Long id){
        return this.storeService.getById(id);
    }

    @PostMapping(path = "/add")
    public Store addStore(@RequestBody Store store){
        return this.storeService.addStore(store);
    }

    @PutMapping("/update/{id}")
    public Store update(@PathVariable("id") Long id, @RequestBody Store store){
        return this.storeService.update(id, store);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        this.storeService.delete(id);
    }
}
