package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.RequestDetailDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.RequestDetail;
import lk.ijse.spring.service.RequestService;
import lk.ijse.spring.utill.StandardResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/reqOrder")
@CrossOrigin
public class RequestController {

    @Autowired
    RequestService requestService;

    @PostMapping(path = "/sendOrders")
    public ResponseEntity saveRequirement(@RequestBody RequestDetailDTO requestDetailDTO) {
        requestService.requsetAdd(requestDetailDTO);
        StandardResponse success = new StandardResponse(200, "success","null");
        return new ResponseEntity(success, HttpStatus.OK);
    }
    @GetMapping(path = "/getLastId")
    public ResponseEntity getLastRequestId(){
        StandardResponse success = new StandardResponse(200, "success", requestService.getLastReqId());
        return new ResponseEntity(success,HttpStatus.OK);
    }


    @GetMapping(path = "/getAllRequests")
    public ResponseEntity getAllRequests(){
        StandardResponse success = new StandardResponse(200, "success", requestService.getAllRequests());
        return new ResponseEntity(success,HttpStatus.OK);
    }

    @PostMapping("/bookOrders")
    public ResponseEntity updateRequestStates(@RequestBody RequestDetail dto) {
        requestService.bookRequest(dto);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @PostMapping("/getCustomerBookCondition")
    public ResponseEntity getCustomerBookCondition(@RequestBody RequestDetailDTO dto) {

        return new ResponseEntity(new StandardResponse(200, "Success", requestService.getCustomerBookDetail(dto)), HttpStatus.OK);
    }

    @PostMapping("/getDriverAllRequests")
    public ResponseEntity getDriverAllRequests(@RequestBody RequestDetailDTO dto) {

        return new ResponseEntity(new StandardResponse(200, "Success", requestService.getDriverAllRequests(dto)), HttpStatus.OK);
    }
    @PostMapping(path = "/getCustomerContact")
    public ResponseEntity getCustomerByContact(@RequestBody CustomerDTO dto){
        StandardResponse success = new StandardResponse(200, "success", requestService.getCustomerByContact(dto));
        return new ResponseEntity(success,HttpStatus.OK);
    }

    @GetMapping(path = "/getTodayRequests")
    public ResponseEntity getTodayRequests(){
        StandardResponse success = new StandardResponse(200, "success", requestService.getTodayRequests());
        return new ResponseEntity(success,HttpStatus.OK);
    }
}
