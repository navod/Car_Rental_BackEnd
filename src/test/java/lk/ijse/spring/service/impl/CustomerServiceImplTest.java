package lk.ijse.spring.service.impl;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class, WebRootConfig.class})
@RunWith(SpringRunner.class)
public class CustomerServiceImplTest {

    @Autowired
    CustomerService service;

    @Autowired
    CustomerRepo repo;

    @Test
    public void createAccount() {
//        CustomerDTO dto = new CustomerDTO("navod","panadura","n@gmail.com","1234","0763933541","200011200960");
//        service.createAccount(dto);
    }

    @Test
    public void loadLastCustId() {
        String customerByCustomerID = repo.findCustomerByCustomerID();
        System.out.println(customerByCustomerID);

    }
    @Test
    public void getCustomer(){
        List<Customer> customerByEmail = repo.getCustomerByEmail("navod@gmail.com");
        System.out.println(customerByEmail);
    }
}
