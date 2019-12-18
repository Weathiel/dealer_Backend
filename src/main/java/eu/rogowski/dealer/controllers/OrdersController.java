package eu.rogowski.dealer.controllers;

import eu.rogowski.dealer.models.Orders;
import eu.rogowski.dealer.models.dto.OrdersDTO;
import eu.rogowski.dealer.models.dto.UserDTO;
import eu.rogowski.dealer.services.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrdersController {
    @Autowired
    private final OrdersService ordersService;

    @GetMapping(params = {"page", "size"})
    @PreAuthorize("hasAnyRole('ROLE_WORKER', 'ROLE_ADMIN')")
    public List<Orders> findAll(@RequestParam Integer page,
                                @RequestParam Integer size) {
        return ordersService.findAll(page, size).toList();
    }

    @GetMapping("/length")
    @PreAuthorize("hasAnyRole('ROLE_WORKER', 'ROLE_ADMIN')")
    public Integer ordersSize(){
        return ordersService.howMany();
    }

    @GetMapping(params = "offerId")
    @PreAuthorize("hasAnyRole('ROLE_WORKER', 'ROLE_ADMIN')")
    public List<Orders> findAllOffersWith(@RequestParam Long offerId){
        return ordersService.findAllOrdersByOfferId(offerId);
    }

    @GetMapping("/token")
    @PreAuthorize("hasAnyRole('ROLE_USER' ,'ROLE_WORKER', 'ROLE_ADMIN')")
    public List<Orders> findAllByToken(HttpServletRequest httpServletRequest){
        return ordersService.findAllOrdersByToken(httpServletRequest);
    }

    @PostMapping("/new")
    @PreAuthorize("hasAnyRole('ROLE_USER' ,'ROLE_WORKER', 'ROLE_ADMIN')")
    public Orders newOrder(@RequestBody OrdersDTO ordersDTO) {
        return ordersService.newOrder(ordersDTO);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_WORKER', 'ROLE_ADMIN')")
    public void updateOrder(@RequestBody OrdersDTO ordersDTO,
                              @PathVariable Long id){
        ordersService.updateOrder(ordersDTO, id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER' ,'ROLE_WORKER', 'ROLE_ADMIN')")
    public void deleteOrder(@PathVariable Long id){
        ordersService.delete(id );
    }
}
