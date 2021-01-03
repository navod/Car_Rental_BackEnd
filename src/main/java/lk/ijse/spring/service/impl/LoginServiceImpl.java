package lk.ijse.spring.service.impl;

import lk.ijse.spring.repo.LoginRepo;
import lk.ijse.spring.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepo repo;

    @Override
    public String checkLoginRole(String email, String password) {
        String loginRole = repo.findLoginRole(email, password);
        return loginRole;
    }
}
