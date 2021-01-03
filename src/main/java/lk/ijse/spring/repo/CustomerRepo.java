package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,String> {

    @Query(value = "select customerID from customer order by customerID desc limit 1",nativeQuery = true)
    String findCustomerByCustomerID();

    @Query(value = "SELECT * FROM customer WHERE email=?1",nativeQuery = true)
    List<Customer> getCustomerByEmail(String email);

    @Query(value = "SELECT customerID FROM customer WHERE contact=?1",nativeQuery = true)
    String findByCustomerContact(String contact);
}

