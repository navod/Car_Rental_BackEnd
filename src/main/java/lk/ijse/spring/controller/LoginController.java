package lk.ijse.spring.controller;

import lk.ijse.spring.dto.LoginDTO;
import lk.ijse.spring.service.LoginService;
import lk.ijse.spring.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer/login")
@CrossOrigin
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping
    public ResponseEntity checkLoginRole(@RequestBody LoginDTO dto) {
        StandardResponse success = new StandardResponse(200, "success", loginService.checkLoginRole(dto.getEmail(), dto.getPassword()));
        return new ResponseEntity(success, HttpStatus.OK);
    }
}
