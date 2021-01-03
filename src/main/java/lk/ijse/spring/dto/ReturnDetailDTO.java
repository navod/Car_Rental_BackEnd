package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReturnDetailDTO {
    private String returnId;
    private Date pickUpdate;
    private Date returnDate;
    private double additionalKm;
    private double damageFee;
    private String reqId;
}
