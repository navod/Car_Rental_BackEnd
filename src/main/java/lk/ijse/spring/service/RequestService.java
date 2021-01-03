package lk.ijse.spring.service;

import lk.ijse.spring.dto.*;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.RequestDetail;

import java.util.List;

public interface RequestService {


    void requsetAdd(RequestDetailDTO requestDetailDTO);

    String getLastReqId();

    List<QueryDTO> getAllRequests();

    void bookRequest(RequestDetail dto);

    List<QueryDTO> getCustomerBookDetail(RequestDetailDTO dto);

    List<QueryDTO> getDriverAllRequests(RequestDetailDTO dto);

    List<BillQueryDTO>getCustomerByContact(CustomerDTO dto);

    int getTodayRequests();
}
