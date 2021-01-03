package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PurchaseDetailDTO {
    private String billId;
    private double total;
    private Date billDate;
    private String customerExperience;
    private String returnId;

}
