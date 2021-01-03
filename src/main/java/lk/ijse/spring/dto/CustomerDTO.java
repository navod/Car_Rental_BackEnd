package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Lob;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class CustomerDTO {
    private String customerID;
    private String customerName;
    private String customerAddress;
    private String email;
    private String password;
    private String contact;
    private String nic;
//    @Lob
//    @Column(name="nicBackImage", nullable=false, columnDefinition="mediumblob")
//    private String nicBackImage;



}
