package eu.rogowski.dealer.services;

import eu.rogowski.dealer.models.Cars;
import eu.rogowski.dealer.repositories.CarsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarsService {
    private final CarsRepository carsRepository;

    public Page<Cars> getCarsPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "carId"));
        return carsRepository.findAll(pageable);
    }

    public List<Cars> findAllByBrand(String brand) {
        return carsRepository.findAllByBrand(brand);
    }
}
