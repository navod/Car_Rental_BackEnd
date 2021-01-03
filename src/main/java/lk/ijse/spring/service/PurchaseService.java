package lk.ijse.spring.service;

import lk.ijse.spring.dto.*;

public interface PurchaseService {

    String placeRetrunDetail(ReturnDetailDTO returnDetailDTO);

    void placePurchase(PurchaseDetailDTO purchaseDetailDTO);
}
