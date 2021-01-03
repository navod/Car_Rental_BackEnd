package lk.ijse.spring.repo;

import lk.ijse.spring.config.WebAppConfig;
import lk.ijse.spring.config.WebRootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.sql.Date;

import static org.junit.Assert.*;
@WebAppConfiguration
@ContextConfiguration(classes = {WebAppConfig.class, WebRootConfig.class})
@RunWith(SpringRunner.class)
public class RequestRepoTest {

    @Autowired
    RequestRepo requestRepo;

//    @Test
//    public void getDateDiff() {
//        int dateDiff = requestRepo.getDateDiff(new Date(2020 / 11 / 30), new Date(2020 / 12 / 31));
//        System.out.println(dateDiff);
//    }
}
