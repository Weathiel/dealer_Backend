package eu.rogowski.dealer.controllers;

import eu.rogowski.dealer.models.Cars;
import eu.rogowski.dealer.services.CarsService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/all")
    public List<Cars> getAll(){
        return carsService.getAll();
    }

    @GetMapping("/lenght")
    public ResponseEntity<Integer> getCarsLenght(){
        return ResponseEntity.ok(this.carsService.getAll().size());
    }

}
