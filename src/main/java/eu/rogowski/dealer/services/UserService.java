package eu.rogowski.dealer.services;

import eu.rogowski.dealer.exceptions.ResourceNotFoundException;
import eu.rogowski.dealer.models.User;
import eu.rogowski.dealer.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_= {@Autowired})
public class UserService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public Page<User> getUserPage(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "orderId"));
        return userRepository.findAll(pageable);
    }

    public List<User> getUserByFirstNameAndLastName(String firstName, String lastName){
        return userRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void changePassword(Long id, String password){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id  " + id + " doesn't exist!"));
        user.setPassword(password);
        userRepository.save(user);
    }
}
