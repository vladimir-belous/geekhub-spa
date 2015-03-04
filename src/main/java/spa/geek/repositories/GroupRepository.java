package spa.geek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import spa.geek.entities.Group;

/**
 * @author vladimirb
 * @since 3/4/15.
 */

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
