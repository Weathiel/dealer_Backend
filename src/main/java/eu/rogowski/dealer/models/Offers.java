package eu.rogowski.dealer.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter @Setter @NoArgsConstructor
public class Offers extends Auditable<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offerId;

    private Float mileage;

    @NotNull
    private Float price;

    private String color;

    private String prod_country;

    private Boolean englishCar;

    private String image;

    @NotNull
    private Boolean archivized;

    private Date production_date;

    @ManyToOne
    @JoinColumn
    private Cars cars;

}
