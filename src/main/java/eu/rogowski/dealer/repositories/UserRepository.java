package eu.rogowski.dealer.repositories;

import eu.rogowski.dealer.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByFirstNameAndLastName(String firstName, String lastName);
    User findByUsername(String username);
}
