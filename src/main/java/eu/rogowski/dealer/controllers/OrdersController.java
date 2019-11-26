package eu.rogowski.dealer.controllers;

import eu.rogowski.dealer.models.Orders;
import eu.rogowski.dealer.models.dto.OrdersDTO;
import eu.rogowski.dealer.services.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrdersController {
    @Autowired
    private final OrdersService ordersService;

    @GetMapping(params = {"page", "size"})
    public List<Orders> findAll(@RequestParam Integer page,
                                @RequestParam Integer size) {
        return ordersService.findAll(page, size).toList();
    }

    @GetMapping(params = "offerId")
    public List<Orders> findAllOffersWith(@RequestParam Long offerId){
        return ordersService.findAllOrdersByOfferId(offerId);
    }

    @PostMapping("/new")
    public Orders newOrder(@RequestBody OrdersDTO ordersDTO) {
        return ordersService.newOrder(ordersDTO);
    }

    @PutMapping("/update")
    public void updateOrder(@RequestBody OrdersDTO ordersDTO,
                              @RequestParam Long id){
        ordersService.updateOrder(ordersDTO, id);
    }
}
