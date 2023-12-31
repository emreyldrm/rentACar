package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.rent.abstracts.AddRentRequest;
import com.tobeto.rentACar.services.dtos.rent.abstracts.DeleteRentRequest;
import com.tobeto.rentACar.services.dtos.rent.abstracts.UpdateRentRequest;
import com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentResponse;

import java.util.List;

public interface RentService {
    void add(AddRentRequest request);
    void update(UpdateRentRequest request);
    void delete(DeleteRentRequest request);
    List<GetListRentResponse> getByCustomerName(String customerName);
    List<GetListRentResponse> getByBrandName(String brandName);
    List<GetListRentResponse> getByPayMethod(String payName);
}
