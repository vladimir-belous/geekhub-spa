package spa.geek.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spa.geek.entities.User;

/**
 * @author vladimirb
 * @since 3/4/15.
 */

public interface UserRepository extends JpaRepository<User, Integer> {

}
