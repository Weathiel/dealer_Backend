package eu.rogowski.dealer.repositories;

import eu.rogowski.dealer.models.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {
    List<Cars> findAllByBrand(String brand);
    List<Cars> findModelByBrand(String brand);
}
