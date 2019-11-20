package eu.rogowski.dealer.controllers;

import eu.rogowski.dealer.models.Cars;
import eu.rogowski.dealer.repositories.CarsRepository;
import eu.rogowski.dealer.services.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/cars")
public class CarsController {

    private final CarsService carsService;

    @GetMapping(params = {"page", "size"})
    public List<Cars> getPageOfCars(@RequestParam String page,
                                    @RequestParam String size){
        return carsService.getCarsPage(page, size).toList();
    }

    @GetMapping(params = "brand")
    public List<Cars> getCarsByBrand(@RequestParam String brand){
        return carsService.findAllByBrand(brand);
    }

    @GetMapping(value = "/models", params = "brand")
    public List<Cars> getCarsModelByBrand(@RequestParam String brand){return carsService.findModelByBrand(brand);}

}
