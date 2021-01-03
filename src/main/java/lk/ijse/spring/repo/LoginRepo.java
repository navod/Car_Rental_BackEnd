package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepo extends JpaRepository<Login, String> {

    @Query(value = "select logId from login order by logId desc limit 1",nativeQuery = true)
    String findLoginByLogId();

    @Query(value = "SELECT role from login where email=?1 and password=?2",nativeQuery = true)
    String findLoginRole(String email,String password);

    @Query(value = "select logId from login where email=?1",nativeQuery = true)
    String deleteByDriverEmail(String email);


}
