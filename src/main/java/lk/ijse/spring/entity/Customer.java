package lk.ijse.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.InitBinder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(value = {"requestDetails"})
public class Customer implements Serializable, Converter<Customer,String> {
    @Id
    private String customerID;
    private String customerName;
    private String customerAddress;
    @Column(unique = true)
    private String email;
    private String password;
    private String contact;
    private String nic;
    @OneToMany(mappedBy = "customer")
    private List<RequestDetail> requestDetails= new ArrayList<>();

    public Customer(String customerID, String customerName, String customerAddress, String email, String password, String contact, String nic) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.email = email;
        this.password = password;
        this.contact = contact;
        this.nic = nic;
    }

    public List<RequestDetail> getRequestDetails() {
        return null;
    }

    public void setRequestDetails(List<RequestDetail> requestDetails) {
        this.requestDetails = requestDetails;
    }

    @Override
    public String convert(Customer customer) {
        try {
            return new ObjectMapper().writeValueAsString(customer);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
