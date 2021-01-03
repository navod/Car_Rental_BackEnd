package lk.ijse.spring.repo;

import lk.ijse.spring.entity.PurchaseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PurchaseRepo extends JpaRepository<PurchaseDetail, String> {


    @Query(value = "select billId from purchasedetail order by billId desc limit 1", nativeQuery = true)
    String getLastPurchaseId();
}
