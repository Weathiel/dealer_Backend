package eu.rogowski.dealer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Orders extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private Float discount;

    private Float totalPrice;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties
    private Offers offers;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties
    private User user;

    @OneToOne
    @JoinColumn
    private Contract contract;
}
