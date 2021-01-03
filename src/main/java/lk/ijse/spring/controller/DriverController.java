package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/driver")
@CrossOrigin
public class DriverController {

    @Autowired
    DriverService driverService;


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, path = "/addDrivers")
    public ResponseEntity addDrivers(@RequestBody DriverDTO driverDTO) {
        driverService.addDrivers(driverDTO);
        StandardResponse success = new StandardResponse(200, "Success", null);
        return new ResponseEntity(success, HttpStatus.OK);
    }

    @GetMapping(path = "/getLastId")
    public ResponseEntity getDriverLastId() {
        StandardResponse success = new StandardResponse(200, "success", driverService.loadLastDriverId());
        return new ResponseEntity(success, HttpStatus.OK);
    }

    @GetMapping(path = "/loadAllDrivers")
    public ResponseEntity getAllDrivers() {
        StandardResponse success = new StandardResponse(200, "success", driverService.getAllDrivers());
        return new ResponseEntity(success, HttpStatus.OK);
    }
    @GetMapping(path = "/loadAllDriverId")
    public ResponseEntity getAllDriverId() {
        StandardResponse success = new StandardResponse(200, "success", driverService.getAllDriverId());
        return new ResponseEntity(success, HttpStatus.OK);
    }
    @PostMapping(path = "/driverDetail")
    public ResponseEntity getDriverDetail(@RequestBody DriverDTO dto){
        StandardResponse success = new StandardResponse(200, "success", driverService.getDriverDetail(dto.getDriverContact()));
        return new ResponseEntity(success,HttpStatus.OK);
    }
    @PostMapping(path = "/getDriverRequest")
    public ResponseEntity getDriverRequestById(@RequestBody DriverDTO dto){
        StandardResponse success = new StandardResponse(200, "success", driverService.getDriverRequestById(dto.getDriverId()));
        return new ResponseEntity(success,HttpStatus.OK);
    }

    @PutMapping("/updateDriver")
    public ResponseEntity updateCustomer(@RequestBody DriverDTO dto) {
        driverService.updateDrivers(dto);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }
    @DeleteMapping("/deleteDrivers")
    public ResponseEntity deleteDriver(@RequestBody DriverDTO driverDTO){
        driverService.deleteDrivers(driverDTO);
        return new ResponseEntity(new StandardResponse(200,"Success",null),HttpStatus.OK);
    }

    @PostMapping(path = "/getDriverDetailByEmail")
    public ResponseEntity getDriverDetailByEmail(@RequestBody DriverDTO dto){
        StandardResponse success = new StandardResponse(200, "success", driverService.getDriverDetailByEmail(dto.getDriverEmail()));
        return new ResponseEntity(success,HttpStatus.OK);
    }
//    @PutMapping("/updateDrivers")
//    public ResponseEntity updateCars(@RequestBody DriverDTO dto) {
//        driverService.updateDrivers(dto);
//        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
//    }

    @GetMapping(path = "/countAllDrivers")
    public ResponseEntity countAllDrivers() {
        StandardResponse success = new StandardResponse(200, "success", driverService.countAllDrivers());
        return new ResponseEntity(success, HttpStatus.OK);
    }

    @GetMapping(path = "/countAvailable")
    public ResponseEntity countAvailable() {
        StandardResponse success = new StandardResponse(200, "success", driverService.countAvailable());
        return new ResponseEntity(success, HttpStatus.OK);
    }

    @GetMapping(path = "/countBookedDrivers")
    public ResponseEntity countBookedDrivers() {
        StandardResponse success = new StandardResponse(200, "success", driverService.countBookedDrivers());
        return new ResponseEntity(success, HttpStatus.OK);
    }
}
