package eu.rogowski.dealer.repositories;

import eu.rogowski.dealer.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAllByrolename(String role_name);
}
