package eu.rogowski.dealer.controllers;

import eu.rogowski.dealer.models.Cars;
import eu.rogowski.dealer.services.CarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/cars")
public class CarsController {

    private final CarsService carsService;

    @GetMapping(params = {"page", "size"})
    public List<Cars> getPageOfCars(@RequestParam Integer page,
                                    @RequestParam Integer size) {
        return carsService.getCarsPage(page, size).toList();
    }

    @GetMapping(params = "brand")
    public List<Cars> getCarsByBrand(@RequestParam String brand) {
        return carsService.findAllByBrand(brand);
    }

    @GetMapping(value = "/models", params = "brand")
    public List<Cars> getCarsModelByBrand(@RequestParam String brand) {
        return carsService.findAllByBrand(brand);
    }

}
