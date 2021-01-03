package lk.ijse.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@JsonIgnoreProperties(value = {"requestDetails"})
public class Driver {
    @Id
    private String driverId;
    private String driverName;
    private String driverAddress;
    @Column(unique = true)
    private String driverNIC;
    @Column(unique = true)
    private String driverEmail;
    @Column(unique = true)
    private String driverContact;
    private String driverPassword;
    private String states;
    @OneToMany(mappedBy = "driver")
    private List<RequestDetail> requestDetails = new ArrayList<>();

    public Driver(String driverId, String driverName, String driverAddress, String driverNIC, String driverEmail, String driverContact, String driverPassword, String states) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.driverAddress = driverAddress;
        this.driverNIC = driverNIC;
        this.driverEmail = driverEmail;
        this.driverContact = driverContact;
        this.driverPassword = driverPassword;
        this.states = states;
    }

    public List<RequestDetail> getRequestDetails() {
        return null;
    }
}
