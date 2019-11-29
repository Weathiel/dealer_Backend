package eu.rogowski.dealer.controllers;

import eu.rogowski.dealer.models.User;
import eu.rogowski.dealer.models.dto.UserDTO;
import eu.rogowski.dealer.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController{
    private final UserService userService;

    @GetMapping(params = {"page", "size"})
    public List<User> getUserPage(@RequestParam Integer page,
                                  @RequestParam Integer size){
        return userService.getUserPage(page, size).toList();
    }

    @GetMapping(params = {"firstName", "lastName"})
    public List<User> getUsersByNames(@RequestParam String firstName,
                                      @RequestParam String lastName){
        return userService.getUserByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping(params = "username")
    public User getUsersByUsername(@RequestParam String username){
        return userService.getUserByUsername(username);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO){
        return userService.login(userDTO.getUsername(), userDTO.getPassword());
    }

    @PostMapping(value = "/register")
    public void registerUser(@RequestBody UserDTO userDTO){
        userService.registerUser(userDTO);
    }

    @PostMapping("/token")
    public User getUserByToken(@RequestBody String token){
        return userService.findByToken(token);
    }

    @PutMapping(value = "/change", params = {"id", "password"})
    public void changePassword(@RequestParam Long id,
                               @RequestParam String password){
        userService.changePassword(id , password);
    }

}
