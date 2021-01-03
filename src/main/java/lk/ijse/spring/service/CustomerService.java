package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void createAccount(CustomerDTO dto);
    String loadLastCustId();
    List<CustomerDTO> getAllCustomers();
    List<CustomerDTO> getCustomerDetail(String email);
    void updateCustomer(CustomerDTO dto);

    long countAllCustomers();
}
