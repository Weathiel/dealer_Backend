package eu.rogowski.dealer.models.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter @Setter @NoArgsConstructor
public class OffersDTO {

    private Long offerId;

    private Float mileage;

    private Float price;

    private String color;

    private String prod_country;

    private Boolean english_car;

    private Boolean archivized;

    private Date production_date;

    private Long carId;

    public void setPrice(Float price) {
        this.price = price*(float)1.10;
    }
}
