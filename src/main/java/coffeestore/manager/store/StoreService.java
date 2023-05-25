package coffeestore.manager.store;

import coffeestore.manager.coffee.Coffee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public List<Store> getAll() {
        return this.storeRepository.findAll();
    }

    public Store addStore(Store store) {
        return this.storeRepository.save(store);
    }

    public Store getById(Long id) {
        return this.storeRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("id "+id+" not found")
                );
    }

    public Store update(Long id, Store store) {
        Store foundedStore = this.getById(id);
        foundedStore.setName(store.getName());
        foundedStore.setLocation(store.getLocation());
        return this.storeRepository.save(foundedStore);
    }

    public void delete(Long id) {
        this.storeRepository.deleteById((id));
    }
}
