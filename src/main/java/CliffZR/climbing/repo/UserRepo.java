package CliffZR.climbing.repo;


import CliffZR.climbing.models.User;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    User findUserByUsername(String username);

}
