package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/car")
@CrossOrigin
public class CarController {

    @Autowired
    CarService carService;


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, path = "/addCars")
    public ResponseEntity addCars(@RequestBody CarDTO carDTO) {
        carService.addCars(carDTO);
        StandardResponse success = new StandardResponse(200, "Success", null);
        return new ResponseEntity(success, HttpStatus.OK);
    }

    @GetMapping(path = "/getLastCarId")
    public ResponseEntity getCarLastId() {
        StandardResponse success = new StandardResponse(200, "success", carService.loadLastCarId());
        return new ResponseEntity(success, HttpStatus.OK);
    }

    @GetMapping(path = "/loadAllCars")
    public ResponseEntity getAllCars() {
        StandardResponse success = new StandardResponse(200, "success", carService.getAllCars());
        return new ResponseEntity(success, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCars")
    public ResponseEntity deleteCar(@RequestBody CarDTO carDTO){
        carService.deleteCars(carDTO);
        return new ResponseEntity(new StandardResponse(200,"Success",null),HttpStatus.OK);
    }


    @PutMapping("/updateCars")
    public ResponseEntity updateCars(@RequestBody CarDTO dto) {
        carService.updateCars(dto);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @PostMapping("/getCarModel")
    public ResponseEntity getCarModels(@RequestBody CarDTO dto){
        StandardResponse success = new StandardResponse(200, "success", carService.getCarModel(dto.getCarType()));
        return new ResponseEntity(success,HttpStatus.OK);
    }

    @PostMapping("/getCarUpdateId")
    public ResponseEntity getCarUpdateId(@RequestBody CarDTO dto){
        StandardResponse success = new StandardResponse(200, "success", carService.getCarUpdateId(dto.getCarType()));
        return new ResponseEntity(success,HttpStatus.OK);
    }

    @PostMapping("/getCarDetail")
    public ResponseEntity getCarDetails(@RequestBody CarDTO dto){
        StandardResponse success = new StandardResponse(200, "success", carService.getCarDetail(dto.getCarModel()));
        return new ResponseEntity(success,HttpStatus.OK);
    }


    @PostMapping("/getCarDetailsById")
    public ResponseEntity getCarDetailsById(@RequestBody CarDTO dto){
        StandardResponse success = new StandardResponse(200, "success", carService.getCarDetailById(dto.getCarId()));
        return new ResponseEntity(success,HttpStatus.OK);
    }

    @GetMapping(path = "/countAllCars")
    public ResponseEntity countAllCars() {
        StandardResponse success = new StandardResponse(200, "success", carService.countAllCars());
        return new ResponseEntity(success, HttpStatus.OK);
    }

    @GetMapping(path = "/countAvailableCars")
    public ResponseEntity countAvailableCars() {
        StandardResponse success = new StandardResponse(200, "success", carService.countAvailableCars());
        return new ResponseEntity(success, HttpStatus.OK);
    }

    @GetMapping(path = "/countBookedCars")
    public ResponseEntity countBookedCars() {
        StandardResponse success = new StandardResponse(200, "success", carService.countBookedCars());
        return new ResponseEntity(success, HttpStatus.OK);
    }
}
