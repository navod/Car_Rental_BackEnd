package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Persister;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class PurchaseDetail {
    @Id
    private String billId;
    private double total;
    @CreationTimestamp
    private Date billDate;
    private String customerExperience;

    @ManyToOne
    @JoinColumn(name = "returnId", referencedColumnName = "returnId")
    private ReturnDetail returnDetail;

}
