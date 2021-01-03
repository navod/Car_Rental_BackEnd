package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarDTO {
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

}
