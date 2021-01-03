package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    void addDrivers(DriverDTO dto);

    String loadLastDriverId();

    List<DriverDTO> getAllDrivers();

    //    List<CustomerDTO> getCustomerDetail(String email);
    void updateDrivers(DriverDTO dto);

    void deleteDrivers(DriverDTO dto);

    List<DriverDTO> getDriverDetail(String driverContact);

    List<String> getAllDriverId();

    List<DriverDTO> getDriverRequestById(String driverId);

    List<DriverDTO> getDriverDetailByEmail(String driverEmail);

    Long countAllDrivers();

    int countAvailable();

    int countBookedDrivers();
}
