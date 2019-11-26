package eu.rogowski.dealer.services;

import eu.rogowski.dealer.exceptions.ResourceNotFoundException;
import eu.rogowski.dealer.models.Contract;
import eu.rogowski.dealer.models.Offers;
import eu.rogowski.dealer.models.Orders;
import eu.rogowski.dealer.models.dto.OrdersDTO;
import eu.rogowski.dealer.repositories.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrdersService {
    private final OrdersRepository ordersRepository;
    private final UserRepository userRepository;
    private final OffersRepository offersRepository;
    private final ContractRepository contractRepository;
    private final CurrencyRepository currencyRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public Page<Orders> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "orderId"));
        return ordersRepository.findAll(pageable);
    }

    public List<Orders> findAllOrdersByOfferId(Long offerId){
        return ordersRepository.findAllByOffers(offersRepository.findById(offerId).orElseThrow(() -> new ResourceNotFoundException()));
    }

    public Orders newOrder(OrdersDTO ordersDTO) {
        Orders orders = modelMapper.map(ordersDTO, Orders.class);
        Contract contract = new Contract(ordersDTO.getDeposit(), ordersDTO.getDone());

        orders.setUser(userRepository.findById(ordersDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Didn't found user with id: " + ordersDTO.getUserId())));

        orders.setOffers(offersRepository.findById(ordersDTO.getOfferId())
                .orElseThrow(() -> new ResourceNotFoundException("Didn't found offer with id: " + ordersDTO.getOfferId())));

        orders.setCurrencies(currencyRepository.findAll());

        orders.setTotalPrice(orders.getOffers().getPrice() * (100-orders.getDiscount()) / (float)100);

        orders.setContract(contractRepository.save(contract));

        return ordersRepository.save(orders);
    }

    public void updateOrder(OrdersDTO ordersDTO, Long id){
        Orders orders = ordersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Didn't found order with id: " + id));
        orders.setDiscount(ordersDTO.getDiscount());
        orders.setTotalPrice(orders.getOffers().getPrice() * (100-orders.getDiscount()) / (float)100);
        orders.getContract().setDone(ordersDTO.getDone());
        orders.getContract().setDeposit(ordersDTO.getDeposit());
        ordersRepository.save(orders);
    }


}
