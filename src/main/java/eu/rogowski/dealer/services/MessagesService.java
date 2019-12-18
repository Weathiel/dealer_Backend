package eu.rogowski.dealer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessagesService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail() throws AddressException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("no-reply@dealer.pl");
        simpleMailMessage.setTo("nostale.naruto@gmail.com");
        simpleMailMessage.setSubject("no-reply");
        simpleMailMessage.setText("TEST TEST TEST TEST");

        javaMailSender.send(simpleMailMessage);
    }
}
