package eu.rogowski.dealer.repositories;

import eu.rogowski.dealer.models.Offers;
import eu.rogowski.dealer.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findAllByOffers(Offers offers);
}
