package lk.ijse.spring.repo;

import lk.ijse.spring.dto.QueryDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Login;
import lk.ijse.spring.entity.RequestDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface RequestRepo extends JpaRepository<RequestDetail, String> {

    @Query(value = "SELECT reqId from requestdetail order by reqId desc limit 1",nativeQuery = true)
    String findLastRequestId();

    @Query(value = "SELECT DATEDIFF(?1, ?2)",nativeQuery = true)
    int getDateDiff(Date date1,Date date2);

    @Query(value = "SELECT count(*) from requestdetail where pickUpDate=CURDATE() ",nativeQuery = true)
    int countTodayRequests();
}
