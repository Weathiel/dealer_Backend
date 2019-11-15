package eu.rogowski.dealer.repositories;

import eu.rogowski.dealer.models.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffersRepository extends JpaRepository<Offers, Long> {
}
