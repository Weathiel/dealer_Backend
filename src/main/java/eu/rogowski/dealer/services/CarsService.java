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

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarsService {
    private final CarsRepository carsRepository;

    public Page<Cars> getCarsPage(String page, String pageSize) {
        Pageable pageable = PageRequest.of(Integer.valueOf(page), Integer.valueOf(pageSize), Sort.by(Sort.Direction.ASC, "carId"));
        return carsRepository.findAll(pageable);
    }

    public List<Cars> findAllByBrand(String brand) {
        return carsRepository.findAllByBrand(brand);
    }

}
