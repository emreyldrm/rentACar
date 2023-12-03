package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.rent.abstracts.AddRentRequest;
import com.tobeto.rentACar.services.dtos.rent.abstracts.DeleteRentRequest;
import com.tobeto.rentACar.services.dtos.rent.abstracts.UpdateRentRequest;
import com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentByPayMethodResponse;
import com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentByBrandResponse;
import com.tobeto.rentACar.services.dtos.rent.concretes.GetListRentByCustomerResponse;

import java.util.List;

public interface RentService {
    void add(AddRentRequest request);
    void update(UpdateRentRequest request);
    void delete(DeleteRentRequest request);
    List<GetListRentByCustomerResponse> getByCustomerName(String customerName);
    List<GetListRentByBrandResponse> getByBrandName(String brandName);
    List<GetListRentByPayMethodResponse> getByPayMethod(String payName);
}
