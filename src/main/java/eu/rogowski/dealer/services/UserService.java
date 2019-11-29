package eu.rogowski.dealer.services;

import eu.rogowski.dealer.exceptions.ResourceNotFoundException;
import eu.rogowski.dealer.models.User;
import eu.rogowski.dealer.models.dto.UserDTO;
import eu.rogowski.dealer.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.graalvm.compiler.lir.LIRInstruction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor_= {@Autowired})
public class UserService {
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public Page<User> getUserPage(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "userId"));
        return userRepository.findAll(pageable);
    }

    public List<User> getUserByFirstNameAndLastName(String firstName, String lastName){
        return userRepository.findAllByFirstNameAndLastName(firstName, lastName);
    }

    public User getUserByUsername(String username){
        return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User: " + username + " not found!"));
    }

    public String login(String username, String password){
        try {
            User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException());
            String token = UUID.randomUUID().toString();
            user.setAccessToken(token);
            userRepository.save(user);
            return token;
        }catch (ResourceNotFoundException e){
            return null;
        }
    }

    public User findByToken(String token){
        try {
            return userRepository.findByAccessToken(token).orElseThrow(() -> new ResourceNotFoundException());
        }catch(ResourceNotFoundException e) {
        return null;
        }
    }

    public void registerUser(UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        userRepository.save(user);
    }

    public void changePassword(Long id, String password){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id  " + id + " doesn't exist!"));
        user.setPassword(password);
        userRepository.save(user);
    }
}
