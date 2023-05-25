package coffeestore.manager.badge;

import coffeestore.manager.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BadgeService {

    private final BadgeRepository badgeRepository;

    public List<Badge> getAll() {
        return this.badgeRepository.findAll();
    }

    public Badge getById(Long id) {
        return this.badgeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id "+id+" not founded")
        );
    }

    public Badge add(Badge badge) {
        return this.badgeRepository.save(badge);
    }

    public Badge update(Long id, Badge badge) {
        Badge foundedBadge = this.getById(id);
        foundedBadge.setIsActivated(badge.getIsActivated());
        return this.badgeRepository.save(foundedBadge);
    }

    public void delete(Long id) {
        this.badgeRepository.deleteById(id);
    }
}
