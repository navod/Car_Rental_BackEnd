package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BillQueryDTO {
    private String reqId;
    private String custEmail;
    private String custNIC;
    private String custName;
    private String carId;
    private String carModel;
    private double monthlyFee;
    private double dailyFee;
    private String carType;
    private double additionalKmFee;
    private String pickUpDate;
    private String returnDate;
    private double damageFee;
    private int carDuration;
    private int dateDiff;
    private int dailyKm;
    private int monthlyKm;
}
