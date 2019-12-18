package eu.rogowski.dealer.repositories;

import eu.rogowski.dealer.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByFirstNameAndLastName(String firstName, String lastName);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByPassword(String password);
}
