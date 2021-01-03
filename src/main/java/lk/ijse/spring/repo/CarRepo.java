package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepo extends JpaRepository<Car,String> {

    @Query(value = "select carId from car order by carId desc limit 1",nativeQuery = true)
    String findCarByCarID();

    @Query(value = "SELECT DISTINCT(carModel) from car where carType=?1 and states='Available'",nativeQuery = true)
    List<String> getCarModels(String carType);

    @Query(value = "SELECT * from car where carModel=?1 and states='Available'",nativeQuery = true)
    List<Car> getCarDetail(String carType);

    @Query(value = "SELECT count(*) from car where states='Available'",nativeQuery = true)
    int countAvailableCars();

    @Query(value = "SELECT count(*) from car where  states='Booked'",nativeQuery = true)
    int countAllBookedCars();

    @Query(value = "SELECT DISTINCT(carId) from car where carType=?1",nativeQuery = true)
    List<String> getAllCarId(String carType);

    @Query(value = "SELECT * from car where carId=?1",nativeQuery = true)
    List<Car> findAllCarById(String carId);
}
