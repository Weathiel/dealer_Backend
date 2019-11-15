package eu.rogowski.dealer.controllers;

import eu.rogowski.dealer.repositories.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarsController {

    @Autowired
    CarsRepository carsRepository;
}
