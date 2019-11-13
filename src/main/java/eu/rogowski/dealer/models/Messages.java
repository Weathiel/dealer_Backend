package eu.rogowski.dealer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class Messages extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messagesId;

    private String message;

    private String sender;

    @ManyToOne
    @JoinColumn
    private User user;
}
