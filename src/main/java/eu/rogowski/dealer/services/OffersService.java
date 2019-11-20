package eu.rogowski.dealer.services;

import eu.rogowski.dealer.models.Offers;
import eu.rogowski.dealer.repositories.OffersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;


import java.util.List;

@Service
@RequiredArgsConstructor
public class OffersService {
    private final OffersRepository offersRepository;

    public Page<Offers> findAll(String page, String pageSize){
        Pageable pageable = PageRequest.of(Integer.valueOf(page), Integer.valueOf(pageSize), Sort.by(Sort.Direction.ASC, "offerId"));
        return offersRepository.findAll(pageable);
    }

    public Offers newOffer(Offers offers){
        return offersRepository.save(offers);
    }

}
