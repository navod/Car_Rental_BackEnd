package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDetailDTO implements Serializable {
    private String reqId;
    private Date pickUpDate;
    private Date  returnDate;
    private String pickUpTime;
    private String pickUpLocation;
    private String reason;
    private double damageFee;
    private String  driver;
    private String car;
    private String customer;
    private String states;


}
