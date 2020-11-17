package eu.rogowski.dealer.controllers;

import eu.rogowski.dealer.models.Currency;
import eu.rogowski.dealer.repositories.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CurrencyController {

    @Autowired
    CurrencyRepository repository;

    @GetMapping("/currency")
    public List<Currency> getAll(){
        return repository.findAll();
    }
}
