package eu.rogowski.dealer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Getter @Setter @NoArgsConstructor
public class User extends Auditable<String>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long userId;

    @UniqueElements
    @NotNull
    private String username;

    @UniqueElements
    @NotNull
    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String city;

    private String address;

    private Integer phoneNumber;

    @ManyToOne
    @JoinColumn
    private Role role;

}
