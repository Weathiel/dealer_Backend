package eu.rogowski.dealer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"username", "password", "email"}))
@Getter @Setter @NoArgsConstructor
public class User extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull
    private String username;

    @NotNull
    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String city;

    private String address;

    private Integer phoneNumber;

    private String accessToken;

    @ManyToOne
    @JoinColumn
    private Role role;

    public User(User user) {
        this.userId = user.getUserId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.city = user.getCity();
        this.address = user.getAddress();
        this.phoneNumber = user.getPhoneNumber();
        this.accessToken = user.getAccessToken();
        this.role = user.getRole();
    }
}
