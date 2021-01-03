package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, path = "/createAccount")
    public ResponseEntity createSignIn(@RequestBody CustomerDTO customerDTO) {
        customerService.createAccount(customerDTO);
        StandardResponse success = new StandardResponse(200, "Success", null);
        return new ResponseEntity(success, HttpStatus.OK);
    }
    @GetMapping(path = "/getLastId")
    public ResponseEntity getCustomerLastId(){
        StandardResponse success = new StandardResponse(200, "success", customerService.loadLastCustId());
        return new ResponseEntity(success,HttpStatus.OK);
    }
    @GetMapping(path = "/loadAllCustomers")
    public ResponseEntity getAllCustomers(){
        StandardResponse success = new StandardResponse(200, "success", customerService.getAllCustomers());
        return new ResponseEntity(success,HttpStatus.OK);
    }
    @PostMapping(path = "/customerDetails")
    public ResponseEntity getCustomerDetail(@RequestBody CustomerDTO dto){
        StandardResponse success = new StandardResponse(200, "success", customerService.getCustomerDetail(dto.getEmail()));
        return new ResponseEntity(success,HttpStatus.OK);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto) {
        customerService.updateCustomer(dto);
        return new ResponseEntity(new StandardResponse(200, "Success", null), HttpStatus.OK);
    }

    @GetMapping(path = "/countAllCustomers")
    public ResponseEntity countAllCustomer(){
        StandardResponse success = new StandardResponse(200, "success", customerService.countAllCustomers());
        return new ResponseEntity(success,HttpStatus.OK);
    }

}
