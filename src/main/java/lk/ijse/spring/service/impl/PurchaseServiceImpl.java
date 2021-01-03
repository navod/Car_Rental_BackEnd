package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.PurchaseDetailDTO;
import lk.ijse.spring.dto.ReturnDetailDTO;
import lk.ijse.spring.entity.*;
import lk.ijse.spring.repo.*;
import lk.ijse.spring.service.PurchaseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    RequestRepo requestRepo;

    @Autowired
    PurchaseRepo purchaseRepo;

    @Autowired
    ReturnRepo returnRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper modelMapper;

    private String lastRequestId;
    private String lastPurchaseId;


    @Override
    public String placeRetrunDetail(ReturnDetailDTO returnDetailDTO) {
        getLastReturnId();

        RequestDetail requestDetail = requestRepo.getOne(returnDetailDTO.getReqId());
        ReturnDetail r1 = new ReturnDetail(
                this.lastRequestId,
                returnDetailDTO.getPickUpdate(),
                returnDetailDTO.getReturnDate(),
                returnDetailDTO.getAdditionalKm(),
                returnDetailDTO.getDamageFee(),
                requestDetail
        );
        ReturnDetail save = returnRepo.save(r1);
        System.out.println(save.getReturnId());
        if (save == null) {
            return null;
        }
        return save.getReturnId();
    }

    @Override
    public void placePurchase(PurchaseDetailDTO purchaseDetailDTO) {
        getLastBillId();
        ReturnDetail one = returnRepo.getOne(purchaseDetailDTO.getReturnId());
        PurchaseDetail purchaseDetail = new PurchaseDetail(
                this.lastPurchaseId,
                purchaseDetailDTO.getTotal(),
                purchaseDetailDTO.getBillDate(),
                purchaseDetailDTO.getCustomerExperience(),
                one
        );
        PurchaseDetail save = purchaseRepo.save(purchaseDetail);
        if (save != null) {
            RequestDetail requestDetail = one.getRequestDetail();
            Driver driver = one.getRequestDetail().getDriver();
            Car car = one.getRequestDetail().getCar();


            if (driver == null) {

            }else if (driver != null && car != null && requestDetail != null){
                driver.setStates("Available");
                car.setStates("Available");
                requestDetail.setStates("Paid");
            }

        }
    }

    private void getLastBillId() {
        String lastPurchaseId = purchaseRepo.getLastPurchaseId();
        if (lastPurchaseId == null) {
            this.lastPurchaseId = "P001";
        } else {
            String[] split = lastPurchaseId.split("P");
            int num = Integer.parseInt(split[1]);
            num++;
            if (num < 10) {
                this.lastPurchaseId = "P00" + num;
            } else if (num < 100) {
                this.lastPurchaseId = "P0" + num;
            } else {
                this.lastPurchaseId = "P" + num;
            }
        }
    }

    public void getLastReturnId() {
        String lastReturnId = returnRepo.findLastReturnId();
        if (lastReturnId == null) {
            this.lastRequestId = "RE001";
        } else {
            String[] split = lastReturnId.split("RE");
            int num = Integer.parseInt(split[1]);
            num++;
            if (num < 10) {
                this.lastRequestId = "RE00" + num;
            } else if (num < 100) {
                this.lastRequestId = "RE0" + num;
            } else {
                this.lastRequestId = "RE" + num;
            }
        }
    }
}
