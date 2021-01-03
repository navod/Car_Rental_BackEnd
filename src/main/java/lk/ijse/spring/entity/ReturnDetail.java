package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReturnDetail {
    @Id
    private String returnId;
    private Date pickUpdate;
    private Date returnDate;
    private double additionalKm;
    private double damageFee;
    @ManyToOne
    @JoinColumn(name = "reqId", referencedColumnName = "reqId")
    private RequestDetail requestDetail;
    @OneToMany(mappedBy = "returnDetail")
    private List<PurchaseDetail> purchaseDetails = new ArrayList<>();

    public ReturnDetail(String returnId, Date pickUpdate, Date returnDate, double additionalKm, double damageFee, RequestDetail requestDetail) {
        this.returnId = returnId;
        this.pickUpdate = pickUpdate;
        this.returnDate = returnDate;
        this.additionalKm = additionalKm;
        this.damageFee = damageFee;
        this.requestDetail = requestDetail;
    }
}
