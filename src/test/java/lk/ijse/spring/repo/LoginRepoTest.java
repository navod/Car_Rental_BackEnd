package lk.ijse.spring.repo;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class, WebRootConfig.class})
@RunWith(SpringRunner.class)
public class LoginRepoTest {


    @Autowired
    LoginRepo repo;

    @Test
    public void getCustomers(){
        String loginRole = repo.findLoginRole("navod@gmail.com", "1234");
        System.out.println(loginRole);
    }

    @Test
    public void testId(){
        String s = repo.deleteByDriverEmail("n@gmail.com");
        System.out.println(s);
    }

}
