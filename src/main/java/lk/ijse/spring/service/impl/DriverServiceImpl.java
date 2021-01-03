package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.Login;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.repo.LoginRepo;
import lk.ijse.spring.service.DriverService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepo driverRepo;

    @Autowired
    LoginRepo loginRepo;

    @Autowired
    ModelMapper modelMapper;

    private String lastDriverId;
    private String loginLastId;

    @Override
    public void addDrivers(DriverDTO dto) {
        loadLastLoginId();
        if (!driverRepo.existsById(dto.getDriverId()) && !loginRepo.existsById(loginLastId)) {
            Driver d1 = new Driver(dto.getDriverId(), dto.getDriverName(), dto.getDriverAddress(), dto.getDriverNIC(), dto.getDriverEmail(), dto.getDriverContact(), dto.getDriverPassword(),"Available");
            Login login1 = new Login(loginLastId, "Driver", d1.getDriverEmail(), d1.getDriverPassword());

            Driver save = driverRepo.save(d1);

            if (save != null) {
                loginRepo.save(login1);
            }
        } else {
            throw new RuntimeException("Driver Already Exists");
        }
    }

    @Override
    public String loadLastDriverId() {
        String lastDriverID = driverRepo.findDriverByDriverID();
        if (lastDriverID == null) {
            return this.lastDriverId = "D001";
        } else {
            String[] split = lastDriverID.split("D");
            int num = Integer.parseInt(split[1]);
            num++;
            if (num < 10) {
                return this.lastDriverId = "D00" + num;
            } else if (num < 100) {
                return this.lastDriverId = "D0" + num;
            } else {
                return this.lastDriverId = "D" + num;
            }
        }
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        List<Driver> allCars = driverRepo.findAll();
        return modelMapper.map(allCars, new TypeToken<List<DriverDTO>>() {
        }.getType());
    }

    @Override
    public void updateDrivers(DriverDTO dto) {
        if (driverRepo.existsById(dto.getDriverId())) {
            if (driverRepo.existsById(dto.getDriverId())) {
                Driver driver = modelMapper.map(dto, Driver.class);
                driverRepo.save(driver);
            }
        }
    }

    @Override
    public void deleteDrivers(DriverDTO driverDTO) {
        if (driverRepo.existsById(driverDTO.getDriverId())) {
            String logId = loginRepo.deleteByDriverEmail(driverDTO.getDriverEmail());
            System.out.println(logId);
            if(logId != null){
            loginRepo.deleteById(logId);
            driverRepo.deleteById(driverDTO.getDriverId());
            }
        }
    }

    @Override
    public List<DriverDTO> getDriverDetail(String driverContact) {
        List<Driver> driverDetailByContact = driverRepo.findDriverDetailById(driverContact);
        return modelMapper.map(driverDetailByContact, new TypeToken<List<DriverDTO>>() {
        }.getType());
    }

    @Override
    public List<String> getAllDriverId() {
        List<String> allDriverId = driverRepo.getAllDriverId();
        if(allDriverId == null){
            return null;
        }
        return allDriverId;
    }

    @Override
    public List<DriverDTO> getDriverRequestById(String driverId) {
        List<Driver> driverRequestById = driverRepo.getDriverRequestById(driverId);
        return modelMapper.map(driverRequestById, new TypeToken<List<DriverDTO>>() {
        }.getType());

    }

    @Override
    public List<DriverDTO> getDriverDetailByEmail(String driverEmail) {
        List<Driver> byEmail = driverRepo.findByEmail(driverEmail);
        if(byEmail == null){
            return null;
        }
        List<DriverDTO> list = new ArrayList<>();
        for (Driver driver : byEmail) {
            list.add(new DriverDTO(
                    driver.getDriverId(),
                    driver.getDriverName(),
                    driver.getDriverAddress(),
                    driver.getDriverNIC(),
                    driver.getDriverEmail(),
                    driver.getDriverContact(),
                    driver.getDriverPassword(),
                    driver.getStates()
            ));
        }
        return list;
    }

    @Override
    public Long countAllDrivers() {
        long count = driverRepo.count();
        return count;
    }

    @Override
    public int countAvailable() {
       int count =  driverRepo.countAvailable();
       return count;
    }

    @Override
    public int countBookedDrivers() {
       int count = driverRepo.countBookedDrivers();
        return count;
    }

    public void loadLastLoginId() {
        String lastLoginID = loginRepo.findLoginByLogId();
        if (lastLoginID == null) {
            this.loginLastId = "L001";
        } else {
            String[] split = lastLoginID.split("L");
            int num = Integer.parseInt(split[1]);
            num++;
            if (num < 10) {
                this.loginLastId = "L00" + num;
            } else if (num < 100) {
                this.loginLastId = "L0" + num;
            } else {
                this.loginLastId = "L" + num;
            }
        }
    }
}
