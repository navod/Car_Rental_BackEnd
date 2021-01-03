package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DriverRepo extends JpaRepository<Driver,String> {

    @Query(value = "select driverId from driver order by driverId desc limit 1",nativeQuery = true)
    String findDriverByDriverID();

    @Query(value = "SELECT * from driver where driverContact=?1",nativeQuery = true)
    List<Driver> findDriverDetailById(String driverContact);

    @Query(value = "SELECT driverId from driver WHERE states ='Available'",nativeQuery = true)
    List<String> getAllDriverId();

    @Query(value = "SELECT * from driver WHERE driverId=?1 AND states ='Available'",nativeQuery = true)
    List<Driver> getDriverRequestById(String driverId);

    @Query(value = "SELECT * FROM driver WHERE driverEmail=?1",nativeQuery = true)
    List<Driver> findByEmail(String driverEmail);

    @Query(value = "select count(*) from driver where states = 'Available'",nativeQuery = true)
    int countAvailable();

    @Query(value = "select count(*) from  driver where states = 'Booked'",nativeQuery = true)
    int countBookedDrivers();
}
