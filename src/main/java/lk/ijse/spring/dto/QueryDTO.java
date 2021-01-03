package lk.ijse.spring.dto;

import lk.ijse.spring.entity.RequestDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryDTO {

    private String reqId;
    private String customerName;
    private String contact;
    private String carType;
    private String carModel;
    private String pickUpDate;
    private String returnDate;
    private String driverName;
    private String reason;
    private String pickUpLocation;
    private String pickUpTime;

    public QueryDTO(String reqId, String customerName, String contact, String carType, String carModel, String pickUpDate, String returnDate, String driverName, String reason) {
        this.reqId = reqId;
        this.customerName = customerName;
        this.contact = contact;
        this.carType = carType;
        this.carModel = carModel;
        this.pickUpDate = pickUpDate;
        this.returnDate = returnDate;
        this.driverName = driverName;
        this.reason = reason;
    }

//    private List<RequestDetail> requestDetails;


    public QueryDTO(String reqId, String pickUpDate, String reason) {
        this.reqId = reqId;
        this.pickUpDate = pickUpDate;
        this.reason = reason;
    }
}
