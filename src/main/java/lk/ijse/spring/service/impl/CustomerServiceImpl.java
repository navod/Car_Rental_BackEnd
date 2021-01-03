package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Login;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.LoginRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    LoginRepo loginRepo;

    private String custLastId;
    private String loginLastId;

    @Override
    public void createAccount(CustomerDTO dto) {
        loadLastLoginId();
        if (!customerRepo.existsById(dto.getCustomerID()) && !loginRepo.existsById(loginLastId)) {
            Customer c1 = new Customer(dto.getCustomerID(), dto.getCustomerName(), dto.getCustomerAddress(), dto.getEmail(), dto.getPassword(), dto.getContact(), dto.getNic());
            Login login1 = new Login(loginLastId, "Customer", c1.getEmail(), c1.getPassword());

            Customer save = customerRepo.save(c1);

            if (save != null) {
                loginRepo.save(login1);
            }
        } else {
            throw new RuntimeException("Customer Already Exists");
        }
    }

    @Override
    public String loadLastCustId() {
        String lastCustomerID = customerRepo.findCustomerByCustomerID();
        if (lastCustomerID == null) {
            return this.custLastId = "C001";
        } else {
            String[] split = lastCustomerID.split("C");
            int num = Integer.parseInt(split[1]);
            num++;
            if (num < 10) {
                return this.custLastId = "C00" + num;
            } else if (num < 100) {
                return this.custLastId = "C0" + num;
            } else {
                return this.custLastId = "C" + num;
            }
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> allCustomers = customerRepo.findAll();
        return modelMapper.map(allCustomers, new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public List<CustomerDTO> getCustomerDetail(String email) {
        List<Customer> customerDetails = customerRepo.getCustomerByEmail(email);
        System.out.println(customerDetails);
        List<CustomerDTO> details = new ArrayList<>();
        for (Customer customerDetail : customerDetails) {
            details.add(new CustomerDTO(
                    customerDetail.getCustomerID(),
                    customerDetail.getCustomerName(),
                    customerDetail.getCustomerAddress(),
                    customerDetail.getEmail(),
                    customerDetail.getPassword(),
                    customerDetail.getContact(),
                    customerDetail.getNic()
            ));
        }
        return details;
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getCustomerID())) {
            if (customerRepo.existsById(dto.getCustomerID())) {
                Customer cus = modelMapper.map(dto, Customer.class);
                customerRepo.save(cus);
            }
        }
    }

    @Override
    public long countAllCustomers() {

        long count = customerRepo.count();
        return count;
    }

    public void loadLastLoginId() {
        String lastLoginID = loginRepo.findLoginByLogId();
        if (lastLoginID == null) {
            this.loginLastId = "L001";
        } else {
            String[] split = lastLoginID.split("L");
            int num = Integer.parseInt(split[1]);
            num++;
            if (num < 10) {
                this.loginLastId = "L00" + num;
            } else if (num < 100) {
                this.loginLastId = "L0" + num;
            } else {
                this.loginLastId = "L" + num;
            }
        }
    }
}
