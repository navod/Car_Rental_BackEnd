package lk.ijse.spring.repo;

import lk.ijse.spring.entity.ReturnDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReturnRepo extends JpaRepository<ReturnDetail, String> {


    @Query(value = "select returnId from returndetail order by returnId desc limit 1", nativeQuery = true)
    String findLastReturnId();
}
