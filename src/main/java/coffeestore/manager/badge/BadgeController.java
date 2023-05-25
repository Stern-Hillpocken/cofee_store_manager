package coffeestore.manager.badge;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path="/badges")
public class BadgeController {

    private final BadgeService badgeService;

    @GetMapping
    public List<Badge> getAll(){
        return this.badgeService.getAll();
    }

    @GetMapping("/{id}")
    public Badge getById(@PathVariable("id") Long id){
        return this.badgeService.getById(id);
    }

    @PostMapping("/add")
    public Badge add(@RequestBody Badge badge){
        return this.badgeService.add(badge);
    }

    @PutMapping("/update/{id}")
    public Badge update(@PathVariable("id") Long id, @RequestBody Badge badge){
        return this.badgeService.update(id, badge);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        this.badgeService.delete(id);
    }
}
