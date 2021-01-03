package lk.ijse.spring.repo;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.config.WebRootConfig;
import lk.ijse.spring.entity.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class, WebRootConfig.class})
@RunWith(SpringRunner.class)
public class CarRepoTest {

    @Autowired
    CarRepo repo;

    @Test
    public void getCars(){
        List<String> general = repo.getCarModels("General");
        System.out.println(general);
    }
}
