package lk.ijse.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(value = {"requestDetails"})
//@Projection(name = "deadline", types = { ABDeadlineType.class })
public class Car implements Serializable {
    @Id
    private String carId;
    private String carModel;
    private int dailyKm;
    private int monthlyKm;
    private double monthlyRateRs;
    private double dailyRatePerRs;
    private double additionalKmPrice;
    private String fuelType;
    private String transmissionType;
    private String color;
    private String carType;
    private int carDuration;
    private String states;
    private int passengers;

    @OneToMany(mappedBy = "car")
    private List<RequestDetail> requestDetails = new ArrayList<>();

    public List<RequestDetail> getRequestDetails() {
        return null;
    }
}
