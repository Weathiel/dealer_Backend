package eu.rogowski.dealer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @NoArgsConstructor
public class Offers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    private Float mileage;

    @NotNull
    private Float price;

    private String color;

    private String prod_country;

    private Boolean english_car;

    @NotNull
    private Boolean archvized;

    private Date production_date;

    @NotNull
    private Date created_time;

    @ManyToOne
    @JoinColumn
    private Cars cars;

}
