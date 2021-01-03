package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.service.CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper modelMapper;

    private String lastCarId;

    @Override
    public void addCars(CarDTO dto) {
        loadLastCarId();
        if (!carRepo.existsById(dto.getCarId())) {
            Car map = modelMapper.map(dto, Car.class);
            carRepo.save(map);
        } else {
            throw new RuntimeException("Car Already Exists");
        }
    }

    @Override
    public String loadLastCarId() {
        String lastCarID = carRepo.findCarByCarID();
        if (lastCarID == null) {
            return this.lastCarId = "CR001";
        } else {
            String[] split = lastCarID.split("CR");
            int num = Integer.parseInt(split[1]);
            num++;
            if (num < 10) {
                return this.lastCarId = "CR00" + num;
            } else if (num < 100) {
                return this.lastCarId = "CR0" + num;
            } else {
                return this.lastCarId = "CR" + num;
            }
        }
    }

    @Override
    public List<CustomerDTO> getAllCars() {
        List<Car> allCars = carRepo.findAll();
        return modelMapper.map(allCars, new TypeToken<List<CarDTO>>() {
        }.getType());
    }

    @Override
    public void updateCars(CarDTO dto) {
        if (carRepo.existsById(dto.getCarId())) {
            if (carRepo.existsById(dto.getCarId())) {
                Car car = modelMapper.map(dto, Car.class);
                carRepo.save(car);
            }
        }
    }

    @Override
    public void deleteCars(CarDTO carDTO) {
        if (carRepo.existsById(carDTO.getCarId())) {

            carRepo.deleteById(carDTO.getCarId());
        }
    }

    @Override
    public List<String> getCarModel(String carType) {
        List<String> carModels = carRepo.getCarModels(carType);
        if(carModels == null){
            return null;
        }
        return carModels;
    }

    @Override
    public List<Car> getCarDetail(String carModel) {
        List<Car> carDetail = carRepo.getCarDetail(carModel);
        return carDetail;
    }

    @Override
    public Long countAllCars() {
        long count = carRepo.count();
        return count;
    }

    @Override
    public int countAvailableCars() {
        int count = carRepo.countAvailableCars();
        return count;
    }

    @Override
    public int countBookedCars() {
        int count = carRepo.countAllBookedCars();
        return count;
    }

    @Override
    public List<String> getCarUpdateId(String carType) {
        List<String> allCars = carRepo.getAllCarId(carType);
        return allCars;
    }

    @Override
    public List<Car> getCarDetailById(String carId) {
        List<Car> allCarById = carRepo.findAllCarById(carId);
        return allCarById;

    }
}
