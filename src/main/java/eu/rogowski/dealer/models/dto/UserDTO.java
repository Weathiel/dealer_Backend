package eu.rogowski.dealer.models.dto;

import eu.rogowski.dealer.models.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UserDTO {
    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String city;

    private String address;

    private Integer phoneNumber;

    private Long roleId;
}
