package eu.rogowski.dealer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"username", "password", "email"}))
@Getter @Setter @NoArgsConstructor
public class User extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
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

}
