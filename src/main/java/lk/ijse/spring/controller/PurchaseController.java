package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.PurchaseDetailDTO;
import lk.ijse.spring.dto.RequestDetailDTO;
import lk.ijse.spring.dto.ReturnDetailDTO;
import lk.ijse.spring.entity.RequestDetail;
import lk.ijse.spring.service.PurchaseService;
import lk.ijse.spring.service.RequestService;
import lk.ijse.spring.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/purchase")
@CrossOrigin
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping(path = "/placeReturnDetail")
    public ResponseEntity saveReturnDetails(@RequestBody ReturnDetailDTO returnDetailDTO) {

        StandardResponse success = new StandardResponse(200, "success",purchaseService.placeRetrunDetail(returnDetailDTO));
        return new ResponseEntity(success, HttpStatus.OK);
    }

    @PostMapping(path = "/placeBill")
    public ResponseEntity savePurchases(@RequestBody PurchaseDetailDTO purchaseDetailDTO) {
        purchaseService.placePurchase(purchaseDetailDTO);
        StandardResponse success = new StandardResponse(200, "success",null);
        return new ResponseEntity(success, HttpStatus.OK);
    }


}
