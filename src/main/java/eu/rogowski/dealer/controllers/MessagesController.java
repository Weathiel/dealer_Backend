package eu.rogowski.dealer.controllers;

import eu.rogowski.dealer.services.MessagesService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.AddressException;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessagesController {
    @Autowired
    private final MessagesService messagesService;


    @GetMapping("/s")
    @PreAuthorize("hasAnyRole('ROLE_USER' ,'ROLE_WORKER', 'ROLE_ADMIN')")
    public String send(){
        try {
            messagesService.sendMail();
        } catch (AddressException e) {
            return "lol";
        }
        return "losssss!";
    }
}
