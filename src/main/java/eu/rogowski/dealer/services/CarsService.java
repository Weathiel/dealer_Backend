package eu.rogowski.dealer.services;

import eu.rogowski.dealer.models.Cars;
import eu.rogowski.dealer.repositories.CarsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarsService {
    private final CarsRepository carsRepository;

    public List<Cars> getAll() {
        return carsRepository.findAll();
    }
}
