package lk.ijse.spring.repo;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.entity.Driver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class, WebRootConfig.class})
@RunWith(SpringRunner.class)
public class DriverRepoTest {

    @Autowired
    DriverRepo repo;

    @Test
    public void getDetails(){
        List<Driver> driverDetailById = repo.findDriverDetailById("0785463");
        System.out.println(driverDetailById);
    }

    @Test
    public void checkEmail(){
        Optional<Driver> log = repo.findById("D002");
        System.out.println(log);
    }
}
