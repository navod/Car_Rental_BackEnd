package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.dto.QueryDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.RequestDetail;
import lk.ijse.spring.repo.CarRepo;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.DriverRepo;
import lk.ijse.spring.repo.RequestRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.*;
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class, WebRootConfig.class})
@RunWith(SpringRunner.class)
public class RequestServiceImplTest {
    @Autowired
    RequestRepo requestRepo;

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    DriverRepo driverRepo;

    @Autowired
    CarRepo carRepo;

    @Test
    public void requsetAdd() {
//        Date date = new Date("2020/10/22");
//        Customer customer = customerRepo.getOne("C001");
//        Car car = carRepo.getOne("CR001");
//        Driver one = driverRepo.getOne("D002");
//        RequestDetail requestDetail = new RequestDetail(
//                "R001",
//                ,
//                "2020/10/23",
//                "9.00",
//                "Panadura",
//                "eeasda",
//                10000, one, car, customer);
//
//        requestRepo.save(requestDetail);
    }

    @Test
    public void getAllRequests() {
        int i = requestRepo.countTodayRequests();
        System.out.println(i);
    }
}
