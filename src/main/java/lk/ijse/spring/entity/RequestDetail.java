package lk.ijse.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(value = {"requestDetails"})
public class RequestDetail implements Serializable{
    @Id
    private String reqId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pickUpDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnDate;
    private String pickUpTime;
    private String pickUpLocation;
    private String reason;
    private double damageFee;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverId",referencedColumnName = "driverId")
    private Driver driver;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carId", referencedColumnName = "carId",nullable = false)
    private Car car;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerID", referencedColumnName = "customerID", nullable = false)
    private Customer customer;

    private String states;
    @OneToMany(mappedBy = "requestDetail")
    private List<ReturnDetail> returnDetailList = new ArrayList<>();

    public RequestDetail(String reqId, Date pickUpDate, Date returnDate, String pickUpTime, String pickUpLocation, String reason, double damageFee, Driver driver, Car car, Customer customer, String states) {
        this.reqId = reqId;
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.pickUpTime = pickUpTime;
        this.pickUpLocation = pickUpLocation;
        this.reason = reason;
        this.damageFee = damageFee;
        this.driver = driver;
        this.car = car;
        this.customer = customer;
        this.states = states;
    }

    public List<ReturnDetail> getReturnDetailList() {
        return null;
    }
}
