package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.BillQueryDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.dto.QueryDTO;
import lk.ijse.spring.dto.RequestDetailDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.RequestDetail;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.repo.RequestRepo;
import lk.ijse.spring.service.RequestService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestRepo requestRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    CarRepo carRepo;

    @Autowired
    ModelMapper modelMapper;

    private String lastRequestId;

    @Override
    public void requsetAdd(RequestDetailDTO requestDetailDTO) {
        Customer customer = customerRepo.getOne(requestDetailDTO.getCustomer());
        Car car = carRepo.getOne(requestDetailDTO.getCar());
        Driver one = driverRepo.getOne(requestDetailDTO.getDriver());
        RequestDetail requestDetail = new RequestDetail(
                lastRequestId,
                requestDetailDTO.getPickUpDate(),
                requestDetailDTO.getReturnDate(),
                requestDetailDTO.getPickUpTime(),
                requestDetailDTO.getPickUpLocation(),
                requestDetailDTO.getReason(),
                requestDetailDTO.getDamageFee(), one, car, customer,
                "Pending");

        RequestDetail save = requestRepo.save(requestDetail);
        if (save != null) {
            one.setStates("Booked");
            car.setStates("Booked");
        }
    }

    @Override
    public String getLastReqId() {

        String lastRequestId = requestRepo.findLastRequestId();
        if (lastRequestId == null) {
            return this.lastRequestId = "R001";
        } else {
            String[] split = lastRequestId.split("R");
            int num = Integer.parseInt(split[1]);
            num++;
            if (num < 10) {
                return this.lastRequestId = "R00" + num;
            } else if (num < 100) {
                return this.lastRequestId = "R0" + num;
            } else {
                return this.lastRequestId = "R" + num;
            }
        }
    }

    @Override
    public List<QueryDTO> getAllRequests() {

        List<RequestDetail> all = requestRepo.findAll();
        if (all == null) {
            return null;
        }
        List<QueryDTO> list = new ArrayList<>();
        for (RequestDetail requestDetail : all) {
            if (requestDetail.getStates().equals("Pending")) {
                list.add(new QueryDTO(
                        requestDetail.getReqId(),
                        requestDetail.getCustomer().getCustomerName(),
                        requestDetail.getCustomer().getContact(),
                        requestDetail.getCar().getCarType(),
                        requestDetail.getCar().getCarModel(),
                        requestDetail.getPickUpDate().toString(),
                        requestDetail.getReturnDate().toString(),
                        requestDetail.getDriver().getDriverName(),
                        requestDetail.getReason()
                ));
                return list;
            }
        }
        return null;
    }

    @Override
    public void bookRequest(RequestDetail dto) {
        if (requestRepo.existsById(dto.getReqId())) {
            RequestDetail one = requestRepo.getOne(dto.getReqId());
            one.setStates("Booked");
        }
    }

    @Override
    public List<QueryDTO> getCustomerBookDetail(RequestDetailDTO dto) {
        List<RequestDetail> all = requestRepo.findAll();
        if (all == null) {
            return null;
        }
        List<QueryDTO> list = new ArrayList<>();
        for (RequestDetail requestDetail : all) {
            if (requestDetail.getCustomer().getCustomerID().equals(dto.getCustomer())) {
                list.add(new QueryDTO(
                        requestDetail.getReqId(),
                        requestDetail.getPickUpDate().toString(),
                        requestDetail.getStates()
                ));
                return list;
            }
        }
        return null;
    }

    @Override
    public List<QueryDTO> getDriverAllRequests(RequestDetailDTO driver) {
        List<RequestDetail> all = requestRepo.findAll();
        if (all == null) {
            return null;
        }
        List<QueryDTO> list = new ArrayList<>();
        for (RequestDetail requestDetail : all) {
            if (requestDetail.getDriver().getDriverId().equals(driver.getDriver())) {
                list.add(new QueryDTO(
                        requestDetail.getReqId(),
                        requestDetail.getCustomer().getCustomerName(),
                        requestDetail.getCustomer().getContact(),
                        requestDetail.getCar().getCarType(),
                        requestDetail.getCar().getCarModel(),
                        requestDetail.getPickUpDate().toString(),
                        requestDetail.getReturnDate().toString(),
                        requestDetail.getPickUpLocation(),
                        requestDetail.getPickUpTime()
                ));
                return list;
            }
        }
        return null;
    }

    @Override
    public List<BillQueryDTO> getCustomerByContact(CustomerDTO dto) {

        String customerId = customerRepo.findByCustomerContact(dto.getContact());
        List<BillQueryDTO> list = new ArrayList<>();
        if (customerId != null) {
            List<RequestDetail> all = requestRepo.findAll();
            if (all == null) {
                return null;
            }
            for (RequestDetail requestDetail : all) {
                int dateDiff = requestRepo.getDateDiff(requestDetail.getReturnDate(),requestDetail.getPickUpDate());
                if (requestDetail.getCustomer().getCustomerID().equals(customerId)) {
                    list.add(new BillQueryDTO(
                            requestDetail.getReqId(),
                            requestDetail.getCustomer().getEmail(),
                            requestDetail.getCustomer().getNic(),
                            requestDetail.getCustomer().getCustomerName(),
                            requestDetail.getCar().getCarId(),
                            requestDetail.getCar().getCarModel(),
                            requestDetail.getCar().getMonthlyRateRs(),
                            requestDetail.getCar().getDailyRatePerRs(),
                            requestDetail.getCar().getCarType(),
                            requestDetail.getCar().getAdditionalKmPrice(),
                            requestDetail.getPickUpDate().toString(),
                            requestDetail.getReturnDate().toString(),
                            requestDetail.getDamageFee(),
                            requestDetail.getCar().getCarDuration(),
                            dateDiff,
                            requestDetail.getCar().getDailyKm(),
                            requestDetail.getCar().getMonthlyKm()

                    ));
                    return list;
                }
            }
        }
        return null;
    }

    @Override
    public int getTodayRequests() {
        int count = requestRepo.countTodayRequests();
        return count;
    }
}
