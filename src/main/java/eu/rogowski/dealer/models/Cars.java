package eu.rogowski.dealer.models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @NotNull
    private String brand;

    @NotNull
    private String model;

    private String body_type;

    private String gas_type;

    private Date s_production_year;

    private Date e_production_year;

    private Integer engine_power;

    public Long getCarId() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBody_type() {
        return body_type;
    }

    public void setBody_type(String body_type) {
        this.body_type = body_type;
    }

    public String getGas_type() {
        return gas_type;
    }

    public void setGas_type(String gas_type) {
        this.gas_type = gas_type;
    }

    public Date getS_production_year() {
        return s_production_year;
    }

    public void setS_production_year(Date s_production_year) {
        this.s_production_year = s_production_year;
    }

    public Date getE_production_year() {
        return e_production_year;
    }

    public void setE_production_year(Date e_production_year) {
        this.e_production_year = e_production_year;
    }

    public Integer getEngine_power() {
        return engine_power;
    }

    public void setEngine_power(Integer engine_power) {
        this.engine_power = engine_power;
    }
}
