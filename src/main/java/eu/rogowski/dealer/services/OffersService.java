package eu.rogowski.dealer.services;

import eu.rogowski.dealer.exceptions.ResourceNotFoundException;
import eu.rogowski.dealer.models.Offers;
import eu.rogowski.dealer.models.dto.OffersDTO;
import eu.rogowski.dealer.repositories.CarsRepository;
import eu.rogowski.dealer.repositories.OffersRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OffersService {
    private final OffersRepository offersRepository;
    private final CarsRepository carsRepository;
    @Autowired
    private final ModelMapper modelMapper;

    public Page<Offers> findAll(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "offerId"));
        return offersRepository.findAll(pageable);
    }


    public Offers newOffer(OffersDTO offersDTO) {
        Offers offers = modelMapper.map(offersDTO, Offers.class);
        offers.setCars(carsRepository.findById(offersDTO.getCarId()).orElseThrow(() -> new ResourceNotFoundException("Didn't found car with id: " + offersDTO.getCarId()))
        );
        return offersRepository.save(offers);
    }

    public void arichivizeOffer(Long id) {
        offersRepository.findById(id).map(offers -> {
            offers.setArchivized(true);
            return offersRepository.save(offers);
        }).orElseThrow(() -> new ResourceNotFoundException("Didn't found offer with id: " + id));
    }
}
