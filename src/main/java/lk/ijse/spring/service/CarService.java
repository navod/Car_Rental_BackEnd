package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Car;

import java.util.List;

public interface CarService {
    void addCars(CarDTO dto);
    String loadLastCarId();
    List<CustomerDTO> getAllCars();

    void updateCars(CarDTO dto);
    void deleteCars(CarDTO dto);

    List<String> getCarModel(String carType);

    List<Car> getCarDetail(String carModel);

    Long countAllCars();

    int countAvailableCars();

    int countBookedCars();

    List<String> getCarUpdateId(String carType);

    List<Car> getCarDetailById(String carId);
}
