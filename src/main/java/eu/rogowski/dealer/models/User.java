package eu.rogowski.dealer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Getter @Setter @NoArgsConstructor
public class User extends AuditModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long userId;

    private String username;

    private String password;

    private String first_name;

    private String last_name;

    private String email;

    private String city;

    private String address;

    private Integer phone_number;

    @ManyToOne
    @JoinColumn
    private Role role;

}
