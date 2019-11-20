package eu.rogowski.dealer.controllers;

import eu.rogowski.dealer.models.Offers;
import eu.rogowski.dealer.services.OffersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/offers")
public class OffersController {

    private final OffersService offersService;

    @GetMapping(params = {"page", "size"})
    public List<Offers> findAll(@RequestParam String page,
                                @RequestParam String size){
        return offersService.findAll(page, size).toList();
    }

    @PostMapping("/post")
    public Offers newOffer(@RequestBody Offers offers){
        return offersService.newOffer(offers);
    }

}
