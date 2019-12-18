package eu.rogowski.dealer.controllers;

import eu.rogowski.dealer.models.Offers;
import eu.rogowski.dealer.models.dto.OffersDTO;
import eu.rogowski.dealer.services.CarsService;
import eu.rogowski.dealer.services.OffersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/offers")
public class OffersController {

    @Autowired
    private final OffersService offersService;


    @GetMapping(params = {"page", "size"})
    public List<Offers> findAll(@RequestParam Integer page,
                                @RequestParam Integer size) {
        return offersService.findAll(page, size).toList();
    }

    @GetMapping("/lenght")
    public Long lenght(){
        return offersService.lenght();
    }

    @PostMapping("/new")
    @PreAuthorize("hasAnyRole('ROLE_WORKER', 'ROLE_ADMIN')")
    public Offers newOffer(@RequestBody OffersDTO offersDTO) {
        return offersService.newOffer(offersDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_WORKER', 'ROLE_ADMIN')")
    public void carSold(@PathVariable Long id,
            @RequestBody OffersDTO offersDTO) {
        offersService.update(offersDTO, id);
    }

}
