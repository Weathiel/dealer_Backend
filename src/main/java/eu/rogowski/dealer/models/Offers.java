package eu.rogowski.dealer.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
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

    public Float getMileage() {
        return mileage;
    }

    public void setMileage(Float mileage) {
        this.mileage = mileage;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProd_country() {
        return prod_country;
    }

    public void setProd_country(String prod_country) {
        this.prod_country = prod_country;
    }

    public Boolean getEnglish_car() {
        return english_car;
    }

    public void setEnglish_car(Boolean english_car) {
        this.english_car = english_car;
    }

    public Boolean getArchvized() {
        return archvized;
    }

    public void setArchvized(Boolean archvized) {
        this.archvized = archvized;
    }

    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }
}
